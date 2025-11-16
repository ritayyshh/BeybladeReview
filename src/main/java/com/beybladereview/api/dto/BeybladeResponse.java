package com.beybladereview.api.dto;

import lombok.Data;
import java.util.List;

@Data
public class BeybladeResponse {
    private List<BeybladeDto> content;
    private int pageNo;
    private int pageSize;
    private long totalElements;
    private int totalPages;
    private boolean last;
}
