package com.liberties.iveagh.cryptosync2;

import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.util.DisplayMetrics;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

import java.util.Locale;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action- snackbar bottom toast", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        final Button loginButton = (Button) findViewById(R.id.firebase_log_reg_btn);
        loginButton.setOnClickListener(new View.OnClickListener() {

        public void onClick(View v) {
            Intent loginScreenIntent = new Intent(MainActivity.this, FirebaseLogin.class);
            startActivity(loginScreenIntent);
            }
        });
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        Locale locale = null;
        //noinspection SimplifiableIfStatement
        if (id == R.id.action_main) {
            //use backStack?
            Intent mainActivityIntent = new Intent(MainActivity.this, MainActivity.class);
            startActivity(mainActivityIntent);
            //return true;
        }
        if (id == R.id.action_settings) {
            Intent settingsActivityIntent = new Intent(MainActivity.this, SettingsActivity.class);
            startActivity(settingsActivityIntent);
            //return true
        }
        if (id == R.id.action_hello) {
            //return true
            Intent helloIntent = new Intent(MainActivity.this, HelloAndroid.class);
            //start Activity by using Intent
            startActivity(helloIntent);
        }
        if (id == R.id.action_english) {
            //return true
            //Intent helloIntent = new Intent(MainActivity.this, MainActivity.class);
            //start Activity by using Intent
            //startActivity(helloIntent);
            locale = new Locale("en");
            Resources res = getResources();
            DisplayMetrics dm = res.getDisplayMetrics();
            Configuration conf = res.getConfiguration();
            conf.locale = locale;
            res.updateConfiguration(conf, dm);
            Intent refresh = new Intent(MainActivity.this, MainActivity.class);
            startActivity(refresh);
            finish();
        }
        if (id == R.id.action_gaeilge) {
            locale = new Locale("ga");
            Resources res = getResources();
            DisplayMetrics dm = res.getDisplayMetrics();
            Configuration conf = res.getConfiguration();
            conf.locale = locale;
            res.updateConfiguration(conf, dm);
            Intent refresh = new Intent(MainActivity.this, MainActivity.class);
            startActivity(refresh);
            finish();
            //add to backStack?
        }
        if (id == R.id.action_tamil) {
            locale = new Locale("ta");
            Resources res = getResources();
            DisplayMetrics dm = res.getDisplayMetrics();
            Configuration conf = res.getConfiguration();
            conf.locale = locale;
            res.updateConfiguration(conf, dm);
            Intent refresh = new Intent(MainActivity.this, MainActivity.class);
            startActivity(refresh);
            finish();
        }
        if (id == R.id.action_german) {
            //return true
            locale = new Locale("de");
            Resources res = getResources();
            DisplayMetrics dm = res.getDisplayMetrics();
            Configuration conf = res.getConfiguration();
            conf.locale = locale;
            res.updateConfiguration(conf, dm);
            Intent refresh = new Intent(MainActivity.this, MainActivity.class);
            startActivity(refresh);
            finish();
        }
        if (id == R.id.action_contacs) {
            return true;
//            Intent helloIntent = new Intent(MainActivity.this, HelloAndroid.class);
//            //start Activity by using Intent
//            startActivity(helloIntent);
        }
        if (id == R.id.action_about) {
            return true;

        }
//        return true;
        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
            Intent cameraPageIntent = new Intent(MainActivity.this, CameraActivity.class);
            //start Activity by using Intent regRage
            startActivity(cameraPageIntent);
        } else if (id == R.id.nav_gallery) {
            Intent regPageIntent = new Intent(MainActivity.this, HelloAndroid.class);
            //start Activity by using Intent regRage
            startActivity(regPageIntent);
        } else if (id == R.id.nav_reg_login) {
            // Create an explicit Intent for starting the reg + loginScreen Activity
            Intent regloginScreenIntent = new Intent(MainActivity.this, LoginScreen.class);
            // Use the Intent to start loginScreen Activity
            startActivity(regloginScreenIntent);
        } else if (id == R.id.nav_reg_login_google) {
            // Create an explicit Intent for starting the reg + loginScreen Activity
            Intent regLoginGoogleIntent = new Intent(MainActivity.this, LoginGoogleActivity.class);
            // Use the Intent to start loginScreen Activity
            startActivity(regLoginGoogleIntent);
        } else if (id == R.id.nav_firebase_reg_login){
            Intent firebaseRegLoginIntent = new Intent(MainActivity.this, FirebaseActivity.class);
            startActivity(firebaseRegLoginIntent);
        } else if (id == R.id.nav_manage) {
            Intent settingsActivity = new Intent(MainActivity.this, SettingsActivity.class);
            startActivity(settingsActivity);
        } else if (id == R.id.nav_map) {
            // Create an explicit Intent for starting the reg + loginScreen Activity
            Intent mapLocationIntent = new Intent(MainActivity.this, MapLocation.class);
            // Use the Intent to start loginScreen Activity
            startActivity(mapLocationIntent);
        } else if (id == R.id.nav_map_contacts) {
            // Create an explicit Intent for starting the reg + loginScreen Activity
            Intent mapContactsIntent = new Intent(MainActivity.this, MapLocationContacts.class);
            // Use the Intent to start loginScreen Activity
            startActivity(mapContactsIntent);
        } else if (id == R.id.nav_eth_api){
            // Create an explicit Intent for starting the reg + loginScreen Activity
            Intent ethereumMainIntent = new Intent(MainActivity.this, EthereumMain.class);
            // Use the Intent to start loginScreen Activity
            startActivity(ethereumMainIntent);
        } else if (id == R.id.nav_form1){

        } else if (id == R.id.nav_form2){

        } else if (id == R.id.osLin) {
            Intent linuxEthereumTabbed = new Intent(MainActivity.this, LinuxEthereumTabbed.class);
            startActivity(linuxEthereumTabbed);
            //Intent linuxEthereumBottomNav = new Intent(MainActivity.this, LinuxEtherumBottomNav.class);
            //startActivity(linuxEthereumBottomNav);
        } else if (id == R.id.osMac) {
            //Intent linuxEthereumTabbed = new Intent(MainActivity.this, LinuxEthereumTabbed.class);
            //startActivity(linuxEthereumTabbed);
        } else if (id == R.id.osWin) {

        } else if (id == R.id.theme_light) {
            // switch here between light and dart themes.
            // <item name="android:colorBackground">@color/black</item>
            // or @color/white
        } else if (id == R.id.theme_dark) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
