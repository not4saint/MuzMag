package com.muztorg.MuzTorg.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/muztorg")
public class InstrumentsController {
    @GetMapping("/${instr}")
    public List<InstrumentDTO> getAllInstruments(@PathVariable(name = "instr") String instr) {
        /// TODO: 28.03.2023 method return list of all instruments in current category
    }
}
