package fisei.uta.edu.ec.android_app_001;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SecondActivity extends AppCompatActivity {

    //  Variable para mostrar los datos recibidos del: MainActivity
    private TextView textViewMessage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_second);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Obtener los datos del: Intent
        Bundle extras = getIntent().getExtras();
        String user = extras.getString("userParm");
        String password = extras.getString("passwordParm");

        textViewMessage = findViewById(R.id.textViewMessage);
        textViewMessage.setText("Usuario:" + user + "     " + "Clave: " + password);
    }
    public void onClicBrowser(View view) {

    }
    public void onClicCall(View view) {

    }
    public void onClicGoggleMaps(View view) {

    }
    public void onClicShowThirdActivity(View view) {

    }
    public void onClicClose(View view) {
        finish();
    }
}