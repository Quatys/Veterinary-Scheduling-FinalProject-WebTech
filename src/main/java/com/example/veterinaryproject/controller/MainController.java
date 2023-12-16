package com.example.veterinaryproject.controller;

import ch.qos.logback.core.model.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    @GetMapping("/")
    public String home(Model model) {
        // Add logic to display home page
        return "index";
    }

    // Dashboard page
    @GetMapping("/dashboard")
    public String showDashboard(Model model) {
        // Add logic to prepare the model for the dashboard page
        return "dashboard";
    }

    @GetMapping("/new-pet")
    public String showNewPet(Model model) {
        return "Pet/new-pet";
    }

    @GetMapping("/make-appointment")
    public String showMakeAppointment(Model model) {
        return "Appointment/make-appointment";
    }

    @GetMapping("/appointmentList")
    public String showAppointmentList() {
        return "Appointment/appointmentList";
    }

    @GetMapping("/calendar")
    public String showCalendar() {
        // Add logic to display calendar
        return "calendar";
    }


}
