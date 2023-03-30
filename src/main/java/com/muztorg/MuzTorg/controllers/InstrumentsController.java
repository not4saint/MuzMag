package com.muztorg.MuzTorg.controllers;

import com.muztorg.MuzTorg.models.instr.Instrument;
import com.muztorg.MuzTorg.services.InstrumentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/muztorg/catalog")
@RequiredArgsConstructor
public class InstrumentsController {
    private final InstrumentService instrumentService;
    @GetMapping("/${instr}")
    public List<? extends Instrument> getAllInstruments(@PathVariable(name = "instr") String nameInstr) {
        return instrumentService.findAllInstrumentsInCurrentCategory(nameInstr);
    }
}
