package debanikandroidstudio.ctug;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

/**
 * Created by debanikmoulick on 20/04/17.
 */

public class Feedback_j extends Fragment
{
    EditText name,email,phone,feedback;
    String fname,fmail,fphone,ffeed;
    Button submit;
    String hosturl="http://192.168.43.113/CTU/feedback.php";
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v1=inflater.inflate(R.layout.feedback_x,null);
        name=(EditText)v1.findViewById(R.id.feedback_name);
        email=(EditText)v1.findViewById(R.id.feedback_email);
        phone=(EditText)v1.findViewById(R.id.feedback_phone);
        feedback=(EditText)v1.findViewById(R.id.feedback_feedback);
        submit=(Button)v1.findViewById(R.id.feedback_button);
        fname=name.getText().toString();
        fmail=email.getText().toString();
        fphone=phone.getText().toString();
        ffeed=feedback.getText().toString();


            submit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v)
                {

                    fname = name.getText().toString();
                    fmail = email.getText().toString();
                    fphone = phone.getText().toString();
                    ffeed = feedback.getText().toString();
                    if(fphone.length()<10||fphone.length()>10)
                    {
                        Toast.makeText(getContext(), "Min 10 digits in phone", Toast.LENGTH_SHORT).show();

                    }
                    else
                    {
                        if(fmail.isEmpty())
                        {
                            Toast.makeText(getContext(), "We need your email to get in touch with you!!", Toast.LENGTH_SHORT).show();
                        }

                        else
                        {
                            if (fmail.contains("@")&&fmail.contains("."))
                            {
                                save();
                                Toast.makeText(getContext(), "Thanks for your feedback.", Toast.LENGTH_SHORT).show();
                                name.setText("");
                                email.setText("");
                                phone.setText("");
                                feedback.setText("");
                               // Toast.makeText(getContext(), "" + fname + fmail + fphone + ffeed, Toast.LENGTH_SHORT).show();
                            }
                            else
                            {
                                Toast.makeText(getContext(), "Please check your email-id", Toast.LENGTH_SHORT).show();
                            }

                        }
                    }


                }
            });


        return v1;
    }
    public void save()
    {
        String n=name.getText().toString();
        String e=email.getText().toString();
        String p=phone.getText().toString();
        String f=feedback.getText().toString();
        try
        {
            URL u=new URL(hosturl);
            HttpURLConnection con=(HttpURLConnection)u.openConnection();
            con.setRequestMethod("POST");
            con.setDoOutput(true);
            OutputStream os= con.getOutputStream();
            OutputStreamWriter osw=new OutputStreamWriter(os,"UTF-8");
            BufferedWriter bw=new BufferedWriter(osw);
            String query=
                    URLEncoder.encode("n","UTF-8")+"="+URLEncoder.encode(n,"UTF-8")+"&"+
                            URLEncoder.encode("email","UTF-8")+"="+URLEncoder.encode(e,"UTF-8")+"&"+
                            URLEncoder.encode("p","UTF-8")+"="+URLEncoder.encode(p,"UTF-8")+"&"+
                            URLEncoder.encode("f","UTF-8")+"="+URLEncoder.encode(f,"UTF-8");
            bw.write(query);
            bw.flush();
            bw.close();
            InputStream is=con.getInputStream();
            con.connect();
            is.close();
           // Toast.makeText(getContext(), "email-"+e, Toast.LENGTH_SHORT).show();


        }
        catch (Exception er)
        {

        }
    }
}
