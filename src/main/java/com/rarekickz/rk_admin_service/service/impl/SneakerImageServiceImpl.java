package com.rarekickz.rk_admin_service.service.impl;

import com.rarekickz.rk_admin_service.domain.Sneaker;
import com.rarekickz.rk_admin_service.domain.SneakerImage;
import com.rarekickz.rk_admin_service.repository.SneakerImageRepository;
import com.rarekickz.rk_admin_service.service.SneakerImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class SneakerImageServiceImpl implements SneakerImageService {

    private final SneakerImageRepository sneakerImageRepository;

    @Override
    public Set<SneakerImage> addSneakerImages(final Collection<String> imageData, final Sneaker sneaker) {
        final List<SneakerImage> sneakerImages = imageData.stream()
                .map(sneakerImage -> new SneakerImage(sneakerImage, sneaker))
                .toList();
        return new HashSet<>(sneakerImageRepository.saveAll(sneakerImages));
    }

    @Override
    public void deleteSneakerImages(final Collection<SneakerImage> sneakerImages) {
        sneakerImageRepository.deleteAll(sneakerImages);
        sneakerImageRepository.flush();
    }
}
