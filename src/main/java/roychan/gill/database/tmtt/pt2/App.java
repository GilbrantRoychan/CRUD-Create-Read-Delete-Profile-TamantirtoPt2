package roychan.gill.database.tmtt.pt2;

import roychan.gill.database.tmtt.pt2.repo.ProfileRepository;
import roychan.gill.database.tmtt.pt2.repo.impl.ProfileRepositoryImpl;
import roychan.gill.database.tmtt.pt2.service.ProfileService;
import roychan.gill.database.tmtt.pt2.view.ViewProfile;

import java.util.Scanner;


public class App {
    public static void main( String[] args ) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("==============================");
                System.out.println("Selamat data di MyProfile silahkan masukan pilihan Anda");
        System.out.println("==============================");
                System.out.println("1. Show Data");
                System.out.println("2. Create dta");
                System.out.println("3. Update data");
                System.out.println("4. hapus data");
                System.out.println("5. Cari data");
                System.out.println("6. Check In");
                System.out.println("7. Check Out");


                System.out.print("masukan pilihan anda: ");
                Integer input = scanner.nextInt();
                scanner.nextLine();
                switch (input) {
                    case 1 -> ViewProfile.viewShowProfile();
                    case 2 -> ViewProfile.viewAddData();
                    case 3 -> ViewProfile.viewUpdateData();
                    case 4 -> ViewProfile.viewDeleteProfile();
                    case 5 -> ViewProfile.viewSearchByID();
                    case 6 -> ViewProfile.viewabsensiCheckIn();
                    case 7 -> ViewProfile.viewabsensiCheckout();
                    default -> System.err.println("Input salah");
            }
        }
    }

