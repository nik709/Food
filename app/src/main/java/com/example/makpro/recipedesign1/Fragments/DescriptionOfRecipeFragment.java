package com.example.makpro.recipedesign1.Fragments;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.makpro.recipedesign1.R;
import com.example.makpro.recipedesign1.staticString;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link DescriptionOfRecipeFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link DescriptionOfRecipeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DescriptionOfRecipeFragment extends Fragment implements View.OnClickListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    TextView RecipeName;
    TextView Description;
    Button addComment;
    View view;
    boolean comm;
    EditText editText;

    private OnFragmentInteractionListener mListener;

    public DescriptionOfRecipeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment DescriptionOfRecipeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static DescriptionOfRecipeFragment newInstance(String param1, String param2) {
        DescriptionOfRecipeFragment fragment = new DescriptionOfRecipeFragment();
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
        view = inflater.inflate(R.layout.fragment_description_of_recipe, container, false);

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

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        Typeface des = Typeface.createFromAsset(getActivity().getAssets(), "Mateur.ttf");
        Typeface name = Typeface.createFromAsset(getActivity().getAssets(), "Peace Sans Webfont.ttf");
        addComment = (Button) view.findViewById(R.id.addComment);
        addComment.setTypeface(name);
        addComment.setOnClickListener(this);
        RecipeName = (TextView) view.findViewById(R.id.IDRecipeName);
        RecipeName.setTypeface(name);
        Description = (TextView) view.findViewById(R.id.IDDescription);
        Description.setTypeface(des);
        RecipeName.setText(staticString.RecipeName);
        Description.setText(staticString.Description.get(staticString.IDofRecipe));
        comm = false;
        return  view;
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
        switch(v.getId()){
            case R.id.addComment:
                if (!comm) {
                    LinearLayout layout = (LinearLayout) view.findViewById(R.id.description);
                    LinearLayout.LayoutParams lParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                    int gravity = Gravity.LEFT; //по левому краю
                    lParams.gravity = gravity;
                    editText = new EditText(view.getContext());
                    editText.setMinWidth(300);
                    Button tmp = new Button(view.getContext());
                    tmp.setText("Принять");
                    layout.addView(editText, lParams);
                    layout.addView(tmp, lParams);
                    tmp.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            staticString.addComment=editText.getText().toString();
                        }
                    });
                    editText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                        @Override
                        public void onFocusChange(View v, boolean hasFocus) {
                            Context context = view.getContext();
                            InputMethodManager imm = (InputMethodManager)context.getSystemService(Context.INPUT_METHOD_SERVICE);
                            imm.hideSoftInputFromWindow(editText.getWindowToken(), 0);
                        }
                    });
                    comm=true;
                    break;
                }
        }
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
