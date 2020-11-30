package com.registrocitas.entity;

import com.registrocitas.entity.Citas;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-11-30T12:52:29")
@StaticMetamodel(Paciente.class)
public class Paciente_ { 

    public static volatile SingularAttribute<Paciente, String> epsAfiliacion;
    public static volatile SingularAttribute<Paciente, String> historiaClinica;
    public static volatile SingularAttribute<Paciente, Date> fechaNacimiento;
    public static volatile SingularAttribute<Paciente, String> tipoIdentificacion;
    public static volatile SingularAttribute<Paciente, String> identificacion;
    public static volatile CollectionAttribute<Paciente, Citas> citasCollection;
    public static volatile SingularAttribute<Paciente, Integer> idpaciente;
    public static volatile SingularAttribute<Paciente, String> nombres;

}