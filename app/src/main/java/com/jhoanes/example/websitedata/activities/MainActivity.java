package com.jhoanes.example.websitedata.activities;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ProgressBar;

import com.jhoanes.example.websitedata.R;
import com.jhoanes.example.websitedata.loaders.UrlLoader;
import com.jhoanes.example.websitedata.utils.WebViewClient;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, WebViewClient.OnPageWeb, SwipeRefreshLayout.OnRefreshListener {

    private WebView mWebView;
    private WebSettings mWebSettings;
    private UrlLoader mLoader;
    private ProgressBar mProgressBar;
    private SwipeRefreshLayout mLayout;
    private Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);

        mProgressBar = findViewById(R.id.m_progress_bar);
        mLayout = findViewById(R.id.m_swipe);
        mWebView = findViewById(R.id.web_view);
        mWebView.setWebViewClient(new WebViewClient(this, this));

        mWebSettings = mWebView.getSettings();
        accelerationHardware();

        swipeSetup();
        webViewSetup();
        drawerSetup();

        mLoader = new UrlLoader(mWebView);
        mLayout.setOnRefreshListener(this);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, mToolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

    }

    @SuppressLint("SetJavaScriptEnabled")
    private void webViewSetup() {
        mWebSettings.setRenderPriority(WebSettings.RenderPriority.HIGH);
        mWebSettings.setCacheMode(WebSettings.LOAD_NO_CACHE);
        mWebSettings.setJavaScriptEnabled(true);
    }

    private void swipeSetup() {
        mLayout.setColorSchemeColors(getResources()
                .getColor(R.color.progress_start), getResources()
                .getColor(R.color.progress_end));
    }

    private void accelerationHardware() {
        if (isAccelerationHardwareAvailable())
            mWebView.setLayerType(View.LAYER_TYPE_HARDWARE, null);
        else
            mWebView.setLayerType(View.LAYER_TYPE_SOFTWARE, null);
    }

    private boolean isAccelerationHardwareAvailable() {
        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT;
    }

    @Override
    protected void onStart() {
        super.onStart();
        mLoader.loadBaseUrl();
    }

    private void drawerSetup() {
        mToolbar.setClickable(true);
        mToolbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mLoader.loadBaseUrl();
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
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK) && mWebView.canGoBack()) {
            mWebView.goBack();
            return true;
        }
        return super.onKeyDown(keyCode, event);
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

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        item.setCheckable(false);

        switch (id) {
            case R.id.nav_ordinances:
                mLoader.loadOrdinances();
                break;
            case R.id.nav_laws:
                mLoader.loadLaws();
                break;
            case R.id.nav_daily:
                mLoader.loadDaily();
                break;
            case R.id.nav_contract:
                mLoader.loadContracts();
                break;
            case R.id.nav_decrees:
                mLoader.loadDecrees();
                break;
            case R.id.nav_bidding:
                mLoader.loadBidding();
                break;
            case R.id.nav_counter_check:
                mLoader.loadCounterCheck();
                break;
            case R.id.nav_invoice:
                mLoader.loadNFSE();
                break;
            case R.id.nav_diary:
                mLoader.loadDiary();
                break;
            case R.id.nav_share:
                break;
            case R.id.nav_send:
                break;
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void showLoading() {
        if (mProgressBar != null && !isRefresh()) mProgressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        if (mProgressBar != null) mProgressBar.setVisibility(View.GONE);
    }

    @Override
    public void showRefreshSwipe() {
        //Do nothing...
    }

    @Override
    public void hideRefreshSwipe() {
        mLayout.setRefreshing(false);
    }

    private boolean isRefresh() {
        return mLayout.isRefreshing();
    }

    @Override
    public void onRefresh() {
        mLoader.refresh();
    }
}
