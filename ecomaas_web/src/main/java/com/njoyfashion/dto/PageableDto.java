package com.njoyfashion.dto;

import lombok.Data;

import java.util.List;

@Data
public class PageableDto<T> {
    private long totalItems;
    private List<T> data;
    private int totalPages;
    private int currentPage;
}