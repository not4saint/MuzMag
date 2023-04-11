package com.muztorg.MuzTorg.controllers;

import com.muztorg.MuzTorg.dto.instruments.InstrumentRequestDTO;
import com.muztorg.MuzTorg.models.instr.Instrument;
import com.muztorg.MuzTorg.services.interfaces.InstrumentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/muzmag/catalog")
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

    @PostMapping("/${instr}/${id}/add")
    public ResponseEntity<HttpStatus> addInstrumentInShoppingCart(@RequestBody InstrumentRequestDTO instrumentRequestDTO) {
        instrumentService.addInstrument(instrumentRequestDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }
}
