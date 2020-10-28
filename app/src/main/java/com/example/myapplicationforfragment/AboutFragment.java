package com.example.myapplicationforfragment;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.LinearLayout;
import android.widget.Switch;

import android.app.Fragment;

public class AboutFragment extends Fragment {

    Button closeButton;
    Button button_about;
    Button button_calc;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        final View view = inflater.inflate(R.layout.about_fragment, container, false);


//        closeButton =  (Button)view.findViewById(R.id.closeButton);
//        MainActivity activityInstance = (MainActivity) getActivity();
//
//        button_about = (Button)activityInstance.findViewById(R.id.openAbout);

//        button_calc = (Button) view.findViewById((R.id.openCalc));



//        closeButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                AboutFragment aboutFragment = (AboutFragment)getFragmentManager().findFragmentById(R.id.aboutFragment);
//                aboutFragment.getView().setVisibility(View.GONE);
//                button_about.setVisibility(View.VISIBLE);
////                button_calc.setVisibility(View.VISIBLE);
//            }
//        });
        return view;
        };
}

