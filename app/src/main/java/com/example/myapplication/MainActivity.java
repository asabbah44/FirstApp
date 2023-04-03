package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

/**
 * This is the main activity class which is called
 */
public class MainActivity extends AppCompatActivity {

    private Button button;
    private Button btn_show_input;
    private EditText et_user_input;
    private int counter = 0;
    private TextView Ltxt_MyInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button1);
        btn_show_input = findViewById(R.id.btn_show_input);
        et_user_input = findViewById(R.id.et_user_input);
        Ltxt_MyInput=findViewById(R.id.txt_MyInput);

        button.setOnClickListener(onClickListener);

        btn_show_input.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userInput = et_user_input.getText().toString();
                if(userInput.trim().isEmpty()){
                    Toast.makeText(MainActivity.this, "Please enter a value!", Toast.LENGTH_LONG).show();
                }else {
                    Toast.makeText(MainActivity.this, et_user_input.getText(), Toast.LENGTH_SHORT).show();
                    Ltxt_MyInput.setText(et_user_input.getText());

                }
            }
        });

    }

    private View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Toast.makeText(MainActivity.this, "Hello Students!", Toast.LENGTH_LONG).show();
            button.setText(getText(R.string.click_me) + " " + ++counter);
        }
    };

    public void Next(View view) {
        Button btnNext= (Button) view;
        Intent nextActivity=new Intent(MainActivity.this,SecondActivity.class);
        nextActivity.putExtra("Data",Ltxt_MyInput.getText().toString());
        MainActivity.this.startActivity(nextActivity);


    }
}