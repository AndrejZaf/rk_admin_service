package com.rarekickz.rk_admin_service.web;

import com.rarekickz.rk_admin_service.domain.Brand;
import com.rarekickz.rk_admin_service.dto.BrandDTO;
import com.rarekickz.rk_admin_service.service.BrandService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.rarekickz.rk_admin_service.converter.BrandConverter.convertToBrandDTOList;

@RequestMapping("/api/admin/brand")
@RestController
@RequiredArgsConstructor
public class BrandController {

    private final BrandService brandService;

    @GetMapping
    public ResponseEntity<List<BrandDTO>> getBrands() {
        List<Brand> brands = brandService.findAllBrands();
        return new ResponseEntity<>(convertToBrandDTOList(brands), HttpStatus.OK);
    }
}
