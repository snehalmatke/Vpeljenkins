package springbootawsexample.model;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection ="instance")
public class User {


	private int id;
	private String lastName;
	private String firstName;
	private String emailId;
}
