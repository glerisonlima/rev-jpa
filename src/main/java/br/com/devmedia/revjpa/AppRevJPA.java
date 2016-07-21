package br.com.devmedia.revjpa;

import java.util.Arrays;
import java.util.List;

import br.com.devmedia.revjpa.dao.DocumentDAO;
import br.com.devmedia.revjpa.dao.PersonDAO;
import br.com.devmedia.revjpa.dao.PhoneDAO;
import br.com.devmedia.revjpa.entity.Document;
import br.com.devmedia.revjpa.entity.Person;
import br.com.devmedia.revjpa.entity.Phone;
import br.com.devmedia.revjpa.entity.Phone.TypePhone;

/**
 * Hello world!
 *
 */
public class AppRevJPA
{
    public static void main( String[] args ){
        System.out.println( "Hello World!" );
        
        //insertPerson();
        //findPersonById();
        //findAllPersons();
        //countPersons();
        //findByLastName();
        //findByAge();
        //findByFullName();
        //updatePerson();
        //deletePerson();
        
        //insertDocument();
        //updateDocument();
        //findPersonByCpf();
        
        //insertPhone();
        //insertPhoneByPerson();
        //updatePhone();
        //updatePhoneByPerson();
        deleteOnCascade();
        
    }

	private static void deleteOnCascade() {
		new PersonDAO().delete(9L);
	}

	private static void updatePhoneByPerson() {
		Person person = new PersonDAO().findById(9L);
		for (Phone phone: person.getPhones()){
			System.out.println("| - "+phone.toString());
			if(TypePhone.COMERCIAL == phone.getType()){
				phone.setType(TypePhone.RESIDENCIAL);
			}
		}
		new PersonDAO().update(person);
		
		for (Phone phone: person.getPhones()){
			System.out.println("2 - "+phone.toString());			
		}
	}

	private static void updatePhone() {
		Person person = new PersonDAO().findById(9L);
		
		PhoneDAO dao = new PhoneDAO();
		
		Phone phone = new PhoneDAO().findById(3L);
		phone.setPerson(person);
		dao.update(phone);
		
		phone = dao.findById(phone.getId());
		System.out.println(phone.toString());
	}

	private static void insertPhoneByPerson() {
		Phone ph1 = new Phone(TypePhone.CELULAR, "87235955");
		Phone ph2 = new Phone(TypePhone.COMERCIAL, "32968388");
		
		Person person = new Person();
		person.setFistName("Gabriel");
		person.setLastName("Lima");
		person.setAge(6);
		person.setDocument(new Document("445.256.365-14", 400222359));
		
		//ph1.setPerson(person);
		//ph2.setPerson(person);
		//person.setPhones(Arrays.asList(ph1,ph2));
		
		person.addPhone(ph1);
		person.addPhone(ph2);
		new PersonDAO().save(person);
		
	}

	private static void insertPhone() {
		Person person = new Person();
		person.setFistName("Gilson");
		person.setLastName("Figueira");
		person.setAge(28);
		person.setDocument(new Document("145.256.365-14", 100222359));
		Phone phone = new Phone(TypePhone.CELULAR, "87235908");
		phone.setPerson(person);
		PhoneDAO dao = new PhoneDAO();
		
		dao.save(phone);
		
		phone = dao.findById(phone.getId());
		System.out.println(phone.toString());
	}

	private static void findPersonByCpf() {
		Person p = new PersonDAO().findByCpf("789.456.122-44");
		
		System.out.println(p.toString());
	}

	private static void updateDocument() {
		Document doc = new DocumentDAO().findById(1L);
		System.out.println(doc.toString());
		
		doc.setCpf("789.456.122-44");
		new DocumentDAO().update(doc);
		
		System.out.println(new DocumentDAO().findById(1L).toString());
		
	}

	private static void insertDocument() {
		
		Person p1 = new Person();
		p1.setFistName("Aline");
		p1.setLastName("de Sousa");
		p1.setAge(24);
		p1.setDocument(new Document("123.456.789-99", 123456789));
		
		new PersonDAO().save(p1);
		
		System.out.println(p1.toString());
	}

	private static void deletePerson() {
		new PersonDAO().delete(3L);
	}

	private static void updatePerson() {
		Person p1 = new PersonDAO().findById(3L);
		System.out.println(p1.toString());
		
		p1.setLastName("Ferreira");
		new PersonDAO().update(p1);
		Person p2 = new PersonDAO().findById(3L);
		System.out.println(p2.toString());
	}

	private static void findByFullName() {
		Person person = new PersonDAO().findByFullName("Glerison", "Lima");
		System.out.println(person.toString());	
	}

	private static void findByAge() {
		List<Person> persons = new PersonDAO().findAgeIsBetween(27, 60);
				
		for (Person person: persons){
			System.out.println(person.toString());		
		}
	}

	private static void findByLastName() {
		List<Person> persons = new PersonDAO().findByLastName("Silva");
		
		for (Person person: persons){
			System.out.println(person.toString());		
		}
	}

	private static void countPersons() {
		long total = new PersonDAO().count();
		System.out.println("Total of Persons: "+total);		
	}

	private static void findAllPersons() {
		List<Person> persons = new PersonDAO().findAll();
		
		for (Person p : persons){
			System.out.println(p.toString());
		}
	}

	private static void findPersonById() {
		Person p1 = new PersonDAO().findById(2L);
		Person p2 = new PersonDAO().findById(4L);
		
		System.out.println(p1.toString());
		System.out.println(p2.toString());
		
		
	}

	private static void insertPerson() {
		Person p1 = new Person();
		p1.setFistName("Gilberto");
		p1.setLastName("Roges");
		p1.setAge(45);
		
		new PersonDAO().save(p1);
		System.out.println(p1.toString());
				
		Person p2 = new Person();
		p2.setFistName("Armando");
		p2.setLastName("Silva");
		p2.setAge(35);
		
		new PersonDAO().save(p2);
		System.out.println(p2.toString());
		
		Person p3 = new Person();
		p3.setFistName("Carlos");
		p3.setLastName("Rodrigues");
		p3.setAge(26);
		
		new PersonDAO().save(p3);
		System.out.println(p3.toString());
		
		
		
	}
}
