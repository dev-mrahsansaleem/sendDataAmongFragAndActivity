package com.example.senddatainactivityandfragment;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnClickME = findViewById(R.id.btnClickMe);

        btnClickME.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText text = (EditText)findViewById(R.id.inputText);
                Intent intent=new Intent(getBaseContext(),Main2Activity.class);
                intent.putExtra("dataFromActivityOne",text.getText().toString());

                startActivityForResult(intent,100);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==100)
        {
            if(resultCode==RESULT_OK)
            {
                TextView textView = findViewById(R.id.viewText);
                textView.setText(data.getStringExtra("data"));
            }
        }
    }
}
