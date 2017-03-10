package fr.btssio.pharma;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    private static final int REQUEST_CODE = 1;
    private EditText etUsername, etPassword;
    private Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etUsername = (EditText) findViewById(R.id.etUsername);
        etPassword = (EditText) findViewById(R.id.etPassword);
        btnLogin   = (Button) findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean error = false;

                if (TextUtils.isEmpty(getUsername())) {
                    error = true;
                    Toast.makeText(LoginActivity.this, "Veuillez renter un pseudo.", Toast.LENGTH_LONG).show();
                    etUsername.requestFocus();
                } else if (TextUtils.isEmpty(getPassword())) {
                    error = true;
                    Toast.makeText(LoginActivity.this, "Veuillez renter le mot de passe.", Toast.LENGTH_LONG).show();
                    etPassword.requestFocus();
                }

                if (!error) {
                    Intent mainIntent = new Intent(getApplicationContext(), MainActivity.class);
                    startActivityForResult(mainIntent, REQUEST_CODE);
                }
            }
        });
    }

    @Override
    protected void onActivityResult(int requestcode, int resultcode, Intent data) {
        if (requestcode == REQUEST_CODE){
            if (resultcode == RESULT_OK || resultcode == RESULT_CANCELED) {
                etUsername.setText("");
                etPassword.setText("");
                etUsername.requestFocus();
            }
        }
    }

    private String getUsername() {
        return etUsername.getText().toString().trim();
    }

    private String getPassword() {
        return etPassword.getText().toString().trim();
    }
}
