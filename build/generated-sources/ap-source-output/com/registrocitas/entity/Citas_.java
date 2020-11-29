package com.registrocitas.entity;

import com.registrocitas.entity.Medicos;
import com.registrocitas.entity.Paciente;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-11-29T16:55:52")
@StaticMetamodel(Citas.class)
public class Citas_ { 

    public static volatile SingularAttribute<Citas, Integer> idcitas;
    public static volatile SingularAttribute<Citas, Date> fechaCita;
    public static volatile SingularAttribute<Citas, String> horaCita;
    public static volatile SingularAttribute<Citas, Medicos> idmedicos;
    public static volatile SingularAttribute<Citas, Paciente> idpaciente;

}