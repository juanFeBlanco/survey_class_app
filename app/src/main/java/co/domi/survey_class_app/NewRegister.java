package co.domi.survey_class_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class NewRegister extends AppCompatActivity {

    private EditText nameUI;
    private EditText codeUI;
    private Button continueBtnUI;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_register);

        nameUI = findViewById(R.id.nameTextFieldID);
        codeUI = findViewById(R.id.codeTextFieldID);
        continueBtnUI = findViewById(R.id.continueBtnID);

        continueBtnUI.setOnClickListener(
                (view) -> {
                    if(!nameUI.getText().toString().equals("") && !codeUI.getText().toString().equals("")){
                        Student newStudent = new Student(nameUI.getText().toString(), codeUI.getText().toString());
                        SharedPreferences info = getSharedPreferences("studentsList",MODE_PRIVATE);
                        String currentStudentsR = info.getString("list", "vacío");
                        info.edit().putString("list", currentStudentsR + "\n" + newStudent.toString()).apply();
                        Intent prepAct = new Intent(this, PreparationActivities1.class);
                        startActivity(prepAct);
                    }
                }
        );
    }
}