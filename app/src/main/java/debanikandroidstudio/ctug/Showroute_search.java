package debanikandroidstudio.ctug;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.List;

public class Showroute_search extends AppCompatActivity {

    String numb;
    ListView lst;
    TextView text;
    String routes[];
    Button final_back;
    Typeface ty;
    String hosturl2="http://192.168.43.113/CTU/finalshowroute.php";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_showroute_search);
        text=(TextView)findViewById(R.id.textView_final);


        numb=getIntent().getStringExtra("selected");
        text.setText("Following are the details for Bus #"+numb);
        ty=Typeface.createFromAsset(getAssets(),"fonts/debu.ttf");
        text.setTypeface(ty);
        //Toast.makeText(this, "le"+numb, Toast.LENGTH_SHORT).show();
        lst=(ListView)findViewById(R.id.showroute__list_layout_final);

        load(numb);
        //Toast.makeText(this, "ff"+routes[0]+" "+routes[1], Toast.LENGTH_SHORT).show();
        ArrayAdapter adp=new ArrayAdapter(this,R.layout.support_simple_spinner_dropdown_item,routes);
        lst.setAdapter(adp);

    }
    public void load(String data)
    {
        String line="";
        StringBuilder bob=new StringBuilder();
        try
        {
            URL u=new URL(hosturl2);
            HttpURLConnection co=(HttpURLConnection)u.openConnection();
            co.setRequestMethod("POST");
            co.setDoInput(true);
            OutputStream os=co.getOutputStream();
            OutputStreamWriter osw=new OutputStreamWriter(os,"UTF-8");
            BufferedWriter bw=new BufferedWriter(osw);
            String query= URLEncoder.encode("numb","UTF-8")+"="+URLEncoder.encode(data,"UTF-8");
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
                String details=bob.toString();
                JSONArray array=new JSONArray(details);
                JSONObject object=null;
                routes=new String[array.length()];
                for(int i=0;i<array.length();i++)
                {
                    object=array.getJSONObject(i);
                    routes[i]=object.getString("stopname");
                }
            }


        }
        catch (Exception e)
        {

        }

    }

    @Override
    public void onBackPressed() {
        Intent i =new Intent(getApplicationContext(),WelcomeUSER_Navi.class);
        startActivity(i);
    }
}
