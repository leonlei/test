package com.leon.util;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;

/**
 * Created by Administrator.
 * User: Leon
 * 2016/2/1
 */
public class Page<T> {
    // 分页导出 每页数量
    public final static int EXPORT_COUNT = 100;

    /**
     * 每页数量 默认20
     */
    @JsonIgnore
    private Integer count = 15;

    /**
     * 当前页码
     */
    private Integer pageno;

    /**
     * 总页数
     */
    private Integer pagetotal;

    /**
     * 总记录数
     */
    private Integer recordTotal;

    /**
     * 结果集
     */
    private List<T> list;

    public Integer getPageno()
    {
        return pageno < 1 ? 1 : pageno;
    }

    public void setPageno(Integer pageno)
    {
        this.pageno = pageno < 1 ? 1 : pageno;
    }

    public Integer getPagetotal()
    {
        return pagetotal;
    }

    public void setPagetotal(Integer pagetotal)
    {
        this.pagetotal = pagetotal;
    }

    public List<T> getList()
    {
        return list;
    }

    public void setList(List<T> list)
    {
        this.list = list;
    }

    public Integer getRecordTotal()
    {
        return recordTotal;
    }

    public void setRecordTotal(Integer recordTotal)
    {
        this.recordTotal = recordTotal;
    }

    public Integer getCount()
    {
        return count;
    }

    public void setCount(Integer count)
    {
        this.count = count;
    }
}
