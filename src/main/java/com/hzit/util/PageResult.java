package com.hzit.util;

import java.util.List;

/**
 * E:泛型 任意类型
 * @param <E>
 */
public class PageResult<E> {

    private int count; //总大小
    private int pageCount; //总页数
    private int page; //当前页
    private int size; //当前页 大小

    private List<E> dataList;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public List<E> getDataList() {
        return dataList;
    }

    public void setDataList(List<E> dataList) {
        this.dataList = dataList;
    }

    @Override
    public String toString() {
        return "PageResult{" +
                "count=" + count +
                ", pageCount=" + pageCount +
                ", page=" + page +
                ", size=" + size +
                ", dataList=" + dataList +
                '}';
    }
}
