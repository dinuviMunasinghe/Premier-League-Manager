package entities;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;

public class DateComparator implements Comparator<Match>{
    @Override
    public int compare(Match matchOne, Match matchTwo) {
        Date dateOne = null;
        Date dateTwo = null;
        try{
            dateOne = new SimpleDateFormat("dd/MM/yyyy").parse(matchOne.getDate());
            dateTwo = new SimpleDateFormat("dd/MM/yyyy").parse(matchTwo.getDate());
        }catch (ParseException e){
            e.printStackTrace();
        }
        return dateOne.compareTo(dateTwo);
    }
}

