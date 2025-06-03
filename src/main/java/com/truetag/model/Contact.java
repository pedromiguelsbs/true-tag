package com.truetag.model;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "contact_type", discriminatorType = DiscriminatorType.STRING)
@Table(name = "contatos")
@NoArgsConstructor
public abstract class Contact implements Verifiable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    protected Boolean authentic;

    public Contact(Boolean authentic) {
        this.authentic = authentic;
    }

    @Override
    public Boolean isAuthentic() {
        return authentic;
    }

}