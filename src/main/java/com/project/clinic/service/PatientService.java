package com.project.clinic.service;

import com.project.clinic.DTO.PatientDTO;
import com.project.clinic.Entity.Patient;
import com.project.clinic.ModelMapper.PatientMapper;
import com.project.clinic.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PatientService {

    @Autowired
    private PatientRepository patientRepository;

    //create patient
    public PatientDTO createPatient(PatientDTO dto){
        Patient patient = PatientMapper.toEntity(dto);
        Patient saved = patientRepository.save(patient);
        return PatientMapper.toDto(saved);
    }

    //get all

    public List<PatientDTO> getAllPatients(){
        return patientRepository.findAll()
                .stream()
                .map(PatientMapper::toDto)
                .collect(Collectors.toList());
    }

    //get by id

    public PatientDTO getByPatientId(Long id){
        Patient patient = patientRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("patient id not found"));
            return PatientMapper.toDto(patient);


    }
    //update patient

    public PatientDTO updatePatient(Long id, PatientDTO dto){
        Patient existing = patientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("user not found"));

        existing.setName(dto.getName());
        existing.setEmail(dto.getEmail());
        existing.setPhone(dto.getPhone());

        Patient updated = patientRepository.save(existing);
        return PatientMapper.toDto(updated);
    }

    //delete patient

    public String deletePatient(Long id){
        patientRepository.deleteById(id);
        return "patient deleted successfully";
    }
}
