package edu.Itaca.Practica2AD.dao;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.query.Query;
import edu.Itaca.Practica2AD.Cliente;
import edu.Itaca.Practica2AD.HibernateUtil;

public class ClienteDAO implements DAO<Cliente> {

	Scanner reader = new Scanner(System.in);
	Cliente cliente = new Cliente();

	public void insertar(Object a) throws Exception {

		Session session = HibernateUtil.setUp();

		cliente = new Cliente();

		int codigo_cliente;
		String nombre_cliente;
		String nombre_contacto;
		String apellido_contacto;
		String telefono;
		String fax;
		String linea_direccion1;
		String linea_direccion2;
		String ciudad;
		String region;
		String pais;
		int codigo_postal;
		int codigo_empleado_rep_ventas;
		int limite_credito;

		System.out.println("Di el Id del nuevo cliente:");
		codigo_cliente = reader.nextInt();
		cliente.setId(codigo_cliente);
		System.out.println("Dime su nombre:");
		nombre_cliente = reader.nextLine();
		nombre_cliente = reader.nextLine();
		cliente.setNombre_cliente(nombre_cliente);
		System.out.println("Dime el nombre del contacto");
		nombre_contacto = reader.nextLine();
		cliente.setNombre_contacto(nombre_contacto);
		System.out.println("Dime el apellido: ");
		apellido_contacto = reader.nextLine();
		cliente.setApellido_contacto(apellido_contacto);
		System.out.println("Dime tu telefono: ");
		telefono = reader.nextLine();
		cliente.setTelefono(telefono);
		System.out.println("Dime tu fax");
		fax = reader.nextLine();
		fax = reader.nextLine();
		cliente.setFax(fax);
		System.out.println("Dime su 1ºDirección: ");
		linea_direccion1 = reader.nextLine();
		cliente.setLinea_direccion1(linea_direccion1);
		System.out.println("Dime su 2ºDirección: ");
		linea_direccion2 = reader.nextLine();
		cliente.setLinea_direccion2(linea_direccion2);
		System.out.println("Dime su  Ciudad: ");
		ciudad = reader.nextLine();
		cliente.setCiudad(ciudad);
		System.out.println("Dime su Región: ");
		region = reader.nextLine();
		cliente.setRegion(region);
		System.out.println("Dime su Pais: ");
		pais = reader.nextLine();
		cliente.setPais(pais);
		System.out.println("Dime su codigo postal: ");
		codigo_postal = reader.nextInt();
		cliente.setCodigo_postal(codigo_postal);
		System.out.println("Dime el codigo del empleado: ");
		codigo_empleado_rep_ventas = reader.nextInt();
		cliente.setCodigo_empleado_rep_ventas(codigo_empleado_rep_ventas);
		System.out.println("Dime el limite de credito: ");
		limite_credito = reader.nextInt();
		cliente.setLimite_credito(limite_credito);

		session.getTransaction().begin();
		session.persist(cliente);
		session.getTransaction().commit();
		System.out.println("Añadido a la base de datos\n");

	}

	public void modificar(Object a) {
		// TODO Auto-generated method stub

	}

	public void eliminar(Object a) {
		// TODO Auto-generated method stub

	}

	public List<Cliente> obtenerTodos() throws Exception {

		Session sf = HibernateUtil.setUp();
		Query query = sf.createQuery("select  e  from Cliente e ORDER BY nombre_cliente");

		List<Cliente> entities = query.getResultList();

		return entities;
	}

	public Object obtener(Object id) throws Exception {

		Session sf = HibernateUtil.setUp();

		cliente = new Cliente();
		System.out.println("Dime el id del cliente:");

		// cliente2 = sf.find(ClienteEntity.class, reader.nextInt());
		cliente = sf.find(Cliente.class, reader.nextInt());

		System.out.println(cliente);
		System.out.println();

		return id;

	}

	public List<Cliente> obtenerNombre(Object id) throws Exception {

		Session sf = HibernateUtil.setUp();
		String dato;

		cliente = new Cliente();
		System.out.println("Dime el nombre del cliente, el nombre del contacto o el apellido del contacto");
		dato = reader.nextLine();

		Query query = sf.createQuery("select  e  from Cliente e where nombre_cliente = '" + dato + "'"+ " or nombre_contacto= '" + dato + "' or apellido_contacto = '" + dato + "'");

		List<Cliente> entities = query.getResultList();

		return entities;

	}

	public Cliente get(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Cliente> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public void create(Cliente t) {
		// TODO Auto-generated method stub
		
	}

	public void update(Cliente t, String[] params) {
		// TODO Auto-generated method stub
		
	}

	public void delete(Cliente t) {
		// TODO Auto-generated method stub
		
	}

}