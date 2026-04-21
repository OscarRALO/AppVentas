package com.ventas.entities;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="venta_encabezado")
public class Vencabezado {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idvpedido;
	
    private LocalDate fecha;
    
    private Float total;
    
    @ManyToOne
    @JoinColumn(name = "idcliente")
    private Cliente cliente;
    
    @ManyToOne
    @JoinColumn(name = "idempleado")
    private Empleado empleado;

	public Long getIdvpedido() {
		return idvpedido;
	}

	public void setIdvpedido(Long idvpedido) {
		this.idvpedido = idvpedido;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public Float getTotal() {
		return total;
	}

	public void setTotal(Float total) {
		this.total = total;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Empleado getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}
    
    
    
}
