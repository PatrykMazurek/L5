package pl.uken.web_service.controller;

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

import jakarta.validation.Valid;
import jakarta.websocket.server.PathParam;
import pl.uken.web_service.model.Person;
import pl.uken.web_service.repository.PersonRepository;

@Controller
@RequestMapping("/person")
public class PersonContriller {
    
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
    public String addPerson(@Valid @ModelAttribute("person") Person p, BindingResult bind ){
        if (bind.hasErrors()){
            return "add_person";
        }
        repository.save(p);
        return "redirect:/";
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
                return "redirect:/person/all";
            }
        }
        return "redirect:/";
    }
}
