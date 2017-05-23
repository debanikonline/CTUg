package debanikandroidstudio.ctug;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.support.annotation.DrawableRes;
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

import java.util.ArrayList;
import java.util.List;

public class Login extends AppCompatActivity
{
    EditText name, pass;
    Button login, fb;
    String nd,pd;
    RelativeLayout relativeLayout;
    AnimationDrawable animationDrawable;
    Spinner language;
    TextView logo, signup;
    int flag=0,flag2=0;
    Typeface tf;
    Drawable shape;
    TextView forgot;
    //String a,b;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
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
            public void onClick(View v) {
                Intent welcomeuser=new Intent(getApplicationContext(),WelcomeUSER_Navi.class);
                startActivity(welcomeuser);
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
}
