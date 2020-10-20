package com.peru.associations;

import java.util.Date;
import java.util.HashSet;
import java.util.Optional;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.peru.associations.manytomany.entities.Programmer;
import com.peru.associations.manytomany.entities.Project;
import com.peru.associations.manytomany.repos.ProgrammerRepository;
import com.peru.associations.onetomany.entities.Customer;
import com.peru.associations.onetomany.entities.PhoneNumber;
import com.peru.associations.onetomany.repos.CustomerRepository;
import com.peru.associations.onetoone.entities.License;
import com.peru.associations.onetoone.entities.Person;
import com.peru.associations.onetoone.repos.LicenseRepository;

@SpringBootTest
class AssociationsApplicationTests {
	
	@Autowired
	CustomerRepository customerRepository;
	
	@Autowired
	ProgrammerRepository programmerRepository;
	
	@Autowired
	LicenseRepository licenseRepository;

	//@Test
	public void testCreateCustomer() {
		Customer c = new Customer();
		c.setName("Perumal");
		PhoneNumber p1 = new PhoneNumber();
		p1.setNumber(912349);
		p1.setType("Home");
		
		PhoneNumber p2 = new PhoneNumber();
		p2.setNumber(12345);
		p2.setType("office");
		
	
		c.addPhoneNumber(p1);
		c.addPhoneNumber(p2);
		customerRepository.save(c);
	}
	
	
	//@Test
	//@Transactional //to enable lazy loading
	public void testLoadCustomer() {
		 Customer customer = customerRepository.findById(1).get();
		 System.out.println("Customer --> "+customer.getName());
		 customer.getNumber().forEach(p -> System.out.println(p.getNumber()));
	}
	
	//@Test
	public void testMtoMProgrammer() {
		Programmer p = new Programmer();
		p.setName("Perumal");
		p.setSalary(1000);
		HashSet<Project> projects = new HashSet<Project>();
		Project project = new Project();
		project.setName("TGP");
		projects.add(project);
		p.setProjects(projects);
		programmerRepository.save(p);
	}
	
	//@Test
	//@Transactional
	public void testLoadProgrammer() {
		Programmer programmer = programmerRepository.findById(5).get();
		System.out.println(programmer);
		System.out.println(programmer.getProjects());
	}
	
	@Test
	public void testOnetoOneCreate() {
		License l = new License();
		l.setType("CAR");
		l.setValidFrom(new Date());
		l.setValidTo(new Date());
		Person person = new Person();
		person.setFirstName("Perumal");
		person.setLastName("Ramesh");
		person.setAge(26);
		l.setPerson(person);
		licenseRepository.save(l);
		
	}
	
	
	

}
