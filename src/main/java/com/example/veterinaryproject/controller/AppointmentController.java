package com.example.veterinaryproject.controller;

import com.example.veterinaryproject.model.Appointment;
import com.example.veterinaryproject.repository.AppointmentRepository;
import com.example.veterinaryproject.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/appointments")
public class AppointmentController {

    private final AppointmentService appointmentService;
    private final AppointmentRepository appointmentRepository;

    @Autowired
    public AppointmentController(AppointmentService appointmentService, AppointmentRepository appointmentRepository) {
        this.appointmentService = appointmentService;
        this.appointmentRepository = appointmentRepository;
    }

    // home page with list of appointments
    @GetMapping
    public String home(Model model) {
        List<Appointment> allAppointments = appointmentService.getAllAppointments();
        model.addAttribute("allAppointments", allAppointments);
        return "/Appointment/appointmentList";
    }

    // create page: where we save new appointment
    @GetMapping("/new")
    public String newAppointmentForm(Model model) {
        Appointment appointment = new Appointment();
        model.addAttribute("appointment", appointment);
        return "/Appointment/make-appointment";
    }

    // create appointment
    @PostMapping("/new")
    public String newAppointment(@ModelAttribute("appointment") Appointment appointment) {
        appointmentService.saveAppointment(appointment); // save appointment
        return "redirect:/appointmentList";
    }

    // update page: where we update appointment info
   // @GetMapping("/{id}/edit_appointment")
   // public String updateAppointmentForm(@PathVariable("id") String id, Model model) {
    //    Appointment appointment = appointmentService.getAppointmentById(id);
    //    model.addAttribute("appointment", appointment);
    //    return "/Appointment/editappointment";
    //}

    // update appointment
    @PostMapping("/{id}/edit_appointment")
    public String editAppointment(@PathVariable("id") String id, @ModelAttribute("appointment") Appointment appointment) {
        appointment.setId(id);
        appointmentService.updateAppointment(appointment);
        return "redirect:/appointmentList";
    }

    // delete appointment
    @GetMapping("/{id}/delete")
    public String removeAppointment(@PathVariable("id") String id) {
        appointmentService.deleteAppointment(id);
        return "redirect:/appointmentList";
    }
}
