package debanikandroidstudio.ctug;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

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

public class NewUserRegisterPage extends AppCompatActivity
{
    EditText name,email,phone,password,answer;
    String names,emails,passwords,answers, security;
    String phones;
    Button reg;
    Drawable shape;
    Spinner ques;
    List questions;
    String localhost="http://192.168.43.113/CTU/userregistration.php";
    int flagname=0,flagemail=0,flagphone=0,flagpassword=0,flaganswer=0;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_user_register_page);
        StrictMode.ThreadPolicy policy=new StrictMode.ThreadPolicy.Builder().build();
        StrictMode.setThreadPolicy(policy);
        shape=getResources().getDrawable(R.drawable.fullborder);
        name=(EditText)findViewById(R.id.newuser_NameID);
        email=(EditText)findViewById(R.id.newuser_emailID);
        phone=(EditText)findViewById(R.id.newuser_PhoneID);
        ques=(Spinner)findViewById(R.id.newuser_SpinnerID);
        password=(EditText)findViewById(R.id.newuser_PasswordID);
        answer=(EditText)findViewById(R.id.newuser_AnswerID);
        reg=(Button)findViewById(R.id.newuser_ButtonID);
        reg.setEnabled(false);
        questions=new ArrayList();
        questions.add("Favorite City");
        questions.add("Mother's Maiden name");
        questions.add("Favourite sports person");
        questions.add("Dream vacation place name");
        questions.add("First pet");
        questions.add("Best Friend's name");
        questions.add("Name of first school");
        questions.add("Favourite Singer");
        questions.add("Favourite ICE Cream Name");
        ArrayAdapter adp=new ArrayAdapter(this,R.layout.support_simple_spinner_dropdown_item,questions);
        ques.setAdapter(adp);
        ques.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                security=ques.getSelectedItem().toString();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        name.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after)
            {
                flagname=0;
                reg.setEnabled(false);
                reg.setBackgroundDrawable(shape);
                reg.setTextColor(Color.parseColor("#26ffffff"));

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count)
            {
                if(s.length()==0)
                {
                    flagname=0;
                    reg.setEnabled(false);
                    reg.setBackgroundDrawable(shape);
                    reg.setTextColor(Color.parseColor("#26ffffff"));
                }
                else if (s.length()>0)
                {
                    flagname=1;
                    if((flagname==1)&&(flagemail==1)&&(flagphone==1)&&(flagpassword==1)&&(flaganswer==1))
                    {
                        reg.setEnabled(true);
                        reg.setBackgroundColor(Color.WHITE);
                        reg.setTextColor(Color.BLACK);
                    }
                }

            }

            @Override
            public void afterTextChanged(Editable s)
            {
                if(s.length()==0)
                {
                    flagname=0;
                    reg.setEnabled(false);
                    reg.setBackgroundDrawable(shape);
                    reg.setTextColor(Color.parseColor("#26ffffff"));
                }
                else if (s.length()>0)
                {
                    flagname=1;
                    if((flagname==1)&&(flagemail==1)&&(flagphone==1)&&(flagpassword==1)&&(flaganswer==1))
                    {
                        reg.setEnabled(true);
                        reg.setBackgroundColor(Color.WHITE);
                        reg.setTextColor(Color.BLACK);
                    }
                }

            }
        });
        email.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after)
            {
                flagemail=0;
                reg.setEnabled(false);
                reg.setBackgroundDrawable(shape);
                reg.setTextColor(Color.parseColor("#26ffffff"));

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count)
            {
                if(s.length()==0)
                {
                    flagemail=0;
                    reg.setEnabled(false);
                    reg.setBackgroundDrawable(shape);
                    reg.setTextColor(Color.parseColor("#26ffffff"));
                }
                else if (s.length()>0)
                {
                    flagemail=1;
                    if((flagname==1)&&(flagemail==1)&&(flagphone==1)&&(flagpassword==1)&&(flaganswer==1))
                    {
                        reg.setEnabled(true);
                        reg.setBackgroundColor(Color.WHITE);
                        reg.setTextColor(Color.BLACK);
                    }
                }

            }

            @Override
            public void afterTextChanged(Editable s)
            {
                if(s.length()==0)
                {
                    flagemail=0;
                    reg.setEnabled(false);
                    reg.setBackgroundDrawable(shape);
                    reg.setTextColor(Color.parseColor("#26ffffff"));
                }
               else if (s.length()>0)
                {
                    flagemail=1;
                    if((flagname==1)&&(flagemail==1)&&(flagphone==1)&&(flagpassword==1)&&(flaganswer==1))
                    {
                        reg.setEnabled(true);
                        reg.setBackgroundColor(Color.WHITE);
                        reg.setTextColor(Color.BLACK);
                    }
                }

            }
        });
        phone.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after)
            {
                flagphone=0;
                reg.setEnabled(false);
                reg.setBackgroundDrawable(shape);
                reg.setTextColor(Color.parseColor("#26ffffff"));

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count)
            {
                if(s.length()==0)
                {
                    flagphone=0;
                    reg.setEnabled(false);
                    reg.setBackgroundDrawable(shape);
                    reg.setTextColor(Color.parseColor("#26ffffff"));
                }
               else if (s.length()>0)
                {
                    flagphone=1;
                    if((flagname==1)&&(flagemail==1)&&(flagphone==1)&&(flagpassword==1)&&(flaganswer==1))
                    {
                        reg.setEnabled(true);
                        reg.setBackgroundColor(Color.WHITE);
                        reg.setTextColor(Color.BLACK);
                    }
                }

            }

            @Override
            public void afterTextChanged(Editable s)
            {
                if(s.length()==0)
                {
                    flagphone=0;
                    reg.setEnabled(false);
                    reg.setBackgroundDrawable(shape);
                    reg.setTextColor(Color.parseColor("#26ffffff"));
                }
               else if (s.length()>0)
                {
                    flagphone=1;
                    if((flagname==1)&&(flagemail==1)&&(flagphone==1)&&(flagpassword==1)&&(flaganswer==1))
                    {
                        reg.setEnabled(true);
                        reg.setBackgroundColor(Color.WHITE);
                        reg.setTextColor(Color.BLACK);
                    }
                }

            }
        });
        password.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after)
            {
                flagpassword=0;
                reg.setEnabled(false);
                reg.setBackgroundDrawable(shape);
                reg.setTextColor(Color.parseColor("#26ffffff"));

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count)
            {
                if(s.length()==0)
                {
                    flagpassword=0;
                    reg.setEnabled(false);
                    reg.setBackgroundDrawable(shape);
                    reg.setTextColor(Color.parseColor("#26ffffff"));
                }
               else if (s.length()>0)
                {
                    flagpassword=1;
                    if((flagname==1)&&(flagemail==1)&&(flagphone==1)&&(flagpassword==1)&&(flaganswer==1))
                    {
                        reg.setEnabled(true);
                        reg.setBackgroundColor(Color.WHITE);
                        reg.setTextColor(Color.BLACK);
                    }
                }

            }

            @Override
            public void afterTextChanged(Editable s)
            {
                if(s.length()==0)
                {
                    flagpassword=0;
                    reg.setEnabled(false);
                    reg.setBackgroundDrawable(shape);
                    reg.setTextColor(Color.parseColor("#26ffffff"));
                }
                else if (s.length()>0)
                {
                    flagpassword=1;
                    if((flagname==1)&&(flagemail==1)&&(flagphone==1)&&(flagpassword==1)&&(flaganswer==1))
                    {
                        reg.setEnabled(true);
                        reg.setBackgroundColor(Color.WHITE);
                        reg.setTextColor(Color.BLACK);
                    }
                }


            }
        });
        answer.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after)
            {
                flaganswer=0;
                reg.setEnabled(false);
                reg.setBackgroundDrawable(shape);
                reg.setTextColor(Color.parseColor("#26ffffff"));

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count)
            {
                if(s.length()==0)
                {
                    flaganswer=0;
                    reg.setEnabled(false);
                    reg.setBackgroundDrawable(shape);
                    reg.setTextColor(Color.parseColor("#26ffffff"));
                }
              else  if (s.length()>0)
                {
                    flaganswer=1;
                    if((flagname==1)&&(flagemail==1)&&(flagphone==1)&&(flagpassword==1)&&(flaganswer==1))
                    {
                        reg.setEnabled(true);
                        reg.setBackgroundColor(Color.WHITE);
                        reg.setTextColor(Color.BLACK);
                    }
                }


            }

            @Override
            public void afterTextChanged(Editable s)
            {
                if(s.length()==0)
                {
                    flaganswer=0;
                    reg.setEnabled(false);
                    reg.setBackgroundDrawable(shape);
                    reg.setTextColor(Color.parseColor("#26ffffff"));
                }
              else  if (s.length()>0)
                {
                    flaganswer=1;
                    if((flagname==1)&&(flagemail==1)&&(flagphone==1)&&(flagpassword==1)&&(flaganswer==1))
                    {
                        reg.setEnabled(true);
                        reg.setBackgroundColor(Color.WHITE);
                        reg.setTextColor(Color.BLACK);
                    }
                }


            }
        });



        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insert();
                Toast.makeText(NewUserRegisterPage.this, "Registration complete", Toast.LENGTH_SHORT).show();

                Intent go=new Intent(getApplicationContext(),Login.class);
                startActivity(go);
                Toast.makeText(NewUserRegisterPage.this, "Please Login with your details to continue", Toast.LENGTH_SHORT).show();
            }
        });


    }
    public void insert()
    {
        names=name.getText().toString();
        emails=email.getText().toString();
        phones=phone.getText().toString();
        passwords=password.getText().toString();
        answers=answer.getText().toString();


       try
       {
           URL url=new URL(localhost);
           HttpURLConnection connection=(HttpURLConnection)url.openConnection();
           connection.setRequestMethod("POST");
           connection.setDoOutput(true);
           OutputStream os=connection.getOutputStream();
           OutputStreamWriter osw=new OutputStreamWriter(os,"UTF-8");
           BufferedWriter bw=new BufferedWriter(osw);
           String query= URLEncoder.encode("zname","UTF-8")+"="+URLEncoder.encode(names,"UTF-8")+
                     "&"+URLEncoder.encode("zmail","UTF-8")+"="+URLEncoder.encode(emails,"UTF-8")+
                   "&"+URLEncoder.encode("zphone","UTF-8")+"="+URLEncoder.encode(phones,"UTF-8")+
                   "&"+URLEncoder.encode("zpassword","UTF-8")+"="+URLEncoder.encode(passwords,"UTF-8")+
                   "&"+URLEncoder.encode("zanswer","UTF-8")+"="+URLEncoder.encode(answers,"UTF-8")+
                   "&"+URLEncoder.encode("zques","UTF-8")+"="+URLEncoder.encode(security,"UTF-8");
           bw.write(query);
           bw.flush();
           bw.close();
           InputStream is=connection.getInputStream();
           connection.connect();
           is.close();

       }
       catch (Exception e)
        {
            Toast.makeText(this, "error is "+e, Toast.LENGTH_SHORT).show();
        }

    }

}

