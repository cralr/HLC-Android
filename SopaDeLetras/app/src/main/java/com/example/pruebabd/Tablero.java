package com.example.pruebabd;

import java.util.ArrayList;

public class Tablero {

    private static final int NFILAS = 10;
    private static final int NCOLUMNAS = 10;
    private static final int NUM_CAPITALES = 5;

    private int i;
    private int j;
    private int fila;
    private int columna;
    private String capital = "";
    private int sentido = 0;

    private String tablero[][] = new String[NFILAS][NCOLUMNAS];
    private String[] letters = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","enne","o","p","q","r","s","t","u","v","x","y","z",};
    private ArrayList<Integer> indiceCapitales = new ArrayList<Integer>();


    public Tablero(String[] capitales){
        generarTablero(capitales);
    }

    private void generarTablero(String[] capitales) {
        crearTablero();
        insertarCapitales(capitales);
        rellenarTablero();
    }

    private void rellenarTablero(){
        for(i=0;i<NFILAS;i++){
            for(j=0;j<NCOLUMNAS;j++){
                if( tablero[i][j].equals(""))
                    tablero[i][j] = letters[(int)(Math.random()*26)];
            }
        }
    }

    private void crearTablero() {
        for(i=0;i<NFILAS;i++){
            for(j=0;j<NCOLUMNAS;j++){
                tablero[i][j] = "";
            }
        }
    }

    private Boolean comprobarCapitalDisponible(int numRand){
        for (int i = 0; i < indiceCapitales.size() ; i++) {
            if( indiceCapitales.get(i) == numRand )
                return false;
        }
        return true;
    }

    private void insertarCapitales(String[] capitales){
        for (int i = 0; i < NUM_CAPITALES ; i++) {
            //generar y comprobar indice capital
            int indiceCapital = generarIndiceCapital(capitales);
            capital = capitales[indiceCapital].replaceAll("\\r","");
            capital = capital.replaceAll("\\n","");
            //generar direccion y coordenadas
            sentido = (int)(Math.random()*8);
            do {
                 fila = (int)(Math.random()*NFILAS);
                 columna = (int)(Math.random()*NCOLUMNAS);
            }while( !(validarLongitud(fila,columna,capital,sentido) && validarUbicacion(fila,columna,capital,sentido)) );
            //insertar capital
            insertarCapital(fila,columna,capital,sentido);
        }
    }

    private void insertarCapital(int fila, int columna, String capital, int sentido) {
        switch (sentido) {
            case 0: //fila--
                 insertar(fila,columna,capital,-1,0);
                 break;
            case 1: //fila--, columna++
                 insertar(fila,columna,capital,-1,1);
                break;
            case 2: //columna++
                 insertar(fila,columna,capital,0,1);
                break;
            case 3: //fila++, columna++
                 insertar(fila,columna,capital,1,1);
                break;
            case 4: //fila++
                 insertar(fila,columna,capital,1,0);
                break;
            case 5: //fila++, columna--
                 insertar(fila,columna,capital,1,-1);
                break;
            case 6: //columna--
                 insertar(fila,columna,capital,0,-1);
                break;
            default: //fila--, columna--
                insertar(fila,columna,capital,-1,-1);
                break;
        }
    }

    private void insertar(int fila, int columna, String capital, int increFila, int increColumna) {
        int coordFilaFinal = fila + capital.length() * increFila;
        int coordColumnaFinal = columna + capital.length() * increColumna;
        int indiceCapital = 0;
        while (!(fila == coordFilaFinal && columna == coordColumnaFinal)) {
            tablero[fila][columna] = capital.substring(indiceCapital, indiceCapital+1).toLowerCase();

            fila += increFila;
            columna += increColumna;
            indiceCapital++;
        }
    }

    private boolean validarLongitud(int fila, int columna, String capital, int sentido) {
        switch (sentido) {
            case 0: //fila--
                return (fila - capital.length() >= 0);
            case 1: //fila--, columna++
                return (fila - capital.length() >=0 && columna + capital.length() <= tablero.length-1);
            case 2: //columna++
                return (columna + capital.length() <= tablero.length -1);
            case 3: //fila++, columna++
                return (fila + capital.length() <= tablero.length -1 && columna + capital.length() <= tablero.length -1);
            case 4: //fila++
                return (fila + capital.length() <= tablero.length -1);
            case 5: //fila++, columna--
                return (fila + capital.length() <= tablero.length -1 && columna - capital.length() >=0);
            case 6: //columna--
                return (columna - capital.length() >=0);
            default: //fila--, columna--
                return (fila - capital.length()>=0 && columna - capital.length() >=0);
        }
    }

    private boolean validarUbicacion(int fila, int columna, String capital, int sentido) {
        switch (sentido) {
            case 0: //fila--
                return ValidarPosicionLetras(fila,columna,capital,-1,0);
            case 1: //fila--, columna++
                return ValidarPosicionLetras(fila,columna,capital,-1,1);
            case 2: //columna++
                return ValidarPosicionLetras(fila,columna,capital,0,1);
            case 3: //fila++, columna++
                return ValidarPosicionLetras(fila,columna,capital,1,1);
            case 4: //fila++
                return ValidarPosicionLetras(fila,columna,capital,1,0);
            case 5: //fila++, columna--
                return ValidarPosicionLetras(fila,columna,capital,1,-1);
            case 6: //columna--
                return ValidarPosicionLetras(fila,columna,capital,0,-1);
            default: //fila--, columna--
                return ValidarPosicionLetras(fila,columna,capital,-1,-1);
        }
    }

    private boolean ValidarPosicionLetras(int fila, int columna, String capital, int increFila, int increColumna) {
        int coordFilaFinal = fila + capital.length() * increFila;
        int coordColumnaFinal = columna + capital.length() * increColumna;
        int indiceCapital = 0;
        while (!(fila == coordFilaFinal && columna == coordColumnaFinal)) {
            //Si la posición de tablero no es una cadena vacía o no coincide las letras con la letra de la capital a insertar
            if (!(tablero[fila][columna] == "" ||
                    tablero[fila][columna] == capital.substring(indiceCapital, indiceCapital+1).toLowerCase() ))
                return false;

            fila += increFila;
            columna += increColumna;
            indiceCapital++;
        }
        return true;
    }


    private int generarIndiceCapital(String[] capitales) {
        int i = 0;
        do {
            i = (int)(Math.random()*capitales.length);
        }while ( !comprobarCapitalDisponible(i) );
        indiceCapitales.add(i);
        return i;
    }

    public String[][] getTablero(){
        return tablero;
    }


}
