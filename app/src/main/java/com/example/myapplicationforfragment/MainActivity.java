package com.example.myapplicationforfragment;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    public Button button_about;
    public Button button_calc;
    public Button button_rules;
    public LinearLayout buttonsOpen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button_about = (Button) findViewById((R.id.openAbout));
        button_calc = (Button) findViewById((R.id.openCalc));
        button_rules = (Button) findViewById((R.id.openRules));
        buttonsOpen = (LinearLayout) findViewById((R.id.buttons));


        CalcFragment calcFragment = (CalcFragment)getFragmentManager().findFragmentById(R.id.calcFragment);
        AboutFragment aboutFragment = (AboutFragment)getFragmentManager().findFragmentById(R.id.aboutFragment);
        RulesFragment rulesFragment = (RulesFragment)getFragmentManager().findFragmentById(R.id.rulesFragment);

        calcFragment.getView().setVisibility(View.GONE);
        aboutFragment.getView().setVisibility(View.GONE);
        rulesFragment.getView().setVisibility(View.GONE);

    }

    public void openCalc(View view) {
        CalcFragment mapFragment = (CalcFragment)getFragmentManager().findFragmentById(R.id.calcFragment);
        mapFragment.getView().setVisibility(View.VISIBLE);
        buttonsOpen.setVisibility(View.GONE);
    }

    public void openAbout(View view) {
        AboutFragment mapFragment = (AboutFragment)getFragmentManager().findFragmentById(R.id.aboutFragment);
        mapFragment.getView().setVisibility(View.VISIBLE);
        buttonsOpen.setVisibility(View.GONE);
    }

    public void closeButton(View view) {

        AboutFragment aboutFragment = (AboutFragment)getFragmentManager().findFragmentById(R.id.aboutFragment);
                aboutFragment.getView().setVisibility(View.GONE);
        CalcFragment calcFragment = (CalcFragment)getFragmentManager().findFragmentById(R.id.calcFragment);
        calcFragment.getView().setVisibility(View.GONE);
        RulesFragment rulesF = (RulesFragment)getFragmentManager().findFragmentById(R.id.rulesFragment);
        rulesF.getView().setVisibility(View.GONE);
        buttonsOpen.setVisibility(View.VISIBLE);
    }

    public void closeButtonCalc(View view) {
        CalcFragment calcFragment = (CalcFragment)getFragmentManager().findFragmentById(R.id.calcFragment);
        calcFragment.getView().setVisibility(View.GONE);
        buttonsOpen.setVisibility(View.VISIBLE);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch(id){
            case R.id.set_about :
                AboutFragment mapFragment = (AboutFragment)getFragmentManager().findFragmentById(R.id.aboutFragment);
                mapFragment.getView().setVisibility(View.VISIBLE);
                buttonsOpen.setVisibility(View.GONE);
                return true;
            case R.id.set_calc:
                CalcFragment calc = (CalcFragment)getFragmentManager().findFragmentById(R.id.calcFragment);
                calc.getView().setVisibility(View.VISIBLE);
                buttonsOpen.setVisibility(View.GONE);
                return true;
            case R.id.set_rules:
                RulesFragment r = (RulesFragment)getFragmentManager().findFragmentById(R.id.rulesFragment);
                r.getView().setVisibility(View.VISIBLE);
                buttonsOpen.setVisibility(View.GONE);
                return true;
            case R.id.set_share:
                CalcFragment calcul = (CalcFragment)getFragmentManager().findFragmentById(R.id.calcFragment);
                if (calcul.isResumed()) {
                    Intent myIntent = new Intent(Intent.ACTION_SEND);
                    myIntent.setType("text/plain");
                    String shareBody = "My result is: " + calcul.resultField.getText();
                    myIntent.putExtra(Intent.EXTRA_SUBJECT, shareBody);
                    myIntent.putExtra(Intent.EXTRA_TEXT, shareBody);
                    startActivity(Intent.createChooser(myIntent, "Share using"));
                    return true;
                }
                else{
                    return true;
                }

        }
        return super.onOptionsItemSelected(item);
    }

    public void openRules(View view) {
        RulesFragment rules = (RulesFragment)getFragmentManager().findFragmentById(R.id.rulesFragment);
        rules.getView().setVisibility(View.VISIBLE);
        buttonsOpen.setVisibility(View.GONE);
    }
}