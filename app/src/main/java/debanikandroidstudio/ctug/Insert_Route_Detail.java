package debanikandroidstudio.ctug;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class Insert_Route_Detail extends AppCompatActivity
{
    EditText routename,start,stop,starttime,stoptime;
    Button save;
    Typeface ty;
    TextView title;
    int flagname=0,flagstart=0,flagstop=0,flagstarttime=0,flagstoptime=0;
    String hosturl="http://192.168.43.113/CTU/insertroutedetailsfromadmin.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_route_detail);
        StrictMode.ThreadPolicy threadPolicy = new StrictMode.ThreadPolicy.Builder().build();
        StrictMode.setThreadPolicy(threadPolicy);
        routename=(EditText)findViewById(R.id.routenameID);
        start=(EditText)findViewById(R.id.startID);
        stop=(EditText)findViewById(R.id.stopID);
        title=(TextView)findViewById(R.id.textView11);
        ty=Typeface.createFromAsset(getAssets(),"fonts/debu.ttf");
        title.setTypeface(ty);
        starttime=(EditText)findViewById(R.id.starttimeID);
        stoptime=(EditText)findViewById(R.id.stoptimeid);
        save=(Button)findViewById(R.id.SaveRouteButton);
        save.setEnabled(false);
        routename.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after)
            {
                flagname=0;

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count)
            {

                if(s.length()>0)
                {
                    flagname=1;
                    if((flagname==1)&&(flagstart==1)&&(flagstop==1)&&(flagstarttime==1)&&(flagstoptime==1))
                    {
                        save.setEnabled(true);
                        save.setBackgroundColor(Color.WHITE);
                    }
                }
                else if(s.length()==0)
                {
                    save.setEnabled(false);
                    save.setBackgroundColor(Color.TRANSPARENT);
                }

            }

            @Override
            public void afterTextChanged(Editable s)
            {
                if(s.length()>0)
                {
                    flagname=1;
                    if((flagname==1)&&(flagstart==1)&&(flagstop==1)&&(flagstarttime==1)&&(flagstoptime==1))
                    {
                        save.setEnabled(true);
                        save.setBackgroundColor(Color.WHITE);
                    }
                }
                else if(s.length()==0)
                {
                    save.setEnabled(false);
                    save.setBackgroundColor(Color.TRANSPARENT);
                }

            }
        });
        start.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after)
            {
                flagstart=0;

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count)
            {

                if(s.length()>0)
                {
                    flagstart=1;

                    if((flagstart==1)&&(flagname==1)&&(flagstop==1)&&(flagstarttime==1)&&(flagstoptime==1))
                    {
                        save.setEnabled(true);
                        save.setBackgroundColor(Color.WHITE);
                    }
                }
                else if(s.length()==0)
                {
                    save.setEnabled(false);
                    save.setBackgroundColor(Color.TRANSPARENT);
                }

            }

            @Override
            public void afterTextChanged(Editable s)
            {

                if(s.length()>0)
                {
                    flagstart=1;

                    if((flagstart==1)&&(flagname==1)&&(flagstop==1)&&(flagstarttime==1)&&(flagstoptime==1))
                    {
                        save.setEnabled(true);
                        save.setBackgroundColor(Color.WHITE);
                    }
                }
                else if(s.length()==0)
                {
                    save.setEnabled(false);
                    save.setBackgroundColor(Color.TRANSPARENT);
                }

            }
        });
        stop.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after)
            {
                flagstop=0;

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count)
            {
                if(s.length()>0)
                {
                    flagstop=1;

                    if((flagstop==1)&&(flagstart==1)&&(flagname==1)&&(flagstarttime==1)&&(flagstoptime==1))
                    {
                        save.setEnabled(true);
                        save.setBackgroundColor(Color.WHITE);
                    }
                }
                else if(s.length()==0)
                {
                    save.setEnabled(false);
                    save.setBackgroundColor(Color.TRANSPARENT);
                }
            }

            @Override
            public void afterTextChanged(Editable s)
            {
                if(s.length()>0)
                {
                    flagstop=1;

                    if((flagstop==1)&&(flagstart==1)&&(flagname==1)&&(flagstarttime==1)&&(flagstoptime==1))
                    {
                        save.setEnabled(true);
                        save.setBackgroundColor(Color.WHITE);
                    }
                }
                else if(s.length()==0)
                {
                    save.setEnabled(false);
                    save.setBackgroundColor(Color.TRANSPARENT);
                }

            }
        });
        starttime.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after)
            {
                flagstarttime=0;

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count)
            {
                if(s.length()>0)
                {
                    flagstarttime=1;

                    if((flagstarttime==1)&&(flagstart==1)&&(flagstop==1)&&(flagname==1)&&(flagstoptime==1))
                    {
                        save.setEnabled(true);
                        save.setBackgroundColor(Color.WHITE);
                    }
                }
                else if(s.length()==0)
                {
                    save.setEnabled(false);
                    save.setBackgroundColor(Color.TRANSPARENT);
                }

            }

            @Override
            public void afterTextChanged(Editable s)
            {
                if(s.length()>0)
                {
                    flagstarttime=1;

                    if((flagstarttime==1)&&(flagstart==1)&&(flagstop==1)&&(flagname==1)&&(flagstoptime==1))
                    {
                        save.setEnabled(true);
                        save.setBackgroundColor(Color.WHITE);
                    }
                }
                else if(s.length()==0)
                {
                    save.setEnabled(false);
                    save.setBackgroundColor(Color.TRANSPARENT);
                }

            }
        });
        stoptime.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after)
            {
                flagstoptime=0;
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count)
            {
                if(s.length()>0)
                {
                    flagstoptime=1;

                    if((flagstoptime==1)&&(flagstart==1)&&(flagstop==1)&&(flagstarttime==1)&&(flagname==1))
                    {
                        save.setEnabled(true);
                        save.setBackgroundColor(Color.WHITE);
                    }
                }
                else if(s.length()==0)
                {
                    save.setEnabled(false);
                    save.setBackgroundColor(Color.TRANSPARENT);
                }


            }

            @Override
            public void afterTextChanged(Editable s)
            {
                if(s.length()>0)
                {
                    flagstoptime=1;

                    if((flagstoptime==1)&&(flagstart==1)&&(flagstop==1)&&(flagstarttime==1)&&(flagname==1))
                    {
                        save.setEnabled(true);
                        save.setBackgroundColor(Color.WHITE);
                    }
                }
                else if(s.length()==0)
                {
                    save.setEnabled(false);
                    save.setBackgroundColor(Color.TRANSPARENT);
                }

            }
        });
        save.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                insert();
                Toast.makeText(getApplicationContext(),"Details Saved",Toast.LENGTH_LONG).show();
                routename.setText("");
                start.setText("");
                stop.setText("");
                starttime.setText("");
                stoptime.setText("");

            }
        });

    }
    public void insert()
    {
        String goname,gostart,gostop,gostarttime,gostoptime;
        goname=routename.getText().toString();
        gostart=start.getText().toString();
        gostop=stop.getText().toString();
        gostarttime=starttime.getText().toString();
        gostoptime=stoptime.getText().toString();
       // Toast.makeText(this, gostarttime+gostoptime, Toast.LENGTH_SHORT).show();

        try
        {

            URL url = new URL(hosturl);
            HttpURLConnection connection=(HttpURLConnection)url.openConnection();
            connection.setRequestMethod("POST");
            connection.setDoOutput(true);
            OutputStream os=connection.getOutputStream();
            OutputStreamWriter osw=new OutputStreamWriter(os,"UTF-8");
            BufferedWriter bw=new BufferedWriter(osw);
            String query= URLEncoder.encode("routename","UTF-8")+"="+URLEncoder.encode(goname,"UTF-8")
                    +"&"+URLEncoder.encode("start","UTF-8")+"="+URLEncoder.encode(gostart,"UTF-8")
                    +"&"+URLEncoder.encode("stop","UTF-8")+"="+URLEncoder.encode(gostop,"UTF-8")
                    +"&"+URLEncoder.encode("this","UTF-8")+"="+URLEncoder.encode(gostarttime,"UTF-8")
                    +"&"+URLEncoder.encode("that","UTF-8")+"="+URLEncoder.encode(gostoptime,"UTF-8");
            bw.write(query);
            bw.flush();
            bw.close();
            InputStream is=connection.getInputStream();
            connection.connect();
            is.close();
        }
        catch (Exception e)
        {
            Toast.makeText(getApplicationContext(),""+e,Toast.LENGTH_SHORT).show();

        }

    }
}
