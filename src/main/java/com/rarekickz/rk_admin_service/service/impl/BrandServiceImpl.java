package com.rarekickz.rk_admin_service.service.impl;

import com.rarekickz.rk_admin_service.domain.Brand;
import com.rarekickz.rk_admin_service.repository.BrandRepository;
import com.rarekickz.rk_admin_service.service.BrandService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BrandServiceImpl implements BrandService {

    private final BrandRepository brandRepository;

    @Override
    public List<Brand> findAllBrands() {
        return brandRepository.findAll();
    }

    @Override
    public Brand findById(final Long brandId) {
        return brandRepository.findById(brandId)
                .orElseThrow(EntityNotFoundException::new);
    }
}
