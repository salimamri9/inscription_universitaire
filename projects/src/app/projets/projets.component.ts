import { Component } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-projets',
  templateUrl: './projets.component.html',
  styleUrls: ['./projets.component.css']
})
export class ProjetsComponent {
//test
  constructor(private http: HttpClient) {
    this.getAllEtudiant();
  }
//webhook test
  EtudiantArray: any[] = [];

  nom: string = "";
  cin: string = "";
  tel: string = "";

  currentEtudiantID = "";

  private backendUrl = 'http://192.168.49.2:30001/api/v1'; // Backend service URL

  register() {
    let bodyData = {
      "nom": this.nom,
      "cin": this.cin,
      "tel": this.tel
    };

    this.http.post(`${this.backendUrl}/etudiant/save`, bodyData, { responseType: 'text' }).subscribe((resultData: any) => {
      console.log(resultData);
      alert("Etudiant ajouté avec succès");
      this.getAllEtudiant();
      this.nom = '';
      this.cin = '';
      this.tel = '';
    });
  }

  getAllEtudiant() {
    this.http.get(`${this.backendUrl}/etudiant/getall`).subscribe((resultData: any) => {
      console.log(resultData);
      this.EtudiantArray = resultData;
    });
  }

  setUpdate(data: any) {
    this.nom = data.nom;
    this.cin = data.cin;
    this.tel = data.tel;
    this.currentEtudiantID = data._id;
  }

  UpdateRecords() {
    let bodyData = {
      "nom": this.nom,
      "cin": this.cin,
      "tel": this.tel
    };

    this.http.put(`${this.backendUrl}/etudiant/edit/${this.currentEtudiantID}`, bodyData, { responseType: 'text' }).subscribe((resultData: any) => {
      console.log(resultData);
      alert("Etudiant modifié avec succès")
      this.getAllEtudiant();

      this.nom = '';
      this.cin = '';
      this.tel = '';
    });
  }

  save() {
    if (this.currentEtudiantID == '') {
      this.register();
    }
    else {
      this.UpdateRecords();
    }
  }

  setDelete(data: any) {
    this.http.delete(`${this.backendUrl}/etudiant/delete/${data._id}`, { responseType: 'text' }).subscribe((resultData: any) => {
      console.log(resultData);
      alert("Etudiant supprimé")
      this.getAllEtudiant();

      this.nom = '';
      this.cin = '';
      this.tel = '';

    });

  }
}
