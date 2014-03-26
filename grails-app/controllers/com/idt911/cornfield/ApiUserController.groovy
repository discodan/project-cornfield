package com.idt911.cornfield

import grails.converters.JSON
import grails.converters.XML
import grails.plugin.springsecurity.annotation.Secured
@Secured(['ROLE_ADMIN'])
class ApiUserController {
	
    def index() { render 'superman' }
	
	
	def show() {
		def user = ApiUser.get(params.id)
		render user.username
	}
	
	def update() {
		def user = ApiUser.findByUsername('me')
		render user as XML
	}
	
	def save() {
		
	}
}
