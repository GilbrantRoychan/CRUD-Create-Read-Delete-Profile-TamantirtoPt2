package roychan.gill.database.tmtt.pt2.entity;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class ProfileEntity {

    private  Integer ID;
    private  String nama;
    private LocalDate tanggal_lahir;
    private  String nomor_telepon;
    private LocalDateTime created_at;
    private  LocalDateTime updated_at;

    public ProfileEntity() {
    }



    public ProfileEntity(String nama, LocalDate tanggal_lahir, String nomor_telepon) {
        this.nama = nama;
        this.tanggal_lahir = tanggal_lahir;
        this.nomor_telepon = nomor_telepon;
    }

    public ProfileEntity(Integer ID, String nama, LocalDate tanggal_lahir, String nomor_telepon) {
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

    public LocalDate getTanggal_lahir() {
        return tanggal_lahir;
    }

    public void setTanggal_lahir(LocalDate tanggal_lahir) {
        this.tanggal_lahir = tanggal_lahir;
    }

    public String getNomor_telepon() {
        return nomor_telepon;
    }

    public void setNomor_telepon(String nomor_telepon) {
        this.nomor_telepon = nomor_telepon;
    }

    public LocalDateTime getCreated_at() {
        return created_at;
    }

    public void setCreated_at(LocalDateTime created_at) {
        this.created_at = created_at;
    }

    public LocalDateTime getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(LocalDateTime updated_at) {
        this.updated_at = updated_at;
    }
}
