package springbootawsexample.config;

import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

import com.mongodb.client.MongoClient;


@Component
public class MongoConfig {

//	 @Autowired
//	 private MongoTemplate mongoTemplate;

//	    @PostConstruct
//	    public void createIndexes() {
//	        mongoTemplate.indexOps("users")
//	            .ensureIndex(new Index().on("lastName", Sort.Direction.ASC));
//	    }
//	    @PostConstruct
//	    public void createIndexes1() {
//	        mongoTemplate.indexOps("users")
//	            .ensureIndex(new Index().on("id", Sort.Direction.ASC));
//	    }
	 
	   @Bean
	   public MongoTemplate mongoTemplate(MongoClient mongoClient) {
	     return new MongoTemplate(mongoClient, "Aws");
	   }


}
