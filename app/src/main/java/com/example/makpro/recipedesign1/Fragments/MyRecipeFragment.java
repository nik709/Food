package com.example.makpro.recipedesign1.Fragments;

import android.app.FragmentTransaction;
import android.content.Context;


import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import android.graphics.Typeface;


import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
//import android.support.v4.app.Fragment;
import  android.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.makpro.recipedesign1.DBHelper;
import com.example.makpro.recipedesign1.R;
import com.example.makpro.recipedesign1.staticString;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link MyRecipeFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link MyRecipeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MyRecipeFragment extends Fragment implements View.OnClickListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    View view;
    Button time, cuisine, category, cookingMethod, dopSearch;
    FragmentTransaction fTrans;
    TimeFragment tF;
    CuisineFragment cuisineFragmentF;
    CategoryFragment categoryFragment;
    Cooking_methodFragment cooking_methodFragment;
    ResultFragment resultFragment;
    String tmp1, tmp2, tmp3, tmp4;

    private OnFragmentInteractionListener mListener;

    public SQLiteDatabase sqLiteDatabase;
    public DBHelper dbHelper;

   //Описание курсора
    Cursor cursor;
    final String LOG_TAG = "myLogs";

    public MyRecipeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MyRecipeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MyRecipeFragment newInstance(String param1, String param2) {
        MyRecipeFragment fragment = new MyRecipeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        tF = new TimeFragment();
        cuisineFragmentF = new CuisineFragment();
        categoryFragment = new CategoryFragment();
        cooking_methodFragment = new Cooking_methodFragment();
        resultFragment = new ResultFragment();
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }



    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        tmp1 = "";
        tmp2 = "";
        tmp3 = "";
        tmp4 = "";

        view = inflater.inflate(R.layout.fragment_my_recipe, container, false);


        //подлючаемся к базе данных
        dbHelper = new DBHelper(view.getContext());
        sqLiteDatabase = dbHelper.getWritableDatabase();

        Typeface rec = Typeface.createFromAsset(getActivity().getAssets(), "Mateur.ttf");

        time = (Button) view.findViewById(R.id.timeB);
        time.setTypeface(rec);
        cuisine = (Button) view.findViewById(R.id.cuisineB);
        cuisine.setTypeface(rec);
        category = (Button) view.findViewById(R.id.categoryB);
        category.setTypeface(rec);
        cookingMethod = (Button) view.findViewById(R.id.CookingmethodB);
        cookingMethod.setTypeface(rec);
        dopSearch = (Button) view.findViewById(R.id.dopSearch);
        dopSearch.setTypeface(rec);
        time.setOnClickListener(this);
        cuisine.setOnClickListener(this);
        category.setOnClickListener(this);
        cookingMethod.setOnClickListener(this);
        dopSearch.setOnClickListener(this);

        for (int i=0; i<staticString.SearchCuisine.size(); i++) {
            if (i!=staticString.SearchCuisine.size()-1)
                tmp1+=staticString.SearchCuisine.get(i)+" or ";
            else
                tmp1+=staticString.SearchCuisine.get(i);
        }
        for (int i=0; i<staticString.SearchCategory.size(); i++) {
            if (i!=staticString.SearchCategory.size()-1)
                tmp2+=staticString.SearchCategory.get(i)+" or ";
            else
                tmp2+=staticString.SearchCategory.get(i);
        }
        for (int i=0; i<staticString.SearchCookingMethod.size(); i++) {
            if (i!=staticString.SearchCookingMethod.size()-1)
                tmp3+=staticString.SearchCookingMethod.get(i)+" or ";
            else
                tmp3+=staticString.SearchCookingMethod.get(i);
        }
        for (int i=0; i<staticString.SearchTime.size(); i++) {
            if (i!=staticString.SearchTime.size()-1)
                tmp4+=staticString.SearchTime.get(i)+" or ";
            else
                tmp4+=staticString.SearchTime.get(i);
        }

        if (tmp1 == "")
            tmp1 = "Cuisine_ID";
        if (tmp2 == "")
            tmp2 = "Category_ID";
        if (tmp3 == "")
            tmp3 = "Cooking_method_ID";
        if (tmp4 == "")
            tmp4 = "Time_ID";

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
        switch (v.getId()){
            case R.id.timeB:
                fTrans.replace(R.id.conteiner, tF);
                break;
            case R.id.cuisineB:
                fTrans.replace(R.id.conteiner, cuisineFragmentF);
                break;
            case R.id.categoryB:
                fTrans.replace(R.id.conteiner, categoryFragment);
                break;
            case R.id.CookingmethodB:
                fTrans.replace(R.id.conteiner, cooking_methodFragment);
                break;
            case R.id.dopSearch:

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
                    String inquiry = "select Recipe_name, Cuisine_name, Category_name, Method_name, Time_name, Description_cooking_method, Caloric_content "
                            + "from Recipe "
                            + "inner join Cuisine on Rec_Cuisine_ID = Cuisine_ID "
                            + "inner join Category on Rec_Category_ID = Category_ID "
                            + "inner join Cooking_method on Rec_Cooking_method_ID = Cooking_method_ID "
                            + "inner join Time on Rec_Time_ID = Time_ID "
                            + "inner join Composition on Recipe_ID = Comp_recipe_ID "
                            + "where (Cuisine_ID = " + tmp1 + " and Category_ID = " + tmp2
                            + " and Cooking_method_ID = " + tmp3 +" and Time_ID = " + tmp4
                            + ") and Recipe_ID in "
                            + "(select Recipe_ID "
                            + "from Composition "
                            + "inner join Recipe on Recipe_ID = Comp_Recipe_ID "
                            + "where " + staticString.Products + " group by Recipe_ID "
                            + "having count(Comp_ingredient_ID)=" + chislo + " order by Recipe_ID) "
                            + "group by Recipe_ID";
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
                else {
                    String inquiry = "select Recipe_name, Cuisine_name, Category_name, Method_name, Time_name, Description_cooking_method, Caloric_content "
                            + "from Recipe "
                            + "inner join Cuisine on Rec_Cuisine_ID = Cuisine_ID "
                            + "inner join Category on Rec_Category_ID = Category_ID "
                            + "inner join Cooking_method on Rec_Cooking_method_ID = Cooking_method_ID "
                            + "inner join Time on Rec_Time_ID = Time_ID "
                            + "inner join Composition on Recipe_ID = Comp_recipe_ID "
                            + "where (Cuisine_ID = " + tmp1 + " and Category_ID = " + tmp2
                            + " and Cooking_method_ID = " + tmp3 +" and Time_ID = " + tmp4
                            + ") "
                            + "group by Recipe_ID";
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
                fTrans.replace(R.id.conteiner, resultFragment);
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
