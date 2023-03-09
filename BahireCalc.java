import java.security.InvalidParameterException;

public class BahireCalc {

    static final int[] tewsak = { 7, 6, 5, 4, 3, 2, 8 };

    static String greg_months[] = { "January", "February", "March", "Apri", "May", "June", "July", "August",
            "September",
            "October", "November", "December" };
    static String et_months[] = { "September",
            "October", "November", "December", "January", "February", "March", "Apri", "May", "June", "July",
            "August", "Paguime" };
    static String የሳምንቱ_ዕለታት[] = { "ቅዳሜ", "እሑድ", "ሠኞ", "ማግሠኞ", "ረቡዕ", "ሀሙስ", "ዐርብ" };
    static String የሳምንቱ_days[] = { "Saturday", "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday" };
    static String ወራት[] = { "መስከረም", "ጥቅምት", "ኅዳር", "ታኅሣሥ", "ጥር", "የካቲት", "መጋቢት", "ሚያዝያ", "ግንቦት", "ሰኔ", "ሐምሌ", "ነሐሴ",
            "ጳጉሜ" };
    static String grወራት[] = { "ጥር", "የካቲት", "መጋቢት", "ሚያዝያ", "ግንቦት", "ሰኔ", "ሐምሌ", "ነሐሴ", "መስከረም", "ጥቅምት", "ኅዳር",
            "ታኅሣሥ" };
    public static final String etNums[] = { "", "፩", "፪", "፫", "፬", "፭", "፮", "፯", "፰", "፱", "፲", "፳", "፴", "፵", "፶",
            "፷", "፸", "፹", "፺", "፻", "፼" };
    public static final String etNums2[] = { "", "፻", "፼", "፻፼", "፼፼", "፻፼፼", "፼፼፼", "፻፼፼፼", "፼፼፼፼" };

    static String etYearString(ቀን etDate) {
        String yString = "";
        if (etDate.getYear() < 10)
            yString = "000";
        else if (etDate.getYear() < 100)
            yString = "00";
        else if (etDate.getYear() < 1000)
            yString = "0";
        else
            yString = "";

        return yString;
    }

    static String grYearString(GregDate grDate) {
        String yString = "";
        if (grDate.getY() < 10)
            yString = "000";
        else if (grDate.getY() < 100)
            yString = "00";
        else if (grDate.getY() < 1000)
            yString = "0";
        else
            yString = "";

        return yString;
    }

    static String get_ወር(int month) {
        return ወራት[month - 1];
    }

    static String get_et_month(int month) {
        return et_months[month - 1];
    }

    static String get_greg_month(int month) {
        return greg_months[month - 1];
    }

    static String get_greg_ወር(int month) {
        return grወራት[month - 1];
    }

    static int getNum(String num) {
        if (num.equals(""))
            return 1;
        else if (num.equals("፩"))
            return 1;
        else if (num.equals("፪"))
            return 2;
        else if (num.equals("፫"))
            return 3;
        else if (num.equals("፬"))
            return 4;
        else if (num.equals("፭"))
            return 5;
        else if (num.equals("፮"))
            return 6;
        else if (num.equals("፯"))
            return 7;
        else if (num.equals("፰"))
            return 8;
        else if (num.equals("፱"))
            return 9;
        else if (num.equals("፲"))
            return 10;
        else if (num.equals("፳"))
            return 20;
        else if (num.equals("፴"))
            return 30;
        else if (num.equals("፵"))
            return 40;
        else if (num.equals("፶"))
            return 50;
        else if (num.equals("፷"))
            return 60;
        else if (num.equals("፸"))
            return 70;
        else if (num.equals("፹"))
            return 80;
        else if (num.equals("፺"))
            return 90;
        else if (num.equals("፻"))
            return 100;
        else if (num.equals("፼"))
            return 10000;
        else if (num.equals("፻፼"))
            return 1000000;
        else if (num.equals("፼፼"))
            return 100000000;
        // else if (num.equals("፻፼፼"))
        // return 10000000000;
        // else if (num.equals("፼፼፼"))
        // return 100000000000;
        else
            throw new InvalidParameterException();
    }

    static int toArabic(String num) {
        int nfinal = 0, max = 100000000;
        int nextStep = 1;
        boolean end = false;
        String n = "", n3 = "", tempn = "", tempn2 = "", tempn3 = "";
        int n2 = 0;
        for (int i = 0; i < num.length(); i++) {
            n = num.substring(i, i + 1);

            if (i > 0)
                tempn = num.substring(i - 1, i);

            if (getNum(n) <= 90) {

                if (getNum(n3) > max)
                    throw new InvalidParameterException();
                else if (getNum(n3) == max && nextStep == 2)
                    throw new InvalidParameterException();
                else if (getNum(n3) == max)
                    nextStep++;
                else
                    nextStep = 1;

                if (i > 0 && getNum(tempn) <= 90) {
                    if (getNum(n) <= 9 && getNum(tempn) <= 9) // ፩፪
                        throw new InvalidParameterException();
                    else if (getNum(n) <= 9 && (getNum(tempn) <= 90 && getNum(tempn) >= 10))// ፴፩
                    {
                        if (end)
                            throw new InvalidParameterException();
                        else
                            end = true;
                    }

                    else if ((getNum(n) <= 90 && getNum(n) >= 10) && (getNum(tempn) <= 90 && getNum(tempn) >= 10))// ፴፳
                        throw new InvalidParameterException();

                    else if ((getNum(n) <= 90 && getNum(n) >= 10) && getNum(tempn) <= 9)// ፩፴
                        throw new InvalidParameterException();
                }

                if (getNum(n3) == max) {
                    if (getNum(tempn3) <= 9 && getNum(tempn2) <= 9) // ፩ ፪
                        throw new InvalidParameterException();

                    else if ((getNum(tempn3) <= 90 && getNum(tempn3) >= 10)
                            && (getNum(tempn2) <= 90 && getNum(tempn2) >= 10))// ፴፳
                        throw new InvalidParameterException();
                    else if ((getNum(tempn2) <= 90 && getNum(tempn2) >= 10) && getNum(tempn3) <= 9)// ፩፴
                        throw new InvalidParameterException();
                }

                nfinal += n2 * getNum(n3);
                n2 = getNum(n);
                tempn2 = n;
                tempn3 = tempn2;
                max = (i == 0) ? max : getNum(n3);
                n3 = "";
            } else if (getNum(n) == 100 || getNum(n) == 10000) {
                n3 += n;
                n2 = (n2 == 0) ? 1 : n2;
            }

        }
        if (getNum(n3) > max)
            throw new InvalidParameterException();
        else if (getNum(n3) == max && nextStep == 2)
            throw new InvalidParameterException();

        if (getNum(n3) == max) {
            if (getNum(tempn3) <= 9 && getNum(tempn2) <= 9) // ፩ ፪
                throw new InvalidParameterException();

            else if ((getNum(tempn3) <= 90 && getNum(tempn3) >= 10) && (getNum(tempn2) <= 90 && getNum(tempn2) >= 10))// ፴፳
                throw new InvalidParameterException();
            else if ((getNum(tempn2) <= 90 && getNum(tempn2) >= 10) && getNum(tempn3) <= 9)// ፩፴
                throw new InvalidParameterException();
        }

        nfinal += n2 * getNum(n3);

        return nfinal;
    }

    static String toEthiopic(String num) {
        String etNum = "";
        int numL = num.length();
        int x1;
        for (int i = 1, j = 0, k = 0; i <= numL; i++) {
            x1 = Integer.parseInt(num.substring(numL - i, numL - i + 1));
            etNum = etNums[x1 + (x1 == 0 ? 0 : j)] + etNums2[(x1 == 0 ? 0 : k)] + etNum;

            if (i % 2 == 0) {
                k++;
                j = 0;
            } else
                j = 9;
        }

        return etNum;

    }

    // static void printCal(ቀን etDate) {
    //     int ዕለት_ማስያ = BahireCalc.ዕለት(etDate);
    //     int temp_ቀን = (ዕለት_ማስያ == 0) ? -5 : 2 - ዕለት_ማስያ;

    //     // << L"\t\t|| እሁድ ሠኞ ማግሠኞ ረቡዕ ሀሙስ ዐርብ ቅዳሜ ||\t\n";

    //     for (int i = 0, cal = 0; i < 6; i++) {
    //         for (int j = temp_ቀን; j <= temp_ቀን + 6; j++, cal++) {
    //             if (j < 1 || j > 30
    //                     || (ቀን.ዘመነ_ዮሐንስ(etDate.getYear() + 1)
    //                             && etDate.getMonth() == 13
    //                             && j > 6)
    //                     || (!ቀን.ዘመነ_ዮሐንስ(etDate.getYear() + 1)
    //                             && etDate.getMonth() == 13
    //                             && j > 5)) {
    //                 FirstPage.calLabels.get(cal).setText("");
    //             } else
    //                 FirstPage.calLabels.get(cal).setText((j < 10 && j > 0) ? "0" + j : j + "");
    //         }
    //         temp_ቀን += 7;
    //     }

    // }

    static ቀን ToEthiopian(GregDate input) {

        int pagume_n, leap_c;
        ቀን output = new ቀን(1, 1, 2015);
        leap_c = GregDate.leap_year(input.getY()) ? 1 : 0;
        pagume_n = GregDate.leap_year(input.getY() + 1) ? 6 : 5;
        int[][] arr = { {},
                { 9 + leap_c, 5, 8, 22 }, // jan
                { 8 + leap_c, 6, 8, 23 }, // feb
                { 10 + leap_c, 7, 8, 21 }, // mar
                { 9, 8, 8, 22 }, // apr
                { 9, 9, 8, 8, 22 }, // may
                { 8, 10, 8, 23 }, // jun
                { 8, 11, 8, 23 }, // jul
                { 7, 12, 8, 24 }, // aug
                { 11 + leap_c, 1, 7, 20 }, // sep
                { 11 + leap_c, 2, 7, 20 }, // oct
                { 10 + leap_c, 3, 7, 21 }, // nov
                { 10 + leap_c, 4, 7, 21 }// dec
        };

        int day = input.getD();
        int month = input.getM();
        int year = input.getY();
        // if (month == 12)
        if (month == 9 && (day <= arr[month][0] - 1)) {
            if (day <= 10 + leap_c && day >= 6 + leap_c)
                output = new ቀን(day - 5, 13,
                        year - 8);
            else if (day <= 5 + leap_c && day >= 1)
                output = new ቀን(25 - leap_c + day, 12,
                        year - 8);
        }

        else {
            if (day >= arr[month][0])
                output = new ቀን(day - arr[month][0] + 1, arr[month][1],
                        year - arr[month][2]);
            else if (day <= arr[month][0] - 1)
                output = new ቀን(arr[month][3] + day, arr[month][1] - 1,
                        year - arr[month][2]);
        }

        return output;
    }

    static GregDate ToGregorian(ቀን input) {
        int pagume_n, leap_c;
        GregDate output = new GregDate(01, 01, 2023);
        leap_c = ቀን.ዘመነ_ዮሐንስ(input.getYear()) ? 1 : 0;
        pagume_n = ቀን.ዘመነ_ዮሐንስ(input.getYear() + 1) ? 6 : 5;
        int[][] arr = { {}, { 20 - leap_c, 10 + leap_c, 9, 7 }, { 21 - leap_c, 10 + leap_c, 10, 7 },
                { 21 - leap_c, 9 + leap_c, 11, 7 }, { 22 - leap_c, 9 + leap_c, 12, 7 },
                { 23 - leap_c, 8 + leap_c, 1, 8 }, { 21, 7 + leap_c, 2, 8 },
                { 22, 9, 3, 8 }, { 22, 8, 4, 8 }, { 23, 8, 5, 8 }, { 23, 7, 6, 8 },
                { 24, 7, 7, 8 }, { 25, 6, 8, 8 }, { pagume_n, 5, 9, 8 } };

        int day = input.getDay();
        int month = input.getMonth();
        int year = input.getYear();

        if (day >= 1 && day <= arr[month][0])
            output = new GregDate(day + arr[month][1], arr[month][2],
                    year + arr[month][3]);
        else if (day >= arr[month][0] + 1 && day <= 30)
            output = new GregDate(day - arr[month][0], arr[month][2] + 1,
                    year + arr[month][3]);

        return output;
    }

    static int ዕለት(ቀን y) {
        int yy = (y.getDay() + 2 * y.getMonth() + ጥንተ_ዮን(y.getYear())) % 7;
        return yy;
    }

    static int ወንበር(int y) {
        return (5500 + y) % 19 - 1;
    }

    static int መደብ(int y) {
        return (5500 + y) % 19;
    }

    static int አበቅቴ(int y) {
        return (11 * ወንበር(y)) % 30;
    }

    static int መጥቅዕ(int y) {
        if (አበቅቴ(y) == 0)
            return 30;
        return (19 * ወንበር(y)) % 30;
    }

    static boolean በዓለ_መጥቅዕ(int y) {
        if (መጥቅዕ(y) > 14)
            return true;
        return false;
    }

    static int ጥንተ_ዮን(int y) {
        int yon;
        yon = ((5500 + y) + (5500 + y) / 4) % 7 - 1;
        if (yon == 0)
            yon = 7;
        if (yon == -1)
            yon = 1;
        return yon;
    }

    static int መባጃ_ሐመር(int y) {
        if (በዓለ_መጥቅዕ(y))
            return (መጥቅዕ(y) + ተውሳክ(መጥቅዕ(y), 1, y)) % 30;
        return (መጥቅዕ(y) + ተውሳክ(መጥቅዕ(y), 2, y)) % 30;
    }

    static int ተውሳክ(int Day, int month, int y) {
        int sereke;
        sereke = Day + 2 * month + ጥንተ_ዮን(y);
        if (sereke > 7) {
            sereke %= 7;
            if (sereke == 0)
                return 0;
        }
        return tewsak[sereke - 1];
    }

    static ቀን ጾመ_ነነዌ(int y) {
        if (በዓለ_መጥቅዕ(y))
            return new ቀን(መባጃ_ሐመር(y), 5, 2015);
        else
            return new ቀን(መባጃ_ሐመር(y), 6, 2015);
    }

    static ቀን ዓቢይ_ጾም(int y) {
        int d;
        d = (14 + መባጃ_ሐመር(y));
        if (d > 30)
            return new ቀን(d % 30, 7, 2015);
        else {
            if (በዓለ_መጥቅዕ(y))
                return new ቀን(d, 5, 2015);
            else
                return new ቀን(d, 6, 2015);
        }
    }

    static ቀን ደብረ_ዘይት(int y) {
        int d;
        d = 27 + ((14 + መባጃ_ሐመር(y)) % 30);
        if (d <= 30)
            return new ቀን(d, 6, 2015);
        else if (30 < d && d <= 60) {
            d = d % 30;
            if (d == 0)
                return new ቀን(30, 7, 2015);
            else
                return new ቀን(d % 30, 7, 2015);
        } else // if (d > 60)
            return new ቀን(d % 30, 8, 2015);
    }

    static ቀን ሆሳዕና(int y) {
        int d;
        d = 18 + ((14 + መባጃ_ሐመር(y)) % 30);
        if (d > 30)
            return new ቀን(d % 30, 8, 2015);
        else
            return new ቀን(d, 7, 2015);
    }

    static ቀን ስቅለት(int y) {
        int d;
        d = 23 + ((14 + መባጃ_ሐመር(y)) % 30);
        if (d > 30)
            return new ቀን(d % 30, 8, 2015);
        else
            return new ቀን(d, 7, 2015);
    }

    static ቀን ትንሣኤ(int y) {
        int d;
        d = 25 + ((14 + መባጃ_ሐመር(y)) % 30);
        if (d > 30)
            return new ቀን(d % 30, 8, 2015);
        else
            return new ቀን(d, 7, 2015);
    }

    static ቀን ዕርገት(int y) {
        int d;
        d = 18 + መባጃ_ሐመር(y);
        if (d > 30)
            return new ቀን(d % 30, 10, 2015);
        else
            return new ቀን(d, 9, 2015);
    }

    static ቀን ጰራቅሊጦስ(int y) {
        int d;
        d = 28 + መባጃ_ሐመር(y);
        if (d > 30)
            return new ቀን(d % 30, 10, 2015);
        else
            return new ቀን(d, 9, 2015);
    }

    static ቀን ጾመ_ሐዋርያት(int y) {
        int d;
        d = 29 + መባጃ_ሐመር(y);
        if (d > 30)
            return new ቀን(d % 30, 10, 2015);
        else
            return new ቀን(d, 9, 2015);
    }

    static ቀን ጾመ_ድኅነት(int y) {
        int d;
        d = 1 + መባጃ_ሐመር(y);
        if (d > 30)
            return new ቀን(d % 30, 10, 2015);
        else
            return new ቀን(d, 9, 2015);
    }
}