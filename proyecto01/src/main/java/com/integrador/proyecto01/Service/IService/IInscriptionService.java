package com.integrador.proyecto01.Service.IService;

import com.integrador.proyecto01.Model.Inscription;

import java.util.List;

public interface IInscriptionService {

    Inscription save(Inscription inscription);
    List<Inscription> showAll();
    Inscription showById(Long id);
    void deleteById(Long id);
}
