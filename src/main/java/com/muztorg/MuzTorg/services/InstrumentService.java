package com.muztorg.MuzTorg.services;

import com.muztorg.MuzTorg.models.instr.Instrument;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class InstrumentService {
    public List<? extends Instrument> findAllInstrumentsInCurrentCategory(String nameInstr) {
        return //todo: сделать так, чтоб возвращались все инструменты исходя из переданного имени (для каждого своя репа)
    }
}
