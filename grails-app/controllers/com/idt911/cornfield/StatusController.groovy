package com.idt911.cornfield

import grails.plugin.springsecurity.annotation.Secured

@Secured(['ROLE_ADMIN'])
class StatusController {

    def index() { render 'Yes, we are up and running. Thanks for asking. Move Along. ' }
}
