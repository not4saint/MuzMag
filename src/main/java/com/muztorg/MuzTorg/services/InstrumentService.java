package com.muztorg.MuzTorg.services;

import com.muztorg.MuzTorg.dto.instruments.InstrumentRequestDTO;
import com.muztorg.MuzTorg.models.instr.Instrument;
import com.muztorg.MuzTorg.models.user.ShoppingCart;

import java.util.List;

public interface InstrumentService {
    List<? extends Instrument> findAllInstrumentsInCurrentCategory(String nameInstr);
    Instrument findInstrumentInCurrentCategoryById(String nameInstr, int id);
    List<ShoppingCart> findAllInstrumentsInShoppingCart();
    void addInstrument(InstrumentRequestDTO instrumentRequestDTO);
    void deleteInstrument(InstrumentRequestDTO instrumentRequestDTO);

}
