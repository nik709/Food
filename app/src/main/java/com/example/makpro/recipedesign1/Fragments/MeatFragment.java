package com.example.makpro.recipedesign1.Fragments;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.ContentValues;
import android.content.Context;
import android.content.res.Resources;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
//import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;

import com.example.makpro.recipedesign1.R;
import com.example.makpro.recipedesign1.staticString;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link MeatFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link MeatFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MeatFragment extends Fragment implements View.OnClickListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    View view;
    CheckBox chicken;
    CheckBox Pig;
    CheckBox turkey;
    CheckBox cow;
    CheckBox rabbit;
    CheckBox bear;
    Button apply;
    Button choose_all;
    Fragment fr;
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public MeatFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MeatFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MeatFragment newInstance(String param1, String param2) {
        MeatFragment fragment = new MeatFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        fr = this;
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_meat2,container, false);
        apply = (Button) view.findViewById(R.id.apply);
        chicken = (CheckBox) view.findViewById(R.id.CBchicken);
        Pig =(CheckBox) view.findViewById(R.id.CBpig);
        turkey =(CheckBox) view.findViewById(R.id.CBturkey);
        cow =(CheckBox) view.findViewById(R.id.CBcow);
        rabbit =(CheckBox) view.findViewById(R.id.CBrabbit);
        bear =(CheckBox) view.findViewById(R.id.CBbear);
        apply.setOnClickListener(new View.OnClickListener(){
           @Override
            public void onClick(View v)
           {
               if (chicken.isChecked()) {
                   staticString.str.remove("Comp_Ingredient_ID = 135");
                   staticString.str.add("Comp_Ingredient_ID = 135");
               }
               else
                   staticString.str.remove("Comp_Ingredient_ID = 135");

               if (Pig.isChecked()) {
                   staticString.str.remove("Comp_Ingredient_ID = 134");
                   staticString.str.add("Comp_Ingredient_ID = 134");
               }
               else
                   staticString.str.remove("Comp_Ingredient_ID = 134");

               if (turkey.isChecked()) {
                   staticString.str.remove("Comp_Ingredient_ID = 136");
                   staticString.str.add("Comp_Ingredient_ID = 136");
               }
               else
                   staticString.str.remove("Comp_Ingredient_ID = 136");

               if (cow.isChecked()) {
                   staticString.str.remove("Comp_Ingredient_ID = 133");
                   staticString.str.add("Comp_Ingredient_ID = 133");
               }
               else
                   staticString.str.remove("Comp_Ingredient_ID = 133");

               if (rabbit.isChecked()) {
                   staticString.str.remove("Comp_Ingredient_ID = 133");
                   staticString.str.add("Comp_Ingredient_ID = 133");
               }
               else
                   staticString.str.remove("Comp_Ingredient_ID = 133");

               if (bear.isChecked()) {
                   staticString.str.remove("bear");
                   staticString.str.add("bear");
               }
               else
                   staticString.str.remove("bear");

               FragmentManager fm = getFragmentManager();
               fm.popBackStack();
               FragmentTransaction ft = fm.beginTransaction();
               ft.commit();
           }
        });
        choose_all = (Button) view.findViewById(R.id.choose_all);
        choose_all.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                
            }
        });
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
