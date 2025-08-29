package roychan.gill.database.tmtt.pt2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import roychan.gill.database.tmtt.pt2.entity.ProfileEntity;
import roychan.gill.database.tmtt.pt2.repo.ProfileRepository;
import roychan.gill.database.tmtt.pt2.repo.impl.ProfileRepositoryImpl;
import roychan.gill.database.tmtt.pt2.utill.ConvertDateToLong;

public class TestRepository {

    ProfileRepository profileRepository;

    @BeforeEach
    void setUp() {
        profileRepository = new ProfileRepositoryImpl();

    }

    @Test
    void testInsertData() {
        ProfileEntity testProfile1 = new ProfileEntity("GilbrantTest", ConvertDateToLong.convertToLong(19,7,2002), "1212121212");
        profileRepository.insert(testProfile1);
    }

    @Test
    void testGetAllData() {
        System.out.println(profileRepository.getAll().size());
    }

    @Test
    void testUdpateData() {
        ProfileEntity profileGanti = new ProfileEntity("Roychan", ConvertDateToLong.convertToLong(12,11,2001), "08951234");

        System.out.println(profileRepository.update(3, profileGanti));
    }

    @Test
    void testDeleteData() {

        System.out.println(profileRepository.deleteById(1));
    }
}
