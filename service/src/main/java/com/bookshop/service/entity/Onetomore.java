package com.bookshop.service.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Onetomore {
    private Integer bookId;
    private Integer userId;
    private String proTitle;
}
