package com.project.clinic.service;

import com.project.clinic.DTO.DoctorDTO;
import com.project.clinic.Entity.Doctor;
import com.project.clinic.ModelMapper.ModelMapper;
import com.project.clinic.exception.DoctorNotFoundException;
import com.project.clinic.repository.DoctorRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.print.Doc;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DoctorService
{
    private final DoctorRepo doctorRepo;

    public DoctorDTO create(Doctor doctor)
    {
        return ModelMapper.toDoctorDTO(doctorRepo.save(doctor));
    }
    public DoctorDTO getDoctor(long id){
        return ModelMapper.toDoctorDTO(doctorRepo.findById(id).orElseThrow(()->new DoctorNotFoundException("Doctor Not Found") ));
    }
    public List<DoctorDTO> getAllDoctors(){
        return doctorRepo.findAll().stream()
                .map(ModelMapper::toDoctorDTO)
                .toList();
    }

    public void delete(long id){
        Doctor doctor = doctorRepo.findById(id).orElseThrow(()->new DoctorNotFoundException("Doctor Not Found"));
        doctorRepo.deleteById(id);
    }
    public DoctorDTO update(long id,Doctor updated){
        Doctor exist = doctorRepo.findById(id).orElseThrow(()->new DoctorNotFoundException("Doctor Not Found"));
        exist.setName(updated.getName());
        exist.setDept(updated.getDept());
        if(updated.getAppointments()!=null){
            exist.setAppointments(updated.getAppointments());
        }
        Doctor saved = doctorRepo.save(exist);
        return ModelMapper.toDoctorDTO(saved);
    }
}
