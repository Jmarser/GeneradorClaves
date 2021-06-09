
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Jmarser
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

     
        System.out.println(new Generador().getClave("bajo", 10));

        System.out.println(new Generador().getClave("medio", 8));
        
        System.out.println(new Generador().getClave("alto", 12));

        
        //System.out.println(new Generador().getClave("pincard", 0));
     

     
    }

}
