package com.example.etudiant.Controller;

import com.example.etudiant.Entity.Etudiant;
import com.example.etudiant.service.EtudiantServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("api/v1/etudiant")
public class EtudiantController {

    @Autowired
    private EtudiantServices etudiantServices;

    @PostMapping(value = "/save")
    public String saveEtudiant(@RequestBody Etudiant etudiant) {
        try {
            etudiantServices.saveorUpdate(etudiant);
            return etudiant.get_id();
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Unable to save Etudiant", e);
        }
    }

    @GetMapping(value = "/getall")
    public Iterable<Etudiant> getEtudiants() {
        try {
            return etudiantServices.listAll();
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Unable to fetch Etudiants", e);
        }
    }

    @PutMapping(value = "/edit/{id}")
    public Etudiant update(@RequestBody Etudiant etudiant, @PathVariable(name = "id") String _id) {
        try {
            etudiant.set_id(_id);
            etudiantServices.saveorUpdate(etudiant);
            return etudiant;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Unable to update Etudiant", e);
        }
    }

    @DeleteMapping("/delete/{id}")
    public void deleteEtudiant(@PathVariable("id") String _id) {
        try {
            etudiantServices.deleteEtudiant(_id);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Unable to delete Etudiant", e);
        }
    }

    @RequestMapping("/search/{id}")
    public Etudiant getEtudiant(@PathVariable(name = "id") String etudiantid) {
        try {
            return etudiantServices.getEtudiantByID(etudiantid);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Unable to fetch Etudiant", e);
        }
    }
}
