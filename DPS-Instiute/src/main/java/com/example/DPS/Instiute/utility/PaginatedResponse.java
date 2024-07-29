package com.example.DPS.Instiute.utility;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaginatedResponse<T> {
    private long pageNo;
    private long pageSize;
    private long numberOfElements;
    private long totalPages;
    private long totalElements;
    private List<T> data;
}
