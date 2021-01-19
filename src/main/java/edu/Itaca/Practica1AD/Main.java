package edu.Itaca.Practica1AD;

import java.io.*;
import java.io.InputStreamReader;
import java.lang.module.Configuration;
import java.sql.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.spi.SessionFactoryServiceRegistryBuilder;

import utilidades.Leer;

public class Main {
	static Connection conn = null;
	private static Session session;
	static BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) {

		try {
			HibernateUtil.setUp();
			
			System.out.println("Elige lo que quieres hacer: \n1. Añadir cliente\n2. Mostrar cliente\n3. Mostrar todos clientes\n4. Buscar cliente\n5. Edita producto\n0. Salir");

			int opcion = Leer.pedirEnteroValidar();
			while (opcion != 0) {

				switch (opcion) {
				case 1:
					añadirCliente();
					break;
				case 2:
					mostrarCliente();
					break;
				case 3:
					mostrarTodosClientes();
					break;
				case 4:
					buscarClientes();
					break;
				case 5:
					updateClientes();
					break;
				default:
					System.out.println("No se ha introducido una accion determinada.");
					;
				}
				System.out.println("Elige lo que quieres hacer: \n1. Añadir cliente\n2. Mostrar cliente\n3. Mostrar todos clientes\n4. Buscar cliente\n5. Edita producto\n0. Salir");
				opcion = Leer.pedirEnteroValidar();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public static void añadirCliente() throws SQLException {

		System.out.println("Introduce los datos del cliente:");

		System.out.println("Codigo_cliente: ");
		int codigo_cliente = Leer.pedirEnteroValidar();
		System.out.println("Nombre_cliente: ");
		String nombre_cliente = Leer.pedirCadena();
		System.out.println("Telefono: ");
		String telefono = Leer.pedirCadena();
		System.out.println("Fax: ");
		String fax = Leer.pedirCadena();
		System.out.println("Linea_direccion1: ");
		String linea_direccion1 = Leer.pedirCadena();
		System.out.println("Ciudad: ");
		String ciudad = Leer.pedirCadena();
		System.out.println("Codigo_empleado_rep_ventas: ");
		int codigo_empleado_rep_ventas = Leer.pedirEnteroValidar();

		String sql = "INSERT INTO cliente (codigo_cliente, nombre_cliente, telefono, fax, linea_direccion1, ciudad, codigo_empleado_rep_ventas) VALUES (?, ?, ?, ?, ?, ?, ?)";

		PreparedStatement statement = conn.prepareStatement(sql);
		statement.setInt(1, codigo_cliente);
		statement.setString(2, nombre_cliente);
		statement.setString(3, telefono);
		statement.setString(4, fax);
		statement.setString(5, linea_direccion1);
		statement.setString(6, ciudad);
		statement.setInt(7, codigo_empleado_rep_ventas);

		int rowsInserted = statement.executeUpdate();
		if (rowsInserted > 0) {
			System.out.println("Se ha introducido un nuevo cliente correctamente");
		}

	}

	public static void mostrarCliente() throws SQLException {
		try {
			System.out.println("Introduce el codigo del cliente:");
			int codigo_cliente = Leer.pedirEnteroValidar();
			String sql = "SELECT * FROM cliente WHERE codigo_cliente=" + codigo_cliente;

			Statement statement = conn.createStatement();
			ResultSet result = statement.executeQuery(sql);

			while (result.next()) {
				String nombre_cliente = result.getString(2);
				String telefono = result.getString(3);
				String linea_direccion1 = result.getString(5);
				String ciudad = result.getString(6);

				String output = "Cliente #" + codigo_cliente + ": %s - %s - %s - %s";
				System.out.println(String.format(output, nombre_cliente, telefono, linea_direccion1, ciudad));
			}
		} catch (Exception e) {
			System.out.println("Error a la hora de buscar un cliente.");
		}
	}

	public static void mostrarTodosClientes() throws SQLException {
		String sql = "SELECT * FROM cliente ORDER BY nombre_cliente ASC";

		Statement statement = conn.createStatement();
		ResultSet result = statement.executeQuery(sql);

		while (result.next()) {
			String nombre_cliente = result.getString(2);
			String nombre_contacto = result.getString(3);
			String telefono = result.getString(5);
			String linea_direccion1 = result.getString(7);

			String output = "%s - %s - %s - %s";
			System.out.println(String.format(output, nombre_cliente, nombre_contacto, telefono, linea_direccion1));
		}
	}

	public static void buscarClientes() throws SQLException {
		System.out.println("Introduce el nombre, contacto o apellido del cliente a buscar:");
		String palabra = Leer.pedirCadena();
		String sql = "SELECT * FROM cliente WHERE nombre_cliente LIKE '%" + palabra + "%' OR nombre_contacto LIKE '%"
				+ palabra + "%' OR apellido_contacto LIKE '%" + palabra + "%'";

		Statement statement = conn.createStatement();
		ResultSet result = statement.executeQuery(sql);

		while (result.next()) {
			String nombre_cliente = result.getString(2);
			String nombre_contacto = result.getString(3);
			String apellido_contacto = result.getString(4);

			String output = "%s - %s - %s";
			System.out.println(String.format(output, nombre_cliente, nombre_contacto, apellido_contacto));
		}
	}

	public static void updateClientes() throws SQLException {
		System.out.println("Introduce el codigo del producto:");
		String codigo=Leer.pedirCadena();
		String sql = "SELECT * FROM producto WHERE codigo_producto='" + codigo+"'";

		Statement statement = conn.createStatement();
		ResultSet result = statement.executeQuery(sql);

		
		while (result.next()) {
			int codigo_producto = result.getInt(1);
			String nombre = result.getString(2);
			String gama = result.getString(3);
			int cantidad_en_stock = result.getInt(7);
			int precio_venta = result.getInt(8);

			String output = "%s - %s - %s - %s - %s";
			System.out.println(String.format(output, codigo_producto, nombre, gama, cantidad_en_stock, precio_venta));
		}
		
		/*String nombre = result.getString(2);
		String gama = result.getString(3);
		int cantidad_en_stock = result.getInt(7);
		int precio_venta = result.getInt(8);*/
		
		System.out.println("Introduce el nuevo nombre del producto:");
		String nuevoNombreProducto=Leer.pedirCadena();
		/*if(nuevoNombreProducto.equalsIgnoreCase("")) {
			nuevoNombreProducto.contentEquals(nombre);
		}*/
		System.out.println("Introduce la nueva gama del producto;");
		String nuevaGama=Leer.pedirCadena();
		/*if(nuevaGama.equalsIgnoreCase("")) {
			nuevaGama.contentEquals(gama);
		}*/
		System.out.println("Introduce la nueva cantidad en stock:");
		int nuevaCantidad=Leer.pedirEnteroValidar();
		/*if(nuevaCantidad==0) {
			nuevaCantidad=cantidad_en_stock;
		}*/
		System.out.println("Introduce el nuevo precio venta:");
		int nuevoPrecio=Leer.pedirEnteroValidar();
		/*if(nuevoPrecio==0) {
			nuevoPrecio=precio_venta;
		}*/
		
		
		String sql2="UPDATE producto SET nombre='"+nuevoNombreProducto+"', gama='"+nuevaGama+"', cantidad_en_stock='"+nuevaCantidad+"', precio_venta='"+nuevoPrecio+"' WHERE codigo_producto="+codigo;

		PreparedStatement statement2 = conn.prepareStatement(sql2);
		statement2.execute();
		System.out.println("Modificado con exito.");
		
	}
	
}
