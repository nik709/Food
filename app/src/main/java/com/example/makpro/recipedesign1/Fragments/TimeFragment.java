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
 * {@link TimeFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link TimeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TimeFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    View view;
    CheckBox time1, time2, time3, time4, time5, time6, time7;
    Button apply;

    private OnFragmentInteractionListener mListener;

    public TimeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment TimeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static TimeFragment newInstance(String param1, String param2) {
        TimeFragment fragment = new TimeFragment();
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
        view = inflater.inflate(R.layout.fragment_time, container, false);
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
        apply = (Button) view.findViewById(R.id.ApplyTime);
        time1 = (CheckBox) view.findViewById(R.id.CBtime1);
        time2 = (CheckBox) view.findViewById(R.id.CBtime2);
        time3 = (CheckBox) view.findViewById(R.id.CBtime3);
        time4 = (CheckBox) view.findViewById(R.id.CBtime4);
        time5 = (CheckBox) view.findViewById(R.id.CBtime5);
        time6 = (CheckBox) view.findViewById(R.id.CBtime6);
        time7 = (CheckBox) view.findViewById(R.id.CBtime7);
        apply.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {
                if (time1.isChecked()) {
                    staticString.str.remove("time1");
                    staticString.str.add("time1");
                }
                else
                    staticString.str.remove("time1");

                if (time2.isChecked()) {
                    staticString.str.remove("time2");
                    staticString.str.add("time2");
                }
                else
                    staticString.str.remove("time2");

                if (time3.isChecked()) {
                    staticString.str.remove("time3");
                    staticString.str.add("time3");
                }
                else
                    staticString.str.remove("time3");

                if (time4.isChecked()) {
                    staticString.str.remove("time4");
                    staticString.str.add("time4");
                }
                else
                    staticString.str.remove("time4");

                if (time5.isChecked()) {
                    staticString.str.remove("time5");
                    staticString.str.add("time5");
                }
                else
                    staticString.str.remove("time5");

                if (time6.isChecked()) {
                    staticString.str.remove("time6");
                    staticString.str.add("time6");
                }
                else
                    staticString.str.remove("time6");

                if (time7.isChecked()) {
                    staticString.str.remove("time7");
                    staticString.str.add("time7");
                }
                else
                    staticString.str.remove("time7");

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
