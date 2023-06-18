package com.rarekickz.rk_admin_service.service.impl;

import com.rarekickz.rk_admin_service.domain.Brand;
import com.rarekickz.rk_admin_service.domain.Sneaker;
import com.rarekickz.rk_admin_service.domain.SneakerImage;
import com.rarekickz.rk_admin_service.domain.SneakerSize;
import com.rarekickz.rk_admin_service.dto.SneakerDTO;
import com.rarekickz.rk_admin_service.enums.Gender;
import com.rarekickz.rk_admin_service.repository.SneakerRepository;
import com.rarekickz.rk_admin_service.service.BrandService;
import com.rarekickz.rk_admin_service.service.SneakerImageService;
import com.rarekickz.rk_admin_service.service.SneakerService;
import com.rarekickz.rk_admin_service.service.SneakerSizeService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class SneakerServiceImpl implements SneakerService {

    private final SneakerRepository sneakerRepository;

    private final BrandService brandService;

    private final SneakerImageService sneakerImageService;

    private final SneakerSizeService sneakerSizeService;

    @Override
    @Transactional
    public Sneaker addSneaker(final SneakerDTO sneakerDTO) {
        final Brand brand = brandService.findById(sneakerDTO.getBrandId());
        final Sneaker sneaker = sneakerRepository.save(createSneaker(sneakerDTO, brand));
        final Set<SneakerImage> sneakerImages = sneakerImageService.addSneakerImages(sneakerDTO.getImages(), sneaker);
        final Set<SneakerSize> sneakerSizes = sneakerSizeService.addSneakerSizes(sneaker, sneakerDTO.getSizes());
        sneaker.setSneakerImages(sneakerImages);
        sneaker.setSneakerSizes(sneakerSizes);
        return sneaker;
    }

    @Override
    @Transactional
    public Sneaker updateSneaker(final SneakerDTO sneakerDTO) {
        final Brand brand = brandService.findById(sneakerDTO.getBrandId());
        Sneaker sneaker = sneakerRepository
                .findById(sneakerDTO.getId()).orElseThrow(EntityNotFoundException::new);
        sneakerImageService.deleteSneakerImages(sneaker.getSneakerImages());
        sneakerSizeService.deleteSneakerSizes(sneaker.getSneakerSizes());
        final Set<SneakerImage> sneakerImages = sneakerImageService.addSneakerImages(sneakerDTO.getImages(), sneaker);
        final Set<SneakerSize> sneakerSizes = sneakerSizeService.addSneakerSizes(sneaker, sneakerDTO.getSizes());
        updateSneakerProperties(sneakerDTO, brand, sneaker, sneakerImages, sneakerSizes);
        sneaker = sneakerRepository.save(sneaker);
        return sneaker;
    }

    @Override
    @Transactional
    public List<Sneaker> findAllSneakers() {
        return sneakerRepository.findAllSneakersWithImages();
    }

    @Override
    @Transactional
    public void deleteSneaker(final Long sneakerId) {
        final Sneaker sneaker = sneakerRepository.findById(sneakerId).orElseThrow(EntityNotFoundException::new);
        sneakerSizeService.deleteSneakerSizes(sneaker.getSneakerSizes());
        sneakerImageService.deleteSneakerImages(sneaker.getSneakerImages());
        sneakerRepository.delete(sneaker);
    }

    @Override
    public void premiumSneaker(final Long sneakerId) {
        final Sneaker newSpecialSneaker = sneakerRepository.findById(sneakerId).orElseThrow(EntityNotFoundException::new);
        if(newSpecialSneaker.isSpecial()) {
            return;
        }

        newSpecialSneaker.setSpecial(true);
        final Optional<Sneaker> previousSpecialSneaker = sneakerRepository.findBySpecialTrue();
        if (previousSpecialSneaker.isPresent()) {
            final Sneaker sneaker = previousSpecialSneaker.get();
            sneaker.setSpecial(false);
            sneakerRepository.saveAll(List.of(newSpecialSneaker, sneaker));
            return;
        }

        sneakerRepository.save(newSpecialSneaker);
    }

    private Sneaker createSneaker(final SneakerDTO sneakerDTO, final Brand brand) {
        return Sneaker.builder()
                .brand(brand)
                .name(sneakerDTO.getName())
                .description(sneakerDTO.getDescription())
                .price(sneakerDTO.getPrice())
                .gender(Gender.values()[sneakerDTO.getGender()])
                .sneakerImages(new HashSet<>())
                .special(false)
                .build();
    }

    private void updateSneakerProperties(final SneakerDTO sneakerDTO, final Brand brand, final Sneaker sneaker, final Set<SneakerImage> sneakerImages, final Set<SneakerSize> sneakerSizes) {
        sneaker.setBrand(brand);
        sneaker.setGender(Gender.values()[sneakerDTO.getGender()]);
        sneaker.setName(sneakerDTO.getName());
        sneaker.setDescription(sneakerDTO.getDescription());
        sneaker.setPrice(sneakerDTO.getPrice());
        sneaker.setSneakerImages(sneakerImages);
        sneaker.setSneakerSizes(sneakerSizes);
    }
}
