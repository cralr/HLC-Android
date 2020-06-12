package com.example.pruebabd;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DownloadManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;



public class MainActivity extends AppCompatActivity {
    TextView textView;
    RequestQueue queue;
    String URL = "http://192.168.1.39/sopaletras/api/api.php";


    private final int ids[][] = {
            {R.id.ImageButton0_0, R.id.ImageButton0_1, R.id.ImageButton0_2, R.id.ImageButton0_3, R.id.ImageButton0_4, R.id.ImageButton0_5, R.id.ImageButton0_6,R.id.ImageButton0_7,R.id.ImageButton0_8,R.id.ImageButton0_9},
            {R.id.ImageButton1_0, R.id.ImageButton1_1, R.id.ImageButton1_2, R.id.ImageButton1_3, R.id.ImageButton1_4, R.id.ImageButton1_5, R.id.ImageButton1_6,R.id.ImageButton1_7,R.id.ImageButton1_8,R.id.ImageButton1_9},
            {R.id.ImageButton2_0, R.id.ImageButton2_1, R.id.ImageButton2_2, R.id.ImageButton2_3, R.id.ImageButton2_4, R.id.ImageButton2_5, R.id.ImageButton2_6,R.id.ImageButton2_7,R.id.ImageButton2_8,R.id.ImageButton2_9},
            {R.id.ImageButton3_0, R.id.ImageButton3_1, R.id.ImageButton3_2, R.id.ImageButton3_3, R.id.ImageButton3_4, R.id.ImageButton3_5, R.id.ImageButton3_6,R.id.ImageButton3_7,R.id.ImageButton3_8,R.id.ImageButton3_9},
            {R.id.ImageButton4_0, R.id.ImageButton4_1, R.id.ImageButton4_2, R.id.ImageButton4_3, R.id.ImageButton4_4, R.id.ImageButton4_5, R.id.ImageButton4_6,R.id.ImageButton4_7,R.id.ImageButton4_8,R.id.ImageButton4_9},
            {R.id.ImageButton5_0, R.id.ImageButton5_1, R.id.ImageButton5_2, R.id.ImageButton5_3, R.id.ImageButton5_4, R.id.ImageButton5_5, R.id.ImageButton5_6,R.id.ImageButton5_7,R.id.ImageButton5_8,R.id.ImageButton5_9},
            {R.id.ImageButton6_0, R.id.ImageButton6_1, R.id.ImageButton6_2, R.id.ImageButton6_3, R.id.ImageButton6_4, R.id.ImageButton6_5, R.id.ImageButton6_6,R.id.ImageButton6_7,R.id.ImageButton6_8,R.id.ImageButton6_9},
            {R.id.ImageButton7_0, R.id.ImageButton7_1, R.id.ImageButton7_2, R.id.ImageButton7_3, R.id.ImageButton7_4, R.id.ImageButton7_5, R.id.ImageButton7_6,R.id.ImageButton7_7,R.id.ImageButton7_8,R.id.ImageButton7_9},
            {R.id.ImageButton8_0, R.id.ImageButton8_1, R.id.ImageButton8_2, R.id.ImageButton8_3, R.id.ImageButton8_4, R.id.ImageButton8_5, R.id.ImageButton8_6,R.id.ImageButton8_7,R.id.ImageButton8_8,R.id.ImageButton8_9},
            {R.id.ImageButton9_0, R.id.ImageButton9_1, R.id.ImageButton9_2, R.id.ImageButton9_3, R.id.ImageButton9_4, R.id.ImageButton9_5, R.id.ImageButton9_6,R.id.ImageButton9_7,R.id.ImageButton9_8,R.id.ImageButton9_9}
    };

    private String[] letters = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","enne","o","p","q","r","s","t","u","v","x","y","z",};


    private String[] capitales;
    public Juego juego;
    private String[][] tablero;

    int i;
    int j;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        queue = Volley.newRequestQueue(this);

        textView = (TextView) findViewById(R.id.prueba);

        StringRequest request = new StringRequest(Request.Method.GET, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                String respuesta = response.replaceAll("\\[", "");
                respuesta = respuesta.replaceAll("\\]", "");
                respuesta = respuesta.replaceAll("\"", "");
                capitales=respuesta.split(",");
                juego = new Juego(capitales);
                imprimirTablero(juego, ids);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("error",error.toString());
            }
        });
        queue.add(request);

    }

    public void imprimirTablero(Juego juego, int[][] ids){
        String[][] tablero = juego.getTablero();
        for(int i=0;i<10;i++){
            for(int j=0;j<10;j++){
                findViewById(ids[j][i]).setBackgroundResource(getResources().getIdentifier(tablero[i][j],"drawable",getPackageName()));
            }
        }
    }


}


