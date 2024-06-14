package com.example.etudiant.service;

import com.example.etudiant.Entity.Etudiant;
import com.example.etudiant.Repo.EtudiantRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EtudiantServices {
    @Autowired
    private EtudiantRepo repo;

    public void saveorUpdate(Etudiant etudiants) {

        repo.save(etudiants);
    }

    public Iterable<Etudiant> listAll() {

        return this.repo.findAll();
    }


    public void deleteEtudiant(String id) {

        repo.deleteById(id);
    }

    public Etudiant getEtudiantByID(String etudiantid) {

        return repo.findById(etudiantid).get();
    }
}

