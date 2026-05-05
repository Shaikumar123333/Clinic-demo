package com.project.clinic.Controller;

import com.project.clinic.DTO.PatientDTO;
import com.project.clinic.Entity.Patient;
import com.project.clinic.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patients")


public class PatientController {

    @Autowired
    private PatientService patientService;

    @PostMapping
    public PatientDTO create(@RequestBody PatientDTO dto){
        return patientService.createPatient(dto);
    }

    @GetMapping
    public List<PatientDTO> getAll(){
        return patientService.getAllPatients();
    }

    @GetMapping("/{id}")
    public PatientDTO getById(@PathVariable Long id){
        return patientService.getByPatientId(id);
    }

    @DeleteMapping("/{id}")
    public String  Delete(@PathVariable  Long id){
         return patientService.deletePatient(id);

    }

}
