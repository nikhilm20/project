package com.nk.springproject.controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.nk.springproject.dao.ContactsDAO;
import com.nk.springproject.entity.Contacts;
import com.nk.springproject.service.ContactService;




@Controller
@RequestMapping("/contact")
public class UserController {
	
	
	@Autowired
	private ContactService contactService;

	
	@Autowired
	private ContactsDAO contactDao;
	


	@GetMapping("/list")
	public String listContacts(Model theModel) {
		
		// get contacts from the dao
				List<Contacts> theContacts = contactService.getContacts();
				
						
				// add the contacts to the model
				theModel.addAttribute("contacts", theContacts);
		
		return "list-contacts";
	}
	
	@GetMapping("/sortedlist")
	public String listSortedContacts(Model theModel) {
		
		// get contacts from the dao
				List<Contacts> theContacts = contactService.getContact();
				
						
				// add the contacts to the model
				theModel.addAttribute("contacts", theContacts);
		
		return "list-contacts";
	}

	@GetMapping(value = "/getContactPhoto/{id}")
	public void getContactPhoto(HttpServletResponse response, @PathVariable("id") int id) throws Exception {
		response.setContentType("image/jpeg");

		Blob ph = contactDao.getPhotoById(id);

		byte[] bytes = ph.getBytes(1, (int) ph.length());
		InputStream inputStream = new ByteArrayInputStream(bytes);
		IOUtils.copy(inputStream, response.getOutputStream());
	}
	
	
	
	
	
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		
		// create model attribute to bind form data
		Contacts theContact = new Contacts();
		
		theModel.addAttribute("contact", theContact);
		
		return "compose-form";
	}
	@PostMapping("/saveContact")
	public String saveContact(@ModelAttribute("email") Contacts theContact) {
		
		// save the contact using our service
		contactService.saveContact(theContact);
		
		
		return "redirect:/contact/list";
	}
	
//	@PostMapping("/saveContact")
//	public String saveContact(@ModelAttribute("contact") Contacts theContact ,HttpServletRequest request, final @RequestParam(required=false,name="id") MultipartFile[] attachFileObj) throws IllegalStateException, IOException {
//		
//		
//		 if ((attachFileObj != null) && (attachFileObj.length > 0) && (!attachFileObj.equals(""))) {
//	            for (MultipartFile aFile : attachFileObj) {
//	                if(aFile.isEmpty()) {
//	                    continue;
//	                } else {
//	                     
//	                    	theContact = new Contacts();
//	                        
//	                    	theContact.setImage(aFile.getBytes());
//	                     
//	                }
//	            }
//		 }
//	                    	contactService.saveContact(theContact);
//	                    	return "redirect:/contact/list";   
//	               
//	        
//	}
		
	
		
		
	
	

	@GetMapping("/showFormForupdate")
	public String showFormForUpdate(@RequestParam("customerId") int theId,
									Model theModel) {
		
		// get the contact from our service
		Contacts theContacts = contactService.getContacts(theId);	
		
		// set contact as a model attribute to pre-populate the form
		theModel.addAttribute("contact", theContacts);
		
		// send over to our form		
		return "compose-form";
	}
	@GetMapping("/delete")
	public String deleteEmail(@RequestParam("customerId") int theId) {
		
		// delete the contact
		contactService.deleteContact(theId);
		
		return "redirect:/contact/list";
	}
	

}


