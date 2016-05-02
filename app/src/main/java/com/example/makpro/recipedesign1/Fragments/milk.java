package com.example.makpro.recipedesign1.Fragments;

import android.content.Context;
import android.app.FragmentManager;
import android.app.FragmentTransaction;

import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
//import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;

import com.example.makpro.recipedesign1.R;
import com.example.makpro.recipedesign1.staticString;

import com.example.makpro.recipedesign1.R;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link milk.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link milk#newInstance} factory method to
 * create an instance of this fragment.
 */
public class milk extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    View view;
    CheckBox milk;
    CheckBox cheese;
    CheckBox curd;
    CheckBox sour;
    CheckBox cream;
    Button apply;
    private OnFragmentInteractionListener mListener;

    public milk() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment milk.
     */
    // TODO: Rename and change types and number of parameters
    public static milk newInstance(String param1, String param2) {
        milk fragment = new milk();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_milk, container, false);
        apply = (Button) view.findViewById(R.id.milkApply);
        milk = (CheckBox) view.findViewById(R.id.milkBox);
        cheese = (CheckBox) view.findViewById(R.id.cheeseBox);
        curd = (CheckBox) view.findViewById(R.id.curdBox);
        sour = (CheckBox) view.findViewById(R.id.sourBox);
        cream = (CheckBox) view.findViewById(R.id.creamBox);
        apply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (milk.isChecked())
                {
                    staticString.str.remove("milk");
                    staticString.str.add("milk");
                }
                else
                    staticString.str.remove("milk");
                if (cheese.isChecked())
                {
                    staticString.str.remove("cheese");
                    staticString.str.add("cheese");
                }
                else
                    staticString.str.remove("cheese");
                if (curd.isChecked())
                {
                    staticString.str.remove("kefir");
                    staticString.str.add("kefir");
                }
                else
                    staticString.str.remove("kefir");
                if (sour.isChecked())
                {
                    staticString.str.remove("sour");
                    staticString.str.add("sour");
                }
                else
                    staticString.str.remove("sour");
                if (cream.isChecked())
                {
                    staticString.str.remove("cream");
                    staticString.str.add("cream");
                }
                else
                    staticString.str.remove("cream");

                FragmentManager fm = getFragmentManager();
                fm.popBackStack();
                FragmentTransaction ft = fm.beginTransaction();
                ft.commit();
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
