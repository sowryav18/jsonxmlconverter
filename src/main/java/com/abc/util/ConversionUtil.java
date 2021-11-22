package com.abc.util;

import java.io.File;
import java.io.IOException;

import com.abc.model.AddressBook;
import com.abc.model.AddressBookWrapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

public class ConversionUtil {

	public static String convertXMLToJSON(String xml) throws JsonMappingException, JsonProcessingException {
		XmlMapper xmlMapper = new XmlMapper();
		AddressBook addressBook = xmlMapper.readValue(xml, AddressBook.class);
//		Contact contact=xmlMapper.readValue(xml, Contact.class);
		ObjectMapper mapper = new ObjectMapper();
		mapper.enable(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT);
		mapper.enable(SerializationFeature.WRAP_ROOT_VALUE);
		mapper.enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);
		return mapper.writeValueAsString(addressBook);
	}
	
	public static String convertXMLToJSON(File xml) throws IOException {
		XmlMapper xmlMapper = new XmlMapper();
		AddressBook addressBook = xmlMapper.readValue(xml, AddressBook.class);
		ObjectMapper mapper = new ObjectMapper();
		mapper.enable(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT);
		mapper.enable(SerializationFeature.WRAP_ROOT_VALUE);
		mapper.enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);
		return mapper.writeValueAsString(addressBook);
	}

	public static String convertJSONToXML(String json) throws JsonMappingException, JsonProcessingException {
		ObjectMapper jsonMapper = new ObjectMapper();
		jsonMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		AddressBookWrapper addressBook = jsonMapper.readValue(json, AddressBookWrapper.class);
		XmlMapper xmlMapper = new XmlMapper();
		xmlMapper.enable(DeserializationFeature.UNWRAP_ROOT_VALUE);
//		xmlMapper.configure(DeserializationConfig.Feature.UNWRAP_ROOT_VALUE, true);
		return xmlMapper.writeValueAsString(addressBook.getAddressBook());
	}
	
	public static String convertJSONToXML(File json) throws IOException {
		ObjectMapper jsonMapper = new ObjectMapper();
		jsonMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		AddressBookWrapper addressBook = jsonMapper.readValue(json, AddressBookWrapper.class);
		XmlMapper xmlMapper = new XmlMapper();
		xmlMapper.enable(DeserializationFeature.UNWRAP_ROOT_VALUE);
		return xmlMapper.writeValueAsString(addressBook.getAddressBook());
	}

}
