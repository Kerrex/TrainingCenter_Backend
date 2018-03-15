package pl.kerrex.trainingcenterbackend.Service.Impl

import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.userdetails.UsernameNotFoundException
import pl.kerrex.trainingcenterbackend.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.crypto.password.StandardPasswordEncoder
import org.springframework.security.provisioning.UserDetailsManager
import org.springframework.stereotype.Component
import pl.kerrex.trainingcenterbackend.Service.CustomUserDetailsManager
import pl.kerrex.trainingcenterbackend.dto.UserDTO
import pl.kerrex.trainingcenterbackend.repository.RoleRepository
import java.util.*


@Component
class AppUserDetailsService(private val userRepository: UserRepository,
                            private val roleRepository: RoleRepository) : UserDetailsManager, CustomUserDetailsManager {
    override fun createUser(user: UserDTO) {
        val encryptedPassword = StandardPasswordEncoder().encode(user.password)
        val newUser = pl.kerrex.trainingcenterbackend.domain.User()
        newUser.firstName = user.firstName
        newUser.lastName = user.lastName
        newUser.username = user.username
        newUser.email = user.email
        newUser.roles = mutableListOf(roleRepository.findByRoleName("STANDARD_USER"))
        newUser.password = encryptedPassword

        userRepository.save(newUser)
    }

    override fun userExists(username: String): Boolean {
        val userByUsername = userRepository.findByUsername(username)
        return userByUsername != null
    }

    override fun updateUser(user: UserDetails?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun createUser(user: UserDetails) {
        throw NotImplementedError("Don't use this method, please")
    }

    override fun deleteUser(username: String?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun changePassword(oldPassword: String?, newPassword: String?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    @Throws(UsernameNotFoundException::class)
    override fun loadUserByUsername(username: String): UserDetails {
        val userByUsername = userRepository.findByUsername(username)
        val userByEmail = userRepository.findByEmail(username)

        val user = userByUsername ?: userByEmail
        val authorities = ArrayList<GrantedAuthority>()
        user?.roles?.forEach { role -> authorities.add(SimpleGrantedAuthority(role.roleName)) }

        if (user == null) {
            throw UsernameNotFoundException("User $username not found!")
        }

        return User(user.username, user.password, authorities)
    }
}