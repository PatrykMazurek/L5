package pl.krakow.uken.mail_service.controller;

import java.time.LocalDateTime;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pl.krakow.uken.mail_service.model.PersonMail;
import pl.krakow.uken.mail_service.repository.PersonMailRepository;

@RestController
@RequestMapping("/mail")
public class MailController {
    
    @Autowired
    PersonMailRepository repository;

    @PostMapping("/add")
    public ResponseEntity<String> addNewPersonMail(@RequestBody 
                HashMap<String, Object> personInfo){
        
        PersonMail pm = new PersonMail(0L, 
                                        Long.parseLong(personInfo.get("personId").toString()),
                                        personInfo.get("email").toString(), 
                                        LocalDateTime.now(), 
                                        LocalDateTime.now());
        
        repository.save(pm);
        return ResponseEntity.ok().body("null");
    }

}
