package com.rarekickz.rk_admin_service.converter;

import com.rarekickz.rk_admin_service.domain.Brand;
import com.rarekickz.rk_admin_service.dto.BrandDTO;
import lombok.experimental.UtilityClass;

import java.util.Collection;
import java.util.List;

@UtilityClass
public class BrandConverter {

    public static BrandDTO convertToBrandDTO(Brand brand) {
        return new BrandDTO(brand.getId(), brand.getName());
    }

    public static List<BrandDTO> convertToBrandDTOList(Collection<Brand> brands) {
        return brands.stream()
                .map(BrandConverter::convertToBrandDTO)
                .toList();
    }
}
