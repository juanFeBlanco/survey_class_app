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
                    if(!nameUI.getText().toString().equals("") && !codeUI.getText().toString().equals("") && !verifyInput()){
                        SharedPreferences info = getSharedPreferences("studentsList",MODE_PRIVATE);
                        info.edit().putString("names", nameUI.getText().toString() + ";").apply();
                        info.edit().putString("codes", codeUI.getText().toString() + ";").apply();

                        Intent prepAct = new Intent(this, PreparationActivities1.class);
                        finish();
                        startActivity(prepAct);
                    }else{
                        Toast.makeText(this, "Campos no rellenados o código repetido", Toast.LENGTH_SHORT).show();
                    }
                }
        );
    }

    private boolean verifyInput() {
        boolean found = false;
        String code = codeUI.getText().toString();
        SharedPreferences info = getSharedPreferences("studentsList",MODE_PRIVATE);
        String codes = info.getString("codes", "vacío");
        String[] codesS = codes.split(";");

        for(int i = 0; i < codesS.length && !found; i++){
            if(code.equals(codesS[i])){
                found = true;
            }
        }
        return found;
    }
}