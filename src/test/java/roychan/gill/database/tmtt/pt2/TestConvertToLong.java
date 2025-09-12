package roychan.gill.database.tmtt.pt2;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import roychan.gill.database.tmtt.pt2.utill.ConvertDateToLong;

import java.sql.Date;

@Disabled
public class TestConvertToLong {

    @Test
    void testconvert1() {

        Long data = ConvertDateToLong.convertToLong("19/7/2022");
        Date cek =  new Date(data);
        System.out.println(cek);
    }
    @Test
    void testconvert2() {

        Long data = ConvertDateToLong.convertToLong("19/7,2002");
        Date cek = new Date(data);
        System.out.println(cek);

    }
}
