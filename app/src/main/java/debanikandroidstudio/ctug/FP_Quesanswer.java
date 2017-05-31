package debanikandroidstudio.ctug;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
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

public class FP_Quesanswer extends AppCompatActivity
{
    RelativeLayout relativeLayout;
    AnimationDrawable animationDrawable;
    TextView ques,ahh;
    EditText ans;
    Button next;
    String un;
    String checkans;
    String question,answer;
    String hosturl="http://192.168.43.113/CTU/quesans.php";
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fp__quesanswer);
        relativeLayout=(RelativeLayout)findViewById(R.id.fpques);
        animationDrawable=(AnimationDrawable)relativeLayout.getBackground();
        animationDrawable.setEnterFadeDuration(5000);
        animationDrawable.setExitFadeDuration(2000);
        ques=(TextView)findViewById(R.id.fp_2_question_space);
        ans=(EditText)findViewById(R.id.fp_2_answer_space);
        ahh=(TextView)findViewById(R.id.textView23);
        next=(Button)findViewById(R.id.fp_2_button_next);
        un=getIntent().getStringExtra("username");
        ahh.setText("Heya!! "+un);
        quesans(un);
        ques.setText(question);

       // Toast.makeText(this, "q--"+question[0], Toast.LENGTH_SHORT).show();


        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
               // Toast.makeText(FP_Quesanswer.this, "entered button onClick", Toast.LENGTH_SHORT).show();
                checkans=ans.getText().toString();
                //Toast.makeText(FP_Quesanswer.this, "entered - "+checkans, Toast.LENGTH_SHORT).show();
                //Toast.makeText(FP_Quesanswer.this, "database - "+answer, Toast.LENGTH_SHORT).show();
                if(checkans.equals(answer))
                {
                    Intent i=new Intent(getApplicationContext(),FP_3_recovery.class);
                    i.putExtra("username",un);
                    startActivity(i);
                }
                else
                {
                    Toast.makeText(FP_Quesanswer.this, "Your answer doesn't matches with records!!", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (animationDrawable != null && !animationDrawable.isRunning())
            animationDrawable.start();
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (animationDrawable != null && animationDrawable.isRunning())
            animationDrawable.stop();
    }
    public void quesans(String uname)
    {
        //Toast.makeText(this, "begin of method - "+uname, Toast.LENGTH_SHORT).show();
        String line="";
        StringBuilder bob= new StringBuilder();
        try
        {
            URL url=new URL(hosturl);
            HttpURLConnection co=(HttpURLConnection)url.openConnection();
            co.setRequestMethod("POST");
            co.setDoInput(true);
            OutputStream os=co.getOutputStream();
            OutputStreamWriter osw=new OutputStreamWriter(os,"UTF-8");
            BufferedWriter bw=new BufferedWriter(osw);
            String query= URLEncoder.encode("cname","UTF-8")+"="+URLEncoder.encode(uname,"UTF-8");
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
                String data=bob.toString();

                JSONObject object=new JSONObject(data);

                    question=object.getString("securityquestion");
                    answer=object.getString("canswer");


            }


        }
        catch(Exception e)
        {

        }
       // Toast.makeText(this, ""+question, Toast.LENGTH_SHORT).show();
        //Toast.makeText(this, ""+answer, Toast.LENGTH_SHORT).show();
    }


}
