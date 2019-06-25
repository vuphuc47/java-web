package models;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserService implements UserDetailsService {
	MemberRepository repository = new MemberRepository();

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Member obj = repository.signIn(username);
		//System.out.println(obj.getId());
		//System.out.println(obj.getPassword());
		if (obj != null) {
			List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
			for (Role role : obj.getRoles()) {
				authorities.add(new SimpleGrantedAuthority(role.getRoleName()));
			}
			//System.out.println(obj.getRoles());
			return new User(obj.getUsername(), obj.getPassword(), true, true, true, true, authorities);
		}
		return null;
	}
}
