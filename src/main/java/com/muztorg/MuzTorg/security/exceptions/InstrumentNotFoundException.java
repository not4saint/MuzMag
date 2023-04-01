package com.muztorg.MuzTorg.security.exceptions;

import com.muztorg.MuzTorg.models.instr.Instrument;

public class InstrumentNotFoundException extends RuntimeException {
    public InstrumentNotFoundException(String message) {
        super(message);
    }
}
