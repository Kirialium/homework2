package com.example.homework2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    private EditText typeSum;
    private Button btnOk;
    private int money;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Objects.requireNonNull(this.getSupportActionBar()).hide();

        fillVariables();
        setSystemBarsColor();

        final int telescopeCost = 14000;
        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                money = Integer.parseInt(typeSum.getText().toString());
            }
        });
    }


    private void fillVariables(){
        typeSum = findViewById(R.id.type_sum);
        btnOk = findViewById(R.id.btn_ok);
    }


    public void setSystemBarsColor() {
        Window window = this.getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.setStatusBarColor(this.getResources().getColor(R.color.dark_black));
        getWindow().setNavigationBarColor(getResources().getColor(R.color.dark_black));
    }


}