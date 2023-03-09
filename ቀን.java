import java.time.LocalDate;
import java.util.InputMismatchException;

public class ቀን {
    private int day, month, year;

    ቀን() {
        LocalDate dd = LocalDate.now();
        ቀን kk = BahireCalc.ToEthiopian(new GregDate(dd.getDayOfMonth(), dd.getMonthValue(), dd.getYear()));
        setDay(kk.getDay());
        setMonth(kk.getMonth());
        setYear(kk.getYear());
    }

    ቀን(int d, int m, int y) {
        if (d <= 0 || d > 30 || m <= 0 || m > 13 || (m == 13 && !ዘመነ_ዮሐንስ(y) && d > 5)
                || (m == 13 && ዘመነ_ዮሐንስ(y) && d > 6)) {
            throw new InputMismatchException();
        } else {
            day = d;
            month = m;
            setYear(y);
        }

    }

    static ቀን incቀን(ቀን x) {
        if (x == null) {

        }
        if (x.month == 13 && (ዘመነ_ዮሐንስ(x.year + 1) ? x.day == 6 : x.day == 5)) {
            x.day = 1;
            x.month = 1;
            x.year++;
        } else if (x.day == 30) {
            x.day = 1;
            x.month++;
        } else
            x.day++;
        return x;
    }

    static ቀን incወር(ቀን x) {
        if (x.month == 13) {
            x.month = 1;
            x.year++;
        } else
            x.month++;
        return x;
    }

    static ቀን incዓመት(ቀን x) {
        x.year++;
        return x;
    }

    static ቀን decቀን(ቀን x) {
        if (x == null) {

        }
        if (x.month == 1 && x.day == 1) {
            x.day = ዘመነ_ዮሐንስ(x.year) ? 6 : 5;
            x.month = 13;
            x.setYear(x.year - 1);
        } else if (x.day == 1) {
            x.day = 30;
            x.month--;
        } else
            x.day--;
        return x;
    }

    static ቀን decወር(ቀን x) {
        if (x.month == 1) {
            x.month = 13;
            x.setYear(x.year - 1);
        } else
            x.month--;
        return x;
    }

    static ቀን decዓመት(ቀን x) {
        x.setYear(x.year - 1);
        return x;
    }

    static boolean ዘመነ_ዮሐንስ(int yy) {
        if (yy % 4 == 0)
            return true;
        return false;
    }

    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    public void setDay(int day) {
        if (day <= 30 && day >= 1)
            this.day = day;
    }

    public void setMonth(int month) {
        if (month <= 13 && month >= 1)
            this.month = month;
    }

    public void setYear(int year) {
        if (year >= 1 && year < 8000)
            this.year = year;
        else
            throw new InputMismatchException();
    }
    

}
