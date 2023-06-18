package com.rarekickz.rk_admin_service.service;

import com.rarekickz.rk_admin_service.domain.Brand;

import java.util.List;
import java.util.Optional;

public interface BrandService {

    List<Brand> findAllBrands();

    Brand findById(Long brandId);
}
