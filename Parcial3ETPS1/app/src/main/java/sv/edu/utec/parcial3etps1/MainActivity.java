package sv.edu.utec.parcial3etps1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import sv.edu.utec.parcial3etps1.Helper.AdminSQLiteOpenHelper;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView btnNav;
    EditText edtNombre,edtApellido,edtTelefono,edtCorreo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnNav=findViewById(R.id.btnav_crud);
        edtNombre=findViewById(R.id.edtNOMBRE);
        edtApellido=findViewById(R.id.edtAPELLIDO);
        edtTelefono=findViewById(R.id.edtTELEFONO);
        edtCorreo=findViewById(R.id.edtCORREO);
        btnNav.setOnNavigationItemSelectedListener((BottomNavigationView.OnNavigationItemSelectedListener) navaListener);

    }
    private BottomNavigationView.OnNavigationItemSelectedListener navaListener= new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment seleccionFrag= null;

            switch (item.getItemId()){
                case R.id.navigation_agregar:
                    AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(getApplicationContext(),"bodega",null,2);
                    SQLiteDatabase bd= admin.getWritableDatabase();
                    String nom=edtNombre.getText().toString();
                    String ape=edtApellido.getText().toString();
                    String tele=edtTelefono.getText().toString();
                    String corre=edtCorreo.getText().toString();

                    ContentValues informacion =new ContentValues();
                    informacion.put("nombre",nom);
                    informacion.put("apellidos",ape);
                    informacion.put("telefono",tele);
                    informacion.put("correo",corre);
                    try {
                        bd.insert("contactos", null, informacion);

                        Toast.makeText(getApplicationContext(), "Se inserto el contacto", Toast.LENGTH_LONG).show();
                        bd.close();

                    } catch (Exception e){
                        Toast.makeText(getApplicationContext(), ""+e.getCause(), Toast.LENGTH_LONG).show();
                    }
                    break;
                case R.id.navigation_actualizar:
                    admin = new AdminSQLiteOpenHelper(getApplicationContext(),"bodega",null,2);
                    bd= admin.getWritableDatabase();
                    nom=edtNombre.getText().toString();
                    ape=edtApellido.getText().toString();
                    tele=edtTelefono.getText().toString();
                    corre=edtCorreo.getText().toString();

                    informacion =new ContentValues();
                    informacion.put("nombre",nom);
                    informacion.put("apellidos",ape);
                    informacion.put("telefono",tele);
                    informacion.put("correo",corre);

                    int cat=bd.update("contactos",informacion,
                            "nombre="+"'"+nom+"'",null);
                    bd.close();
                    if(cat==1){
                        Toast.makeText(getApplicationContext(),"Se modifico el contacto",Toast.LENGTH_LONG).show();

                    }
                    else{
                        Toast.makeText(getApplicationContext(),"No se modifico el contacto",Toast.LENGTH_LONG).show();
                    }
                    break;
                case R.id.navigation_eliminar:

                    admin = new AdminSQLiteOpenHelper(getApplicationContext(),"bodega",null,2);
                    bd= admin.getWritableDatabase();
                    nom=edtNombre.getText().toString();

                    cat=bd.delete("contactos",
                            "nombre="+"'"+nom+"'",null);

                    bd.close();
                    edtNombre.setText("");
                    edtApellido.setText("");
                    edtTelefono.setText("");
                    edtCorreo.setText("");

                    if(cat==1){
                        Toast.makeText(getApplicationContext(),"Se borro el contacto",Toast.LENGTH_LONG).show();

                    }
                    else{
                        Toast.makeText(getApplicationContext(),"No se borro el contacto",Toast.LENGTH_LONG).show();

                    }
                    break;

            }

            return true;

        }



    };

}