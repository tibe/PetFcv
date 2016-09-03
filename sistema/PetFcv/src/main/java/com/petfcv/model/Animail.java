/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.petfcv.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 *
 * @author tibe
 */
@Entity
@Table(name = "animail")
public class Animail implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @Column(name = "nm_animal")
    private String nmAnimal;

    @Column(name = "nm_raca")
    private String nmRaca;

    @Column(name = "peso")
    private String peso;

    @Column(name = "dt_nascimento")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dtNascimento;

}
