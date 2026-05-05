package com.project.clinic.ModelMapper;

import com.project.clinic.DTO.AppointmentRes;
import com.project.clinic.DTO.DoctorDTO;
import com.project.clinic.DTO.PatientDTO;
import com.project.clinic.DTO.UserDTO;
import com.project.clinic.Entity.Appointment;
import com.project.clinic.Entity.Doctor;
import com.project.clinic.Entity.Patient;
import com.project.clinic.Entity.Users;

import javax.swing.text.html.parser.Entity;

public class ModelMapper {
    public static PatientDTO toPaitentDto(Patient patient){
        if (patient == null) return null;

        PatientDTO dto = new PatientDTO();
        dto.setId(patient.getId());
        dto.setName(patient.getName());
        dto.setEmail(patient.getEmail());
        dto.setPhone(patient.getPhone());
        return dto;
    }

//    public static Patient toEntity(PatientDTO dto){
//        if(dto == null) return null;
//
//        Patient patient = new Patient();
//        dto.setId(patient.getId());
//        dto.setName(patient.getName());
//        dto.setEmail(patient.getEmail());
//
//        return patient;
//    }
    public static DoctorDTO toDoctorDTO(Doctor doctor){
        DoctorDTO dto = new DoctorDTO();
        dto.setId(doctor.getId());
        dto.setName(doctor.getName());
        dto.setDept(doctor.getDept());
        return dto;
    }
    public static AppointmentRes toAppointmentRes(Appointment appointment){
        AppointmentRes res = new AppointmentRes();
        res.setStatus(appointment.getStatus());
        res.setLocalDateTime(appointment.getLocalDateTime());
        res.setId(appointment.getId());
        return res;
    }
    public static UserDTO toUserDTO(Users user){
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setName(user.getName());
        userDTO.setEmail(user.getEmail());
        return userDTO;
    }
}
