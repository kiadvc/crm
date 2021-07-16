package ch.zli3.ksh18a.andkli.crm.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import ch.zli3.ksh18a.andkli.crm.model.AppUser;
import ch.zli3.ksh18a.andkli.crm.model.AppUserImpl;

public interface UserRepository extends CrudRepository<AppUserImpl, Long>{

	
	default AppUser insertUser(String userName, String password, List<String> roles) {
		return save(new AppUserImpl(userName, password, roles));
	}

	Optional<AppUser> findByUserName(String userName);
	
	default AppUser setRoles(AppUser user, List<String> roles) {
		return save(((AppUserImpl)user).setRoles(roles));
	}
}
