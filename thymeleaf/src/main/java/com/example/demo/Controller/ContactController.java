package com.example.demo.Controller;

import com.example.demo.Entity.Contact;
import com.example.demo.Service.ContactServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;

@Controller
public class ContactController {
    @Autowired
    private ContactServiceImpl contactService;
    
    @GetMapping("/list")
    public String viewContacts(Model model) {
        model.addAttribute("tabla", contactService.allContacts()); // attribute -> th:each="contact : ${tabla}"
        return "tabla";
    }
    @GetMapping("/") //Este GET genera la vista del form
    public String newContact(Model model) {
        Contact newContact = new Contact();
        model.addAttribute("objectForm", newContact); // este es el th:object="${objectForm}" mismo de mas abajo
        return "index";
    }
    @PostMapping("/form") //este post esta conectado al form -> th:action="@{/contacts}"
    public String contact(@ModelAttribute("objectForm") Contact contact){ // esto @ModelAttribute("objectForm") esta conectado a esto -> th:object="${objectForm}"
        contact.setDate(LocalDateTime.now()); //esto se coloca aca por que no esta en el form
        contactService.saveContact(contact); // guardas en la BD
        return "redirect:/enviado.html";
    }
    @GetMapping("/eliminar/{id}") //Si coloco @DeleteMapping se rompe todo.
    public String eliminar(@PathVariable Long id){
        contactService.deleteById(id);
        return "redirect:/list";
    }
}
