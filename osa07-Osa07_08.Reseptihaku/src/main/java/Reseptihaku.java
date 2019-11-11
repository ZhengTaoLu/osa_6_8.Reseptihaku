
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Reseptihaku {

    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);
        
        
        System.out.print("Mistä luetaan? ");
        String sana1 = lukija.nextLine();
        Resepti resepti = new Resepti(sana1);
        
        while(true){
            System.out.print("Syötä komento: ");
            String sana2 = lukija.nextLine();
            if(sana2.equals("lopeta")){
                break;
            }
            if(sana2.equals("listaa")){
                resepti.listaa();
            }
        }
        
    }

}
