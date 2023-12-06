package org.example.Web;

import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.example.entities.Compte;
import org.example.repositories.CompteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController

//@Component
//@GetMapping("/banque")
public class CompteRestJaxRSAPI

{

    @Autowired
    private CompteRepository compteRepository;
    @RequestMapping("/comptes")
    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Transactional
    public List<Compte> compteList()
    {
        return compteRepository.findAll();
    }
    @GetMapping("/comptes/{id}")
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public Compte getOne(@PathParam(value = "id") Long id)
    {
        return compteRepository.findById(id).get();
    }
    @Path("/comptes")
    @POST
    @Produces({MediaType.APPLICATION_JSON})
    public Compte save(Compte compte)
    {
        return compteRepository.save(compte);
    }
    @Path("/comptes/{id}")
    @POST
    @Produces({MediaType.APPLICATION_JSON})
    public Compte update (Compte compte,@PathParam("id") Long id)
    {
        compte.setId(id);
        return compteRepository.save(compte);
    }
    @Path("/comptes/{id}")
    @DELETE
    @Produces({MediaType.APPLICATION_JSON})
    public void delete(@PathParam("id")Long id)
    {
        compteRepository.deleteById(id);
    }
}

