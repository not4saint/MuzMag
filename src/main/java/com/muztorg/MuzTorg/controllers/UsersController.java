package com.muztorg.MuzTorg.controllers;

import com.muztorg.MuzTorg.dto.instruments.InstrumentRequestDTO;
import com.muztorg.MuzTorg.dto.users.UserInfoDTO;
import com.muztorg.MuzTorg.dto.users.UserUpdateInfoDTO;
import com.muztorg.MuzTorg.models.user.ShoppingCart;
import com.muztorg.MuzTorg.security.exceptions.EmailAlreadyRegisteredException;
import com.muztorg.MuzTorg.services.InstrumentService;
import com.muztorg.MuzTorg.services.UserService;
import com.muztorg.MuzTorg.util.UserValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/muztorg")
public class UsersController {
    private final UserService userService;
    private final InstrumentService instrumentService;
    private final UserValidator userValidator;
    @GetMapping("/user-info")
    public UserInfoDTO getUserInfo() {
        return userService.findUserByEmail();
    }

    @PostMapping("/user-info/update")
    public ResponseEntity<HttpStatus> updateUserInfo(@RequestBody UserUpdateInfoDTO userUpdateInfoDTO,
                                                     BindingResult bindingResult) {
        userValidator.validate(userUpdateInfoDTO, bindingResult);
        if (bindingResult.hasErrors())
            throw new EmailAlreadyRegisteredException("This email is already registered");

        userService.updateUserInformation(userUpdateInfoDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/shopping-cart")
    public List<ShoppingCart> getShoppingCart() {
        return instrumentService.findAllInstrumentsInShoppingCart();
    }

    @PostMapping("/shopping-cart/increase")
    public ResponseEntity<HttpStatus> increaseAmountCurrentInstrumentInShoppingCart(@RequestBody InstrumentRequestDTO instrumentRequestDTO) {
        instrumentService.addInstrument(instrumentRequestDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @DeleteMapping("/shopping-cart/add")
    public ResponseEntity<HttpStatus> deleteCurrentInstrumentInShoppingCart(@RequestBody InstrumentRequestDTO instrumentRequestDTO) {
        instrumentService.deleteInstrument(instrumentRequestDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }
}
