package com.integrador.proyecto01.Service;

import com.integrador.proyecto01.Model.Voluntary;
import com.integrador.proyecto01.Repository.IVoluntaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VoluntaryServiceImpl implements IVoluntaryService{
    @Autowired
    private IVoluntaryRepository voluntaryRepository;

    @Override
    public Voluntary save(Voluntary voluntary) {
        return voluntaryRepository.save(voluntary);
    }

    @Override
    public Voluntary getById(Long id) {
        return voluntaryRepository.findById(id).orElse(null);
    }

    @Override
    public List<Voluntary> getAll() {
        return voluntaryRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        voluntaryRepository.deleteById(id);
    }
}
