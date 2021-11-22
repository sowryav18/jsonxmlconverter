package com.abc.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AddressBookWrapper implements Serializable {
	private static final long serialVersionUID = 1L;
	@JsonProperty("AddressBook")
	private AddressBook addressBook;

	public AddressBook getAddressBook() {
		return addressBook;
	}
	public void setAddressBook(AddressBook addressBook) {
		this.addressBook = addressBook;
	}
}
