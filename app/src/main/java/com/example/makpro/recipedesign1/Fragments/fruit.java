package com.example.makpro.recipedesign1.Fragments;

import android.content.Context;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;

import com.example.makpro.recipedesign1.R;
import com.example.makpro.recipedesign1.staticString;
/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link fruit.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link fruit#newInstance} factory method to
 * create an instance of this fragment.
 */
public class fruit extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    View view;
    CheckBox apple;
    CheckBox pear;
    CheckBox grape;
    CheckBox orange;
    CheckBox banana;
    CheckBox ananas;
    Button apply;

    private OnFragmentInteractionListener mListener;

    public fruit() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment fruit.
     */
    // TODO: Rename and change types and number of parameters
    public static fruit newInstance(String param1, String param2) {
        fruit fragment = new fruit();
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
        view = inflater.inflate(R.layout.fragment_fruit, container, false);
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
        Typeface general = Typeface.createFromAsset(getActivity().getAssets(), "Peace Sans Webfont.ttf");
        Typeface general1 = Typeface.createFromAsset(getActivity().getAssets(), "Mateur.ttf");
        apple = (CheckBox) view.findViewById(R.id.appleB);
        apple.setTypeface(general);
        pear = (CheckBox) view.findViewById(R.id.pearB);
        pear.setTypeface(general);
        orange = (CheckBox) view.findViewById(R.id.orangeB);
        orange.setTypeface(general);
        ananas = (CheckBox) view.findViewById(R.id.ananasB);
        ananas.setTypeface(general);
        banana = (CheckBox) view.findViewById(R.id.bananaB);
        banana.setTypeface(general);
        grape = (CheckBox) view.findViewById(R.id.grapeB);
        grape.setTypeface(general);
        apply = (Button) view.findViewById(R.id.applyF);
        apply.setTypeface(general1);
        apply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (apple.isChecked())
                {
                    staticString.str.remove("101");
                    staticString.str.add("101");
                }
                else
                    staticString.str.remove("101");
                if (pear.isChecked())
                {
                    staticString.str.remove("104");
                    staticString.str.add("104");
                }
                else
                    staticString.str.remove("104");
                if (orange.isChecked())
                {
                    staticString.str.remove("103");
                    staticString.str.add("103");
                }
                else
                    staticString.str.remove("103");
                if (ananas.isChecked())
                {
                    staticString.str.remove("106");
                    staticString.str.add("106");
                }
                else
                    staticString.str.remove("106");
                if (banana.isChecked())
                {
                    staticString.str.remove("102");
                    staticString.str.add("102");
                }
                else
                    staticString.str.remove("102");
                if (grape.isChecked())
                {
                    staticString.str.remove("105");
                    staticString.str.add("105");
                }
                else
                    staticString.str.remove("105");
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
