package com.rarekickz.rk_admin_service.service;

import com.rarekickz.rk_admin_service.domain.Sneaker;
import com.rarekickz.rk_admin_service.dto.IdListDTO;
import com.rarekickz.rk_admin_service.dto.SneakerDTO;

import java.util.List;

public interface SneakerService {

    Sneaker addSneaker(SneakerDTO sneakerDTO);

    Sneaker updateSneaker(SneakerDTO sneakerDTO);

    List<Sneaker> findAllSneakers();

    void deleteSneaker(Long sneakerId);

    void premiumSneaker(Long sneakerId);
}
