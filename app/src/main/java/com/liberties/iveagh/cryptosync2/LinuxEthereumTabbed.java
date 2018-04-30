package com.liberties.iveagh.cryptosync2;

import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import android.widget.ImageButton;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Locale;

public class LinuxEthereumTabbed extends AppCompatActivity {

    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    private SectionsPagerAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_linux_ethereum_tabbed);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Fab fab fabsn", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_linux_ethereum_tabbed, menu);
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
            Intent mainActivityIntent = new Intent(LinuxEthereumTabbed.this, MainActivity.class);
            startActivity(mainActivityIntent);
            //return true;
        }
        if (id == R.id.action_settings) {
            Intent settingsActivityIntent = new Intent(LinuxEthereumTabbed.this, SettingsActivity.class);
            startActivity(settingsActivityIntent);
            //return true
        }
        if (id == R.id.action_hello) {
            //return true
            Intent helloIntent = new Intent(LinuxEthereumTabbed.this, HelloAndroid.class);
            //start Activity by using Intent
            startActivity(helloIntent);
        }
        if (id == R.id.action_english) {
            //return true
            Intent helloIntent = new Intent(LinuxEthereumTabbed.this, MainActivity.class);
            //start Activity by using Intent
            startActivity(helloIntent);
        }
        if (id == R.id.action_gaeilge) {
            locale = new Locale("ga");
            Resources res = getResources();
            DisplayMetrics dm = res.getDisplayMetrics();
            Configuration conf = res.getConfiguration();
            conf.locale = locale;
            res.updateConfiguration(conf, dm);
            Intent refresh = new Intent(LinuxEthereumTabbed.this, MainActivity.class);
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
            Intent refresh = new Intent(this, MainActivity.class);
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
            Intent refresh = new Intent(this, MainActivity.class);
            startActivity(refresh);
            finish();
        }
        if (id == R.id.action_contacs) {
            return true;
//            Intent helloIntent = new Intent(LinuxEthereumTabbed.this, HelloAndroid.class);
//            //start Activity by using Intent
//            startActivity(helloIntent);
        }
        if (id == R.id.action_about) {
            return true;

        }


        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";

        public PlaceholderFragment() {
        }

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_linux_ethereum_tabbed, container, false);

            TextView textView = (TextView) rootView.findViewById(R.id.section_label);
            textView.setText(getString(R.string.section_format, getArguments().getInt(ARG_SECTION_NUMBER)));

            TextView textViewPage = (TextView) rootView.findViewById(R.id.section_page);
            if (getArguments().getInt(ARG_SECTION_NUMBER) == 1) {
                textViewPage.setText("\n\nprogram page with java individually" +
                        "\nthis being page begin" +
                        "\nSetup Tech Page" +
                        "\n\n" +
                        "\nGeth - Go + Ethereum" +
                        "\n\tGolang is a new imperative language from Google and aims to update C for modern computing " +
                        "environments with new technologies like concurrency." +
                        "\n\nEthereum Browser + Mist" +
                        "\n\n" +
                        "\nSystem Requirements" +
                        "\n\tNetwork Speeds" +
                        "\n\t\tMakes the differencce between this taking 6 hrs and 6 days. if it takes longer you may already be " +
                        "out of the game." +
                        "\n\tROM" +
                        "\n\t\t100Gb to start with. Must have room to expand." +
                        "\n\tRAM" +
                        "\n\t\t6Gb Minimum" +
                        "\n\tSwap Space" +
                        "\n\t\t4Gb Minimum" +
                        "\n\tNetwork Speeds" +
                                "\n\t\tMakes the differencce between this taking 6 hrs and 6 days. if it takes longer you may already be " +
                                "out of the game." +
                                "\n\tROM" +
                                "\n\t\t100Gb to start with. Must have room to expand." +
                                "\n\tRAM" +
                                "\n\t\t6Gb Minimum" +
                                "\n\tSwap Space" +
                                "\n\t\t4Gb Minimum");
            }
            if (getArguments().getInt(ARG_SECTION_NUMBER) == 2) {
                textViewPage.setText("\n\nBegin Blcoackchain Install" +
                        "\n\n" +
                        "\nGeth commands" +
                        "\n\n" +
                        "\n\tStart" +
                        "\n\tStop" +
                        "\n\n" +
                        "\nEth.js" +
                        "\n\t\tWith ethereum.sync we can perform calls on geth blockchain." +
                        "\n\n\n----------------------" +
                        "\n\t\t6Gb Minimum" +
                                "\n\tGolang is a new imperative language from Google and aims to update C for modern computing " +
                                "environments with new technologies like concurrency." +
                                "\n\nEthereum Browser + Mist" +
                                "\n\n" +
                                "\nSystem Requirements" +
                                "\n\tNetwork Speeds" +
                                "\n\t\tMakes the difference between this taking 6 hrs and 6 days. if it takes longer you may already be " +
                                "out of the game." +
                                "\n\tROM" +
                                "\n\t\t100Gb to start with. Must have room to expand." +
                                "\n\tRAM" +
                                "\n\t\t6Gb Minimum");
            };
            if (getArguments().getInt(ARG_SECTION_NUMBER) == 3) {
                textViewPage.setText("\n\nSystem and Blockchain Maintenance" +
                        "\n\n" +
                        "\nChronography" +
                        "\n\t\tFind the best time to download - usually in mornign or late at night." +
                        "\nDepends upon net speeds. " +
                        "\nIt is actually possible to download on 3G if main sync " +
                        "is achieved first." +
                        "\n\n" +
                        "\nFree up system resources: memory" +
                        "\n\tBleachBit" +
                        "\n\n\n----------------------" +
                                "\n\t\t6Gb Minimum" +
                                "\n\tGolang is a new imperative language from Google and aims to update C for modern computing " +
                                "environments with new technologies like concurrency." +
                                "\n\nEthereum Browser + Mist" +
                                "\n\n" +
                                "\nSystem Requirements" +
                                "\n\tNetwork Speeds" +
                                "\n\t\tMakes the differencce between this taking 6 hrs and 6 days. if it takes longer you may already be " +
                                "out of the game." +
                                "\n\tROM" +
                                "\n\t\t100Gb to start with. Must have room to expand." +
                                "\n\tRAM" +
                                "\n\t\t6Gb Minimum");
            }
            //end textViewPage
            return rootView;
        }
    }

    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            return PlaceholderFragment.newInstance(position + 1);
        }

        @Override
        public int getCount() {
            // Show 4 total pages.
            return 3;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "SECTION 1";
                case 1:
                    return "SECTION 2";
                case 2:
                    return "SECTION 3";
            }
            return null;
        }
    }
}
