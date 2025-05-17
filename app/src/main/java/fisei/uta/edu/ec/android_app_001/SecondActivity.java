package fisei.uta.edu.ec.android_app_001;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SecondActivity extends AppCompatActivity {

    private int code = 1;

    //  Variable para mostrar los datos recibidos del: MainActivity
    private TextView textViewMessage;

    //***********************************************************************************
    // Nueva forma
    //***********************************************************************************
    ActivityResultLauncher<Intent> activityResult = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult o) {
                    // Comprobar si la ventana hija (ThirdActivity) se cerro correctamente
                    if (o.getResultCode() == SecondActivity.RESULT_OK) {
                        Intent intent = o.getData();

                        textViewMessage.setText("Utilizando la nueva forma: " + intent.getDataString());
                    }
                }
            }
    );

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
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.google.com"));
        startActivity(intent);
    }
    public void onClicCall(View view) {
        Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:+59374834398"));
        startActivity(intent);
    }

    public void onClicGoggleMaps(View view) {
        // Coordenadas: longitud y latitud (Ecuador)
    }

    public void onClicShowThirdActivity(View view) {
        // Intent intent = new Intent(this, ThirdActivity.class);
        // startActivity(intent);

        Intent intent = new Intent(this, ThirdActivity.class);

        // Para cuando se regresa datos
        //startActivityForResult(intent,code);

        //***********************************************************************************
        // Nueva forma de capturar los datos regresados desde un activity
        //***********************************************************************************
        activityResult.launch(intent);
    }
    public void onClicClose(View view) {
        finish();
    }

    //***********************************************************************************
    // Forma anterior de capturar los datos devueltos por un activity
    //***********************************************************************************
    // Este evento ejecuta al cerrar la ventana que lo llamo (ThirdActivity)
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        /*
        // Comprobar si la ventana que se invoco (ThirdActivity) se cerro correctamente
        if ((requestCode == code) && (resultCode == RESULT_OK))
        {
            textViewMessage.setText("Selecciono el item: " + data.getDataString());
        }

         */
    }
}