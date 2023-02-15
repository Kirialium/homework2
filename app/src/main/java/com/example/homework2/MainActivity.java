package com.example.homework2;

import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    private EditText typeSum;
    private Button btnOk;
    private TextView upText;

    private int money;
    private final int telescopeCost = 14000;
    private final float bet = 1.05f;
    private final float scholarship = 2500 * bet;
    private float time = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Objects.requireNonNull(this.getSupportActionBar()).hide();

        fillVariables();
        setSystemBarsColor();



        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(TextUtils.isEmpty(typeSum.getText().toString())) {
                    Toast.makeText(getApplicationContext(), "Введите сумму", Toast.LENGTH_SHORT).show();
                }
                else {
                    money = Integer.parseInt(typeSum.getText().toString());
                    calculateTime();
                    variantsToBuy();
                }
            }
        });
    }


    private void fillVariables(){
        typeSum = findViewById(R.id.type_sum);
        btnOk = findViewById(R.id.btn_ok);
        upText = findViewById(R.id.up_text);
    }


    public void setSystemBarsColor() {
        Window window = this.getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.setStatusBarColor(this.getResources().getColor(R.color.dark_black));
        getWindow().setNavigationBarColor(getResources().getColor(R.color.dark_black));
    }

    private void calculateTime(){
        time = (telescopeCost - money) / scholarship;
    }

    @SuppressLint("SetTextI18n")
    private void variantsToBuy(){
        if(money >= telescopeCost){
            upText.setText("Купиете хоть сейчас");
        }
        else {
            @SuppressLint("DefaultLocale")
            String timeString = String.format("%.01f",time);
            upText.setText("Вы купите через " + timeString +" месяцев");
        }
    }
}