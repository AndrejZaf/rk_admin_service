package com.rarekickz.rk_admin_service.service;

import com.rarekickz.rk_admin_service.domain.Sneaker;
import com.rarekickz.rk_admin_service.domain.SneakerSize;
import com.rarekickz.rk_admin_service.dto.SneakerSizeDTO;

import java.util.Collection;
import java.util.Set;

public interface SneakerSizeService {
    Set<SneakerSize> addSneakerSizes(Sneaker sneaker, Collection<SneakerSizeDTO> sneakerSizes);

    void deleteSneakerSizes(Collection<SneakerSize> sneakerSizes);
}
