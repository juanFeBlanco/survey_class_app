package co.domi.survey_class_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

public class selfEvaluationActivity extends AppCompatActivity {

    private CheckBox cB1;
    private CheckBox cB2;
    private CheckBox cB3;
    private Button endingBnt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_self_evaluation);

        cB1 = findViewById(R.id.SECB1);
        cB2 = findViewById(R.id.SECB2);
        cB3 = findViewById(R.id.SECB3);
        endingBnt = findViewById(R.id.endBtn);

       endingBnt.setClickable(false);

        cB1.setOnClickListener(
                (view) -> {
                    manageCheckBoxInteraction();
                }
        );

        cB2.setOnClickListener(
                (view) -> {
                    manageCheckBoxInteraction();
                }
        );

        cB3.setOnClickListener(
                (view) -> {
                    manageCheckBoxInteraction();
                }
        );

        endingBnt.setOnClickListener(
                (view) -> {
                    int score = 0;
                    if(cB1.isChecked()){
                        score+=1;
                    }
                    if(cB2.isChecked()){
                        score+=3;
                    }

                    SharedPreferences info = getSharedPreferences("studentsList",MODE_PRIVATE);
                    String scores = info.getString("listScores2", "vacío");
                    info.edit().putString("listScores2", scores + "\n" + score).apply();
                    finish();
                }
        );
        //1:47:50
    }

    public void manageCheckBoxInteraction(){
        if(cB1.isChecked() || cB2.isChecked() || cB3.isChecked()){
            endingBnt.setBackground(getResources().getDrawable(R.drawable.colorbtn));
            endingBnt.setClickable(true);
        }else{
            Toast.makeText(this, "Por favor elige una opción", Toast.LENGTH_SHORT).show();
            endingBnt.setBackground(getResources().getDrawable(R.drawable.notaccesiblecolorbtn));
            endingBnt.setClickable(false);
        }
    }


}