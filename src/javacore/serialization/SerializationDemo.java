package javacore.serialization;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SerializationDemo {
	public static void main(String[] args) {
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		Date dob = null;
		try {
			dob = df.parse("04/04/2015");
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		Address address = new Address("#34", "ABC Street", "New Delhi", "Delhi", "India");
		Person person = new Person("User1", dob, 2, address);
		// file name
		final String fileName = "D://person.ser";
		// serializing
		Util.serialzeObject(person, fileName);

		try {
			person = (Person) Util.deSerialzeObject(fileName);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("deserialized object ---- ");
		System.out.println("Name " + person.getName());
		System.out.println("DOB " + person.getDob());
		System.out.println("Age " + person.getAge());
		System.out.println("Address Line1 " + person.getAddress().getAddressLine1());
		System.out.println("Address Line2 " + person.getAddress().getAddressLine2());
		System.out.println("City " + person.getAddress().getCity());
		System.out.println("State " + person.getAddress().getState());
		System.out.println("Country " + person.getAddress().getCountry());

	}
}
