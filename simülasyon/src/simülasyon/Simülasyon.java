package simülasyon;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Simülasyon {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Lutfen dosya adini giriniz: ");
        String dosyaAdi = scanner.nextLine();
        scanner.close();

    
        int[] sayilar = new int[500];
        int[] indeksler = new int[500];

        try (BufferedReader br = new BufferedReader(new FileReader(dosyaAdi))) {
            String satir;
            int index = 0;
            while ((satir = br.readLine()) != null) {
                int sayi = Integer.parseInt(satir);
                sayilar[index] = sayi; 
                indeksler[index] = index;
                index++;
            }
        } catch (IOException | NumberFormatException e) {
            System.err.println("Dosya okuma hatası: " + e.getMessage());
            return;
        }

      
        System.out.println("Siralanmamis sayilar ve orijinal indeksleri:");
        for (int i = 0; i < sayilar.length; i++) {
            if (sayilar[i] != 0) {
                System.out.println("X: " + sayilar[i] + " - Y: " + indeksler[i]);
            }
        }

     
        for (int i = 0; i < sayilar.length - 1; i++) {
            for (int j = i + 1; j < sayilar.length; j++) {
                if (sayilar[i] > sayilar[j]) {
                   
                    int geciciSayi = sayilar[i];
                    sayilar[i] = sayilar[j];
                    sayilar[j] = geciciSayi;

                    int geciciIndeks = indeksler[i];
                    indeksler[i] = indeksler[j];
                    indeksler[j] = geciciIndeks;
                }
            }
        }

        System.out.println("Siralanmis sayilar ve orijinal indeksleri:");
        for (int i = 0; i < sayilar.length; i++) {
            if (sayilar[i] != 0) {
                System.out.println("X: " + sayilar[i] + " - Y: " + indeksler[i]);
            }
        }
    }
}