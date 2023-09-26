package com.integrador.proyecto01.Controller;

import com.integrador.proyecto01.Model.Inscription;
import com.integrador.proyecto01.Model.Shift;
import com.integrador.proyecto01.Service.InscriptionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/v1")
public class InscriptionController {

    @Autowired
    private InscriptionServiceImpl inscriptionService;

    @PostMapping("/create/inscription")
    public String createInscription(@RequestParam("name") String name, @RequestParam("studentName") String studentName, @RequestParam("email") String email,
                                    @RequestParam("phoneNumber") String phoneNumber, @RequestParam("shift") Shift shift, @RequestParam("message") String message){
        Inscription newInscription = new Inscription();
        newInscription.setName(name);
        newInscription.setStudentName(studentName);
        newInscription.setEmail(email);
        newInscription.setPhoneNumber(phoneNumber);
        newInscription.setShift(shift);
        newInscription.setMessage(message);
        inscriptionService.save(newInscription);
        return "redirect:/confirmacion.html";
    }

    @GetMapping("/inscriptions")
    public ResponseEntity<List<Inscription>> showAll(){
        List<Inscription> showAllInscriptions = inscriptionService.showAll();
        return new ResponseEntity<>(showAllInscriptions, HttpStatus.OK);
    }

    @GetMapping("/inscription/{id}")
    public ResponseEntity<Inscription> showById(@PathVariable Long id){
        Inscription showInscription = inscriptionService.showById(id);
        return new ResponseEntity<>(showInscription, HttpStatus.OK);
    }

    @DeleteMapping("/inscription/{id}")
    public void deleteById(@PathVariable Long id) {
        inscriptionService.deleteById(id);
    }
}
