package com.glorystone.prod.base;

import com.github.pagehelper.Page;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * Created by wangwei on 2017/8/22.
 */
public @Data class BaseResponse<T> implements Serializable {

    private static final long serialVersionUID = 1L;


    private int code;
    private String message;

    private Paging paging;

    private T data;

    public BaseResponse(T t) {
        if (t instanceof Page) {
            this.paging = new Paging(t);
        }

        data = t;
    }

    public @Data class Paging implements Serializable {
        private long total; // 总条数
        private List<T> list;   // 结果集
        private int pageNum; // 第几页
        private int pageSize; // 每页条数
        private int pageCount;  //总页数
        private int currentSize; // 当前页数量 <= pageSize

        public Paging(T t) {
                Page<T> page = (Page<T>) t;
                this.pageNum = page.getPageNum();
                this.pageSize = page.getPageSize();
                this.total = page.getTotal();
                this.pageCount = page.getPages();
                this.list = page.getResult();
                this.currentSize = page.size();


        }


    }
}
