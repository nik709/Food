package com.example.makpro.recipedesign1.Fragments;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.renderscript.Type;
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
 * {@link CuisineFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link CuisineFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CuisineFragment extends Fragment implements View.OnClickListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    View view;
    CheckBox Russia, Europe, Asia, Kavkas;
    Button apply;

    private OnFragmentInteractionListener mListener;

    public CuisineFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CuisineFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static CuisineFragment newInstance(String param1, String param2) {
        CuisineFragment fragment = new CuisineFragment();
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
        view = inflater.inflate(R.layout.fragment_cuisine, container, false);

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
        apply = (Button) view.findViewById(R.id.CuisineApply);
        apply.setTypeface(general1);
        Russia = (CheckBox) view.findViewById(R.id.CBRussia);
        Russia.setTypeface(general);
        Europe= (CheckBox) view.findViewById(R.id.CBEurope);
        Europe.setTypeface(general);
        Asia= (CheckBox) view.findViewById(R.id.CBAsia);
        Asia.setTypeface(general);
        Kavkas = (CheckBox) view.findViewById(R.id.CBKavkas);
        Kavkas.setTypeface(general);
        apply.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {
                if (Russia.isChecked()) {
                    staticString.str.remove("Russia");
                    staticString.str.add("Russia");
                }
                else
                    staticString.str.remove("Russia");

                if (Europe.isChecked()) {
                    staticString.str.remove("Europe");
                    staticString.str.add("Europe");
                }
                else
                    staticString.str.remove("Europe");

                if (Asia.isChecked()) {
                    staticString.str.remove("Asia");
                    staticString.str.add("Asia");
                }
                else
                    staticString.str.remove("Asia");

                if (Kavkas.isChecked()) {
                    staticString.str.remove("Kavkas");
                    staticString.str.add("Kavkas");
                }
                else
                    staticString.str.remove("Kavkas");


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
