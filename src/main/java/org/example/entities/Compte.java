package org.example.entities;

import jakarta.persistence.*;
import lombok.*;

import javax.annotation.processing.Generated;
import java.util.Date;
// Using Lombok annotations to automatically generate getter, setter, toString, and constructors
@Getter
@Setter
@ToString
@Entity
@AllArgsConstructor
@NoArgsConstructor

public class Compte {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private double solde;
    private Date dateCreation;
    // Enumerated types for the account type and state
    @Enumerated(EnumType.STRING)
    private TypeCompte type;
    @Enumerated(EnumType.STRING)
    private EtatCompte etat;
    // Enum defining possible types of accounts
    public enum TypeCompte {
        COURANT, EPARGNE
    }

    // Enum defining possible states of an account
    public enum EtatCompte {
        CREE, ACTIVE, SUSPENDU, BLOQUE

    }


}
