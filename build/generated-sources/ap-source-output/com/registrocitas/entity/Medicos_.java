package com.registrocitas.entity;

import com.registrocitas.entity.Citas;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-11-29T16:55:52")
@StaticMetamodel(Medicos.class)
public class Medicos_ { 

    public static volatile SingularAttribute<Medicos, String> horaInicioAtencion;
    public static volatile SingularAttribute<Medicos, BigDecimal> aniosExperiencia;
    public static volatile SingularAttribute<Medicos, Integer> idmedicos;
    public static volatile SingularAttribute<Medicos, String> tipoIdentificacion;
    public static volatile SingularAttribute<Medicos, String> identificacion;
    public static volatile CollectionAttribute<Medicos, Citas> citasCollection;
    public static volatile SingularAttribute<Medicos, String> tarjetaProfesional;
    public static volatile SingularAttribute<Medicos, String> especialidad;
    public static volatile SingularAttribute<Medicos, String> horaFinAtencion;
    public static volatile SingularAttribute<Medicos, String> nombres;

}