package com.project.clinic.ModelMapper;

import com.project.clinic.DTO.PatientDTO;
import com.project.clinic.Entity.Patient;

import javax.swing.text.html.parser.Entity;

public class PatientMapper {
    public static PatientDTO toDto(Patient patient){
        if (patient == null) return null;

        PatientDTO dto = new PatientDTO();
        dto.setId(patient.getId());
        dto.setName(patient.getName());
        dto.setEmail(patient.getEmail());
        return dto;
    }

    public static Patient toEntity(PatientDTO dto){
        if(dto == null) return null;

        Patient patient = new Patient();
        dto.setId(patient.getId());
        dto.setName(patient.getName());
        dto.setEmail(patient.getEmail());
        return patient;
    }
}
