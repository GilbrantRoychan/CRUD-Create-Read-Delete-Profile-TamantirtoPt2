package roychan.gill.database.tmtt.pt2.view;
import roychan.gill.database.tmtt.pt2.repo.ProfileRepository;
import roychan.gill.database.tmtt.pt2.repo.impl.ProfileRepositoryImpl;
import roychan.gill.database.tmtt.pt2.service.ProfileService;

import java.util.Scanner;

public class ViewProfile {

      private  static ProfileRepository profileRepository;
      private static ProfileService profileService;

      static {
            profileRepository = new ProfileRepositoryImpl();
            profileService = new ProfileService(profileRepository);
      }


      public ViewProfile(ProfileService profileService) {
            this.profileService = profileService;
      }

      public static   void viewShowProfile(){
            System.out.println("Menampilkan Data : ");
            profileService.showData();
      }

      public static  void  viewAddData(){
            try(Scanner scanner = new Scanner(System.in)) {
                  System.out.print("Masukan nama: ");
                  String inputNama = scanner.nextLine();

                  System.out.print("Masukan Tanggal Lahir(ex: dd/mm/yyyy): ");
                  String inputTanggal = scanner.nextLine();

                  System.out.print("Masukan Nomor Telepon: ");
                  String inputNomorTelepon = scanner.nextLine();

                  profileService.insertData(inputNama,inputTanggal,inputNomorTelepon);
            }
      }

      public static  void  viewUpdateData(){
            try(Scanner scanner = new Scanner(System.in)) {
                  System.out.print("Masukan ID kamu: ");
                  Integer inputID = scanner.nextInt();

                  //give space for input after Integer
                  scanner.nextLine();

                  System.out.print("Masukan Nama Baru: ");
                  String inputNama = scanner.nextLine();

                  System.out.print("Masukan Tanggal Lahir  Baru: ");
                  String inputTanggal = scanner.nextLine();

                  System.out.print("Masukan Nomor telepon  Baru: ");
                  String inputNomor = scanner.nextLine();

                  profileService.updateData(inputID,inputNama,inputTanggal,inputNomor);

            }
      }

      public static  void viewDeleteProfile(){
            try(Scanner scanner =  new Scanner(System.in)) {
                  System.out.print("masukan ID kamu: ");
                  Integer inputID = scanner.nextInt();
                  scanner.nextLine();

                  System.out.print("apakah kamu yakin untuk menghapus (Y/N): ");
                  String getConfirm = scanner.next();
                  if (getConfirm.toLowerCase().contains("y") || getConfirm.toUpperCase().contains("Y")){
                        profileService.deleteData(inputID);
                  }else {
                        System.err.println("Anda menggagalkan untuk menghapus data");
                  }

            }
      }

      public static  void viewSearchByID(){
            try(Scanner scanner =  new Scanner(System.in)) {
                  System.out.print("masukan ID kamu: ");
                  Integer inputID = scanner.nextInt();

                  profileService.searchById(inputID);
            }
      }

      public  static  void viewabsensiCheckIn(){
            try(Scanner scanner = new Scanner(System.in)) {

                  System.out.print("Masukan ID: ");
                  Integer getIDFromUser = scanner.nextInt();

                  profileService.checkIn(getIDFromUser);
            }
      }

      public  static  void viewabsensiCheckout(){
            try(Scanner scanner = new Scanner(System.in)) {

                  System.out.print("Masukan ID: ");
                  Integer getIDFromUser = scanner.nextInt();
                  profileService.checkOut(getIDFromUser);
            }
      }

      public static  void viewSearchByNama(){
            try(Scanner scanner =  new Scanner(System.in)) {
                  System.out.print("masukan nama  yang ingin di cari : ");
                  String inputNama = scanner.nextLine();

                  profileService.showDataFamiliar(inputNama);
            }
      }

}
