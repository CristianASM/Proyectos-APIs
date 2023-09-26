package com.integrador.proyecto01.Service;

import com.integrador.proyecto01.Model.Form;
import com.integrador.proyecto01.Repository.IFormRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FormServiceImpl implements IFormService {

    @Autowired
    private IFormRepository formRepository;

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
        return formRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteById(Long id) {
        formRepository.deleteById(id);
    }
}
