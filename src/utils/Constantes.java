/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

/**
 *
 * @author Jmarser
 */
public class Constantes {

    //constantes para la generación de las claves
    public static final String MAYUSCULAS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public static final String MINUSCULAS = "abcdefghijklmnopqrstuvwxyz";
    public static final String NUMEROS = "0123456789";
    public static final String ESPECIALES = "!@#$%&*()_+-=[]|,./?><";

    //Longitud de las claves según la seguridad
    public static final int LONG_LOW = 6;
    public static final int LONG_MEDIUM = 8;
    public static final int LONG_HIGH = 10;
    public static final int LONG_PIN_CARD = 4;

    //patrones de verificacion de las contraseñas creadas
    public static final String PATRON_LOW = "^(?=\\w*[A-Z])(?=\\w*[a-z])\\S{6,}$";
    public static final String PATRON_MEDIUM = "^(?=\\w*\\d)(?=\\w*[A-Z])(?=\\w*[a-z])\\S{8,}$";
    public static final String PATRON_HIGH = "^(?=.*\\d{2,})(?=.*[\\u0021-\\u002b\\u003c-\\u0040])(?=.*[A-Z])(?=.*[a-z])\\S{10,}$";
}
