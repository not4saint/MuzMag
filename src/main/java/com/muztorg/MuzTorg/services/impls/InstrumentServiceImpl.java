package com.muztorg.MuzTorg.services.impls;

import com.muztorg.MuzTorg.dto.instruments.InstrumentRequestDTO;
import com.muztorg.MuzTorg.models.instr.Instrument;
import com.muztorg.MuzTorg.models.user.ShoppingCart;
import com.muztorg.MuzTorg.models.user.User;
import com.muztorg.MuzTorg.repositories.*;
import com.muztorg.MuzTorg.security.exceptions.CurrentCategoryNotFoundException;
import com.muztorg.MuzTorg.security.exceptions.InstrumentNotFoundException;
import com.muztorg.MuzTorg.services.interfaces.AuthenticationService;
import com.muztorg.MuzTorg.services.interfaces.InstrumentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class InstrumentServiceImpl implements InstrumentService, AuthenticationService {
    private final BowedStringsRepository bowedStringsRepository;
    private final BrassRepository brassRepository;
    private final DrumsRepository drumsRepository;
    private final GuitarsRepository guitarsRepository;
    private final PianosRepository pianosRepository;
    private final ShoppingCartsRepository shoppingCartsRepository;

    public List<? extends Instrument> findAllInstrumentsInCurrentCategory(String nameInstr) {
        return switch (nameInstr) {
            case "bowed-strings" -> bowedStringsRepository.findAll();
            case "brass" -> brassRepository.findAll();
            case "drums" -> drumsRepository.findAll();
            case "guitar" -> guitarsRepository.findAll();
            case "piano" -> pianosRepository.findAll();
            default ->
                    throw new CurrentCategoryNotFoundException(String.format("«%s» category was not found", nameInstr));
        };
    }

    public Instrument findInstrumentInCurrentCategoryById(String nameInstr, int id) {
        Optional<? extends Instrument> optionalInstrument = switch (nameInstr) {
            case "bowed-strings" -> bowedStringsRepository.findById(id);
            case "brass" -> brassRepository.findById(id);
            case "drums" -> drumsRepository.findById(id);
            case "guitar" -> guitarsRepository.findById(id);
            case "piano" -> pianosRepository.findById(id);
            default ->
                    throw new CurrentCategoryNotFoundException(String.format("«%s» category was not found", nameInstr));
        };

        return optionalInstrument.orElseThrow(() ->
                new InstrumentNotFoundException(String.format("Instrument: %s by %d not found", nameInstr, id)));
    }

    public List<ShoppingCart> findAllInstrumentsInShoppingCart() {
        User user = getUserAfterAuthenticationInCurrentSession();
        List<ShoppingCart> shoppingCart = shoppingCartsRepository.findByUser(user);
        if (shoppingCart.isEmpty()) {
            return Collections.emptyList();
        }
        return shoppingCart;
    }

    @Transactional
    public void addInstrument(InstrumentRequestDTO instrumentRequestDTO) {
        User user = getUserAfterAuthenticationInCurrentSession();
        Optional<ShoppingCart> optionalShoppingCart = shoppingCartsRepository.findByUserAndInstrumentTypeAndInstrumentId(user,
                instrumentRequestDTO.getInstrumentType(), instrumentRequestDTO.getInstrumentId());
        ShoppingCart shoppingCart;

        if (optionalShoppingCart.isPresent()) {
            shoppingCart = optionalShoppingCart.get();
            shoppingCart.setAmount(shoppingCart.getAmount() + instrumentRequestDTO.getAmount());
        } else {
            shoppingCart = ShoppingCart.builder()
                    .user(getUserAfterAuthenticationInCurrentSession())
                    .instrumentId(instrumentRequestDTO.getInstrumentId())
                    .instrumentType(instrumentRequestDTO.getInstrumentType())
                    .amount(instrumentRequestDTO.getAmount())
                    .cost(instrumentRequestDTO.getCost())
                    .build();
        }
        shoppingCartsRepository.save(shoppingCart);
    }

    @Transactional
    public void deleteInstrument(InstrumentRequestDTO instrumentRequestDTO) {
        User user = getUserAfterAuthenticationInCurrentSession();
        shoppingCartsRepository.deleteAllByUserAndInstrumentTypeAndInstrumentId(user,
                instrumentRequestDTO.getInstrumentType(), instrumentRequestDTO.getInstrumentId());
    }
}
