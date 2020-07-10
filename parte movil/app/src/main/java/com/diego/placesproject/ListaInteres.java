package com.diego.placesproject;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.SparseBooleanArray;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.jar.JarException;


import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ListaInteres extends AppCompatActivity {

    ListView myList;
    Button getChoice, clearAll, addPlace;
    SharedPreferences sharedpreferences;
    public static final String MyPREFERENCES = "MyChoice" ;
    ArrayList<String> selectedItems = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_interes);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        myList = (ListView)findViewById(R.id.list);
        getChoice = (Button)findViewById(R.id.getchoice);
        clearAll = (Button)findViewById(R.id.clearall);
        addPlace = (Button)findViewById(R.id.agregarL);
        ArrayAdapter <String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_multiple_choice, getResources().getStringArray(R.array.Indian_States));
        myList.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        myList.setAdapter(adapter);
        sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);


        if(sharedpreferences.contains(MyPREFERENCES)){
            LoadSelections();
        }
        getChoice.setOnClickListener(new Button.OnClickListener(){

            @Override
            public void onClick(View v) {

                String selected = "";
                int cntChoice = myList.getCount();

                SparseBooleanArray sparseBooleanArray = myList.getCheckedItemPositions();
                for(int i = 0; i < cntChoice; i++){
                    if(sparseBooleanArray.get(i)) {
                        selected += myList.getItemAtPosition(i).toString() + "\n";
                        System.out.println("Checking list while adding:" + myList.getItemAtPosition(i).toString());
                        SaveSelections();

                    }

                }

                Toast.makeText(ListaInteres.this, selected, Toast.LENGTH_LONG).show();

            }});

      clearAll.setOnClickListener(new View.OnClickListener() {

        @Override
        public void onClick(View v) {
// TODO Auto-generated method stub
            ClearSelections();
        }
    });


      addPlace.setOnClickListener(v){
          ejecutarServicio("http://67.205.173.0/sugerirLugar.php");
        };
    }

    private void ejecutarServicio(String URL){
        StringRequest stringRequest= new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast.makeText(getApplicationContext(), "Ubicacion sugerida", Toast.LENGTH_SHORT).show();
            }

        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(),error.toString(),Toast.LENGTH_SHORT).show();
            }
        }){
            protected Map<String,String> getParams() throws AuthFailureError{
                Map<String,String> parametros = new HashMap<String,String>();
                parametros.put("localizacion",mFusedLocationProviderClient.getLastLocation());
                return parametros;
            }
        };
        RequestQueue requestQueue= Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }

    private void SaveSelections() {
// save the selections in the shared preference in private mode for the user

        SharedPreferences.Editor prefEditor = sharedpreferences.edit();
        String savedItems = getSavedItems();
        prefEditor.putString(MyPREFERENCES.toString(), savedItems);
        prefEditor.commit();
    }

    private String getSavedItems() {
        String savedItems = "";
        int count = this.myList.getAdapter().getCount();
        for (int i = 0; i < count; i++) {
            if (this.myList.isItemChecked(i)) {
                if (savedItems.length() > 0) {
                    savedItems += "," + this.myList.getItemAtPosition(i);
                } else {
                    savedItems += this.myList.getItemAtPosition(i);
                }
            }
        }
        return savedItems;
    }
        private void LoadSelections() {
// if the selections were previously saved load them

            if (sharedpreferences.contains(MyPREFERENCES.toString())) {
                
                int count = this.myList.getAdapter().getCount();

                for (int i = 0; i < count; i++) {
                    String currentItem = (String) myList.getAdapter()
                            .getItem(i);
                    if (selectedItems.contains(currentItem)) {
                        myList.setItemChecked(i, true);
                        Toast.makeText(getApplicationContext(),
                                "Curren Item: " + currentItem,
                                Toast.LENGTH_LONG).show();
                    } else {
                        myList.setItemChecked(i, false);
                    }

                }
            }
        }

        private void ClearSelections() {
// user has clicked clear button so uncheck all the items
            int count = this.myList.getAdapter().getCount();
            for (int i = 0; i < count; i++) {
                this.myList.setItemChecked(i, false);
            }
// also clear the saved selections
            SaveSelections();
        }
        private void obtenerLista(String URL){
            JsonArrayRequest jsonArrayRequest= new JsonArrayRequest(URL, new Response.Listener<JSONArray>() {
                @Override
                public void onResponse(JSONArray response) {
                    JSONObject jsonObject=null;
                    for(int i = 0; i<response.length();i++){
                        try{
                            jsonObject=response.getJSONObject(i);
                            String savedItems = sharedpreferences.getString(MyPREFERENCES.toString(), "");
                            selectedItems.addAll(Arrays.asList(savedItems.split(",")));

                    }catch (JSONException e ){
                        Toast.makeText(getApplicationContext(),e.getMessage(),Toast.LENGTH_SHORT).show();
                        }
                    }
                }
            })
        }

    }


















