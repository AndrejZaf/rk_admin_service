package com.rarekickz.rk_admin_service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class IdListDTO {

    private List<Long> ids;
}
