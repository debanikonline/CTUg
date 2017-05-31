package debanikandroidstudio.ctug;

import android.content.Intent;
import android.graphics.Color;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
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

public class FP_Enterusername extends AppCompatActivity
{
    EditText edit;
    String username;
    String status;
    Button enter,signup;
    ImageButton img;
    String hosturl="http://192.168.43.113/CTU/checkusername.php";

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fp__enterusername);
        StrictMode.ThreadPolicy policy=new StrictMode.ThreadPolicy.Builder().build();
        StrictMode.setThreadPolicy(policy);
        enter=(Button)findViewById(R.id.fp_1_button);
        signup=(Button)findViewById(R.id.signup_from_help);
        signup.setVisibility(View.INVISIBLE);
        enter.setEnabled(false);
        img=(ImageButton)findViewById(R.id.imageButton2);
        img.setVisibility(View.INVISIBLE);
        edit=(EditText)findViewById(R.id.fp_1_username);
        username=edit.getText().toString();
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(),NewUserRegisterPage.class);
                startActivity(i);
            }
        });
        edit.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after)
            {
                enter.setEnabled(false);
                enter.setBackgroundColor(Color.TRANSPARENT);
                enter.setTextColor(Color.WHITE);
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count)
            {
//                if(s.length()>0)
//                {
//                    enter.setEnabled(true);
//                }
//                else if(s.length()<0)
//                {
//                    enter.setEnabled(false);
//                }

            }

            @Override
            public void afterTextChanged(Editable s)
            {
                if(s.length()==0)
                {
                    enter.setEnabled(false);
                    enter.setBackgroundColor(Color.TRANSPARENT);
                    enter.setTextColor(Color.WHITE);
                }
                else if(s.length()>0)
                {
                    enter.setEnabled(true);
                    enter.setBackgroundColor(Color.WHITE);
                    enter.setTextColor(Color.BLACK);
                }

            }
        });
        enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                username=edit.getText().toString();

                    //Toast.makeText(FP_Enterusername.this, "Searching"+username, Toast.LENGTH_SHORT).show();
                    check(username);
               // Toast.makeText(FP_Enterusername.this, "------o or 1?--"+status, Toast.LENGTH_SHORT).show();
                if(status.equals("0"))
                {
                    Toast.makeText(FP_Enterusername.this, "Entered username doesn't exist, Please signup instead!", Toast.LENGTH_SHORT).show();
                    img.setVisibility(View.INVISIBLE);
                    signup.setVisibility(View.VISIBLE);
                    signup.setBackgroundColor(Color.WHITE);
                }
                else if(status.equals("1"))
                {
                   // Toast.makeText(FP_Enterusername.this, "YESSSS", Toast.LENGTH_SHORT).show();
                    img.setVisibility(View.VISIBLE);
                    signup.setVisibility(View.INVISIBLE);

                    Intent i=new Intent(getApplicationContext(),FP_Quesanswer.class);
                    i.putExtra("username",username);
                    startActivity(i);

                }


            }
        });





    }
    public void check(String name)
    {
        String line="",getstatus;
        StringBuilder bob=new StringBuilder();

        try
        {
            URL url=new URL(hosturl);
            HttpURLConnection co=(HttpURLConnection)url.openConnection();
            co.setRequestMethod("POST");
            co.setDoOutput(true);
            OutputStream os=co.getOutputStream();
            OutputStreamWriter osw=new OutputStreamWriter(os,"UTF-8");
            BufferedWriter bw=new BufferedWriter(osw);
            String query= URLEncoder.encode("cname","UTF-8")+"="+URLEncoder.encode(name,"UTF-8");
            bw.write(query);
            bw.flush();
            bw.close();
            InputStream is=co.getInputStream();
            InputStreamReader isr=new InputStreamReader(is);
            BufferedReader br=new BufferedReader(isr);
            if(br!=null)
            {
                while((line=br.readLine())!=null)
                {
                    bob.append(line+"\n");
                }
                getstatus=bob.toString();

                JSONObject object=new JSONObject(getstatus);
                status=object.getString("code");



            }


        }
        catch (Exception e)
        {
            Toast.makeText(this, "error"+e, Toast.LENGTH_SHORT).show();
        }

    }
}
