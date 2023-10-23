package com.integrador.proyecto01.Service;

import com.integrador.proyecto01.Exceptions.FormNotFoundException;
import com.integrador.proyecto01.Model.Voluntary;
import com.integrador.proyecto01.Repository.IVoluntaryRepository;
import com.integrador.proyecto01.Service.IService.IVoluntaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VoluntaryServiceImpl implements IVoluntaryService {
    private final IVoluntaryRepository voluntaryRepository;
    @Autowired
    public VoluntaryServiceImpl(IVoluntaryRepository voluntaryRepository) {
        this.voluntaryRepository = voluntaryRepository;
    }

    @Override
    public Voluntary save(Voluntary voluntary) {
        return voluntaryRepository.save(voluntary);
    }

    @Override
    public Voluntary getById(Long id) {
        return voluntaryRepository.findById(id).orElseThrow(() -> new FormNotFoundException("Formulario no encontrado"));
    }

    @Override
    public List<Voluntary> getAll() {
        return voluntaryRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        voluntaryRepository.findById(id).orElseThrow(() -> new FormNotFoundException("Formulario no encontrado"));
        voluntaryRepository.deleteById(id);
    }
}
