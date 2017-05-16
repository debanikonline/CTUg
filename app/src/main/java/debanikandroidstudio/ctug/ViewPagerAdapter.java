package debanikandroidstudio.ctug;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class ViewPagerAdapter extends FragmentPagerAdapter {

    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        if (position ==0)
        {
            return new Home();
        }
        else if (position == 1)
        {
            return new Routes_j();
        }
        else if (position == 2)
        {
            return new Bustimestop_j();
        }
        else if (position == 3)
        {
            return new Buspass_j();

        }
        else if (position == 4)
        {
            return new Busfare_j();
        }
        else if (position == 5)
        {
            return new Helpline_j();
        }
        else if (position == 6)
        {
            return new Feedback_j();
        }
        else if (position == 7)
        {
            return new Routemaps_j();
        }
        else if (position == 8)
        {
            return new Refer_j();
        }
        else if (position == 9)
        {
            return new Rate_j();
        }
        else if (position == 10)
        {
            return new About_j();
        }
        else return null;
    }

    @Override
    public int getCount() {
        return 11;
    }
}
