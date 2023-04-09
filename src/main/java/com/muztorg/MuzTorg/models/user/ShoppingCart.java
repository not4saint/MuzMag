package com.muztorg.MuzTorg.models.user;

import com.muztorg.MuzTorg.models.instr.InstrumentType;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cascade;

@Entity
@Table
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ShoppingCart {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private User user;
    @Column
    @Enumerated(EnumType.STRING)
    private InstrumentType instrumentType;
    @Column
    @NotEmpty
    private int instrumentId;
    @Column
    @Min(1)
    private int amount;
}
