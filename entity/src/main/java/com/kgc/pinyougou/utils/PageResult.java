package com.kgc.pinyougou.utils;

import java.io.Serializable;
import java.util.List;

/**
 * @Auther: 谭海亮
 * @Date: 2020/4/25 21:53
 * @Description:
 */
public class PageResult implements Serializable {

    private Long total;
    private List rows;

    public PageResult() {
    }

    public PageResult(Long total, List rows) {
        this.total = total;
        this.rows = rows;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public List getRows() {
        return rows;
    }

    public void setRows(List rows) {
        this.rows = rows;
    }
}
