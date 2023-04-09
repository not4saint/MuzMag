package com.muztorg.MuzTorg.repositories;

import com.muztorg.MuzTorg.models.instr.InstrumentType;
import com.muztorg.MuzTorg.models.user.ShoppingCart;
import com.muztorg.MuzTorg.models.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ShoppingCartsRepository extends JpaRepository<ShoppingCart, Integer> {
    Optional<ShoppingCart> findByUserAndInstrumentTypeAndInstrumentId(User user, InstrumentType instrType, int instrId);
    List<ShoppingCart> findByUser(User user);
    void deleteAllByUserAndInstrumentTypeAndInstrumentId(User user, InstrumentType instrumentType, int instrId);
}
