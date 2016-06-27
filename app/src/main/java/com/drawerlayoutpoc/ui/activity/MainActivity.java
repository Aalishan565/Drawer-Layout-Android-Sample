package com.drawerlayoutpoc.ui.activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import com.drawerlayoutpoc.R;
import com.drawerlayoutpoc.model.FragmentDrawer;
import com.drawerlayoutpoc.ui.fragment.CommissionReportFragment;
import com.drawerlayoutpoc.ui.fragment.MyScheduleFragment;
import com.drawerlayoutpoc.ui.fragment.PurchaseSeriesFragment;
import com.drawerlayoutpoc.ui.fragment.SchedulerFragment;

public class MainActivity extends AppCompatActivity implements FragmentDrawer.FragmentDrawerListener {
    private static String TAG = MainActivity.class.getSimpleName();
    private Toolbar mToolbar;
    private FragmentDrawer drawerFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        drawerFragment = (FragmentDrawer) getSupportFragmentManager().findFragmentById(R.id.fragment_navigation_drawer);
        drawerFragment.setUp(R.id.fragment_navigation_drawer, (DrawerLayout) findViewById(R.id.drawer_layout), mToolbar);
        drawerFragment.setDrawerListener(this);
        displayView(0);
    }


    @Override
    public void onDrawerItemSelected(View view, int position) {
        displayView(position);
    }

    private void displayView(int position) {
        Fragment fragment = null;

        switch (position) {
            case 0:
                fragment = new MyScheduleFragment();
                break;
            case 1:
                fragment = new SchedulerFragment();

                break;
            case 2:
                fragment = new PurchaseSeriesFragment();

                break;
            case 3:
                fragment = new CommissionReportFragment();
                break;
            case 4:
                Intent intentChangePwd = new Intent(this, ChangePasswordActivity.class);
                startActivity(intentChangePwd);
                break;
            case 5:
                Intent intentAboutApp = new Intent(this, AboutTheAppActivity.class);
                startActivity(intentAboutApp);
                break;
            case 6:
             Toast.makeText(this,"Log out clicked",Toast.LENGTH_SHORT).show();
                break;

            default:
                break;
        }

        if (fragment != null) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.container, fragment);
            fragmentTransaction.commit();
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
