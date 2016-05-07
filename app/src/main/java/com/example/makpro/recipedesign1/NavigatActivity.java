package com.example.makpro.recipedesign1;

import android.app.Fragment;
import android.app.FragmentManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.app.FragmentTransaction;
import android.widget.Button;

import com.example.makpro.recipedesign1.Fragments.AddRecipeFragment;
import com.example.makpro.recipedesign1.Fragments.FragmentIngridients;
import com.example.makpro.recipedesign1.Fragments.MyRecipeFragment;

import java.util.ArrayList;

public class NavigatActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    FragmentIngridients FragIngridient;
    MyRecipeFragment dopSearch;
    AddRecipeFragment addRecipeFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigat);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        /*FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        FragIngridient = new FragmentIngridients();
        dopSearch = new MyRecipeFragment();
        addRecipeFragment = new AddRecipeFragment();
        staticString.str = new ArrayList<String>();
        staticString.addIngridients = new ArrayList<String>();
        staticString.NameRecipe = new ArrayList<String>();
        staticString.NameCuisine = new ArrayList<String>();
        staticString.NameCategory = new ArrayList<String>();
        staticString.NameMethod = new ArrayList<String>();
        staticString.NameTime = new ArrayList<String>();
        staticString.Description = new ArrayList<String>();
        staticString.Caloric = new ArrayList<String>();

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
        getMenuInflater().inflate(R.menu.navigat, menu);
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

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        FragmentManager fm = getFragmentManager();
        FragmentTransaction ftrans = fm.beginTransaction();
        if (id == R.id.nav_camera) {
            staticString.IsAdd = false;
            ftrans.replace(R.id.conteiner, FragIngridient);

        } else if (id == R.id.nav_gallery) {
            staticString.IsAdd = false;
            ftrans.replace(R.id.conteiner, dopSearch);

        } else if (id == R.id.nav_slideshow) {
            staticString.IsAdd = true;
            ftrans.replace(R.id.conteiner, addRecipeFragment);

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }
        ftrans.addToBackStack(null);
        ftrans.commit();

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
