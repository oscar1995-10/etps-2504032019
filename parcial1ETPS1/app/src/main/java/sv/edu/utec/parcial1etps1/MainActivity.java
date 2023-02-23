package sv.edu.utec.parcial1etps1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    EditText edtUser,edtPassword;
    Button btnLog;
    TextView txvMessage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtUser=findViewById(R.id.edtUSUARIO);
        edtPassword=findViewById(R.id.edtCONTRASEÑA);

        btnLog=findViewById(R.id.btnLOGUEAR);
        txvMessage=findViewById(R.id.txvMensaje);
    }

    public void  LOGUEAR(View v)
    {
        String user,password;
        user=edtUser.getText().toString();
        password=edtPassword.getText().toString();

        if (user.equals("parcialETps1") && password.equals("p4rC14l#tp$")) {
            Intent intento=new Intent(this,screenIMC.class);
            startActivity(intento);
            txvMessage.setText("contraseña y usuario son correctos");
        }else {
            txvMessage.setText("contraseña y usuario no son correctos");
        }
    }
}