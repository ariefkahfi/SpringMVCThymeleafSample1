package com.arief.mvc.models;

import javax.persistence.*;

@Entity
@Table(name = "penumpang")
public class Penumpang {

    @Id
    @Column(name = "id_penumpang")
    @GeneratedValue
    private int idPenumpang;

    @Column(name = "nama_penumpang")
    private String namaPenumpang;

    @Column(name = "jenkel_penumpang")
    private String jenkelPenumpang;



    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinTable(
            name = "pesawat_penumpang",
            joinColumns = {@JoinColumn(name = "id_penumpang")},
            inverseJoinColumns = {@JoinColumn(name = "id_pesawat")}
    )
    private Pesawat pesawat;

    @OneToOne(mappedBy = "penumpang",cascade = {CascadeType.REMOVE})
    private Tiket tiket;


    public int getIdPenumpang() {
        return idPenumpang;
    }

    public void setIdPenumpang(int idPenumpang) {
        this.idPenumpang = idPenumpang;
    }

    public String getNamaPenumpang() {
        return namaPenumpang;
    }

    public void setNamaPenumpang(String namaPenumpang) {
        this.namaPenumpang = namaPenumpang;
    }

    public String getJenkelPenumpang() {
        return jenkelPenumpang;
    }

    public void setJenkelPenumpang(String jenkelPenumpang) {
        this.jenkelPenumpang = jenkelPenumpang;
    }

    public Pesawat getPesawat() {
        return pesawat;
    }

    public void setPesawat(Pesawat pesawat) {
        this.pesawat = pesawat;
    }

    public Tiket getTiket() {
        return tiket;
    }

    public void setTiket(Tiket tiket) {
        this.tiket = tiket;
    }

    @Override
    public String toString() {
        return "Penumpang{" +
                "idPenumpang=" + idPenumpang +
                ", namaPenumpang='" + namaPenumpang + '\'' +
                ", jenkelPenumpang='" + jenkelPenumpang + '\'' +
                '}';
    }
}
