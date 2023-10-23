package com.integrador.proyecto01.Controller;

import com.integrador.proyecto01.Model.Form;
import com.integrador.proyecto01.Service.FormServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/api/v1")
public class FormController {
    private final FormServiceImpl formService;
    private final JavaMailSender javaMailSender;
    @Autowired
    public FormController(FormServiceImpl formService, JavaMailSender javaMailSender) {
        this.formService = formService;
        this.javaMailSender = javaMailSender;
    }

    @PostMapping("/create")
    public String createForm(@RequestParam("name") String name, @RequestParam("email") String email, @RequestParam("message") String message){
        Form newForm = new Form();
        newForm.setName(name);
        newForm.setEmail(email);
        newForm.setMessage(message);
        newForm.setDate(LocalDate.now());
        formService.create(newForm);

        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo("integradorproyecto001@gmail.com");
        mailMessage.setSubject("Nuevo formulario de contacto enviado");
        mailMessage.setText("Nombre: " + name + "\nCorreo: " + email + "\nMensaje: " + message);
        javaMailSender.send(mailMessage);
        return "redirect:/confirmacion.html";
    }

    @GetMapping("/forms")
    public ResponseEntity<List<Form>> showAll(){
        List<Form> allForms = formService.showAll();
        return new ResponseEntity<>(allForms, HttpStatus.OK);
    }

    @GetMapping("/form/{id}")
    public ResponseEntity<Form> showById(@PathVariable Long id){
        Form formById = formService.findById(id);
        return new ResponseEntity<>(formById, HttpStatus.OK);
    }

    @DeleteMapping("/form/{id}")
    public void deleteById(@PathVariable Long id){
        formService.deleteById(id);
    }
}
