package com.example.lab3pr;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    final int[] counter = {0};

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


        Button button1 = (Button)findViewById(R.id.button);
        Button button2 = (Button)findViewById(R.id.button2);
        TextView TL = (TextView)findViewById(R.id.TextView1);

        TL.setText(getResources().getString(R.string.textForTV, counter[0]));


        button1.setOnClickListener(this);
        button2.setOnClickListener(this);


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
}
