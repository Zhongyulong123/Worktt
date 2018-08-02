package com.example.drawerlayout;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
private ListView listView;
private DrawerLayout drawerLayout;
private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    listView = findViewById(R.id.listview);
    drawerLayout = findViewById(R.id.drawer_layout);
    textView = findViewById(R.id.t1);

   listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
           Toast.makeText(MainActivity.this,"点击侧拉",Toast.LENGTH_LONG).show();
           textView.setText("阿斯顿权威");
           drawerLayout.closeDrawers();
       }
   });
    textView.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            drawerLayout.openDrawer(GravityCompat.START);
        }
    });
    }
}
