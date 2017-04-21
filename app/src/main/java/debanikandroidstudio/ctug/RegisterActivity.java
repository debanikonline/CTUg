package debanikandroidstudio.ctug;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.StrictMode;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import javax.net.ssl.HttpsURLConnection;

public class RegisterActivity extends AppCompatActivity
{
    Button btnregister;
    EditText regname,regpassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        StrictMode.ThreadPolicy threadPolicy=new StrictMode.ThreadPolicy.Builder().build();
        StrictMode.setThreadPolicy(threadPolicy);
        regname=(EditText)findViewById(R.id.registername);
        regpassword=(EditText)findViewById(R.id.registerpassword);
        btnregister=(Button)findViewById(R.id.registerbutton);
        btnregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                reguser();

                Dbox();
            }
        });

    }
    public void Dbox()
    {
        AlertDialog.Builder box= new AlertDialog.Builder(this);
        box.setMessage("Do you want to go back to the Menu Page?");
        box.setTitle("New Admin Registered");
        box.setCancelable(true);
        //box.setPositiveButton("Proceed", new DialogInterface
        box.setPositiveButton("YES", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which)
            {
                Intent gotoAdminEditor=new Intent(getApplicationContext(),WelcomeADMIN.class);
                startActivity(gotoAdminEditor);

            }
        });
        box.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which)
            {
                regname.setText("");
                regpassword.setText("");
                dialog.cancel();
            }
        });
        AlertDialog dialog=box.create();
        dialog.show();
    }
    public void reguser()
    {
        String registerthisname=regname.getText().toString();
        String registerthispassword=regpassword.getText().toString();
        String hosturl="http://192.168.43.113/CTU/adminphpform.php";
        try
        {
            URL url=new URL(hosturl);
            HttpURLConnection connection=(HttpURLConnection)url.openConnection();
           // HttpsURLConnection connection=(HttpsURLConnection)url.openConnection();
            connection.setRequestMethod("POST");
            connection.setDoOutput(true);
            //Toast.makeText(getApplicationContext(),"connection OK",Toast.LENGTH_SHORT).show();
            OutputStream outstrm=connection.getOutputStream();
            OutputStreamWriter outstrmwrtr=new OutputStreamWriter(outstrm,"UTF-8");
            BufferedWriter bfwrtr=new BufferedWriter(outstrmwrtr);
            String query= URLEncoder.encode("username","UTF-8")+"="+URLEncoder.encode(registerthisname,"UTF-8")+
                    "&"+URLEncoder.encode("password","UTF-8")+"="+URLEncoder.encode(registerthispassword,"UTF-8");
            bfwrtr.write(query);
            bfwrtr.flush();
            bfwrtr.close();
            InputStream in=connection.getInputStream();
            connection.connect();
            in.close();


        }
        catch (Exception e)
        {
            Toast.makeText(getApplicationContext(),""+e,Toast.LENGTH_SHORT).show();
        }

    }
}
