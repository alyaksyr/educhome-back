package ci.educhome.web.securities;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import ci.educhome.web.entities.Users;
import ci.educhome.web.services.UserService;

public class UserDetailServiceImpl implements UserDetailsService {
	
	@Autowired
	private UserService userService;

	@Override
	public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
		Users user =userService.findUserByLogin(login);
		if (user==null) {
			throw new UsernameNotFoundException(login);
		}
		List<GrantedAuthority> authorities = user.getRoles().stream().map(role->
			new SimpleGrantedAuthority(role.getName().name())
		).collect(Collectors.toList());
		
		return  new User(user.getLogin(),user.getPassword(),authorities);
	}
	
}
