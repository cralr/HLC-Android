
package com.example.juegodardos;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView puntos;
    TextView jugador;
    Button reinicio;
    int puntuacionJugador1 = 301;
    int puntuacionJugador2 = 301;
    boolean doble;
    boolean triple;
    Button botones[]= new Button[27];
    int puntuacion;
    int jugadorInicial = 1;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView display = (TextView) findViewById(R.id.totalPuntos);

        //Botones

        botones[0] = (Button) findViewById(R.id.n1);
        botones[1] = (Button) findViewById(R.id.n2);
        botones[2] = (Button) findViewById(R.id.n3);
        botones[3] = (Button) findViewById(R.id.n4);
        botones[4] = (Button) findViewById(R.id.n5);
        botones[5] = (Button) findViewById(R.id.n6);
        botones[6] = (Button) findViewById(R.id.n7);
        botones[7] = (Button) findViewById(R.id.n8);
        botones[8] = (Button) findViewById(R.id.n9);
        botones[9] = (Button) findViewById(R.id.n10);
        botones[10] = (Button) findViewById(R.id.n11);
        botones[11] = (Button) findViewById(R.id.n12);
        botones[12] = (Button) findViewById(R.id.n13);
        botones[13] = (Button) findViewById(R.id.n14);
        botones[14] = (Button) findViewById(R.id.n15);
        botones[15] = (Button) findViewById(R.id.n16);
        botones[16] = (Button) findViewById(R.id.n17);
        botones[17] = (Button) findViewById(R.id.n18);
        botones[18] = (Button) findViewById(R.id.n19);
        botones[19] = (Button) findViewById(R.id.n20);
        botones[20] = (Button) findViewById(R.id.n25);
        botones[21] = (Button) findViewById(R.id.n50);
        botones[22] = (Button) findViewById(R.id.doble);
        botones[23] = (Button) findViewById(R.id.triple);
        botones[24] = (Button) findViewById(R.id.reinicio);
        botones[25] = (Button) findViewById(R.id.jugador1);
        botones[26] = (Button) findViewById(R.id.jugador2);

        puntos = (TextView) findViewById((R.id.totalPuntos));
        jugador = (TextView) findViewById((R.id.jugadores));

        botones[25].setOnClickListener(cambiarJugador);
        botones[26].setOnClickListener(cambiarJugador);

        for (int i = 0; i < 22; i++) {
            botones[i].setOnClickListener(calcularPuntos);
        }

        //Doble y Triple

        botones[22].setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v){
                doble = true;
            }
        });

        botones[23].setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v){
                triple = true;
            }
        });

        //Reinicio

        final Context context = this;
        botones[24].setOnClickListener(new Button.OnClickListener(){

            public void onClick(View v) {


                AlertDialog.Builder alertdialog = new AlertDialog.Builder(context);
                alertdialog.setTitle("Reiniciar marcador");
                alertdialog.setMessage("¿Deseas reiniciar el marcador?")
                        .setCancelable(false)
                        .setPositiveButton(" Aceptar", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                                if (jugadorInicial == 1){
                                    puntuacionJugador1 = 301;
                                    puntos.setText(String.valueOf(puntuacionJugador1));
                                }
                                if (jugadorInicial == 2) {
                                    puntuacionJugador2 = 301;
                                    puntos.setText(String.valueOf(puntuacionJugador2));
                                }
                            }
                        })
                        .setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        });
                AlertDialog mensaje = alertdialog.create();
                mensaje.show();

            }
        });
    }

    private View.OnClickListener calcularPuntos = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            puntuacion = Integer.parseInt(puntos.getText().toString());
            int contadorPuntos = 0;
            switch (v.getId()) {
                case R.id.n1:
                    contadorPuntos = 1;
                    break;
                case R.id.n2:
                    contadorPuntos = 2;
                    break;

                case R.id.n3:
                    contadorPuntos = 3;
                    break;

                case R.id.n4:
                    contadorPuntos = 4;
                    break;

                case R.id.n5:
                    contadorPuntos = 5;
                    break;

                case R.id.n6:
                    contadorPuntos = 6;
                    break;

                case R.id.n7:
                    contadorPuntos = 7;
                    break;

                case R.id.n8:
                    contadorPuntos = 8;
                    break;

                case R.id.n9:
                    contadorPuntos = 9;
                    break;

                case R.id.n10:
                    contadorPuntos = 10;
                    break;

                case R.id.n11:
                    contadorPuntos = 11;
                    break;

                case R.id.n12:
                    contadorPuntos = 12;
                    break;

                case R.id.n13:
                    contadorPuntos = 13;
                    break;

                case R.id.n14:
                    contadorPuntos = 14;
                    break;

                case R.id.n15:
                    contadorPuntos = 15;
                    break;

                case R.id.n16:
                    contadorPuntos = 16;
                    break;

                case R.id.n17:
                    contadorPuntos = 17;
                    break;

                case R.id.n18:
                    contadorPuntos = 18;
                    break;

                case R.id.n19:
                    contadorPuntos = 19;
                    break;

                case R.id.n20:
                    contadorPuntos = 20;
                    break;

                case R.id.n25:
                    contadorPuntos = 25;
                    break;

                case R.id.n50:
                    contadorPuntos = 50;
                    break;
            }
            if (doble == true) {
                contadorPuntos = contadorPuntos * 2;
                doble = false;
            } else if (triple == true) {
                contadorPuntos = contadorPuntos *3;
                triple = false;
            }

            if (jugadorInicial == 1) {
                puntuacionJugador1 -= contadorPuntos;
                puntos.setText(String.valueOf(puntuacionJugador1));
            }

            if (jugadorInicial == 2) {
                puntuacionJugador2 -= contadorPuntos;
                puntos.setText(String.valueOf(puntuacionJugador2));
            }

        }
    };

    private View.OnClickListener cambiarJugador = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.jugador1:
                    jugadorInicial = 1;
                    puntos.setText(String.valueOf(puntuacionJugador1));
                    jugador.setText("Jugador 1");
                    break;
                case R.id.jugador2:
                    jugadorInicial = 2;
                    puntos.setText(String.valueOf(puntuacionJugador2));
                    jugador.setText("Jugador 2");
                    break;
            }
        }
    };

}