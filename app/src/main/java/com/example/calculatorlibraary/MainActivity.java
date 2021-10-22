package com.example.calculatorlibraary;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.calculatorlibraary.databinding.ActivityMainBinding;


public class MainActivity extends AppCompatActivity {

    CalciPresenter calciPresenter;
    TextView input, output;
    Button equal, reset, back;
    String data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActivityMainBinding binding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        calciPresenter =new CalciPresenter();
        binding.setViewModel(calciPresenter);

        input = (TextView) findViewById(R.id.textViewinput);
        output = (TextView) findViewById(R.id.textViewoutput);
        reset=findViewById(R.id.buttonce);
        back=findViewById(R.id.buttonc);
        equal=findViewById(R.id.buttonequal);

        calciPresenter.inputResult.observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                output.setText("");
                input.setText(s);
            }
        });

        calciPresenter.outputResult.observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                output.setText(s);
            }
        });

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data = input.getText().toString();
                input.setText("");
                output.setText("");

            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data = input.getText().toString();
                input.setText(data.substring(0, data.length() - 1));
                output.setText("");
            }
        });


        equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data = input.getText().toString();
                calciPresenter.onequals(data);
            }
        });
    }

}
