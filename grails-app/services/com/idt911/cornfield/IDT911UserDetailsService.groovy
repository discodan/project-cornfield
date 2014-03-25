package com.idt911.cornfield

import grails.plugin.springsecurity.SpringSecurityUtils
import grails.plugin.springsecurity.userdetails.GrailsUserDetailsService

import org.springframework.security.core.authority.GrantedAuthorityImpl
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UsernameNotFoundException

class IDT911UserDetailsService implements GrailsUserDetailsService {

	/**
    * Some Spring Security classes (e.g. RoleHierarchyVoter) expect at least
    * one role, so we give a user with no granted roles this one which gets
    * past that restriction but doesn't grant anything.
    */
   static final List NO_ROLES = [new GrantedAuthorityImpl(SpringSecurityUtils.NO_ROLE)]

   UserDetails loadUserByUsername(String username, boolean loadRoles)
            throws UsernameNotFoundException {
      return loadUserByUsername(username)
   }

   UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

      ApiUser.withTransaction { status ->

         ApiUser user = ApiUser.findByUsername(username)
         if (!user) throw new UsernameNotFoundException(
                      'User not found', username)

         def authorities = user.authorities.collect {
             new GrantedAuthorityImpl(it.authority)
         }

         return new IDT911UserDetails(user.username, user.password, user.enabled,
            !user.accountExpired, !user.passwordExpired,
            !user.accountLocked, authorities ?: NO_ROLES, user.id,
            "")
      }
   }

}
