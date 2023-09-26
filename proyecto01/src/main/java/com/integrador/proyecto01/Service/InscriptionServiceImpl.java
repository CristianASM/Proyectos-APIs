package com.integrador.proyecto01.Service;

import com.integrador.proyecto01.Model.Inscription;
import com.integrador.proyecto01.Repository.IInscriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InscriptionServiceImpl implements IInscriptionService {
    @Autowired
    private IInscriptionRepository inscriptionRepository;

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
        return inscriptionRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteById(Long id) {
        inscriptionRepository.deleteById(id);
    }
}
