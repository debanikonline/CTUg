package debanikandroidstudio.ctug;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Handler;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SplashScreen extends AppCompatActivity
{
TextView name;
    Typeface ty;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        name=(TextView)findViewById(R.id.textView3);
        ty=Typeface.createFromAsset(getAssets(),"fonts/debu.ttf");
        name.setTypeface(ty);
        Thread thread= new Thread(new Runnable() {
            @Override
            public void run()
            {
                try
                {
                    Thread.sleep(2000);
                    Intent intent=new Intent(getApplicationContext(),LoginSwitcher.class);
                    startActivity(intent);
                    finish();
                }
                catch (Exception e)
                {

                }

            }
        });
        thread.start();

    }

}
