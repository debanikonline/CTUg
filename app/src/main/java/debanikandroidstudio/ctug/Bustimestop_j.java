package debanikandroidstudio.ctug;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
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

/**
 * Created by debanikmoulick on 03/05/17.
 */

public class Bustimestop_j extends android.support.v4.app.Fragment {
    String routename="ISBT 43 to IT PARK Chd via Railway Station";
    int rid;
    Custommaan adp;
    TextView n, t;
    Button b;
    String stopname[], stoptime[];
    String hosturl = "http://192.168.43.113/CTU/getrouteidgold.php";
    String hosturl2 = "http://192.168.43.113/CTU/getstopnameandtime.php";
    ListView lst;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.bustimestop_x, container, false);
        //String item=getActivity().getIntent().getExtras().getString("routename");
        StrictMode.ThreadPolicy poi=new StrictMode.ThreadPolicy.Builder().build();
        StrictMode.setThreadPolicy(poi);
        lst=(ListView)v.findViewById(R.id.stoplist);


//        Intent img=new Intent();
//
//        routename=img.getStringExtra("routename");
        //Toast.makeText(this, "img wala routename"+routename, Toast.LENGTH_SHORT).show();


        routeid(routename);
        getstopandtime(rid);
        //Toast.makeText(this, "stop name---"+stopname[4]+"stop time ----"+stoptime[4], Toast.LENGTH_SHORT).show();
        adp=new Custommaan(getContext(),stopname,stoptime);
        lst.setAdapter(adp);
        Toast.makeText(getContext(), "rnameeee-"+routename, Toast.LENGTH_SHORT).show();
        return v;
    }
    public void routeid(String routename)
    {
        String line="";
        StringBuilder st=new StringBuilder();
        try
        {
            URL url=new URL(hosturl);
            HttpURLConnection connect=(HttpURLConnection)url.openConnection();
            connect.setRequestMethod("POST");
            connect.setDoOutput(true);
            OutputStream os=connect.getOutputStream();
            OutputStreamWriter osw=new OutputStreamWriter(os,"UTF-8");
            BufferedWriter bw=new BufferedWriter(osw);
            String query= URLEncoder.encode("routename","UTF-8")+"="+URLEncoder.encode(routename,"UTF-8");
            bw.write(query);
            bw.flush();
            bw.close();
            InputStream is=connect.getInputStream();
            InputStreamReader ir=new InputStreamReader(is);
            BufferedReader br=new BufferedReader(ir);
            if(br!=null)
            {
                while((line=br.readLine())!=null)
                {
                    st.append(line+"\n");
                }

            }
            String data=st.toString();
            Toast.makeText(getContext(), data, Toast.LENGTH_SHORT).show();
            JSONObject object=new JSONObject(data);

            rid=object.getInt("routeid");
            Toast.makeText(getContext(), "ye wala"+rid, Toast.LENGTH_SHORT).show();


        }
        catch (Exception e)
        {
            Toast.makeText(getContext(), "error in selecting routeid in stop details -"+e, Toast.LENGTH_SHORT).show();
        }
    }
    public void getstopandtime(int i)

    {
        String line="";
        StringBuilder bob=new StringBuilder();

        try
        {
            URL thisurl=new URL(hosturl2);
            HttpURLConnection thisconnection=(HttpURLConnection)thisurl.openConnection();
            thisconnection.setRequestMethod("POST");
            thisconnection.setDoInput(true);
            OutputStream os=thisconnection.getOutputStream();
            OutputStreamWriter osw=new OutputStreamWriter(os,"UTF-8");
            BufferedWriter bw=new BufferedWriter(osw);
            String query=URLEncoder.encode("routeid","UTF-8")+"="+URLEncoder.encode(i+"","UTF-8");
            bw.write(query);
            bw.flush();
            bw.close();
            InputStream is=thisconnection.getInputStream();
            //thisconnection.connect();
            InputStreamReader isr=new InputStreamReader(is);
            BufferedReader bread=new BufferedReader(isr);
            if(bread!=null)
            {
                while((line=bread.readLine())!=null)
                {
                    bob.append(line+"\n");

                }
                String details=bob.toString();
                JSONArray array=new JSONArray(details);
                JSONObject object=null;
                stopname=new String[array.length()];
                stoptime=new String[array.length()];
                for(int z=0;z<array.length();z++)
                {
                    object=array.getJSONObject(z);
                    stopname[z]=object.getString("stopname");
                    stoptime[z]=object.getString("stoptime");


                }
                Toast.makeText(getContext(), "stopname lenght-"+stopname.length, Toast.LENGTH_SHORT).show();
//                Toast.makeText(this, stopname[1], Toast.LENGTH_SHORT).show();
//                Toast.makeText(this, stopname[2], Toast.LENGTH_SHORT).show();
//                Toast.makeText(this, stopname[3], Toast.LENGTH_SHORT).show();
//                Toast.makeText(this, stopname[4], Toast.LENGTH_SHORT).show();
//                Toast.makeText(this, stopname[5], Toast.LENGTH_SHORT).show();
//                Toast.makeText(this, "array lenght-"+array.length(), Toast.LENGTH_SHORT).show();

            }

            is.close();




        }
        catch (Exception e)
        {
            Toast.makeText(getContext(), "error in getstopandtime method -"+e, Toast.LENGTH_SHORT).show();
        }


    }
    public class Custommaan extends BaseAdapter
    {

        String busstopname[];
        String busstoptime[];
        Context ctx;
        LayoutInflater lay;

        public Custommaan( Context ctx,String[] busstopname,String[] busstoptime) {
            this.busstopname = busstopname;
            this.busstoptime = busstoptime;
            this.ctx = ctx;
            lay = (LayoutInflater.from(ctx));
        }





        @Override
        public int getCount() {
            return busstopname.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent)
        {

            convertView=lay.inflate(R.layout.content_list_stopname_stoptime,null);
            TextView name=(TextView)convertView.findViewById(R.id.busstopnameTEXTVIEW);
            TextView time=(TextView)convertView.findViewById(R.id.busstoptimeTEXTVIEW);

//            name.setText(""+busstopname[position]);
            name.setText(""+busstopname[position]);
            time.setText(""+busstoptime[position]);
            // Toast.makeText(ctx, "bbbb--"+busstopname[position], Toast.LENGTH_SHORT).show();
            return convertView;
        }
    }
}

