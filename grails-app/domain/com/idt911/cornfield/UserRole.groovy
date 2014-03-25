package com.idt911.cornfield

import org.apache.commons.lang.builder.HashCodeBuilder

class UserRole implements Serializable {

	private static final long serialVersionUID = 1

	ApiUser user
	Role role

	boolean equals(other) {
		if (!(other instanceof UserRole)) {
			return false
		}

		other.user?.id == user?.id &&
			other.role?.id == role?.id
	}

	int hashCode() {
		def builder = new HashCodeBuilder()
		if (user) builder.append(user.id)
		if (role) builder.append(role.id)
		builder.toHashCode()
	}

	static UserRole get(long userId, long roleId) {
		UserRole.where {
			user == ApiUser.load(userId) &&
			role == Role.load(roleId)
		}.get()
	}

	static UserRole create(ApiUser user, Role role, boolean flush = false) {
		new UserRole(user: user, role: role).save(flush: flush, insert: true)
	}

	static boolean remove(ApiUser u, Role r, boolean flush = false) {

		int rowCount = UserRole.where {
			user == ApiUser.load(u.id) &&
			role == Role.load(r.id)
		}.deleteAll()

		rowCount > 0
	}

	static void removeAll(ApiUser u) {
		UserRole.where {
			user == ApiUser.load(u.id)
		}.deleteAll()
	}

	static void removeAll(Role r) {
		UserRole.where {
			role == Role.load(r.id)
		}.deleteAll()
	}

	static mapping = {
		id composite: ['role', 'user']
		version false
	}
}
