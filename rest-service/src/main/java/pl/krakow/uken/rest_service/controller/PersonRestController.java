package pl.krakow.uken.rest_service.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.apache.tomcat.util.json.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.util.JSONPObject;

import pl.krakow.uken.rest_service.model.Person;
import pl.krakow.uken.rest_service.repository.RestPersonRepository;

@RestController
@RequestMapping("api/v1/")
public class PersonRestController {
    
    @Autowired
    RestPersonRepository repository;

    @GetMapping("/all")
    public ResponseEntity<List<Person>> getAllPerson(){
        return ResponseEntity.ok().body(repository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Person> getPersonById(@PathVariable("id") Long id){
        Person p = repository.findById(id).orElse(null);
        return ResponseEntity.ok().body(p);
    }

    @PostMapping("/add")
    public ResponseEntity<String> addPerson(@RequestBody Person p, 
                                    @RequestHeader("api-key") String apiKey){
        // if (repository.findPersonByApiKey(apiKey) != null || apiKey.equals("test")){
        //     p.setCreated_at(LocalDateTime.now());
        //     p.setUpdated_at(LocalDateTime.now());
        //     p.setApiKey(null);
        //     Person svaePerson = repository.save(p);
        //     if (svaePerson != null){
        //         return ResponseEntity.ok().body("Dodano osobę do bazy");
        //     }else{
        //         return ResponseEntity.ok().body("błąd dodania osoby do bazy");
        //     }
        // }else{
            return ResponseEntity.ok().body("Brak dostępu");
        // }
        
    }

    public ResponseEntity<String> sendPersonEmail(@RequestBody Long id){
        String url = "http://localhost:8090/send/"+id;
        return ResponseEntity.ok().body("Brak dostępu");
    }
}
