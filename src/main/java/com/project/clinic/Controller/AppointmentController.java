package com.project.clinic.Controller;

import com.project.clinic.DTO.AppointmentReq;
import com.project.clinic.DTO.AppointmentRes;
import com.project.clinic.service.AppointmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/appointment")
@RequiredArgsConstructor
public class AppointmentController {

    private final AppointmentService service;

    //create booking
    @PostMapping("/book")
    public ResponseEntity<AppointmentRes> create(@RequestBody AppointmentReq req){
        return new ResponseEntity<>(service.create(req), HttpStatus.CREATED);
    }

    //cancel booking
    @DeleteMapping("/cancel/{id}")
    public  ResponseEntity<AppointmentRes> cancel(@PathVariable long id){
        return new ResponseEntity<>(service.cancel(id), HttpStatus.NO_CONTENT);
    }

    //

    @GetMapping("/{id}")
    public  ResponseEntity<AppointmentRes> getById(@PathVariable long id){
        return new ResponseEntity<>(service.getById(id) , HttpStatus.FOUND);
    }

    @GetMapping("/all")
    public ResponseEntity<List<AppointmentRes>> getAll(){
        return new ResponseEntity<>(service.getAll() , HttpStatus.FOUND);
    }


}
