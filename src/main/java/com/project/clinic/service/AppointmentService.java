package com.project.clinic.service;

import com.project.clinic.DTO.AppointmentReq;
import com.project.clinic.DTO.AppointmentRes;
import com.project.clinic.Entity.Appointment;
import com.project.clinic.Entity.Doctor;
import com.project.clinic.Entity.Patient;
import com.project.clinic.ModelMapper.ModelMapper;
import com.project.clinic.exception.DoctorNotFoundException;
import com.project.clinic.exception.PatientNotFoundException;
import com.project.clinic.repository.AppointmentRepo;
import com.project.clinic.repository.DoctorRepo;
import com.project.clinic.repository.PatientRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AppointmentService {

    private final AppointmentRepo repo;
    private final DoctorRepo doctorRepo;
    private final PatientRepository patientRepo;

    @Transactional
    public AppointmentRes create(AppointmentReq req){
        Appointment appointment = new Appointment();
        Doctor doctor = doctorRepo.findById(req.getDoctor_id()).orElseThrow(()-> new DoctorNotFoundException("Doctor Not Found"));
        Patient patient = patientRepo.findById(req.getPatient_id()).orElseThrow(()->new PatientNotFoundException("Patient Not Found"));
        appointment.setDoctor(doctor);
        appointment.setPatient(patient);
        appointment.setLocalDateTime(LocalDateTime.now());
        appointment.setStatus(req.getStatus());
        return ModelMapper.toAppointmentRes(repo.save(appointment));
    }
    @Transactional
    public AppointmentRes cancel(long id) {
        Appointment appointment = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Appointment Not Found"));

        appointment.setStatus("CANCELLED"); // or use enum

        Appointment saved = repo.save(appointment);
        return ModelMapper.toAppointmentRes(saved);
    }
    @Transactional
    public AppointmentRes getById(long id) {
        Appointment appointment = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Appointment Not Found"));

        return ModelMapper.toAppointmentRes(appointment);
    }
    public List<AppointmentRes> getAll() {
        return repo.findAll()
                .stream()
                .map(ModelMapper::toAppointmentRes)
                .toList();
    }

}
