package com.example.entrega5;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText paraula;
    EditText jugador;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ((Button)findViewById(R.id.btStart)).setOnClickListener(this);
        jugador = (EditText)findViewById(R.id.txName);
        paraula = (EditText) findViewById(R.id.txWord);

    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.btStart:
                startPartida();
        }
    }

    public void startPartida(){
        if(paraula.getText().toString().length()==0){
            mostrarMissatge("Falta introduir Paraula");
        }else if(jugador.getText().toString().length()==0){
            mostrarMissatge("Falta introduir Nom del Jugaodr");
        }else{
            Intent start = new Intent(MainActivity.this,ActivityPartida.class);
            start.putExtra("jugador",new Jugador(jugador.getText().toString()));
            start.putExtra("paraula",paraula.getText().toString());
            startActivityForResult(start,1);

        }
    }

    public void mostrarMissatge(String missatge){

        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setMessage(missatge)
                .setTitle("Atenció");

        AlertDialog dialog = builder.create();
        dialog.show();
    }
}