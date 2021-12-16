package com.nk.springproject.dao;

import java.sql.Blob;
import java.util.List;

import javax.sql.DataSource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import com.nk.springproject.entity.Contacts;
@Repository
public class ContactsDaoImpl implements ContactsDAO {
	@Autowired
	private SessionFactory sessionFactory;
	
	@Autowired		
	private JdbcTemplate jdbcTemp;
	
	public ContactsDaoImpl(DataSource dataSource) {
		jdbcTemp = new JdbcTemplate(dataSource);
	}
	
	
	
	@Transactional
	@Override
	public List<Contacts> getContacts() {
		Session currentSession = sessionFactory.getCurrentSession();
		// create a query
		Query<Contacts> theQuery = 
				currentSession.createQuery("from Contacts ",Contacts.class);
		
		// execute query and get result list
		List<Contacts> emails = theQuery.getResultList();
				
		// return the results		
		return emails;
	}

	@Override
	@Transactional
	public Contacts getContacts(int theId) {
		Session currentSession = sessionFactory.getCurrentSession();
Contacts theContact = currentSession.get(Contacts.class, theId);
		
		return theContact;
	}

	@Override
	@Transactional
	public void saveContact(Contacts theContact) {
		Session currentSession = sessionFactory.getCurrentSession();
		
		// save the contact
		currentSession.saveOrUpdate(theContact);
		
	}

	@Override
	@Transactional
	public void deleteContact(int theId) {
		Session currentSession = sessionFactory.getCurrentSession();
		
		// delete object with primary key
		Query theQuery = 
				currentSession.createQuery("delete from Contacts where id=:customerId").setParameter("customerId", theId);
		
		theQuery.executeUpdate();	
		
	}

	@Override
	@Transactional
	public List<Contacts> getContact() {
		// TODO Auto-generated method stub
		Session currentSession = sessionFactory.getCurrentSession();
		// create a query
		Query<Contacts> theQuery = 
				currentSession.createQuery("from Contacts order by firstName ",Contacts.class);
		
		// execute query and get result list
		List<Contacts> emails = theQuery.getResultList();
				
		// return the results		
		return emails;
	}

	@Override
	public Blob getPhotoById(int id) {
		String query = "select image from contacts where idcontacts=?";

		Blob photo = jdbcTemp.queryForObject(query, new Object[] { id }, Blob.class);

		return photo;
	}

}
