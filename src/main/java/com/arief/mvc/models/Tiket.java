package com.arief.mvc.models;

import javax.persistence.*;
import java.util.UUID;

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


    @OneToOne(mappedBy = "tiket",fetch = FetchType.LAZY)
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

    public static Tiket createTiket(String asal , String tujuan){
        Tiket t = new Tiket();
        String idTiket  = UUID.randomUUID().toString().substring(0,4);
        t.setIdTiket(idTiket);
        t.setAsal(asal);
        t.setTujuan(tujuan);

        System.out.println("created Tiket instance : " + t);

        return t;
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
