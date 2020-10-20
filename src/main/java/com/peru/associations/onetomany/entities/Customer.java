package com.peru.associations.onetomany.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	
	@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<PhoneNumber> number;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Set<PhoneNumber> getNumber() {
		return number;
	}
	public void setNumber(Set<PhoneNumber> number) {
		this.number = number;
	}
	
	public void addPhoneNumber(PhoneNumber pn) {
		if(pn != null) {
			if(number==null) {
				number = new HashSet<PhoneNumber>();
			}
			pn.setCustomer(this);
			number.add(pn);
			
			
		}
	}

}
