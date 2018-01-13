package com.puzzle.wi.puzzle;

import android.annotation.SuppressLint;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.puzzle.wi.puzzle.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    ImageButton btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btnVacio;
    Button start;
    float initialX, initialY;



    int[] b1, b2, b3, b4, b5, b6, b7, b8, fichaVacia;
    TextView texto1;
    Boolean empieza = false;


    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        texto1 = (TextView) findViewById(R.id.texto1);
        btn1 = (ImageButton) findViewById(R.id.btn1);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Click(view, b1);
            }
        });
        btn2 = (ImageButton) findViewById(R.id.btn2);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Click(view, b2);
            }
        });
        btn3 = (ImageButton) findViewById(R.id.btn3);
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Click(view, b3);
            }
        });
        btn4 = (ImageButton) findViewById(R.id.btn4);
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Click(view, b4);
            }
        });
        btn5 = (ImageButton) findViewById(R.id.btn5);
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Click(view, b5);
            }
        });
        btn6 = (ImageButton) findViewById(R.id.btn6);
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Click(view, b6);
            }
        });
        btn7 = (ImageButton) findViewById(R.id.btn7);
        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Click(view, b7);
            }
        });
        btn8 = (ImageButton) findViewById(R.id.btn8);
        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Click(view, b8);
            }
        });
        btnVacio = (ImageButton) findViewById(R.id.btnVacio);


        start = (Button) findViewById(R.id.start);
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                empieza = true;
                Inicia(empieza);
            }
        });

        Inicia(false);

    }


    /** When the player does click in each image, if it's possible, it lets to change it position
     *
     * @param v -> View
     * @param ficha -> id of the image selected
     */
    public void Click(View v, int[] ficha) {
        if(empieza) {
            float vacioX = btnVacio.getX();
            float vacioY = btnVacio.getY();
            if ((ficha[0] + 1 == fichaVacia[0] && ficha[1] == fichaVacia[1]) || (ficha[0] - 1 == fichaVacia[0] && ficha[1] == fichaVacia[1]) || (ficha[1] + 1 == fichaVacia[1] && ficha[0] == fichaVacia[0]) || (ficha[1] - 1 == fichaVacia[1] && ficha[0] == fichaVacia[0])) {
                btnVacio.setX(v.getX());
                btnVacio.setY(v.getY());
                v.setX(vacioX);
                v.setY(vacioY);
                int newPosX = fichaVacia[0];
                int newPosY = fichaVacia[1];
                fichaVacia[0] = ficha[0];
                fichaVacia[1] = ficha[1];
                ficha[0] = newPosX;
                ficha[1] = newPosY;

                //Test if the images are in their correct position
                comprueba();
            }
        }
    }


    /** Test if the images are in their correct position
     *
     */
    public void comprueba() {
        if(
                b1[0] == 0 && b1[1] == 0 &&
                b2[0] == 1 && b2[1] == 0 &&
                b3[0] == 2 && b3[1] == 0 &&
                b4[0] == 0 && b4[1] == 1 &&
                b5[0] == 1 && b5[1] == 1 &&
                b6[0] == 2 && b6[1] == 1 &&
                b7[0] == 0 && b7[1] == 2 &&
                b8[0] == 1 && b8[1] == 2
        ){
        texto1.setText("ENHORABUENA. HAS GANADO");
        }
    }


    /** It initialize the images: If Start is not clicked shows the image complete; if not, it shows the images random
     *
     * @param empieza -> Boolean -> true:Can start the game and execute a rand for the images; false: still cannot start the game
     */
    public void Inicia(Boolean empieza){
        //Inicializa al azar las fichas
        int[][] fichas = {{0,0},{1,0},{2,0},{0,1},{1,1},{2,1},{0,2},{1,2},{2,2}};
        List<int[]> lista = Arrays.asList(fichas);
        if(empieza) {
            Collections.shuffle(lista, new Random());
        }
        b1 = fichas[0];
        b2 = fichas[1];
        b3 = fichas[2];
        b4 = fichas[3];
        b5 = fichas[4];
        b6 = fichas[5];
        b7 = fichas[6];
        b8 = fichas[7];
        fichaVacia = fichas[8];
        float density = Resources.getSystem().getDisplayMetrics().density;
        btn1.setX(b1[0] * density * 120);
        btn1.setY(b1[1] * density * 120);
        btn2.setX(b2[0] * density * 120);
        btn2.setY(b2[1] * density * 120);
        btn3.setX(b3[0] * density * 120);
        btn3.setY(b3[1] * density * 120);
        btn4.setX(b4[0] * density * 120);
        btn4.setY(b4[1] * density * 120);
        btn5.setX(b5[0] * density * 120);
        btn5.setY(b5[1] * density * 120);
        btn6.setX(b6[0] * density * 120);
        btn6.setY(b6[1] * density * 120);
        btn7.setX(b7[0] * density * 120);
        btn7.setY(b7[1] * density * 120);
        btn8.setX(b8[0] * density * 120);
        btn8.setY(b8[1] * density * 120);
        btnVacio.setX(fichaVacia[0] * density * 120);
        btnVacio.setY(fichaVacia[1] * density * 120);
    }

    @Override
    public void onClick(View view) {}
}

