/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.registrocitas.controller;

import com.registrocitas.entity.Medicos;
import com.registrocitas.facade.MedicosFacadeLocal;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import org.primefaces.PrimeFaces;

/**
 *
 * @author glzs
 */
@Named(value = "doctorRequest")
@RequestScoped
public class DoctorRequest {
    
    @EJB
    MedicosFacadeLocal medicosFacadeLocal;
    
    private ArrayList<Medicos> doctorsList = new ArrayList();
    private Medicos doctor = new Medicos();
    private Medicos doctorEdit = new Medicos();
    
    @PostConstruct
    public void init(){
        doctorsList.addAll(medicosFacadeLocal.findAll());
    }
    
    
    public void addDoctor(){
        String message = "";
        try {
            medicosFacadeLocal.create(doctor);
            doctorsList.add(doctor);
            message = "swal('Ok','Doctor registrado!','success');";
        } catch (Exception e) {
            message = "swal('Upss!','Ocurrio un error!','error');";
        }
        PrimeFaces.current().executeScript(message);
        
    }
    
    public String editDoctor(Medicos doctor){
        doctorEdit = doctor;
        return "private/edit";
    }
    
    public void updateDoctor(){
        String message = "";
        try {
            medicosFacadeLocal.edit(doctorEdit);
            doctorsList.clear();
            doctorsList.addAll(medicosFacadeLocal.findAll());
            doctorEdit = new Medicos();
            ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
            String url = ec.getRequestContextPath() + "/doctor" ;
            message = "swal('Ok','Modificado!','success');";
            ec.redirect(url);
        } catch (IOException ex) {
            message = "swal('Ok','Error interno','error');";
            ex.printStackTrace();
        }
        PrimeFaces.current().executeScript(message);
    }
    
    public void deleteDoctor(Medicos doctor){
        String message = "";
        try {
            medicosFacadeLocal.remove(doctor);
            doctorsList.remove(doctor);
            message = "swal('Ok','Eliminado!','success');";
        } catch (Exception e) {
            message = "swal('Ok','No fue posible eliminar!','error');";
        }
        PrimeFaces.current().executeScript(message);
    }
    
    public DoctorRequest() {
    }

    public Medicos getDoctorEdit() {
        return doctorEdit;
    }

    public void setDoctorEdit(Medicos doctorEdit) {
        this.doctorEdit = doctorEdit;
    }
    
    

    public Medicos getDoctor() {
        return doctor;
    }

    public void setDoctor(Medicos medico) {
        this.doctor = medico;
    }
    
    public ArrayList<Medicos> getDoctorsList() {
        return doctorsList;
    }

    public void setDoctorsList(ArrayList<Medicos> doctorsList) {
        this.doctorsList = doctorsList;
    }
    
}
