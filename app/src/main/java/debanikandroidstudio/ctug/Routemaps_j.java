package debanikandroidstudio.ctug;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

/**
 * Created by debanikmoulick on 21/04/17.
 */

public class Routemaps_j extends Fragment
{
   // ImageView img;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v1=inflater.inflate(R.layout.routemaps_x,container,false);
        //img=(ImageView)getView().findViewById(R.id.routeimageid);
        //img.setRotation(90);
        return v1;


    }
}
