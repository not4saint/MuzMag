package com.muztorg.MuzTorg.dto.instruments;

import com.muztorg.MuzTorg.models.instr.InstrumentType;
import jakarta.persistence.Column;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InstrumentRequestDTO {
    @NotEmpty
    private InstrumentType instrumentType;
    @NotEmpty
    private int instrumentId;
    @Min(1)
    private int amount;
    @NotEmpty
    private int cost;
}
