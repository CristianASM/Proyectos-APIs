package com.integrador.proyecto01.Controller;

import com.integrador.proyecto01.Model.Affiliate;
import com.integrador.proyecto01.Service.AffiliateServiceImpl;
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
public class AffiliateController {
    private final AffiliateServiceImpl affiliateService;
    private final JavaMailSender javaMailSender;
    @Autowired
    public AffiliateController(AffiliateServiceImpl affiliateService, JavaMailSender javaMailSender) {
        this.affiliateService = affiliateService;
        this.javaMailSender = javaMailSender;
    }

    @PostMapping("/create/affiliate")
    public String saveAffiliate(@RequestParam("name")String name,@RequestParam("email")String email,@RequestParam("phoneNumber")String phoneNumber){
        Affiliate newAffiliate = new Affiliate();
        newAffiliate.setName(name);
        newAffiliate.setEmail(email);
        newAffiliate.setPhoneNumber(phoneNumber);
        affiliateService.save(newAffiliate);

        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo("integradorproyecto001@gmail.com");
        mailMessage.setSubject("Nuevo formulario de afiliado enviado");
        mailMessage.setText("Nombre: " + name + "\nCorreo: " + email + "\nNumero de telefono: " + phoneNumber);
        javaMailSender.send(mailMessage);
        return "redirect:/confirmacion.html";
    }
    @GetMapping("/affiliates")
    public ResponseEntity<List<Affiliate>> getAll(){
        List<Affiliate> allAffiliates = affiliateService.getAll();
        return new ResponseEntity<>(allAffiliates, HttpStatus.OK);
    }
    @GetMapping("/affiliate/{id}")
    public ResponseEntity<Affiliate> getAffiliate(@PathVariable Long id){
        Affiliate affiliateById = affiliateService.getById(id);
        return new ResponseEntity<>(affiliateById, HttpStatus.OK);
    }

    @DeleteMapping("/affiliate/{id}")
    public void deleteAffiliate(@PathVariable Long id){
        affiliateService.deleteById(id);
    }
}
