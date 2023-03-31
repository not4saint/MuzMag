package com.muztorg.MuzTorg.repositories;

import com.muztorg.MuzTorg.models.instr.brass.Brass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BrassRepository extends JpaRepository<Brass, Integer> {
}
