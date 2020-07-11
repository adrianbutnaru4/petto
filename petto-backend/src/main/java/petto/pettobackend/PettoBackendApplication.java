package petto.pettobackend;

import io.github.kaiso.relmongo.config.EnableRelMongo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@EnableMongoRepositories
@EnableRelMongo
@SpringBootApplication
public class PettoBackendApplication {

  public static void main(String[] args) {
    SpringApplication.run(PettoBackendApplication.class, args);
  }
}
