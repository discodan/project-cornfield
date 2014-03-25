package com.idt911.cornfield

import grails.converters.JSON
import grails.converters.XML
import grails.plugin.springsecurity.annotation.Secured
@Secured(['ROLE_ADMIN'])
class CustomerController {

	def index() { }

	def save() {
		def format = request.format
		def acceptHeader = request.getHeader('Accept').toString()
		def customer
		if (format == 'json') {
			def json = request.JSON
			customer = new Customer(json)
			customer.externalId = params.id
			customer.save(flush: true, failOnError: true)
		} else if (format == 'xml') {
			def xml = request.XML
			def dob = xml.dob.text();
			customer = new Customer(externalId: params.id, dob: xml.dob.text(), firstName: xml.firstName.text(), 
				lastName: xml.lastName.text(), ssn: xml.ssn.text(), username: xml.username.text())
			customer.save(flush: true, failOnError: true)
		}
		
		if (acceptHeader.contains('json')) {
			render customer as JSON
		} else if (acceptHeader.contains('xml')) {
			render customer as XML
		}
	}

	def show() {
		def customer = Customer.findByExternalId(params.id)
		def format = request.format
		def acceptHeader = request.getHeader('Accept').toString()
		if (acceptHeader.contains('json')) {
			render customer as JSON
		} else if (acceptHeader.contains('xml')) { 
			render customer as XML
		} else {
			render customer as XML
		}
		
	}
}
