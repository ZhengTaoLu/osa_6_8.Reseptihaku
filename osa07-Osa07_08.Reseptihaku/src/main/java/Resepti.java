import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author tao-s
 */
public class Resepti {
    private final HashMap<String, Integer>resepti;
    private String tiedosto;
    public Resepti(String tiedosto){
        this.resepti = new HashMap<>();
        this.tiedosto = tiedosto;
    }
    public void tiedostolukeminen(String tiedosto){
        try (Scanner tiedostonLukija = new Scanner(new File(this.tiedosto))) {
            String sana1 = "";
            int luku1 = 0;
            while (tiedostonLukija.hasNextLine()) {
                String rivi = tiedostonLukija.nextLine();
                if(rivi.equals("Lettutaikina") || rivi.equals("Lihapullat") 
                        || rivi.equals("Tofurullat")){
                    sana1 = rivi;
                }
                if(rivi.equals("60") || rivi.equals("20") || rivi.equals("30")){
                    luku1 = Integer.valueOf(rivi);
                }
                if(!sana1.equals(null) && luku1 != 0){
                    this.resepti.put(sana1, luku1);
                }
            }
            if(resepti.get("Lettutaikina") != 60){
                this.resepti.replace("Lettutaikina", resepti.get("Lettitaikina"), 60);
            }
            if(resepti.get("Lihapullat") != 20){
                this.resepti.replace("Lihapullat", resepti.get("Lihapullat"), 20);
            }
            if(resepti.get("Tofurullat") != 30){
                this.resepti.replace("Tofurullat", resepti.get("Tofurullat"), 30);
            }
        } catch (Exception e) {
            System.out.println("Virhe: " + e.getMessage());
        }
    }
    public String toString(String nimi, int luku){
        return nimi + ", keittoaika: " + luku;
    }
    public void listaa(){
        System.out.println("Reseptit:");
        try (Scanner tiedostonLukija = new Scanner(new File(tiedosto))) {
            String sana1 = "";
            int luku1 = 0;
            int indeksi = 0;
            boolean yes = false;
                while (tiedostonLukija.hasNextLine() && yes == true) {
                    String rivi = tiedostonLukija.nextLine();
                    if(rivi.equals("Lettutaikina")){
                        sana1 = rivi;
                    }
                    if(rivi.equals("60")){
                        luku1 = Integer.valueOf(rivi);
                    }
                        System.out.println(sana1 + ", keittoaika: " + luku1);
                        yes = true;
                }
                yes = false;
                while (tiedostonLukija.hasNextLine() && yes == true) {
                    String rivi = tiedostonLukija.nextLine();
                    if(rivi.equals("Lihapullat")){
                        sana1 = rivi;
                    }
                    if(rivi.equals("20")){
                        luku1 = Integer.valueOf(rivi);
                    }
                        System.out.println(sana1 + ", keittoaika: " + luku1);
                        yes = true;
                }
                yes = false;
                while (tiedostonLukija.hasNextLine() && yes == true) {
                    String rivi = tiedostonLukija.nextLine();
                    if(rivi.equals("Tofurullat")){
                        sana1 = rivi;
                    }
                    if(rivi.equals("30")){
                        luku1 = Integer.valueOf(rivi);
                    }
                        System.out.println(sana1 + ", keittoaika: " + luku1);
                        yes = true;
                }
            
        } catch (Exception e) {
            System.out.println("Virhe: " + e.getMessage());
        }
    }
}
