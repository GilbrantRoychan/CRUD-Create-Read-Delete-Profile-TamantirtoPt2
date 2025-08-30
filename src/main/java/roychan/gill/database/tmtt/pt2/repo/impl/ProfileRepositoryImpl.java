package roychan.gill.database.tmtt.pt2.repo.impl;

import roychan.gill.database.tmtt.pt2.entity.ProfileEntity;
import roychan.gill.database.tmtt.pt2.repo.ProfileRepository;
import roychan.gill.database.tmtt.pt2.utill.HikariConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProfileRepositoryImpl implements ProfileRepository {
    @Override
    public void insert(ProfileEntity profile) {
        try(Connection connection = HikariConnection.getDataSource().getConnection()) {

            final String QUERY_SQL = """
                    INSERT INTO Profile(Nama, Tanggal_lahir, Nomor_telepon,Created_at)
                    VALUES(?,?,?,?)
                    """;

            try(PreparedStatement statement = connection.prepareStatement(QUERY_SQL, Statement.RETURN_GENERATED_KEYS)) {

                statement.setString(1, profile.getNama());
                statement.setDate(2,new Date(profile.getTanggal_lahir()));
                statement.setString(3, profile.getNomor_telepon());
                statement.setTimestamp(4, new Timestamp(System.currentTimeMillis()));

                // execute DB
                statement.executeUpdate();

                try(ResultSet getGeneratedKeys = statement.getGeneratedKeys();) {
                    if (getGeneratedKeys.next()){
                        int getID = getGeneratedKeys.getInt(1);
                        profile.setID(getID);
                        System.out.println("success generate ID: " + getID);
                    }
                }
            }
        }catch (SQLException e){
            throw  new RuntimeException(e);
        }
    }

    @Override
    public List<ProfileEntity> getAll() {
        try(
                Connection connection = HikariConnection.getDataSource().getConnection();
                Statement statement = connection.createStatement();
                ) {

            final  String QUERY_SQL ="SELECT * FROM Profile;";
            try(ResultSet result = statement.executeQuery(QUERY_SQL)) {
                List<ProfileEntity> profileEntities = new ArrayList<>();
                while (result.next()){
                    profileEntities.add(
                            new ProfileEntity(
                                    result.getInt("ID"),
                                    result.getString("Nama"),
                                    result.getDate("Tanggal_lahir").getTime(),
                                    result.getString("Nomor_telepon")
                                    ));
                }
                return  profileEntities;

            }
        }catch (SQLException e){
            throw  new RuntimeException(e);
        }

    }

    @Override
    public ProfileEntity searchByID(Integer ID) {
        try(Connection connection = HikariConnection.getDataSource().getConnection()) {
            final  String QUERY_SQL = "SELECT * FROM Profile WHERE ID=?";
            try(PreparedStatement statement = connection.prepareStatement(QUERY_SQL)) {
                statement.setInt(1, ID);

                ResultSet result = statement.executeQuery();
                if (result.next()){
                    return  new ProfileEntity(
                            result.getInt("ID"),
                            result.getString("Nama"),
                            result.getDate("Tanggal_lahir").getTime(),
                            result.getString("Nomor_telepon")
                    );
                }else {
                    throw   new RuntimeException("ID tidak di temukan");
                }

            }

        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public Integer update(Integer ID,ProfileEntity profile) {

        // melakukan check terlebih dahulu apakah ID ada di database
        try(Connection connection = HikariConnection.getDataSource().getConnection();) {
            final String QUERY_SQL_GET ="SELECT * FROM Profile WHERE ID=?";
            try(PreparedStatement statement = connection.prepareStatement(QUERY_SQL_GET)) {

                statement.setInt(1, ID);

                ResultSet getResult = statement.executeQuery();
                if (getResult.next() || ID.equals(getResult.getInt("ID"))){

                    final String QUERY_SQL = """
                            UPDATE  Profile
                            SET Nama = ?, Tanggal_lahir=?, Nomor_telepon=?, Updated_at=?
                            WHERE ID=?
                            """;
                    try(PreparedStatement statement1 = connection.prepareStatement(QUERY_SQL)) {

                        statement1.setString(1, profile.getNama());
                        statement1.setDate(2, new Date(profile.getTanggal_lahir()));
                        statement1.setString(3, profile.getNomor_telepon());
                        statement1.setTimestamp(4, new Timestamp(System.currentTimeMillis()));
                        statement1.setInt(5, ID);
                        return  statement1.executeUpdate();

                    }

                }else {
                    throw new RuntimeException("ID tidak di temukan");
                }

            }

        }catch (SQLException e){
            throw new RuntimeException(e);
        }

    }

    @Override
    public Boolean deleteById(Integer ID) {
        try(Connection connection = HikariConnection.getDataSource().getConnection()) {
            final  String QUERY_SQL = """
                    DELETE FROM Profile
                    WHERE ID = ?
                    """;
            try(PreparedStatement statement = connection.prepareStatement(QUERY_SQL)) {
                statement.setInt(1, ID);

                // execute to DB

                int rowsEfected = statement.executeUpdate();
                 return rowsEfected > 0;

            }

        }catch (SQLException e){
            throw  new RuntimeException(e);
        }

    }
}
