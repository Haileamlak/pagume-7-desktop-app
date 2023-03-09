
import java.util.InputMismatchException;

public class GregDate {
    private int d, m, y;

    GregDate(int dd, int mm, int yy) {
        if (is_date(dd, mm, yy)) {
            setD(dd);
            setM(mm);
            setY(yy);
        }
        else
            throw new InputMismatchException();
    }

    static GregDate incDay(GregDate x) {
        switch (x.m) {
            case 2: // the length of February varies
                if ((leap_year(x.y)) ? x.d == 29 : x.d == 28) {
                    x.d = 1;
                    x.m++;
                } else
                    x.d++;
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                if (x.d == 30) { // the rest have 30 days
                    x.d = 1;
                    x.m++;
                } else
                    x.d++;
                break;
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
                if (x.d == 31) {
                    x.d = 1;
                    x.m++;
                } else
                    x.d++;
                break;
            case 12:
                if (x.d == 31) {
                    x.d = 1;
                    x.m = 1;
                    x.y++;
                } else
                    x.d++;
                break;
        }
        return x;
    }

    static GregDate incMonth(GregDate x) {
        if (x.m == 12) {
            x.m = 1;
            x.y++;
        } else
            x.m++;

        return x;
    }

    static GregDate incYear(GregDate x) {
        x.y++;

        return x;
    }

    static GregDate decDay(GregDate x) {
        switch (x.m) {
            case 3: // the length of February varies
                if (x.d == 1) {
                    x.d = leap_year(x.y - 1) ? 29 : 28;
                    x.m--;
                } else
                    x.d--;
                break;
            case 5:
            case 7:
            case 10:
            case 12:
                if (x.d == 1) { // the rest have 30 days
                    x.d = 30;
                    x.m--;
                } else
                    x.d--;
                break;
            case 2:
            case 4:
            case 6:
            case 8:
            case 9:
            case 11:
                if (x.d == 1) {
                    x.d = 31;
                    x.m--;
                } else
                    x.d--;
                break;
            case 1:
                if (x.d == 1) {
                    x.d = 31;
                    x.m = 12;
                    x.setY(x.y - 1);
                } else
                    x.d--;
                break;
        }
        return x;
    }

    static GregDate decMonth(GregDate x) {
        if (x.m == 1) {
            x.m = 12;
            x.setY(x.y - 1);
        } else
            x.m--;

        return x;
    }

    static GregDate decYear(GregDate x) {
        x.setY(x.y - 1);

        return x;
    }

    public int getD() {
        return d;
    }

    public int getM() {
        return m;
    }

    public int getY() {
        return y;
    }

    public void setD(int d) {
        this.d = d;
    }

    public void setM(int m) {
        this.m = m;
    }

    public void setY(int y) {
        this.y = y;
    }

    static boolean leap_year(int yy) {
        if (yy % 400 == 0)
            return true;
        if (yy % 4 == 0 && yy % 100 != 0)
            return true;
        return false;
    }

    static boolean is_date(int d, int m, int y) {
        if (d <= 0 || m < 1 || 12 < m)
            return false;
        int days_in_month = 31; // most months have 31 days
        switch (m) {
            case 2: // the length of February varies
                days_in_month = (leap_year(y)) ? 29 : 28;
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                days_in_month = 30; // the rest have 30 days
                break;
        }
        if (days_in_month < d)
            return false;
        return true;
    }
}
