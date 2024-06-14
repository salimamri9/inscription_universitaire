package com.example.etudiant.Repo;

import com.example.etudiant.Entity.Etudiant;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EtudiantRepo extends MongoRepository<Etudiant,String> {
}
