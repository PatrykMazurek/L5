package pl.uken.krakow.web_service.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import pl.uken.krakow.web_service.model.Commision;

@Controller
@RequestMapping("/commision")
public class CommisionController {
    
    @GetMapping("/all")
    public String getCommisionView(Model model){
        String url = "https://api.sejm.gov.pl/sejm/term10/committees";
        RestTemplate template = new RestTemplate();
        String result = template.getForObject(url, String.class);
        ObjectMapper mapper = new ObjectMapper();
        Commision[] commision = null;
        try {
            commision = mapper.readValue(result, Commision[].class);
            System.out.println(commision[0].getName());
        } catch (JsonProcessingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        model.addAttribute("commisions", commision);
        return "commision_all";
    }

}
