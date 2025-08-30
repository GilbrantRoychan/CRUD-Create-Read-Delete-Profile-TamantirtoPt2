package roychan.gill.database.tmtt.pt2;

import roychan.gill.database.tmtt.pt2.repo.ProfileRepository;
import roychan.gill.database.tmtt.pt2.repo.impl.ProfileRepositoryImpl;
import roychan.gill.database.tmtt.pt2.service.ProfileService;
import roychan.gill.database.tmtt.pt2.view.ViewProfile;

import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args ) {

        try(Scanner scanner = new Scanner(System.in)) {

            System.out.println("Selamat data di MyProfile silahkan masukan pilihan Anda");
            System.out.println("1. Show Data");
            System.out.println("2. Create dta");
            System.out.println("3. Update data");
            System.out.println("4. Cari data");

            System.out.print("masukan pilihan anda: ");
            Integer input = scanner.nextInt();

            switch (input){
                case 1:
                    ViewProfile.viewShowProfile();
                    break;
                case 2:
                    ViewProfile.viewAddData();
                    break;
                case 3:
                    ViewProfile.viewUpdateData();
                    break;
                case 4:
                    ViewProfile.viewSearchByID();
                    break;
                default:
                    System.err.println("Input salah");
            }


        }
    }
}
