package com.integrador.proyecto01.Controller;

import com.integrador.proyecto01.Model.Shift;
import com.integrador.proyecto01.Model.Voluntary;
import com.integrador.proyecto01.Service.VoluntaryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/v1")
public class VoluntaryController {
    private final VoluntaryServiceImpl voluntaryService;
    private final JavaMailSender javaMailSender;
    @Autowired
    public VoluntaryController(VoluntaryServiceImpl voluntaryService, JavaMailSender javaMailSender) {
        this.voluntaryService = voluntaryService;
        this.javaMailSender = javaMailSender;
    }

    @PostMapping("/create/voluntary")
    public String createVoluntary(@RequestParam("name") String name, @RequestParam("email") String email,
                                  @RequestParam("phoneNumber") String phoneNumber,@RequestParam("shift") Shift shift){
        Voluntary newVoluntary = new Voluntary();
        newVoluntary.setName(name);
        newVoluntary.setEmail(email);
        newVoluntary.setPhoneNumber(phoneNumber);
        newVoluntary.setShift(shift);
        voluntaryService.save(newVoluntary);

        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo("integradorproyecto001@gmail.com");
        mailMessage.setSubject("Nuevo formulario de voluntario enviado");
        mailMessage.setText("Nombre: " + name + "\nCorreo: " + email + "\nNumero de telefono: " + phoneNumber + "\nTurno: " + shift);
        javaMailSender.send(mailMessage);
        return "redirect:/confirmacion.html";
    }

    @GetMapping("/volunteers")
    public ResponseEntity<List<Voluntary>> showAll(){
        List<Voluntary> allVoluntary = voluntaryService.getAll();
        return new ResponseEntity<>(allVoluntary, HttpStatus.OK);
    }
    @GetMapping("/voluntary/{id}")
    public ResponseEntity<Voluntary> showVoluntary(@PathVariable Long id){
        Voluntary voluntaryById = voluntaryService.getById(id);
        return new ResponseEntity<>(voluntaryById, HttpStatus.OK);
    }

    @DeleteMapping("/voluntary/{id}")
    public void deleteVoluntary(@PathVariable Long id){
        voluntaryService.deleteById(id);
    }
}
