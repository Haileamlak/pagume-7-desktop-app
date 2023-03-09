
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.*;
import java.awt.event.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Vector;
import java.net.URI;

public class Pagume7 extends JFrame implements ActionListener {

        JPanel p1, p2, pTemp, bigPanel;
        JPanel clock = new JPanel();
        JButton enterButton;

        JTextField etDay, etMonth, etYear, etNum, arNum, grDay, grMonth, grYear;
        JLabel txtBasic, basic1, etDateInput, grDateInput, find, find2, txtHead, txtFast, txtHoly;
        JButton bt1, bt2, bt3, bt4, bt5, bt6, bt7, bt8;

        JComboBox calBox, numBox, langBox; // settings
        boolean deflang = true, defcal = true, defnum = true;//

        ቀን etDate = new ቀን();
        GregDate grTemp = BahireCalc.ToGregorian(etDate);
        GregDate grDate = grTemp;

        public static Point center = GraphicsEnvironment.getLocalGraphicsEnvironment().getCenterPoint();

        public Color butbackColor = new Color(255, 153, 0);
        public Color butfrontColor = Color.black;
        public Color butbackColor2 = Color.white;
        public Color butfrontColor2 = new Color(0, 153, 204);

        ImageIcon arrowUp = new ImageIcon("images/up-arrow.png");
        ImageIcon arrowDown = new ImageIcon("images/down-arrow.png");
        ImageIcon arrowUpBig = new ImageIcon("images/up-arrow.png");
        ImageIcon arrowDownBig = new ImageIcon("images/down-arrow.png");
        ImageIcon calIcon = new ImageIcon("images/calendar3icon.png");
        ImageIcon dcIcon = new ImageIcon("images/dateconvicon.png");
        ImageIcon holyIcon = new ImageIcon("images/holyicon.png");
        ImageIcon fastIcon = new ImageIcon("images/fasticon.png");
        ImageIcon dayIcon = new ImageIcon("images/dayicon.png");
        ImageIcon numConvIcon = new ImageIcon("images/numconvicon.png");
        ImageIcon nextIcon = new ImageIcon("images/righticon.png");
        ImageIcon leftIcon = new ImageIcon("images/lefticon.png");
        ImageIcon upward = new ImageIcon("images/arrow-up.png");
        ImageIcon downward = new ImageIcon("images/arrow-down.png");

        public static void main(String[] args) {
                Pagume7 fff = new Pagume7();
                fff.setVisible(true);
        }

        Pagume7() {
                super();
                setFont(new Font("Power Geez Unicode1", Font.BOLD, 18));
                setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                setLayout(null);
                setBounds((int) center.getX() - 475, (int) center.getY() - 375, 950, 750);
                getContentPane().setBackground(new Color(0, 153, 204));
                Image iconimg = Toolkit.getDefaultToolkit().getImage("images/bahirelogo.png");
                setIconImage(iconimg);

                pTemp = MenuPage();
                p1 = new FrontPage();
                bigPanel = new JPanel(null);
                bigPanel.setBounds(0, 0, 950, 750);
                bigPanel.setBackground(butfrontColor2);

                bigPanel.add(pTemp);
                bigPanel.add(p1);
                add(bigPanel);

        }

        JPanel mainPan(int index) {

                p1 = new JPanel(null);
                p1.setBounds(0, 0, 370, 710);
                p1.setBackground(new Color(0, 153, 204));// new Color(0, 153, 204)

                JButton backButton = new JButton();
                backButton.setBounds(50, 30, 100, 30);
                backButton.setBackground(butfrontColor2);
                backButton.setIcon(new ImageIcon("images/back.png"));
                backButton.addActionListener(this);
                backButton.setBorderPainted(false);
                backButton.setActionCommand("MenuPage");
                p1.add(backButton);

                bt1 = new JButton(deflang ? " የቀን መቁጠሪያ" : " Calender");
                bt1.setIcon(calIcon);
                bt1.setFont(new Font("Power Geez Unicode1", Font.BOLD, 18));
                bt1.setBounds(index == 1 ? 121 : 50, 80, 250, 60);
                bt1.addActionListener(this);
                bt1.setActionCommand("Buttons");
                bt1.setBackground(index == 1 ? butbackColor2 : butbackColor);
                bt1.setForeground(index == 1 ? butfrontColor2 : butfrontColor);
                bt1.setCursor(new Cursor(Cursor.HAND_CURSOR));
                p1.add(bt1);

                bt2 = new JButton(deflang ? " የቀን መቀየሪያ" : " Date Converter");
                bt2.setIcon(dcIcon);
                bt2.setFont(new Font("Power Geez Unicode1", Font.BOLD, 18));
                bt2.setBounds(index == 2 ? 121 : 50, 170, 250, 60);
                bt2.addActionListener(this);
                bt2.setActionCommand("bUttons");
                bt2.setBackground(index == 2 ? butbackColor2 : butbackColor);
                bt2.setForeground(index == 2 ? butfrontColor2 : butfrontColor);
                bt2.setCursor(new Cursor(Cursor.HAND_CURSOR));
                p1.add(bt2);

                bt3 = new JButton(deflang ? " የቁጥር መቀየሪያ" : "Number Converter");
                bt3.setIcon(numConvIcon);
                bt3.setFont(new Font("Power Geez Unicode1", Font.BOLD, 18));
                bt3.setBounds(index == 3 ? 121 : 50, 260, 250, 60);
                bt3.addActionListener(this);
                bt3.setActionCommand("buTtons");
                bt3.setBackground(index == 3 ? butbackColor2 : butbackColor);
                bt3.setForeground(index == 3 ? butfrontColor2 : butfrontColor);
                bt3.setCursor(new Cursor(Cursor.HAND_CURSOR));
                p1.add(bt3);

                bt4 = new JButton(deflang ? " በዓላት" : " Holidays");//
                bt4.setIcon(holyIcon);
                bt4.setFont(new Font("Power Geez Unicode1", Font.BOLD, 18));
                bt4.setBounds(index == 4 ? 121 : 50, 350, 250, 60);
                bt4.addActionListener(this);
                bt4.setActionCommand("butTons");
                bt4.setBackground(index == 4 ? butbackColor2 : butbackColor);
                bt4.setForeground(index == 4 ? butfrontColor2 : butfrontColor);
                bt4.setCursor(new Cursor(Cursor.HAND_CURSOR));
                p1.add(bt4);

                bt5 = new JButton(deflang ? " አጽዋማት" : " Fastings");
                bt5.setIcon(fastIcon);
                bt5.setFont(new Font("Power Geez Unicode1", Font.BOLD, 18));
                bt5.setBounds(index == 5 ? 121 : 50, 440, 250, 60);
                bt5.addActionListener(this);
                bt5.setActionCommand("buttOns");
                bt5.setBackground(index == 5 ? butbackColor2 : butbackColor);
                bt5.setForeground(index == 5 ? butfrontColor2 : butfrontColor);
                bt5.setCursor(new Cursor(Cursor.HAND_CURSOR));
                p1.add(bt5);

                bt6 = new JButton(deflang ? "የዕለት ማግኛ" : " Find the Day");
                bt6.setIcon(dayIcon);
                bt6.setFont(new Font("Power Geez Unicode1", Font.BOLD, 18));
                bt6.setBounds(index == 6 ? 121 : 50, 530, 250, 60);
                bt6.addActionListener(this);
                bt6.setActionCommand("buttoNs");
                bt6.setBackground(index == 6 ? butbackColor2 : butbackColor);
                bt6.setForeground(index == 6 ? butfrontColor2 : butfrontColor);
                bt6.setCursor(new Cursor(Cursor.HAND_CURSOR));
                p1.add(bt6);

                bt7 = new JButton(deflang ? "ዓመታዊ መሠረታዊ ስሌቶች" : "Basic yearly Calculations");
                bt7.setFont(new Font("Power Geez Unicode1", Font.BOLD, 16));
                bt7.setBounds(index == 7 ? 121 : 50, 620, 250, 60);
                bt7.addActionListener(this);
                bt7.setActionCommand("buttonS");
                bt7.setBackground(index == 7 ? butbackColor2 : butbackColor);
                bt7.setForeground(index == 7 ? butfrontColor2 : butfrontColor);
                bt7.setCursor(new Cursor(Cursor.HAND_CURSOR));
                p1.add(bt7);

                return p1;
        }

        private class Calender extends JPanel implements MouseListener, ActionListener {//

                Calender() {

                        super(null);
                        etDate = new ቀን();
                        grDate = BahireCalc.ToGregorian(etDate);
                        setBounds(370, 10, 550, 690);
                        setBackground(Color.white);

                        JButton btup2 = new JButton(arrowUp);
                        btup2.setBounds(195, 70, 50, 30);
                        btup2.setActionCommand("Calr");
                        btup2.addActionListener(this);
                        btup2.setBackground(Color.white);
                        btup2.setBorderPainted(false);
                        btup2.setCursor(new Cursor(Cursor.HAND_CURSOR));
                        add(btup2);

                        JButton btup3 = new JButton(arrowUpBig);
                        btup3.setBounds(270, 70, 70, 30);
                        btup3.setActionCommand("cAlr");
                        btup3.addActionListener(this);
                        btup3.setBackground(Color.white);
                        btup3.setBorderPainted(false);
                        btup3.setCursor(new Cursor(Cursor.HAND_CURSOR));
                        add(btup3);

                        if (defcal)
                                etMonth = new JTextField(
                                                etDate.getMonth() < 10 ? "0" + etDate.getMonth()
                                                                : etDate.getMonth() + "");
                        else
                                etMonth = new JTextField(
                                                grDate.getM() < 10 ? "0" + grDate.getM()
                                                                : grDate.getM() + "");

                        etMonth.setBackground(Color.yellow);// new Color(0, 153, 204));
                        etMonth.setForeground(Color.black);
                        etMonth.setBounds(190, 105, 60, 40);
                        etMonth.addMouseListener(this);
                        etMonth.setFont(new Font("Power Geez Unicode1", Font.BOLD, 30));
                        add(etMonth);

                        if (defcal)
                                etYear = new JTextField(BahireCalc.etYearString(etDate) + etDate.getYear());
                        else
                                etYear = new JTextField(BahireCalc.grYearString(grDate) + grDate.getY());

                        etYear.setBackground(Color.red);// new Color(0, 153, 204));
                        etYear.setForeground(Color.black);
                        etYear.setBounds(260, 105, 90, 40);
                        etYear.addMouseListener(this);
                        etYear.setFont(new Font("Power Geez Unicode1", Font.BOLD, 30));
                        add(etYear);

                        JButton btdw2 = new JButton(arrowDown);
                        btdw2.setBounds(195, 150, 50, 30);
                        btdw2.setActionCommand("caLr");
                        btdw2.addActionListener(this);
                        btdw2.setBackground(Color.white);
                        btdw2.setBorderPainted(false);
                        btdw2.setCursor(new Cursor(Cursor.HAND_CURSOR));
                        add(btdw2);

                        JButton btdw3 = new JButton(arrowDownBig);
                        btdw3.setBounds(270, 150, 70, 30);
                        btdw3.setActionCommand("calR");
                        btdw3.addActionListener(this);
                        btdw3.setBackground(Color.white);
                        btdw3.setBorderPainted(false);
                        btdw3.setCursor(new Cursor(Cursor.HAND_CURSOR));
                        add(btdw3);

                        JButton prev = new JButton(leftIcon);
                        prev.setFont(new Font("Power Geez Unicode1", Font.PLAIN, 18));
                        prev.setCursor(new Cursor(Cursor.HAND_CURSOR));
                        prev.addActionListener(this);
                        prev.setBackground(Color.white);
                        prev.setBorderPainted(false);
                        prev.setActionCommand("caLr");
                        prev.setBounds(10, 400, 40, 100);
                        add(prev);

                        JButton next = new JButton(nextIcon);
                        next.setFont(new Font("Power Geez Unicode1", Font.PLAIN, 18));
                        next.setCursor(new Cursor(Cursor.HAND_CURSOR));
                        next.setBackground(Color.white);
                        next.setBorderPainted(false);
                        next.addActionListener(this);
                        next.setActionCommand("Calr");
                        next.setBounds(505, 400, 40, 100);
                        add(next);

                }

                @Override
                public void actionPerformed(ActionEvent e) {
                        // TODO Auto-generated method stub
                        if (e.getActionCommand().equalsIgnoreCase("calr")) {
                                String mm = etMonth.getText().trim();
                                String yy = etYear.getText().trim();

                                try {
                                        if (defcal) {
                                                etDate = new ቀን(01, Integer.parseInt(mm), Integer.parseInt(yy));
                                                {
                                                        if (e.getActionCommand().equals("Calr"))
                                                                etDate = ቀን.incወር(etDate);
                                                        else if (e.getActionCommand().equals("caLr"))
                                                                etDate = ቀን.decወር(etDate);
                                                        else if (e.getActionCommand().equals("cAlr"))
                                                                etDate = ቀን.incዓመት(etDate);
                                                        else if (e.getActionCommand().equals("calR"))
                                                                etDate = ቀን.decዓመት(etDate);

                                                }
                                                grDate = BahireCalc.ToGregorian(etDate);

                                                String yString = BahireCalc.etYearString(etDate);

                                                etMonth.setText(etDate.getMonth() < 10 ? "0" + etDate.getMonth()
                                                                : "" + etDate.getMonth());
                                                etYear.setText(yString + etDate.getYear());
                                        } else {
                                                grDate = new GregDate(01, Integer.parseInt(mm), Integer.parseInt(yy));
                                                {
                                                        if (e.getActionCommand().equals("Calr"))
                                                                grDate = GregDate.incMonth(grDate);
                                                        else if (e.getActionCommand().equals("caLr"))
                                                                grDate = GregDate.decMonth(grDate);
                                                        else if (e.getActionCommand().equals("cAlr"))
                                                                grDate = GregDate.incYear(grDate);
                                                        else if (e.getActionCommand().equals("calR"))
                                                                grDate = GregDate.decYear(grDate);

                                                }
                                                etDate = BahireCalc.ToEthiopian(grDate);

                                                String yString = BahireCalc.grYearString(grDate);

                                                etMonth.setText(grDate.getM() < 10 ? "0" + grDate.getM()
                                                                : "" + grDate.getM());
                                                etYear.setText(yString + grDate.getY());
                                        }
                                        repaint();
                                } catch (Exception eee) {
                                        // Str
                                        JLabel message = new JLabel(deflang ? "የተሳሳተ ግብዓት" : "Invalid Input");
                                        message.setFont(new Font("Power Geez Unicode1", Font.PLAIN, 18));
                                        message.setForeground(Color.red);
                                        JOptionPane.showMessageDialog(this, message, "Error",
                                                        JOptionPane.ERROR_MESSAGE);
                                }
                        }

                        else if (e.getActionCommand().equals("enter")) {
                                String mm = etMonth.getText().trim();
                                String yy = etYear.getText().trim();

                                try {
                                        if (defcal) {
                                                etDate = new ቀን(01, Integer.parseInt(mm), Integer.parseInt(yy));

                                                grDate = BahireCalc.ToGregorian(etDate);

                                                String yString = BahireCalc.etYearString(etDate);

                                                etMonth.setText(etDate.getMonth() < 10 ? "0" + etDate.getMonth()
                                                                : "" + etDate.getMonth());
                                                etYear.setText(yString + etDate.getYear());
                                        } else {
                                                grDate = new GregDate(01, Integer.parseInt(mm), Integer.parseInt(yy));

                                                etDate = BahireCalc.ToEthiopian(grDate);

                                                String yString = BahireCalc.grYearString(grDate);

                                                etMonth.setText(grDate.getM() < 10 ? "0" + grDate.getM()
                                                                : "" + grDate.getM());
                                                etYear.setText(yString + grDate.getY());
                                        }
                                        repaint();
                                        remove(enterButton);
                                } catch (Exception eee) {
                                        JLabel message = new JLabel(deflang ? "የተሳሳተ ግብዓት" : "Invalid Input");
                                        message.setFont(new Font("Power Geez Unicode1", Font.PLAIN, 18));
                                        message.setForeground(Color.red);
                                        JOptionPane.showMessageDialog(this, message, "Error",
                                                        JOptionPane.ERROR_MESSAGE);
                                }

                        }
                }

                @Override
                protected void paintComponent(Graphics g) {
                        // TODO Auto-generated method stub
                        super.paintComponent(g);
                        g.setColor(Color.black);
                        g.drawRoundRect(100, 50, 350, 200, 25, 25);
                        g.drawRoundRect(5, 300, 540, 320, 15, 15);
                        g.setFont(new Font("Power Geez Unicode1", Font.PLAIN, 25));

                        if (defcal)
                                g.drawString(deflang
                                                ? BahireCalc.get_ወር(etDate.getMonth())
                                                                + " "
                                                                + (defnum ? BahireCalc.toEthiopic(etDate.getYear() + "")
                                                                                : BahireCalc.etYearString(etDate)
                                                                                                + etDate.getYear())
                                                                + " ዓ.ም "
                                                : BahireCalc.get_et_month(etDate.getMonth())
                                                                + " "
                                                                + (defnum ? BahireCalc.toEthiopic(etDate.getYear() + "")
                                                                                : BahireCalc.etYearString(etDate)
                                                                                                + etDate.getYear())
                                                                + " E.C",
                                                150, 230);
                        else {
                                g.drawString(deflang
                                                ? BahireCalc.get_greg_ወር(grDate.getM()) + " "
                                                                + (defnum ? BahireCalc.toEthiopic(grDate.getY() + "")
                                                                                : BahireCalc.grYearString(grDate)
                                                                                                + grDate.getY())
                                                                + " እ.ኤ.አ"
                                                : BahireCalc.get_greg_month(grDate.getM())
                                                                + " "
                                                                + (defnum ? BahireCalc.toEthiopic(grDate.getY() + "")
                                                                                : BahireCalc.grYearString(grDate)
                                                                                                + grDate.getY())
                                                                + " G.C",
                                                150, 230);
                        }

                        g.setFont(new Font("Power Geez Unicode1", Font.PLAIN, 18));

                        g.drawString(deflang ? "እሁድ  ሠኞ  ማግሠኞ ረቡዕ  ሀሙስ  ዐርብ  ቅዳሜ"
                                        : "Sun   Mon   Tue   Wed   Thu    Fri    Sat",
                                        80, 330);

                        int stopday = 31; // most months have 31 days

                        if (defcal) {
                                stopday = 30;
                                if (etDate.getMonth() == 13)
                                        stopday = ቀን.ዘመነ_ዮሐንስ(etDate.getYear() + 1) ? 6 : 5;
                        } else {
                                switch (grDate.getM()) {
                                        case 2: // the length of February varies
                                                stopday = (GregDate.leap_year(grDate.getY())) ? 29 : 28;
                                                break;
                                        case 4:
                                        case 6:
                                        case 9:
                                        case 11:
                                                stopday = 30; // the rest have 30 days
                                                break;
                                }
                        }

                        int ዕለት_ማስያ = BahireCalc.ዕለት(etDate);
                        int temp_ቀን = (ዕለት_ማስያ == 0) ? -5 : 2 - ዕለት_ማስያ;

                        for (int i = 0, k = 1; i < 6; i++, k++) {
                                for (int j = temp_ቀን, l = 1; j <= temp_ቀን + 6; j++, l++) {
                                        if (l == 1)
                                                g.setColor(Color.red);
                                        else
                                                g.setColor(new Color(0, 153, 204));

                                        g.fillOval(20 + l * 60, 320 + k * 40, 40, 35);
                                        g.setColor(Color.white);
                                        if (j < 1 || j > stopday) {
                                                // g.drawString("", 30 + l * 60, 320 + k * 40);
                                        } else
                                                g.drawString(((j < 10 && j > 0)
                                                                ? (defnum ? BahireCalc.toEthiopic(j + "") : "0" + j)
                                                                : (defnum
                                                                                ? BahireCalc.toEthiopic(j + "")
                                                                                : j + "")),
                                                                30 + l * 60,
                                                                345 + k * 40);

                                }
                                temp_ቀን += 7;
                        }
                }

                @Override
                public void mouseClicked(MouseEvent e) {
                        enterButton = new JButton(new ImageIcon("images/entericon.png"));
                        enterButton.setBounds(350, 110, 50, 30);
                        enterButton.setActionCommand("enter");
                        enterButton.addActionListener(this);
                        enterButton.setBackground(Color.white);
                        enterButton.setBorderPainted(false);
                        enterButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
                        add(enterButton);
                        enterButton.setVisible(false);
                        enterButton.setVisible(true);

                }

                @Override
                public void mouseEntered(MouseEvent e) {
                        // TODO Auto-generated method stub
                }

                @Override
                public void mouseExited(MouseEvent e) {
                        // TODO Auto-generated method stub
                }

                @Override
                public void mousePressed(MouseEvent e) {
                        // TODO Auto-generated method stub
                }

                @Override
                public void mouseReleased(MouseEvent e) {
                        // TODO Auto-generated method stub
                }

        }

        private class DateConverter extends JPanel implements ActionListener, MouseListener {
                DateConverter() {
                        super(null);
                        etDate = new ቀን();
                        grDate = BahireCalc.ToGregorian(etDate);

                        setBounds(370, 10, 550, 690);
                        setBackground(Color.white);// new Color(0, 153, 204)

                        JButton btup1 = new JButton(upward);
                        btup1.setBounds(25, 300, 50, 30);
                        btup1.setActionCommand("Ethicv");
                        btup1.setBackground(new Color(0, 177, 93));
                        // btup1.setBackground(Color.white);
                        btup1.setCursor(new Cursor(Cursor.HAND_CURSOR));
                        btup1.addActionListener(this);
                        add(btup1);

                        JButton btupan = new JButton(upward);
                        btupan.setBounds(90, 300, 50, 30);
                        btupan.setActionCommand("eThicv");
                        btupan.setBackground(Color.yellow);
                        btupan.setCursor(new Cursor(Cursor.HAND_CURSOR));
                        btupan.addActionListener(this);
                        add(btupan);

                        JButton btup3 = new JButton(upward);
                        btup3.setBounds(165, 300, 70, 30);
                        btup3.setActionCommand("etHicv");
                        btup3.setBackground(Color.red);
                        btup3.setCursor(new Cursor(Cursor.HAND_CURSOR));
                        btup3.addActionListener(this);
                        add(btup3);

                        etDay = new JTextField(etDate.getDay() < 10 ? "0" + etDate.getDay() : etDate.getDay() + "");
                        // etDay.setBackground(new Color(0, 177, 93));
                        etDay.setForeground(Color.black);
                        etDay.setBounds(20, 335, 60, 40);
                        etDay.addMouseListener(this);
                        etDay.setFont(new Font("Power Geez Unicode1", Font.BOLD, 30));
                        add(etDay);

                        etMonth = new JTextField(
                                        etDate.getMonth() < 10 ? "0" + etDate.getMonth() : etDate.getMonth() + "");
                        // etMonth.setBackground(Color.yellow);// new Color(0, 153, 204));
                        etMonth.setForeground(Color.black);
                        etMonth.setBounds(85, 335, 60, 40);
                        etMonth.addMouseListener(this);
                        etMonth.setFont(new Font("Power Geez Unicode1", Font.BOLD, 30));
                        add(etMonth);

                        etYear = new JTextField(BahireCalc.etYearString(etDate) + etDate.getYear());
                        // etYear.setBackground(Color.red);// new Color(0, 153, 204));
                        etYear.setForeground(Color.black);
                        etYear.addMouseListener(this);
                        etYear.setBounds(155, 335, 90, 40);
                        etYear.setFont(new Font("Power Geez Unicode1", Font.BOLD, 30));
                        add(etYear);

                        JButton btdw1 = new JButton(downward);
                        btdw1.setBounds(25, 380, 50, 30);
                        btdw1.setActionCommand("ethIcv");
                        btdw1.setBackground(new Color(0, 177, 93));
                        btdw1.setBorderPainted(false);
                        btdw1.setCursor(new Cursor(Cursor.HAND_CURSOR));
                        btdw1.addActionListener(this);
                        add(btdw1);

                        JButton btdw2 = new JButton(downward);
                        btdw2.setBounds(90, 380, 50, 30);
                        btdw2.setActionCommand("ethiCv");
                        btdw2.setBackground(Color.yellow);
                        btdw2.setCursor(new Cursor(Cursor.HAND_CURSOR));
                        btdw2.addActionListener(this);
                        add(btdw2);

                        JButton btdw3 = new JButton(downward);
                        btdw3.setBounds(165, 380, 70, 30);
                        btdw3.setActionCommand("ethicV");
                        btdw3.setBackground(Color.red);
                        btdw3.setCursor(new Cursor(Cursor.HAND_CURSOR));
                        btdw3.addActionListener(this);
                        add(btdw3);

                        JButton grup1 = new JButton(upward);
                        grup1.setBounds(320, 300, 50, 30);
                        grup1.setActionCommand("Gregcv");
                        grup1.setBackground(new Color(0, 153, 204));
                        grup1.setCursor(new Cursor(Cursor.HAND_CURSOR));
                        grup1.addActionListener(this);
                        add(grup1);

                        JButton grup2 = new JButton(upward);
                        grup2.setBounds(385, 300, 50, 30);
                        grup2.setActionCommand("gRegcv");
                        grup2.setBackground(new Color(0, 153, 204));
                        grup2.setCursor(new Cursor(Cursor.HAND_CURSOR));
                        grup2.addActionListener(this);
                        add(grup2);
                        JButton grup3 = new JButton(upward);
                        grup3.setBounds(460, 300, 70, 30);
                        grup3.setActionCommand("grEgcv");
                        grup3.setBackground(new Color(0, 153, 204));
                        grup3.setCursor(new Cursor(Cursor.HAND_CURSOR));
                        grup3.addActionListener(this);
                        add(grup3);

                        grDay = new JTextField(grDate.getD() < 10 ? "0" + grDate.getD() : grDate.getD() + "");
                        // grDay.setBackground(new Color(0, 153, 204));
                        grDay.setForeground(Color.black);
                        grDay.addMouseListener(this);
                        grDay.setBounds(315, 335, 60, 40);
                        grDay.setFont(new Font("Power Geez Unicode1", Font.BOLD, 30));
                        add(grDay);

                        grMonth = new JTextField(grDate.getM() < 10 ? "0" + grDate.getM() : grDate.getM() + "");
                        // grMonth.setBackground(new Color(0, 153, 204));// new Color(0, 153, 204));
                        grMonth.setForeground(Color.black);
                        grMonth.addMouseListener(this);
                        grMonth.setBounds(380, 335, 60, 40);
                        grMonth.setFont(new Font("Power Geez Unicode1", Font.BOLD, 30));
                        add(grMonth);

                        grYear = new JTextField(BahireCalc.grYearString(grDate) + grDate.getY());
                        // grYear.setBackground(new Color(0, 153, 204));// new Color(0, 153, 204));
                        grYear.setForeground(Color.black);
                        grYear.addMouseListener(this);
                        grYear.setBounds(450, 335, 90, 40);
                        grYear.setFont(new Font("Power Geez Unicode1", Font.BOLD, 30));
                        add(grYear);

                        JButton grdw1 = new JButton(downward);
                        grdw1.setBounds(320, 380, 50, 30);
                        grdw1.setActionCommand("greGcv");
                        grdw1.setBackground(new Color(0, 153, 204));
                        grdw1.setCursor(new Cursor(Cursor.HAND_CURSOR));
                        grdw1.addActionListener(this);
                        add(grdw1);

                        JButton grdw2 = new JButton(downward);
                        grdw2.setBounds(385, 380, 50, 30);
                        grdw2.setActionCommand("gregCv");
                        grdw2.setBackground(new Color(0, 153, 204));
                        grdw2.setCursor(new Cursor(Cursor.HAND_CURSOR));
                        grdw2.addActionListener(this);
                        add(grdw2);

                        JButton grdw3 = new JButton(downward);
                        grdw3.setBounds(460, 380, 70, 30);
                        grdw3.setActionCommand("gregcV");
                        grdw3.setBackground(new Color(0, 153, 204));
                        grdw3.setCursor(new Cursor(Cursor.HAND_CURSOR));
                        grdw3.addActionListener(this);
                        add(grdw3);

                        enterButton = new JButton();
                        add(enterButton);

                }

                @Override
                public void actionPerformed(ActionEvent e) {
                        if (e.getActionCommand().equalsIgnoreCase("ethicv")
                                        || e.getActionCommand().equalsIgnoreCase("gregcv")) {

                                if (e.getActionCommand().equalsIgnoreCase("ethicv")) {
                                        String dd = etDay.getText().trim();
                                        String mm = etMonth.getText().trim();
                                        String yy = etYear.getText().trim();

                                        try {
                                                etDate = new ቀን(Integer.parseInt(dd), Integer.parseInt(mm),
                                                                Integer.parseInt(yy));
                                                {
                                                        if (e.getActionCommand().equals("Ethicv"))
                                                                etDate = ቀን.incቀን(etDate);
                                                        if (e.getActionCommand().equals("eThicv"))
                                                                etDate = ቀን.incወር(etDate);
                                                        if (e.getActionCommand().equals("etHicv"))
                                                                etDate = ቀን.incዓመት(etDate);
                                                        if (e.getActionCommand().equals("ethIcv"))
                                                                etDate = ቀን.decቀን(etDate);
                                                        if (e.getActionCommand().equals("ethiCv"))
                                                                etDate = ቀን.decወር(etDate);
                                                        if (e.getActionCommand().equals("ethicV"))
                                                                etDate = ቀን.decዓመት(etDate);
                                                }
                                                grDate = BahireCalc.ToGregorian(etDate);
                                        } catch (Exception eee) {
                                                JLabel message = new JLabel(deflang ? "የተሳሳተ ግብዓት" : "Invalid Input");
                                                message.setFont(new Font("Power Geez Unicode1", Font.PLAIN, 18));
                                                message.setForeground(Color.red);
                                                JOptionPane.showMessageDialog(this, message, "Error",
                                                                JOptionPane.ERROR_MESSAGE);
                                        }
                                } else if (e.getActionCommand().equalsIgnoreCase("gregcv")) {

                                        String dd = grDay.getText().trim();
                                        String mm = grMonth.getText().trim();
                                        String yy = grYear.getText().trim();

                                        try {
                                                grDate = new GregDate(Integer.parseInt(dd), Integer.parseInt(mm),
                                                                Integer.parseInt(yy));
                                                {
                                                        if (e.getActionCommand().equals("Gregcv"))
                                                                grDate = GregDate.incDay(grDate);
                                                        if (e.getActionCommand().equals("gRegcv"))
                                                                grDate = GregDate.incMonth(grDate);
                                                        if (e.getActionCommand().equals("grEgcv"))
                                                                grDate = GregDate.incYear(grDate);
                                                        if (e.getActionCommand().equals("greGcv"))
                                                                grDate = GregDate.decDay(grDate);
                                                        if (e.getActionCommand().equals("gregCv"))
                                                                grDate = GregDate.decMonth(grDate);
                                                        if (e.getActionCommand().equals("gregcV"))
                                                                grDate = GregDate.decYear(grDate);
                                                }

                                                etDate = BahireCalc.ToEthiopian(grDate);
                                        } catch (Exception eee) {
                                                JLabel message = new JLabel(deflang ? "የተሳሳተ ግብዓት" : "Invalid Input");
                                                message.setFont(new Font("Power Geez Unicode1", Font.PLAIN, 18));
                                                message.setForeground(Color.red);
                                                JOptionPane.showMessageDialog(this, message, "Error",
                                                                JOptionPane.ERROR_MESSAGE);
                                        }
                                }

                                String yString = BahireCalc.etYearString(etDate);

                                etDay.setText(etDate.getDay() < 10 ? "0" + etDate.getDay()
                                                : "" + etDate.getDay());
                                etMonth.setText(etDate.getMonth() < 10 ? "0" + etDate.getMonth()
                                                : "" + etDate.getMonth());
                                etYear.setText(yString + etDate.getYear());

                                grDay.setText(grDate.getD() < 10 ? "0" + grDate.getD() : "" + grDate.getD());
                                grMonth.setText(grDate.getM() < 10 ? "0" + grDate.getM()
                                                : "" + grDate.getM());
                                grYear.setText(BahireCalc.grYearString(grDate) + grDate.getY());
                                remove(enterButton);
                                repaint();

                        }
                }

                @Override
                protected void paintComponent(Graphics g) {
                        // TODO Auto-generated method stub
                        super.paintComponent(g);
                        g.setColor(Color.black);
                        Image brana1 = Toolkit.getDefaultToolkit().getImage("images/branaConv.jpg");
                        g.drawImage(brana1, 240, 200, this);
                        Image brana = Toolkit.getDefaultToolkit().getImage("images/branaconv2.png");
                        g.drawImage(brana, -10, 200, this);

                        g.setFont(new Font("Power Geez Unicode1", Font.BOLD, 30));

                        g.drawRoundRect(30, 90, 230, 40, 10, 10);
                        g.drawRoundRect(320, 90, 230, 40, 10, 10);

                        g.drawString(deflang ? "የኢትዮጵያውያን" : "Ethiopian", 35, 120);
                        g.setColor(new Color(0, 153, 204));
                        g.drawString(deflang ? "የጎርጎሮሳውያን" : "Gregorian", 325, 120);
                        g.setColor(Color.black);

                        g.setFont(new Font("Power Geez Unicode1", Font.PLAIN, 22));

                        // Ethiopic Numeral
                        if (defnum) {
                                if (deflang)// amharic
                                        g.drawString(BahireCalc.get_ወር(etDate.getMonth())
                                                        + " " + BahireCalc.toEthiopic(etDate.getDay() + "")
                                                        + " "
                                                        + BahireCalc.toEthiopic(etDate.getYear() + "") + " ዓ.ም",
                                                        10, 580);
                                else // english
                                        g.drawString(BahireCalc.get_et_month(etDate.getMonth())
                                                        + " " + BahireCalc.toEthiopic(etDate.getDay() + "")
                                                        + " "
                                                        + BahireCalc.toEthiopic(etDate.getYear() + "") + " E.C",
                                                        10, 580);

                                g.setColor(new Color(0, 153, 204));

                                if (deflang)// amharic
                                        g.drawString(BahireCalc.get_greg_ወር(grDate.getM()) + " " + BahireCalc
                                                        .toEthiopic(grDate.getD() + "") + " "
                                                        + BahireCalc.toEthiopic(grDate.getY() + ""), 320, 580);

                                else// english
                                        g.drawString(BahireCalc.get_greg_month(grDate.getM()) + " "
                                                        + BahireCalc.toEthiopic(grDate.getD() + "")
                                                        + " " +
                                                        BahireCalc.toEthiopic(etDate.getYear() + ""), 320, 580);

                        }

                        // Arabic Numeral
                        else {
                                if (deflang)// amharic
                                        g.drawString(BahireCalc.get_ወር(etDate.getMonth())
                                                        + " " + (etDate.getDay() < 10 ? "0" + etDate.getDay()
                                                                        : etDate.getDay())
                                                        + " "
                                                        + BahireCalc.etYearString(etDate) + etDate.getYear() + " ዓ.ም",
                                                        10, 580);
                                else // english
                                        g.drawString(BahireCalc.get_et_month(etDate.getMonth())
                                                        + " " + (etDate.getDay() < 10 ? "0" + etDate.getDay()
                                                                        : etDate.getDay())
                                                        + " "
                                                        + BahireCalc.etYearString(etDate) + etDate.getYear() + " E.C",
                                                        10, 580);

                                g.setColor(new Color(0, 153, 204));

                                if (deflang)// amharic
                                        g.drawString(BahireCalc.get_greg_ወር(grDate.getM()) + " " + (grDate.getD() < 10
                                                        ? "0" + grDate.getD()
                                                        : grDate.getD()) + " "
                                                        + BahireCalc.grYearString(grDate) + grDate.getY(), 320, 580);

                                else// english
                                        g.drawString(BahireCalc.get_greg_month(grDate.getM()) + " "
                                                        + (grDate.getD() < 10
                                                                        ? "0" + grDate.getD()
                                                                        : grDate.getD())
                                                        + " " +
                                                        BahireCalc.grYearString(grDate) + grDate.getY(), 320, 580);
                        }

                        g.setColor(Color.black);
                }

                @Override
                public void mouseClicked(MouseEvent e) {
                        remove(enterButton);
                        ImageIcon entericon = null;
                        String enteraction = "";
                        if (e.getSource() == etDay || e.getSource() == etMonth || e.getSource() == etYear) {
                                entericon = new ImageIcon("images/entericon.png");
                                enteraction = "ethicv";
                        } else if (e.getSource() == grDay || e.getSource() == grMonth || e.getSource() == grYear) {
                                entericon = new ImageIcon("images/backentericon.png");
                                enteraction = "gregcv";
                        }

                        enterButton = new JButton(entericon);
                        enterButton.setBounds(250, 340, 50, 30);
                        enterButton.setActionCommand(enteraction);
                        enterButton.addActionListener(this);
                        enterButton.setBackground(Color.white);
                        enterButton.setBorderPainted(false);
                        enterButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
                        add(enterButton);
                        enterButton.setVisible(false);
                        enterButton.setVisible(true);

                }

                @Override
                public void mouseEntered(MouseEvent e) {
                        // TODO Auto-generated method stub
                }

                @Override
                public void mouseExited(MouseEvent e) {
                        // TODO Auto-generated method stub
                }

                @Override
                public void mousePressed(MouseEvent e) {
                        // TODO Auto-generated method stub
                }

                @Override
                public void mouseReleased(MouseEvent e) {
                        // TODO Auto-generated method stub
                }
        }

        private class NumConverter extends JPanel implements ActionListener, MouseListener {
                NumConverter() {
                        super(null);
                        setBounds(370, 10, 550, 690);
                        setBackground(Color.white);// new Color(0, 153, 204)

                        etNum = new JTextField("፩");
                        etNum.setBackground(new Color(255, 153, 0));// new Color(0, 153, 204));
                        etNum.setForeground(Color.white);
                        etNum.addMouseListener(this);
                        etNum.setFont(new Font("Power Geez Unicode1", Font.PLAIN, 20));
                        etNum.setBounds(75, 190, 150, 40);
                        etNum.setActionCommand("etNums");
                        etNum.addActionListener(this);
                        add(etNum);

                        arNum = new JTextField("1");
                        arNum.setBackground(new Color(0, 153, 204));// new Color(0, 153, 204));
                        arNum.setForeground(Color.white);
                        arNum.addMouseListener(this);
                        arNum.setFont(new Font("Power Geez Unicode1", Font.PLAIN, 20));
                        arNum.setBounds(358, 190, 150, 40);
                        add(arNum);

                        for (int i = 0, k = 1; i < 4; i++) {
                                for (int j = 0; j < 5; j++) {

                                        JButton etNumNum = new JButton(BahireCalc.etNums[k]);
                                        etNumNum.setBounds(10 + j * 60, 340 + i * 60, 50, 50);
                                        etNumNum.setFont(new Font("Power Geez Unicode1", Font.PLAIN, 18));
                                        etNumNum.setBackground(new Color(255, 153, 0));
                                        etNumNum.setActionCommand("etNum" + k);
                                        etNumNum.setForeground(Color.white);
                                        etNumNum.addActionListener(this);
                                        etNumNum.setCursor(new Cursor(Cursor.HAND_CURSOR));
                                        add(etNumNum);
                                        k++;
                                }
                        }
                        for (int i = 0, k = 1; i < 4; i++) {
                                for (int j = 0; j < 3; j++) {

                                        JButton etNumNum = new JButton(k + "");

                                        etNumNum.setBounds(350 + j * 60, 340 + i * 60, 50, 50);
                                        etNumNum.setFont(new Font("Power Geez Unicode1", Font.PLAIN, 18));
                                        etNumNum.setBackground(new Color(0, 153, 204));
                                        etNumNum.setForeground(Color.white);
                                        etNumNum.setActionCommand("arNum" + k);
                                        etNumNum.addActionListener(this);
                                        etNumNum.setCursor(new Cursor(Cursor.HAND_CURSOR));

                                        if (k == 10) {
                                                etNumNum.setText("-");
                                                etNumNum.removeActionListener(this);
                                        }
                                        if (k == 12) {
                                                etNumNum.setText(".");
                                                etNumNum.removeActionListener(this);
                                        }
                                        if (k == 11) {
                                                etNumNum.setText("0");
                                                etNumNum.setActionCommand("arNum" + "0");
                                        }

                                        add(etNumNum);
                                        k++;
                                }
                        }
                        enterButton = new JButton();
                        add(enterButton);
                }

                @Override
                protected void paintComponent(Graphics g) {
                        // TODO Auto-generated method stub
                        super.paintComponent(g);

                        g.setFont(new Font("Power Geez Unicode1", Font.BOLD, 20));
                        g.setColor(new Color(255, 153, 0));

                        g.drawString(deflang ? "የኢትዮጵያ ቁጥር" : "Ethiopic Numeral", 65, 50);

                        g.drawString(deflang ? "የአረብ ቁጥር" : "Arabic Numeral", 355, 50);

                        Image img1 = Toolkit.getDefaultToolkit().getImage("images/branaNum1.png");
                        g.drawImage(img1, 35, 125, this);
                        Image img2 = Toolkit.getDefaultToolkit().getImage("images/branaNum2.jpg");
                        g.drawImage(img2, 315, 100, this);

                }

                @Override
                public void actionPerformed(ActionEvent e) {
                        // TODO Auto-generated method stub
                        try {

                                if (e.getActionCommand().substring(0, 5).equals("etNum")) {

                                        etNum.setText(etNum.getText().trim()
                                                        + BahireCalc.etNums[Integer
                                                                        .parseInt(e.getActionCommand().substring(5))]);
                                        arNum.setText(BahireCalc.toArabic(etNum.getText().trim()) + "");

                                }

                                else if (e.getActionCommand().substring(0, 5).equals("arNum")) {

                                        // if (e.getActionCommand().substring(5).equals("10"))
                                        // arNum.setText(arNum.getText().trim() + "-");
                                        if (e.getActionCommand().substring(5).equals("11"))
                                                arNum.setText(arNum.getText().trim() + "0");
                                        // else if (e.getActionCommand().substring(5).equals("12"))
                                        // arNum.setText(arNum.getText().trim() + ".");
                                        // else
                                        arNum.setText(arNum.getText().trim() + e.getActionCommand().substring(5));
                                        etNum.setText(BahireCalc.toEthiopic(arNum.getText().trim()));

                                }

                                else if (e.getActionCommand().equals("ethiopic"))
                                        arNum.setText(BahireCalc.toArabic(etNum.getText().trim()) + "");
                                else if (e.getActionCommand().equals("arabic"))
                                        etNum.setText(BahireCalc.toEthiopic(arNum.getText().trim()));

                                repaint();
                                remove(enterButton);
                        } catch (Exception ee) {
                                // TODO: handle exception
                                JLabel message = new JLabel(deflang ? "የተሳሳተ ግብዓት" : "Invalid Input");
                                message.setFont(new Font("Power Geez Unicode1", Font.PLAIN, 18));
                                message.setForeground(Color.red);
                                JOptionPane.showMessageDialog(this, message, "Error",
                                                JOptionPane.ERROR_MESSAGE);
                        }
                }

                @Override
                public void mouseClicked(MouseEvent e) {
                        remove(enterButton);
                        ImageIcon entericon = null;
                        String enteraction = "";
                        if (e.getSource() == etNum) {
                                entericon = new ImageIcon("images/entericon.png");
                                enteraction = "ethiopic";
                        } else if (e.getSource() == arNum) {
                                entericon = new ImageIcon("images/backentericon.png");
                                enteraction = "arabic";
                        }

                        enterButton = new JButton(entericon);
                        enterButton.setBounds(260, 200, 50, 30);
                        enterButton.setActionCommand(enteraction);
                        enterButton.addActionListener(this);
                        enterButton.setBackground(Color.white);
                        enterButton.setBorderPainted(false);
                        enterButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
                        add(enterButton);
                        enterButton.setVisible(false);
                        enterButton.setVisible(true);

                }

                @Override
                public void mouseEntered(MouseEvent e) {
                        // TODO Auto-generated method stub
                }

                @Override
                public void mouseExited(MouseEvent e) {
                        // TODO Auto-generated method stub
                }

                @Override
                public void mousePressed(MouseEvent e) {
                        // TODO Auto-generated method stub
                }

                @Override
                public void mouseReleased(MouseEvent e) {
                        // TODO Auto-generated method stub
                }

        }

        private class Holidays extends JPanel implements ActionListener, MouseListener {

                Holidays() {
                        super(null);
                        etDate = new ቀን();

                        setBounds(370, 10, 550, 690);
                        setBackground(Color.white);//

                        JButton btupan = new JButton(arrowUp);
                        btupan.setBounds(120, 30, 70, 30);
                        btupan.setActionCommand("Hyear");
                        btupan.addActionListener(this);
                        btupan.setBackground(Color.white);
                        btupan.setBorderPainted(false);
                        btupan.setCursor(new Cursor(Cursor.HAND_CURSOR));
                        add(btupan);

                        etYear = new JTextField(BahireCalc.etYearString(etDate) + etDate.getYear());
                        etYear.setBackground(new Color(0, 153, 204));// new Color(0, 153, 204));
                        etYear.setForeground(Color.white);
                        etYear.addMouseListener(this);
                        etYear.setBounds(110, 65, 90, 40);
                        etYear.setFont(new Font("Power Geez Unicode1", Font.BOLD, 30));
                        add(etYear);

                        JButton btdw3 = new JButton(arrowDown);
                        btdw3.setBounds(120, 110, 70, 30);
                        btdw3.setActionCommand("hYear");
                        btdw3.addActionListener(this);
                        btdw3.setBackground(Color.white);
                        btdw3.setBorderPainted(false);
                        btdw3.setCursor(new Cursor(Cursor.HAND_CURSOR));
                        add(btdw3);

                        enterButton = new JButton();
                        add(enterButton);

                }

                @Override
                protected void paintComponent(Graphics g) {

                        super.paintComponent(g);
                        String[] holy2 = new String[6];
                        ቀን ደብረ_ዘይት = BahireCalc.ደብረ_ዘይት(etDate.getYear());
                        ቀን ሆሳዕና = BahireCalc.ሆሳዕና(etDate.getYear());
                        ቀን ስቅለት = BahireCalc.ስቅለት(etDate.getYear());
                        ቀን ትንሣኤ = BahireCalc.ትንሣኤ(etDate.getYear());
                        ቀን ጰራቅሊጦስ = BahireCalc.ጰራቅሊጦስ(etDate.getYear());
                        ቀን ዕርገት = BahireCalc.ዕርገት(etDate.getYear());
                        if (deflang) {
                                holy2[0] = "በዓለ ደብረ ዘይት : " + BahireCalc.get_ወር(ደብረ_ዘይት.getMonth()) + " "
                                                + (defnum ? BahireCalc.toEthiopic(ደብረ_ዘይት.getDay() + "")
                                                                : ደብረ_ዘይት.getDay());
                                holy2[1] = "በዓለ ሆሣዕና : " + BahireCalc.get_ወር(ሆሳዕና.getMonth()) + " "
                                                + (defnum ? BahireCalc.toEthiopic(
                                                                ሆሳዕና.getDay() + "") : ሆሳዕና.getDay());
                                holy2[2] = "በዓለ ስቅለት : " + BahireCalc.get_ወር(ስቅለት.getMonth()) + " "
                                                + (defnum ? BahireCalc.toEthiopic(ስቅለት.getDay() + "") : ስቅለት.getDay());
                                holy2[3] = "በዓለ ትንሣኤ : " + BahireCalc.get_ወር(ትንሣኤ.getMonth()) + " "
                                                + (defnum ? BahireCalc.toEthiopic(ትንሣኤ.getDay() + "") : ትንሣኤ.getDay());
                                holy2[4] = "በዓለ ጰራቅሊጦስ : " + BahireCalc.get_ወር(ጰራቅሊጦስ.getMonth()) + " "
                                                + (defnum ? BahireCalc.toEthiopic(ጰራቅሊጦስ.getDay() + "")
                                                                : ጰራቅሊጦስ.getDay());
                                holy2[5] = "በዓለ ዕርገት : " + BahireCalc.get_ወር(ዕርገት.getMonth()) + " "
                                                + (defnum ? BahireCalc.toEthiopic(ዕርገት.getDay() + "") : ዕርገት.getDay());
                        } else {
                                holy2[0] = "Debre Zeit : " + BahireCalc.get_et_month(ደብረ_ዘይት.getMonth()) + " "
                                                + (defnum ? BahireCalc.toEthiopic(ደብረ_ዘይት.getDay() + "")
                                                                : ደብረ_ዘይት.getDay());
                                holy2[1] = "Hossaina : " + BahireCalc.get_et_month(ሆሳዕና.getMonth()) + " "
                                                + (defnum ? BahireCalc.toEthiopic(
                                                                ሆሳዕና.getDay() + "") : ሆሳዕና.getDay());
                                holy2[2] = "Siklet : " + BahireCalc.get_et_month(ስቅለት.getMonth()) + " " + (defnum
                                                ? BahireCalc.toEthiopic(ስቅለት.getDay() + "")
                                                : ስቅለት.getDay());
                                holy2[3] = "Tnsae : " + BahireCalc.get_et_month(ትንሣኤ.getMonth()) + " " + (defnum
                                                ? BahireCalc.toEthiopic(ትንሣኤ.getDay() + "")
                                                : ትንሣኤ.getDay());
                                holy2[4] = "Peraqlitos : " + BahireCalc.get_et_month(ጰራቅሊጦስ.getMonth()) + " "
                                                + (defnum ? BahireCalc.toEthiopic(ጰራቅሊጦስ.getDay() + "")
                                                                : ጰራቅሊጦስ.getDay());
                                holy2[5] = "Erget : " + BahireCalc.get_et_month(ዕርገት.getMonth()) + " " + (defnum
                                                ? BahireCalc.toEthiopic(ዕርገት.getDay() + "")
                                                : ዕርገት.getDay());

                        }
                        // TODO Auto-generated method stub
                        g.setColor(Color.black);

                        // g.drawRoundRect(50, 10, 450, 150, 25, 25);

                        g.setColor(new Color(0, 153, 204));
                        g.fillRoundRect(40, 10, 470, 670, 20, 20);

                        g.setColor(Color.white);
                        g.fillOval(80, 10, 150, 150);
                        g.fillRoundRect(230, 35, 260, 100, 15, 15);
                        g.fillRoundRect(50, 200, 450, 60, 20, 20);
                        g.fillRoundRect(50, 280, 450, 60, 20, 20);
                        g.fillRoundRect(50, 360, 450, 60, 20, 20);
                        g.fillRoundRect(50, 440, 450, 60, 20, 20);
                        g.fillRoundRect(50, 520, 450, 60, 20, 20);
                        g.fillRoundRect(50, 600, 450, 60, 20, 20);

                        g.setColor(Color.black);
                        g.setFont(new Font("Power Geez Unicode1", Font.PLAIN, 25));
                        g.drawString(deflang
                                        ? " የ" + (defnum ? BahireCalc.toEthiopic(
                                                        etDate.getYear() + "")
                                                        : BahireCalc.etYearString(etDate) + etDate.getYear())
                                                        + " ዓ.ም "
                                        : " " + (defnum ? BahireCalc.toEthiopic(
                                                        etDate.getYear() + "")
                                                        : BahireCalc.etYearString(etDate) + etDate.getYear())
                                                        + "`s",
                                        250, 70);
                        g.drawString(deflang ? "የበዓላት ማውጫ" : "Holidays List", 250, 110);

                        g.setFont(new Font("Power Geez Unicode1", Font.PLAIN, 22));

                        g.drawString(holy2[0], 100, 240);
                        g.drawString(holy2[1], 100, 320);
                        g.drawString(holy2[2], 100, 400);
                        g.drawString(holy2[3], 100, 480);
                        g.drawString(holy2[4], 100, 560);
                        g.drawString(holy2[5], 100, 640);
                }

                @Override
                public void actionPerformed(ActionEvent e) {
                        if (e.getActionCommand().equalsIgnoreCase("hyear")) {
                                String yy = etYear.getText().trim();

                                try {
                                        etDate = new ቀን(1, 1, Integer.parseInt(yy));
                                        {
                                                if (e.getActionCommand().equals("Hyear"))
                                                        etDate = ቀን.incዓመት(etDate);
                                                if (e.getActionCommand().equals("hYear"))
                                                        etDate = ቀን.decዓመት(etDate);
                                        }

                                        String yString = BahireCalc.etYearString(etDate);

                                        etYear.setText(yString + etDate.getYear());

                                        repaint();
                                        remove(enterButton);
                                } catch (Exception ee) {
                                        // Invalid input
                                        JLabel message = new JLabel(deflang ? "የተሳሳተ ግብዓት" : "Invalid Input");
                                        message.setFont(new Font("Power Geez Unicode1", Font.PLAIN, 18));
                                        message.setForeground(Color.red);
                                        JOptionPane.showMessageDialog(this, message, "Error",
                                                        JOptionPane.ERROR_MESSAGE);
                                }

                        }

                }

                @Override
                public void mouseClicked(MouseEvent e) {
                        enterButton = new JButton(new ImageIcon("images/entericon.png"));
                        enterButton.setBounds(200, 70, 30, 30);
                        enterButton.setActionCommand("hyear");
                        enterButton.addActionListener(this);
                        enterButton.setBackground(Color.white);
                        enterButton.setBorderPainted(false);
                        enterButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
                        add(enterButton);
                        enterButton.setVisible(false);
                        enterButton.setVisible(true);

                }

                @Override
                public void mouseEntered(MouseEvent e) {
                        // TODO Auto-generated method stub
                }

                @Override
                public void mouseExited(MouseEvent e) {
                        // TODO Auto-generated method stub
                }

                @Override
                public void mousePressed(MouseEvent e) {
                        // TODO Auto-generated method stub
                }

                @Override
                public void mouseReleased(MouseEvent e) {
                        // TODO Auto-generated method stub
                }
        }

        private class Fastings extends JPanel implements ActionListener, MouseListener {

                Fastings() {
                        super(null);
                        etDate = new ቀን();

                        setBounds(370, 10, 550, 690);
                        setBackground(Color.white);// new Color(0, 153, 204)

                        JButton btupan = new JButton(arrowUp);
                        btupan.setBounds(120, 30, 70, 30);
                        btupan.setActionCommand("Fyear");
                        btupan.addActionListener(this);
                        btupan.setBackground(new Color(0, 153, 204));
                        btupan.setBorderPainted(false);
                        btupan.setCursor(new Cursor(Cursor.HAND_CURSOR));
                        add(btupan);

                        etYear = new JTextField(BahireCalc.etYearString(etDate) + etDate.getYear());
                        etYear.setBackground(Color.white);// new Color(0, 153, 204));
                        // etYear.setForeground(Color.white);
                        etYear.setBounds(110, 65, 90, 40);
                        etYear.addMouseListener(this);
                        etYear.setFont(new Font("Power Geez Unicode1", Font.BOLD, 30));
                        add(etYear);

                        JButton btdw3 = new JButton(arrowDown);
                        btdw3.setBounds(120, 110, 70, 30);
                        btdw3.setActionCommand("fYear");
                        btdw3.addActionListener(this);
                        btdw3.setBackground(new Color(0, 153, 204));
                        btdw3.setBorderPainted(false);
                        btdw3.setCursor(new Cursor(Cursor.HAND_CURSOR));
                        add(btdw3);

                        enterButton = new JButton();
                        add(enterButton);

                }

                @Override
                protected void paintComponent(Graphics g) {
                        // TODO Auto-generated method stub
                        super.paintComponent(g);

                        String[] tsom2 = new String[4];
                        ቀን ድኅነት = BahireCalc.ጾመ_ድኅነት(etDate.getYear());
                        ቀን ነነዌ = BahireCalc.ጾመ_ነነዌ(etDate.getYear());
                        ቀን ዓቢይ_ጾም = BahireCalc.ዓቢይ_ጾም(etDate.getYear());
                        ቀን ጾመ_ሐዋርያት = BahireCalc.ጾመ_ሐዋርያት(etDate.getYear());
                        if (deflang) {
                                tsom2[0] = "ጾመ ድኅነት : " + BahireCalc.get_ወር(ድኅነት.getMonth()) + " "
                                                + (defnum ? BahireCalc.toEthiopic(ድኅነት.getDay() + "") : ድኅነት.getDay());
                                tsom2[1] = "ጾመ ነነዌ : " + BahireCalc.get_ወር(ነነዌ.getMonth()) + " " + (defnum
                                                ? BahireCalc.toEthiopic(ነነዌ.getDay() + "")
                                                : ነነዌ.getDay());
                                tsom2[2] = "ዓቢይ ጾም : " + BahireCalc.get_ወር(ዓቢይ_ጾም.getMonth()) + " " + (defnum
                                                ? BahireCalc.toEthiopic(ዓቢይ_ጾም.getDay() + "")
                                                : ዓቢይ_ጾም.getDay());
                                tsom2[3] = "ጾመ ሐዋርያት : " + BahireCalc.get_ወር(ጾመ_ሐዋርያት.getMonth()) + " "
                                                + (defnum ? BahireCalc.toEthiopic(ጾመ_ሐዋርያት.getDay() + "")
                                                                : ጾመ_ሐዋርያት.getDay());
                        } else {
                                tsom2[0] = "Tsome Dihnet : " + BahireCalc.get_et_month(ድኅነት.getMonth()) + " "
                                                + (defnum ? BahireCalc.toEthiopic(ድኅነት.getDay() + "") : ድኅነት.getDay());
                                tsom2[1] = "Tsome Nenewie : " + BahireCalc.get_et_month(ነነዌ.getMonth()) + " "
                                                + (defnum ? BahireCalc.toEthiopic(ነነዌ.getDay() + "") : ነነዌ.getDay());
                                tsom2[2] = "Abiy Tsom : " + BahireCalc.get_et_month(ዓቢይ_ጾም.getMonth()) + " "
                                                + (defnum ? BahireCalc.toEthiopic(
                                                                ዓቢይ_ጾም.getDay() + "") : ዓቢይ_ጾም.getDay());
                                tsom2[3] = "Tsome Hawariyat : " + BahireCalc.get_et_month(ጾመ_ሐዋርያት.getMonth()) + " "
                                                + (defnum ? BahireCalc.toEthiopic(
                                                                ጾመ_ሐዋርያት.getDay() + "") : ጾመ_ሐዋርያት.getDay());
                        }
                        g.setColor(Color.black);

                        // g.drawRoundRect(50, 10, 450, 150, 25, 25);

                        g.setColor(Color.white);
                        g.fillRoundRect(40, 10, 470, 670, 20, 20);

                        g.setColor(new Color(0, 153, 204));
                        g.fillOval(80, 10, 150, 150);
                        g.fillRoundRect(230, 35, 260, 100, 15, 15);

                        g.fillRoundRect(50, 200, 450, 80, 20, 20);
                        g.fillRoundRect(50, 320, 450, 80, 20, 20);
                        g.fillRoundRect(50, 440, 450, 80, 20, 20);
                        g.fillRoundRect(50, 560, 450, 80, 20, 20);

                        g.setColor(Color.white);
                        g.setFont(new Font("Power Geez Unicode1", Font.PLAIN, 25));
                        g.drawString(deflang ? " የ" + (defnum ? BahireCalc.toEthiopic(etDate.getYear() + "")
                                        : BahireCalc.etYearString(etDate) + etDate.getYear()) + " ዓ.ም "
                                        : " " + (defnum ? BahireCalc.toEthiopic(etDate.getYear() + "")
                                                        : BahireCalc.etYearString(etDate) + etDate.getYear()) + "`s",
                                        250, 70);
                        g.drawString(deflang ? "የአጽዋማት ማውጫ" : "Fastings List", 250, 110);

                        g.setFont(new Font("Power Geez Unicode1", Font.PLAIN, 22));

                        g.drawString(tsom2[0], 70, 240);
                        g.drawString(tsom2[1], 70, 360);
                        g.drawString(tsom2[2], 70, 480);
                        g.drawString(tsom2[3], 70, 600);
                }

                @Override
                public void actionPerformed(ActionEvent e) {
                        // TODO Auto-generated method stub
                        if (e.getActionCommand().equalsIgnoreCase("fyear")) {
                                String yy = etYear.getText().trim();

                                try {
                                        etDate = new ቀን(1, 1, Integer.parseInt(yy));
                                        {
                                                if (e.getActionCommand().equals("Fyear"))
                                                        etDate = ቀን.incዓመት(etDate);
                                                if (e.getActionCommand().equals("fYear"))
                                                        etDate = ቀን.decዓመት(etDate);
                                        }
                                        String yString = BahireCalc.etYearString(etDate);

                                        etYear.setText(yString + etDate.getYear());

                                        repaint();
                                        remove(enterButton);
                                } catch (Exception ee) {
                                        // Invalid input
                                        JLabel message = new JLabel(deflang ? "የተሳሳተ ግብዓት" : "Invalid Input");
                                        message.setFont(new Font("Power Geez Unicode1", Font.PLAIN, 18));
                                        message.setForeground(Color.red);
                                        JOptionPane.showMessageDialog(this, message, "Error",
                                                        JOptionPane.ERROR_MESSAGE);
                                }
                        }
                }

                @Override
                public void mouseClicked(MouseEvent e) {
                        enterButton = new JButton(new ImageIcon("images/entericon.png"));
                        enterButton.setBounds(200, 70, 30, 30);
                        enterButton.setActionCommand("fyear");
                        enterButton.addActionListener(this);
                        enterButton.setBackground(new Color(0, 153, 204));
                        enterButton.setBorderPainted(false);
                        enterButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
                        add(enterButton);
                        enterButton.setVisible(false);
                        enterButton.setVisible(true);

                }

                @Override
                public void mouseEntered(MouseEvent e) {
                        // TODO Auto-generated method stub
                }

                @Override
                public void mouseExited(MouseEvent e) {
                        // TODO Auto-generated method stub
                }

                @Override
                public void mousePressed(MouseEvent e) {
                        // TODO Auto-generated method stub
                }

                @Override
                public void mouseReleased(MouseEvent e) {
                        // TODO Auto-generated method stub
                }
        }

        private class Find_ዕለት extends JPanel implements ActionListener, MouseListener {

                Find_ዕለት() {
                        super(null);
                        etDate = new ቀን();
                        setBounds(370, 10, 550, 690);
                        setBackground(Color.white);// new Color(0, 153, 204)

                        JButton btup1 = new JButton(upward);
                        btup1.setBounds(170, 210, 50, 30);
                        btup1.setActionCommand("Finday");
                        btup1.addActionListener(this);
                        btup1.setBackground(Color.white);
                        btup1.setCursor(new Cursor(Cursor.HAND_CURSOR));
                        add(btup1);

                        JButton btup2 = new JButton(upward);
                        btup2.setBounds(235, 210, 50, 30);
                        btup2.setActionCommand("fInday");
                        btup2.addActionListener(this);
                        btup2.setBackground(Color.white);
                        btup2.setCursor(new Cursor(Cursor.HAND_CURSOR));
                        add(btup2);

                        JButton btup3 = new JButton(upward);
                        btup3.setBounds(310, 210, 70, 30);
                        btup3.setActionCommand("fiNday");
                        btup3.addActionListener(this);
                        btup3.setBackground(Color.white);
                        btup3.setCursor(new Cursor(Cursor.HAND_CURSOR));
                        add(btup3);

                        etDay = new JTextField(etDate.getDay() < 10 ? "0" + etDate.getDay() : etDate.getDay() + "");
                        etDay.setBackground(new Color(0, 177, 93));
                        etDay.addActionListener(this);
                        etDay.setForeground(Color.black);
                        etDay.setBounds(165, 245, 60, 40);
                        etDay.addMouseListener(this);
                        etDay.setFont(new Font("Power Geez Unicode1", Font.BOLD, 30));
                        add(etDay);

                        etMonth = new JTextField(
                                        etDate.getMonth() < 10 ? "0" + etDate.getMonth() : etDate.getMonth() + "");
                        etMonth.setBackground(Color.yellow);// new Color(0, 153, 204));
                        etMonth.setForeground(Color.black);
                        etMonth.setBounds(230, 245, 60, 40);
                        etMonth.addMouseListener(this);
                        etMonth.setFont(new Font("Power Geez Unicode1", Font.BOLD, 30));
                        add(etMonth);

                        etYear = new JTextField(BahireCalc.etYearString(etDate) + etDate.getYear());
                        etYear.setBackground(Color.red);// new Color(0, 153, 204));
                        etYear.setForeground(Color.black);
                        etYear.addMouseListener(this);
                        etYear.setBounds(300, 245, 90, 40);
                        etYear.setFont(new Font("Power Geez Unicode1", Font.BOLD, 30));
                        add(etYear);

                        JButton btdw1 = new JButton(downward);
                        btdw1.setBounds(170, 290, 50, 30);
                        btdw1.setActionCommand("finDay");
                        btdw1.addActionListener(this);
                        btdw1.setBackground(Color.white);
                        btdw1.setCursor(new Cursor(Cursor.HAND_CURSOR));
                        add(btdw1);

                        JButton btdw2 = new JButton(downward);
                        btdw2.setBounds(235, 290, 50, 30);
                        btdw2.setActionCommand("findAy");
                        btdw2.addActionListener(this);
                        btdw2.setBackground(Color.white);
                        btdw2.setCursor(new Cursor(Cursor.HAND_CURSOR));
                        add(btdw2);

                        JButton btdw3 = new JButton(downward);
                        btdw3.setBounds(310, 290, 70, 30);
                        btdw3.setActionCommand("findaY");
                        btdw3.addActionListener(this);
                        btdw3.setBackground(Color.white);
                        btdw3.setCursor(new Cursor(Cursor.HAND_CURSOR));
                        add(btdw3);

                        enterButton = new JButton();
                        add(enterButton);
                }

                @Override
                protected void paintComponent(Graphics g) {
                        // TODO Auto-generated method stub
                        super.paintComponent(g);
                        Image img = Toolkit.getDefaultToolkit().getImage("images/branaside.png");

                        g.setColor(new Color(0, 153, 204));
                        g.fillRoundRect(40, 50, 470, 570, 20, 20);
                        g.setColor(Color.white);
                        g.fillRoundRect(50, 60, 450, 60, 10, 10);
                        g.fillRoundRect(100, 450, 350, 130, 10, 10);
                        g.setColor(Color.black);

                        g.setFont(new Font("Power Geez Unicode1", Font.PLAIN, 25));
                        g.drawString(deflang ? "ዕለቱን ለማወቅ የሚፈልጉትን ቀን ያስገቡ" : "Enter The Date You Want To Know", 50,
                                        100);
                        if (deflang) {
                                g.drawString(" " + BahireCalc.get_ወር(etDate.getMonth()) + " "
                                                + (defnum ? BahireCalc.toEthiopic(etDate.getDay() + "")
                                                                : (etDate.getDay() < 10
                                                                                ? "0" + etDate.getDay()
                                                                                : etDate.getDay() + ""))
                                                + " "
                                                + (defnum ? BahireCalc.toEthiopic(etDate.getYear() + "")
                                                                : BahireCalc.etYearString(etDate) + etDate.getYear())
                                                + " ዓ.ም", 120,
                                                500);
                                g.drawString(" በዕለተ " + BahireCalc.የሳምንቱ_ዕለታት[BahireCalc.ዕለት(etDate)] +
                                                " ይውላል።", 120, 550);
                        } else {
                                g.drawString(" " + BahireCalc.get_et_month(etDate.getMonth()) + " "
                                                + (defnum ? BahireCalc.toEthiopic(etDate.getDay() + "")
                                                                : (etDate.getDay() < 10
                                                                                ? "0" + etDate.getDay()
                                                                                : etDate.getDay() + ""))
                                                + " "
                                                + (defnum ? BahireCalc.toEthiopic(etDate.getYear() + "")
                                                                : BahireCalc.etYearString(etDate) + etDate.getYear())
                                                + " E.C", 120,
                                                500);
                                g.drawString(" will be on " + BahireCalc.የሳምንቱ_days[BahireCalc.ዕለት(etDate)] + ".", 120,
                                                550);
                        }
                        g.drawImage(img, 110, 140, this);

                }

                @Override
                public void actionPerformed(ActionEvent e) {
                        if (e.getActionCommand().equalsIgnoreCase("finday")) {
                                String dd = etDay.getText().trim();
                                String mm = etMonth.getText().trim();
                                String yy = etYear.getText().trim();

                                try {
                                        etDate = new ቀን(Integer.parseInt(dd), Integer.parseInt(mm),
                                                        Integer.parseInt(yy));
                                        {
                                                if (e.getActionCommand().equals("Finday"))
                                                        etDate = ቀን.incቀን(etDate);
                                                if (e.getActionCommand().equals("fInday"))
                                                        etDate = ቀን.incወር(etDate);
                                                if (e.getActionCommand().equals("fiNday"))
                                                        etDate = ቀን.incዓመት(etDate);
                                                if (e.getActionCommand().equals("finDay"))
                                                        etDate = ቀን.decቀን(etDate);
                                                if (e.getActionCommand().equals("findAy"))
                                                        etDate = ቀን.decወር(etDate);
                                                if (e.getActionCommand().equals("findaY"))
                                                        etDate = ቀን.decዓመት(etDate);
                                        }
                                        String yString = BahireCalc.etYearString(etDate);

                                        etDay.setText(etDate.getDay() < 10 ? "0" + etDate.getDay()
                                                        : "" + etDate.getDay());
                                        etMonth.setText(etDate.getMonth() < 10 ? "0" + etDate.getMonth()
                                                        : "" + etDate.getMonth());
                                        etYear.setText(yString + etDate.getYear());

                                        repaint();
                                        remove(enterButton);
                                } catch (Exception eee) {
                                        //
                                        JLabel message = new JLabel(deflang ? "የተሳሳተ ግብዓት" : "Invalid Input");
                                        message.setFont(new Font("Power Geez Unicode1", Font.PLAIN, 18));
                                        message.setForeground(Color.red);
                                        JOptionPane.showMessageDialog(this, message, "Error",
                                                        JOptionPane.ERROR_MESSAGE);
                                }

                        }

                }

                @Override
                public void mouseClicked(MouseEvent e) {
                        enterButton = new JButton(new ImageIcon("images/entericon.png"));
                        enterButton.setBounds(400, 245, 50, 40);
                        enterButton.setActionCommand("finday");
                        enterButton.addActionListener(this);
                        enterButton.setBackground(Color.white);
                        enterButton.setBorderPainted(false);
                        enterButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
                        add(enterButton);
                        enterButton.setVisible(false);
                        enterButton.setVisible(true);

                }

                @Override
                public void mouseEntered(MouseEvent e) {
                        // TODO Auto-generated method stub
                }

                @Override
                public void mouseExited(MouseEvent e) {
                        // TODO Auto-generated method stub
                }

                @Override
                public void mousePressed(MouseEvent e) {
                        // TODO Auto-generated method stub
                }

                @Override
                public void mouseReleased(MouseEvent e) {
                        // TODO Auto-generated method stub
                }
        }

        private class Basic_Info extends JPanel implements ActionListener, MouseListener {
                Basic_Info() {
                        super(null);
                        etDate = new ቀን();

                        setBounds(370, 10, 550, 690);
                        setBackground(Color.white);// new Color(0, 153, 204)

                        JButton btupan = new JButton(arrowUp);
                        btupan.setBounds(120, 30, 70, 30);
                        btupan.setActionCommand("Basicyear");
                        btupan.setBackground(butfrontColor2);
                        btupan.setCursor(new Cursor(Cursor.HAND_CURSOR));
                        btupan.setBorderPainted(false);
                        btupan.addActionListener(this);
                        add(btupan);

                        etYear = new JTextField(BahireCalc.etYearString(etDate) + etDate.getYear());
                        etYear.setBackground(Color.white);// new Color(0, 153, 204));
                        // etYear.setForeground(Color.white);
                        etYear.setBounds(110, 65, 50 + 40, 30 + 10);
                        etYear.addMouseListener(this);
                        etYear.setFont(new Font("Power Geez Unicode1", Font.BOLD, 30));
                        add(etYear);

                        JButton btdw3 = new JButton(arrowDown);
                        btdw3.setBounds(120, 110, 50 + 20, 30);
                        btdw3.setActionCommand("basicYear");
                        btdw3.setBackground(butfrontColor2);
                        btdw3.setCursor(new Cursor(Cursor.HAND_CURSOR));
                        btdw3.setBorderPainted(false);
                        btdw3.addActionListener(this);
                        add(btdw3);

                        enterButton = new JButton();
                        add(enterButton);

                }

                @Override
                protected void paintComponent(Graphics g) {
                        // TODO Auto-generated method stub
                        super.paintComponent(g);

                        Image img = Toolkit.getDefaultToolkit().getImage("images/branaBasic.jpg");

                        String[] basic = new String[12];
                        if (deflang) {
                                basic[0] = "ወንበር = " + (defnum
                                                ? BahireCalc.toEthiopic(BahireCalc.ወንበር(etDate.getYear()) + "")
                                                : BahireCalc.ወንበር(etDate.getYear()));
                                basic[1] = "ጥንተ ዮን = " + (defnum
                                                ? BahireCalc.toEthiopic(BahireCalc.ጥንተ_ዮን(etDate.getYear()) + "")
                                                : BahireCalc.ጥንተ_ዮን(etDate.getYear()));
                                basic[2] = "መባጃ ሐመር = " + (defnum
                                                ? BahireCalc.toEthiopic(BahireCalc.መባጃ_ሐመር(etDate.getYear()) + "")
                                                : BahireCalc.መባጃ_ሐመር(etDate.getYear()));
                                basic[3] = "መደብ = " + (defnum
                                                ? BahireCalc.toEthiopic(BahireCalc.መደብ(etDate.getYear()) + "")
                                                : BahireCalc.መደብ(etDate.getYear()));
                                basic[4] = "አበቅቴ = " + (defnum
                                                ? BahireCalc.toEthiopic(BahireCalc.አበቅቴ(etDate.getYear()) + "")
                                                : BahireCalc.አበቅቴ(etDate.getYear()));
                                basic[5] = "መጥቅዕ = " + (defnum
                                                ? BahireCalc.toEthiopic(BahireCalc.መጥቅዕ(etDate.getYear()) + "")
                                                : BahireCalc.መጥቅዕ(etDate.getYear()));
                        } else {
                                basic[0] = "Wenber = " + (defnum
                                                ? BahireCalc.toEthiopic(BahireCalc.ወንበር(etDate.getYear()) + "")
                                                : BahireCalc.ወንበር(etDate.getYear()));
                                basic[1] = "Tinte Yon = " + (defnum
                                                ? BahireCalc.toEthiopic(BahireCalc.ጥንተ_ዮን(etDate.getYear()) + "")
                                                : BahireCalc.ጥንተ_ዮን(etDate.getYear()));
                                basic[2] = "Mebaja Hamer = " + (defnum
                                                ? BahireCalc.toEthiopic(BahireCalc.መባጃ_ሐመር(etDate.getYear()) + "")
                                                : BahireCalc.መባጃ_ሐመር(etDate.getYear()));
                                basic[3] = "Medeb = " + (defnum
                                                ? BahireCalc.toEthiopic(BahireCalc.መደብ(etDate.getYear()) + "")
                                                : BahireCalc.መደብ(etDate.getYear()));
                                basic[4] = "Abeqte = " + (defnum
                                                ? BahireCalc.toEthiopic(BahireCalc.አበቅቴ(etDate.getYear()) + "")
                                                : BahireCalc.አበቅቴ(etDate.getYear()));
                                basic[5] = "Metki = " + (defnum
                                                ? BahireCalc.toEthiopic(BahireCalc.መጥቅዕ(etDate.getYear()) + "")
                                                : BahireCalc.መጥቅዕ(etDate.getYear()));
                        }
                        g.drawImage(img, 60, 150, this);
                        g.setColor(new Color(0, 153, 204));
                        g.fillOval(80, 10, 150, 150);
                        g.fillRoundRect(230, 35, 260, 100, 15, 15);

                        g.setColor(Color.black);
                        g.setFont(new Font("Power Geez Unicode1", Font.PLAIN, 22));
                        g.drawString(deflang ? " የ" + (defnum ? BahireCalc.toEthiopic(etDate
                                        .getYear() + "") : BahireCalc.etYearString(etDate) + etDate.getYear()) + " ዓ.ም "
                                        : (defnum ? BahireCalc.toEthiopic(etDate
                                                        .getYear() + "")
                                                        : BahireCalc.etYearString(etDate) + etDate.getYear()) + "`s",
                                        250, 70);
                        g.drawString(deflang ? "መሠረታዊ ስሌቶች " : "Basic Calcuations", 250, 110);

                        g.drawRoundRect(40, 5, 470, 680, 20, 20);

                        g.drawRoundRect(EXIT_ON_CLOSE, DISPOSE_ON_CLOSE, WIDTH, HEIGHT, WIDTH, HEIGHT);
                        g.drawString(basic[0], 180, 280);
                        g.drawString(basic[1], 180, 340);
                        g.drawString(basic[2], 180, 400);
                        g.drawString(basic[3], 180, 460);
                        g.drawString(basic[4], 180, 520);
                        g.drawString(basic[5], 180, 580);

                }

                @Override
                public void actionPerformed(ActionEvent e) {
                        if (e.getActionCommand().equalsIgnoreCase("basicyear")) {

                                String yy = etYear.getText().trim();
                                try {
                                        etDate = new ቀን(1, 1, Integer.parseInt(yy));
                                        {
                                                if (e.getActionCommand().equals("Basicyear"))
                                                        etDate = ቀን.incዓመት(etDate);
                                                if (e.getActionCommand().equals("basicYear"))
                                                        etDate = ቀን.decዓመት(etDate);
                                        }

                                        String yString = BahireCalc.etYearString(etDate);

                                        etYear.setText(yString + etDate.getYear());

                                        repaint();
                                        remove(enterButton);
                                } catch (Exception ee) {
                                        // Invalid input
                                        JLabel message = new JLabel(deflang ? "የተሳሳተ ግብዓት" : "Invalid Input");
                                        message.setFont(new Font("Power Geez Unicode1", Font.PLAIN, 18));
                                        message.setForeground(Color.red);
                                        JOptionPane.showMessageDialog(this, message, "Error",
                                                        JOptionPane.ERROR_MESSAGE);
                                }
                        }

                }

                @Override
                public void mouseClicked(MouseEvent e) {
                        enterButton = new JButton(new ImageIcon("images/entericon.png"));
                        enterButton.setBounds(200, 70, 30, 30);
                        enterButton.setActionCommand("basicyear");
                        enterButton.addActionListener(this);
                        enterButton.setBackground(new Color(0, 153, 204));
                        enterButton.setBorderPainted(false);
                        enterButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
                        add(enterButton);
                        enterButton.setVisible(false);
                        enterButton.setVisible(true);

                }

                @Override
                public void mouseEntered(MouseEvent e) {
                        // TODO Auto-generated method stub
                }

                @Override
                public void mouseExited(MouseEvent e) {
                        // TODO Auto-generated method stub
                }

                @Override
                public void mousePressed(MouseEvent e) {
                        // TODO Auto-generated method stub
                }

                @Override
                public void mouseReleased(MouseEvent e) {
                        // TODO Auto-generated method stub
                }
        }

        private class FrontPage extends JPanel {

                FrontPage() {
                        super(null);
                        setBounds(0, 0, 520, 710);
                        setBackground(Color.white);

                        // JLabel logoLabel = new JLabel(new ImageIcon("images/bahirelogo.png"));
                        // logoLabel.setBounds(186, 186, 128, 128);
                        // add(logoLabel);
                }

                @Override
                protected void paintComponent(Graphics g) {
                        // TODO Auto-generated method stub
                        super.paintComponent(g);
                        Font defaultFont = g.getFont();

                        LocalDate dateNow = LocalDate.now();

                        g.setColor(new Color(0, 153, 204));
                        g.setFont(new Font("Power Geez Unicode1", Font.BOLD, 25));

                        g.drawString((deflang ? BahireCalc.get_greg_ወር(dateNow.getMonthValue())
                                        : dateNow.getMonth()) + " "
                                        + (defnum ? BahireCalc.toEthiopic(
                                                        dateNow.getDayOfMonth() + "")
                                                        : dateNow.getDayOfMonth())
                                        + ", "
                                        + (defnum ? BahireCalc
                                                        .toEthiopic(dateNow.getYear() + "")
                                                        : dateNow.getYear()),
                                        200,
                                        580);
                        g.drawString((deflang ? BahireCalc.የሳምንቱ_ዕለታት[BahireCalc.ዕለት(
                                        new ቀን(dateNow.getDayOfMonth(), dateNow.getMonthValue(),
                                                        dateNow.getYear()))]
                                        : dateNow.getDayOfWeek()) + "", 300, 640);
                        g.setFont(defaultFont);

                        g.drawRoundRect(40, 520, 450, 150, 25, 25);// date and time enclosing rect
                        g.drawOval(30, 30, 460, 460);// enclosing circle

                        g.setFont(new Font("Power Geez Unicode1", Font.PLAIN, defaultFont.getSize() + 2));

                        for (int i = 1; i <= 12; i++) {
                                g.setColor(new Color(0, 153, 204));
                                g.fillOval((int) (260 + (210 * Math.sin(i * 30 * (Math.PI / 180)))) - 15,
                                                (int) (260 - (210 * Math.cos(i * 30 * (Math.PI / 180)))) - 15,
                                                30, 30);
                                g.setColor(Color.white);
                                g.drawString(defnum ? BahireCalc.toEthiopic(i + "") : i + "",
                                                (int) (260 + (210 * Math.sin(i * 30 * (Math.PI / 180))) - 5),
                                                (int) (260 - (210 * Math.cos(i * 30 * (Math.PI / 180)))) + 5);
                        }

                        g.setColor(Color.black);
                        g.fillOval(250, 250, 20, 20);// centre

                        LocalTime t = LocalTime.now();

                        int y = t.getMinute() % 60, z = t.getHour() % 12;

                        int a1 = (int) (260 - (40 * Math.sin(y * 6 * (Math.PI / 180))));
                        int b1 = (int) (260 + (40 * Math.cos(y * 6 * (Math.PI / 180))));
                        int a2 = (int) (260 + (180 * Math.sin(y * 6 * (Math.PI / 180))));
                        int b2 = (int) (260 - (180 * Math.cos(y * 6 * (Math.PI / 180))));

                        int c1 = (int) (260 - (20 * Math.sin(z * 30 * (Math.PI / 180))));
                        int d1 = (int) (260 + (20 * Math.cos(z * 30 * (Math.PI / 180))));
                        int c2 = (int) (260 + (150 * Math.sin(z * 30 * (Math.PI / 180))));
                        int d2 = (int) (260 - (150 * Math.cos(z * 30 * (Math.PI / 180))));
                        // min
                        g.setColor(Color.yellow);
                        g.drawLine(a1, b1, a2, b2);
                        // hour
                        g.setColor(Color.red);
                        g.drawLine(c1, d1, c2, d2);

                        // min
                        g.setColor(Color.yellow);
                        g.setFont(new Font("Power Geez Unicode1", Font.BOLD, 60));
                        if (defnum)
                                g.drawString(BahireCalc.toEthiopic(y + ""), 60, 650);
                        else
                                g.drawString(y < 10 ? "0" + y : y + "", 60, 650);

                        // hour
                        g.setColor(Color.red);
                        if (defnum)
                                g.drawString(BahireCalc.toEthiopic(z + ""), 60, 580);
                        else
                                g.drawString(z < 10 ? "0" + z : z + "", 60, 580);

                }

        }

        JPanel MenuPage() {
                JPanel pan = new JPanel(null);
                pan.setBounds(520, 0, 450, 710);
                pan.setBackground(Color.white);// new Color(0, 153, 204)

                // pan.setBounds(520, 0, 420, 710);
                // pan.setBackground(Color.white);

                // Graphics g = pan.getGraphics();
                // g.setColor(new Color(0, 153, 204));
                // g.fillRoundRect(75, 325, 90, 90, 25, 25);
                // g.fillRoundRect(225, 325, 90, 90, 25, 25);
                // g.fillRoundRect(75, 445, 90, 90, 25, 25);
                // g.fillRoundRect(225, 445, 90, 90, 25, 25);
                // Image logo = Toolkit.getDefaultToolkit().getImage("black-logo.png");
                // g.drawImage(logo, 100, 50, this);

                JLabel logoLabel = new JLabel(new ImageIcon("images/bahirelogo.png"));
                logoLabel.setBounds(130, 60, 128, 128);
                pan.add(logoLabel);

                JButton MenuButton = new JButton(new ImageIcon("images/whitemenu.png"));
                MenuButton.addActionListener(this);
                MenuButton.setActionCommand("menu");
                MenuButton.setBackground(new Color(0, 153, 204));
                MenuButton.addActionListener(this);
                // MenuButton.setBorderPainted(false);
                MenuButton.setBounds(80, 330, 80, 80);
                pan.add(MenuButton);

                JButton setButton = new JButton(new ImageIcon("images/whitesettings.png"));
                setButton.addActionListener(this);
                setButton.setActionCommand("setting");
                setButton.setBackground(new Color(0, 153, 204));
                // setButton.setBorderPainted(false);
                setButton.setBounds(230, 330, 80, 80);
                pan.add(setButton);

                JButton aboutButton = new JButton(new ImageIcon("images/whiteabout.png"));
                aboutButton.addActionListener(this);
                aboutButton.setActionCommand("about");
                aboutButton.setBackground(new Color(0, 153, 204));
                // aboutButton.setBorderPainted(false);
                aboutButton.setBounds(80, 450, 80, 80);
                pan.add(aboutButton);

                JButton shareButton = new JButton(new ImageIcon("images/email.png"));
                shareButton.addActionListener(this);
                shareButton.setActionCommand("contactus");
                shareButton.setBackground(new Color(0, 153, 204));
                // shareButton.setBorderPainted(false);
                shareButton.setBounds(230, 450, 80, 80);
                pan.add(shareButton);

                return pan;

        }

        JPanel Settings() {
                JPanel pan = new JPanel(null);
                pan.setBounds(520, 0, 450, 710);
                pan.setBackground(new Color(0, 102, 102));// new Color(0, 153, 204)

                JLabel logoLabel = new JLabel(new ImageIcon("images/bahirelogo.png"));
                logoLabel.setBounds(130, 60, 128, 128);
                pan.add(logoLabel);

                JLabel langLabel = new JLabel(deflang ? "ቋንቋ" : "Language");
                langLabel.setFont(new Font("Power Geez Unicode1", Font.PLAIN, 17));
                langLabel.setBounds(20, 305, 150, 30);
                langLabel.setForeground(Color.white);
                langLabel.setIcon(new ImageIcon("images/lang-icon.png"));
                pan.add(langLabel);

                Vector<String> lang = new Vector<>();
                lang.add(deflang ? "እንግሊዝኛ" : "English");
                lang.add(deflang ? "አማርኛ" : "Amharic");

                langBox = new JComboBox<>(lang);
                langBox.setFont(new Font("Power Geez Unicode1", Font.PLAIN, 20));
                langBox.setBounds(230, 310, 150, 30);
                langBox.setForeground(new Color(0, 153, 204));
                langBox.setSelectedIndex(deflang ? 1 : 0);
                langBox.setBackground(Color.white);
                pan.add(langBox);

                JLabel numLabel = new JLabel(deflang ? "ቁጥር" : "Numeral");
                numLabel.setFont(new Font("Power Geez Unicode1", Font.PLAIN, 17));
                numLabel.setBounds(20, 375, 150, 30);
                numLabel.setForeground(Color.white);
                numLabel.setIcon(new ImageIcon("images/numconvicon.png"));
                pan.add(numLabel);

                Vector<String> num = new Vector<>();
                num.add(deflang ? "የአረብ" : "Arabic");
                num.add(deflang ? "የኢትዮጵያ" : "Ethiopic");

                numBox = new JComboBox<>(num);
                numBox.setFont(new Font("Power Geez Unicode1", Font.PLAIN, 20));
                numBox.setBounds(230, 380, 150, 30);
                numBox.setSelectedIndex(defnum ? 1 : 0);
                numBox.setForeground(new Color(0, 153, 204));
                numBox.setBackground(Color.white);
                pan.add(numBox);

                JLabel calLabel = new JLabel(deflang ? "የቀን መቁጠሪያ" : "Default Calendar");
                calLabel.setFont(new Font("Power Geez Unicode1", Font.PLAIN, 17));
                calLabel.setBounds(20, 445, 200, 30);
                calLabel.setForeground(Color.white);
                calLabel.setIcon(new ImageIcon("images/calendar2icon.png"));
                pan.add(calLabel);

                Vector<String> cal = new Vector<>();
                cal.add(deflang ? "የጎርጎሮሳውያን" : "Gregorian");
                cal.add(deflang ? "የኢትዮጵያውያን" : "Ethiopian");

                calBox = new JComboBox<>(cal);
                calBox.setFont(new Font("Power Geez Unicode1", Font.PLAIN, 20));
                calBox.setBounds(230, 450, 150, 30);
                calBox.setSelectedIndex(defcal ? 1 : 0);
                calBox.setForeground(new Color(0, 153, 204));
                calBox.setBackground(Color.white);
                pan.add(calBox);

                JButton saveButton = new JButton(new ImageIcon("images/saveButton.png"));
                saveButton.setText(deflang ? "አስቀምጥ" : "Save");
                saveButton.addActionListener(this);
                saveButton.setBackground(Color.white);
                // saveButton.setBorderPainted(false);
                saveButton.setFont(new Font("Power Geez Unicode1", Font.PLAIN, 10));
                saveButton.setBounds(250, 510, 110, 40);
                pan.add(saveButton);

                JButton cancelButton = new JButton(new ImageIcon("images/cancelicon.png"));
                cancelButton.setText(deflang ? "ሰርዝ" : "Cancel");
                cancelButton.addActionListener(this);
                cancelButton.setBackground(Color.white);
                // cancelButton.setBorderPainted(false);
                cancelButton.setFont(new Font("Power Geez Unicode1", Font.PLAIN, 12));
                cancelButton.setBounds(120, 510, 110, 40);
                pan.add(cancelButton);

                return pan;
        }

        JPanel About() {
                JPanel pan = new JPanel(null);
                pan.setBounds(520, 0, 450, 710);
                pan.setBackground(new Color(0, 102, 102));// new Color(0, 153, 204)

                JButton backButton = new JButton(new ImageIcon("images/back.png"));
                backButton.setBounds(10, 30, 100, 30);
                backButton.setBackground(new Color(0, 102, 102));
                backButton.addActionListener(this);
                backButton.setBorderPainted(false);
                backButton.setActionCommand("back");
                pan.add(backButton);

                JLabel logoLabel = new JLabel(new ImageIcon("images/bahirelogo.png"));
                logoLabel.setBounds(130, 60, 128, 128);
                pan.add(logoLabel);

                JLabel devLabel = new JLabel(deflang ? "አበልጻጊ ፡ ኃይለ አምላክ በላቸው" : "Developer : Haileamlak Belachew");
                devLabel.setFont(new Font("Power Geez Unicode1", Font.PLAIN, 18));
                devLabel.setForeground(Color.white);
                devLabel.setBounds(60, 210, 300, 30);
                pan.add(devLabel);

                JLabel phoneLabel = new JLabel(new ImageIcon("images/phone.png"));
                phoneLabel.setFont(new Font("Power Geez Unicode1", Font.PLAIN, 18));
                phoneLabel.setForeground(Color.white);
                phoneLabel.setText("+251906397248");
                phoneLabel.setBounds(65, 250, 200, 40);
                pan.add(phoneLabel);

                JButton emailButton = new JButton(new ImageIcon("images/mail.png"));
                emailButton.setFont(new Font("Power Geez Unicode1", Font.PLAIN, 18));
                emailButton.setForeground(Color.white);
                emailButton.setBackground(new Color(0, 102, 102));
                emailButton.addActionListener(this);
                emailButton.setText("haileamlakbeat@gmail.com");
                emailButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
                emailButton.setBounds(60, 300, 300, 40);
                emailButton.setBorderPainted(false);
                pan.add(emailButton);

                JButton linkedinButton = new JButton(new ImageIcon("images/linkedin.png"));
                linkedinButton.setFont(new Font("Power Geez Unicode1", Font.PLAIN, 18));
                linkedinButton.setForeground(Color.white);
                linkedinButton.setBackground(new Color(0, 102, 102));
                linkedinButton.addActionListener(this);
                linkedinButton.setText("Haileamlak Belachew");
                linkedinButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
                linkedinButton.setBounds(60, 350, 250, 40);
                linkedinButton.setBorderPainted(false);
                pan.add(linkedinButton);

                JButton instaButton = new JButton(new ImageIcon("images/instagram.png"));
                instaButton.setFont(new Font("Power Geez Unicode1", Font.PLAIN, 18));
                instaButton.setForeground(Color.white);
                instaButton.setBackground(new Color(0, 102, 102));
                instaButton.addActionListener(this);
                instaButton.setText("haileamlak_belachew");
                instaButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
                instaButton.setBounds(60, 400, 250, 40);
                instaButton.setBorderPainted(false);
                pan.add(instaButton);

                return pan;
        }

        @Override
        public void actionPerformed(ActionEvent e) {

                if (e.getActionCommand().equalsIgnoreCase("buttons")) {
                        bigPanel.remove(p1);
                        bigPanel.remove(pTemp);
                        if (e.getActionCommand().equals("Buttons")) {
                                p1 = mainPan(1);
                                pTemp = new Calender();
                        }
                        if (e.getActionCommand().equals("bUttons")) {
                                p1 = mainPan(2);
                                pTemp = new DateConverter();
                        }
                        if (e.getActionCommand().equals("buTtons")) {
                                p1 = mainPan(3);
                                pTemp = new NumConverter();
                        }
                        if (e.getActionCommand().equals("butTons")) {
                                p1 = mainPan(4);
                                pTemp = new Holidays();
                        }
                        if (e.getActionCommand().equals("buttOns")) {
                                p1 = mainPan(5);
                                pTemp = new Fastings();
                        }
                        if (e.getActionCommand().equals("buttoNs")) {
                                p1 = mainPan(6);
                                pTemp = new Find_ዕለት();
                        }
                        if (e.getActionCommand().equals("buttonS")) {
                                p1 = mainPan(7);
                                pTemp = new Basic_Info();
                        }
                        bigPanel.add(p1);
                        bigPanel.add(pTemp);
                        bigPanel.setVisible(false);
                        bigPanel.setVisible(true);
                }

                else if (e.getActionCommand().equals("menu")) {
                        bigPanel.remove(p1);
                        bigPanel.remove(pTemp);
                        pTemp = new FrontPage();
                        p1 = mainPan(0);
                        pTemp.setBounds(370, 10, 550, 690);
                        bigPanel.add(p1);
                        bigPanel.add(pTemp);
                        bigPanel.setVisible(false);
                        bigPanel.setVisible(true);

                }

                else if (e.getActionCommand().equals("MenuPage")) {
                        bigPanel.remove(p1);
                        bigPanel.remove(pTemp);

                        p1 = new FrontPage();
                        pTemp = MenuPage();
                        bigPanel.add(p1);
                        bigPanel.add(pTemp);

                        bigPanel.setVisible(false);
                        bigPanel.setVisible(true);

                }

                else if (e.getActionCommand().equals("setting")) {
                        bigPanel.remove(pTemp);
                        pTemp = Settings();
                        bigPanel.add(pTemp);

                        pTemp.setVisible(false);
                        pTemp.setVisible(true);

                }

                else if (e.getActionCommand().equals("Save") || e.getActionCommand().equals("አስቀምጥ")) {

                        deflang = (langBox.getSelectedItem().equals("Amharic")
                                        || langBox.getSelectedItem().equals("አማርኛ")) ? true : false;
                        defcal = (calBox.getSelectedItem().equals("Ethiopian")
                                        || calBox.getSelectedItem().equals("የኢትዮጵያውያን")) ? true : false;
                        defnum = (numBox.getSelectedItem().equals("Ethiopic")
                                        || numBox.getSelectedItem().equals("የኢትዮጵያ")) ? true : false;

                        bigPanel.remove(pTemp);
                        bigPanel.remove(p1);
                        pTemp = MenuPage();
                        p1 = new FrontPage();
                        bigPanel.add(p1);
                        bigPanel.add(pTemp);
                        bigPanel.setVisible(false);
                        bigPanel.setVisible(true);

                }

                else if (e.getActionCommand().equals("Cancel") || e.getActionCommand().equals("ሰርዝ")) {

                        bigPanel.remove(pTemp);
                        pTemp = MenuPage();
                        bigPanel.add(pTemp);

                        pTemp.setVisible(false);
                        pTemp.setVisible(true);
                }

                else if (e.getActionCommand().equals("contactus")) {
                        Desktop desk = Desktop.getDesktop();

                        try {
                                URI mailto = new URI("mailto:haileamlakbeat@gmail.com?subject=Pagume%207");
                                desk.mail(mailto);

                        } catch (Exception eee) {
                                // TODO: handle exception
                        }

                }

                else if (e.getActionCommand().equals("about")) {

                        bigPanel.remove(pTemp);
                        pTemp = About();
                        bigPanel.add(pTemp);

                        pTemp.setVisible(false);
                        pTemp.setVisible(true);
                }

                else if (e.getActionCommand().equals("back")) {
                        bigPanel.remove(pTemp);
                        pTemp = MenuPage();
                        bigPanel.add(pTemp);

                        pTemp.setVisible(false);
                        pTemp.setVisible(true);
                }

                else if (e.getActionCommand().equals("haileamlakbeat@gmail.com")) {
                        Desktop desk = Desktop.getDesktop();

                        try {
                                URI mailto = new URI("mailto:haileamlakbeat@gmail.com");
                                desk.mail(mailto);

                        } catch (Exception eee) {
                                // TODO: handle exception
                        }
                }

                else if (e.getActionCommand().equals("Haileamlak Belachew")) {
                        Desktop desk = Desktop.getDesktop();
                        try {
                                desk.browse(new URI("https://www.linkedin.com/in/haileamlak-belachew-53b6bb230/"));

                        } catch (Exception ee) {
                                // TODO: handle exception
                        }
                }

                else if (e.getActionCommand().equals("haileamlak_belachew")) {
                        Desktop desk = Desktop.getDesktop();
                        try {
                                desk.browse(new URI("https://www.instagram.com/haileamlak_belachew/"));

                        } catch (Exception ee) {
                                // TODO: handle exception
                        }
                }
        }

}
