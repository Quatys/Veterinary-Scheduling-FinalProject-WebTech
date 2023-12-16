package com.example.veterinaryproject.service.implementation;

import com.example.veterinaryproject.model.Appointment;
import com.example.veterinaryproject.repository.AppointmentRepository;
import com.example.veterinaryproject.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentServiceImpl implements AppointmentService {
    private final AppointmentRepository appointmentRepository;

    @Autowired
    public AppointmentServiceImpl(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

    @Override
    public List<Appointment> getAllAppointments() {
        return  appointmentRepository.findAll();
    }

    @Override
    public void saveAppointment(Appointment appointment) {
        appointmentRepository.save(appointment);
    }

    @Override
    public void updateAppointment(Appointment appointment) {
        appointmentRepository.save(appointment);
    }

    @Override
    public void deleteAppointment(String appointmentId) {
        appointmentRepository.deleteById(appointmentId);
    }


}
