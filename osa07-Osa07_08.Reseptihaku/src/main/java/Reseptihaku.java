
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Reseptihaku {

    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);
        Resepti reseptix = new Resepti();
        
        System.out.print("Mistä luetaan? ");
        reseptix.tiedostolukeminen(lukija.nextLine()); 
        while(true){
            System.out.print("Syötä komento: ");
            String sana2 = lukija.nextLine();
            if(sana2.equals("lopeta")){
                break;
            }
            if(sana2.equals("listaa")){
                reseptix.listaa();
                System.out.println(" ");
            }
            if(sana2.equals("hae nimi")){
                System.out.print("Mitä haetaan: ");
                reseptix.hae(lukija.nextLine());
                System.out.println(" ");
            }
            if(sana2.equals("hae keittoaika")){
                System.out.print("Keittoaika korkeintaan: ");
                reseptix.keittoaika(Integer.valueOf(lukija.nextLine()));
                System.out.println(" ");
            }
            if(sana2.equals("hae aine")){
                System.out.print("Mitä raaka-ainetta haetaan: ");
                reseptix.aineHaku(lukija.nextLine());
            }
        }
        
    }

}
