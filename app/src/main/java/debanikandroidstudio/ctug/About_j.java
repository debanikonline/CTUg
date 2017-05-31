package debanikandroidstudio.ctug;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class About_j extends Fragment
{
    TextView name;
    Typeface ty;
    @Nullable
    @Override

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v1=inflater.inflate(R.layout.about_x,null);
        ty=Typeface.createFromAsset(getActivity().getAssets(),"fonts/debu.ttf");
        name=(TextView)v1.findViewById(R.id.textView9);
        name.setTypeface(ty);
        return v1;
    }
}
