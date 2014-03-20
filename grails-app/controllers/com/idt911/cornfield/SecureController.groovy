package com.idt911.cornfield

import grails.plugin.springsecurity.annotation.Secured

class SecureController {

	@Secured(['ROLE_ADMIN'])
    def index() {render 'Secure access only' }
}
