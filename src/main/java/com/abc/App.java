package com.abc;

import java.io.File;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Scanner;

import com.abc.util.ConversionUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

/**
 * Hello world!
 *
 */
public class App 
{
	private static final String xml="<AddressBook>\n"
			+ "	<Contact>\n"
			+ "		<CustomerID>ALFKI</CustomerID>\n"
			+ "		<CompanyName>Alfreds Futterkiste</CompanyName>\n"
			+ "		<ContactName>Maria Anders</ContactName>\n"
			+ "		<ContactTitle>Sales Representative</ContactTitle>\n"
			+ "		<Address>Obere Str. 57</Address>\n"
			+ "		<City>Berlin</City>\n"
			+ "		<Email>dummy@gmail.com</Email>\n"
			+ "		<PostalCode>12209</PostalCode>\n"
			+ "		<Country>Germany</Country>\n"
			+ "		<Phone>030-0074321</Phone>\n"
			+ "		<Fax>030-0076545</Fax>\n"
			+ "	</Contact>\n"
			+ "	<Contact>\n"
			+ "		<CustomerID>ANATR</CustomerID>\n"
			+ "		<CompanyName>Ana Trujillo Emparedados y helados</CompanyName>\n"
			+ "		<ContactName>Ana Trujillo</ContactName>\n"
			+ "		<ContactTitle>Owner</ContactTitle>\n"
			+ "		<Address>Avda. de la Constitución 2222</Address>\n"
			+ "		<City>México D.F.</City>\n"
			+ "		<Email>dummy@gmail.com</Email>\n"
			+ "		<PostalCode>05021</PostalCode>\n"
			+ "		<Country>Mexico</Country>\n"
			+ "		<Phone>(5) 555-4729</Phone>\n"
			+ "		<Fax>(5) 555-3745</Fax>\n"
			+ "	</Contact>"
			+ "</AddressBook>";
	
	private static String xml2 ="	<Contact>\n"
			+ "		<CustomerID>ANATR</CustomerID>\n"
			+ "		<CompanyName>Ana Trujillo Emparedados y helados</CompanyName>\n"
			+ "		<ContactName>Ana Trujillo</ContactName>\n"
			+ "		<ContactTitle>Owner</ContactTitle>\n"
			+ "		<Address>Avda. de la Constitución 2222</Address>\n"
			+ "		<City>México D.F.</City>\n"
			+ "		<Email>dummy@gmail.com</Email>\n"
			+ "		<PostalCode>05021</PostalCode>\n"
			+ "		<Country>Mexico</Country>\n"
			+ "		<Phone>(5) 555-4729</Phone>\n"
			+ "		<Fax>(5) 555-3745</Fax>\n"
			+ "	</Contact>";
	
	private static String json1="{\"AddressBook\":{\"Contact\":[{\"CustomerID\":\"ALFKI\",\"CompanyName\":\"Alfreds Futterkiste\",\"ContactName\":\"Maria Anders\",\"ContactTitle\":\"Sales Representative\",\"Address\":\"Obere Str. 57\",\"City\":\"Berlin\",\"Email\":\"dummy@gmail.com\",\"PostalCode\":\"12209\",\"Country\":\"Germany\",\"Phone\":\"030-0074321\",\"Fax\":\"030-0076545\"},{\"CustomerID\":\"ANATR\",\"CompanyName\":\"Ana Trujillo Emparedados y helados\",\"ContactName\":\"Ana Trujillo\",\"ContactTitle\":\"Owner\",\"Address\":\"Avda. de la Constitución 2222\",\"City\":\"México D.F.\",\"Email\":\"dummy@gmail.com\",\"PostalCode\":\"05021\",\"Country\":\"Mexico\",\"Phone\":\"(5) 555-4729\",\"Fax\":\"(5) 555-3745\"}]}}\n"
			+ "";
	
    public static void main( String[] args ) throws IOException
    {
        System.out.println( "1. Convert XML to JSON" );
        System.out.println( "2. Convert JSON to XML" );
        System.out.println( "3. Exit" );
        Scanner scanner = new Scanner(System.in);
        try {
            while (true) {
                System.out.println("Please choose your option");
                String option = scanner.nextLine();
                if(option.equalsIgnoreCase("1")) {
                    System.out.println("Provide XML file path");
                    String filePath=scanner.nextLine();
                    System.out.println(ConversionUtil.convertXMLToJSON(new File(filePath)));
                    System.exit(0);
                }else if(option.equalsIgnoreCase("2")) {
                    System.out.println("Provide JSON file path");
                    String filePath=scanner.nextLine();
                    System.out.println(ConversionUtil.convertJSONToXML(new File(filePath)));
                    System.exit(0);
                }else {
                	System.exit(0);
                }
            }
        } catch(IllegalStateException | NoSuchElementException e) {
            System.out.println("System.in was closed; exiting");
        }
    }
}
