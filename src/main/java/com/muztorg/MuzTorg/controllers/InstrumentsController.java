package com.muztorg.MuzTorg.controllers;

import com.muztorg.MuzTorg.models.instr.Instrument;
import com.muztorg.MuzTorg.services.InstrumentService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/${instr}/${id}")
    public Instrument getInstrument(@PathVariable(name = "instr") String nameInstr, @PathVariable("id") int id) {
        return instrumentService.findInstrumentInCurrentCategoryById(nameInstr, id);
    }

    @PostMapping("/${instr}/${id}")
    public ResponseEntity<HttpStatus> addInstrumentInShoppingCart(@PathVariable(name = "instr") String nameInstr,
                                                                  @PathVariable("id") int id) {
        // TODO: 02.04.2023 добавление в корзину 
    }
}
