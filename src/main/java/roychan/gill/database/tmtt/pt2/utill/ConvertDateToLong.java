package roychan.gill.database.tmtt.pt2.utill;

import java.util.Date;
import java.util.Calendar;

public class ConvertDateToLong {

    public static Long convertToLong(int tanggal, int bulan, int tahun){

        Calendar kalender = Calendar.getInstance();

        kalender.set(Calendar.DAY_OF_MONTH, tanggal);
        kalender.set(Calendar.MONTH, (tanggal- 1));
        kalender.set(Calendar.YEAR, tahun);

        Date resiult = kalender.getTime();

        return  resiult.getTime() ; // return Long value;

    }
}
