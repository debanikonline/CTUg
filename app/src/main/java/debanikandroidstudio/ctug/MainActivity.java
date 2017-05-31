package debanikandroidstudio.ctug;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.StrictMode;
import android.provider.CalendarContract;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

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

public class MainActivity extends AppCompatActivity {
    Button btnlogin, forgot;
    EditText txtname, txpassword;
    int flag=0,fla2=0;
    int access;
    String hosturl = "http://192.168.43.113/CTU/checkadmin.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        StrictMode.ThreadPolicy policy=new StrictMode.ThreadPolicy.Builder().build();
        StrictMode.setThreadPolicy(policy);
        txtname = (EditText) findViewById(R.id.editTextname);
        txpassword = (EditText) findViewById(R.id.editTextpassword);
        btnlogin = (Button) findViewById(R.id.buttonlogin);
        btnlogin.setEnabled(false);
        txtname.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after)
            {
                flag=0;
               // btnlogin.setEnabled(false);

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count)
            {
                if(s.length()>0)
                {
                    flag=1;
                    if((flag==1)&&(fla2==1))
                    {
                        btnlogin.setEnabled(true);
                        btnlogin.setBackgroundColor(Color.WHITE);
                        btnlogin.setTextColor(Color.parseColor("#000000"));
                    }

                }
                else if(s.length()==0)
                {
                    flag=0;
                    btnlogin.setEnabled(false);
                    btnlogin.setBackgroundColor(Color.TRANSPARENT);
                }

            }

            @Override
            public void afterTextChanged(Editable s)
            {
                if(s.length()>0)
                {
                    flag=1;
                    if((flag==1)&&(fla2==1))
                    {
                        btnlogin.setEnabled(true);
                        btnlogin.setBackgroundColor(Color.WHITE);
                        btnlogin.setTextColor(Color.parseColor("#000000"));
                    }

                }
                else if(s.length()==0)
                {
                    flag=0;
                    btnlogin.setEnabled(false);
                    btnlogin.setBackgroundColor(Color.TRANSPARENT);
                }

            }
        });
        txpassword.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after)
            {
                fla2=0;

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(s.length()>0)
                {
                    fla2=1;
                    if((fla2==1)&&(flag==1))
                    {
                        btnlogin.setEnabled(true);
                        btnlogin.setBackgroundColor(Color.WHITE);
                        btnlogin.setTextColor(Color.parseColor("#000000"));
                    }
                }
                else if(s.length()==0)
                {
                    fla2=0;
                    btnlogin.setEnabled(false);
                    btnlogin.setBackgroundColor(Color.TRANSPARENT);
                }
            }

            @Override
            public void afterTextChanged(Editable s)
            {
                if(s.length()>0)
                {
                    fla2=1;
                    if((fla2==1)&&(flag==1))
                    {
                        btnlogin.setEnabled(true);

                        btnlogin.setBackgroundColor(Color.WHITE);
                        btnlogin.setTextColor(Color.parseColor("#000000"));
                    }
                }
                else if(s.length()==0)
                {
                    fla2=0;
                    btnlogin.setEnabled(false);
                    btnlogin.setBackgroundColor(Color.TRANSPARENT);
                }
            }
        });

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                check();
                if(access==1)
                {
                    Intent welcomeAdminPage = new Intent(getApplicationContext(), WelcomeADMIN.class);
                    startActivity(welcomeAdminPage);
                   // Intent welcomeuser=new Intent(getApplicationContext(),WelcomeUSER_Navi.class);
                    //startActivity(welcomeuser);
                    //Toast.makeText(MainActivity.this, "yes 1", Toast.LENGTH_SHORT).show();
                }
                else if(access==0)
                {
                    dbox();
                    //Toast.makeText(MainActivity.this, "Username or Password incorrect..!!", Toast.LENGTH_SHORT).show();
                }

                //----------after checking correct username and password use the following intent.
                //Intent welcomeAdminPage = new Intent(getApplicationContext(), WelcomeADMIN.class);
                //startActivity(welcomeAdminPage);
            }
        });
//        btnnewuser=(Button)findViewById(R.id.newuserbutton);
//        btnnewuser.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent registerpage=new Intent(getApplicationContext(),RegisterActivity.class);
//                startActivity(registerpage);
//            }
//        });
//        base=(Button)findViewById(R.id.viewbasebutton);
//        base.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent basepage=new Intent(getApplicationContext(),ViewDetails.class);
//                startActivity(basepage);
//            }
//        });
        forgot = (Button) findViewById(R.id.AdminForgotPasswordButtonID);
        forgot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) 
            {
                if(txtname.length()==0)
                {
                    Toast.makeText(MainActivity.this, "Please enter username to continue", Toast.LENGTH_SHORT).show();
                }
                else if(txtname.length()>0) {
                    Dbox();
                }
                else
                {
                    Toast.makeText(MainActivity.this, "", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }

    public void Dbox()
    {
        String name=txtname.getText().toString();
        String print="";
        if (name.equals(null))
        {
            print="";
        }
        else
        {
            print=name;
        }
        AlertDialog.Builder box = new AlertDialog.Builder(this);
        box.setMessage("You cannot reset your password from here, You need to drop a TextMessage to Debanik Moulick [HOD] for assistance, Please check if your UserName is correct in your message.");
        box.setTitle("Need help "+print+"?");
        box.setPositiveButton("Send Message",new DialogInterface.OnClickListener()
        {
            @Override
            public void onClick(DialogInterface dialog, int which)
            {
                String user=txtname.getText().toString();
//                Uri uri = Uri.parse("http://"); // missing 'http://' will cause crashed
//                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
//                startActivity(intent);
                //Intent smsIntent = new Intent(Intent.ACTION_SENDTO,
                     //   Uri.parse("sms:8194946794"));
                        Intent smsIntent=new Intent(Intent.ACTION_VIEW,Uri.parse("sms:8194946794"));
                smsIntent.putExtra("sms_body","Sir i have forgotten my password, i want to reset it, my user name is "+"\n"+user+"\n"+"Thank You.");
                startActivity(smsIntent);



            }
        });
        box.setNegativeButton("i remember!!", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which)
            {
                dialog.cancel();
            }
        });
        AlertDialog d=box.create();
        d.show();

    }
    public void check()
    {
        String un=txtname.getText().toString();
        String up=txpassword.getText().toString();
        String line="";
        StringBuilder bob=new StringBuilder();
       // Toast.makeText(this, "u---"+un+"p-----"+up, Toast.LENGTH_SHORT).show();

        try
        {
            URL u=new URL(hosturl);
            HttpURLConnection con=(HttpURLConnection)u.openConnection();
            con.setRequestMethod("POST");
            con.setDoOutput(true);
            OutputStream os=con.getOutputStream();
            OutputStreamWriter osw=new OutputStreamWriter(os,"UTF-8");
            BufferedWriter bw=new BufferedWriter(osw);
            String query= URLEncoder.encode("uu","UTF-8")+"="+URLEncoder.encode(un,"UTF-8")+"&"+
                    URLEncoder.encode("pp","UTF-8")+"="+URLEncoder.encode(up,"UTF-8");
            bw.write(query);
            bw.flush();
            bw.close();
            InputStream is=con.getInputStream();
            con.connect();
            InputStreamReader isr=new InputStreamReader(is);
            BufferedReader br=new BufferedReader(isr);
            if(br!=null)
            {
                while((line=br.readLine())!=null)
                {
                    bob.append(line+"\n");
                }
                String data=bob.toString();
                JSONObject object=new JSONObject(data);
                access=object.getInt("code");
                //Toast.makeText(this, "flag code--"+access, Toast.LENGTH_SHORT).show();


            }
           // Toast.makeText(this, "flag code--"+access, Toast.LENGTH_SHORT).show();






        }
        catch (Exception e)
        {
            Toast.makeText(this, ""+e, Toast.LENGTH_SHORT).show();

        }
    }
    public void dbox()
    {
        AlertDialog.Builder box= new AlertDialog.Builder(this);
        box.setTitle("ERROR");
        box.setMessage("Please enter valid Username and Password.");
        box.setCancelable(true);
        box.setNegativeButton("Try again", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which)
            {
                dialog.cancel();


            }
        });
        AlertDialog dialog=box.create();
        dialog.show();
    }
}
