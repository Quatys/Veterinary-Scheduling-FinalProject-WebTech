package com.example.veterinaryproject.service;

import com.example.veterinaryproject.model.Appointment;

import java.util.List;

public interface AppointmentService {
    List<Appointment> getAllAppointments();
    void saveAppointment(Appointment appointment);
    void updateAppointment(Appointment appointment);
    void deleteAppointment(String appointmentId);
}
