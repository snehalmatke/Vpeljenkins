package springbootawsexample.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import springbootawsexample.model.User;

public interface UserRepository extends MongoRepository<User, Integer>  {
	
	public User save(User user);
	
	
}
