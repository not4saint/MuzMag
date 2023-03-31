package com.muztorg.MuzTorg.services;

import com.muztorg.MuzTorg.models.instr.Instrument;
import com.muztorg.MuzTorg.models.instr.guitar.Guitar;
import com.muztorg.MuzTorg.repositories.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class InstrumentService {
    private final BowedStringsRepository bowedStringsRepository;
    private final BrassRepository brassRepository;
    private final DrumsRepository drumsRepository;
    private final GuitarsRepository guitarsRepository;
    private final PianosRepository pianosRepository;

    public List<? extends Instrument> findAllInstrumentsInCurrentCategory(String nameInstr) {

        return //todo: сделать так, чтоб возвращались все инструменты исходя из переданного имени (для каждого своя репа)
    }
}
