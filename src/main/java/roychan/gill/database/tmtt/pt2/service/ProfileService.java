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
        List<ProfileEntity> profileEntities = profileRepository.getAll();
                profileEntities.forEach(datas->{
                    System.out.println("ID: " + datas.getID());
                    System.out.println("Nama: " + datas.getNama());
                    System.out.println("Tanggal lahir: " + new Date(datas.getTanggal_lahir()));
                    System.out.println("Nomor telepon: " + datas.getNomor_telepon());
                    System.out.println();
                });


    }
    public void insertData(String nama, String date, String noTlp){
            ProfileEntity profile = new ProfileEntity(nama, ConvertDateToLong.convertToLong(date), noTlp);
            if (profile!=null){
                profileRepository.insert(profile);
            }

        };
    public  void updateData(Integer IDTarget, String nama, String date, String noTlp ){

        ProfileEntity profileUpdated = new ProfileEntity(nama,ConvertDateToLong.convertToLong(date), noTlp);
        Integer updated = profileRepository.update(IDTarget, profileUpdated);

        if (updated>0){
            System.out.println("Success Edit Data");
        }else {
            throw new RuntimeException();
        }

        };
    public  void  deleteData(Integer ID){

        Boolean efected = profileRepository.deleteById(ID);
        if (efected){
            System.out.println("Success to delete Data with ID: " + ID);
        }else {
            System.err.println("terjadi kesalah dengan ID " + ID);
        }

    };
    public  void searchById(Integer ID){

        ProfileEntity profile = profileRepository.searchByID(ID);
        if (profile!=null){
            System.out.println("ID Di temukan dengan data");
            System.out.println();
            System.out.println("ID: " + profile.getID());
            System.out.println("Nama: " + profile.getNama());
            System.out.println("Tanggal lahir: " + new Date(profile.getTanggal_lahir()));
            System.out.println("Nomor telepon: " + profile.getNomor_telepon());
        }else {
            throw new RuntimeException("ID tidak cocok");
        }

    };




}




