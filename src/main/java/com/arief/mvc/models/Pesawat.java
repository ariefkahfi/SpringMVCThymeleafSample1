package com.arief.mvc.models;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "pesawat")
public class Pesawat {

    @Id
    @Column(length = 4 , name = "id_pesawat")
    private String idPesawat;

    @Column(name = "nama_pesawat")
    private String namaPesawat;

    @OneToMany(mappedBy = "pesawat",cascade = {CascadeType.REMOVE})
    private List<Penumpang> penumpangList;

    public String getIdPesawat() {
        return idPesawat;
    }

    public void setIdPesawat(String idPesawat) {
        this.idPesawat = idPesawat;
    }

    public String getNamaPesawat() {
        return namaPesawat;
    }

    public void setNamaPesawat(String namaPesawat) {
        this.namaPesawat = namaPesawat;
    }

    public List<Penumpang> getPenumpangList() {
        return penumpangList;
    }

    public void setPenumpangList(List<Penumpang> penumpangList) {
        this.penumpangList = penumpangList;
    }


    public static Pesawat createPesawat(String idPesawat,String namaPesawat){
        Pesawat p = new Pesawat();
        p.setIdPesawat(idPesawat);
        p.setNamaPesawat(namaPesawat);
        p.setPenumpangList(new ArrayList<Penumpang>());
        return p;
    }

    @Override
    public String toString() {
        return "Pesawat{" +
                "idPesawat='" + idPesawat + '\'' +
                ", namaPesawat='" + namaPesawat + '\'' +
                '}';
    }
}
