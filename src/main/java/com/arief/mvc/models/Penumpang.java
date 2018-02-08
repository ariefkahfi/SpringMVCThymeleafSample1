package com.arief.mvc.models;

import org.hibernate.annotations.Cascade;

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



    @ManyToOne
    @JoinTable(
            name = "pesawat_penumpang",
            joinColumns = {@JoinColumn(name = "id_penumpang")},
            inverseJoinColumns = {@JoinColumn(name = "id_pesawat")}
    )
    private Pesawat pesawat;

    @OneToOne
    @Cascade({
            org.hibernate.annotations.CascadeType.SAVE_UPDATE,
            org.hibernate.annotations.CascadeType.REMOVE})
    @JoinColumn(name = "id_tiket",unique = true)
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


    public static Penumpang createPenumpang(
            String namaPenumpang,
            String jenkelPenumpang,
            Pesawat pesawat,
            Tiket t){
        Penumpang p = new Penumpang();
        p.setNamaPenumpang(namaPenumpang);
        p.setJenkelPenumpang(jenkelPenumpang);
        p.setPesawat(pesawat);
        p.setTiket(t);
        return p;
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
