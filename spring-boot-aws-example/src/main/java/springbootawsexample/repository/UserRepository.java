package springbootawsexample.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;

import springbootawsexample.model.User;

public interface UserRepository extends MongoRepository<User, Integer>  {
	
	public User findByLastName(String lastName);

	//public User findByEmailIdAndLastName(String emailId);

	public User findByEmailId(String emailId);
	
	@Aggregation("{ $unwind: '$age' }, { $group: { _id: '$firstName', totalage: { $min: '$age.count' } } }")
	public List<User> findByAge(int age);
	
	
}
