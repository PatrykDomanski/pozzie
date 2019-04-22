package Pozzie.controllers;

import Pozzie.services.EmailSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@Component
public class EmailTest {

    @Autowired
    EmailSender emailSender;

    @RequestMapping("email/sendTest")
    @ResponseBody
    public String send(){
        emailSender.sendEmail("patrykd48@interia.eu", "test", "test");
        return "send";
    }
}
