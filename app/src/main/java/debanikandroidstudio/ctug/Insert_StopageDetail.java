package debanikandroidstudio.ctug;

import android.graphics.Color;
import android.graphics.Typeface;
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
import java.util.ArrayList;
import java.util.List;

public class Insert_StopageDetail extends AppCompatActivity
{
    TextView t,select;
    Spinner stopspin;
    EditText enterstop,entertime;
    Button save;
    List routelist;
    int routeid;
    Typeface ty;
    int flag=0,flag2=0;
    String selectedroute;
    String hosturl="http://192.168.43.113/CTU/selectroute.php";
    String hosturl1="http://192.168.43.113/CTU/selectrouteid.php";
    String hosturl2="http://192.168.43.113/CTU/insertroutestop.php";
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_stopage);
        StrictMode.ThreadPolicy threadPolicy = new StrictMode.ThreadPolicy.Builder().build();
        StrictMode.setThreadPolicy(threadPolicy);
        t=(TextView)findViewById(R.id.trytext);
        stopspin=(Spinner)findViewById(R.id.select_spinner);
        enterstop=(EditText)findViewById(R.id.stopagenameID);
        select=(TextView)findViewById(R.id.selectstopage_text);
        ty=Typeface.createFromAsset(getAssets(),"fonts/debu.ttf");
        select.setTypeface(ty);
        entertime=(EditText)findViewById(R.id.stopagetimeID);
        routelist=selectroute();
       // Toast.makeText(getApplicationContext(),""+routelist,Toast.LENGTH_LONG).show();
        ArrayAdapter<String> adp=new ArrayAdapter<String>(getApplicationContext(),R.layout.support_simple_spinner_dropdown_item,routelist);
        adp.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        stopspin.setAdapter(adp);

        stopspin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selectedroute=stopspin.getSelectedItem().toString();
                selectrouteid(selectedroute);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        save=(Button)findViewById(R.id.enterstopagebuttonID);
        save.setEnabled(false);

        enterstop.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after)
            {
                flag=0;
                save.setEnabled(false);
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count)
            {
                if(s.length()>0)
                {
                    flag=1;
                    if((flag==1)&&(flag2==1))
                    {
                        save.setEnabled(true);
                        save.setBackgroundColor(Color.WHITE);
                    }
                }
                else if (s.length()==0)
                {
                    flag=0;
                    save.setEnabled(false);
                    save.setBackgroundColor(Color.TRANSPARENT);
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
                        save.setEnabled(true);
                        save.setBackgroundColor(Color.WHITE);
                    }
                }
                else if (s.length()==0)
                {
                    flag=0;
                    save.setEnabled(false);
                    save.setBackgroundColor(Color.TRANSPARENT);
                }

            }
        });

        entertime.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after)
            {
                flag2=0;
                save.setEnabled(false);

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count)
            {
                if(s.length()>0)
                {
                    flag2=1;
                    if((flag2==1)&&(flag==1))
                    {
                        save.setEnabled(true);
                        save.setBackgroundColor(Color.WHITE);
                    }
                }
                else if (s.length()==0)
                {
                    flag2=0;
                    save.setEnabled(false);
                    save.setBackgroundColor(Color.TRANSPARENT);
                }

            }



            @Override
            public void afterTextChanged(Editable s)
            {
                if(s.length()>0)
            {
                flag2=1;
                if((flag2==1)&&(flag==1))
                {
                    save.setEnabled(true);
                    save.setBackgroundColor(Color.WHITE);
                }
            }
            else if (s.length()==0)
            {
                flag2=0;
                save.setEnabled(false);
                save.setBackgroundColor(Color.TRANSPARENT);
            }

            }
        });
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                saveroutestopdetails();
                Toast.makeText(getApplicationContext(),"Data Inserted successfully",Toast.LENGTH_SHORT).show();
                enterstop.setText("");
                entertime.setText("");
            }
        });


    }
    public List<String> selectroute()
    {
        String line="";
        StringBuilder stringBuilder=new StringBuilder();
        ArrayList<String>list=new ArrayList<>();
        try
        {
            URL url=new URL(hosturl);
            HttpURLConnection connection=(HttpURLConnection)url.openConnection();
            //Toast.makeText(getApplicationContext(),"connection ok",Toast.LENGTH_LONG).show();
            connection.setRequestMethod("POST");
            connection.setDoOutput(true);
            InputStream is=connection.getInputStream();
            connection.connect();
            InputStreamReader isr=new InputStreamReader(is);
            BufferedReader br=new BufferedReader(isr);
            if(br!=null)
            {
                while((line=br.readLine())!=null)
                {
                    stringBuilder.append(line+"\n");
                }
            }
            String data=stringBuilder.toString();
            //Toast.makeText(getApplicationContext(),""+data,Toast.LENGTH_LONG).show();
            JSONArray jsonarray=new JSONArray(data);
            JSONObject jsonobject=null;
            //routearray=new String[jsonarray.length()];
            for(int i=0;i<jsonarray.length();i++)
            {
                jsonobject=jsonarray.getJSONObject(i);
                String detail=jsonobject.getString("routename");

                list.add(i,detail);
                //routearray[i]=detail;
            }




        }
        catch (Exception e)
        {
            Toast.makeText(this," "+e, Toast.LENGTH_LONG).show();

        }
        return list;
    }
    public void selectrouteid(String selectedroute)
    {
        String line1="";
        StringBuilder stringBuilder1=new StringBuilder();
        try
        {
            URL url=new URL(hosturl1);
            HttpURLConnection connection=(HttpURLConnection)url.openConnection();
            connection.setRequestMethod("POST");
            connection.setDoOutput(true);
            OutputStream os=connection.getOutputStream();
            OutputStreamWriter osw=new OutputStreamWriter(os,"UTF-8");
            BufferedWriter br=new BufferedWriter(osw);
            String query= URLEncoder.encode("routename","UTF-8")+"="+URLEncoder.encode(selectedroute,"UTF-8");
            br.write(query);
            br.flush();
            br.close();
            InputStream is=connection.getInputStream();
            InputStreamReader isr=new InputStreamReader(is);
            BufferedReader br1=new BufferedReader(isr);
            if(br1 !=null)
            {
                while((line1=br1.readLine())!=null)
                {
                   stringBuilder1.append(line1+"\n");
                }
            }
            String data1=stringBuilder1.toString();
           // Toast.makeText(getApplicationContext(),data1,Toast.LENGTH_SHORT).show();
            JSONObject object1=new JSONObject(data1);
            routeid=object1.getInt("routeid");
          //  Toast.makeText(this, "this is the route id : " + routeid, Toast.LENGTH_LONG).show();

        }
        catch (Exception e)
        {
            Toast.makeText(this, " " + e, Toast.LENGTH_LONG).show();
        }


    }
   public void saveroutestopdetails()
   {
       //enterstopname
       //enterstoptime
       //routeid
       String stopname=enterstop.getText().toString();
       String stoptime=entertime.getText().toString();
        int g=routeid;

        try
        {
            URL url=new URL(hosturl2);
            HttpURLConnection connection=(HttpURLConnection)url.openConnection();
            connection.setRequestMethod("POST");
            connection.setDoOutput(true);
            OutputStream os=connection.getOutputStream();
            OutputStreamWriter osw=new OutputStreamWriter(os,"UTF-8");
            BufferedWriter br=new BufferedWriter(osw);
            String query=URLEncoder.encode("stopname","UTF-8")+"="+URLEncoder.encode(stopname,"UTF-8")+"&"
                    +URLEncoder.encode("stoptime","UTF-8")+"="+URLEncoder.encode(stoptime,"UTF-8")+"&"
                    +URLEncoder.encode("routeid","UTF-8")+"="+URLEncoder.encode(""+routeid,"UTF-8");
            br.write(query);
            br.flush();
            br.close();
            InputStream is=connection.getInputStream();
            connection.connect();
            is.close();

        }
        catch(Exception e)
        {

        }

   }
}
