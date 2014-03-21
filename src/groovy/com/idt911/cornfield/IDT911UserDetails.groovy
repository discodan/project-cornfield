package com.idt911.cornfield

import grails.plugin.springsecurity.userdetails.GrailsUser

import org.springframework.security.core.GrantedAuthority

class IDT911UserDetails extends GrailsUser {

	final String fullName

	IDT911UserDetails(String username, String password, boolean enabled,
		boolean accountNonExpired, boolean credentialsNonExpired,
		boolean accountNonLocked,
		Collection<GrantedAuthority> authorities,
		long id, String fullName) 
	{
		super(username, password, enabled, accountNonExpired,
			credentialsNonExpired, accountNonLocked, authorities, id)

		this.fullName = fullName
	}

	static constraints = {
	}
}
