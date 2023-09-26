package com.integrador.proyecto01.Service;

import com.integrador.proyecto01.Model.Voluntary;

import java.util.List;

public interface IVoluntaryService {

    Voluntary save(Voluntary voluntary);
    Voluntary getById(Long id);
    List<Voluntary> getAll();
    void deleteById(Long id);
}
