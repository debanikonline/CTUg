package debanikandroidstudio.ctug;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class LoginSwitcher extends AppCompatActivity
{
    ImageButton user,admin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_switcher);
        user=(ImageButton)findViewById(R.id.userlogin);
        admin=(ImageButton)findViewById(R.id.adminlogin);
        user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent user=new Intent(getApplicationContext(),Login.class);
                startActivity(user);
            }
        });
        admin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent admin=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(admin);
            }
        });

    }

}
