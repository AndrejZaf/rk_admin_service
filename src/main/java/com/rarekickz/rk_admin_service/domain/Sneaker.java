package com.rarekickz.rk_admin_service.domain;

import com.rarekickz.rk_admin_service.enums.Gender;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Entity(name = "sneaker")
public class Sneaker {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "name")
    private String name;

    @NotNull
    @Column(name = "description")
    private String description;

    @NotNull
    @Column(name = "price")
    private Double price;

    @OneToOne
    @JoinColumn(name = "brand_id", referencedColumnName = "id")
    private Brand brand;

    @NotNull
    @Column(name = "is_special")
    private boolean isSpecial = false;

    @NotNull
    @Column(name = "gender")
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @OneToMany(mappedBy = "sneaker", fetch = FetchType.LAZY)
    private Set<SneakerImage> sneakerImages;

    @OneToMany(mappedBy = "sneaker", fetch = FetchType.LAZY)
    private Set<SneakerSize> sneakerSizes;
}
