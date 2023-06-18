package com.rarekickz.rk_admin_service.repository;

import com.rarekickz.rk_admin_service.domain.SneakerSize;
import com.rarekickz.rk_admin_service.domain.SneakerSizeId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SneakerSizeRepository extends JpaRepository<SneakerSize, SneakerSizeId> {
}
