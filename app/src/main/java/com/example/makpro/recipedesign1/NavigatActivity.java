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

import com.example.makpro.recipedesign1.Fragments.FragmentIngridients;
import com.example.makpro.recipedesign1.Fragments.MyRecipeFragment;

public class NavigatActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    FragmentIngridients FragIngridient;
    MyRecipeFragment myrecipe;

    //Описание курсора
    Cursor cursor;
    SQLiteDatabase sqLiteDatabase;
    DBHelper dbHelper;

    final String LOG_TAG = "myLogs";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigat);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
//--------------------------------------------------------------------------------------------------
        //подлючаемся к базе данных
        dbHelper = new DBHelper(this);
        sqLiteDatabase = dbHelper.getWritableDatabase();

        // выводим в лог блюда по типу
        Log.d(LOG_TAG, "--- Table Ingredient ---");
        cursor = sqLiteDatabase.query("Ingredient", null, null, null, null, null, null);
        logCursor(cursor);
        cursor.close();
        Log.d(LOG_TAG, "--- ---");

        Log.d(LOG_TAG, "--- Table Recipe ---");
        cursor = sqLiteDatabase.query("Recipe", null, null, null, null, null, null);
        logCursor(cursor);
        cursor.close();
        Log.d(LOG_TAG, "--- ---");

        Log.d(LOG_TAG, "--- INNER JOIN with rawQuery---");
        String sqlQuery = "select Recipe_name, Method_name, Cuisine_name "
                +"from Recipe "
                +"inner join Cooking_method on Rec_Cooking_method_ID = Cooking_method_ID "
                +"inner join Cuisine on Rec_Cuisine_ID = Cuisine_ID "
                +"where Rec_Cooking_method_ID = ?";
        cursor = sqLiteDatabase.rawQuery(sqlQuery,new String[]{"16"});
        logCursor(cursor);
        cursor.close();
        Log.d(LOG_TAG, "--- ---");

//--------------------------------------------------------------------------------------------------



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
        myrecipe = new MyRecipeFragment();

    }

    void logCursor(Cursor c) {
        if (c != null) {
            if (c.moveToFirst()) {
                String str;
                do {
                    str = "";
                    for (String cn : c.getColumnNames()) {
                        str = str.concat(cn + " = " + c.getString(c.getColumnIndex(cn)) + "; ");
                    }
                    Log.d(LOG_TAG, str);
                } while (c.moveToNext());
            }
        } else
            Log.d(LOG_TAG, "Cursor is null");
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
            ftrans.replace(R.id.conteiner, FragIngridient);

        } else if (id == R.id.nav_gallery) {
            ftrans.replace(R.id.conteiner, myrecipe);

        } else if (id == R.id.nav_slideshow) {

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
