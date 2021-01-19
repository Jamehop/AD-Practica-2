package edu.Itaca.Practica1AD;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.Table;

@SuppressWarnings("deprecation")
@Entity
@Table( name = "cliente" )



public class Cliente{
	  @Id
	  @Column(name = "codigo_cliente")
	  private Long id;
	

	  
	  @Column(name="nombre_cliente")
	  private String nombre_cliente;
	  
	  @Column(name = "nombre_contacto")
	  private String nombre_contacto;
	  
	  @Column(name="apellido_contacto")
	  private String apellido_contacto;
	  
	  @Column(name="telefono")
	  private int telefono;
	  
	  @Column(name = "fax")
	  private String fax;
	  
	  @Column(name="linea_direccion1")
	  private String linea_direccion1;
	  
	  @Column(name="linea_direccion2")
	  private String linea_direccion2;
	  
	  @Column(name="ciudad")
	  private String ciudad;
	  
	  @Column(name = "region")
	  private String region;
	  
	  @Column(name="pais")
	  private String pais;
	  
	  @Column(name="codigo_postal")
	  private int codigo_postal;
	  
	  @Column(name="codigo_empleado_rep_ventas")
	  private int codigo_empleado_rep_ventas;
	  
	  @Column(name="limite_credito")
	  private int limite_credito;
	}
