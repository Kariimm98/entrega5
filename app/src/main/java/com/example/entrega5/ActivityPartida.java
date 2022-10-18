package com.example.entrega5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class ActivityPartida extends AppCompatActivity {

    Partida partida;
    Map<Integer, List<View>>parts ;
    EditText paraula;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init();
        setContentView(R.layout.activity_partida);
        Jugador jugador = (Jugador) getIntent().getSerializableExtra("jugador");
        String paraula = getIntent().getStringExtra("paraula");

        this.partida = new Partida(jugador,paraula);

        addPartsToMap();

    }


    public void init(){
        this.paraula = (EditText)findViewById(R.id.txWord);
        String caracters = partida.getParaula().replaceAll("/[a-z0-9]/gi", "_");
        this.paraula.setText(caracters);
    }

    public void addPartsToMap(){
        ViewGroup root = (ViewGroup) findViewById(android.R.id.content).getRootView();

        for(int i = 0; i<root.getChildCount();i++){
            View view = root.getChildAt(i);
            view.setVisibility(View.INVISIBLE);

            String nomView = getResources().getResourceName(view.getId()).toLowerCase(Locale.ROOT);

            if(nomView.contains("lbobj") && nomView.contains(i+"")){
                List<View>  arr= parts.get(i);

                if(arr ==null){
                    arr = new ArrayList<>();
                    arr.add(view);
                    parts.put(i,arr);
                }else{
                    parts.get(i).add(view);
                }
            }
        }
    }
}