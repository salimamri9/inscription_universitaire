package com.example.etudiant.Controller;

import com.example.etudiant.Entity.Etudiant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.etudiant.service.EtudiantServices;
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("api/v1/etudiant")
public class EtudiantController {

    @Autowired
    private EtudiantServices EtudiantServices;

    @PostMapping(value = "/save")
    private String saveEtudiant(@RequestBody Etudiant etudiants) {

        EtudiantServices.saveorUpdate(etudiants);
        return etudiants.get_id();
    }

    @GetMapping(value = "/getall")
    public Iterable<Etudiant> getEtudiants() {
        return EtudiantServices.listAll();
    }

    @PutMapping(value = "/edit/{id}")
    private Etudiant update(@RequestBody Etudiant etudiant, @PathVariable(name = "id") String _id) {
        etudiant.set_id(_id);
        EtudiantServices.saveorUpdate(etudiant);
        return etudiant;
    }

    @DeleteMapping("/delete/{id}")
    private void deleteEtudiant(@PathVariable("id") String _id) {
        EtudiantServices.deleteEtudiant(_id);
    }


    @RequestMapping("/search/{id}")
    private Etudiant getEtudiants(@PathVariable(name = "id") String etudiantid) {
        return EtudiantServices.getEtudiantByID(etudiantid);
    }
}
