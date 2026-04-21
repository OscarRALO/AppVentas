package com.ventas.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="producto")
public class Producto {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idproducto;
	@Column(length = 55)
	private String nombre;
	@Column(length = 55)
	private String descripcion;
    private Float preciocompra;
    private Float precioventa;
    
    @Column(length = 3)
    private String talla;
    
    @Column(length = 4)
    private int stock;
    
    @Column(length = 2)
    private String estado;
    
    @ManyToOne
    @JoinColumn(name = "idcategoria")
    private Categoria categoria;
    
    @ManyToOne
    @JoinColumn(name = "idproveedor")
    private Proveedor proveedor;

	public Long getIdproducto() {
		return idproducto;
	}

	public void setIdproducto(Long idproducto) {
		this.idproducto = idproducto;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Float getPreciocompra() {
		return preciocompra;
	}

	public void setPreciocompra(Float preciocompra) {
		this.preciocompra = preciocompra;
	}

	public Float getPrecioventa() {
		return precioventa;
	}

	public void setPrecioventa(Float precioventa) {
		this.precioventa = precioventa;
	}

	public String getTalla() {
		return talla;
	}

	public void setTalla(String talla) {
		this.talla = talla;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Proveedor getProveedor() {
		return proveedor;
	}

	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}
    
	
    
}
