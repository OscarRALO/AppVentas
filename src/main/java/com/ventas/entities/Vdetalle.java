package com.ventas.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="venta_detalle")
public class Vdetalle {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idvdetalle;
    
    private Float precio;
    private int cantidad;
    private Float subtotal;
    
    @ManyToOne
    @JoinColumn(name = "idproducto")
    private Producto producto;
    
    @ManyToOne
    @JoinColumn(name = "idvpedido")
    private Vencabezado vencabezado;

	public Long getIdvdetalle() {
		return idvdetalle;
	}

	public void setIdvdetalle(Long idvdetalle) {
		this.idvdetalle = idvdetalle;
	}

	public Float getPrecio() {
		return precio;
	}

	public void setPrecio(Float precio) {
		this.precio = precio;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public Float getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(Float subtotal) {
		this.subtotal = subtotal;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public Vencabezado getVencabezado() {
		return vencabezado;
	}

	public void setVencabezado(Vencabezado vencabezado) {
		this.vencabezado = vencabezado;
	}
    
    
    
}