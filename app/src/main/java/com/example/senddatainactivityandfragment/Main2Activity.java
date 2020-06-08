package com.example.senddatainactivityandfragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity  implements fragment_two.OnDataPass {

    Bundle bundle = new Bundle();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        Intent intent = getIntent();
//        str = intent.getStringExtra("dataFromActivityOne");
//        bundle.putString("dataFromActivityOne", str);


        bundle.putString("dataFromActivityOne",  intent.getStringExtra("dataFromActivityOne"));

        fragment_one fragment_one = new fragment_one();

        fragment_one.setArguments(bundle);

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.add(R.id.frag_one_linear_layout, fragment_one).commit();
    }
    @Override
    public void onDataPass(String data) {
        Toast.makeText(this, data, Toast.LENGTH_SHORT).show();
        Intent intent=new Intent();
        intent.putExtra("data",data);
        setResult(RESULT_OK,intent);
        finish();
    }
}
