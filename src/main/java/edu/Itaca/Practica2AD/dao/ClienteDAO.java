package edu.Itaca.Practica2AD.dao;

import java.util.List;

import org.hibernate.Session;

import edu.Itaca.Practica1AD.Cliente;
import edu.Itaca.Practica1AD.HibernateUtil;

public class ClienteDAO implements DAO<Cliente>{

	public Cliente get(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Cliente> getAll() {
		try {
			Session session=HibernateUtil.setUp();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public void create(Cliente t) {
		
		
	}

	public void update(Cliente t, String[] params) {
		// TODO Auto-generated method stub
		
	}

	public void delete(Cliente t) {
		// TODO Auto-generated method stub
		
	}

	

}
