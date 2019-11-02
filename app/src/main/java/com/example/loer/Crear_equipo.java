package com.example.loer;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import android.database.sqlite.SQLiteDatabase;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;


public class Crear_equipo extends AppCompatActivity {
    ImageView img;
    ImageButton ib;
    static final int REQUEST_IMAGE_CAPTURE = 1;
    private EditText et_n,et_d,et_e,et_c,et_p,et_eq;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_equipo);

        //Codigo para habilitar la flecha de atras
        Bundle bundle = getIntent().getExtras();
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        //traigo el contenido de los campos por su id
        img = (ImageView)findViewById(R.id.foto_jugador);
        ib = (ImageButton)findViewById(R.id.imageB);
        et_n = (EditText)findViewById(R.id.et_nombre);
        et_d = (EditText)findViewById(R.id.et_documento);
        et_e = (EditText)findViewById(R.id.et_edad);
        et_c = (EditText)findViewById(R.id.et_celular);
        et_p = (EditText)findViewById(R.id.et_posicion);
        et_eq = (EditText)findViewById(R.id.et_equipo);

        ib.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                llamarintent();
            }
        });

    }

    private void llamarintent(){
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            img.setImageBitmap(imageBitmap);
        }
    }
    //Metodo para dar de alta a los jugadores
    public  void incribir(View view){
        AdminSQLieteOpenHelper admin = new AdminSQLieteOpenHelper(this, "administracion", null, 1);
        SQLiteDatabase BaseDeDatos = admin.getWritableDatabase();

    }



}
