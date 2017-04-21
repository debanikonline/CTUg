package debanikandroidstudio.ctug;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

public class WelcomeADMIN extends AppCompatActivity
{
    Button newadmin,viewadmindetails,insertSTOP,newroute,allot;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_admin);
        newadmin=(Button)findViewById(R.id.newadminentryButtonID);
        viewadmindetails=(Button)findViewById(R.id.viewAdminDatabaseID);
        insertSTOP=(Button)findViewById(R.id.insertSTOPbuttonID);
        newroute=(Button)findViewById(R.id.newROUTE_buttonID);
        allot=(Button)findViewById(R.id.allotbus_buttonID);
        newadmin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent registryactivity=new Intent(getApplicationContext(),RegisterActivity.class);
                startActivity(registryactivity);
            }
        });
        viewadmindetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent viewadmin=new Intent(getApplicationContext(),ViewDetails.class);
                startActivity(viewadmin);
            }
        });
        insertSTOP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent stop=new Intent(getApplicationContext(),Insert_StopageDetail.class);
                startActivity(stop);
            //Dbox();

            }
        });
        newroute.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent newroute=new Intent(getApplicationContext(),Insert_Route_Detail.class);
                startActivity(newroute);
            }
        });
        allot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent allot=new Intent(getApplicationContext(),Insert_Allot_Bus.class);
                startActivity(allot);
            }
        });

    }
    public void Dbox()
    {
        AlertDialog.Builder box=new AlertDialog.Builder(this);
        box.setMessage("Select a database to update");
        box.setTitle("Database Selection");
        box.setPositiveButton("GO", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which)
            {
                Intent updateotherdatabases=new Intent(getApplicationContext(),AdminOtherDatabaseSelectionView.class);
                startActivity(updateotherdatabases);

            }
        });
        box.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which)
            {
                dialog.cancel();
            }
        });
    }
}
