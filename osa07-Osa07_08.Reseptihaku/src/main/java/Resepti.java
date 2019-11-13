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
    private final HashMap<String, Integer>yes1;
    private final Haku haku0 = new Haku();
    public Resepti(){
        this.yes1 = new HashMap<>();
    }
    public void tiedostolukeminen(String tiedosto){
        try (Scanner tiedostonLukija = new Scanner(new File(tiedosto))) {
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
                    this.yes1.putIfAbsent(sana1, luku1);
                }
            }
            if(yes1.get("Lettutaikina") != 60){
                this.yes1.replace("Lettutaikina", yes1.get("Lettitaikina"), 60);
            }
            if(yes1.get("Lihapullat") != 20){
                this.yes1.replace("Lihapullat", yes1.get("Lihapullat"), 20);
            }
            if(yes1.get("Tofurullat") != 30){
                this.yes1.replace("Tofurullat", yes1.get("Tofurullat"), 30);
            }
        } catch (Exception e) {
            System.out.println("Virhe: " + e.getMessage());
        }
    }
    public String toString(String nimi){
        return nimi + ", keittoaika: " + this.yes1.get(nimi);
    }
    public void listaa(){
        System.out.println("Reseptit:");
        for(String listaa: yes1.keySet()){
            System.out.println(listaa + ", keittoaika: " 
                    + this.yes1.get(listaa));
        }
    }
    public void hae(String haku){
        System.out.println(" ");
        System.out.println("Reseptit:");
        for(String hae: yes1.keySet()){
            if(hae.contains(haku)){
               System.out.println(hae + ", keittoaika: " 
                    + this.yes1.get(hae)); 
            }
        }
    }
    public void keittoaika(int keittoaika){
        System.out.println(" ");
        System.out.println("Reseptit:");
        for(String aika: yes1.keySet()){
            if(this.yes1.get(aika) <= keittoaika){
               System.out.println(aika + ", keittoaika: " 
                    + this.yes1.get(aika));  
            }
        }
    }
    public void aineHaku(String hae){
        this.haku0.aineHaku();
        System.out.println("Reseptit:");
        this.haku0.contains(hae);
    }
}
