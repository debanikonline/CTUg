package debanikandroidstudio.ctug;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class LoginSwitcher extends AppCompatActivity
{
    Spinner loginas;
    String selected="";
    Button proceed;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_switcher);
        proceed=(Button)findViewById(R.id.loginswitcherbuttonID);
        loginas=(Spinner)findViewById(R.id.Login_Switcher_SpinnerID);
        List items=new ArrayList();
        items.add("User Login");
        items.add("Administrator");
        loginas.setPrompt("Login As");
        ArrayAdapter <String> adp=new ArrayAdapter<String>(getApplicationContext(),R.layout.support_simple_spinner_dropdown_item,items);
        adp.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        loginas.setAdapter(adp);
        loginas.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
            {
                    selected=loginas.getSelectedItem().toString();


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        proceed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                String change=selected;
                if (change.equals("User Login"))
                {
                    Intent gotouserloginpage=new Intent(getApplicationContext(),Login_PageUser.class);
                    startActivity(gotouserloginpage);

                }
                else
                {
                    Intent gotoadminloginpage=new Intent(getApplicationContext(),MainActivity.class);
                    startActivity(gotoadminloginpage);
                }
            }
        });

    }

}
