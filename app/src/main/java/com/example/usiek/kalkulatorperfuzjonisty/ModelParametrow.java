package com.example.usiek.kalkulatorperfuzjonisty;

import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;

import butterknife.BindView;

import static android.content.ContentValues.TAG;

/**
 * Created by usiek on 28.01.2018.
 */

public class ModelParametrow {


    //    parametry wejściowe
    public double wzrost;
    public double waga;
    public double temp;
    public boolean plec;
    public double przeplywKrwi;
    public double wskaznikIC;
    public double objetoscPierwotna = 1500;
    public double roztKardio;
    public double hct;
    public double hctOczekiwane;


    //    parametry wyjsciowe
    public String kaniuleSVC;
    public double kaniulaWspolna;
    public String wymiarKaniuliTetniczej;
    public double DLP;
    public double rozmiarAortalnej;
    public double cbp;
    public double objetoscKrwiKrazacej;
    public double wskaznikHemodilucji;
    public double hematocrytOczekiwany;
    public double vkk;


    public void obliczParametry() {
        rozmiarKaniulizylnej();
        rozmiarKaniuliTetniczej();
        rozmiarKaniuliAortalnej();
        rzutMinutowy();
        krewKrazaca();
        setWskaznikHemodilucji();
        setHctOczekiwane();
        setPodazKrwi();
    }

    public void rozmiarKaniulizylnej() {

        if (3 > waga) {
            kaniulaSVCwspolna("12/14", 18);
        } else if (waga >= 3 && waga < 6) {
            kaniulaSVCwspolna("14/16", 18);
        } else if (waga >= 6 && waga < 8) {
            kaniulaSVCwspolna("16/16", 20);
        } else if (waga >= 8 && waga < 10) {
            kaniulaSVCwspolna("16/18", 22);
        } else if (waga >= 10 && waga < 12) {
            kaniulaSVCwspolna("18/18", 24);
        } else if (waga >= 12 && waga < 15) {
            kaniulaSVCwspolna("18/20", 26);
        } else if (waga >= 15 && waga < 20) {
            kaniulaSVCwspolna("20/20", 26);
        } else if (waga >= 20 && waga < 25) {
            kaniulaSVCwspolna("20/24", 28);
        } else if (waga >= 25 && waga < 30) {
            kaniulaSVCwspolna("24/24", 28);
        } else if (waga >= 30 && waga < 35) {
            kaniulaSVCwspolna("24/28", 30);
        } else if (waga >= 35 && waga < 40) {
            kaniulaSVCwspolna("26/28", 34);
        } else if (waga >= 40 && waga < 45) {
            kaniulaSVCwspolna("128/28", 34);
        } else if (waga >= 45 && waga < 55) {
            kaniulaSVCwspolna("30/32", 36);
        } else if (waga >= 55 && waga < 65) {
            kaniulaSVCwspolna("32/34", 40);
        } else if (waga >= 65) {
            kaniulaSVCwspolna("34/36", 40);
        }

//        SVC.setText(kaniuleSVC);
//        Wspolna.setText(String.valueOf(kaniulaWspolna));
        Log.d(TAG, "someOtherMethod()");
    }

    public void kaniulaSVCwspolna(String a, double b) {
        kaniuleSVC = a;
        kaniulaWspolna = b;
    }

    public void rozmiarKaniuliTetniczej() {

        if (3 > waga) {
            kaniulaTętnicza("3/16 < 0,6 lpm", 8);
        } else if (waga >= 3 && waga < 5) {
            kaniulaTętnicza("3/16 < 0,9 lpm", 10);
        } else if (waga >= 5 && waga < 10) {
            kaniulaTętnicza("3/16 < 1,5 lpm", 12);
        } else if (waga >= 10 && waga < 15) {
            kaniulaTętnicza("1/4 < 2,5 lpm", 14);
        } else if (waga >= 15 && waga < 22) {
            kaniulaTętnicza("1/4 < 3,0 lpm", 16);
        } else if (waga >= 23 && waga < 29) {
            kaniulaTętnicza("3/8 < 4,0 lpm", 18);
        } else if (waga >= 29 && waga < 45) {
            kaniulaTętnicza("3/8 < 6,5 lpm", 20);
        } else if (waga >= 45 && waga < 80) {
            kaniulaTętnicza("3/8", 22);
        } else if (waga >= 80 && waga < 120) {
            kaniulaTętnicza("3/8", 24);
        } else if (waga >= 120) {
            kaniulaTętnicza("3/8", 24); // czy tu nie musi być this????
        }

//        DLPwynik.setText(kaniuleSVC);
//        TetniczaPrzeplyw.setText(String.valueOf(kaniulaWspolna));
    }

    public void kaniulaTętnicza(String a, double b) {
        wymiarKaniuliTetniczej = a;
        DLP = b;
    }

    public void rozmiarKaniuliAortalnej() {

        if (380 > przeplywKrwi) {
            rozmiarAortalnej = 6;
        } else if (przeplywKrwi >= 380 && przeplywKrwi < 560) {
            rozmiarAortalnej = 8;
        } else if (przeplywKrwi >= 560 && przeplywKrwi < 700) {
            rozmiarAortalnej = 10;
        } else if (przeplywKrwi >= 700 && przeplywKrwi < 1000) {
            rozmiarAortalnej = 12;
        } else if (przeplywKrwi >= 1000 && przeplywKrwi < 1400) {
            rozmiarAortalnej = 14;
        } else if (przeplywKrwi >= 1400 && przeplywKrwi < 1800) {
            rozmiarAortalnej = 16;
        } else if (przeplywKrwi >= 1800 && przeplywKrwi < 3000) {
            rozmiarAortalnej = 18;
        } else if (przeplywKrwi >= 3000) {
            rozmiarAortalnej = 20;
        }

//        AortalnaWynik.setText(kaniuleSVC);
    }

    public void rzutMinutowy() {

        double CI = 2.8;

        if (Double.isNaN(wskaznikIC)) {
            if (temp >= 37) {
                CI = 2.5;
            } else if (temp < 37 && temp >= 32) {
                CI = 2.1;
            } else if (temp < 32 && temp >= 28) {
                CI = 1.8;
            } else if (temp < 28 && temp >= 25) {
                CI = 1.2;
            } else if (temp < 25) {
                CI = 0.6;
            } else {
                CI = wskaznikIC;
            }
            //        CPB.setText(String.valueOf(cbp));
        }
        cbp = (0.00007184 * Math.pow(waga, 0.0425) * Math.pow(wzrost, 0.725) * CI);
    }

    public void krewKrazaca() {
        if (plec) {
            objetoscKrwiKrazacej = 2370 * 0.00007184 * Math.pow(waga, 0.0425) * Math.pow(wzrost, 0.725);
        } else {
            objetoscKrwiKrazacej = 2740 * 0.00007184 * Math.pow(waga, 0.0425) * Math.pow(wzrost, 0.725);
        }

//        KrewKrazaca.setText(String.valueOf(objetoscKrwiKrazacej));
    }

    public void setWskaznikHemodilucji() {
        int vi = 0;

        vi = getVi(vi);

        wskaznikHemodilucji = objetoscPierwotna / (waga * vi * objetoscPierwotna);

//        Hemodylucja.setText(String.valueOf(wskaznikHemodilucji));
    }

    private int getVi(int vi) {
        if (10 > waga) {
            vi = 85;
        } else if (waga >= 10 && waga < 20) {
            vi = 80;
        } else if (waga >= 20 && waga < 30) {
            vi = 75;
        } else if (waga >= 30 && waga < 40) {
            vi = 70;
        } else if (waga >= 40 && waga < 50) {
            vi = 65;
        } else if (waga >= 50) {
            vi = 60;
        }
        return vi;
    }

    public void setHctOczekiwane() {
        int vi = 0;
        vi = getVi(vi);

        hematocrytOczekiwany = (hct * waga * vi) / (waga * vi * objetoscPierwotna);

//        HEmatokrytOczekiwany.setText(String.valueOf(hematocrytOczekiwany));
    }

    public void setPodazKrwi() {

        vkk = ((hctOczekiwane / 100) * (objetoscPierwotna + waga * getVi(0))
                - (waga * getVi(0) * hct)) / 0.7;

//        PodazKrwi.setText(String.valueOf(vkk));
    }
}