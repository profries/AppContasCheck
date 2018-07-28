package com.example.iossenac.appcontascheck;

import android.app.Dialog;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, Dialog.OnClickListener{
    CheckBox checkAgua, checkLuz, checkTelefone, checkCelular;
    Button botaoPagar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        checkAgua = (CheckBox) findViewById(R.id.checkAgua);
        checkLuz = (CheckBox) findViewById(R.id.checkLuz);
        checkTelefone = (CheckBox) findViewById(R.id.checkTelefone);
        checkCelular = (CheckBox) findViewById(R.id.checkCelular);
        botaoPagar = (Button) findViewById(R.id.botaoPagar);

        botaoPagar.setOnClickListener(this);
    }



    @Override
    public void onClick(View view) {
        int total = 0;

        if(checkAgua.isChecked())
            total += Integer.parseInt(checkAgua.getTag().toString());

        if(checkLuz.isChecked())
            total += Integer.parseInt(checkLuz.getTag().toString());

        if(checkTelefone.isChecked())
            total += Integer.parseInt(checkTelefone.getTag().toString());

        if(checkCelular.isChecked())
            total += Integer.parseInt(checkCelular.getTag().toString());


        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        dialog.setTitle("Pagamento");
        dialog.setMessage("O valor do pagamento total é "+total+". Confirma pagamento?");
        dialog.setPositiveButton("OK",this);
        dialog.setNegativeButton("Cancelar",this);
        dialog.show();
    }

    @Override
    public void onClick(DialogInterface dialog, int tipo) {
        if(tipo == AlertDialog.BUTTON_POSITIVE){
            Toast.makeText(this,"Pagamento realizado com sucesso!",Toast.LENGTH_SHORT)
                    .show();
        }
        else if(tipo == AlertDialog.BUTTON_NEGATIVE){
            Toast.makeText(this,"Pagamento cancelado!",Toast.LENGTH_SHORT)
                    .show();
        }
        checkAgua.setChecked(false);
        checkLuz.setChecked(false);
        checkTelefone.setChecked(false);
        checkCelular.setChecked(false);
    }
}
