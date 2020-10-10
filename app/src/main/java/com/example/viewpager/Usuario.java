package com.example.viewpager;

class Usuario {
    String Nombre;
    int edad;
    String correo;

    public Usuario(String nombre, int edad, String correo) {
        Nombre = nombre;
        this.edad = edad;
        this.correo = correo;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
}
