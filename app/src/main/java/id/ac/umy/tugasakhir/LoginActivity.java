package id.ac.umy.tugasakhir;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.firebase.auth.FirebaseUser;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private EditText et_email;
    private EditText et_password;
    private Button btn_login;
    private TextView btn_regis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        et_email = findViewById(R.id.et_Email);
        et_password = findViewById(R.id.et_pass);
        btn_login = findViewById(R.id.btn_login);
        btn_regis = findViewById(R.id.regis);
        mAuth = FirebaseAuth.getInstance();

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String email = et_email.getText().toString();
                String password = et_password.getText().toString();

                if ((TextUtils.isEmpty(email) || TextUtils.isEmpty(password))){
                    Toast.makeText(getApplicationContext(), "Harap Isi Data Dengan Lengkap", Toast.LENGTH_LONG).show();
                } else {
                    mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()){

                                Toast.makeText(getApplicationContext(), "Login Berhasil!", Toast.LENGTH_LONG).show();
                                Intent main = new Intent(getApplicationContext(), MainActivity.class);
                                main.putExtra("data", et_email.getText().toString());
                                startActivity(main);
                                finish();
                            }else{
                                Toast.makeText(getApplicationContext(), "Login Gagal!", Toast.LENGTH_LONG).show();
                            }
                        }
                    });
                }
            }
        });


        btn_regis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Regis = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(Regis);
            }
        });

    }
}