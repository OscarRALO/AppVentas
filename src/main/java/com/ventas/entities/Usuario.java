package com.ventas.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="usuario")
@Data
@AllArgsConstructor @NoArgsConstructor
public class Usuario {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idusuario;
	
	@Column(length = 12)
	private String usuario;

	@Column(name = "password", length = 60)
	private String passwordHash;
	
    @Column(length = 2)
    private String estado;
    
    @ManyToOne
    @JoinColumn(name = "idempleado")
    private Empleado empleado;


}
