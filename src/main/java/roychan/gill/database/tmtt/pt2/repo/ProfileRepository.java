package roychan.gill.database.tmtt.pt2.repo;

import roychan.gill.database.tmtt.pt2.entity.ProfileEntity;

import java.util.List;

public interface ProfileRepository {

    void insert(ProfileEntity profile);
    List<ProfileEntity> getAll();
    Integer update(Integer ID,ProfileEntity profile);
    Boolean deleteById(Integer ID);

    // TODO: fiitur tambahan like searchByID dll




}
