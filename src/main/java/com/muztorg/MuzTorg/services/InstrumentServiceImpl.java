package com.muztorg.MuzTorg.services;

import com.muztorg.MuzTorg.models.instr.Instrument;
import com.muztorg.MuzTorg.repositories.*;
import com.muztorg.MuzTorg.security.exceptions.CurrentCategoryNotFoundException;
import com.muztorg.MuzTorg.security.exceptions.InstrumentNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class InstrumentServiceImpl implements InstrumentService {
    private final BowedStringsRepository bowedStringsRepository;
    private final BrassRepository brassRepository;
    private final DrumsRepository drumsRepository;
    private final GuitarsRepository guitarsRepository;
    private final PianosRepository pianosRepository;

    public List<? extends Instrument> findAllInstrumentsInCurrentCategory(String nameInstr) {
        return switch (nameInstr) {
            case "bowed-strings" -> bowedStringsRepository.findAll();
            case "brass" -> brassRepository.findAll();
            case "drums" -> drumsRepository.findAll();
            case "guitar" -> guitarsRepository.findAll();
            case "piano" -> pianosRepository.findAll();
            default -> throw new CurrentCategoryNotFoundException(String.format("«%s» category was not found", nameInstr));
        };
    }

    public Instrument findInstrumentInCurrentCategoryById(String nameInstr, int id) {
        Optional<? extends Instrument> optionalInstrument = switch (nameInstr) {
            case "bowed-strings" -> bowedStringsRepository.findById(id);
            case "brass" -> brassRepository.findById(id);
            case "drums" -> drumsRepository.findById(id);
            case "guitar" -> guitarsRepository.findById(id);
            case "piano" -> pianosRepository.findById(id);
            default -> throw new CurrentCategoryNotFoundException(String.format("«%s» category was not found", nameInstr));
        };

        return optionalInstrument.orElseThrow(() ->
                new InstrumentNotFoundException(String.format("Instrument: %s by %d not found", nameInstr, id)));
    }
}
