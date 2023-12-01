package com.example.collegamentofinale;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;


public class Gioco extends AppCompatActivity {
    public static final String PUNT1_KEY = "punt1";
    public static final String PUNT2_KEY = "punt2";

    int WC = 170, HC = 170, WX = 180, HX = 180;
    int numeroCasuale,numeroCasuale2 ,numeroCasuale3,numeroCasuale4,numeroCasuale5,numeroCasuale6;

    LinearLayout ly;
    EditText et;
    Button skip, pareggio;
    ImageView id1, id2, id3, id4, id5, id6;
    TextView punteggio, turno, t1, t2, t3, t4, t5, t6, t7, t8,t9;
    ContentResolver contentResolver;
    private boolean pos1 = false,pos2 = false,pos3 = false,pos4 = false,pos5 = false,pos6 = false,pos7 = false, pos8 = false,pos9 = false,c2 = false,c3 = false,c4 = false,c1 = false,c5 = false,c6 = false,c7 = false,c8 = false,c9 = false,x1 = false,x2 = false,x3 = false,x4 = false,x5 = false,x6 = false,x7 = false,x8 = false,x9 = false;

    ArrayList<String> immagini = new ArrayList<>(Arrays.asList(
            "immagine1", "immagine2", "immagine3", "immagine4", "immagine5", "immagine6", "immagine7", "immagine8", "immagine9", "immagine10", "immagine11", "immagine12", "immagine13", "immagine14", "immagine15", "immagine16", "immagine17", "immagine18", "immagine19", "immagine20", "immagine21", "immagine22", "immagine23", "immagine24", "immagine25", "immagine26", "immagine27", "immagine28", "immagine29", "immagine30"));



    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gioco);


        contentResolver = getContentResolver();



        ImageButton pos1Button = findViewById(R.id.pos1);
        ImageButton pos2Button = findViewById(R.id.pos2);
        ImageButton pos3Button = findViewById(R.id.pos3);
        ImageButton pos4Button = findViewById(R.id.pos4);
        ImageButton pos5Button = findViewById(R.id.pos5);
        ImageButton pos6Button = findViewById(R.id.pos6);
        ImageButton pos7Button = findViewById(R.id.pos7);
        ImageButton pos8Button = findViewById(R.id.pos8);
        ImageButton pos9Button = findViewById(R.id.pos9);

        punteggio = findViewById(R.id.punteggio);
       // punteggio.setText("P1 " + punt1 + "-" + punt2 + " P2");
        turno = findViewById(R.id.turno);
        skip = findViewById(R.id.skip);
        pareggio = findViewById(R.id.pareggio);
        ly = findViewById(R.id.ly);
        et = findViewById(R.id.et);

        t1 = findViewById(R.id.trovato1);
        t2 = findViewById(R.id.trovato2);
        t3 = findViewById(R.id.trovato3);
        t4 = findViewById(R.id.trovato4);
        t5 = findViewById(R.id.trovato5);
        t6 = findViewById(R.id.trovato6);
        t7 = findViewById(R.id.trovato7);
        t8 = findViewById(R.id.trovato8);
        t9 = findViewById(R.id.trovato9);

        id1 = findViewById(R.id.iv1);
        id2 = findViewById(R.id.iv2);
        id3 = findViewById(R.id.iv3);
        id4 = findViewById(R.id.iv4);
        id5 = findViewById(R.id.iv5);
        id6 = findViewById(R.id.iv6);

        Set<Integer> numeriGenerati = new HashSet<>();
        Random random = new Random();
        numeroCasuale = generaNumeroCasuale(1, 30, numeriGenerati, random);
        numeroCasuale2 = generaNumeroCasuale(1, 30, numeriGenerati, random);
        numeroCasuale3 = generaNumeroCasuale(1, 30, numeriGenerati, random);
        numeroCasuale4 = generaNumeroCasuale(1, 30, numeriGenerati, random);
        numeroCasuale5 = generaNumeroCasuale(1, 30, numeriGenerati, random);
        numeroCasuale6 = generaNumeroCasuale(1, 30, numeriGenerati, random);


        if (savedInstanceState != null) {
            PunteggioManager.setPunt1(savedInstanceState.getInt(PUNT1_KEY, 0));
            PunteggioManager.setPunt2(savedInstanceState.getInt(PUNT2_KEY, 0));
            updatePunteggio();
        }



        String immagineCasuale = "immagine" + numeroCasuale;
        int idImmagine = getResources().getIdentifier(immagineCasuale, "drawable", getPackageName());
        id1.setImageResource(idImmagine);


        String immagineCasuale2 = "immagine" + numeroCasuale2;
        int idImmagine2 = getResources().getIdentifier(immagineCasuale2, "drawable", getPackageName());
        id2.setImageResource(idImmagine2);


        String immagineCasuale3 = "immagine" + numeroCasuale3;
        int idImmagine3 = getResources().getIdentifier(immagineCasuale3, "drawable", getPackageName());
        id3.setImageResource(idImmagine3);


        String immagineCasuale4 = "immagine" + numeroCasuale4;
        int idImmagine4 = getResources().getIdentifier(immagineCasuale4, "drawable", getPackageName());
        id4.setImageResource(idImmagine4);


        String immagineCasuale5 = "immagine" + numeroCasuale5;
        int idImmagine5 = getResources().getIdentifier(immagineCasuale5, "drawable", getPackageName());
        id5.setImageResource(idImmagine5);


        String immagineCasuale6 = "immagine" + numeroCasuale6;
        int idImmagine6 = getResources().getIdentifier(immagineCasuale6, "drawable", getPackageName());
        id6.setImageResource(idImmagine6);



       //CERCASQUADRE
        ListView listView = findViewById(R.id.listView);

        /*String[] dati = {"Elemento 1", "Elemento 2", "Elemento 3"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, dati);
        listView.setAdapter(adapter);*/

        pos1Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                searchPlayer(view);
                // Imposta la variabile booleana per pos1 a true e le altre a false
                pos1 = true;
                pos2 = false;
                pos3 = false;
                pos4 = false;
                pos5 = false;
                pos6 = false;
                pos7 = false;
                pos8 = false;
                pos9 = false;
            }
        });

        pos2Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("CASUALI", "numeroCasuale: " + numeroCasuale + " numero2 " + numeroCasuale2 + " numeroCasuale3: " + numeroCasuale3 + " numeroCasuale4: " + numeroCasuale4 + " numeroCasuale5: " + numeroCasuale5 + " numeroCasuale6: " + numeroCasuale6);

                searchPlayer(view);
                pos1 = false;
                pos2 = true;
                pos3 = false;
                pos4 = false;
                pos5 = false;
                pos6 = false;
                pos7 = false;
                pos8 = false;
                pos9 = false;
            }
        });

        pos3Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                searchPlayer(view);
                pos1 = false;
                pos2 = false;
                pos3 = true;
                pos4 = false;
                pos5 = false;
                pos6 = false;
                pos7 = false;
                pos8 = false;
                pos9 = false;
            }
        });

        pos4Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                searchPlayer(view);
                pos1 = false;
                pos2 = false;
                pos3 = false;
                pos4 = true;
                pos5 = false;
                pos6 = false;
                pos7 = false;
                pos8 = false;
                pos9 = false;
            }
        });

        pos5Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                searchPlayer(view);
                pos1 = false;
                pos2 = false;
                pos3 = false;
                pos4 = false;
                pos5 = true;
                pos6 = false;
                pos7 = false;
                pos8 = false;
                pos9 = false;
            }
        });

        pos6Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                searchPlayer(view);
                pos1 = false;
                pos2 = false;
                pos3 = false;
                pos4 = false;
                pos5 = false;
                pos6 = true;
                pos7 = false;
                pos8 = false;
                pos9 = false;
            }
        });

        pos7Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                searchPlayer(view);
                pos1 = false;
                pos2 = false;
                pos3 = false;
                pos4 = false;
                pos5 = false;
                pos6 = false;
                pos7 = true;
                pos8 = false;
                pos9 = false;
            }
        });

        pos8Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pos1 = false;
                pos2 = false;
                pos3 = false;
                pos4 = false;
                pos5 = false;
                pos6 = false;
                pos7 = false;
                pos8 = true;
                pos9 = false;
                searchPlayer(view);
            }
        });

        pos9Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                searchPlayer(view);
                pos1 = false;
                pos2 = false;
                pos3 = false;
                pos4 = false;
                pos5 = false;
                pos6 = false;
                pos7 = false;
                pos8 = false;
                pos9 = true;
            }
        });




        et.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                // Azioni prima che il testo cambi (può essere lasciato vuoto se non sono necessarie azioni)
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                String userInput = et.getText().toString();
                String[] projection = {"nomep"};
                String selection = "nomep LIKE ? OR nomep LIKE ?";
                String[] selectionArgs = new String[]{userInput + "%", "% " + userInput + "%"};
                Cursor cursor = contentResolver.query(CONTENT_URI, projection, selection, selectionArgs, null);

                List<String> resultArray = new ArrayList<>();

                if (cursor != null) {
                    while (cursor.moveToNext()) {
                        String nome = cursor.getString(cursor.getColumnIndexOrThrow("nomep"));
                        if (!resultArray.contains(nome)) {
                            resultArray.add(nome);
                        }
                    }
                    cursor.close();
                }
                String[] resultStringArray = resultArray.toArray(new String[0]);


                ArrayAdapter<String> adapter = new ArrayAdapter<>(Gioco.this, android.R.layout.simple_list_item_1, resultStringArray);
                listView.setAdapter(adapter);

                    // listView.setVisibility(cursor.getCount() > 0 ? View.VISIBLE : View.GONE);
                    listView.setVisibility(View.VISIBLE);

                    if (et.getText().toString().equals("")){
                        listView.setVisibility(View.INVISIBLE);
                    }
                }


            @Override
            public void afterTextChanged(Editable editable) {
                // Azioni dopo che il testo è stato effettivamente cambiato (può essere lasciato vuoto se non sono necessarie azioni)
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Ottieni l'elemento selezionato dalla lista
                String selectedItem = (String) parent.getItemAtPosition(position);

                // Ora puoi fare qualcosa con l'elemento selezionato, ad esempio visualizzare un messaggio
               // Toast.makeText(MainActivity.this, "Hai selezionato: " + selectedItem, Toast.LENGTH_SHORT).show();


                if (pos1 == true) {
                    String[] projection = {"nomep"};
                    String selection = "nomep = ? AND id_s IN (?, ?)";
                    String[] selectionArgs = new String[]{selectedItem, String.valueOf(numeroCasuale), String.valueOf(numeroCasuale4)};
                    Cursor cursor = contentResolver.query(CONTENT_URI_2, projection, selection, selectionArgs, null);

                    if (cursor.getCount() >= 2){
                        cancel(view);
                        int firstCommaIndex = selectedItem.indexOf(' ');
                        String parteDopoSpazio = (firstCommaIndex != -1) ? selectedItem.substring(firstCommaIndex + 1) : selectedItem;

                        t1.setText(parteDopoSpazio);
                        if (turno.getText().toString().equals("P 1's TURN")){
                            Bitmap originalBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.cerchio);
                            Bitmap resizedBitmap = Bitmap.createScaledBitmap(originalBitmap, WC, HC, false);
                            pos1Button.setImageBitmap(resizedBitmap);
                            pos1Button.setClickable(false);
                            pos1Button.setEnabled(false);
                            c1 = true;
                        } else if (turno.getText().toString().equals("P 2's TURN")) {
                            Bitmap originalBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.x);
                            Bitmap resizedBitmap = Bitmap.createScaledBitmap(originalBitmap, WX, HX, false);
                            pos1Button.setImageBitmap(resizedBitmap);
                            pos1Button.setClickable(false);
                            pos1Button.setEnabled(false);
                            x1 = true;

                        }
                        verifica();

                    }
                    else {
                        cancel(view);
                        Toast.makeText(Gioco.this, selectedItem + " non ha giocato in entrambe le squadre ", Toast.LENGTH_SHORT).show();

                    }
                    changePlayer();
                    InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(pos9Button.getWindowToken(), 0);
                }

               else if (pos2 == true) {
                    String[] projection = {"nomep"};
                    String selection = "nomep = ? AND id_s IN (?, ?)";
                    String[] selectionArgs = new String[]{selectedItem, String.valueOf(numeroCasuale2), String.valueOf(numeroCasuale4)};
                    Cursor cursor = contentResolver.query(CONTENT_URI_2, projection, selection, selectionArgs, null);

                    if (cursor.getCount() >= 2){
                        cancel(view);
                        int firstCommaIndex = selectedItem.indexOf(' ');
                        String parteDopoSpazio = (firstCommaIndex != -1) ? selectedItem.substring(firstCommaIndex + 1) : selectedItem;

                        t2.setText(parteDopoSpazio);
                        if (turno.getText().toString().equals("P 1's TURN")){
                            Bitmap originalBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.cerchio);
                            Bitmap resizedBitmap = Bitmap.createScaledBitmap(originalBitmap, WC, HC, false);
                            pos2Button.setImageBitmap(resizedBitmap);
                            pos2Button.setClickable(false);
                            pos2Button.setEnabled(false);
                            c2 = true;
                        } else if (turno.getText().toString().equals("P 2's TURN")) {
                            Bitmap originalBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.x);
                            Bitmap resizedBitmap = Bitmap.createScaledBitmap(originalBitmap, WX, HX, false);
                            pos2Button.setImageBitmap(resizedBitmap);
                            pos2Button.setClickable(false);
                            pos2Button.setEnabled(false);
                            x2 = true;
                        }
                        verifica();

                    }
                    else {
                        cancel(view);
                        Toast.makeText(Gioco.this, selectedItem + " non ha giocato in entrambe le squadre ", Toast.LENGTH_SHORT).show();

                    }
                    changePlayer();
                    InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(pos9Button.getWindowToken(), 0);
                }

              else  if (pos3 == true) {
                    String[] projection = {"nomep"};
                    String selection = "nomep = ? AND id_s IN (?, ?)";
                    String[] selectionArgs = new String[]{selectedItem, String.valueOf(numeroCasuale3), String.valueOf(numeroCasuale4)};
                    Cursor cursor = contentResolver.query(CONTENT_URI_2, projection, selection, selectionArgs, null);

                    if (cursor.getCount() >= 2){
                        cancel(view);
                        int firstCommaIndex = selectedItem.indexOf(' ');
                        String parteDopoSpazio = (firstCommaIndex != -1) ? selectedItem.substring(firstCommaIndex + 1) : selectedItem;

                        t3.setText(parteDopoSpazio);
                        if (turno.getText().toString().equals("P 1's TURN")){
                            Bitmap originalBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.cerchio);
                            Bitmap resizedBitmap = Bitmap.createScaledBitmap(originalBitmap, WC, HC, false);
                            pos3Button.setImageBitmap(resizedBitmap);
                            pos3Button.setClickable(false);
                            pos3Button.setEnabled(false);
                            c3 = true;
                        }
                        else if (turno.getText().toString().equals("P 2's TURN")) {
                            Bitmap originalBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.x);
                            Bitmap resizedBitmap = Bitmap.createScaledBitmap(originalBitmap, WX, HX, false);
                            pos3Button.setImageBitmap(resizedBitmap);
                            pos3Button.setClickable(false);
                            pos3Button.setEnabled(false);
                            x3 = true;
                        }
                        verifica();

                    }
                    else {
                        cancel(view);
                        Toast.makeText(Gioco.this, selectedItem + " non ha giocato in entrambe le squadre ", Toast.LENGTH_SHORT).show();

                    }
                    changePlayer();
                    InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(pos9Button.getWindowToken(), 0);
                }

             else   if (pos4 == true) {
                    String[] projection = {"nomep"};
                    String selection = "nomep = ? AND id_s IN (?, ?)";
                    String[] selectionArgs = new String[]{selectedItem, String.valueOf(numeroCasuale), String.valueOf(numeroCasuale5)};
                    Cursor cursor = contentResolver.query(CONTENT_URI_2, projection, selection, selectionArgs, null);

                    if (cursor.getCount() >= 2){
                        cancel(view);
                        int firstCommaIndex = selectedItem.indexOf(' ');
                        String parteDopoSpazio = (firstCommaIndex != -1) ? selectedItem.substring(firstCommaIndex + 1) : selectedItem;

                        t4.setText(parteDopoSpazio);
                        if (turno.getText().toString().equals("P 1's TURN")){
                            Bitmap originalBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.cerchio);
                            Bitmap resizedBitmap = Bitmap.createScaledBitmap(originalBitmap, WC, HC, false);
                            pos4Button.setImageBitmap(resizedBitmap);
                            pos4Button.setClickable(false);
                            pos4Button.setEnabled(false);
                            c4 = true;
                        } else if (turno.getText().toString().equals("P 2's TURN")) {
                            Bitmap originalBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.x);
                            Bitmap resizedBitmap = Bitmap.createScaledBitmap(originalBitmap, WX, HX, false);
                            pos4Button.setImageBitmap(resizedBitmap);
                            pos4Button.setClickable(false);
                            pos4Button.setEnabled(false);
                            x4 = true;
                        }
                        verifica();

                    }
                    else {
                        cancel(view);
                        Toast.makeText(Gioco.this, selectedItem + " non ha giocato in entrambe le squadre ", Toast.LENGTH_SHORT).show();

                    }
                    changePlayer();
                    InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(pos9Button.getWindowToken(), 0);
                }

            else    if (pos5 == true) {
                    String[] projection = {"nomep"};
                    String selection = "nomep = ? AND id_s IN (?, ?)";
                    String[] selectionArgs = new String[]{selectedItem, String.valueOf(numeroCasuale2), String.valueOf(numeroCasuale5)};
                    Cursor cursor = contentResolver.query(CONTENT_URI_2, projection, selection, selectionArgs, null);

                    if (cursor.getCount() >= 2){
                        cancel(view);
                        int firstCommaIndex = selectedItem.indexOf(' ');
                        String parteDopoSpazio = (firstCommaIndex != -1) ? selectedItem.substring(firstCommaIndex + 1) : selectedItem;

                        t5.setText(parteDopoSpazio);
                        if (turno.getText().toString().equals("P 1's TURN")){
                            Bitmap originalBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.cerchio);
                            Bitmap resizedBitmap = Bitmap.createScaledBitmap(originalBitmap, WC, HC, false);
                            pos5Button.setImageBitmap(resizedBitmap);
                            pos5Button.setClickable(false);
                            pos5Button.setEnabled(false);
                            c5 = true;
                        } else if (turno.getText().toString().equals("P 2's TURN")) {
                            Bitmap originalBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.x);
                            Bitmap resizedBitmap = Bitmap.createScaledBitmap(originalBitmap, WX, HX, false);
                            pos5Button.setImageBitmap(resizedBitmap);
                            pos5Button.setClickable(false);
                            pos5Button.setEnabled(false);
                            x5 = true;
                        }
                        verifica();

                    }
                    else {
                        cancel(view);
                        Toast.makeText(Gioco.this, selectedItem + " non ha giocato in entrambe le squadre ", Toast.LENGTH_SHORT).show();

                    }
                    changePlayer();
                    InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(pos9Button.getWindowToken(), 0);
                }

               else if (pos6 == true) {
                    String[] projection = {"nomep"};
                    String selection = "nomep = ? AND id_s IN (?, ?)";
                    String[] selectionArgs = new String[]{selectedItem, String.valueOf(numeroCasuale3), String.valueOf(numeroCasuale5)};
                    Cursor cursor = contentResolver.query(CONTENT_URI_2, projection, selection, selectionArgs, null);

                    if (cursor.getCount() >= 2){
                        cancel(view);
                        int firstCommaIndex = selectedItem.indexOf(' ');
                        String parteDopoSpazio = (firstCommaIndex != -1) ? selectedItem.substring(firstCommaIndex + 1) : selectedItem;

                        t6.setText(parteDopoSpazio);
                        if (turno.getText().toString().equals("P 1's TURN")){
                            Bitmap originalBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.cerchio);
                            Bitmap resizedBitmap = Bitmap.createScaledBitmap(originalBitmap, WC, HC, false);
                            pos6Button.setImageBitmap(resizedBitmap);
                            pos6Button.setClickable(false);
                            pos6Button.setEnabled(false);
                            c6 = true;
                        } else if (turno.getText().toString().equals("P 2's TURN")) {
                            Bitmap originalBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.x);
                            Bitmap resizedBitmap = Bitmap.createScaledBitmap(originalBitmap, WX, HX, false);
                            pos6Button.setImageBitmap(resizedBitmap);
                            pos6Button.setClickable(false);
                            pos6Button.setEnabled(false);
                            x6 = true;
                        }
                        verifica();

                    }
                    else {
                        cancel(view);
                        Toast.makeText(Gioco.this, selectedItem + " non ha giocato in entrambe le squadre ", Toast.LENGTH_SHORT).show();

                    }
                    changePlayer();
                    InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(pos9Button.getWindowToken(), 0);
                }

               else if (pos7 == true) {
                    String[] projection = {"nomep"};
                    String selection = "nomep = ? AND id_s IN (?, ?)";
                    String[] selectionArgs = new String[]{selectedItem, String.valueOf(numeroCasuale), String.valueOf(numeroCasuale6)};
                    Cursor cursor = contentResolver.query(CONTENT_URI_2, projection, selection, selectionArgs, null);

                    if (cursor.getCount() >= 2){
                        cancel(view);
                        int firstCommaIndex = selectedItem.indexOf(' ');
                        String parteDopoSpazio = (firstCommaIndex != -1) ? selectedItem.substring(firstCommaIndex + 1) : selectedItem;

                        t7.setText(parteDopoSpazio);
                        if (turno.getText().toString().equals("P 1's TURN")){
                            Bitmap originalBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.cerchio);
                            Bitmap resizedBitmap = Bitmap.createScaledBitmap(originalBitmap, WC, HC, false);
                            pos7Button.setImageBitmap(resizedBitmap);
                            pos7Button.setClickable(false);
                            pos7Button.setEnabled(false);
                            c7 = true;
                        } else if (turno.getText().toString().equals("P 2's TURN")) {
                            Bitmap originalBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.x);
                            Bitmap resizedBitmap = Bitmap.createScaledBitmap(originalBitmap, WX, HX, false);
                            pos7Button.setImageBitmap(resizedBitmap);
                            pos7Button.setClickable(false);
                            pos7Button.setEnabled(false);
                            x7 = true;
                        }
                        verifica();

                    }
                    else {
                        cancel(view);
                        Toast.makeText(Gioco.this, selectedItem + " non ha giocato in entrambe le squadre ", Toast.LENGTH_SHORT).show();

                    }
                    changePlayer();
                    InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(pos9Button.getWindowToken(), 0);
                }

               else if (pos8 == true) {
                    String[] projection = {"nomep"};
                    String selection = "nomep = ? AND id_s IN (?, ?)";
                    String[] selectionArgs = new String[]{selectedItem, String.valueOf(numeroCasuale2), String.valueOf(numeroCasuale6)};
                    Cursor cursor = contentResolver.query(CONTENT_URI_2, projection, selection, selectionArgs, null);

                    if (cursor.getCount() >= 2){
                        cancel(view);
                        int firstCommaIndex = selectedItem.indexOf(' ');
                        String parteDopoSpazio = (firstCommaIndex != -1) ? selectedItem.substring(firstCommaIndex + 1) : selectedItem;

                        t8.setText(parteDopoSpazio);
                        if (turno.getText().toString().equals("P 1's TURN")){
                            Bitmap originalBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.cerchio);
                            Bitmap resizedBitmap = Bitmap.createScaledBitmap(originalBitmap, WC, HC, false);
                            pos8Button.setImageBitmap(resizedBitmap);
                            pos8Button.setClickable(false);
                            pos8Button.setEnabled(false);
                            c8 = true;
                        } else if (turno.getText().toString().equals("P 2's TURN")) {
                            Bitmap originalBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.x);
                            Bitmap resizedBitmap = Bitmap.createScaledBitmap(originalBitmap, WX, HX, false);
                            pos8Button.setImageBitmap(resizedBitmap);
                            pos8Button.setClickable(false);
                            pos8Button.setEnabled(false);
                            x8 = true;
                        }
                        verifica();

                    }
                    else {
                        cancel(view);
                        Toast.makeText(Gioco.this, selectedItem + " non ha giocato in entrambe le squadre ", Toast.LENGTH_SHORT).show();

                    }
                    changePlayer();
                    InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(pos9Button.getWindowToken(), 0);
                }

              else  if (pos9 == true) {
                    String[] projection = {"nomep"};
                    String selection = "nomep = ? AND id_s IN (?, ?)";
                    String[] selectionArgs = new String[]{selectedItem, String.valueOf(numeroCasuale3), String.valueOf(numeroCasuale6)};
                    Cursor cursor = contentResolver.query(CONTENT_URI_2, projection, selection, selectionArgs, null);

                    if (cursor.getCount() >= 2){
                        cancel(view);
                        int firstCommaIndex = selectedItem.indexOf(' ');
                        String parteDopoSpazio = (firstCommaIndex != -1) ? selectedItem.substring(firstCommaIndex + 1) : selectedItem;

                        t9.setText(parteDopoSpazio);
                        if (turno.getText().toString().equals("P 1's TURN")){
                            pos9Button.setClickable(false);
                            pos9Button.setEnabled(false);
                            Bitmap originalBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.cerchio);
                            Bitmap resizedBitmap = Bitmap.createScaledBitmap(originalBitmap, WC, HC, false);

                            // Imposta l'immagine nella ImageView
                            pos9Button.setImageBitmap(resizedBitmap);
                            c9 = true;

                        } else if (turno.getText().toString().equals("P 2's TURN")) {
                            Bitmap originalBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.x);
                            Bitmap resizedBitmap = Bitmap.createScaledBitmap(originalBitmap, WX, HX, false);
                            pos9Button.setImageBitmap(resizedBitmap);
                            pos9Button.setClickable(false);
                            pos9Button.setEnabled(false);
                            x9 = true;
                        }
                        verifica();

                    }
                    else {
                        cancel(view);
                        Toast.makeText(Gioco.this, selectedItem + " non ha giocato in entrambe le squadre ", Toast.LENGTH_SHORT).show();

                    }
                    changePlayer();
                    // Chiudi la tastiera
                    InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(pos9Button.getWindowToken(), 0);
                }
            }
        });


    }


    public void skip(View v) {
        if (skip.getText().equals("SKIP")) {
            skip.setText("SURE?");
        } else if (skip.getText().equals("SURE?")) {
            skip.setText("SKIP");
            changePlayer();
        }
    }

    public void pareggio(View v) {
        if (pareggio.getText().equals("END AS DRAW")) {
            pareggio.setText("ARE YOU SURE?");
        } else {
            recreate();
        }


    }

    public void searchPlayer(View v) {
        et.setText("");
        et.setHint("Search Player...");
        ly.setVisibility(View.VISIBLE);
    }

    public void cancel(View v) {
        ly.setVisibility(View.INVISIBLE);
        et.setText("");
        et.setHint("Search Player...");
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(et.getWindowToken(), 0);


    }


    //ZONA DATABASE



  /*  ArrayList<String> strArrayList  = new ArrayList<>();
    ArrayAdapter<String> adapter;
    adapter = new ArrayAdapter<String>(this,
    android.R.layout.simple_list_item_1, android.R.id.text1, strArrayList);
*/

    @Override
    protected void onResume() {
        super.onResume();
    }

    Uri CONTENT_URI = Uri.parse("content://com.example.tikitakaprof/ALL_PLAYERS");
    Uri CONTENT_URI_2 = Uri.parse("content://com.example.tikitakaprof/ALL_TEAMS");
    ArrayList<String> strArrayList = new ArrayList<>();



    public void GetTextFromSQL(View v) {
       // Cursor cursor = contentResolver.query(CONTENT_URI, null, null, null, null, null);
        String[] projection = {"COLUMN_NAME"};
        String selection = "id = ?";
        String[] selectionArgs = {"7"};

        Cursor cursor = contentResolver.query(CONTENT_URI, projection, selection, selectionArgs, null);

        if (cursor != null) {
            while (cursor.moveToNext()) {
                String str = cursor.getLong(0) + ", " + cursor.getString(1);
                strArrayList.add(str);
                et.setText(str);

            }
            cursor.close();
            }
        }

       public void changePlayer(){
            skip.setText("SKIP");
            if (turno.getText().equals("P 1's TURN")) {
                turno.setText("P 2's TURN");
                turno.setTextColor(Color.WHITE);
                turno.setBackground(new ColorDrawable(Color.parseColor("#0000FF")));
            } else if (turno.getText().equals("P 2's TURN")) {
                turno.setText("P 1's TURN");
                turno.setTextColor(Color.BLACK);
                turno.setBackground(new ColorDrawable(Color.parseColor("#FFFFFF")));
            }
        }

    public static int generaNumeroCasuale(int minimo, int massimo, Set<Integer> numeriGenerati, Random random) {
        int numeroCasuale;
        do {
            numeroCasuale = random.nextInt(massimo - minimo + 1) + minimo;
        } while (numeriGenerati.contains(numeroCasuale));

        numeriGenerati.add(numeroCasuale);
        return numeroCasuale;
    }

    public void verifica(){
        if (c1 == true && c2 == true && c3 == true){ vinto1();}
        if (c4 == true && c5 == true && c6 == true){ vinto1();}
        if (c7 == true && c8 == true && c9 == true){ vinto1();}
        if (c1 == true && c5 == true && c9 == true){ vinto1();}
        if (c3 == true && c5 == true && c7 == true){ vinto1();}
        if (c1 == true && c4 == true && c7 == true){ vinto1();}
        if (c2 == true && c5 == true && c8 == true){ vinto1();}
        if (c3 == true && c6 == true && c9 == true){ vinto1();}

        if (x1 == true && x2 == true && x3 == true){ vinto2();}
        if (x4 == true && x5 == true && x6 == true){ vinto2();}
        if (x7 == true && x8 == true && x9 == true){ vinto2();}
        if (x1 == true && x5 == true && x9 == true){ vinto2();}
        if (x3 == true && x5 == true && x7 == true){ vinto2();}
        if (x1 == true && x4 == true && x7 == true){ vinto2();}
        if (x2 == true && x5 == true && x8 == true){ vinto2();}
        if (x3 == true && x6 == true && x9 == true){ vinto2();}

    }

    public void vinto1() {
        PunteggioManager.incrementPunt1();
        updatePunteggio();

        Toast.makeText(Gioco.this, "P1 WON", Toast.LENGTH_SHORT).show();

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                recreate();
            }
        }, 3000);
    }

    /*public void vinto2(){
        punt2++;
        punteggio.setText("P1 " + punt1 + "-" + punt2 + " P2");
        Toast.makeText(MainActivity.this,  " P2 WON ", Toast.LENGTH_SHORT).show();
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                recreate();            }
        }, 3000);

    }*/
    public void vinto2() {
        PunteggioManager.incrementPunt2();
        updatePunteggio();

        Toast.makeText(Gioco.this, "P2 WON", Toast.LENGTH_SHORT).show();

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                recreate();
            }
        }, 3000);
    }

    private void updatePunteggio() {
        punteggio.setText("P1 " + PunteggioManager.getPunt1() + "-" + PunteggioManager.getPunt2() + " P2");
    }

    // Nell'onSaveInstanceState, puoi anche salvare i valori del punteggio
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(PUNT1_KEY, PunteggioManager.getPunt1());
        outState.putInt(PUNT2_KEY, PunteggioManager.getPunt2());
    }


    public void back(View v){
        Intent i = new Intent();
        i.setClass(this, MainActivity.class);
        startActivityForResult(i, 453);
    }





}

