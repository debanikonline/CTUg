package debanikandroidstudio.ctug;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RatingBar;
import android.widget.Toast;

/**
 * Created by debanikmoulick on 21/04/17.
 */

public class Rate_j extends Fragment
{
    ImageButton r;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v1=inflater.inflate(R.layout.rate_x,null);
        r=(ImageButton) v1.findViewById(R.id.imageButton10);
        r.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("https://www.facebook.com/pg/TwoPoints.India/reviews/?ref=page_internal"); // missing 'http://' will cause crashed
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
        return v1;
    }
}
