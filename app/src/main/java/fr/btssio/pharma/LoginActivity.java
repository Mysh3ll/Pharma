package fr.btssio.pharma;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

import fr.btssio.pharma.orm.gen.DAOProvider;
import fr.btssio.pharma.orm.gen.Visiteur;
import fr.btssio.pharma.orm.gen.VisiteurDAO;
import fr.btssio.pharma.orm.gen.VisiteurDAOImpl;
import fr.btssio.pharma.orm.runtime.query.SelectQuery;
import fr.btssio.pharma.sqllite.PharmaSQLiteOpenHelper;

public class LoginActivity extends AppCompatActivity {

    private static final int REQUEST_CODE = 1;
    private EditText etUsername, etPassword;
    private Button btnLogin;
    private VisiteurDAO visiteurDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT); // Make to run your application only in portrait mode
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
                    //Vérification du visiteur en BDD
                    visiteurDAO = new VisiteurDAOImpl(new PharmaSQLiteOpenHelper(getApplicationContext()));
                    List<Visiteur> visiteurs = visiteurDAO.getVisiteurList(VisiteurDAO.VIS_NOM.eq(getUsername()));

                    for (Visiteur visiteur :
                            visiteurs) {
                        if (visiteur.getVisDateemb().equals(getPassword())) {
                            Intent mainIntent = new Intent(getApplicationContext(), MainActivity.class);
                            mainIntent.putExtra("vis_mat", visiteur.getVisMat());
                            startActivityForResult(mainIntent, REQUEST_CODE);
                        } else {
                            Toast.makeText(getApplicationContext(), "Nom d'utilisateur ou mot de passe incorrect !",Toast.LENGTH_LONG).show();
                        }
                    }

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
