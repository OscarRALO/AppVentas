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
@Table(name="compra_encabezado")
public class Cencabezado {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idcpedido;
	
	private LocalDate fecha;
    
    private Float total;
    
    @ManyToOne
    @JoinColumn(name = "idproveedor")
    private Proveedor proveedor;
    
    @ManyToOne
    @JoinColumn(name = "idempleado")
    private Empleado empleado;

	public Long getIdcpedido() {
		return idcpedido;
	}

	public void setIdcpedido(Long idcpedido) {
		this.idcpedido = idcpedido;
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

	public Proveedor getProveedor() {
		return proveedor;
	}

	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}

	public Empleado getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}
    
    
    
}
