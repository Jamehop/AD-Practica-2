package edu.Itaca.Practica2AD.dao;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.query.Query;
import edu.Itaca.Practica2AD.DetallePedido;
import edu.Itaca.Practica2AD.HibernateUtil;

public class DetallePedidoDAO implements DAO<DetallePedido> {

	Scanner reader = new Scanner(System.in);

	public void insertar(Object a) throws Exception {
		// TODO Auto-generated method stub

	}

	public void modificar(Object a) throws Exception {
		// TODO Auto-generated method stub

	}

	public void eliminar(Object a) {
		// TODO Auto-generated method stub

	}

	public List obtenerTodos() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public List<DetallePedido> obtenerTodosIDcliente() throws Exception {

		Session session = HibernateUtil.setUp();
		int id;
		int Total;
		System.out.println("Introduzca el codigo del cliente: ");
		id = reader.nextInt();

		Query query = session.createQuery("select  e   from DetallePedido e where codigo_pedido in ( select codigo_pedido FROM Pedido  where codigo_cliente="+ id + ")  GROUP BY codigo_pedido");
		Query query2 = session.createQuery("select   sum(cantidad*precio_unidad) as Total   from DetallePedido e where codigo_pedido in ( select codigo_pedido FROM Pedido where codigo_cliente="+id + ") ");
		
		List<DetallePedido> entities = query.getResultList();
		List<DetallePedido> entities2 = query2.getResultList();
		System.out.println("La suma total es:" + entities2);

		return entities;

	}

	public Object obtener(Object id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public DetallePedido get(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<DetallePedido> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public void create(DetallePedido t) {
		// TODO Auto-generated method stub

	}

	public void update(DetallePedido t, String[] params) {
		// TODO Auto-generated method stub

	}

	public void delete(DetallePedido t) {
		// TODO Auto-generated method stub

	}

}
