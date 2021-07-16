package ch.zli3.ksh18a.andkli.crm.data;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import ch.zli3.ksh18a.andkli.crm.repository.UserRepository;
import ch.zli3.ksh18a.andkli.crm.roles.AppRoles;

@Component
public class Initializer implements ApplicationRunner{

	@Autowired
	UserRepository userRepository;
	@Override
	public void run(ApplicationArguments args) throws Exception {
		List<String> admin = new ArrayList<>();
		admin.add(AppRoles.admin);
		userRepository.insertUser("admin", "admin", admin);
		
		List<String> user = new ArrayList<>();
		user.add(AppRoles.user);
		userRepository.insertUser("user", "user", user);
		
		List<String> usemin = new ArrayList<>();
		usemin.add(AppRoles.admin);
		usemin.add(AppRoles.user);
		userRepository.insertUser("usemin", "usemin", usemin);
		
	}
	
}
