package com.example.nzse_bmi_1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText height;
    EditText weight;
    TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        height = findViewById(R.id.height_input);
        weight = findViewById(R.id.weight_input);
        result = findViewById(R.id.textView);
    }

    public void onButtonClick(View view) {
        double height_bmi = 0;
        double weight_bmi = 0;
        try {
            height_bmi = Double.parseDouble(height.getText().toString());
            weight_bmi = Double.parseDouble(weight.getText().toString());
        } catch (NumberFormatException nfe) {
            System.out.println("This is not a number");
            System.out.println(nfe.getMessage());
        }
        if (height_bmi == Math.floor(height_bmi)) {
            double correct_height = height_bmi / 100;
            double bmi_c = weight_bmi / (correct_height * correct_height);
            result.setText(Double.toString(bmi_c));
        } else {
            double bmi = weight_bmi / (height_bmi * height_bmi);
            result.setText(Double.toString(bmi));
        }
    }
}
