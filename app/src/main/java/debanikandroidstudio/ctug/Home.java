package debanikandroidstudio.ctug;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by debanikmoulick on 19/04/17.
 */

public class Home extends android.support.v4.app.Fragment
{
    Button search;
    AutoCompleteTextView from,to;
    String hosturl="http://192.168.43.113/CTU/selectroute_AUTO.php";
    List routes;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        View v1=inflater.inflate(R.layout.home,container,false);
        StrictMode.ThreadPolicy threadPolicy=new StrictMode.ThreadPolicy.Builder().build();
        StrictMode.setThreadPolicy(threadPolicy);
        search=(Button)v1.findViewById(R.id.search_buttonID);
        search.setEnabled(false);
       // from=(AutoCompleteTextView)getView().findViewById(R.id.busfrom_textID_AUTO);
            from=(AutoCompleteTextView)v1.findViewById(R.id.busfrom_textID_AUTO);

            routes=selectroute();

            ArrayList lst=new ArrayList();
        lst.add(routes);

        ArrayAdapter adp=new ArrayAdapter(getContext(),R.layout.support_simple_spinner_dropdown_item,routes);
        adp.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        from.setAdapter(adp);

        from.setThreshold(1);

        from.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after)
            {
                search.setEnabled(false);

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s)
            {
                if (s.length()<=0)
                {
                    search.setEnabled(false);
                }
                else if(s.length()>0)
                {
                    search.setEnabled(true);
                    search.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v)
                        {

                            String a=from.getText().toString();

                            Intent i=new Intent(getContext(),Search_Result_Activity.class);
                            i.putExtra("a",a);
                           // Toast.makeText(getContext(), "transfer- "+a, Toast.LENGTH_SHORT).show();
                            startActivity(i);
                        }
                    });

                }

            }
        });


        return v1;

    }

    public List<String> selectroute()
    {
        String line="";
        StringBuilder stringBuilder=new StringBuilder();
        ArrayList<String> list=new ArrayList<>();
        try
        {
            URL url=new URL(hosturl);
            HttpURLConnection connection=(HttpURLConnection)url.openConnection();
           // Toast.makeText(getContext(),"connection ok",Toast.LENGTH_LONG).show();
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
           // Toast.makeText(getContext(),""+data,Toast.LENGTH_LONG).show();
            JSONArray jsonarray=new JSONArray(data);
            JSONObject jsonobject=null;

            for(int i=0;i<jsonarray.length();i++)
            {
                jsonobject=jsonarray.getJSONObject(i);
                String detail=jsonobject.getString("stopname");

                list.add(i,detail);

            }




        }
        catch (Exception e)
        {
            Toast.makeText(getContext(), ""+e, Toast.LENGTH_SHORT).show();

        }
        return list;
    }

}
