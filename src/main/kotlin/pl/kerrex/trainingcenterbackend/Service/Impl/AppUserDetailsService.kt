package pl.kerrex.trainingcenterbackend.Service.Impl

import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.authority.SimpleGrantedAuthority
import java.util.ArrayList
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.userdetails.UsernameNotFoundException
import pl.kerrex.trainingcenterbackend.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Component


@Component
class AppUserDetailsService : UserDetailsService {
    @Autowired
    private val userRepository: UserRepository? = null

    @Throws(UsernameNotFoundException::class)
    override fun loadUserByUsername(s: String): UserDetails {
        val user = userRepository!!.findByUsername(s)

        val authorities = ArrayList<GrantedAuthority>()
        user.roles?.forEach { role -> authorities.add(SimpleGrantedAuthority(role.roleName)) }

        return User(user.username, user.password, authorities)
    }
}