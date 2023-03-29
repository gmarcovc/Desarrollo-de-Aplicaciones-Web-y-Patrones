package com.Tienda.domain;

import javax.persistence.*;
import java.io.Serializable;
import lombok.Data;

@Data
@Entity
@Table(name = "cliente")
public class Cliente implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cliente")
    private Long idCliente; //Transforma en id_cliente, hibernate lo hace
    private String nombre;
    private String apellidos;
    private String correo;
    private String telefono;

    //Esto se trae el idCredito y el limite en una sola variable
    //Y asi lo podemos juntar a la tabla
    @JoinColumn(name = "id_credito", referencedColumnName = "id_credito")
    @ManyToOne
    private Credito credito;

    public Cliente() {
    }

    public Cliente(String nombre, String apellidos, String correo, String telefono) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.correo = correo;
        this.telefono = telefono;
    }

    public Cliente(String nombre, String apellidos, String correo, String telefono, Credito credito) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.correo = correo;
        this.telefono = telefono;
        this.credito = credito;
    }

}
