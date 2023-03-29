package com.muztorg.MuzTorg.models.user;

import com.muztorg.MuzTorg.models.user.Role;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    @NotEmpty
    private String firstname;
    @Column
    @NotEmpty
    private String lastname;
    @Column
    @NotEmpty
    @Email
    private String email;
    @Column
    @NotEmpty
    private String password;
    @Column
    @Enumerated(EnumType.STRING)
    private Role role;
    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @Column
    private boolean enabled;
    @Column
    private boolean nonLocked;

}
