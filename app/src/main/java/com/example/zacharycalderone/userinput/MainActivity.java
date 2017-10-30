package com.example.zacharycalderone.userinput;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    double mealCost, tip, percentage, total;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText cost = (EditText)findViewById(R.id.mealCost);
        final Spinner group = (Spinner)findViewById(R.id.percentChoice);
        final Button charges = (Button)findViewById(R.id.button);
        charges.setOnClickListener(new View.OnClickListener() {
            final TextView result = ((TextView)findViewById(R.id.result));

            @Override
            public void onClick(View view) {
                mealCost = Double.parseDouble(cost.getText().toString());
                DecimalFormat currency = new DecimalFormat("$###,###.##");
                percentage = Integer.parseInt(group.getSelectedItem().toString());
                tip = mealCost * (percentage/100);
                result.setText(currency.format(tip));
//                result.setText("" + tip);

            }
        });
    }
}
