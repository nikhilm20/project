package com.nk.springproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nk.springproject.dao.ContactsDAO;
import com.nk.springproject.entity.Contacts;
@Service
public class ContactServiceImpl implements ContactService{
	@Autowired
	private ContactsDAO contactDAO;
	@Override
	
	@Transactional
	public List<Contacts> getContacts() {
	 
				return contactDAO.getContacts();
		
	}
	@Override
	@Transactional
	public Contacts getContacts(int theId) {
		return contactDAO.getContacts(theId);
	}
	@Override
	@Transactional
	public void saveContact(Contacts theContact) {
		// TODO Auto-generated method stub
		contactDAO.saveContact(theContact);
	}
	@Override
	@Transactional
	public void deleteContact(int theId) {
		// TODO Auto-generated method stub
		contactDAO.deleteContact(theId);
	}
	@Override
	public List<Contacts> getContact() {
		// TODO Auto-generated method stub
		return contactDAO.getContact();
	}

}
