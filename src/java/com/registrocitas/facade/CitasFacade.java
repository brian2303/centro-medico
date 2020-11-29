/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.registrocitas.facade;

import com.registrocitas.entity.Citas;
import com.registrocitas.entity.Medicos;
import java.util.Date;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author glzs
 */
@Stateless
public class CitasFacade extends AbstractFacade<Citas> implements CitasFacadeLocal {

    @PersistenceContext(unitName = "registrocitasPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CitasFacade() {
        super(Citas.class);
    }
    
    @Override
    public Citas validateAppointment(Date appointmentDate,String AppointmentHour,Medicos medico){
        try {
            Query q = em.createQuery("SELECT c FROM Citas c WHERE c.fechaCita =:fecha "
                    + "AND  c.horaCita =:hora "
                    + "AND c.idmedicos =:medico");
            q.setParameter("fecha", appointmentDate);
            q.setParameter("hora",AppointmentHour);
            q.setParameter("medico",medico);
            return (Citas) q.getSingleResult();
        } catch (Exception e) {
            return new Citas();
        }
    }
    
}
