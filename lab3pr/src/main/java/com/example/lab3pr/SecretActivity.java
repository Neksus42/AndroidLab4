package com.example.lab3pr;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class SecretActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.secretactivity);
        Toolbar toolbar = findViewById(R.id.toolbar4);
        setSupportActionBar(toolbar);

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuItem getback = menu.add(0, 1, 0, "Вернуться");
        MenuItem exit = menu.add(0, 2, 1, "Выйти");


        getback.setShowAsAction(MenuItem.SHOW_AS_ACTION_NEVER);
        exit.setShowAsAction(MenuItem.SHOW_AS_ACTION_NEVER);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == 1) {
            Intent intent = new Intent(SecretActivity.this, MainActivity.class);
            startActivity(intent);
            return true;

        } else if (id == 2) {
            finish();

        }

        return super.onOptionsItemSelected(item);
    }
}
