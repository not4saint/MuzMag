package com.muztorg.MuzTorg.models.instr.drums;

import com.muztorg.MuzTorg.models.instr.Instrument;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
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
public class Drums extends Instrument {
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
    private DrumsType drumsType;
    @Column
    @Min(1)
    @Max(15)
    private int numberOfProducts;
    @Column
    @NotEmpty
    private boolean inStock;
}
