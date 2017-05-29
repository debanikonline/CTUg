package debanikandroidstudio.ctug;
import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class WelcomeUSER_Navi extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener
{

    private ViewPager viewPager;
    private DrawerLayout drawer;
    private TabLayout tabLayout;
    private String[] pageTitle = {"SEARCH", "ROUTES", "BUS TIME/\nSTOPS"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_user__navi);

        viewPager = (ViewPager)findViewById(R.id.view_pager);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        drawer = (DrawerLayout) findViewById(R.id.drawerLayout);

        setSupportActionBar(toolbar);

        //create default navigation drawer toggle
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        //setting Tab layout (number of Tabs = number of ViewPager pages)
        tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        for (int i = 0; i < 3; i++) {
            tabLayout.addTab(tabLayout.newTab().setText(pageTitle[i]));

        }
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        assert navigationView != null;
        navigationView.setNavigationItemSelectedListener(this);
        ViewPagerAdapter pagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(pagerAdapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab)
            {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab)
            {
                viewPager.setCurrentItem(tab.getPosition());
            }
        });
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item)
    {
        int id = item.getItemId();

        if (id == R.id.homepc) {
            viewPager.setCurrentItem(0);

        }
      else if (id == R.id.buspasspc)
        {
            viewPager.setCurrentItem(3);
        }
        else if (id == R.id.busfarespc)
        {
            viewPager.setCurrentItem(4);
        }
        else if (id == R.id.helplinepc)
        {
            viewPager.setCurrentItem(5);
        }
        else if (id == R.id.feedbackpc) {
            viewPager.setCurrentItem(6);
        }
        else if (id == R.id.routemapspc) {
            viewPager.setCurrentItem(7);
        }
        else if (id == R.id.referpc) {
            viewPager.setCurrentItem(8);
        }
        else if (id == R.id.ratepc) {
            viewPager.setCurrentItem(9);
        }
        else if (id == R.id.aboutpc) {
            viewPager.setCurrentItem(10);
        }
        else if (id == R.id.logoutpc) {
            viewPager.setCurrentItem(11);
        }
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed()
    {
        assert drawer != null;
        if (drawer.isDrawerOpen(GravityCompat.START))
        {
            drawer.closeDrawer(GravityCompat.START);
        }
        else
        {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.welcome_user__navi,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch (item.getItemId())
        {
            case R.id.action_Logout:
            {
                Intent i=new Intent(this,Login.class);
                startActivity(i);
            }
        }
        return super.onOptionsItemSelected(item);
    }

}
