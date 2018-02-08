package com.arief.mvc.models;

import javax.persistence.*;

@Entity
@Table(name = "tiket")
public class Tiket {

    @Id
    @Column(name = "id_tiket", length = 4)
    private String idTiket;

    @Column
    private String asal;

    @Column
    private String tujuan;


    @OneToOne
    @JoinColumn(name = "id_penumpang",unique = true)
    private Penumpang penumpang;

    public String getIdTiket() {
        return idTiket;
    }

    public void setIdTiket(String idTiket) {
        this.idTiket = idTiket;
    }

    public String getAsal() {
        return asal;
    }

    public void setAsal(String asal) {
        this.asal = asal;
    }

    public String getTujuan() {
        return tujuan;
    }

    public void setTujuan(String tujuan) {
        this.tujuan = tujuan;
    }

    public Penumpang getPenumpang() {
        return penumpang;
    }

    public void setPenumpang(Penumpang penumpang) {
        this.penumpang = penumpang;
    }

    @Override
    public String toString() {
        return "Tiket{" +
                "idTiket='" + idTiket + '\'' +
                ", asal='" + asal + '\'' +
                ", tujuan='" + tujuan + '\'' +
                '}';
    }
}
