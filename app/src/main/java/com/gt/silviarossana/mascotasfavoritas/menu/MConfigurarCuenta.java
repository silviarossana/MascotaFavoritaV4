package com.gt.silviarossana.mascotasfavoritas.menu;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.gt.silviarossana.mascotasfavoritas.ListaMascotas;
import com.gt.silviarossana.mascotasfavoritas.R;
import com.gt.silviarossana.mascotasfavoritas.fragment.FragmentPerfil;


public class MConfigurarCuenta extends AppCompatActivity {

    Toolbar tbBarraPrincipal;
    EditText etConfigurarUsuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mconfigurar_cuenta);

        this.tbBarraPrincipal = (Toolbar) findViewById(R.id.miActionBar);
        if (this.tbBarraPrincipal != null) {
            setSupportActionBar(this.tbBarraPrincipal);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        etConfigurarUsuario = (EditText)findViewById(R.id.etConfigurarUsuario);
    }

    /**
     *
     * @param v
     */
    public void btnClickconfigurarCuenta(View v){



        if(!etConfigurarUsuario.getText().toString().equals("")){

            //Toast.makeText(this, etConfigurarUsuario.getText().toString(), Toast.LENGTH_LONG).show();

            if(etConfigurarUsuario.getText().toString().trim()
                    .equals(FragmentPerfil.USUARIO_NOMBRE_PERRITO_POCHITO)){

                FragmentPerfil.USUARIO_ACTUAL = FragmentPerfil.USUARIO_PERRITO_POCHITO;
                enviarInicio(v);

            }else if(etConfigurarUsuario.getText().toString().trim()
                    .equals(FragmentPerfil.USUARIO_NOMBRE_GATITO_WAFLE)){

                FragmentPerfil.USUARIO_ACTUAL = FragmentPerfil.USUARIO_GATITO_WAFLE;
                enviarInicio(v);

            }else{
                Toast.makeText(this, "Usuario no tiene permisos en Sandbox", Toast.LENGTH_LONG).show();
            }

        }

    }


    private void enviarInicio(View v){

        //startActivity(intent);
        Intent intent = new Intent(this, ListaMascotas.class);
        startActivity(intent);
    }

}
