/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.registrocitas.controller;

import com.registrocitas.entity.Citas;
import com.registrocitas.entity.Medicos;
import com.registrocitas.entity.Paciente;
import com.registrocitas.facade.CitasFacadeLocal;
import com.registrocitas.facade.MedicosFacadeLocal;
import com.registrocitas.facade.PacienteFacadeLocal;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import org.primefaces.PrimeFaces;

/**
 *
 * @author glzs
 */
@Named(value = "appointmentView")
@ViewScoped
public class AppointmentView implements Serializable {
    
    @EJB
    MedicosFacadeLocal medicosFacadeLocal;
    @EJB
    PacienteFacadeLocal pacienteFacadeLocal;
    @EJB
    CitasFacadeLocal citasFacadeLocal;
    
    private ArrayList<Citas> appointmentList = new ArrayList();
    private Citas appointment = new Citas();
    private Integer idPatient;
    private Integer idDoctor;
    private ArrayList<String> scheduleDoctor = new ArrayList();
    
    @PostConstruct
    public void init(){
        appointmentList.addAll(citasFacadeLocal.findAll());
    }
    /**
     * Creates a new instance of AppointmentView
     */
    public AppointmentView() {
    }
    
    public void addAppointment(){
        String mensajeAlerta = "";
        try {
            if(isValid()){
                appointment.setIdpaciente(pacienteFacadeLocal.find(idPatient));
                citasFacadeLocal.create(appointment);
                appointmentList.add(appointment);
                mensajeAlerta = "swal('Ok','Cita agendada exitosamente!','success');";
                appointment = new Citas();
            }else{
                mensajeAlerta = "swal('Oops','No hay agenda disponible para esta fecha!','error');";
            }
            PrimeFaces.current().executeScript(mensajeAlerta);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public boolean isValid(){
        appointment.setIdmedicos(medicosFacadeLocal.find(idDoctor));
        Citas c = citasFacadeLocal.validateAppointment(appointment.getFechaCita(),
            appointment.getHoraCita(),appointment.getIdmedicos());
        if(c.getIdcitas() == null){
            return true;
        } else {
            return false;
        }
    }
    
    
    public void showSchedule(){
        Medicos doctor = medicosFacadeLocal.find(idDoctor);
        Integer beginHour = Integer.parseInt(doctor.getHoraInicioAtencion());
        Integer endHour = Integer.parseInt(doctor.getHoraFinAtencion());
        for(int i = beginHour;i <= endHour;i++){
            scheduleDoctor.add(String.valueOf(i));
        }
        System.out.println(idDoctor);
        System.out.println("me ejecute el ajax");
    }
    
    public List<Medicos> getDoctorList(){
        return medicosFacadeLocal.findAll();
    }
    
    public List<Paciente> getPatientList(){
        return pacienteFacadeLocal.findAll();
    }
    
    public Integer getIdPatient() {
        return idPatient;
    }

    public void setIdPatient(Integer idPatient) {
        this.idPatient = idPatient;
    }
    
    public Citas getAppointment() {
        return appointment;
    }

    public void setAppointment(Citas appointment) {
        this.appointment = appointment;
    }

    public Integer getIdDoctor() {
        return idDoctor;
    }

    public void setIdDoctor(Integer idDoctor) {
        this.idDoctor = idDoctor;
    }

    public ArrayList<String> getScheduleDoctor() {
        return scheduleDoctor;
    }

    public void setScheduleDoctor(ArrayList<String> scheduleDoctor) {
        this.scheduleDoctor = scheduleDoctor;
    }

    public ArrayList<Citas> getAppointmentList() {
        return appointmentList;
    }

    public void setAppointmentList(ArrayList<Citas> appointmentList) {
        this.appointmentList = appointmentList;
    }

    
    
}
