package sv.edu.utec.parcial2etps1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class ListaPersonal extends AppCompatActivity {
    private ArrayList<Personal> listapersonal;
    ListView lv1;
    Integer[]ImgPpersonal={
            R.drawable.lead_photo_1,
            R.drawable.lead_photo_2,
            R.drawable.lead_photo_3,
            R.drawable.lead_photo_4,
            R.drawable.lead_photo_5,
            R.drawable.lead_photo_6,
            R.drawable.lead_photo_7,
            R.drawable.lead_photo_8,
            R.drawable.lead_photo_9,
            R.drawable.lead_photo_10,
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_personal);

        listapersonal=new ArrayList<Personal>();
        listapersonal.add(new Personal("Alexander Pierrot","CEO","Insures S.O."));
        listapersonal.add(new Personal("Carlos Lopez","Asistente","Hospital Blue"));
        listapersonal.add(new Personal("Sara Bonz","Directora de Markrting","Electrical Parts ltd"));
        listapersonal.add(new Personal("Liliana Clarence","Diseñadora de Producto","Creativa App"));
        listapersonal.add(new Personal("Benito Peralta","Supervisor de Ventas","Neumáticos Press"));
        listapersonal.add(new Personal("Juan Jaramillo","CEO","Banco Nacional"));
        listapersonal.add(new Personal("Christian Sters","CTO","Cooperativa Verde"));
        listapersonal.add(new Personal("Alexa Giralado","Lead Programmer","Frutisofy"));
        listapersonal.add(new Personal("Linda Murillo","Directora de Marketing","Seguros Boliver"));
        listapersonal.add(new Personal("Lizeth Astrada","CEO","Concesionario Motolax"));

        AdaptadorPersonal adaptador = new AdaptadorPersonal(this);
        lv1 = findViewById(R.id.lsvPersonal);
        lv1.setAdapter(adaptador);
    }
    class AdaptadorPersonal extends ArrayAdapter<Personal> {
        AppCompatActivity appCompatActivity;
        AdaptadorPersonal(AppCompatActivity context) {
            super(context, R.layout.personal, listapersonal);
            appCompatActivity = context;
        }
        public View getView(int position, View convertView, ViewGroup parent)
        {
            LayoutInflater inflater = appCompatActivity.getLayoutInflater();
            View item = inflater.inflate(R.layout.personal, null);
            TextView textView1 = item.findViewById(R.id.tvNombre);
            textView1.setText(listapersonal.get(position).getNombre());

            TextView textView2 = item.findViewById(R.id.tvCargo);
            textView2.setText(listapersonal.get(position).getCargo());

            TextView textView3 = item.findViewById(R.id.tvCompania);
            textView3.setText(listapersonal.get(position).getCompania());
            ImageView imageView1 = item.findViewById(R.id.imvFoto);
            imageView1.setImageResource(ImgPpersonal[position]);
            return(item);
        }
    }
}