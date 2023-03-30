package com.muztorg.MuzTorg.models.instr.bowedstrings;

import com.muztorg.MuzTorg.models.instr.Instrument;
import jakarta.persistence.*;
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
public class BowedStrings extends Instrument {
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
    private BowedStringsType type;
    @Column
    @Pattern(regexp = "^\\d{1}/\\d{1}")
    private String size;
    @Column
    @NotEmpty
    private String upperDeck;
    @Column
    @NotEmpty
    private String fretBoard;
    @Column
    @NotEmpty
    private String body;
    @Column
    @NotEmpty
    private String included;
    @Column
    @NotEmpty
    private boolean inStock;
}
