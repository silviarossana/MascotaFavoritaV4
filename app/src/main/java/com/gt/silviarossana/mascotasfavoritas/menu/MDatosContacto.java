package com.gt.silviarossana.mascotasfavoritas.menu;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.gt.silviarossana.mascotasfavoritas.ListaMascotas;
import com.gt.silviarossana.mascotasfavoritas.R;

public class MDatosContacto extends AppCompatActivity {

    Toolbar tbBarraPrincipal;
    private TextView etNombre;
    private TextView etEmail;
    private TextView etDescripcion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mdatos_contacto);


        this.tbBarraPrincipal = (Toolbar) findViewById(R.id.miActionBar);
        if (this.tbBarraPrincipal != null) {
            setSupportActionBar(this.tbBarraPrincipal);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        /*CircularImageView circularImageView = (CircularImageView)findViewById(R.id.yourCircularImageView);
        // Set Border
                circularImageView.setBorderColor(getResources().getColor(R.color.GrayLight));
                circularImageView.setBorderWidth(10);
        // Add Shadow with default param
                circularImageView.addShadow();
        // or with custom param
                circularImageView.setShadowRadius(15);
        circularImageView.setShadowColor(Color.RED);*/

        this.cargarDatosConfirmar();
    }

    @Override
    public boolean onSupportNavigateUp() {

        Intent intent = new Intent(this, ListaMascotas.class);
        //intent.putExtra("arrayMascotas", mascotas);

        startActivity(intent);

        onBackPressed();
        return false;
    }




    /**
     * Cargar parametros enviados
     */
    private void cargarDatosConfirmar(){

        Bundle parametro = getIntent().getExtras();

        etNombre = (TextView) findViewById(R.id.etNombre);
        //etNombre.setText(parametro.getString(getResources().getString(R.string.hint_nombre)));

        etEmail = (TextView) findViewById(R.id.etMail);
        //tvEmail.setText(parametro.getString(getResources().getString(R.string.hint_email)));

        etDescripcion = (TextView) findViewById(R.id.etDescripcion);
        //tvDescripcion.setText(parametro.getString(getResources().getString(R.string.hint_descripcion)));
    }


    /**
     *
     * @param v
     */
    public void btnClickEnviarDatos(View v){

    // Reemplazamos el email por algun otro real
        String[] to = {this.etEmail.getText().toString() };
        //String[] cc = { "otroEmail@ejemplo.com" };
        enviar(to, null, this.etNombre.getText().toString(),
                this.etDescripcion.getText().toString() +
                "\nEsto es un email enviado desde una app de Android"
                );

        //startActivity(intent);
    }


    private void enviar(String[] to, String[] cc,
                        String asunto, String mensaje) {
        Intent emailIntent = new Intent(Intent.ACTION_SEND);
        emailIntent.setData(Uri.parse("mailto:"));
        //String[] to = direccionesEmail;
        //String[] cc = copias;
        emailIntent.putExtra(Intent.EXTRA_EMAIL, to);
        emailIntent.putExtra(Intent.EXTRA_CC, cc);
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, asunto);
        emailIntent.putExtra(Intent.EXTRA_TEXT, mensaje);
        emailIntent.setType("message/rfc822");
        startActivity(Intent.createChooser(emailIntent, "Email "));
    }
}
