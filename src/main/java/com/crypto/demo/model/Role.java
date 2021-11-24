package com.crypto.demo.model;


import com.crypto.demo.model.enums.ERole;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Data
@Entity
public class Role implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "role_name")
    private ERole role;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Role role1 = (Role) o;
        return role == role1.role;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), role);
    }
}
