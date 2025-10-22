package roychan.gill.database.tmtt.pt2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import roychan.gill.database.tmtt.pt2.repo.ProfileRepository;
import roychan.gill.database.tmtt.pt2.repo.impl.ProfileRepositoryImpl;
import roychan.gill.database.tmtt.pt2.service.ProfileService;


public class TestService {

    private  static ProfileRepository profileRepository;
    private  static ProfileService profileService;

    @BeforeEach
    void setUp() {
        profileRepository = new ProfileRepositoryImpl();
        profileService = new ProfileService(profileRepository);

    }

    @Test
    void testShowData() {
        profileService.showData();
    }

    @Test
    void testInsertData (){
        profileService.insertData("Ara", "24/04/2002", "1920192019201");
        profileService.showData();
    }

    @Test
    void testUpdateData() {

        profileService.updateData(2, "GIlbrant Roychan", "19/07/2002", "089504455462");
    }

    @Test
    void testDeleteData() {
        profileService.deleteData(4);
    }

    @Test
    void testSearchByID() {
        profileService.searchById(1);
    }

    @Test
    void testCheckIn() {
//        profileService.checkIn(1);
//        profileService.checkIn(2);
        profileService.checkIn(12);
    }
    @Test
    void testCheckOut() {
//        profileService.checkOut(1);
//        profileService.checkOut(2);
        profileService.checkOut(3);
    }

    @Test
    void testSearchByName() {

        profileService.showDataFamiliar("Bianda");
    }
}
