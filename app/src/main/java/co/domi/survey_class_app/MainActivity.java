package co.domi.survey_class_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView listNamesUI;
    private Button registerBtnUI;
    private Student[] registeredStudents;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences savedInfo = getSharedPreferences("studentsList",MODE_PRIVATE);
        listNamesUI = findViewById(R.id.listRegisteredID);
        registerBtnUI = findViewById(R.id.registerBtnID);

        listNamesUI.setText("No hay estudiantes registrados aún");
        savedInfo.edit().putString("list", "vacío").apply();
        savedInfo.edit().putString("listScores","vacío").apply();
        savedInfo.edit().putString("listScores2","vacío").apply();

        registerBtnUI.setOnClickListener(
                (view) -> {
                    Intent registerActivity = new Intent(this, NewRegister.class);
                    startActivity(registerActivity);
                }
        );
    }
}