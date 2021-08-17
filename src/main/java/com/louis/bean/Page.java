package com.louis.bean;

import java.util.List;

/**
 * @赖小燚
 * @www.louis_lai.com
 */
public class Page<T> {
    public static final Integer PAGE_SIZE = 4;

    private Integer pageNo; //当前页码
    private Integer pageTotalCount; //总记录数
    private Integer pageTotal;  //总页码数
    private Integer pageSize = PAGE_SIZE;   //每页的数量
    private List<T> items;   //当前页包含的书

    public Page() {
    }

    public Page(Integer pageNo, Integer pageTotalCount, Integer pageTotal, Integer pageSize, List<T> items) {
        this.pageNo = pageNo;
        this.pageTotalCount = pageTotalCount;
        this.pageTotal = pageTotal;
        this.pageSize = pageSize;
        this.items = items;
    }

    public static int getPageSize() {
        return PAGE_SIZE;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public List<T> getItems() {
        return items;
    }

    public void setItems(List<T> items) {
        this.items = items;
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public Integer getPageTotalCount() {
        return pageTotalCount;
    }

    public void setPageTotalCount(Integer pageTotalCount) {
        this.pageTotalCount = pageTotalCount;
    }

    public Integer getPageTotal() {
        return pageTotal;
    }

    public void setPageTotal(Integer pageTotal) {
        this.pageTotal = pageTotal;
    }

    @Override
    public String toString() {
        return "Page{" +
                "pageNo=" + pageNo +
                ", pageTotalCount=" + pageTotalCount +
                ", pageTotal=" + pageTotal +
                ", pageSize=" + pageSize +
                ", items=" + items +
                '}';
    }
}
