package com.example.myapplicationforfragment;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.view.View;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;

import android.app.Fragment;

public class CalcFragment extends Fragment implements View.OnClickListener {


    EditText numberField;
    String operation = "";
    EditText resultField;
    @SuppressLint("UseSwitchCompatOrMaterialCode")
    Switch simpleSwitch;
    LinearLayout layout;
    GridLayout Gridlayout;
    Button nano;
    Button micro;
    Button sec;
    Button min;
    Button hour;
    Button doba;
    Button week;
    Button year;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.calc_fragment, container, false);
        numberField = (EditText) view.findViewById(R.id.numberField);
        resultField = (EditText) view.findViewById(R.id.resultField);
        simpleSwitch = (Switch) view.findViewById(R.id.simpleSwitch);
        layout = (LinearLayout) view.findViewById(R.id.activity_second);
        Gridlayout = (GridLayout) view.findViewById(R.id.grid);
        simpleSwitch.setTextOn("dark mode"); // displayed text of the Switch whenever it is in checked or on state
        simpleSwitch.setTextOff("light mode");
        simpleSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    layout.setBackgroundColor(Color.BLACK);
                    Gridlayout.setBackgroundColor(Color.BLACK);
                }
                else {
                    layout.setBackgroundColor(Color.WHITE);
                    Gridlayout.setBackgroundColor(Color.WHITE);
                }
            }
        });

        nano =  (Button)view.findViewById(R.id.nano);
        nano.setOnClickListener((View.OnClickListener) this);
        micro =  (Button)view.findViewById(R.id.micro);
        micro.setOnClickListener((View.OnClickListener) this);
        sec =  (Button)view.findViewById(R.id.sec);
        sec.setOnClickListener((View.OnClickListener) this);
        min =  (Button)view.findViewById(R.id.min);
        min.setOnClickListener((View.OnClickListener) this);
        hour =  (Button)view.findViewById(R.id.hour);
        hour.setOnClickListener((View.OnClickListener) this);
        doba =  (Button)view.findViewById(R.id.doba);
        doba.setOnClickListener((View.OnClickListener) this);
        week =  (Button)view.findViewById(R.id.week);
        week.setOnClickListener((View.OnClickListener) this);
        year =  (Button)view.findViewById(R.id.year);
        year.setOnClickListener((View.OnClickListener) this);
        return view;
    }

    @Override
    public void onClick(View v)
    {
        onOperationClick(v);
    }

    public void onOperationClick(View view){

        Button button = (Button)view;
        String op = button.getText().toString();
        String number = numberField.getText().toString();
        if(number.length()>0){
            try{
                performOperation(Double.valueOf(number), op);
            }catch (NumberFormatException ex){
                numberField.setText("");
            }
        }
        operation = op;
    }

    @SuppressLint("SetTextI18n")
    private void performOperation(Double number, String operation){

        switch(operation){

            case "в наносекунди":
                number *= 1000000000;
                break;
            case "в мікросекунди":
                number *= 1000000;
                break;
            case "в секунди":
                break;
            case "в хвилини":
                number /= 60;
                break;
            case "в години":
                number /= 3600;
                break;
            case "в добу":
                number /= 86400;
                break;
            case "в неділю":
                number /= 604800;
                break;
            case "в рік":
                number /= 31536000;
                break;
        }

        resultField.setText(number.toString());
    }
}