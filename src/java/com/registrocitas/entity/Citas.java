/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.registrocitas.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author glzs
 */
@Entity
@Table(name = "citas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Citas.findAll", query = "SELECT c FROM Citas c")})
public class Citas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idcitas")
    private Integer idcitas;
    @Column(name = "fecha_cita")
    @Temporal(TemporalType.DATE)
    private Date fechaCita;
    @Size(max = 45)
    @Column(name = "hora_cita")
    private String horaCita;
    @JoinColumn(name = "idmedicos", referencedColumnName = "idmedicos")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Medicos idmedicos;
    @JoinColumn(name = "idpaciente", referencedColumnName = "idpaciente")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Paciente idpaciente;

    public Citas() {
    }

    public Citas(Integer idcitas) {
        this.idcitas = idcitas;
    }

    public Integer getIdcitas() {
        return idcitas;
    }

    public void setIdcitas(Integer idcitas) {
        this.idcitas = idcitas;
    }

    public Date getFechaCita() {
        return fechaCita;
    }

    public void setFechaCita(Date fechaCita) {
        this.fechaCita = fechaCita;
    }

    public String getHoraCita() {
        return horaCita;
    }

    public void setHoraCita(String horaCita) {
        this.horaCita = horaCita;
    }

    public Medicos getIdmedicos() {
        return idmedicos;
    }

    public void setIdmedicos(Medicos idmedicos) {
        this.idmedicos = idmedicos;
    }

    public Paciente getIdpaciente() {
        return idpaciente;
    }

    public void setIdpaciente(Paciente idpaciente) {
        this.idpaciente = idpaciente;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idcitas != null ? idcitas.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Citas)) {
            return false;
        }
        Citas other = (Citas) object;
        if ((this.idcitas == null && other.idcitas != null) || (this.idcitas != null && !this.idcitas.equals(other.idcitas))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.registrocitas.entity.Citas[ idcitas=" + idcitas + " ]";
    }
    
}
