package com.idt911.cornfield

class Customer {
	
	String username
	String firstName
	String lastName
	String ssn
	String dob
	String externalId

    static constraints = {
		username unique: true
		externalId unique: true
    }
}
