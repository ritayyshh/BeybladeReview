package com.beybladereview.api.utils;

import com.beybladereview.api.dto.PageResponse;
import org.springframework.data.domain.Page;
import java.util.function.Function;
import java.util.stream.Collectors;

public class PaginationUtils {

    public static <T, R> PageResponse<R> toPageResponse(Page<T> page, Function<T, R> mapper) {
        PageResponse<R> response = new PageResponse<>();

        response.setContent(page.getContent().stream()
                .map(mapper)
                .collect(Collectors.toList()));
        response.setPageNo(page.getNumber());
        response.setPageSize(page.getSize());
        response.setTotalElements(page.getTotalElements());
        response.setTotalPages(page.getTotalPages());
        response.setLast(page.isLast());

        return response;
    }
}