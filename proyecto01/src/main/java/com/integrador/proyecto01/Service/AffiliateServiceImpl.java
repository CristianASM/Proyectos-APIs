package com.integrador.proyecto01.Service;

import com.integrador.proyecto01.Exceptions.FormNotFoundException;
import com.integrador.proyecto01.Model.Affiliate;
import com.integrador.proyecto01.Repository.IAffiliateRepository;
import com.integrador.proyecto01.Service.IService.IAffiliateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AffiliateServiceImpl implements IAffiliateService {
    private final IAffiliateRepository affiliateRepository;
    @Autowired
    public AffiliateServiceImpl(IAffiliateRepository affiliateRepository) {
        this.affiliateRepository = affiliateRepository;
    }

    @Override
    public Affiliate save(Affiliate affiliate) {
        return affiliateRepository.save(affiliate);
    }

    @Override
    public List<Affiliate> getAll() {
        return affiliateRepository.findAll();
    }

    @Override
    public Affiliate getById(Long id) {
        return affiliateRepository.findById(id).orElseThrow(() -> new FormNotFoundException("Formulario no encontrado"));
    }

    @Override
    public void deleteById(Long id) {
        affiliateRepository.findById(id).orElseThrow(() -> new FormNotFoundException("Formulario no encontrado"));
        affiliateRepository.deleteById(id);
    }
}
