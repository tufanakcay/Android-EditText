package com.tufanakcay.androidedittext;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText m_editText;
    TextView m_textView;
    Button m_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
        btnClick();

    }

    private void init() {
        m_editText = findViewById(R.id.editText);
        m_button = findViewById(R.id.calculate_btn);
        m_textView = findViewById(R.id.result_tv);
    }

    private void btnClick() {
        m_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String m_str = m_editText.getText().toString();
                
                if(m_str.length() <= 0 || m_str.matches("")){
                    Toast.makeText(MainActivity.this, "Please enter number", Toast.LENGTH_SHORT).show();
                } else{

                    int m_num = Integer.parseInt(m_str);


                    int cal_num = calculate(m_num);
                    m_textView.setText("Result : " + cal_num); 
                    
                }

            }
        });

    }


    private int calculate(int num) {

        int result = 1;

        for (int i = num; i > 1; i--) {

            result = result * i;
        }

        return result;

    }
}