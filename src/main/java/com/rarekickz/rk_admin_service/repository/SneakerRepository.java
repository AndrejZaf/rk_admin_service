package com.rarekickz.rk_admin_service.repository;

import com.rarekickz.rk_admin_service.domain.Sneaker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SneakerRepository extends JpaRepository<Sneaker, Long> {

    @Query("SELECT s FROM sneaker s " +
            "LEFT JOIN FETCH s.sneakerImages")
    List<Sneaker> findAllSneakersWithImages();

    Optional<Sneaker> findBySpecialTrue();
}
