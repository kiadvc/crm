package ch.zli3.ksh18a.andkli.crm.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Entity(name = "User")
@SuppressWarnings("serial")
public class AppUserImpl implements AppUser {

	@Id
	@GeneratedValue
	private Long id;
	public String userName;
	public String passwordHash;
	
	@ElementCollection(fetch=FetchType.EAGER)
	//For simple types only, no Role objects allowed
	private Set<String> roles;
	
	@OneToMany(mappedBy = "hirer", cascade = CascadeType.DETACH)
	private List<BoatImpl> boats;

	@Override
	public Long getId() {
		return id;
	}

	protected AppUserImpl() {
	} // For JPA only

	public AppUserImpl(String userName, String password, List<String> roles) {
		this.userName = userName;
		setPassword(password);
		this.roles = new HashSet<>(roles);
	}
	
	public AppUserImpl setRoles(List<String> roles) {
        this.roles = new HashSet<>(roles);
        return this;
    }
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return roles.stream()
		.map(role -> new SimpleGrantedAuthority(role))
		.collect(Collectors.toList());
	}
	
	@Override
	public List<String> getRoles(){
		return new ArrayList<>(roles);
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return passwordHash;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return userName;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

	private void setPassword(String password) {
		BCryptPasswordEncoder pwe = new BCryptPasswordEncoder();
		passwordHash = pwe.encode(password);
	}
	@Override
	public List<Boat> getBoats() {
		// TODO Auto-generated method stub
		return boats.stream().collect(Collectors.toList());
	}

}
