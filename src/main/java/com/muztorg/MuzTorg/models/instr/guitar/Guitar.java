package com.muztorg.MuzTorg.models.instr.guitar;

import com.muztorg.MuzTorg.models.instr.Instrument;
import com.muztorg.MuzTorg.models.instr.piano.TypePiano;
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
public class Guitar extends Instrument {
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
    @Enumerated(EnumType.STRING)
    private TypeGuitar type;
    @Column
    @NotEmpty
    private String color;
    @Column
    @NotEmpty
    private String model;
    @Column
    @Min(21)
    @Max(27)
    private int numberOfFrets;
    @Column
    @Pattern(regexp = "\\d+\\sx\\s\\d++")
    private String scale;
    @Column
    @NotEmpty
    private boolean inStock;
}
