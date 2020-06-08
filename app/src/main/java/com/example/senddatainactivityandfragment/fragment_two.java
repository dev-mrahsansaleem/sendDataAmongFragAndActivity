package com.example.senddatainactivityandfragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;


public class fragment_two extends Fragment {
    public interface OnDataPass {
        public void onDataPass(String data);
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_two_layout, container, false);

        final EditText Edit_text_two = v.findViewById(R.id.Edit_text_two);
        Button btn_two = v.findViewById(R.id.btn_two);


        Edit_text_two.setText(getArguments().getString("dataFormEditTextOne"));


        btn_two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getContext(),MainActivity.class);

                dataPasser.onDataPass(Edit_text_two.getText().toString());

            }

        });
        return v;
    }
    OnDataPass dataPasser;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        dataPasser = (OnDataPass) context;
    }
}
