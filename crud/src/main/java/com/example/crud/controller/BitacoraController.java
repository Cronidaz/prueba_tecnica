package com.example.crud.controller;

import com.example.crud.model.BitacoraModel;
import com.example.crud.model.UserModel;
import com.example.crud.repository.IBitacoraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("bitacora")
public class BitacoraController {

    @Autowired
    private IBitacoraRepository bitacoraRepository;

    @GetMapping
    public List<BitacoraModel> listOfUsers(){
        return bitacoraRepository.findAll();
    }

    @GetMapping("/{userId}")
    public List<BitacoraModel> getBitacorasByUserId(@PathVariable Long userId) {
        return bitacoraRepository.findByUserId(userId);
    }

}
