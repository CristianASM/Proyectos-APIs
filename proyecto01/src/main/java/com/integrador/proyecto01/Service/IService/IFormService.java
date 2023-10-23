package com.integrador.proyecto01.Service.IService;

import com.integrador.proyecto01.Model.Form;

import java.util.List;

public interface IFormService {

    Form create(Form form);
    List<Form> showAll();
    Form findById(Long id);

    void deleteById(Long id);
}
