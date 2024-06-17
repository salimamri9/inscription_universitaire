import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-projets',
  templateUrl: './projets.component.html',
  styleUrls: ['./projets.component.css']
})
export class ProjetsComponent implements OnInit {

  constructor(private http: HttpClient) {}

  etudiantArray: any[] = [];
  nom: string = "";
  cin: string = "";
  tel: string = "";
  currentEtudiantID = "";
  private backendUrl = 'http://192.168.49.2:30001/api/v1/etudiant'; // Backend service URL

  ngOnInit(): void {
    this.getAllEtudiants();
  }

  register(): void {
    const bodyData = {
      nom: this.nom,
      cin: this.cin,
      tel: this.tel
    };

    this.http.post(`${this.backendUrl}/save`, bodyData, { responseType: 'text' }).subscribe((resultData: any) => {
      console.log(resultData);
      alert("Etudiant ajouté avec succès");
      this.getAllEtudiants();
      this.resetForm();
    });
  }

  getAllEtudiants(): void {
    this.http.get(`${this.backendUrl}/getall`).subscribe((resultData: any) => {
      console.log(resultData);
      this.etudiantArray = resultData;
    });
  }

  setUpdate(data: any): void {
    this.nom = data.nom;
    this.cin = data.cin;
    this.tel = data.tel;
    this.currentEtudiantID = data._id;
  }

  updateRecords(): void {
    const bodyData = {
      nom: this.nom,
      cin: this.cin,
      tel: this.tel
    };

    this.http.put(`${this.backendUrl}/edit/${this.currentEtudiantID}`, bodyData, { responseType: 'text' }).subscribe((resultData: any) => {
      console.log(resultData);
      alert("Etudiant modifié avec succès");
      this.getAllEtudiants();
      this.resetForm();
    });
  }

  save(): void {
    if (this.currentEtudiantID === '') {
      this.register();
    } else {
      this.updateRecords();
    }
  }

  setDelete(data: any): void {
    this.http.delete(`${this.backendUrl}/delete/${data._id}`, { responseType: 'text' }).subscribe((resultData: any) => {
      console.log(resultData);
      alert("Etudiant supprimé");
      this.getAllEtudiants();
      this.resetForm();
    });
  }

  private resetForm(): void {
    this.nom = '';
    this.cin = '';
    this.tel = '';
    this.currentEtudiantID = '';
  }
}
