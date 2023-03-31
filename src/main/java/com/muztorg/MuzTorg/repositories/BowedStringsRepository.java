package com.muztorg.MuzTorg.repositories;

import com.muztorg.MuzTorg.models.instr.bowedstrings.BowedStrings;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BowedStringsRepository extends JpaRepository<BowedStrings, Integer> {
}
