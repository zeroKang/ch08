package org.zerock.ch08.dto;

import lombok.Data;

@Data
public class PageDTO {

    private int page;
    private int size;

    public PageDTO(int page, int size) {
        this.page = page + 1;
        this.size = size;
    }
}
