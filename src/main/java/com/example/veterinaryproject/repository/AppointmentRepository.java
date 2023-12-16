package com.example.veterinaryproject.repository;

import com.example.veterinaryproject.model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository extends JpaRepository<Appointment, String> {

}
