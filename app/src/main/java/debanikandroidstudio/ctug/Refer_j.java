package debanikandroidstudio.ctug;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by debanikmoulick on 21/04/17.
 */

public class Refer_j extends Fragment
{
    ImageButton share;
    TextView quote;
    Typeface ty;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {

        View v1=inflater.inflate(R.layout.refer_x,null);
        share=(ImageButton)v1.findViewById(R.id.finalsharebtn);
        share.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_SEND);
               i.setType("text/plain");
//                i.putExtra(Intent.EXTRA_SUBJECT, "Two Points Application [ Chandigarh CTU Bus Guide]");
                String sAux = "\nLet me recommend you this application\nyet to launch this app to PLAY store, willbe implemented in next version";
//                sAux = sAux + "//yet to launch this app to PLAY store, willbe implemented in next version \n\n";
                i.putExtra(Intent.EXTRA_TEXT, sAux);
                startActivity(Intent.createChooser(i, "Send To"));
            }
        });
//        Intent intent = new Intent(Intent.ACTION_SEND);
//        intent.setType("plain/text");
//        intent.putExtra(Intent.EXTRA_TEXT,"heya use this app");
//
//        startActivity(Intent.createChooser(intent, "Contact Us!"));

        quote=(TextView)v1.findViewById(R.id.share_quote);
        quote.setText("The more we share , The more we have.");
        ty=Typeface.createFromAsset(getActivity().getAssets(),"fonts/debu.ttf");
        quote.setTypeface(ty);

        return v1;

    }





}
