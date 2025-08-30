package roychan.gill.database.tmtt.pt2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
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
        profileService.insertData("Boni andini", 21, 2, 1999, "0876123");
        profileService.showData();
    }

    @Test
    void testUpdateData() {

        profileService.updateData(2, "GIlbrant Roychan", 19,7,2002, "089504455462");
    }

    @Test
    void testDeleteData() {
        profileService.deleteData(4);
    }

    @Test
    void testSearchByID() {
        profileService.searchById(1);
    }
}
