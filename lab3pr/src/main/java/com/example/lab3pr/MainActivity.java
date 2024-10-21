package com.example.lab3pr;

import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;


import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener, View.OnClickListener {
    final int[] counter = {0};
    private boolean isSecretChecked = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        CheckBox secretCheckBox = findViewById(R.id.checkBox);

        Button button1 = (Button)findViewById(R.id.button);
        Button button2 = (Button)findViewById(R.id.button2);
        registerForContextMenu(button1);
        registerForContextMenu(button2);

        TextView TL = (TextView)findViewById(R.id.TextView1);

        TL.setText(getResources().getString(R.string.textForTV, counter[0]));


        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        secretCheckBox.setOnCheckedChangeListener(this);

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.main_menu, menu);


        MenuItem secretItem = menu.findItem(R.id.action_secret);
        secretItem.setVisible(isSecretChecked);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.about) {

            Intent intent = new Intent(MainActivity.this, ActivityAbout.class);
            startActivity(intent);
            return true;
        } else if (id == R.id.About_author) {

            Intent intent = new Intent(MainActivity.this, ActivityAboutAuthor.class);
            startActivity(intent);
            return true;
        } else if (id == R.id.exit) {
            finish();

        } else if (id == R.id.action_secret) {

            Intent intent = new Intent(MainActivity.this, SecretActivity.class);
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    @Override
    public void onClick(View v) {

        Button button2 = (Button)findViewById(R.id.button2);
        TextView TL = (TextView)findViewById(R.id.TextView1);
        int id = v.getId();
        if (id == R.id.button) {
            ConstraintLayout.LayoutParams params = (ConstraintLayout.LayoutParams)button2.getLayoutParams();
            // dp to px
            if (params.topMargin<500) {
                params.topMargin = params.topMargin + Math.round(20 * getResources().getDisplayMetrics().density);
            }

            Toast.makeText(this, getResources().getString(R.string.toastMessageButton1), Toast.LENGTH_SHORT).show();
            TL.setText(getResources().getString(R.string.textForTV, ++counter[0]));
            button2.setLayoutParams(params);
        } else if (id == R.id.button2) {
            ConstraintLayout.LayoutParams params = (ConstraintLayout.LayoutParams)button2.getLayoutParams();

            // dp to px
            params.topMargin = Math.round(10 * getResources().getDisplayMetrics().density);

            Toast.makeText(this, getResources().getString(R.string.toastMessageButton2), Toast.LENGTH_SHORT).show();
            counter[0] = 0;
            TL.setText(getResources().getString(R.string.textForTV, counter[0]));
            button2.setLayoutParams(params);
        }
    }
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.context_menu, menu);
    }
    @Override
    public boolean onContextItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.item_about) {

            Intent intent = new Intent(MainActivity.this, ActivityAbout.class);
            startActivity(intent);
            return true;

        }

                return super.onContextItemSelected(item);
        }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
            isSecretChecked = b;
            invalidateOptionsMenu();
    }
}

