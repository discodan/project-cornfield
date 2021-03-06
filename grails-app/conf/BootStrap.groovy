import com.idt911.cornfield.Role
import com.idt911.cornfield.ApiUser
import com.idt911.cornfield.UserRole

class BootStrap {

    def init = { servletContext ->
		def adminRole = new Role(authority: 'ROLE_ADMIN').save(flush: true)
		def userRole = new Role(authority: 'ROLE_USER').save(flush: true)
  
		def testUser = new ApiUser(username: 'me', password: 'password')
		testUser.save(flush: true)
  
		UserRole.create testUser, adminRole, true
  
		assert ApiUser.count() == 1
		assert Role.count() == 2
		assert UserRole.count() == 1
    }
    def destroy = {
    }
}
