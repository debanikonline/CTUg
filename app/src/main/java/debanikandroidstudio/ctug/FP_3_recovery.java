package debanikandroidstudio.ctug;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class FP_3_recovery extends AppCompatActivity
{
    EditText p1,p2;
Button change;
    String enter1,enter2;
    String un;
    int flag=0,flag2=0;
    String thispass="";
    String hosturl2="http://192.168.43.113/CTU/updateforgot.php";
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fp_3_recovery);
        un=getIntent().getStringExtra("username");
       // Toast.makeText(this, "final "+un, Toast.LENGTH_SHORT).show();
        p1=(EditText)findViewById(R.id.fp_3_password1);
        p2=(EditText)findViewById(R.id.fp_3_confirmpassword);
        change=(Button)findViewById(R.id.fp_3_button);
        change.setEnabled(false);
        p1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after)
            {
                flag=0;
                change.setEnabled(false);
                change.setBackgroundColor(Color.TRANSPARENT);
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count)
            {
                if(s.length()>0)
                {
                    flag=1;
                    if((flag==1)&&(flag2==1))
                    {
                        change.setEnabled(true);
                        change.setBackgroundColor(Color.WHITE);
                        change.setTextColor(Color.BLACK);
                    }
                }
                else if(s.length()==0)
                {
                    flag=0;
                    change.setEnabled(false);
                    change.setBackgroundColor(Color.TRANSPARENT);
                }

            }

            @Override
            public void afterTextChanged(Editable s)
            {
                if(s.length()>0)
                {
                    flag=1;
                    if((flag==1)&&(flag2==1))
                    {
                        change.setEnabled(true);
                        change.setBackgroundColor(Color.WHITE);
                        change.setTextColor(Color.BLACK);
                    }
                }
                else if(s.length()==0)
                {
                    flag=0;
                    change.setEnabled(false);
                    change.setBackgroundColor(Color.TRANSPARENT);
                }

            }
        });
        p2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after)
            {
                flag2=0;
                change.setEnabled(false);
                change.setBackgroundColor(Color.TRANSPARENT);

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count)
            {
                if(s.length()>0)
                {
                    flag2=1;
                    if((flag==1)&&(flag2==1))
                    {
                        change.setEnabled(true);
                        change.setBackgroundColor(Color.WHITE);
                        change.setTextColor(Color.BLACK);
                    }
                }
                else if(s.length()==0)
                {
                    flag2=0;
                    change.setEnabled(false);
                    change.setBackgroundColor(Color.TRANSPARENT);
                }

            }

            @Override
            public void afterTextChanged(Editable s)
            {
                if(s.length()>0)
                {
                    flag2=1;
                    if((flag==1)&&(flag2==1))
                    {
                        change.setEnabled(true);
                        change.setBackgroundColor(Color.WHITE);
                        change.setTextColor(Color.BLACK);
                    }
                }
                else if(s.length()==0)
                {
                    flag2=0;
                    change.setEnabled(false);
                    change.setBackgroundColor(Color.TRANSPARENT);
                }

            }
        });
        change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                enter1=p1.getText().toString();
                enter2=p2.getText().toString();
                if(enter1.equals(enter2))
                {
                    //Toast.makeText(FP_3_recovery.this, "all fine with "+un, Toast.LENGTH_SHORT).show();

                    thispass=p2.getText().toString();
                    update(un);
                    Toast.makeText(FP_3_recovery.this, "Updated", Toast.LENGTH_SHORT).show();
                    Intent i=new Intent(getApplicationContext(),Login.class);
                    startActivity(i);
                    Toast.makeText(FP_3_recovery.this, "Please Login with the updated credentials!!", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(FP_3_recovery.this, "Both Passwords should be the same!!", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
    public void update(String n)
    {


        try
        {
            URL u=new URL(hosturl2);
            HttpURLConnection con=(HttpURLConnection)u.openConnection();
            con.setRequestMethod("POST");
            con.setDoOutput(true);
            OutputStream os=con.getOutputStream();
            OutputStreamWriter osw=new OutputStreamWriter(os,"UTF-8");
            BufferedWriter bw=new BufferedWriter(osw);
            String query= URLEncoder.encode("us","UTF-8")+"="+URLEncoder.encode(n,"UTF-8")+"&"+URLEncoder.encode("ps","UTF-8")+
                    "="+URLEncoder.encode(thispass,"UTF-8");
            bw.write(query);
            bw.flush();
            bw.close();
            InputStream is= con.getInputStream();
            con.connect();
            is.close();
        }
        catch (Exception e)
        {

        }
    }
}
