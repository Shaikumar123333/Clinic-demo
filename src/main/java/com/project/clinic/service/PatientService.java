package com.project.clinic.service;

import com.project.clinic.DTO.PatientDTO;
import com.project.clinic.Entity.Patient;
import com.project.clinic.ModelMapper.ModelMapper;
//import com.project.clinic.ModelMapper.PatientMapper;
import com.project.clinic.exception.PatientNotFoundException;
import com.project.clinic.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PatientService {

    @Autowired
    private PatientRepository patientRepository;

    //create patient
    public PatientDTO createPatient(Patient patient){
        return ModelMapper.toPaitentDto(patientRepository.save(patient));
    }

    //get all

    public List<PatientDTO> getAllPatients(){
        return patientRepository.findAll()
                .stream()
                .map(ModelMapper::toPaitentDto)
                .collect(Collectors.toList());
    }

    //get by id

    public PatientDTO getByPatientId(Long id){
        Patient patient = patientRepository.findById(id)
            .orElseThrow(() -> new PatientNotFoundException("patient id not found"));
            return ModelMapper.toPaitentDto(patient);


    }
    //update patient

    public PatientDTO updatePatient(Long id, Patient patient){
        Patient existing = patientRepository.findById(id)
                .orElseThrow(() -> new PatientNotFoundException("patient not found"));

        existing.setName(patient.getName());
        existing.setEmail(patient.getEmail());
        existing.setPhone(patient.getPhone());

        Patient updated = patientRepository.save(existing);
        return ModelMapper.toPaitentDto(updated);
    }

    //delete patient

    public void deletePatient(long id){
        Patient patient = patientRepository.findById(id).orElseThrow(()-> new PatientNotFoundException("patient id not found"));
        patientRepository.deleteById(id);

    }
}
