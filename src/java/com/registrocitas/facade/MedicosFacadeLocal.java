/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.registrocitas.facade;

import com.registrocitas.entity.Medicos;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author glzs
 */
@Local
public interface MedicosFacadeLocal {

    void create(Medicos medicos);

    void edit(Medicos medicos);

    void remove(Medicos medicos);

    Medicos find(Object id);

    List<Medicos> findAll();

    List<Medicos> findRange(int[] range);

    int count();
    
}
