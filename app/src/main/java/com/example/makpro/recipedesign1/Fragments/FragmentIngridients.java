package com.example.makpro.recipedesign1.Fragments;

import android.app.FragmentTransaction;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
//import android.support.v4.app.Fragment;
import  android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

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
    Button meatB, veganB, result, milkB, fruitB, cornB, nutB, herbB, seasoningB;
    View view;
    MeatFragment mF;
    vegetableFragment vF;
    fruit fruitF;
    milk milkF;
    corn cornF;
    nut nutF;
    herb herbF;
    seasoning seasoningF;
    ResultFragment rF;
    TextView txt;
    FragmentTransaction fTrans;
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

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

        staticString.str = new ArrayList<String>();
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        String tmp = "";
        view = inflater.inflate(R.layout.fragment_fragment_ingridients, container, false);
        meatB = (Button) view.findViewById(R.id.meatButton);
        cornB = (Button) view.findViewById(R.id.cornBN);
        veganB = (Button) view.findViewById(R.id.vegetableButton);
        milkB = (Button) view.findViewById(R.id.milkB);
        fruitB = (Button) view.findViewById(R.id.fruitButton);
        result = (Button) view.findViewById(R.id.search);
        nutB = (Button) view.findViewById(R.id.nutButton);
        herbB = (Button) view.findViewById(R.id.herbButton);
        seasoningB = (Button) view.findViewById(R.id.seasoningButton);
        result.setOnClickListener(this);
        meatB.setOnClickListener(this);
        veganB.setOnClickListener(this);
        milkB.setOnClickListener(this);
        fruitB.setOnClickListener(this);
        cornB.setOnClickListener(this);
        nutB.setOnClickListener(this);
        herbB.setOnClickListener(this);
        seasoningB.setOnClickListener(this);
        txt = (TextView) view.findViewById(R.id.textView2);
        txt.setText(tmp);
        for (int i=0; i<staticString.str.size(); i++) {
            if (i!=staticString.str.size()-1)
            tmp+=staticString.str.get(i)+" or ";
            else
                tmp+=staticString.str.get(i);
        }
        txt.setText(tmp);
//-------------------------------------------------------------------------------------------------
        String chislo = Integer.toString(staticString.str.size());
        String inquiry = "select Recipe_name, Cuisine_name, Category_name, Method_name, Time_name, Description_cooking_method, Caloric_content"
                +"from Recipe "
                +"inner join Cuisine on Rec_Cuisine_ID = Cuisine_ID "
                +"inner join Category on Rec_Category_ID = Category_ID "
                +"inner join Cooking_method on Rec_Cooking_method_ID = Cooking_method_ID "
                +"inner join Time on Rec_Time_ID = Time_ID "
                +"inner join Composition on Recipe_ID = Comp_recipe_ID "
                +"where Recipe_ID in "
                +"(select Recipe_ID "
                +"from Composition "
                +"inner join Recipe on Recipe_ID = Comp_Recipe_ID "
                +"where"+ tmp + " group by Recipe_ID "
                +"having count(Comp_ingredient_ID)="+chislo +" order by Recipe_ID) "
                +"group by Recipe_ID";
//-----------11--------------------------------------------------------------------------------------
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
        switch(v.getId()) {
            case R.id.meatButton:
                fTrans.replace(R.id.conteiner, mF);
                break;
            case R.id.vegetableButton:
                fTrans.replace(R.id.conteiner, vF);
                break;
            case R.id.milkB:
                fTrans.replace(R.id.conteiner, milkF);
                break;
            case R.id.search:
                fTrans.replace(R.id.conteiner, rF);
                break;
            case R.id.fruitButton:
                fTrans.replace(R.id.conteiner, fruitF);
                break;
            case R.id.cornBN:
                fTrans.replace(R.id.conteiner, cornF);
                break;
            case R.id.nutButton:
                fTrans.replace(R.id.conteiner, nutF);
                break;
            case R.id.herbButton:
                fTrans.replace(R.id.conteiner, herbF);
                break;
            case R.id.seasoningButton:
                fTrans.replace(R.id.conteiner, seasoningF);
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
