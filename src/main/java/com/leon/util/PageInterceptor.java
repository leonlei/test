package com.leon.util;

import org.apache.ibatis.executor.parameter.ParameterHandler;
import org.apache.ibatis.executor.statement.RoutingStatementHandler;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.ParameterMapping;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.scripting.defaults.DefaultParameterHandler;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

/**
 * Created by Administrator.
 * User: Leon
 * 2016/2/1
 */
@Intercepts({ @Signature(method = "prepare", type = StatementHandler.class, args = { Connection.class }) })
public class PageInterceptor implements Interceptor {
    public Object intercept(Invocation invocation) throws Throwable
    {
        RoutingStatementHandler handler = (RoutingStatementHandler) invocation.getTarget();
        StatementHandler delegate = (StatementHandler) ReflectUtil.getFieldValue(handler, "delegate");
        BoundSql boundSql = delegate.getBoundSql();
        Object obj = boundSql.getParameterObject();
        if (obj instanceof Page<?>)
        {
            Page<?> page = (Page<?>) obj;
            MappedStatement mappedStatement = (MappedStatement) ReflectUtil.getFieldValue(delegate, "mappedStatement");
            Connection connection = (Connection) invocation.getArgs()[0];
            String sql = boundSql.getSql();
            settotalCount(page, mappedStatement, connection);
            String pageSql = this.getPageSql(page, sql);
            ReflectUtil.setFieldValue(boundSql, "sql", pageSql);
        }
        return invocation.proceed();
    }

    /**
     * ��������Ӧ�ķ�װԭʼ����ķ���
     */
    public Object plugin(Object target)
    {
        return Plugin.wrap(target, this);
    }

    /**
     * ����page�����ȡ��Ӧ�ķ�ҳ��ѯSql��䣬����ֻ�����������ݿ����ͣ�Mysql��Oracle ���������ݿⶼ û�н��з�ҳ
     *
     * @param page
     *            ��ҳ����
     * @param sql
     *            ԭsql���
     * @return
     */
    private String getPageSql(Page<?> page, String sql)
    {
        StringBuffer sqlBuffer = new StringBuffer(sql);
        return getMysqlPageSql(page, sqlBuffer);
    }

    /**
     * ��ȡMysql���ݿ�ķ�ҳ��ѯ���
     *
     * @param page
     *            ��ҳ����
     * @param sqlBuffer
     *            ����ԭsql����StringBuffer����
     * @return Mysql���ݿ��ҳ���
     */
    private String getMysqlPageSql(Page<?> page, StringBuffer sqlBuffer)
    {
        int offset = (page.getPageno() - 1) * page.getCount();
        sqlBuffer.append(" limit ").append(offset).append(",").append(page.getCount());
        return sqlBuffer.toString();
    }

    /**
     * ����ǰ�Ĳ�������page�����ܼ�¼��
     *
     * @param page
     *            Mapperӳ������Ӧ�Ĳ�������
     * @param mappedStatement
     *            Mapperӳ�����
     * @param connection
     *            ��ǰ�����ݿ�����
     */
    private void settotalCount(Page<?> page, MappedStatement mappedStatement, Connection connection)
    {
        BoundSql boundSql = mappedStatement.getBoundSql(page);
        String sql = boundSql.getSql();
        String countSql = this.getCountSql(sql);
        List<ParameterMapping> parameterMappings = boundSql.getParameterMappings();
        BoundSql countBoundSql = new BoundSql(mappedStatement.getConfiguration(), countSql, parameterMappings, page);
        ParameterHandler parameterHandler = new DefaultParameterHandler(mappedStatement, page, countBoundSql);
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try
        {
            pstmt = connection.prepareStatement(countSql);
            parameterHandler.setParameters(pstmt);
            rs = pstmt.executeQuery();
            if (rs.next())
            {
                int totalCount = rs.getInt(1);
                page.setRecordTotal(totalCount);
                page.setPagetotal((totalCount - 1) / page.getCount() + 1);
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        finally
        {
            try
            {
                if (rs != null)
                    rs.close();
                if (pstmt != null)
                    pstmt.close();
            }
            catch (SQLException e)
            {
                e.printStackTrace();
            }
        }
    }

    /**
     * ����ԭSql����ȡ��Ӧ�Ĳ�ѯ�ܼ�¼����Sql���
     *
     * @param sql
     * @return
     */
    private String getCountSql(String sql)
    {
        return "select count(*) from (" + sql + ") c ";
    }

    public void setProperties(Properties properties) {

    }
}
