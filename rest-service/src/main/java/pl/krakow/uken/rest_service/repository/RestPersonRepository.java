package pl.krakow.uken.rest_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.krakow.uken.rest_service.model.Person;

public interface RestPersonRepository extends JpaRepository<Person, Long>{

    Object findPersonByApiKey(String apiKey);
    
}
