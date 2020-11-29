/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.registrocitas.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author glzs
 */
@Entity
@Table(name = "medicos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Medicos.findAll", query = "SELECT m FROM Medicos m")})
public class Medicos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idmedicos")
    private Integer idmedicos;
    @Size(max = 45)
    @Column(name = "nombres")
    private String nombres;
    @Size(max = 45)
    @Column(name = "identificacion")
    private String identificacion;
    @Size(max = 45)
    @Column(name = "tarjeta_profesional")
    private String tarjetaProfesional;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "anios_experiencia")
    private BigDecimal aniosExperiencia;
    @Size(max = 45)
    @Column(name = "especialidad")
    private String especialidad;
    @Size(max = 45)
    @Column(name = "hora_inicio_atencion")
    private String horaInicioAtencion;
    @Size(max = 45)
    @Column(name = "hora_fin_atencion")
    private String horaFinAtencion;
    @Size(max = 45)
    @Column(name = "tipo_identificacion")
    private String tipoIdentificacion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idmedicos", fetch = FetchType.LAZY)
    private Collection<Citas> citasCollection;

    public Medicos() {
    }

    public Medicos(Integer idmedicos) {
        this.idmedicos = idmedicos;
    }

    public Integer getIdmedicos() {
        return idmedicos;
    }

    public void setIdmedicos(Integer idmedicos) {
        this.idmedicos = idmedicos;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getTarjetaProfesional() {
        return tarjetaProfesional;
    }

    public void setTarjetaProfesional(String tarjetaProfesional) {
        this.tarjetaProfesional = tarjetaProfesional;
    }

    public BigDecimal getAniosExperiencia() {
        return aniosExperiencia;
    }

    public void setAniosExperiencia(BigDecimal aniosExperiencia) {
        this.aniosExperiencia = aniosExperiencia;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public String getHoraInicioAtencion() {
        return horaInicioAtencion;
    }

    public void setHoraInicioAtencion(String horaInicioAtencion) {
        this.horaInicioAtencion = horaInicioAtencion;
    }

    public String getHoraFinAtencion() {
        return horaFinAtencion;
    }

    public void setHoraFinAtencion(String horaFinAtencion) {
        this.horaFinAtencion = horaFinAtencion;
    }

    public String getTipoIdentificacion() {
        return tipoIdentificacion;
    }

    public void setTipoIdentificacion(String tipoIdentificacion) {
        this.tipoIdentificacion = tipoIdentificacion;
    }

    @XmlTransient
    public Collection<Citas> getCitasCollection() {
        return citasCollection;
    }

    public void setCitasCollection(Collection<Citas> citasCollection) {
        this.citasCollection = citasCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idmedicos != null ? idmedicos.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Medicos)) {
            return false;
        }
        Medicos other = (Medicos) object;
        if ((this.idmedicos == null && other.idmedicos != null) || (this.idmedicos != null && !this.idmedicos.equals(other.idmedicos))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.registrocitas.entity.Medicos[ idmedicos=" + idmedicos + " ]";
    }
    
}
