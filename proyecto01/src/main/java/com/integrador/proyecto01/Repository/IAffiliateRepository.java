package com.integrador.proyecto01.Repository;

import com.integrador.proyecto01.Model.Affiliate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAffiliateRepository extends JpaRepository<Affiliate, Long> {
}
