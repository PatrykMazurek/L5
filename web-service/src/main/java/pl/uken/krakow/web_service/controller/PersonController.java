package pl.uken.krakow.web_service.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import jakarta.websocket.server.PathParam;
import pl.uken.krakow.web_service.model.Person;
import pl.uken.krakow.web_service.repository.PersonRepository;

@Controller
@RequestMapping("/person")
public class PersonController {
    
    @Autowired
    private PersonRepository repository;
    
    @GetMapping("/")
    public String homeView(Model model){
        return "index";
    }

    @GetMapping("/all")
    public String allPersonView(Model model){
        List<Person> persons = repository.findAll();
        model.addAttribute("persons", persons);
        return "list_person";
    }

        @GetMapping("/new")
    public String addPersonView(Model model){
        Person p = new Person();
        model.addAttribute("person", p);
        return "add_person";
    }

    @PostMapping("/add")
    public String addPerson( @ModelAttribute("person") Person p, BindingResult bind ){
        if (bind.hasErrors()){
            return "add_person";
        }
        repository.save(p);

        return "redirect:http://localhost:8080/person/";
    }

        @GetMapping("/del/{id}" )
    public String delPersonView(@PathVariable("id") Long id, Model model){
        if (id != null){
            Person p = repository.findById(id).orElse(null);
            model.addAttribute("person", p);
            return "del_person";
        }else{
            return "list_person";
        }
    }

    @GetMapping("/del_person/{id}")
    public String delPerson(@PathVariable("id") Long id,
                            @PathParam("accept") Boolean accept){
        if (id != null){
            Person p = repository.findById(id).orElse(null);
            if (p != null){
                repository.delete(p);
                return "redirect:http://localhost:8080/person/all";
            }
        }
        return "redirect:http://localhost:8080/person/";
    }

    private boolean emailAccount(Long personId, String email){
        String url = "http://localhost:8090/add/";
        RestTemplate rest = new RestTemplate();
        HashMap<String, Object> obj = new HashMap<>();
        obj.put("personId", personId);
        obj.put("email", email);
        String resault = rest.postForObject(url, obj, String.class);
        return true;
    }
}
