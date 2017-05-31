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

public class Insert_Allot_Bus extends AppCompatActivity
{
    Spinner route;
    EditText busno;
    Button allotbutton;
    List routename;
    String fetchid;
    int busrouteid;
    TextView title;
    Typeface ty;
    String hosturl="http://192.168.43.113/CTU/selectroute.php";
    String hosturl1="http://192.168.43.113/CTU/selectrouteid.php";
    String hosturl2="http://192.168.43.113/CTU/allotbus.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert__allot__bus);
        StrictMode.ThreadPolicy threadPolicy=new StrictMode.ThreadPolicy.Builder().build();
        StrictMode.setThreadPolicy(threadPolicy);
        busno=(EditText)findViewById(R.id.AllotTextID);
        title=(TextView)findViewById(R.id.textView5_allot);
        ty=Typeface.createFromAsset(getAssets(),"fonts/debu.ttf");
        title.setTypeface(ty);

        busno.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after)
            {
                allotbutton.setEnabled(false);

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count)
            {
                if(s.length()>0)
                {
                    allotbutton.setEnabled(true);
                    allotbutton.setBackgroundColor(Color.WHITE);
                }
                else if(s.length()==0)
                {
                    allotbutton.setEnabled(false);
                    allotbutton.setBackgroundColor(Color.TRANSPARENT);
                }

            }

            @Override
            public void afterTextChanged(Editable s)
            {
                if(s.length()>0)
                {
                    allotbutton.setEnabled(true);
                    allotbutton.setBackgroundColor(Color.WHITE);
                }
                else if(s.length()==0)
                {
                    allotbutton.setEnabled(false);
                    allotbutton.setBackgroundColor(Color.TRANSPARENT);
                }

            }
        });
        allotbutton=(Button)findViewById(R.id.allotbutnID);
        allotbutton.setEnabled(false);
        route=(Spinner)findViewById(R.id.allotspin);
        routename=routedetials();
        ArrayAdapter<String>adp=new ArrayAdapter<String>(getApplicationContext(),R.layout.support_simple_spinner_dropdown_item,routename);
        adp.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        route.setAdapter(adp);
        route.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
            {
                fetchid=route.getSelectedItem().toString();
                getrouteid(fetchid);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        allotbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                allotbus();
                Toast.makeText(Insert_Allot_Bus.this, "Data Inserted", Toast.LENGTH_SHORT).show();
                busno.setText("");



            }
        });



    }
    public List<String> routedetials()
    {
        String line="";
        StringBuilder bob=new StringBuilder();
        ArrayList<String>lst=new ArrayList<>();
        try
        {
            URL url=new URL(hosturl);
            HttpURLConnection connection=(HttpURLConnection)url.openConnection();
            connection.setRequestMethod("POST");
            connection.setDoOutput(true);
            InputStream is=connection.getInputStream();
            connection.connect();
            InputStreamReader ir=new InputStreamReader(is);
            BufferedReader br=new BufferedReader(ir);
            if(br!=null)
            {
                while((line=br.readLine())!=null)
                {
                    bob.append(line+"\n");
                }
                String data=bob.toString();
                JSONArray jsonArray=new JSONArray(data);
                JSONObject jsonObject=null;
                for(int i=0;i<jsonArray.length();i++)
                {
                    jsonObject=jsonArray.getJSONObject(i);
                    String detail=jsonObject.getString("routename");
                    lst.add(detail);
                }
            }

        }
        catch (Exception e)
        {

        }
        return lst;
    }
    public void getrouteid(String fetchid)
    {
        String line1="";
        StringBuilder bob2=new StringBuilder();

        try
        {
            URL url=new URL(hosturl1);
            HttpURLConnection connection=(HttpURLConnection)url.openConnection();
            connection.setRequestMethod("POST");
            connection.setDoOutput(true);
            OutputStream os=connection.getOutputStream();
            OutputStreamWriter osw=new OutputStreamWriter(os,"UTF-8");
            BufferedWriter br12=new BufferedWriter(osw);
            String query= URLEncoder.encode("routename","UTF-8")+"="+URLEncoder.encode(fetchid,"UTF-8");
            br12.write(query);
            br12.flush();
            br12.close();
            InputStream is=connection.getInputStream();
            connection.connect();
            InputStreamReader isr1=new InputStreamReader(is);
            BufferedReader br1=new BufferedReader(isr1);
            if(br1!=null)
            {
                while((line1=br1.readLine())!=null)
                {
                    bob2.append(line1+"\n");
                }
            }
            String details2=bob2.toString();
            JSONObject jsonObject=new JSONObject(details2);
            busrouteid=jsonObject.getInt("routeid");
           // Toast.makeText(this, ""+busrouteid, Toast.LENGTH_SHORT).show();


        }
        catch(Exception e)
        {
            Toast.makeText(this, ""+e, Toast.LENGTH_SHORT).show();
        }
    }
    public  void allotbus()
    {
        String number=busno.getText().toString();
        try
        {
            URL url=new URL(hosturl2);
            HttpURLConnection connection3=(HttpURLConnection)url.openConnection();
            connection3.setRequestMethod("POST");
            connection3.setDoOutput(true);
            OutputStream os=connection3.getOutputStream();
            OutputStreamWriter osw=new OutputStreamWriter(os,"UTF-8");
            BufferedWriter br3=new BufferedWriter(osw);
            String query3=URLEncoder.encode("busno","UTF-8")+"="+URLEncoder.encode(number,"UTF-8")
                    +"&"+URLEncoder.encode("routeid","UTF-8")+"="+URLEncoder.encode(""+busrouteid,"UTF-8");
            br3.write(query3);
            br3.flush();
            br3.close();
            InputStream is=connection3.getInputStream();
            connection3.connect();
            is.close();

        }
        catch(Exception e)
        {
            Toast.makeText(this, ""+e, Toast.LENGTH_SHORT).show();

        }
    }
}
