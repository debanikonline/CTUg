package debanikandroidstudio.ctug;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
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

public class Search_Result_Activity extends AppCompatActivity
{
    String a;
    ListView lst;
    Button back;
    String listdetails[];
    TextView msg;
    Typeface ty;
    String hosturl2="http://192.168.43.113/CTU/searchresult.php";
    String query="SELECT DISTINCT busno from allotbus RIGHT OUTER JOIN stopage_detail on allotbus.routeid=stopage_detail.routeid where stopage_detail.stopname ='mansa devi'";
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_result);
        back=(Button)findViewById(R.id.button2);
        msg=(TextView)findViewById(R.id.textView15);
        a=getIntent().getStringExtra("a");

        lst=(ListView)findViewById(R.id.search_busnumber_list_ID);
        load(a);
        ArrayAdapter adp=new ArrayAdapter(this,R.layout.support_simple_spinner_dropdown_item,listdetails);
        lst.setAdapter(adp);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(),WelcomeUSER_Navi.class);
                startActivity(i);
            }
        });
        msg.setText("These Busses will lead you to ->"+a+"\n"+" Select a bus to know the stopage details!");
        msg.setTypeface(null,Typeface.ITALIC);
        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selected=listdetails[position].toString();
                Toast.makeText(Search_Result_Activity.this, "you selected bus route - "+selected, Toast.LENGTH_SHORT).show();
                Intent i=new Intent(getApplicationContext(),Showroute_search.class);
                i.putExtra("selected",selected);
                startActivity(i);
            }
        });

    }
    public  void load(String data)
    {
        String line="";
        StringBuilder bob=new StringBuilder();
        try
        {
            URL u=new URL(hosturl2);
            HttpURLConnection co=(HttpURLConnection)u.openConnection();
            co.setRequestMethod("POST");
            co.setDoOutput(true);
            OutputStream os=co.getOutputStream();
            OutputStreamWriter ows=new OutputStreamWriter(os,"UTF-8");
            BufferedWriter bw=new BufferedWriter(ows);
            String q= URLEncoder.encode("name","UTF-8")+"="+URLEncoder.encode(data,"UTF-8");
            bw.write(q);
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
                String bigdata=bob.toString();
                JSONArray array=new JSONArray(bigdata);
                JSONObject object=null;
                listdetails=new String[array.length()];
                for(int i=0;i<array.length();i++)
                {
                    object=array.getJSONObject(i);
                    listdetails[i]=object.getString("busno");
                }
            }



        }
        catch (Exception e)
        {

        }
    }

}
