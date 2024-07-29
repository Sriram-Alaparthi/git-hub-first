package com.example.DPS.Instiute.utility;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.util.List;

public class Utility {
    private static final String DESC = "desc";
    private static final String ASC= "asc";
    public static PageRequest pageRequest(int pageNo, int pageSize, String sortBy, String orderType) {
        PageRequest page = null;
        if (DESC.equalsIgnoreCase(orderType)) {
            page = PageRequest.of(pageNo, pageSize, Sort.by(sortBy).descending());
        } else {
            page = PageRequest.of(pageNo, pageSize, Sort.by(sortBy).ascending());
        }
        return page;
    }

    public static PaginatedResponse paginatedResponse(int number, int totalPages, int size, int numberOfElements, long totalElements, Page<?> paginatedContent, List<?> data) {

        PaginatedResponse pageResponse = new PaginatedResponse();
        pageResponse.setData(data);
        pageResponse.setPageNo(paginatedContent.getNumber());
        pageResponse.setTotalPages(paginatedContent.getTotalPages());
        pageResponse.setPageSize(paginatedContent.getSize());
        pageResponse.setNumberOfElements(paginatedContent.getNumberOfElements());
        pageResponse.setTotalElements(paginatedContent.getTotalElements());
        return pageResponse;
    }
}
