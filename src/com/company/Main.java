package com.company;

import Excepciones.DatoNoValido;
import MisClases.Persona;

import javax.swing.*;
import java.util.ArrayList;

public class Main {
    private static ArrayList<Persona> listaPersona;

    public static void main(String[] args) {
	    try {
            listaPersona = new ArrayList();
            obtenerDatosPersona();
            contadorElche();
            elegirSalida();
        }catch (Exception var2){
            JOptionPane.showMessageDialog(null,"Hubo un error:" + var2.getMessage());
        }
    }
    public static void obtenerDatosPersona() throws Exception{
        do {
            try {
                String nombre = JOptionPane.showInputDialog(null, "Introduzca el nombre de la persona que desa introducir.");
                validarNombre(nombre);
                String fechaNacimiento = JOptionPane.showInputDialog(null, "Introduzca su fecha de nacimieno.");
                validarFechaNacimiento(fechaNacimiento);
                String direccion = JOptionPane.showInputDialog(null, "Introduzca su direccion.");
                validarDireccion(direccion);
                String codigoPostal = JOptionPane.showInputDialog(null, "Introduzca su codigo postal.");
                validarCodigoPostal(codigoPostal);
                String ciudad = JOptionPane.showInputDialog(null, "Introduzca la ciudad donde reside:");
                validarCiudad(ciudad);
                Persona a = new Persona(nombre, fechaNacimiento, direccion, codigoPostal, ciudad);
                listaPersona.add(a);
            }catch (DatoNoValido var5){
                JOptionPane.showMessageDialog(null, "El dato introducido no es correcto");
            }
        }while (JOptionPane.showConfirmDialog( null, "¿Desea introducir otra persona?") == 0);

    }

    public static void contadorElche() throws Exception{
        try {
            StringBuilder msg = new StringBuilder();
            for (Persona j : listaPersona) {
                if ((j.getCiudad()).toLowerCase().equals("elche")) {
                    msg.append(j.getNombre()).append(", ");
                }
            }
        }catch (Exception var2){
            JOptionPane.showMessageDialog(null,"Hubo un error: " + var2.getMessage());
        }
    }

//VALIDACIONES

    public static void validarNombre(String nombre) throws Exception{
        boolean error = false;
        if (nombre.length() <=2){
            error = true;
        }else{
            for (int x = 0; x < nombre.length() && !error; x++) {
                if (Character.isDigit(nombre.charAt(x))){
                    error = true;
                }
            }
        }
        if (error){
            throw new DatoNoValido();
        }
    }

    public static void validarFechaNacimiento(String fechaNacimiento) throws Exception{}

    public static void validarDireccion(String direccion) throws Exception{
        boolean error = direccion.length() <= 0;
        if (error){
            throw new DatoNoValido();
        }
    }

    public static void validarCodigoPostal(String codigoPostal) throws Exception{
        boolean error = false;
        if (codigoPostal.length() <5){
            error = true;
        }else{
            for (int x = 0; x < codigoPostal.length(); x++){
                if (Character.isAlphabetic(codigoPostal.charAt(x))){
                    error = true;
                }
            }
        }
        if (error){
            throw new DatoNoValido();
        }
    }

    public static void validarCiudad(String ciudad) throws Exception{
        boolean error = false;
        for (int x = 0; x < ciudad.length(); x++){
            if (Character.isDigit(ciudad.charAt(x))){
                error = true;
            }
        }
        if (error){
            throw new DatoNoValido();
        }
    }

    public static int validarSalida(int salida) throws Exception{
        boolean error = salida <= 0 || salida >= 4;
        if (error){
            throw new DatoNoValido();
        }else{
            return salida;
        }
    }

//SALIDAS DE DATOS
    public static void elegirSalida() throws Exception{
        try {
            int salida;
            salida = Integer.parseInt(JOptionPane.showInputDialog(null,
                    "¿Que operación quiere visualizar?\n" +
                    "1) Nombre de la persona de mayor edad.\n" +
                    "2) Nombre de las personas que viven en Elche.\n" +
                    "3) Número de personas mayores de edad."));
            validarSalida();

        }catch (Exception var2){
            JOptionPane.showMessageDialog(null,"Hubo un error: " + var2.getMessage());
        }

    }

    public static void nombresElche() throws Exception{

    };
}
