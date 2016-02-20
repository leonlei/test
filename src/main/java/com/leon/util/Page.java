package com.leon.util;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;

/**
 * Created by Administrator.
 * User: Leon
 * 2016/2/1
 */
public class Page<T> {
    // ��ҳ���� ÿҳ����
    public final static int EXPORT_COUNT = 100;

    /**
     * ÿҳ���� Ĭ��20
     */
    @JsonIgnore
    private Integer count = 15;

    /**
     * ��ǰҳ��
     */
    private Integer pageno;

    /**
     * ��ҳ��
     */
    private Integer pagetotal;

    /**
     * �ܼ�¼��
     */
    private Integer recordTotal;

    /**
     * �����
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
