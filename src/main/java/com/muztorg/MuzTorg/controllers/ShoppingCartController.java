package com.muztorg.MuzTorg.controllers;

import com.muztorg.MuzTorg.dto.instruments.InstrumentRequestDTO;
import com.muztorg.MuzTorg.models.user.ShoppingCart;
import com.muztorg.MuzTorg.services.interfaces.InstrumentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/muzmag/shopping-cart")
@RequiredArgsConstructor
public class ShoppingCartController {
    private final InstrumentService instrumentService;

    @GetMapping()
    public List<ShoppingCart> getShoppingCart() {
        return instrumentService.findAllInstrumentsInShoppingCart();
    }

    @PostMapping("/increase")
    public ResponseEntity<HttpStatus> increaseAmountCurrentInstrumentInShoppingCart(@RequestBody InstrumentRequestDTO instrumentRequestDTO) {
        instrumentService.addInstrument(instrumentRequestDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @DeleteMapping("/add")
    public ResponseEntity<HttpStatus> deleteCurrentInstrumentInShoppingCart(@RequestBody InstrumentRequestDTO instrumentRequestDTO) {
        instrumentService.deleteInstrument(instrumentRequestDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }

}
