package debanikandroidstudio.ctug;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.StrictMode;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class AdminEditor extends AppCompatActivity
{
    String u[],p[];
    EditText updatepassword;
    Button updateindatabase,deletefromdatabase;
    TextView updateusername;
    String username="",password="";
    String hosturl="http://192.168.43.113/CTU/updateAdminpannel.php";
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_editor);
        StrictMode.ThreadPolicy threadPolicy = new StrictMode.ThreadPolicy.Builder().build();
        StrictMode.setThreadPolicy(threadPolicy);
        updateusername=(TextView) findViewById(R.id.admineditoruname);
        updatepassword=(EditText)findViewById(R.id.admineditorpassword);
        updateusername.setText(getIntent().getExtras().getString("uname"));
        updatepassword.setText(getIntent().getExtras().getString("pass"));
        updateindatabase=(Button)findViewById(R.id.admineditorEDITbutton);
        deletefromdatabase=(Button)findViewById(R.id.EditorDELETE_fromDATABASE_Button);

        updateindatabase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {

                update();


            }
        });
        deletefromdatabase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                delete();
            }
        });


    }
    public  void update()
    {
        String line="";
        String details="";
        StringBuilder stringb=new StringBuilder();
        username=updateusername.getText().toString();
        password=updatepassword.getText().toString();

        try
        {
            URL url=new URL(hosturl);
            HttpURLConnection connect=(HttpURLConnection)url.openConnection();
            connect.setRequestMethod("POST");
            connect.setDoOutput(true);
            //Toast.makeText(this,"Connection esatablhed",Toast.LENGTH_LONG).show();
            OutputStream os=connect.getOutputStream();
            OutputStreamWriter osw=new OutputStreamWriter(os,"UTF-8");
            BufferedWriter bw=new BufferedWriter(osw);
            String updatequery= URLEncoder.encode("username","UTF-8")+"="+URLEncoder.encode(username,"UTF-8")+
                    "&"+ URLEncoder.encode("password","UTF-8")+"="+URLEncoder.encode(password,"UTF-8")+
                    "&"+URLEncoder.encode("submit","UTF-8")+"="+URLEncoder.encode("up","UTF-8");
            bw.write(updatequery);
            bw.flush();
            bw.close();
            osw.close();
            InputStream in=connect.getInputStream();
            connect.connect();
//            InputStreamReader isr=new InputStreamReader(in);
//            BufferedReader br=new BufferedReader(isr);
//            if(br!=null)
//            {
//                while((line=br.readLine())!=null)
//                {
//                    stringb.append(line+"\n");
//                }
//                details=stringb.toString();
//                Toast.makeText(getApplicationContext(),""+details,Toast.LENGTH_SHORT).show();
//
//                JSONObject object=new JSONObject(details);
//
//
//            }
            in.close();

            //Toast.makeText(this,"Details Updated",Toast.LENGTH_LONG).show();
            updateusername.setText("");
            updatepassword.setText("");
            DboxUpdated();
        }

        catch (Exception e)
        {
            Toast.makeText(getApplicationContext(),""+e,Toast.LENGTH_SHORT).show();
        }

    }
    public void DboxUpdated()
    {
        AlertDialog.Builder box= new AlertDialog.Builder(this);
        box.setMessage("Do you want to go back to the Menu Page?");
        box.setTitle("Records Updated");
        box.setCancelable(true);
        //box.setPositiveButton("Proceed", new DialogInterface
        box.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which)
            {
                Intent gotoAdminEditor=new Intent(getApplicationContext(),WelcomeADMIN.class);
                startActivity(gotoAdminEditor);

            }
        });
        box.setNegativeButton("Show Updated Database", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which)
            {
                Intent gotoAdminEditor=new Intent(getApplicationContext(),ViewDetails.class);
                startActivity(gotoAdminEditor);
                dialog.cancel();
            }
        });
        AlertDialog dialog=box.create();
        dialog.show();
    }
    public void DboxDeleted()
    {
        AlertDialog.Builder box= new AlertDialog.Builder(this);
        box.setMessage("Do you want to go back to the Menu Page?");
        box.setTitle("Item Deleted from Records");
        box.setCancelable(true);
        //box.setPositiveButton("Proceed", new DialogInterface
        box.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent gotoAdminEditor = new Intent(getApplicationContext(), WelcomeADMIN.class);
                        startActivity(gotoAdminEditor);

                    }
                });
        box.setNegativeButton("Show Updated Database", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which)
            {
                Intent gotoAdminEditor=new Intent(getApplicationContext(),ViewDetails.class);
                startActivity(gotoAdminEditor);
                dialog.cancel();
            }
        });
        AlertDialog dialog=box.create();
        dialog.show();
    }
    public void delete()
    {
        username=updateusername.getText().toString();
        password=updatepassword.getText().toString();
        try
        {
            URL url2=new URL(hosturl);
            HttpURLConnection con=(HttpURLConnection)url2.openConnection();
            con.setRequestMethod("POST");
            con.setDoOutput(true);
            OutputStream os1=con.getOutputStream();
            OutputStreamWriter osw=new OutputStreamWriter(os1,"UTF-8");
            BufferedWriter bw1=new BufferedWriter(osw);
            String deletequery=URLEncoder.encode("username","UTF-8")+"="+URLEncoder.encode(username,"UTF-8")
                    +"&"+URLEncoder.encode("password","UTF-8")+"="+URLEncoder.encode(password,"UTF-8")
                    +"&"+URLEncoder.encode("submit","UTF-8")+"="+URLEncoder.encode("delete","UTF-8");
            bw1.write(deletequery);
            bw1.flush();
            bw1.close();
            osw.close();
            InputStream in=con.getInputStream();
            con.connect();
            in.close();
            //Toast.makeText(this,"Entry Deleted",Toast.LENGTH_LONG).show();
            updateusername.setText("");
            updatepassword.setText("");
            DboxDeleted();

        }
        catch(Exception e)
        {
            Toast.makeText(getApplicationContext(),""+e,Toast.LENGTH_SHORT).show();
        }
    }



}
