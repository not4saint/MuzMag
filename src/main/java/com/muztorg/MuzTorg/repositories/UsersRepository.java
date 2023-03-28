package com.muztorg.MuzTorg.repositories;

import com.muztorg.MuzTorg.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsersRepository extends JpaRepository<User, Integer> {
}
