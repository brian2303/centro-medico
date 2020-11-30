

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
import org.primefaces.PrimeFaces;

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
        String message = "";
        try {
            pacienteFacadeLocal.create(patient);
            patientList.add(patient);
            patient = new Paciente();
            message = "swal('Ok','paciente registrado exitosamente!','success');";
        } catch (Exception ex) {
                message = "swal('Upss','No fue posible realizar esta transacción!','error');";
            ex.printStackTrace();
        }
        PrimeFaces.current().executeScript(message);
    }
    
    public void removePatient(Paciente patient){
        String message = "";
        try {
            pacienteFacadeLocal.remove(patient);
            patientList.remove(patient);
            message = "swal('Ok','paciente eliminado exitosamente!','success');";
        } catch (Exception e) {
            message = "swal('Upss','No fue posible realizar esta transacción!','error');";
        }
        PrimeFaces.current().executeScript(message);
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
