package com.Tienda.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import lombok.Data;

@Data
@Entity
@Table(name="credito")
public class Credito implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name="id_credito")
    private Long idCredito;
    private double limite;
    //esto hace que se pueda llamar la columna de la
    //DB y ponerle otro nombre en el proyecto Java si se deseara

    public Credito() {
    }

    //No se hace un constructor paraidCredito porque es autoincremental
    public Credito(double limite) {
        this.limite = limite;
    }
    
 
}
