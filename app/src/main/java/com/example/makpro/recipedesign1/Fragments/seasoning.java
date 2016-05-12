package com.example.makpro.recipedesign1.Fragments;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
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
 * {@link seasoning.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link seasoning#newInstance} factory method to
 * create an instance of this fragment.
 */
public class seasoning extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    CheckBox sugar, salt, pepper, vanilla, cinnamon;
    View view;
    Button apply;
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public seasoning() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment seasoning.
     */
    // TODO: Rename and change types and number of parameters
    public static seasoning newInstance(String param1, String param2) {
        seasoning fragment = new seasoning();
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
        view = inflater.inflate(R.layout.fragment_seasoning, container, false);
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
        cinnamon = (CheckBox) view.findViewById(R.id.cinnamonBox);
        salt = (CheckBox) view.findViewById(R.id.saltBox);
        sugar = (CheckBox) view.findViewById(R.id.sugarBox);
        pepper = (CheckBox) view.findViewById(R.id.pepperBox);
        vanilla = (CheckBox) view.findViewById(R.id.vanillaBox);
        apply = (Button) view.findViewById(R.id.applySeasoning);
        apply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (cinnamon.isChecked())
                {
                    staticString.str.remove("158");
                    staticString.str.add("158");
                }
                else
                    staticString.str.remove("158");
                if (vanilla.isChecked())
                {
                    staticString.str.remove("159");
                    staticString.str.add("159");
                }
                else
                    staticString.str.remove("159");
                if (pepper.isChecked())
                {
                    staticString.str.remove("157");
                    staticString.str.add("157");
                }
                else
                    staticString.str.remove("157");
                if (salt.isChecked())
                {
                    staticString.str.remove("156");
                    staticString.str.add("156");
                }
                else
                    staticString.str.remove("156");
                if (sugar.isChecked())
                {
                    staticString.str.remove("160");
                    staticString.str.add("160");
                }
                else
                    staticString.str.remove("160");
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
