package debanikandroidstudio.ctug;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by debanikmoulick on 03/05/17.
 */

public class Routes_j extends android.support.v4.app.Fragment
{
    ListView lst;
    String rname[];
    String routename[];
    TextView txtu,txtp;
    CustomAdaptorr adp;
    String updatename="";
    private ViewPager pager;
    String updatepassword="";
    TabLayout tabLayout;
    static String data="";
    private String[] pageTitle = {"SEARCH", "ROUTES", "BUS TIME/\nSTOPS"};
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.routes_x,container,false);

        StrictMode.ThreadPolicy policy=new StrictMode.ThreadPolicy.Builder().build();
        StrictMode.setThreadPolicy(policy);
        show();
        lst = (ListView)v.findViewById(R.id.listview);
        adp=new CustomAdaptorr(getContext(),rname);
        lst.setAdapter(adp);
        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                data=rname[position].toString();
                pager=(ViewPager)getActivity().findViewById(R.id.view_pager);
           Toast.makeText(getContext(),"data"+data,Toast.LENGTH_LONG).show();
                pager=(ViewPager)getActivity().findViewById(R.id.view_pager);
                ViewPagerAdapter adp=new ViewPagerAdapter(getActivity().getSupportFragmentManager());

                pager.setAdapter(adp);
                pager.setCurrentItem(2);
//                Bundle b=new Bundle();
//                b.putString("rambo",data);
//                Intent trial=new Intent(getActivity(),Bustimestop_j.class);
//
//                trial.putExtra("ramboji",b);




            }
        });
        return v;
    }
    public void show() {
        String line = "";
        String details = "";
        StringBuilder stringb = new StringBuilder();
        String hosturl = "http://192.168.43.113/CTU/routenamegold.php";
        try {
            URL url = new URL(hosturl);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("POST");
            con.setDoOutput(true);
            Toast.makeText(getContext(), "connection established", Toast.LENGTH_SHORT).show();
            InputStream inptstrm = con.getInputStream();
            InputStreamReader inptstrmrdr = new InputStreamReader(inptstrm);
            BufferedReader bfr = new BufferedReader(inptstrmrdr);
            if (bfr != null) {
                while ((line = bfr.readLine()) != null) {
                    stringb.append(line + "\n");
                }
                details = stringb.toString();
                //Toast.makeText(this,""+details,Toast.LENGTH_LONG).show();
                JSONObject object = null;
                JSONArray array = new JSONArray(details);
                rname = new String[array.length()];

                for (int i = 0; i < array.length(); i++) {
                    object = array.getJSONObject(i);
                    rname[i] = object.getString("routename");



                }


            }

        } catch (Exception e) {
            Toast.makeText(getContext(), "" + e, Toast.LENGTH_LONG).show();

        }

    }
    public class CustomAdaptorr extends BaseAdapter
    {
        String routenames[];

        Context ctx;
        LayoutInflater lyinfltr;

        public CustomAdaptorr(Context ctx,String[] routenames)
        {
            this.routenames = routenames;

            this.ctx = ctx;
            lyinfltr=(LayoutInflater.from(ctx));
        }

        @Override
        public int getCount() {
            return routenames.length;
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
        public View getView(int position, View convertView, ViewGroup parent) {
            convertView=lyinfltr.inflate(R.layout.content_list_textviews,null);
            txtu=(TextView)convertView.findViewById(R.id.item1);

            txtu.setText(""+routenames[position]);

            return convertView;
        }
    }
}

