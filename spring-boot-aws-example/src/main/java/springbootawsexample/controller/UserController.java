package springbootawsexample.controller;

import java.util.List;

import javax.print.attribute.standard.DocumentName;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.aggregation.GroupOperation;
import org.springframework.data.mongodb.core.aggregation.MatchOperation;
import org.springframework.data.mongodb.core.aggregation.SortOperation;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.websocket.server.PathParam;
import springbootawsexample.model.AgeClass;
import springbootawsexample.model.User;
import springbootawsexample.repository.UserRepository;

@RestController
public class UserController {

	@Autowired
	MongoTemplate mongoTemplate;

	@Autowired
	MongoOperations mongoOperations;

	@Autowired
	UserRepository repo;

	@PostMapping("/user")
	public User save(@RequestBody User user) {
		return repo.save(user);

	}

	public List<User> findAll() {
		return repo.findAll();
	}

	@PostMapping("ty")
	public String save1() {
		User user = new User();
		for (int i = 1; i < 1000; i++) {
			user.setId(i);
			user.setFirstName("snehal" + i);
			user.setLastName("matke" + i);
			user.setEmailId("@abc" + i);
			user.setAge(1 + i);
			save(user);
		}
		return " done";
	}

	@GetMapping("get")
	public User get(@RequestParam("emailId") String emailId) {
		return repo.findByEmailId(emailId);
	}

	@GetMapping("get1")
	public User get1(@RequestParam("lastName") String lastName) {
		return repo.findByLastName(lastName);
	}

	@GetMapping("get2")
	public User get2(@RequestParam("id") int id) {
		return repo.findById(id).get();
	}

	@GetMapping("get/age")
	List<User> getByAgeMatch(@PathParam("age") int age) {

		// group
		GroupOperation groupByDpt = Aggregation.group("age").count().as("age");
		System.out.print(groupByDpt);
		// matchoperation
		MatchOperation matchOperation = Aggregation.match(new Criteria("age").gt(67));
		System.out.println(matchOperation);
		// sortOperation
		SortOperation sortOperation = Aggregation.sort(Sort.by(Sort.Direction.DESC, "age"));
		System.out.println(sortOperation);
		// Aggregation
		Aggregation aggregation = Aggregation.newAggregation(sortOperation);
		System.out.println(sortOperation);
		AggregationResults output = mongoTemplate.aggregate(aggregation, "instance", User.class);
		return output.getMappedResults();

	}
	
	
//	@GetMapping("/explainQuery")
//	  public String explainQuery1() {
//	    return userService.explainQuery();
//	  }
	
	

	public String explainQuery() {
	    Query query = new Query(Criteria.where("age").is(30));
	    query.fields().include("_id").include("firstName");
	    
	    Document explainOutput = mongoOperations.executeCommand(new Document("explain", new Document("find", "users")
	    .append("filter", query.getQueryObject())
	    .append("projection", query.getFieldsObject())
	    .append("verbosity", "allPlansExecution")));
	    		
	    return "explainOutput";
	   
	}
	
}
