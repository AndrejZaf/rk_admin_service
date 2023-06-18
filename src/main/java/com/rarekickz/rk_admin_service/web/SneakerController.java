package com.rarekickz.rk_admin_service.web;

import com.rarekickz.rk_admin_service.domain.Sneaker;
import com.rarekickz.rk_admin_service.dto.IdListDTO;
import com.rarekickz.rk_admin_service.dto.SneakerDTO;
import com.rarekickz.rk_admin_service.service.SneakerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.rarekickz.rk_admin_service.converter.SneakerConverter.convertToSneakerDTO;
import static com.rarekickz.rk_admin_service.converter.SneakerConverter.convertToSneakerDTOList;

@RequestMapping("/api/admin/sneaker")
@RestController
@RequiredArgsConstructor
public class SneakerController {

    private final SneakerService sneakerService;

    @GetMapping
    public ResponseEntity<List<SneakerDTO>> getSneakers() {
        final List<Sneaker> sneakers = sneakerService.findAllSneakers();
        return new ResponseEntity<>(convertToSneakerDTOList(sneakers), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<SneakerDTO> addSneaker(@RequestBody final SneakerDTO sneakerDTO) {
        Sneaker sneaker = sneakerService.addSneaker(sneakerDTO);
        return new ResponseEntity<>(convertToSneakerDTO(sneaker), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<SneakerDTO> editSneaker(@RequestBody final SneakerDTO sneakerDTO) {
        final Sneaker sneaker = sneakerService.updateSneaker(sneakerDTO);
        return new ResponseEntity<>(convertToSneakerDTO(sneaker), HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteSneaker(@RequestBody final IdListDTO idListDTO) {
        sneakerService.deleteSneaker(idListDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
