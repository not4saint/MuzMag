package com.muztorg.MuzTorg.repositories;

import com.muztorg.MuzTorg.models.instr.piano.Piano;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PianosRepository extends JpaRepository<Piano, Integer> {
}
