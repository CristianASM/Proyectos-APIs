package com.integrador.proyecto01.Service;

import com.integrador.proyecto01.Model.Affiliate;
import com.integrador.proyecto01.Repository.IAffiliateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AffiliateServiceImpl implements IAffiliateService{

    @Autowired
    private IAffiliateRepository affiliateRepository;

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
        return affiliateRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteById(Long id) {
        affiliateRepository.deleteById(id);
    }
}
