package com.integrador.proyecto01.Service;

import com.integrador.proyecto01.Exceptions.FormNotFoundException;
import com.integrador.proyecto01.Model.Form;
import com.integrador.proyecto01.Repository.IFormRepository;
import com.integrador.proyecto01.Service.IService.IFormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FormServiceImpl implements IFormService {
    private final IFormRepository formRepository;
    @Autowired
    public FormServiceImpl(IFormRepository formRepository) {
        this.formRepository = formRepository;
    }

    @Override
    public Form create(Form form) {
        return formRepository.save(form);
    }

    @Override
    public List<Form> showAll() {
        return formRepository.findAll();
    }

    @Override
    public Form findById(Long id) {
        return formRepository.findById(id).orElseThrow(() -> new FormNotFoundException("Formulario no encontrado"));
    }

    @Override
    public void deleteById(Long id) {
        formRepository.findById(id).orElseThrow(() -> new FormNotFoundException("Formulario no encontrado"));
        formRepository.deleteById(id);
    }
}
