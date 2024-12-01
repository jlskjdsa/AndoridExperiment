package com.example.experiment3;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MenuActivity extends AppCompatActivity {


    TextView text;
    @SuppressLint("ResourceType")
    @Override
    public void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        text = findViewById(R.id.textView);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = new MenuInflater(this);
        menuInflater.inflate(R.menu.menus,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId()==R.id.font_small){
            text.setTextSize(10);
        }
        if (menuItem.getItemId()==R.id.font_medium){
            text.setTextSize(16);
        }
        if (menuItem.getItemId()==R.id.font_large){
            text.setTextSize(20);
        }
        if (menuItem.getItemId()==R.id.color_black){
            text.setTextColor(getResources().getColor(android.R.color.black));
        }
        if (menuItem.getItemId()==R.id.color_red){
            text.setTextColor(getResources().getColor(android.R.color.holo_red_light));
        }
        return super.onOptionsItemSelected(menuItem);
    }
}
