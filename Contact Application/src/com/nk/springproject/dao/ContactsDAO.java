package com.nk.springproject.dao;

import java.sql.Blob;
import java.util.List;

import com.nk.springproject.entity.Contacts;

public interface ContactsDAO {

public	List<Contacts> getContacts();

public Contacts getContacts(int theId);

public void saveContact(Contacts theContact);

public void deleteContact(int theId);

public List<Contacts> getContact();

public Blob getPhotoById(int id);
}
