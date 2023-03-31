package com.muztorg.MuzTorg.repositories;

import com.muztorg.MuzTorg.models.instr.guitar.Guitar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GuitarsRepository extends JpaRepository<Guitar, Integer> {
}
