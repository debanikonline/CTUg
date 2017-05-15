package debanikandroidstudio.ctug;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.net.URL;

public class MainActivity extends AppCompatActivity {
    Button btnlogin, forgot;
    EditText txtname, txpassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtname = (EditText) findViewById(R.id.editTextname);
        txpassword = (EditText) findViewById(R.id.editTextpassword);
        btnlogin = (Button) findViewById(R.id.buttonlogin);
        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                //----------after checking correct username and password use the following intent.
                Intent welcomeAdminPage = new Intent(getApplicationContext(), WelcomeADMIN.class);
                startActivity(welcomeAdminPage);
            }
        });
//        btnnewuser=(Button)findViewById(R.id.newuserbutton);
//        btnnewuser.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent registerpage=new Intent(getApplicationContext(),RegisterActivity.class);
//                startActivity(registerpage);
//            }
//        });
//        base=(Button)findViewById(R.id.viewbasebutton);
//        base.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent basepage=new Intent(getApplicationContext(),ViewDetails.class);
//                startActivity(basepage);
//            }
//        });
        forgot = (Button) findViewById(R.id.AdminForgotPasswordButtonID);
        forgot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) 
            {
                if(txtname.length()==0)
                {
                    Toast.makeText(MainActivity.this, "Please enter username to continue", Toast.LENGTH_SHORT).show();
                }
                else if(txtname.length()>0) {
                    Dbox();
                }
                else
                {
                    Toast.makeText(MainActivity.this, "", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }

    public void Dbox()
    {
        String name=txtname.getText().toString();
        String print="";
        if (name.equals(null))
        {
            print="";
        }
        else
        {
            print=name;
        }
        AlertDialog.Builder box = new AlertDialog.Builder(this);
        box.setMessage("You cannot reset your password from here, You need to drop a TextMessage to Debanik Moulick [HOD] for assistance, Please check if your UserName is correct in your message.");
        box.setTitle("Need help "+print+"?");
        box.setPositiveButton("Send Message",new DialogInterface.OnClickListener()
        {
            @Override
            public void onClick(DialogInterface dialog, int which)
            {
                String user=txtname.getText().toString();
//                Uri uri = Uri.parse("http://"); // missing 'http://' will cause crashed
//                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
//                startActivity(intent);
                //Intent smsIntent = new Intent(Intent.ACTION_SENDTO,
                     //   Uri.parse("sms:8194946794"));
                        Intent smsIntent=new Intent(Intent.ACTION_VIEW,Uri.parse("sms:8194946794"));
                smsIntent.putExtra("sms_body","Sir i have forgotten my password, i want to reset it, my user name is "+"\n"+user+"\n"+"Thank You.");
                startActivity(smsIntent);



            }
        });
        box.setNegativeButton("i remember!!", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which)
            {
                dialog.cancel();
            }
        });
        AlertDialog d=box.create();
        d.show();

    }
}
