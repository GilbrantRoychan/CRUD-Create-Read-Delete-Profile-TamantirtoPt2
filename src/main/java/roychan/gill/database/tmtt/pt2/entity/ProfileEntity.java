package roychan.gill.database.tmtt.pt2.entity;

import java.sql.Timestamp;

public class ProfileEntity {

    private  Integer ID;
    private  String nama;
    private  Long tanggal_lahir;
    private  String nomor_telepon;
    private Timestamp created_at;
    private  Timestamp updated_at;

    public ProfileEntity() {
    }

    public ProfileEntity(String nama, Long tanggal_lahir, String nomor_telepon) {
        this.nama = nama;
        this.tanggal_lahir = tanggal_lahir;
        this.nomor_telepon = nomor_telepon;
    }

    public ProfileEntity(Integer ID, String nama, Long tanggal_lahir, String nomor_telepon) {
        this.ID = ID;
        this.nama = nama;
        this.tanggal_lahir = tanggal_lahir;
        this.nomor_telepon = nomor_telepon;

    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public Long getTanggal_lahir() {
        return tanggal_lahir;
    }

    public void setTanggal_lahir(Long tanggal_lahir) {
        this.tanggal_lahir = tanggal_lahir;
    }

    public String getNomor_telepon() {
        return nomor_telepon;
    }

    public void setNomor_telepon(String nomor_telepon) {
        this.nomor_telepon = nomor_telepon;
    }

    public Timestamp getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Timestamp created_at) {
        this.created_at = created_at;
    }

    public Timestamp getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(Timestamp updated_at) {
        this.updated_at = updated_at;
    }
}
