package com.androidlokomedia.sharepreferencedemo;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Toolbar toolbar;
    Button btnMerah;
    Button btnKuning;
    Button btnHijau;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        btnHijau = (Button) findViewById(R.id.buttonHijau);
        btnKuning = (Button) findViewById(R.id.buttonKuning);
        btnMerah = (Button) findViewById(R.id.buttonMerah);

        btnHijau.setOnClickListener(this);
        btnKuning.setOnClickListener(this);
        btnMerah.setOnClickListener(this);

        if (ambilColor() != R.color.colorPrimary){
            toolbar.setBackgroundColor(ambilColor());
            getWindow().setStatusBarColor(ambilColor());
        }

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.buttonHijau:
                toolbar.setBackgroundColor(getResources().getColor(R.color.colorHijau));
                getWindow().setStatusBarColor(getResources().getColor(R.color.colorHijau));
                simpanWarna(getResources().getColor(R.color.colorHijau));
                break;
            case R.id.buttonKuning:
                toolbar.setBackgroundColor(getResources().getColor(R.color.colorKuning));
                getWindow().setStatusBarColor(getResources().getColor(R.color.colorKuning));
                simpanWarna(getResources().getColor(R.color.colorKuning));
                break;
            case R.id.buttonMerah:
                toolbar.setBackgroundColor(getResources().getColor(R.color.colorAccent));
                getWindow().setStatusBarColor(getResources().getColor(R.color.colorAccent));
                simpanWarna(getResources().getColor(R.color.colorAccent));
                break;
        }
    }

    private void simpanWarna(int color){
        SharedPreferences mSharedPreferences = getSharedPreferences("ToolbarColor",MODE_PRIVATE);
        SharedPreferences.Editor editor = mSharedPreferences.edit();
        editor.putInt("color", color);
        editor.apply();
    }

    private int ambilColor(){
        SharedPreferences mSharedPreferences = getSharedPreferences("ToolbarColor",MODE_PRIVATE);
        int selectedColor = mSharedPreferences.getInt("color", getResources().getColor(R.color.colorPrimary));
        return selectedColor;
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

}
