package debanikandroidstudio.ctug;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.os.StrictMode;
import android.provider.Settings;
import android.support.annotation.DrawableRes;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
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
import java.util.ArrayList;
import java.util.List;

public class Login extends AppCompatActivity
{
    EditText name, pass;
    Button login, fb;
    String nd,pd;
    int access;

    RelativeLayout relativeLayout;
    AnimationDrawable animationDrawable;
    Spinner language;
    TextView logo, signup;
    int flag=0,flag2=0;
    Typeface tf;
    String hosturl = "http://192.168.43.113/CTU/checkup.php";
    Drawable shape;
    TextView forgot;
    int c=0;
    //String a,b;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        StrictMode.ThreadPolicy policy=new StrictMode.ThreadPolicy.Builder().build();
        StrictMode.setThreadPolicy(policy);
        shape=getResources().getDrawable(R.drawable.fullborder);
        relativeLayout=(RelativeLayout)findViewById(R.id.loginback);
        animationDrawable = (AnimationDrawable) relativeLayout.getBackground();
        animationDrawable.setEnterFadeDuration(5000);
        animationDrawable.setExitFadeDuration(2000);
        name=(EditText)findViewById(R.id.name);
        pass=(EditText)findViewById(R.id.password);
        forgot=(TextView)findViewById(R.id.forgotpasstextview);
        nd=name.getText().toString();
        pd=pass.getText().toString();
        signup=(TextView)findViewById(R.id.signup);
        fb=(Button)findViewById(R.id.fbLogin);
        ////-------
//        a=getIntent().getStringExtra("a");
//        b=getIntent().getStringExtra("b");



        ////---------
        language=(Spinner)findViewById(R.id.spinlang);
        logo=(TextView)findViewById(R.id.logo);
        login=(Button)findViewById(R.id.login);
        tf=Typeface.createFromAsset(getAssets(),"fonts/debu.ttf");
        logo.setTypeface(tf);
        login.setEnabled(false);
        ArrayList list=new ArrayList();
        list.add("English");
        list.add("German");
        list.add("Spanish");
        list.add("Chinese");
        list.add("Italiano");
        list.add("japanese");
        list.add("Portugues");
        list.add("Filipino");
        list.add("Hindi");
        list.add("Bengali");
        ArrayAdapter adp=new ArrayAdapter(this,R.layout.support_simple_spinner_dropdown_item,list);
        adp.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        language.setAdapter(adp);

        name.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after)
            {
            login.setEnabled(false);
                flag=0;
                //login.setBackgroundColor(Color.parseColor("#00000000"));
                login.setBackgroundDrawable(shape);
                login.setTextColor(Color.parseColor("#26ffffff"));

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count)
            {
                if(s.length()>0)
                {
                    flag=1;
                    if((flag==1)&&(flag2==1))
                    {
                        login.setEnabled(true);
                        login.setBackgroundColor(Color.WHITE);
                        login.setTextColor(Color.BLACK);
                    }

                }
                else if(s.length()==0)
                {
                    flag=0;
                    login.setEnabled(false);
                    //login.setBackgroundColor(Color.parseColor("#00000000"));
                    login.setBackgroundDrawable(shape);
                    login.setTextColor(Color.parseColor("#26ffffff"));
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
                        login.setEnabled(true);
                        login.setBackgroundColor(Color.WHITE);
                        login.setTextColor(Color.BLACK);
                    }
                }
                if (s.length()==0)
                {
                    flag=0;
                    login.setEnabled(false);
                    //login.setBackgroundColor(Color.parseColor("#00000000"));
                    login.setBackgroundDrawable(shape);
                    login.setTextColor(Color.parseColor("#26ffffff"));

                }

            }
        });
        pass.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s1, int start, int count, int after) {
                login.setEnabled(false);
                flag2=0;
                //login.setBackgroundColor(Color.parseColor("#00000000"));
                login.setBackgroundDrawable(shape);
                login.setTextColor(Color.parseColor("#26ffffff"));

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count)
            {
                if(s.length()>0)
                {
                    flag2=1;
                    if((flag==1)&&(flag2==1))
                    {
                        login.setEnabled(true);
                        login.setBackgroundColor(Color.WHITE);
                        login.setTextColor(Color.BLACK);
                    }

                }
                else if(s.length()==0)
                {
                    flag2=0;
                    login.setEnabled(false);
                    //login.setBackgroundColor(Color.parseColor("#00000000"));
                    login.setBackgroundDrawable(shape);
                    login.setTextColor(Color.parseColor("#26ffffff"));
                }

            }

            @Override
            public void afterTextChanged(Editable s1) {
                if(s1.length()>0)
                {
                    flag2=1;
                    if((flag==1)&&(flag2==1))
                    {
                        login.setEnabled(true);
                        login.setBackgroundColor(Color.WHITE);
                        login.setTextColor(Color.BLACK);
                    }

                }
                else if(s1.length()==0)
                {
                    flag2=0;
                    login.setEnabled(false);
                    //login.setBackgroundColor(Color.parseColor("#00000000"));
                    login.setBackgroundDrawable(shape);
                    login.setTextColor(Color.parseColor("#26ffffff"));
                }


                }



        });
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                check();
                if(access==1)
                {
                    Intent welcomeuser=new Intent(getApplicationContext(),WelcomeUSER_Navi.class);
                    startActivity(welcomeuser);
                    //Toast.makeText(Login.this, "yes 1", Toast.LENGTH_SHORT).show();
                }
                else if(access==0)
                {
                    dbox();
                    //Toast.makeText(Login.this, "Username or Password incorrect..!!", Toast.LENGTH_SHORT).show();
                }
                //check login details , start codeing from here.!!
               // Intent welcomeuser=new Intent(getApplicationContext(),WelcomeUSER_Navi.class);
                //startActivity(welcomeuser);
            }
        });



        forgot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent frgt=new Intent(getApplicationContext(),FP_Enterusername.class);
                startActivity(frgt);
            }
        });
        fb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Login.this, "Will be implemented in next version, thanks for your support", Toast.LENGTH_SHORT).show();
               // Toast.makeText(Login.this, "a--"+a+"b--"+b, Toast.LENGTH_SHORT).show();
            }
        });
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent newuserregistration=new Intent(getApplicationContext(),NewUserRegisterPage.class);
                startActivity(newuserregistration);
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        if (animationDrawable != null && !animationDrawable.isRunning())
            animationDrawable.start();
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (animationDrawable != null && animationDrawable.isRunning())
            animationDrawable.stop();
    }

    @Override
    public void onBackPressed() {




        Toast.makeText(this, "For security reason back press is disabled , close the app manually, Thanks", Toast.LENGTH_SHORT).show();

    }
    public void check()
    {
        String un=name.getText().toString();
        String up=pass.getText().toString();
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
          //  Toast.makeText(this, "flag code--"+access, Toast.LENGTH_SHORT).show();






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
        box.setPositiveButton("Forgot Password?", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which)
            {
                Intent i=new Intent(getApplicationContext(),FP_Enterusername.class);
                startActivity(i);

            }
        });
        AlertDialog dialog=box.create();
        dialog.show();
    }


}
