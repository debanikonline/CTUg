package debanikandroidstudio.ctug;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.StrictMode;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.StringBuilderPrinter;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;
import org.w3c.dom.Text;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;

import javax.net.ssl.HttpsURLConnection;

public class ViewDetails extends AppCompatActivity
{

    ListView lst;
    String u[];
    String p[];
    TextView txtu,txtp;
    CustomAdaptorr adp;
    String updatename="";
    String updatepassword="";
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_details);
        StrictMode.ThreadPolicy threadPolicy=new StrictMode.ThreadPolicy.Builder().build();
        StrictMode.setThreadPolicy(threadPolicy);

            lst = (ListView) findViewById(R.id.mylist);
        View vs= getLayoutInflater().inflate(R.layout.admin_header_list,null);
        lst.addHeaderView(vs);
            show();

            adp = new CustomAdaptorr(getApplicationContext(), u, p);


            lst.setAdapter(adp);

            lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id)
                {

                        TextView updatethisname = (TextView) view.findViewById(R.id.listtextviewusername);
                        updatename = updatethisname.getText().toString();
                        TextView updatethispassword = (TextView) view.findViewById(R.id.listtextviewpassword);
                        updatepassword = updatethispassword.getText().toString();
                        //Toast.makeText(getApplicationContext(), "" + updatename + "" + updatepassword, Toast.LENGTH_SHORT).show();
                        Dbox();

                }
            });
        }

    public void Dbox()
    {
        AlertDialog.Builder box= new AlertDialog.Builder(this);
        box.setMessage("Do you want to edit the select data from database?");
        box.setTitle("Confirmation");
        box.setCancelable(true);
        //box.setPositiveButton("Proceed", new DialogInterface
        box.setPositiveButton("Proceed", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which)
            {
                Intent gotoAdminEditor=new Intent(getApplicationContext(),AdminEditor.class);
                gotoAdminEditor.putExtra("uname",updatename);
                gotoAdminEditor.putExtra("pass",updatepassword);
                startActivity(gotoAdminEditor);

            }
        });
        box.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which)
            {
                dialog.cancel();
            }
        });
        AlertDialog dialog=box.create();
        dialog.show();
    }
    public void show()
    {
        String line="";
        String details="";
        StringBuilder stringb=new StringBuilder();
        String hosturl="http://192.168.43.113/CTU/show.php";
        try
        {
            URL url=new URL(hosturl);
            HttpURLConnection con=(HttpURLConnection)url.openConnection();
            con.setRequestMethod("POST");
            con.setDoOutput(true);
           // Toast.makeText(getApplicationContext(),"connection established",Toast.LENGTH_SHORT).show();
            InputStream inptstrm=con.getInputStream();
            InputStreamReader inptstrmrdr=new InputStreamReader(inptstrm);
            BufferedReader bfr=new BufferedReader(inptstrmrdr);
            if(bfr!=null)
            {
                while((line=bfr.readLine())!=null)
                {
                    stringb.append(line+"\n");
                }
                details=stringb.toString();
                //Toast.makeText(this,""+details,Toast.LENGTH_LONG).show();
                JSONObject object=null;
                JSONArray array=new JSONArray(details);
                u=new String[array.length()];
                p=new String[array.length()];
                for (int i=0;i<array.length();i++)
                {
                    object=array.getJSONObject(i);
                    u[i]=object.getString("uname");
                    p[i]=object.getString("password");





                }


            }

        }
        catch(Exception e)
        {
            Toast.makeText(getApplicationContext(),""+e,Toast.LENGTH_LONG).show();

        }

    }

    public class CustomAdaptorr extends BaseAdapter
    {
        String myuser[];
        String mypassword[];
        Context ctx;
        LayoutInflater lyinfltr;

        public CustomAdaptorr(Context ctx,String[] myuser, String[] mypassword)
        {
            this.myuser = myuser;
            this.mypassword = mypassword;
            this.ctx = ctx;
            lyinfltr=(LayoutInflater.from(ctx));
        }

        @Override
        public int getCount() {
            return myuser.length;
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
            convertView=lyinfltr.inflate(R.layout.list_content,null);
            txtu=(TextView)convertView.findViewById(R.id.listtextviewusername);
            txtp=(TextView)convertView.findViewById(R.id.listtextviewpassword);
            txtu.setText(""+myuser[position]);
            txtp.setText(""+mypassword[position]);
            return convertView;
        }
    }

}
