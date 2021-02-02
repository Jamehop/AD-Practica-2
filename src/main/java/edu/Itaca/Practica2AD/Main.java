package edu.Itaca.Practica2AD;

import java.io.*;
import java.io.InputStreamReader;
import java.lang.module.Configuration;
import java.sql.*;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.spi.SessionFactoryServiceRegistryBuilder;

import edu.Itaca.Practica2AD.dao.ClienteDAO;
import edu.Itaca.Practica2AD.dao.DetallePedidoDAO;
import edu.Itaca.Practica2AD.dao.ProductoDAO;
import utilidades.Leer;

public class Main {
	static Connection conn = null;
	private static Session session;
	static BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) {
		ClienteDAO miCliente = new ClienteDAO();
		Cliente cliente = new Cliente();
		ProductoDAO miProducto = new ProductoDAO();
		Producto producto = new Producto();
		DetallePedidoDAO midetallesPedidos = new DetallePedidoDAO();

		try {
			HibernateUtil.setUp();

			System.out.println(
					"Elige lo que quieres hacer: \n1. Añadir cliente\n2. Mostrar cliente\n3. Mostrar todos clientes"
					+ "\n4. Buscar cliente\n5. Edita producto\n6. Muestra todos los detalles de los pedidos de un Cliente\n"
					+ "\n0. Salir");

			int opcion = Leer.pedirEnteroValidar();
			while (opcion != 0) {

				switch (opcion) {
				case 1:
					miCliente.insertar(cliente);
					break;
				case 2:
					miCliente.obtener(cliente);
					break;
				case 3:
					System.out.println(miCliente.obtenerTodos());
					break;
				case 4:
					System.out.println(miCliente.obtenerNombre(cliente));
					break;
				case 5:
					miProducto.modificar(producto);
					break;
				case 6:
					System.out.println( midetallesPedidos.obtenerTodosIDcliente());
					break;
				default:
					System.out.println("No se ha introducido una accion determinada.");
					;
				}
				System.out.println(
						"Elige lo que quieres hacer: \n1. Añadir cliente\n2. Mostrar cliente\n3. Mostrar todos clientes"
						+ "\n4. Buscar cliente\n5. Edita producto\n6. Muestra todos los detalles de los pedidos de un Cliente\n0. Salir");
				opcion = Leer.pedirEnteroValidar();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
