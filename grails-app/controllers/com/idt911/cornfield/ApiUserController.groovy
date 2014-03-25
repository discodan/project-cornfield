package com.idt911.cornfield

import grails.converters.JSON
import grails.converters.XML
import grails.plugin.springsecurity.annotation.Secured
@Secured(['ROLE_ADMIN'])
class ApiUserController {
	
    def index() { render 'superman' }
	
	
	def show() {
		def user = ApiUser.get(params.id)
		def newUser = new ApiUser(JSON.parse('{"id":3,"accountExpired":false,"accountLocked":false,"enabled":true,"password":"$2a$10$gRyuM0mjBRn8kmzJoY2fWeh3HSCcMfkgRDnlxDrJOU1peFRqUfHmS","passwordExpired":false,"username":"me"}'))
		render newUser as JSON
	}
	
	def update() {
		def user = ApiUser.findByUsername('me')
		render user as XML
	}
	
	def save() {
		
	}
}
