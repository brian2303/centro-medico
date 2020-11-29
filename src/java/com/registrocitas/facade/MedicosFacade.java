/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.registrocitas.facade;

import com.registrocitas.entity.Medicos;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author glzs
 */
@Stateless
public class MedicosFacade extends AbstractFacade<Medicos> implements MedicosFacadeLocal {

    @PersistenceContext(unitName = "registrocitasPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MedicosFacade() {
        super(Medicos.class);
    }
    
}
