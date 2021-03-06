package com.example.makpro.recipedesign1.Fragments;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
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
 * {@link juice.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link juice#newInstance} factory method to
 * create an instance of this fragment.
 */
public class juice extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    CheckBox tomato, apple, orange, lemon;
    Button apply;
    View view;
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public juice() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment juice.
     */
    // TODO: Rename and change types and number of parameters
    public static juice newInstance(String param1, String param2) {
        juice fragment = new juice();
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
        view = inflater.inflate(R.layout.fragment_juice, container, false);
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
        Typeface gen = Typeface.createFromAsset(getActivity().getAssets(), "Peace Sans Webfont.ttf");
        Typeface gen1 = Typeface.createFromAsset(getActivity().getAssets(), "Mateur.ttf");
        apply = (Button) view.findViewById(R.id.applyJuice);
        apply.setTypeface(gen1);
        lemon = (CheckBox) view.findViewById(R.id.lemonjBox);
        lemon.setTypeface(gen);
        orange = (CheckBox) view.findViewById(R.id.orangejBox);
        orange.setTypeface(gen);
        apple = (CheckBox) view.findViewById(R.id.applejBox);
        apple.setTypeface(gen);
        tomato = (CheckBox) view.findViewById(R.id.tomatojBox);
        tomato.setTypeface(gen);
        apply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (tomato.isChecked())
                {
                    staticString.str.remove("173");
                    staticString.str.add("173");
                }
                else
                    staticString.str.remove("173");
                if (orange.isChecked())
                {
                    staticString.str.remove("171");
                    staticString.str.add("171");
                }
                else
                    staticString.str.remove("171");
                if (apple.isChecked())
                {
                    staticString.str.remove("172");
                    staticString.str.add("172");
                }
                else
                    staticString.str.remove("172");
                if (lemon.isChecked())
                {
                    staticString.str.remove("170");
                    staticString.str.add("170");
                }
                else
                    staticString.str.remove("170");

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
