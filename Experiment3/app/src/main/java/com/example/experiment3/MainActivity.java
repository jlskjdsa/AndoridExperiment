package com.example.experiment3;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {


    private String[] names =  new String[]{"Lion","Tiger","Monkey","Dog","Cat","Elephant"};
    private int[] imageIds = new int[]{R.drawable.lion,R.drawable.tiger,R.drawable.monkey,R.drawable.dog,R.drawable.cat,R.drawable.elephant};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.select_buttons);
        Button button1 = findViewById(R.id.button);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setContentView(R.layout.activity_main);
                List<Map<String,Object>> listItems = new ArrayList<>();
                for (int i=0;i<names.length;i++){
                    Map<String,Object> listItem = new HashMap<>();
                    listItem.put("Name",names[i]);
                    listItem.put("Image",imageIds[i]);
                    listItems.add(listItem);
                }
                SimpleAdapter simpleAdapter = new SimpleAdapter(MainActivity.this,listItems,R.layout.list_item,new String[]{"Name","Image"},new int[]{R.id.head,R.id.image});
                ListView listView = findViewById(R.id.mylist);
                listView.setAdapter(simpleAdapter);

                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        String selectItem = names[i];
                        Toast.makeText(MainActivity.this,selectItem,Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

        Button button2 = findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ConstraintLayout login = (ConstraintLayout) getLayoutInflater().inflate(R.layout.login,null);
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("Android APP")
                        .setView(login)
                        .create().show();
            }
        });

        //点击按钮跳转选项菜单实现界面
        Button button3 = findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MenuActivity.class);
                startActivity(intent);
 //               setContentView(R.layout.activity_menu);
            }
        });

        //点击按钮跳转选项菜单实现界面
        Button button4 = findViewById(R.id.button4);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ContextMenuActivity.class);
                startActivity(intent);
                //               setContentView(R.layout.activity_menu);
            }
        });
    }

}