package Modelo;

import java.util.ArrayList;

public class claseMascota {

    private String nombre;
    private String raza;
    private String especie;
    private String color;
    private String genero;
    private int peso;
    private int edad;
    private String diagnostico;
    private int idUsuario;
    private int idMascota;

    private ArrayList<String> petslist = new ArrayList<String>();

    public claseMascota() {
    }

    public claseMascota(String nombre, String raza, String especie, String color, String genero, int peso, int edad, String diagnostico, int idUsuario, int idMascota) {
        this.nombre = nombre;
        this.raza = raza;
        this.especie = especie;
        this.color = color;
        this.genero = genero;
        this.peso = peso;
        this.edad = edad;
        this.diagnostico = diagnostico;
        this.idUsuario = idUsuario;
        this.idMascota = idMascota;
    }

    public ArrayList<String> getPetslist() {
        return petslist;
    }

    public void setPetslist(ArrayList<String> petslist) {
        this.petslist = petslist;
    }

    public int getIdMascota() {
        return idMascota;
    }

    public void setIdMascota(int idMascota) {
        this.idMascota = idMascota;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

}
