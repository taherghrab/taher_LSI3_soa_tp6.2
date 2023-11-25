package org.example;

import org.example.entities.Compte;
import org.example.repositories.CompteRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.Date;

@SpringBootApplication
/*@EnableJpaRepositories(basePackages = "org.example.repositories.CompteRepository") // Active la configuration des dépôts JPA
@EntityScan(basePackages = "entities") // Active la recherche des entités JPA
@ComponentScan("org.example")*/
public class taher_lsi_soa_tp6 {
    public static void main(String[] args) {
        SpringApplication.run(taher_lsi_soa_tp6.class, args);

    }

    @Bean
    public CommandLineRunner CLR (CompteRepository compteRepository) {
        return args -> {
            // Ajout de données de compte initiales
            Compte compte1 = new Compte();
            compte1.setSolde(1500.0);
            compte1.setDateCreation(new Date());
            compte1.setType(Compte.TypeCompte.EPARGNE);
            compte1.setEtat(Compte.EtatCompte.BLOQUE);

            Compte compte2 = new Compte();
            compte2.setSolde(2000.0);
            compte2.setDateCreation(new Date());
            compte2.setType(Compte.TypeCompte.EPARGNE);
            compte2.setEtat(Compte.EtatCompte.ACTIVE);

            Compte compte3 = new Compte();
            compte3.setSolde(3000.0);
            compte3.setDateCreation(new Date());
            compte3.setType(Compte.TypeCompte.COURANT);
            compte3.setEtat(Compte.EtatCompte.SUSPENDU);
            Compte compte4 = new Compte();
            compte4.setSolde(60000.0);
            compte4.setDateCreation(new Date());
            compte4.setType(Compte.TypeCompte.EPARGNE);
            compte4.setEtat(Compte.EtatCompte.ACTIVE);

            // Sauvegarde des comptes dans le référentiel
            compteRepository.save(compte1);
            compteRepository.save(compte2);
            compteRepository.save(compte3);

            // Affichage des soldes des comptes enregistrés dans la console
            compteRepository.findAll().forEach(compte -> System.out.println(" compte #" + compte.getId() + ": " +"  Type de compte:  "+compte.getType()+"  Etat de compte:  "+compte.getEtat() + "  Solde du compte :"+compte.getSolde()));

        };
    }
}

