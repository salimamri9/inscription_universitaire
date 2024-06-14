package com.example.etudiant.Entity;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection ="etudiants")
public class Etudiant {
    @Id
    private String _id;
    private String nom;
    private String cin;
    private String tel;

    public Etudiant(String _id, String nom, String cin, String tel) {
        this._id = _id;
        this.nom = nom;
        this.cin = cin;
        this.tel = tel;
    }

    public Etudiant() {
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getCin() {
        return cin;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    @Override
    public String toString() {
        return "Etudiant{" +
                "_id='" + _id + '\'' +
                ", nom='" + nom + '\'' +
                ", cin='" + cin + '\'' +
                ", tel='" + tel + '\'' +
                '}';
    }
}
