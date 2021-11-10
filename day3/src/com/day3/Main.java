package com.day3;

import java.io.File;
import java.util.*;

public class Main {
    public static void main(String[] args){
        separarApellidos();
    }

    public static void separarApellidos(){
        //Inicializamos variables
        String nombre="";
        String primerApellido="";
        String segundoApellido="";

        //Pedimos el nombre
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce tu nombre y apellidos");
        String nombreCompleto = sc.nextLine();

        //Lo separamos por espacios
        String[] nombreSplit = nombreCompleto.split("\\s+");
        try {
            //Creamos nuestro diccionario de nombres de pila comunes a partir de un documento externo
            Scanner inFile = new Scanner(new File("nombrescomunes.txt")).useDelimiter(",\\s*");

            ArrayList<String> nombresComunes = new ArrayList<String>();

            String token = "";
            while (inFile.hasNext()){
                token = inFile.nextLine();
                nombresComunes.add(token);
            }
            inFile.close();

            //Comprobamos la longitud del nombre introducido y si en el segundo campo aparece un nombre de pila común,
            //Si es así, supondremos que es un nombre compuesto.
            for (int i = 0; i < nombreSplit.length; i++) {
                if (nombreSplit.length == 4) {
                    if (nombresComunes.contains(nombreSplit[1])) {
                        nombre = nombreSplit[0] + " " + nombreSplit[1];
                        primerApellido = nombreSplit[2];
                    } else {
                        nombre = nombreSplit[0];
                        primerApellido = nombreSplit[1] + " " + nombreSplit[2];
                    }
                    segundoApellido = nombreSplit[3];
                }
                else if (nombreSplit.length == 3){
                    if (nombresComunes.contains(nombreSplit[1])) {
                        nombre = nombreSplit[0] + " " + nombreSplit[1];
                        primerApellido = nombreSplit[2];
                    } else {
                        nombre = nombreSplit[0];
                        primerApellido = nombreSplit[1];
                        segundoApellido = nombreSplit[2];
                    }
                }
                else if (nombreSplit.length == 2){
                    if (nombresComunes.contains(nombreSplit[1])){
                        nombre = nombreSplit[0] + " " + nombreSplit[1];
                    }
                }
                else if (nombreSplit.length == 1){
                    nombre = nombreSplit[0];
                }
                else{
                    System.out.println("Nombre no válido.");
                }
            }

            System.out.println("Nombre: "+ nombre);
            if(primerApellido != null && !primerApellido.isEmpty()){
                System.out.println("Primer apellido: "+ primerApellido);
            }
            if(segundoApellido != null && !segundoApellido.isEmpty()) {
                System.out.println("Segundo apellido: " + segundoApellido);
            }

        }catch(Exception e){System.out.println(e);}
    }

}
