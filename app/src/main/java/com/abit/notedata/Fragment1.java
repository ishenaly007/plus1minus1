package com.abit.notedata;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


public class Fragment1 extends Fragment {
    TextView num;
    Button plus, minus;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_1, container, false);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        num = requireActivity().findViewById(R.id.tv_num);
        plus = requireActivity().findViewById(R.id.btn_plus);
        minus = requireActivity().findViewById(R.id.btn_minus);
        plus.setOnClickListener(view1 -> {
            if (!num.getText().toString().equals("20")){
                num.setText(Integer.toString(Integer.parseInt(num.getText().toString()) + 1));
            }else {
                requireActivity().getSupportFragmentManager()
                        .beginTransaction().replace(R.id.container,new Fragment2())
                        .commit();
            }
        });
        minus.setOnClickListener(view1 -> {
            if (!num.getText().toString().equals("20")){
                num.setText(Integer.toString(Integer.parseInt(num.getText().toString()) - 1));
            }else {
                requireActivity().getSupportFragmentManager()
                        .beginTransaction().replace(R.id.container,new Fragment2())
                        .commit();
            }

        });
    }
}
