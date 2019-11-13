import java.io.File;
import java.util.HashMap;
import java.util.ArrayList;
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
public class Haku {
    private final HashMap<String, ArrayList<String>>haku1;
    private final Resepti resepti1 = new Resepti();;
    public Haku(){
        this.haku1 = new HashMap<>();
        this.haku1.putIfAbsent("Lettutaikina", new ArrayList<>());
        this.haku1.putIfAbsent("Lihapullat", new ArrayList<>());
        this.haku1.putIfAbsent("Tofurullat", new ArrayList<>());
    }
    public void aineHaku(){
        try (Scanner tiedostonLukija = new Scanner(new File("reseptit.txt"))) {
            while (tiedostonLukija.hasNextLine()) {
                String rivi = tiedostonLukija.nextLine();
                if(rivi.isEmpty()){
                    break;
                }
                if(rivi.contains("Lettutaikina")){
                    continue;
                }
                this.haku1.get("Lettutaikina").add(rivi);
            }
            while (tiedostonLukija.hasNextLine()) {
                String rivi = tiedostonLukija.nextLine();
                if(rivi.isEmpty()){
                    break;
                }
                if(rivi.contains("Lihapullat")){
                    continue;
                }
                this.haku1.get("Lihapullat").add(rivi);
            }
            while (tiedostonLukija.hasNextLine()) {
                String rivi = tiedostonLukija.nextLine();
                if(rivi.isEmpty()){
                    break;
                }
                if(rivi.contains("Tofurullat")){
                    continue;
                }
                this.haku1.get("Tofurullat").add(rivi);
            }
        } catch(Exception e){
            System.out.println("Virhe: " + e.getMessage());
        }
    }
    public void contains(String hae){
        for(String haku: haku1.keySet()){
            if(this.haku1.get(haku).contains(hae)){
                System.out.println(this.resepti1.toString(haku));
            }
        }
    }
}
