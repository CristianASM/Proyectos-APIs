package com.integrador.proyecto01.Service;

import com.integrador.proyecto01.Exceptions.FormNotFoundException;
import com.integrador.proyecto01.Model.Inscription;
import com.integrador.proyecto01.Repository.IInscriptionRepository;
import com.integrador.proyecto01.Service.IService.IInscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InscriptionServiceImpl implements IInscriptionService {
    private final IInscriptionRepository inscriptionRepository;
    @Autowired
    public InscriptionServiceImpl(IInscriptionRepository inscriptionRepository) {
        this.inscriptionRepository = inscriptionRepository;
    }

    @Override
    public Inscription save(Inscription inscription) {
        return inscriptionRepository.save(inscription);
    }

    @Override
    public List<Inscription> showAll() {
        return inscriptionRepository.findAll();
    }

    @Override
    public Inscription showById(Long id) {
        return inscriptionRepository.findById(id).orElseThrow(() -> new FormNotFoundException("Formulario no encontrado"));
    }

    @Override
    public void deleteById(Long id) {
        inscriptionRepository.findById(id).orElseThrow(() -> new FormNotFoundException("Formulario no encontrado"));
        inscriptionRepository.deleteById(id);
    }
}
