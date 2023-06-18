package com.rarekickz.rk_admin_service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
public class SneakerDTO {

    private Long id;

    private Long brandId;

    private Integer gender;

    private String name;

    private String description;

    private Double price;

    private List<String> images;

    private List<SneakerSizeDTO> sizes;

    private String brand;
}
