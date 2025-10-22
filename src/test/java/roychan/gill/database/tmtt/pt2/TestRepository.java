package roychan.gill.database.tmtt.pt2;

import org.junit.jupiter.api.*;
import roychan.gill.database.tmtt.pt2.entity.ProfileEntity;
import roychan.gill.database.tmtt.pt2.repo.ProfileRepository;
import roychan.gill.database.tmtt.pt2.repo.impl.ProfileRepositoryImpl;
import roychan.gill.database.tmtt.pt2.utill.ConvertDateToLong;

import java.time.LocalDate;


@Disabled
public class TestRepository {

    ProfileRepository profileRepository;

    @BeforeEach
    void setUp() {
        profileRepository = new ProfileRepositoryImpl();

    }

    @Test
    void testInsertData() {
        ProfileEntity testProfile1 = new ProfileEntity("GilbrantTest1", LocalDate.of(2002,7,19), "1");
        ProfileEntity testProfile2 = new ProfileEntity("GilbrantTes2", LocalDate.of(2002,7,19), "12");
        ProfileEntity testProfile3 = new ProfileEntity("GilbrantTest3",LocalDate.of(2002,7,19), "123");
        profileRepository.insert(testProfile1);
        profileRepository.insert(testProfile2);
        profileRepository.insert(testProfile3);
    }

    @Test
    void testGetAllData() {
        System.out.println(profileRepository.getAll().size());
    }


    @Test
    void testUdpateData() {
        ProfileEntity profileGanti = new ProfileEntity("Roychan", LocalDate.of(2002,7,19), "1");

        System.out.println(profileRepository.update(3, profileGanti));
    }

    @Test
    void testDeleteData() {
        System.out.println(profileRepository.deleteById(1));
    }
    @Test
    void testSearchDataByID() {
        ProfileEntity profile = profileRepository.searchByID(1);
        Assertions.assertEquals(profile.getID(), 1);
    }


    @Disabled
    @Test
    @Tag("absensi")
    void testCheckIn() {
        Assertions.assertTrue(profileRepository.checkIn(2));   ;
    }

    @Disabled
    @Test
    @Tag("absensi")
    void testCheckOut() {
        Assertions.assertTrue(profileRepository.checkOut(2));


    }

    @Test
    void testSearchByName() {
        //cara test nya adalah aku menambahkan 2 data terlebih dahulu dengan nama yang identik, lalu akan aku cek Size data yang sama
       // ProfileEntity testProfile1 = new ProfileEntity("Bianda Ara", LocalDate.of("19/7/2001"), "1223");
        //ProfileEntity testProfile2 = new ProfileEntity("Bianda Ari", LocalDate.of("19/7/2010"), "12987");

        var cekData = profileRepository.searchByFamiliarName("Bianda");
        Assertions.assertNotNull( cekData);
    }
}
