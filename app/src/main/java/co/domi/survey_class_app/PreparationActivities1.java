package co.domi.survey_class_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

public class PreparationActivities1 extends AppCompatActivity{

    private CheckBox cb1UI;
    private CheckBox cb2UI;
    private CheckBox cb3UI;
    private Button continueBtnUI;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preparation_activities1);

        cb1UI = findViewById(R.id.actPrepCB1);
        cb2UI = findViewById(R.id.actPrepCB2);
        cb3UI = findViewById(R.id.actPrepCB3);
        continueBtnUI = findViewById(R.id.continuePABTN);

        continueBtnUI.setClickable(false);

        cb1UI.setOnClickListener(
                (view) -> {
                    manageCheckBoxInteraction();
                }
        );

        cb2UI.setOnClickListener(
                (view) -> {
                    manageCheckBoxInteraction();
                }
        );

        cb3UI.setOnClickListener(
                (view) -> {
                    manageCheckBoxInteraction();
                }
        );

        continueBtnUI.setOnClickListener(
                (view) -> {
                    int score = 0;
                    if(cb1UI.isChecked()){
                        score+=1;
                    }
                    if(cb2UI.isChecked()){
                        score+=3;
                    }
                    SharedPreferences info = getSharedPreferences("studentsList",MODE_PRIVATE);
                    info.edit().putString("listScores", score + ";").apply();
                    Intent ending = new Intent(this, selfEvaluationActivity.class);
                    finish();
                    startActivity(ending);
                }
        );
        //1:47:50
    }

    public void manageCheckBoxInteraction(){
        if(cb1UI.isChecked() || cb2UI.isChecked() || cb3UI.isChecked()){
            continueBtnUI.setBackground(getResources().getDrawable(R.drawable.colorbtn));
            continueBtnUI.setClickable(true);
        }else{
            Toast.makeText(this, "Por favor elige una opción", Toast.LENGTH_SHORT).show();
            continueBtnUI.setBackground(getResources().getDrawable(R.drawable.notaccesiblecolorbtn));
            continueBtnUI.setClickable(false);
        }
    }

}