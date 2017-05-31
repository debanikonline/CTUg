package debanikandroidstudio.ctug;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.math.BigInteger;

/**
 * Created by debanikmoulick on 20/04/17.
 */

public class Helpline_j extends Fragment
{
    ListView lst;
    String dial="";
    String contacts[]={"Enquiry ISBT, Sector 17","Enquiry ISBT 43","Duty Inspector, Deport No 1 (Long Route)","Duty Inspector, Deport No 2\n(Local Route)","Duty Inspector, Deport No 3\n(Long Route & Sub Urban)","Duty Inspector, JnNURM Depot(Local Operations)","CTU WorkShop Depot 3","CTU Office Depot 3"};
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v1=inflater.inflate(R.layout.helpline_x,null);
        lst=(ListView)v1.findViewById(R.id.helplinelistview);
        ArrayAdapter adp=new ArrayAdapter(getContext(),R.layout.support_simple_spinner_dropdown_item,contacts);
        lst.setAdapter(adp);
        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selected=contacts[position].toString();

              //  Toast.makeText(getContext(), "selected -- "+selected, Toast.LENGTH_SHORT).show();
                //if (selected.equals("Enquiry ISBT, Sector 17"))//contacts[1])
                if(position==0)
                {
                    dial="01722700006";
                    Dbox();
                }
                else if (position==1)
                {
                    dial="01722624413";
                    Dbox();
                }
                if(position==2)
                {
                    dial="01722650331";
                    Dbox();
                }
                else if (position==3)
                {
                    dial="01722679255";
                    Dbox();
                }
                if(position==4)
                {
                    dial="01722677033";
                    Dbox();
                }
                else if (position==5)
                {
                    dial="01722624418";
                    Dbox();
                }
                if(position==6)
                {
                    dial="01722677033";
                    Dbox();
                }
                else if (position==7)
                {
                    dial="01722677066";
                    Dbox();
                }
                else
                {
                    //Toast.makeText(getContext(), "Click on a contact for help..!!"+position, Toast.LENGTH_SHORT).show();

                }

            }
        });


        return v1;

    }
    public void Dbox()
    {
        AlertDialog.Builder box=new AlertDialog.Builder(getContext());
        box.setMessage("Call"+" "+dial);

        box.setPositiveButton("YES", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which)
            {
                Intent call=new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+dial));
                startActivity(call);

            }
        });
        box.setNegativeButton("cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which)
            {
//                Fragment f=new Busfare_j();
//                FragmentManager manager=getActivity().getSupportFragmentManager();
//                FragmentTransaction transaction=manager.beginTransaction();
//
                dialog.cancel();
            }
        });
        AlertDialog dia=box.create();
        dia.show();
//        AlertDialog.Builder box=new AlertDialog.Builder(getContext());
//        box.setMessage("Select a database to update");
//        box.setTitle("Database Selection");
//        box.setPositiveButton("GO", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int which)
//            {
//                Intent updateotherdatabases=new Intent(getContext(),AdminOtherDatabaseSelectionView.class);
//                startActivity(updateotherdatabases);
//
//            }
//        });
//        box.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int which)
//            {
//                dialog.cancel();
//            }
//        });
    }
}
