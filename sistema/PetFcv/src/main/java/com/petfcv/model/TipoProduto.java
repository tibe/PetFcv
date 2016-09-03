/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.petfcv.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author tibe
 */
@Entity
@Table(name = "tipo_produto")
public class TipoProduto implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;
    
    @NotBlank
    @Column(name = "nm_tipo_produto", length = 200, nullable = false)
    private String nmTipoProduto;
    @OneToMany(mappedBy = "tipoProduto")
    private List<Produto> produtos;

    public TipoProduto() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNmTipoProduto() {
        return nmTipoProduto;
    }

    public void setNmTipoProduto(String nmTipoProduto) {
        this.nmTipoProduto = nmTipoProduto;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 73 * hash + (int) (this.id ^ (this.id >>> 32));
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final TipoProduto other = (TipoProduto) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }
    
    
}
