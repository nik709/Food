package com.example.makpro.recipedesign1.Fragments;

import android.app.FragmentTransaction;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.makpro.recipedesign1.DBHelper;
import com.example.makpro.recipedesign1.R;
import com.example.makpro.recipedesign1.staticString;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link AddRecipeFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link AddRecipeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AddRecipeFragment extends Fragment implements View.OnClickListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    View view;
    Button addIngr, addTime, addCuisine, addCategory, addMethod, addDescription,addCalories ,ADD;
    ContentValues contentValues;

    FragmentTransaction fTrans;
    FragmentIngridients fragmentIngridients;
    TimeFragment timeFragment;
    CuisineFragment cuisineFragment;
    CategoryFragment categoryFragment;
    Cooking_methodFragment cooking_methodFragment;
    AddDescriptionFragment addDescriptionFragment;
    addCaloriesFragment addCaloriesFragment;

    final String LOG_TAG = "myLogs";
    public SQLiteDatabase sqLiteDatabase;
    public DBHelper dbHelper;

    Cursor cursor;

    private OnFragmentInteractionListener mListener;

    public AddRecipeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment AddRecipeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static AddRecipeFragment newInstance(String param1, String param2) {
        AddRecipeFragment fragment = new AddRecipeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        fragmentIngridients = new FragmentIngridients();
        timeFragment = new TimeFragment();
        cuisineFragment = new CuisineFragment();
        categoryFragment = new CategoryFragment();
        cooking_methodFragment = new Cooking_methodFragment();
        addDescriptionFragment = new AddDescriptionFragment();
        addCaloriesFragment = new addCaloriesFragment();
        staticString.addTime = new ArrayList<String>();
        staticString.addCuisine = new ArrayList<String>();
        staticString.addCategory = new ArrayList<String>();
        staticString.addCookingMethod = new ArrayList<String>();

        contentValues = new ContentValues();
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_add_recipe, container, false);
        Typeface gen1 = Typeface.createFromAsset(getActivity().getAssets(), "Peace Sans Webfont.ttf");
        Typeface gen = Typeface.createFromAsset(getActivity().getAssets(), "Mateur.ttf");
        addIngr = (Button) view.findViewById(R.id.addIngr);
        addIngr.setTypeface(gen);
        addTime = (Button) view.findViewById(R.id.addTime);
        addTime.setTypeface(gen);
        addCuisine = (Button) view.findViewById(R.id.addCuisine);
        addCuisine.setTypeface(gen);
        addCategory = (Button) view.findViewById(R.id.addCategory);
        addCategory.setTypeface(gen);
        addMethod = (Button) view.findViewById(R.id.addMethod);
        addMethod.setTypeface(gen);
        addDescription = (Button) view.findViewById(R.id.addDescription);
        addDescription.setTypeface(gen);
        addCalories = (Button) view.findViewById(R.id.addCalories);
        addCalories.setTypeface(gen);
        ADD = (Button) view.findViewById(R.id.ADD);
        ADD.setTypeface(gen1);
        ADD.setOnClickListener(this);
        addIngr.setOnClickListener(this);
        addTime.setOnClickListener(this);
        addCuisine.setOnClickListener(this);
        addCategory.setOnClickListener(this);
        addMethod.setOnClickListener(this);
        addDescription.setOnClickListener(this);
        addCalories.setOnClickListener(this);
        //подлючаемся к базе данных
        dbHelper = new DBHelper(view.getContext());
        sqLiteDatabase = dbHelper.getWritableDatabase();


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

    @Override
    public void onClick(View v) {
        fTrans = getFragmentManager().beginTransaction();
        switch (v.getId())
        {
            case R.id.addIngr:
                fTrans.replace(R.id.conteiner, fragmentIngridients);
                break;
            case R.id.addTime:
                fTrans.replace(R.id.conteiner, timeFragment);
                break;
            case R.id.addCuisine:
                fTrans.replace(R.id.conteiner, cuisineFragment);
                break;
            case R.id.addCategory:
                fTrans.replace(R.id.conteiner, categoryFragment);
                break;
            case R.id.addMethod:
                fTrans.replace(R.id.conteiner, cooking_methodFragment);
                break;
            case R.id.addDescription:
                fTrans.replace(R.id.conteiner, addDescriptionFragment);
                break;
            case R.id.ADD:
                //ДОБАВЛЕНИЕ РЕЦЕПТА В БД
                String last = "select Recipe_ID from Recipe ORDER by Recipe_ID DESC LIMIT 1";
                cursor = sqLiteDatabase.rawQuery(last,null);
                int colRecMaxId = cursor.getColumnIndex("Recipe_ID");
                logCursor(cursor);
                Log.d(LOG_TAG,Integer.toString(colRecMaxId));
                cursor.moveToFirst();
                int lastID = cursor.getInt(colRecMaxId);
                Log.d(LOG_TAG,String.valueOf(staticString.addCategory));
                Log.d(LOG_TAG,String.valueOf(staticString.addCaloricContent));

                contentValues.put("Recipe_ID", lastID+1);
                contentValues.put("Rec_Cuisine_ID", String.valueOf(staticString.addCuisine.get(0)));
                contentValues.put("Rec_Category_ID", String.valueOf(staticString.addCategory.get(0)));
                contentValues.put("Rec_Cooking_method_ID", String.valueOf(staticString.addCookingMethod.get(0)));
                contentValues.put("Rec_Time_ID", String.valueOf(staticString.addTime.get(0)));
                contentValues.put("Description_cooking_method", staticString.addDescription);
                contentValues.put("Recipe_name", staticString.addName);
                contentValues.put("Caloric_content", staticString.addCaloricContent);
                sqLiteDatabase.insert("Recipe",null,contentValues);
                cursor.close();

                contentValues.clear();

                cursor = sqLiteDatabase.query("Composition", null, null, null, null, null, null);
                logCursor(cursor);
                cursor.close();


                last = "select max(Comp_ID) from Composition";
                cursor = sqLiteDatabase.rawQuery(last,null);
                int colCompMaxId = cursor.getColumnIndex("max(Comp_ID)");
                cursor.moveToFirst();
                int lastCompID = cursor.getInt(colCompMaxId);
                int chislo = staticString.addIngridients.size();
                int j = 0;
                for (int i = (lastCompID+1); i<(lastCompID+chislo+1); i++)
                {
                    contentValues.put("Comp_ID", lastCompID+1+j);
                    contentValues.put("Comp_Ingredient_ID",staticString.addIngridients.get(j));
                    contentValues.put("Comp_recipe_ID",lastID+1);
                    sqLiteDatabase.insert("Composition", null, contentValues);
                    contentValues.clear();
                    j++;

                }
                cursor.close();
                break;
            case R.id.addCalories:
                fTrans.replace(R.id.conteiner, addCaloriesFragment);
                break;
        }
        fTrans.addToBackStack(null);
        fTrans.commit();
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
