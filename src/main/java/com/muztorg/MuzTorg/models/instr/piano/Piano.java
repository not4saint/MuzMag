package com.muztorg.MuzTorg.models.instr.piano;

import com.muztorg.MuzTorg.models.instr.Instrument;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Piano extends Instrument {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    @NotEmpty
    private String title;
    @Column
    @NotEmpty
    private String maker;
    @Column
    @NotEmpty
    private String description;
    @Column
    @Max(88)
    @Min(61)
    private int numberOfKeys;
    @Column
    @Enumerated(EnumType.STRING)
    private TypePiano type;
    @Column
    @NotEmpty
    private boolean haveBluetooth;
    @Column
    @NotEmpty
    private String color;
    @Column
    @Max(3)
    @Min(0)
    private int numberOfPedals;
    @Column
    @Pattern(regexp = "\\d+\\sx\\s\\d+\\sx\\s\\d++")
    private String size;
    @Column
    @NotEmpty
    private boolean inStock;
    @Column
    @NotEmpty
    private int cost;
}
