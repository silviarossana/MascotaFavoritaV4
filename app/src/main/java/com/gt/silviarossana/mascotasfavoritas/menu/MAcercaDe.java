package com.gt.silviarossana.mascotasfavoritas.menu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.gt.silviarossana.mascotasfavoritas.ListaMascotas;
import com.gt.silviarossana.mascotasfavoritas.R;

public class MAcercaDe extends AppCompatActivity {

    Toolbar tbBarraPrincipal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_macerca_de);

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
    }

    @Override
    public boolean onSupportNavigateUp() {

        Intent intent = new Intent(this, ListaMascotas.class);
        //intent.putExtra("arrayMascotas", mascotas);

        startActivity(intent);

        onBackPressed();
        return false;
    }


}
