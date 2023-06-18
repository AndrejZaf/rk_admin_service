package com.rarekickz.rk_admin_service.repository;

import com.rarekickz.rk_admin_service.domain.SneakerImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SneakerImageRepository extends JpaRepository<SneakerImage, Long> {
}
