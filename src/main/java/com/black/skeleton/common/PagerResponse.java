package com.black.skeleton.common;

import lombok.Data;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

@Data
public class PagerResponse<T> {

    public PagerResponse(Page<T> pageData, Pageable pageRequest) {
        this.data = pageData.getContent();
        this.total = pageData.getTotalElements();
        this.page = pageRequest.getPageNumber();
        this.size = pageRequest.getPageSize();
    }

    private List<T> data;

    private int page;

    private int size;

    private long total;
}