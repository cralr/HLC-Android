package com.example.juegodardos;

public class Juego {

    private Boolean resta=false;

    private int num1 = 0;
    private int num2 = 0;

    private String input = "0";
    private String resultado = "0";

    /**
     * Constructor
     */
    public Juego(){
    }

    /**
     * Valor del input
     */
    public String getInput(){
        return input;
    }

    public void introduceNumero(String num){
        if((num.equals("351") && input.equals("351")))
            return;
        if(input.equals("351")) {
            input=num;
            resultado="0";
        }
        else
            input+=num;
    }

}
