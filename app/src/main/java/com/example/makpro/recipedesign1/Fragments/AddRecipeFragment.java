package com.example.makpro.recipedesign1.Fragments;

import android.app.FragmentTransaction;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

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
    Button addIngr, addTime, addCuisine, addCategory, addMethod, addDescription;

    FragmentTransaction fTrans;
    FragmentIngridients fragmentIngridients;
    TimeFragment timeFragment;
    CuisineFragment cuisineFragment;
    CategoryFragment categoryFragment;
    Cooking_methodFragment cooking_methodFragment;

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
        staticString.addTime = new ArrayList<String>();
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_add_recipe, container, false);
        addIngr = (Button) view.findViewById(R.id.addIngr);
        addTime = (Button) view.findViewById(R.id.addTime);
        addCuisine = (Button) view.findViewById(R.id.addCuisine);
        addCategory = (Button) view.findViewById(R.id.addCategory);
        addMethod = (Button) view.findViewById(R.id.addMethod);
        addDescription = (Button) view.findViewById(R.id.addDescription);
        addIngr.setOnClickListener(this);
        addTime.setOnClickListener(this);
        addCuisine.setOnClickListener(this);
        addCategory.setOnClickListener(this);
        addMethod.setOnClickListener(this);
        addDescription.setOnClickListener(this);
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
