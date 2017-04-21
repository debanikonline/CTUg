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

import java.net.URL;

public class MainActivity extends AppCompatActivity {
    Button btnlogin, forgot;//,btnnewuser,base;
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
            public void onClick(View v) {
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
            public void onClick(View v) {
                Dbox();
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
        box.setMessage("You cannot reset your password from here, You need to drop a TextMessage to Debanik Moulick [HOD] for assistance, Please mention your UserName in your message.");
        box.setTitle("Need help "+print+"?");
        box.setPositiveButton("Send Message",new DialogInterface.OnClickListener()
        {
            @Override
            public void onClick(DialogInterface dialog, int which)
            {
//                Uri uri = Uri.parse("http://"); // missing 'http://' will cause crashed
//                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
//                startActivity(intent);
                Intent smsIntent = new Intent(Intent.ACTION_SENDTO,
                        Uri.parse("sms:8194946794"));
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
