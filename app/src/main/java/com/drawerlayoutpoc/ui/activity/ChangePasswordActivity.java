package com.drawerlayoutpoc.ui.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.view.MenuItem;

import com.drawerlayoutpoc.R;

/**
 * Created by aalishan on 18/1/16.
 */
public class ChangePasswordActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_password);

        Toolbar mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setTitle(Html.fromHtml("<font color='" + getResources().getColor(R.color.color_white) + "'>" + getString(R.string.hdr_change_password) + "</font>"));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }


    private void initUI() {

    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId()== android.R.id.home) {
            finish();
            return true;
        }
        return false;
    }
}
