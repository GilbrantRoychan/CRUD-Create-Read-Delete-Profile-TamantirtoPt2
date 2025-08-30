package roychan.gill.database.tmtt.pt2.utill;

import java.util.Date;
import java.util.Calendar;
import java.util.StringTokenizer;

public class ConvertDateToLong {


    public  static  Long convertToLong(String date){

        StringTokenizer stringTokenizer = new StringTokenizer(date, "/");
        Calendar kalender = Calendar.getInstance();
        if (stringTokenizer.hasMoreTokens()){
            Integer tanggal = Integer.parseInt(stringTokenizer.nextToken());
            Integer bulan = Integer.parseInt(stringTokenizer.nextToken());
            Integer tahun = Integer.parseInt(stringTokenizer.nextToken());


            kalender.set(Calendar.DAY_OF_MONTH, tanggal);
            kalender.set(Calendar.MONTH, (bulan- 1));
            kalender.set(Calendar.YEAR, tahun);
        }
        Date resiult = kalender.getTime();
        return  resiult.getTime() ; // return Long value;

    };

}
