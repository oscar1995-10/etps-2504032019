package sv.edu.utec.parcial1etps1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class screenIMC extends AppCompatActivity {

    EditText edtPeso,edtAltura;
    TextView tvResultado;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen_imc);
        edtPeso=findViewById(R.id.edtPESO);
        edtAltura=findViewById(R.id.edtALTURA);

        tvResultado=findViewById(R.id.tvResultado);
    }

    public  void  calcular(View v)
    {
        Double peso,altura,resultado;
        peso= Double.parseDouble(edtPeso.getText().toString());
        altura=Double.parseDouble(edtAltura.getText().toString());

        resultado=peso/(altura*altura);
        if (resultado< 10.5)
        {
            tvResultado.setText("IMC : "+String.valueOf(resultado)+" Críticamente Bajo de Peso ");
        } else if (resultado <15.9) {
            tvResultado.setText("IMC : "+String.valueOf(resultado)+" Severamente Bajo de Peso");

        } else if (resultado <18.5) {
            tvResultado.setText("IMC : "+String.valueOf(resultado)+" Bajo de Peso");

        } else if (resultado <25) {
            tvResultado.setText("IMC : "+String.valueOf(resultado)+" Normal (peso saludable)");

        } else if (resultado <30) {
            tvResultado.setText("IMC : "+String.valueOf(resultado)+" Sobrepeso");

        } else if (resultado <35) {
            tvResultado.setText("IMC : "+String.valueOf(resultado)+" Obesidad Clase 1 - Moderadamente Obeso");

        } else if (resultado <40) {
            tvResultado.setText("IMC : "+String.valueOf(resultado)+" Obesidad Clase 2 - Severamente Obeso");

        }else {
            tvResultado.setText("IMC : "+String.valueOf(resultado)+" Obesidad Clase 3 - Críticamente Obeso");

        }
    }
}