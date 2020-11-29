

package com.registrocitas.controller;

import com.registrocitas.entity.Paciente;
import com.registrocitas.facade.PacienteFacadeLocal;
import java.util.ArrayList;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

/**
 *
 * @author glzs
 */
@Named(value = "patientRequest")
@RequestScoped
public class PatientRequest {
    
    @EJB
    PacienteFacadeLocal pacienteFacadeLocal;
    
    private Paciente patient = new Paciente();
    private ArrayList<Paciente> patientList = new ArrayList();
    
    @PostConstruct
    public void init(){
        patientList.addAll(pacienteFacadeLocal.findAll());
    }
    
    public String editPatient(Paciente pat){
        patient = pat;
        return "private/edit";
    }
    
    public void updatePatient(){
        try {
            pacienteFacadeLocal.edit(patient);
            patientList.clear();
            patientList.addAll(pacienteFacadeLocal.findAll());
            patient = new Paciente(); 
            ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
            String url = ec.getRequestContextPath() + "/patient" ;
            ec.redirect(url);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    public void addPatient(){
        try {
            pacienteFacadeLocal.create(patient);
            patientList.add(patient);
            patient = new Paciente();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    public void removePatient(Paciente patient){
        pacienteFacadeLocal.remove(patient);
        patientList.remove(patient);
    }
    
    /**
     * Creates a new instance of PatientRequest
     */
    public PatientRequest() {
    }

    public Paciente getPatient() {
        return patient;
    }

    public void setPatient(Paciente patient) {
        this.patient = patient;
    }

    public ArrayList<Paciente> getPatientList() {
        return patientList;
    }

    public void setPatientList(ArrayList<Paciente> patientList) {
        this.patientList = patientList;
    }
    
}
