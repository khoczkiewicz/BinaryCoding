/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kodowaniebinarne;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Collections;
import java.util.Comparator;
import java.util.BitSet;

/**
 *
 * @author root
 */
public class KodowanieBinarne {

    public static String alfabet = " abcdefghijklmnopqrstuvwxyz0123456789";

    public static Alfabet[] create(String tekst) throws FileNotFoundException, IOException {
        Alfabet[] wystapienia = new Alfabet[alfabet.length()];
        for (int i = 0; i < tekst.length(); i++) {
            for (int j = 0; j < alfabet.length(); j++) {
                wystapienia[j] = new Alfabet(alfabet.charAt(j), 0);
            }
        }
        for (int i = 0; i < tekst.length(); i++) {
            for (int j = 0; j < alfabet.length(); j++) {
                if (tekst.charAt(i) == alfabet.charAt(j)) {
                    wystapienia[j].setWystapienia(wystapienia[j].getWystapienia() + 1);
                }
            }
        }
        Arrays.sort(wystapienia, Collections.reverseOrder());
        return wystapienia;
    }

    public static String encode(Alfabet alfabetPosortowany[], String tekst) {
        String kod = "";
        for (int i = 0; i < alfabetPosortowany.length; i++) {
            kod += alfabetPosortowany[i].getLitera();
        }
        for (int i = 0; i < tekst.length(); i++) {
            for (int j = 0; j < alfabetPosortowany.length; j++) {
                if (alfabetPosortowany[j].getLitera() == tekst.charAt(i)) {
                    if (j < 10) {
                        kod += "0" + j;
                    } else {
                        kod += j;
                    }
                }
            }
        }
        return kod;
    }

    public static String decode(String tekst) {
        int etap = 0;
        int j = 0;
        String alfabetPozyskany = "";
        String wynik = "";
        for (int i = 0; i < tekst.length() - 1; i++) {
            if (etap == 0) {
                if (j < alfabet.length()) {
                    alfabetPozyskany += tekst.charAt(i);
                    j++;
                } else {
                    etap = 1;
                    j = 0;
                }
            }
            int litera;
            if (etap == 1) {
                if (j == 0) {
                    litera = Integer.parseInt(tekst.charAt(i) + "" + tekst.charAt(i + 1));
                    for (int k = 0; k < alfabet.length(); k++) {
                        if (litera == k) {
                            wynik += alfabetPozyskany.charAt(k);
                        }
                    }
                    j++;
                    continue;
                }
                if (j == 1) {
                    j = 0;
                    continue;
                }
            }
        }
        return wynik;
    }

    public static void save(String tekst) throws IOException {
        BufferedWriter zapis = new BufferedWriter(new FileWriter("wynik.bin"));
        zapis.write(tekst);
    }

    public static String load() throws IOException {
        BufferedReader wczytaj = new BufferedReader(new FileReader("wynik.bin"));
        return wczytaj.readLine();
    }

    /*public static String toBinary(String tekst) {
        byte[] bajty = tekst.getBytes();
        StringBuilder binarka = new StringBuilder();
        for (byte b : bajty) {
            int temp = b;
            for (int i = 0; i < 8; i++) {
                binarka.append((temp & 128) == 0 ? 0 : 1);
                temp <<= 1;
            }
            binarka.append(' ');
        }
        return binarka.toString();
    }

    public static String fromBinary(String tekst) {
        StringBuilder binarka = new StringBuilder();
        char[] chary=tekst.toCharArray();
        for(int i=0;i<chary.length;i+=9){
            int indeks=0;
            int suma=0;
            for(int j=7;j>=0;j--){
                if(chary[i+j]=='1'){
                    suma+=1<<indeks;
                }
                indeks++;
            }
            System.out.println(suma);
            binarka.append(Character.toChars(suma));
        }
        return binarka.toString();
    }*/
}
