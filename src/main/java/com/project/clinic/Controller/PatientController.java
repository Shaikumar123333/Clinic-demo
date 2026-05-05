package com.project.clinic.Controller;

import com.project.clinic.DTO.PatientDTO;
import com.project.clinic.Entity.Doctor;
import com.project.clinic.Entity.Patient;
import com.project.clinic.service.PatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patient")
@RequiredArgsConstructor
public class PatientController {

    private final PatientService service;

    @PostMapping("/create")
    public ResponseEntity<PatientDTO> add(@RequestBody Patient patient){
        return new ResponseEntity<>(service.createPatient(patient), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PatientDTO> get(@PathVariable long id){
        return new ResponseEntity<>(service.getByPatientId(id), HttpStatus.FOUND);
    }

    @GetMapping("/all")
    public ResponseEntity<List<PatientDTO>> getAll(){
        return new ResponseEntity<>(service.getAllPatients(), HttpStatus.FOUND);
    }

    @PutMapping("/update/{id}")
    public  ResponseEntity<PatientDTO> update(@PathVariable long id,@RequestBody Patient patient){
        return  new ResponseEntity<>(service.updatePatient(id,patient), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id){
        service.deletePatient(id);
         return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}
