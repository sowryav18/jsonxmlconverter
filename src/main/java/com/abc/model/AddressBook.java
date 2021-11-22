package com.abc.model;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JacksonXmlRootElement(localName = "AddressBook")
@JsonIgnoreProperties
public class AddressBook implements Serializable {
	private static final long serialVersionUID = 1L;
	@JacksonXmlElementWrapper(useWrapping = false)
	@JsonProperty("Contact")
	List<Contact> contact;

	public List<Contact> getContact() {
		return contact;
	}

	public void setContact(List<Contact> contact) {
		this.contact = contact;
	}

}
