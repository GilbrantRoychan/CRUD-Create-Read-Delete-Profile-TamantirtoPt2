package roychan.gill.database.tmtt.pt2.repo;

import roychan.gill.database.tmtt.pt2.entity.ProfileEntity;

import java.util.List;

public interface ProfileRepository {

    void insert(ProfileEntity profile);
    List<ProfileEntity> getAll();
    Integer update(Integer ID,ProfileEntity profile);
    Boolean deleteById(Integer ID);
    ProfileEntity searchByID(Integer ID);
    Boolean checkIn(Integer ID);
    Boolean checkOut(Integer ID);
    List<ProfileEntity> searchByFamiliarName(String name);






}
