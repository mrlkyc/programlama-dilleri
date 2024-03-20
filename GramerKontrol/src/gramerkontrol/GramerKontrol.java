package gramerkontrol;

import java.util.Scanner;
import java.util.HashSet;
import java.util.Arrays;

public class GramerKontrol {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Cumleyi giriniz:");
        String cumle = scanner.nextLine();

        boolean kontrolet =kontrolEt(cumle.trim().toLowerCase());

        if (kontrolet) {
            System.out.println("Girilen cumle gramer yapisina uygun.");
        } else {
            System.out.println("Girilen cumle gramer yapisina uygun degil.");
        }
    }

    public static boolean kontrolEt(String cumle) {
        String[] kelimeler = cumle.split("\\s+");

        HashSet<String> ozne = new HashSet<>(Arrays.asList("sen", "ben", "nurşah", "hasan", "elif", "abdulrezzak",
                "şehribanu", "zeynelabidin", "naki"));
        HashSet<String> nesne = new HashSet<>(Arrays.asList("okul", "bahçe", "yarın", "park", "sınıf",
                "pazartesi", "salı", "çarşamba", "perşembe", "cuma", "cumartesi", "pazar", 
                "merkez", "ev", "kitap", "defter", "güneş", "beydağı"));
        HashSet<String> yuklem = new HashSet<>(Arrays.asList("okumak", "yazmak", "gitmek", "gelmek", "yürümek",
                "görmek"));

        if (kelimeler.length != 3) {
            return false;
        }

        if (!ozne.contains(kelimeler[0]) || !nesne.contains(kelimeler[1]) || !yuklem.contains(kelimeler[2])) {
            return false; 
        }
        
        return true;
    }
}
