package edu.Itaca.Practica2AD.dao;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;

import edu.Itaca.Practica2AD.HibernateUtil;
import edu.Itaca.Practica2AD.Producto;

public class ProductoDAO implements DAO<Producto> {
	Scanner reader = new Scanner(System.in);
	Producto producto;

	public void insertar(Object a) {
		// TODO Auto-generated method stub

	}

	public void modificar(Object a) throws Exception {

		Session session = HibernateUtil.setUp();
		String nombre;
		String gama;

		String dimensiones;
		String proveedor;
		String descripcion;
		int cantidad_en_stock;
		int precio_venta;
		int precio_proveedor;

		System.out.println("Dime el id del producto:");
		producto = new Producto();
		producto = session.find(Producto.class, reader.nextLine());

		System.out.println("Dime el nuevo nombre del producto: ");
		nombre = reader.nextLine();
		if (nombre.equalsIgnoreCase("")) {

			nombre = producto.getNombre_producto();
		}

		producto.setNombre_producto(nombre);
		System.out.println(nombre);
		System.out.println("Dime la nueva gama del producto: ");
		gama = reader.nextLine();
		if (gama.equalsIgnoreCase("")) {

			gama = producto.getGama();
		}
		producto.setGama(gama);
		System.out.println("Dime las nuevas dimensiones: ");
		dimensiones = reader.nextLine();
		if (dimensiones.equalsIgnoreCase("")) {
			dimensiones = producto.getDimensiones();

		}
		producto.setDimensiones(dimensiones);
		System.out.println("Dime el nuevo proveedor: ");
		proveedor = reader.nextLine();

		if (proveedor.equalsIgnoreCase("")) {

			proveedor = producto.getProveedor();
		}

		producto.setProveedor(proveedor);
		System.out.println("Dime la nueva descripción: ");
		descripcion = reader.nextLine();
		if (descripcion.equalsIgnoreCase("")) {

			descripcion = producto.getDescripcion();
		}
		producto.setDescripcion(descripcion);
		System.out.println("Dime la nueva cantidad de stock(0 para no cambiar nada): ");
		cantidad_en_stock = reader.nextInt();
		if (cantidad_en_stock == 0) {
			cantidad_en_stock = producto.getCantidad_en_stock();
		}
		producto.setCantidad_en_stock(cantidad_en_stock);

		System.out.println("Dime el nuevo precio de venta(0 para no cambiar nada): ");
		precio_venta = reader.nextInt();
		if (precio_venta == 0) {
			precio_venta = producto.getPrecio_venta();
		}

		producto.setPrecio_venta(precio_venta);
		System.out.println("Dime el nuevo precio de proveedor(0 para no cambiar nada): ");
		precio_proveedor = reader.nextInt();
		if (precio_proveedor == 0) {
			precio_proveedor = producto.getPrecio_proveedor();
		}
		producto.setPrecio_proveedor(precio_proveedor);

		session.getTransaction().begin();
		session.merge(producto);
		session.getTransaction().commit();
		System.out.println("Producto actualizado..");
		System.out.println();

	}

	public void eliminar(Object a) {
		// TODO Auto-generated method stub

	}

	public List obtenerTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	public Object obtener(Object id) {
		// TODO Auto-generated method stub
		return null;
	}

	public Producto get(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Producto> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public void create(Producto t) {
		// TODO Auto-generated method stub

	}

	public void update(Producto t, String[] params) {
		// TODO Auto-generated method stub

	}

	public void delete(Producto t) {
		// TODO Auto-generated method stub

	}

}