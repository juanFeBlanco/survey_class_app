package co.domi.survey_class_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {

    private TextView listNamesUI;
    private Button registerBtnUI;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences savedInfo = getSharedPreferences("studentsList",MODE_PRIVATE);
        listNamesUI = findViewById(R.id.listRegisteredID);
        registerBtnUI = findViewById(R.id.registerBtnID);

        savedInfo.edit().putString("names", "").apply();
        savedInfo.edit().putString("codes", "").apply();
        savedInfo.edit().putString("listScores","").apply();
        savedInfo.edit().putString("listScores2","").apply();

        registerBtnUI.setOnClickListener(
                (view) -> {
                    Intent registerActivity = new Intent(this, NewRegister.class);
                    startActivity(registerActivity);
                }
        );
    }

    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences info = getSharedPreferences("studentsList",MODE_PRIVATE);
        String names = info.getString("names", "vacío");
        String codes = info.getString("codes", "vacío");
        String scores1 = info.getString("listScores", "vacío");
        String scores2 = info.getString("listScores2", "vacío");

        String[] namesS = names.split(";");
        String[] codesS = names.split(";");
        String[] scoresS1 = scores1.split(";");
        String[] scoresS2 = scores2.split(";");

       for (int i = 0; i < namesS.length; i++){
           try {
               int total = Integer.parseInt(scoresS1[i]) + Integer.parseInt(scoresS2[i]);
               listNamesUI.setText(listNamesUI.getText().toString() + "\n" + namesS[i] + " " + total);
           }catch (NumberFormatException e){

           }

        }
    }
}