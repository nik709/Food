package com.example.makpro.recipedesign1.Fragments;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
//import android.support.v4.app.Fragment;
import  android.app.Fragment;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.makpro.recipedesign1.DBHelper;
import com.example.makpro.recipedesign1.R;
import com.example.makpro.recipedesign1.staticString;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

//import android.support.v7.app.AppCompatActivity;
//import android.support.v4.app.Fragment;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link FragmentIngridients.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link FragmentIngridients#newInstance} factory method to
 * create an instance of this fragment.
 */

public class FragmentIngridients extends Fragment implements View.OnClickListener{
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    Button result;
    ImageButton milkB, meatB, fruitB, groceryB, mushB, veganB, cornB, nutB, seasoningB, juiceB,
    herbB, eggB, seafoodB;
    View view;
    MeatFragment mF;
    vegetableFragment vF;
    fruit fruitF;
    milk milkF;
    corn cornF;
    nut nutF;
    herb herbF;
    juice juiceF;
    seasoning seasoningF;
    seafood seafoodF;
    egg eggF;
    grocery groceryF;
    mushroom mushF;
    ResultFragment rF;
    TextView txt;
    FragmentTransaction fTrans;
    String tmp;
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public SQLiteDatabase sqLiteDatabase;
    public DBHelper dbHelper;



    //Описание курсора
    Cursor cursor;
    final String LOG_TAG = "myLogs";

    public FragmentIngridients() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentIngridients.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentIngridients newInstance(String param1, String param2) {
        FragmentIngridients fragment = new FragmentIngridients();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mF = new MeatFragment();
        vF = new vegetableFragment();
        milkF = new milk();
        fruitF = new fruit();
        cornF = new corn();
        rF = new ResultFragment();
        nutF = new nut();
        herbF = new herb();
        seasoningF = new seasoning();
        juiceF = new juice();
        seafoodF = new seafood();
        eggF = new egg();
        mushF = new mushroom();
        groceryF = new grocery();


        //staticString.str = new ArrayList<String>();

        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        tmp = " ";
        view = inflater.inflate(R.layout.fragment_fragment_ingridients, container, false);

        //------------------------------------------------------------------------------------------------
        //подлючаемся к базе данных
        dbHelper = new DBHelper(view.getContext());
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
        Typeface ingredientFont = Typeface.createFromAsset(getActivity().getAssets(), "Mateur.ttf");
        meatB = (ImageButton) view.findViewById(R.id.meatButton);
        cornB = (ImageButton) view.findViewById(R.id.cornButton);
        veganB = (ImageButton) view.findViewById(R.id.vegetableButton);
        milkB = (ImageButton) view.findViewById(R.id.milkButton);
        fruitB = (ImageButton) view.findViewById(R.id.fruitButton);
        result = (Button) view.findViewById(R.id.search);
        result.setTypeface(ingredientFont);
        nutB = (ImageButton) view.findViewById(R.id.nutButton);
        herbB = (ImageButton) view.findViewById(R.id.herbButton);
        juiceB = (ImageButton) view.findViewById(R.id.juiceButton);
        seafoodB = (ImageButton) view.findViewById(R.id.seafoodButton);
        eggB = (ImageButton) view.findViewById(R.id.eggButton);
        mushB = (ImageButton) view.findViewById(R.id.mushroomButton);
        groceryB = (ImageButton) view.findViewById(R.id.groceryButton);
        result.setOnClickListener(this);
        meatB.setOnClickListener(this);
        veganB.setOnClickListener(this);
        milkB.setOnClickListener(this);
        fruitB.setOnClickListener(this);
        cornB.setOnClickListener(this);
        nutB.setOnClickListener(this);
        herbB.setOnClickListener(this);
        juiceB.setOnClickListener(this);
        seafoodB.setOnClickListener(this);
        eggB.setOnClickListener(this);
        mushB.setOnClickListener(this);
        groceryB.setOnClickListener(this);

        //txt = (TextView) view.findViewById(R.id.textView5);
        //txt.setText(tmp);
        for (int i=0; i<staticString.str.size(); i++) {
            if (i!=staticString.str.size()-1)
            tmp+="Comp_Ingredient_ID = "+staticString.str.get(i)+" or ";
            else
                tmp+="Comp_Ingredient_ID = "+staticString.str.get(i);
        }
        //txt.setText(tmp);
        if (staticString.IsAdd)
        {
            view.setFocusableInTouchMode(true);
            view.requestFocus();

            view.setOnKeyListener(new View.OnKeyListener() {
                @Override
                public boolean onKey(View v, int keyCode, KeyEvent event) {
                    if (event.getAction() == KeyEvent.ACTION_UP) {
                        if (keyCode == KeyEvent.KEYCODE_BACK) {
                            FragmentManager fm = getFragmentManager();
                            fm.popBackStack();
                            FragmentTransaction ft = fm.beginTransaction();
                            ft.commit();
                            return true;
                        }
                    }
                    return false;
                }
            });

            result.setText("Принять");
            result.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v){
                    for (int i=0; i<staticString.addIngridients.size(); i++)
                        staticString.addIngridients.remove(i);
                    for (int i=0; i<staticString.str.size(); i++)
                        staticString.addIngridients.add(staticString.str.get(i));
                    for (int i=0; i<staticString.str.size(); i++)
                        staticString.str.remove(i);

                    FragmentManager fm = getFragmentManager();
                    fm.popBackStack();
                    FragmentTransaction ft = fm.beginTransaction();
                    ft.commit();
                }
            });
        }
        //txt = (TextView) view.findViewById(R.id.textView2);
        //txt.setText(tmp);
        //for (int i=0; i<staticString.str.size(); i++) {
         //   if (i!=staticString.str.size()-1)
          //  tmp+=staticString.str.get(i)+" or ";
          //  else
          //      tmp+=staticString.str.get(i);
     //   }
    //    txt.setText(tmp);

        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
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
    public void onClick(View v) {
        fTrans = getFragmentManager().beginTransaction();
        switch(v.getId()) {
            case R.id.meatButton:
                fTrans.replace(R.id.conteiner, mF);
                break;
            case R.id.vegetableButton:
                fTrans.replace(R.id.conteiner, vF);
                break;
            case R.id.milkButton:
                fTrans.replace(R.id.conteiner, milkF);
                break;
            case R.id.search: {
                //---------------------------------------------------------------------------------

                staticString.NameRecipe.clear();
                staticString.NameCuisine.clear();
                staticString.NameCategory.clear();
                staticString.NameMethod.clear();
                staticString.NameTime.clear();
                staticString.Description.clear();
                staticString.Caloric.clear();


                String chislo = Integer.toString(staticString.str.size());
                staticString.quantityRecipe = 0;

                if(staticString.str.size()>0) {
                    staticString.Products = tmp;
                    String inquiry = "select Recipe_name, Cuisine_name, Category_name, Method_name, Time_name, Description_cooking_method, Caloric_content "
                            + "from Recipe "
                            + "inner join Cuisine on Rec_Cuisine_ID = Cuisine_ID "
                            + "inner join Category on Rec_Category_ID = Category_ID "
                            + "inner join Cooking_method on Rec_Cooking_method_ID = Cooking_method_ID "
                            + "inner join Time on Rec_Time_ID = Time_ID "
                            + "inner join Composition on Recipe_ID = Comp_recipe_ID "
                            + "where Recipe_ID in "
                            + "(select Recipe_ID "
                            + "from Composition "
                            + "inner join Recipe on Recipe_ID = Comp_Recipe_ID "
                            + "where " + tmp + " group by Recipe_ID "
                            + "having count(Comp_ingredient_ID)=" + chislo + " order by Recipe_ID) "
                            + "group by Recipe_ID";
                    Log.d(LOG_TAG,inquiry);
                    cursor = sqLiteDatabase.rawQuery(inquiry, null);

                    if (cursor.moveToFirst()) {
                        int recipeColIndex = cursor.getColumnIndex("Recipe_name");
                        int cuisineColIndex = cursor.getColumnIndex("Cuisine_name");
                        int categoryColIndex = cursor.getColumnIndex("Category_name");
                        int methodColIndex = cursor.getColumnIndex("Method_name");
                        int timeColIndex = cursor.getColumnIndex("Time_name");
                        int descriptionColIndex = cursor.getColumnIndex("Description_cooking_method");
                        int caloricColIndex = cursor.getColumnIndex("Caloric_content");

                        Log.d(LOG_TAG, cursor.getString(recipeColIndex));


                        do {
                            //присваивание в каждый рецепт
                            staticString.NameRecipe.add(cursor.getString(recipeColIndex));
                            staticString.NameCuisine.add(cursor.getString(cuisineColIndex));
                            staticString.NameCategory.add(cursor.getString(categoryColIndex));
                            staticString.NameMethod.add(cursor.getString(methodColIndex));
                            staticString.NameTime.add(cursor.getString(timeColIndex));
                            staticString.Description.add(cursor.getString(descriptionColIndex));
                            staticString.Caloric.add(cursor.getString(caloricColIndex));

                            staticString.quantityRecipe = staticString.quantityRecipe + 1;

                        } while (cursor.moveToNext());
                    } else
                        //сказать что ТАКИХ РЕЦЕПТОВ НЕТ , ВЫ ГУРМАН. МОЖЕТ ДОБАВИТЕ СВОЙ?
                        ;
                    Log.d(LOG_TAG, Integer.toString(staticString.quantityRecipe));
                    logCursor(cursor);
                    cursor.close();
                }
                else
                {
                    //НАПИСАТЬ ЧТО НИЧЕГО НЕ ВЫБРАНО!
                }

                //--------------------------------------------------------------------------------

                fTrans.replace(R.id.conteiner, rF);
                break;
            }
            case R.id.fruitButton:
                fTrans.replace(R.id.conteiner, fruitF);
                break;
            case R.id.cornButton:
                fTrans.replace(R.id.conteiner, cornF);
                break;
            case R.id.nutButton:
                fTrans.replace(R.id.conteiner, nutF);
                break;
            case R.id.herbButton:
                fTrans.replace(R.id.conteiner, herbF);
                break;
            case R.id.juiceButton:
                fTrans.replace(R.id.conteiner, juiceF);
                break;
            case R.id.seafoodButton:
                fTrans.replace(R.id.conteiner, seafoodF);
                break;
            case R.id.eggButton:
                fTrans.replace(R.id.conteiner, eggF);
                break;
            case R.id.mushroomButton:
                fTrans.replace(R.id.conteiner, mushF);
                break;
            case R.id.groceryButton:
                fTrans.replace(R.id.conteiner, groceryF);
                break;
        }
        fTrans.addToBackStack(null);
        fTrans.commit();
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }

}
