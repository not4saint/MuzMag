package com.muztorg.MuzTorg.services;

import com.muztorg.MuzTorg.models.instr.Instrument;

import java.util.List;

public interface InstrumentService {
    List<? extends Instrument> findAllInstrumentsInCurrentCategory(String nameInstr);
    Instrument findInstrumentInCurrentCategoryById(String nameInstr, int id);
}
