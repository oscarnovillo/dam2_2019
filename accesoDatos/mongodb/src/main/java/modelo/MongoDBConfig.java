package modelo;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoClientDbFactory;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories(basePackages = "modelo")
public class MongoDBConfig {
  public String getDatabaseName() {
    return "oscar";
  }
  @Bean
  public MongoClient mongoClient() {

    MongoClient client = MongoClients.create("mongodb://dam2.tomcat.iesquevedo.es:3334");
    return client;
  }
  @Bean
  public MongoDbFactory mongoDbFactory() {
    MongoDbFactory factory = new SimpleMongoClientDbFactory(mongoClient(), getDatabaseName());
    return factory;
  }
  @Bean
  public MongoTemplate mongoTemplate() {
    MongoTemplate template = new MongoTemplate(mongoDbFactory());
    return template;
  }
}