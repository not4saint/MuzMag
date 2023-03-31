package com.muztorg.MuzTorg.repositories;

import com.muztorg.MuzTorg.models.instr.drums.Drums;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DrumsRepository extends JpaRepository<Drums, Integer> {
}
