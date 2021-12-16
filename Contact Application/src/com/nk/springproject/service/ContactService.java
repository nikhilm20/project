package com.nk.springproject.service;

import java.util.List;

import com.nk.springproject.entity.Contacts;

public interface ContactService {



public List<Contacts> getContacts();

public Contacts getContacts(int theId);

public void saveContact(Contacts theContact);

public void deleteContact(int theId);

public List<Contacts> getContact();

}
