package com.project.clinic.Controller;


import com.project.clinic.DTO.DoctorDTO;
import com.project.clinic.Entity.Doctor;
import com.project.clinic.service.DoctorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/doctor")
public class DoctorController {
    private final DoctorService service;

    @PostMapping("/create")
    public ResponseEntity<DoctorDTO> add(@RequestBody Doctor doctor){
        return new ResponseEntity<>(service.create(doctor),HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public ResponseEntity<DoctorDTO> get(@PathVariable long id){
        return new ResponseEntity<>(service.getDoctor(id),HttpStatus.FOUND);
    }
    @GetMapping("/all")
    public ResponseEntity<List<DoctorDTO>> getAll(){
        return new ResponseEntity<>(service.getAllDoctors(),HttpStatus.FOUND);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id){
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<DoctorDTO> update(@PathVariable long id, @RequestBody Doctor doctor){
        return new ResponseEntity<>(service.update(id,doctor),HttpStatus.ACCEPTED);
    }
}
