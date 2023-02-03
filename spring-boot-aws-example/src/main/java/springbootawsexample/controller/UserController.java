package springbootawsexample.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import springbootawsexample.model.User;
import springbootawsexample.repository.UserRepository;


@RestController
public class UserController {
	
	@Autowired
	UserRepository repo;
	
	@PostMapping("/user")
	public User save(@RequestBody User user) {
		return repo.save(user);
	}
	
	@GetMapping("/getall")
	public List<User> findAll(){
		return repo.findAll();
	}
	
	
	}

