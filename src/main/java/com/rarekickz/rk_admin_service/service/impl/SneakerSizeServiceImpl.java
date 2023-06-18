package com.rarekickz.rk_admin_service.service.impl;

import com.rarekickz.rk_admin_service.domain.Sneaker;
import com.rarekickz.rk_admin_service.domain.SneakerSize;
import com.rarekickz.rk_admin_service.dto.SneakerSizeDTO;
import com.rarekickz.rk_admin_service.repository.SneakerSizeRepository;
import com.rarekickz.rk_admin_service.service.SneakerSizeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class SneakerSizeServiceImpl implements SneakerSizeService {

    private final SneakerSizeRepository sneakerSizeRepository;

    @Override
    public Set<SneakerSize> addSneakerSizes(final Sneaker sneaker, final Collection<SneakerSizeDTO> sneakerSizes) {
        final List<SneakerSize> sneakerSizeCollection = sneakerSizes.stream()
                .map(sneakerSize -> new SneakerSize(sneaker, sneakerSize.getSize(), sneakerSize.getQuantity()))
                .toList();
        return new HashSet<>(sneakerSizeRepository.saveAll(sneakerSizeCollection));
    }

    @Override
    public void deleteSneakerSizes(final Collection<SneakerSize> sneakerSizes) {
        sneakerSizeRepository.deleteAll(sneakerSizes);
        sneakerSizeRepository.flush();
    }
}
