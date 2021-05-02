package example.android.thoitiet;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.Menu;
import android.widget.Button;
import android.widget.TimePicker;

import com.google.android.material.navigation.NavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.core.view.GravityCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import example.android.thoitiet.ui.Evaluate.EvaluateFragment;
import example.android.thoitiet.ui.Home.HomeFragment;
import example.android.thoitiet.ui.Language.LanguageFragment;
import example.android.thoitiet.ui.Location.LocationFragment;
import example.android.thoitiet.ui.Notify.NotifyFragment;
import example.android.thoitiet.ui.Setting.SettingFragment;
import example.android.thoitiet.ui.Share.ShareFragment;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    private AppBarConfiguration mAppBarConfiguration;
    private static final int HOME=1;
    private static final int LOCATION=2;
    private static final int SETTING=3;
    private static final int NOTIFY=4;
    private static final int LANGUAGE=5;
    private static final int SHARE=6;
    private static final int EVALUATE=7;
    private int CONST=HOME;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        DrawerLayout drawer=findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);

        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_location, R.id.nav_setting,R.id.nav_notify,R.id.nav_language,R.id.nav_share,R.id.nav_evaluate)
                .setDrawerLayout(drawer)
                .build();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        ActionBarDrawerToggle toggle=new ActionBarDrawerToggle(this,drawer,toolbar,R.string.open,R.string.close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);
        ReplaceFragment(new HomeFragment());



    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }



    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id=item.getItemId();
        if (id==R.id.nav_home)
        {
            if(HOME!=CONST)
            {
                ReplaceFragment(new HomeFragment());
                CONST=HOME;
            }
        }
        else if(id==R.id.nav_location)
        {
            if(LOCATION!=CONST)
            {
                ReplaceFragment(new LocationFragment());
                CONST=LOCATION;
            }
        }
        else if(id==R.id.nav_setting)
        {
            if(SETTING!=CONST)
            {
                ReplaceFragment(new SettingFragment());
                CONST=SETTING;
            }
        }
        else if(id==R.id.nav_notify)
        {
            if(NOTIFY!=CONST)
            {
                ReplaceFragment(new NotifyFragment());
                CONST=NOTIFY;
            }
        }
        else if(id==R.id.nav_language)
        {
            if(LANGUAGE!=CONST)

            {
                ReplaceFragment(new LanguageFragment());
                CONST=LANGUAGE;
            }
        }
        else if(id==R.id.nav_share)
        {
            if(SHARE!=CONST)
            {
                ReplaceFragment(new ShareFragment());
                CONST=SHARE;
            }
        }
        else if(id==R.id.nav_evaluate)
        {
            if(EVALUATE!=CONST)
            {
                ReplaceFragment(new EvaluateFragment());
                CONST=EVALUATE;
            }
        }
        DrawerLayout drawer=findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public  void ReplaceFragment(Fragment fragment)
    {
        FragmentTransaction fragmentTransaction=getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.content_frame,fragment);
        fragmentTransaction.commit();
    }
}