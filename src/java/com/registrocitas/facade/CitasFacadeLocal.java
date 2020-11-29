/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.registrocitas.facade;

import com.registrocitas.entity.Citas;
import com.registrocitas.entity.Medicos;
import java.util.Date;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author glzs
 */
@Local
public interface CitasFacadeLocal {

    void create(Citas citas);

    void edit(Citas citas);

    void remove(Citas citas);

    Citas find(Object id);

    List<Citas> findAll();

    List<Citas> findRange(int[] range);

    int count();

    public Citas validateAppointment(Date appointmentDate, String AppointmentHour,Medicos medico);
    
}
