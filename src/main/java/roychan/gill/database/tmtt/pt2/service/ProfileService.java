package roychan.gill.database.tmtt.pt2.service;

import roychan.gill.database.tmtt.pt2.entity.ProfileEntity;
import roychan.gill.database.tmtt.pt2.repo.ProfileRepository;
import roychan.gill.database.tmtt.pt2.utill.ConvertDateToLong;


import java.sql.Date;
import java.util.List;


public class ProfileService {

    private static   ProfileRepository profileRepository;

    public ProfileService(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }

    public  void showData(){
        // karena di repo sudah ada iterasi kita bs langsung di pangil
        System.out.println("Menampilka data: ");
        List<ProfileEntity> profileEntities = profileRepository.getAll();
        for (var x: profileEntities){
            System.out.println("ID: " + x.getID());
            System.out.println("Nama: " + x.getNama());
            System.out.println("Tanggal lahir: " + new Date(x.getTanggal_lahir()));
            System.out.println("Nomor telepon: " + x.getNomor_telepon());
            System.out.println();
        }

    }
    public void insertData(String nama, Integer tanggal, Integer bulan, Integer tahun, String noTlp){
            ProfileEntity profile = new ProfileEntity(nama, ConvertDateToLong.convertToLong(tanggal,bulan,tahun),noTlp);
            profileRepository.insert(profile);
        }

    public  void updateData(Integer IDTarget, String nama, Integer tanggal, Integer bulan, Integer tahun, String noTlp ){

        ProfileEntity profileUpdated = new ProfileEntity(nama,ConvertDateToLong.convertToLong(tanggal,bulan,tahun), noTlp);
        Integer updated = profileRepository.update(IDTarget, profileUpdated);

        if (updated>0){
            System.out.println("Success Edit Data");
        }else {
            throw new RuntimeException();
        }

        }


    public  void  deleteData(Integer ID){

        Boolean efected = profileRepository.deleteById(ID);
        if (efected){
            System.out.println("Success to delete Data with ID: " + ID);
        }else {
            System.err.println("terjadi kesalah dengan ID " + ID);
        }

    }




}




