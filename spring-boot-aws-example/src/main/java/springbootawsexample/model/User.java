package springbootawsexample.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection ="instance")
public class User {

	@Id
	@Indexed
	private int id;
	
	@Indexed
	private String lastName;

	private String firstName;

	private String emailId;
	
	private int age;
	
}