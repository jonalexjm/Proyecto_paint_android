package jonalexjm.com.appisapaintactivityblank;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.preference.DialogPreference;
import android.provider.MediaStore;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.UUID;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    ImageButton negro;
    ImageButton azul;
    ImageButton rojo;
    ImageButton amarillo;
    ImageButton verde;

    ImageButton marron;
    ImageButton piel;
    ImageButton naranja;
    ImageButton azul_fosforecente;
    ImageButton magneta;

    ImageButton nuevo;
    ImageButton trazo;
    ImageButton borrar;
    ImageButton guardar;


    Lienzo lienzo;
    float pequeno;
    float mediano;
    float grande;

    float pdefecto;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        negro = (ImageButton) findViewById(R.id.imgBtnNegro);
        azul = (ImageButton) findViewById(R.id.imgBtnAzul);
        rojo = (ImageButton) findViewById(R.id.imgBtnRojo);
        amarillo = (ImageButton) findViewById(R.id.imgBtnAmarillo);
        verde = (ImageButton) findViewById(R.id.imgBtnVerde);

        marron = (ImageButton) findViewById(R.id.imgBtnMarron);
        piel = (ImageButton) findViewById(R.id.imgBtnpiel);
        naranja = (ImageButton) findViewById(R.id.imgBtnNaranja);
        azul_fosforecente = (ImageButton) findViewById(R.id.imgBtnAzulFosforecente);
        magneta = (ImageButton) findViewById(R.id.imgBtnMagneta);

        nuevo = (ImageButton) findViewById(R.id.btnNuevo);
        trazo = (ImageButton) findViewById(R.id.btnTrazo);
        borrar = (ImageButton) findViewById(R.id.btnBorrar);
        guardar = (ImageButton) findViewById(R.id.btnGuardar);


        negro.setOnClickListener(this);
        azul.setOnClickListener(this);
        rojo.setOnClickListener(this);
        amarillo.setOnClickListener(this);
        verde.setOnClickListener(this);
        nuevo.setOnClickListener(this);
        trazo.setOnClickListener(this);
        borrar.setOnClickListener(this);
        guardar.setOnClickListener(this);
        marron.setOnClickListener(this);
        piel.setOnClickListener(this);
        naranja.setOnClickListener(this);
        azul_fosforecente.setOnClickListener(this);
        magneta.setOnClickListener(this);

        lienzo = (Lienzo) findViewById(R.id.viewLiezo);

        pequeno = 10;
        mediano = 20;
        grande = 30;
        pdefecto = mediano;


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        String color = null;

        switch (v.getId()){
            case R.id.imgBtnNegro:
                color = v.getTag().toString();
                lienzo.setColor(color);
                break;
            case R.id.imgBtnAzul:
                 color = v.getTag().toString();
                lienzo.setColor(color);
                break;
            case R.id.imgBtnAmarillo:
                 color = v.getTag().toString();
                lienzo.setColor(color);
                break;
            case R.id.imgBtnVerde:
                color = v.getTag().toString();
                lienzo.setColor(color);
                break;
            case R.id.imgBtnRojo:
                color = v.getTag().toString();
                lienzo.setColor(color);

                break;
            case R.id.imgBtnMarron:
                color = v.getTag().toString();
                lienzo.setColor(color);
                break;
            case R.id.imgBtnpiel:
                color = v.getTag().toString();
                lienzo.setColor(color);
                break;
            case R.id.imgBtnAzulFosforecente:
                color = v.getTag().toString();
                lienzo.setColor(color);
                break;
            case R.id.imgBtnNaranja:
                color = v.getTag().toString();
                lienzo.setColor(color);
                break;
            case R.id.imgBtnMagneta:
                color = v.getTag().toString();
                lienzo.setColor(color);

                break;
            case R.id.btnNuevo:

                AlertDialog.Builder newDialog = new AlertDialog.Builder(this);
                newDialog.setTitle("Nuevo Dibujo");
                newDialog.setMessage("Comenzar nuevo dibujo(si continuas perderas el actual)?");
                newDialog.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        lienzo.NuevoDibujo();
                        dialog.dismiss();
                    }
                });
                newDialog.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                newDialog.show();
                break;

            case R.id.btnTrazo:

                final Dialog tamanyopunto = new Dialog(this);
                tamanyopunto.setTitle("Tamaño del pincel:");
                tamanyopunto.setContentView(R.layout.tamano_punto);
                //listen for clicks on tamaños de los botones
                TextView smallBtn = (TextView)tamanyopunto.findViewById(R.id.tvPequeno);
                smallBtn.setOnClickListener(new View.OnClickListener(){
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(MainActivity.this, "has dado click en boton", Toast.LENGTH_SHORT).show();
                        lienzo.setBorrado(false);
                        lienzo.setTamanoPunto(pequeno);

                        tamanyopunto.dismiss();//cierra la ventanita de opcion
                    }
                });
                TextView mediumBtn = (TextView)tamanyopunto.findViewById(R.id.tvMediano);
                mediumBtn.setOnClickListener(new View.OnClickListener(){
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(MainActivity.this, "has dado click en boton", Toast.LENGTH_SHORT).show();
                        lienzo.setBorrado(false);
                        lienzo.setTamanoPunto(mediano);

                        tamanyopunto.dismiss();
                    }
                });
                TextView largeBtn = (TextView)tamanyopunto.findViewById(R.id.tvGrande);
                largeBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(MainActivity.this, "has dado click en boton", Toast.LENGTH_SHORT).show();
                        lienzo.setBorrado(false);
                        lienzo.setTamanoPunto(grande);

                        tamanyopunto.dismiss();
                    }
                });
                //show and wait for user interaction
                tamanyopunto.show();


                break;
            case R.id.btnBorrar:

                final Dialog borrarpunto = new Dialog(this);
                borrarpunto.setTitle("Tamaño del borrador:");
                borrarpunto.setContentView(R.layout.tamano_punto);
                //listen for clicks on tamaños de los botones
                TextView smallBtnBorrar = (TextView)borrarpunto.findViewById(R.id.tvPequeno);
                smallBtnBorrar.setOnClickListener(new View.OnClickListener(){
                    @Override
                    public void onClick(View v) {

                        lienzo.setBorrado(true);

                        lienzo.setTamanoPunto(pequeno);


                        borrarpunto.dismiss();//cierra la ventanita de opcion
                    }
                });
                TextView mediumBtnBorrar = (TextView)borrarpunto.findViewById(R.id.tvMediano);
                mediumBtnBorrar.setOnClickListener(new View.OnClickListener(){
                    @Override
                    public void onClick(View v) {

                        lienzo.setBorrado(true);
                        lienzo.setTamanoPunto(mediano);

                        borrarpunto.dismiss();
                    }
                });
                TextView largeBtnBorrar = (TextView)borrarpunto.findViewById(R.id.tvGrande);
                largeBtnBorrar.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        lienzo.setBorrado(true);
                        lienzo.setTamanoPunto(grande);

                        borrarpunto.dismiss();
                    }
                });
                //show and wait for user interaction
                borrarpunto.show();

                break;
            case R.id.btnGuardar:
                AlertDialog.Builder salvarDibujo = new AlertDialog.Builder(this);
                salvarDibujo.setTitle("Desea guardar el  dibujo");
                salvarDibujo.setMessage("¿Desea guardar el Dibujo en la  galeria?");
                salvarDibujo.setPositiveButton("Aceptar", new DialogInterface.OnClickListener(){
                    public void onClick(DialogInterface dialog, int which){

                        //Salvar dibujo
                        lienzo.setDrawingCacheEnabled(true);
                        //attempt to save
                        String imgSaved = MediaStore.Images.Media.insertImage(
                                getContentResolver(), lienzo.getDrawingCache(),
                                UUID.randomUUID().toString()+".png", "drawing");
                        //Mensaje de todo correcto
                        if(imgSaved!=null){
                            Toast savedToast = Toast.makeText(getApplicationContext(),
                                    "¡Dibujo salvado en la galeria!", Toast.LENGTH_SHORT);
                            savedToast.show();
                        }
                        else{
                            Toast unsavedToast = Toast.makeText(getApplicationContext(),
                                    "¡Error! La imagen no ha podido ser guardada.", Toast.LENGTH_SHORT);
                            unsavedToast.show();
                        }
                        lienzo.destroyDrawingCache();


                    }
                });
                salvarDibujo.setNegativeButton("Cancelar", new DialogInterface.OnClickListener(){
                    public void onClick(DialogInterface dialog, int which){
                        dialog.cancel();
                    }
                });
                salvarDibujo.show();

                break;
            default:
                break;
        }
    }

    public void tamanoPincel(){

    }


}
