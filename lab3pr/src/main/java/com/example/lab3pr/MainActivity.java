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

public class MainActivity extends AppCompatActivity {

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
        final int[] counter = {0};
        TL.setText(getResources().getString(R.string.textForTV, counter[0]));

        View.OnClickListener listener = v -> {
            int id = v.getId();
            if (id == R.id.button)
            {
                ConstraintLayout.LayoutParams params = (ConstraintLayout.LayoutParams)button2.getLayoutParams();

                // dp to px
                if (params.topMargin<500) {
                    params.topMargin = params.topMargin + Math.round(20 * getResources().getDisplayMetrics().density);
                }

                TL.setText(getResources().getString(R.string.textForTV, ++counter[0]));
                button2.setLayoutParams(params);

            } else if (id == R.id.button2) {

                ConstraintLayout.LayoutParams params = (ConstraintLayout.LayoutParams)button2.getLayoutParams();

                // dp to px
                    params.topMargin = Math.round(10 * getResources().getDisplayMetrics().density);
                    counter[0]=0;
                TL.setText(getResources().getString(R.string.textForTV, counter[0]));
                button2.setLayoutParams(params);
            }

        };
        button1.setOnClickListener(listener);
        button2.setOnClickListener(listener);


    }
}