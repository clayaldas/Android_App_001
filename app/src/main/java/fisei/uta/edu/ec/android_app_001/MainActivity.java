package fisei.uta.edu.ec.android_app_001;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private EditText editTextUser;
    private EditText editTextPassword;
    private Button buttonOk;//null

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Obtener las direcciones de las variables de XML (UI)
        editTextUser = findViewById(R.id.editTextUser);
        editTextPassword = findViewById(R.id.editTextPassword);

        buttonOk = findViewById(R.id.buttonOk);

        buttonOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = editTextUser.getText().toString();
                String password = editTextPassword.getText().toString();

                if (!user.matches("") && (!password.matches(""))) {

                    Intent  intent = new Intent(getApplicationContext(), SecondActivity.class);
                    intent.putExtra("userParm", user);
                    intent.putExtra("passwordParm", password);

                    // Mostrar el activity principal del app
                    startActivity(intent);
                }
                else {
                    Toast.makeText(getApplicationContext(), "Los datos son requeridos", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void onClickOk(View view) {

    }
}