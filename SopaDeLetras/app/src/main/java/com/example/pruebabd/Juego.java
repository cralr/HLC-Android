package com.example.pruebabd;

public class Juego {
    private String[] capitales;
    private Tablero tablero;

    public Juego(String[] capitales){
        this.capitales = capitales;
        tablero = new Tablero(capitales);
    }

    public void reiniciarPartida(){
        tablero = null;
        tablero = new Tablero(capitales);
    }

    public String[][] getTablero(){
        return tablero.getTablero();
    }

}
