package com.muztorg.MuzTorg.models.instr.brass;

import com.muztorg.MuzTorg.models.instr.Instrument;
import jakarta.persistence.*;
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
public class Brass extends Instrument {
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
    private BrassType type;
    @Column
    @NotEmpty
    private String key;
    @Column
    @NotEmpty
    private int weight;
    @Column
    @NotEmpty
    private boolean inStock;
    @Column
    @NotEmpty
    private int cost;
}
