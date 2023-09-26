package com.integrador.proyecto01.Service;

import com.integrador.proyecto01.Model.Affiliate;

import java.util.List;

public interface IAffiliateService {
    Affiliate save(Affiliate affiliate);
    List<Affiliate> getAll();
    Affiliate getById(Long id);
    void deleteById(Long id);
}
