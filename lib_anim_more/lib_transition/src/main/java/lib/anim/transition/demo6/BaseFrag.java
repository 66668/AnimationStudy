package lib.anim.transition.demo6;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;

import lib.anim.transition.R;

/**
 *
 */
public class BaseFrag extends Fragment {

    private static final String EXTRA_SAMPLE = "sample";

    public static BaseFrag newInstance() {
        BaseFrag fragment = new BaseFrag();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Log.d("SJY", "onCreateView");
        View view = inflater.inflate(R.layout.fragment_01, container, false);
        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.d("SJY", "onAttach");
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("SJY", "Fragment-onCreate");
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Log.d("SJY", "onViewCreated");
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.d("SJY", "onActivityCreated");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d("SJY", "Fragment-onStart");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d("SJY", "onResume");
    }
}
