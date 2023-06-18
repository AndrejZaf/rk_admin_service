package com.rarekickz.rk_admin_service.service;

import com.rarekickz.rk_admin_service.domain.Sneaker;
import com.rarekickz.rk_admin_service.domain.SneakerImage;

import java.util.Collection;
import java.util.Set;

public interface SneakerImageService {

    Set<SneakerImage> addSneakerImages(Collection<String> imageData, Sneaker sneaker);

    void deleteSneakerImages(Collection<SneakerImage> sneakerImages);
}
