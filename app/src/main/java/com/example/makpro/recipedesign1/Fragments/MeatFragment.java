package com.example.makpro.recipedesign1.Fragments;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.ContentValues;
import android.content.Context;
import android.content.res.Resources;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
//import android.support.v4.app.Fragment;
import android.view.KeyEvent;
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
        view = inflater.inflate(R.layout.fragment_meat2, container, false);
        Typeface general1 = Typeface.createFromAsset(getActivity().getAssets(), "Mateur.ttf");
        Typeface general = Typeface.createFromAsset(getActivity().getAssets(), "Peace Sans Webfont.ttf");
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
        apply = (Button) view.findViewById(R.id.apply);
        apply.setTypeface(general1);
        chicken = (CheckBox) view.findViewById(R.id.CBchicken);
        chicken.setTypeface(general);
        Pig = (CheckBox) view.findViewById(R.id.CBpig);
        Pig.setTypeface(general);
        turkey = (CheckBox) view.findViewById(R.id.CBturkey);
        turkey.setTypeface(general);
        cow = (CheckBox) view.findViewById(R.id.CBcow);
        cow.setTypeface(general);
        rabbit = (CheckBox) view.findViewById(R.id.CBrabbit);
        rabbit.setTypeface(general);
        bear = (CheckBox) view.findViewById(R.id.CBbear);
        bear.setTypeface(general);
        apply.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (chicken.isChecked()) {
                staticString.str.remove("135");
                staticString.str.add("135");
            } else
                staticString.str.remove("135");

            if (Pig.isChecked()) {
                staticString.str.remove("134");
                staticString.str.add("134");
            } else
                staticString.str.remove("134");

            if (turkey.isChecked()) {
                staticString.str.remove("136");
                staticString.str.add("136");
            } else
                staticString.str.remove("136");

            if (cow.isChecked()) {
                staticString.str.remove("133");
                staticString.str.add("133");
            } else
                staticString.str.remove("133");

            if (rabbit.isChecked()) {
                staticString.str.remove("137");
                staticString.str.add("137");
            } else
                staticString.str.remove("137");

            if (bear.isChecked()) {
                staticString.str.remove("174");
                staticString.str.add("174");
            } else
                staticString.str.remove("174");

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
