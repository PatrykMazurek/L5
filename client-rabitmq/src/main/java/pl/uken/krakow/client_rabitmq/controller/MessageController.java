package pl.uken.krakow.client_rabitmq.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import pl.uken.krakow.client_rabitmq.model.Message;
// import pl.uken.krakow.client_rabitmq.service.MessageReciverService;
import pl.uken.krakow.client_rabitmq.service.MessageSenderService;

@Controller
@RequestMapping("/message")
public class MessageController {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(MessageController.class);


    @GetMapping("/")
    public String getAllMessageView(Model model){
        List<Message> messageList = new ArrayList<Message>();
        model.addAttribute("listMsg", messageList);
        // dopisać rozwiązanie do odczytu wiadomości
        return "index";
    }

    @GetMapping("/send")
    public String sentMessageView(Model model){
        Message message = new Message();
        model.addAttribute("msg", message);
        return "send_message";
    }

    @PostMapping("/send_message")
    public String sentMessage(@ModelAttribute("msg") Message msg, BindingResult result){
        if (result.hasErrors()){
            return "send_message";
        }
        LOGGER.info("Send message -> " + msg.getText());
        return "redirect:message/";
    }

}
