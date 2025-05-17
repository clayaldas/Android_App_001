package fisei.uta.edu.ec.android_app_001;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

public class ThirdActivity extends AppCompatActivity {
    private ListView listViewData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_third);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        listViewData = findViewById(R.id.listViewData);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, loadDataListView());

        // Asociar los datos (adapter) al ListView para que se visualice
        listViewData.setAdapter(adapter);

        // Utilizar el evento (clic) dentro de un item para seleccionar
        // el item presionado.
        listViewData.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                // Recuperar el item seleccionado
                String itemSelected = (String) listViewData.getAdapter().getItem(i);

                /*
                Toast.makeText(getApplicationContext(), "Item seleccionado: " + itemSelected,
                        Toast.LENGTH_SHORT).show();
                 */

                // Regresar el item seleccionado
                Intent intent = new Intent();
                intent.setData(Uri.parse(itemSelected));

                setResult(Activity.RESULT_OK, intent);

                finish();
            }
        });
    }

    private List<String> loadDataListView() {
        List<String> list = new ArrayList<String>();

        for (int i=1; i <=20; i++) {
            String number = "Número: " + i;
            list.add(number);
        }

        return  list;
    }
}