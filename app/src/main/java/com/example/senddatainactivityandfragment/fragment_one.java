package com.example.senddatainactivityandfragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import java.util.Objects;


public class fragment_one extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull final LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_one_layout, container, false);

        final EditText Edit_text_one = v.findViewById(R.id.Edit_text_one);
        Button btn_one = v.findViewById(R.id.btn_one);

//        String str = getArguments().getString("dataFromActivityOne");
//        editText.setText(str);

        Edit_text_one.setText(getArguments().getString("dataFromActivityOne"));


        btn_one.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceType")
            @Override
            public void onClick(View v) {
                Bundle bundle =new Bundle();
                bundle.putString("dataFormEditTextOne",Edit_text_one.getText().toString());



                fragment_two fragmentTwo =  new fragment_two();
                fragmentTwo.setArguments(bundle);




                FragmentManager fragmentManager = Objects.requireNonNull(getActivity()).getSupportFragmentManager();
                FragmentTransaction fragmentTransaction =  fragmentManager.beginTransaction();
                fragmentTransaction.add(R.id.frag_two_linear_layout,fragmentTwo);

                fragmentTransaction.commit();


            }
        });


        return v;
    }
}
