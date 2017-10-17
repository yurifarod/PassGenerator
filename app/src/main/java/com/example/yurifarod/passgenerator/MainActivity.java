package com.example.yurifarod.passgenerator;

import android.support.v7.app.*;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.widget.*;
import android.view.*;
import android.app.*;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    EditText tamanho;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tamanho = (EditText) findViewById(R.id.tamanho);
        button = (Button) findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v){

                int tam = Integer.parseInt(tamanho.getText().toString());
                AlertDialog.Builder dialogo = new AlertDialog.Builder(MainActivity.this);

                String senha = gerarSenha(tam);
                if(tam > 1 && tam < 17) {
                    dialogo.setTitle("Senha Gerada:");
                    dialogo.setMessage(senha);
                    dialogo.setNeutralButton("OBRIGADO!", null);
                    dialogo.show();
                }
                else{
                    dialogo.setTitle("Senha Gerada:");
                    dialogo.setMessage("SÓ VALORES ENTRE 2 E 16");
                    dialogo.setNeutralButton("OBRIGADO!", null);
                    dialogo.show();
                }

            }
        });
    }

    protected String gerarSenha(int tam){
        String resultado = "";
        int[] primo = new int[7];
        primo[0] = 233;
        primo[1] = 619;
        primo[2] = 293;
        primo[3] = 271;
        primo[4] = 269;
        primo[5] = 61;
        primo[6] = 383;

        Random gerador = new Random();

        for(int i = 0; i < tam; i++){
            int indice = gerador.nextInt(7);
            int cod = gerador.nextInt(1000)*primo[indice];
            cod = cod % 127;
            while(cod < 32){
                cod = gerador.nextInt(1000)*primo[indice];
                cod = cod % 127;
            }
            resultado += (char)cod;
        }

        return resultado;
    }
}
