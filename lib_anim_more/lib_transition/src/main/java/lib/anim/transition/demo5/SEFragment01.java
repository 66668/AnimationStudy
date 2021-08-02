package lib.anim.transition.demo5;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.transition.ChangeBounds;
import android.transition.Slide;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.core.graphics.drawable.DrawableCompat;

import lib.anim.transition.R;

/**
 *
 */
public class SEFragment01 extends Fragment {

    private static final String EXTRA_SAMPLE = "sample";

    public static SEFragment01 newInstance() {
        SEFragment01 fragment = new SEFragment01();
        return fragment;
    }

    public static SEFragment01 newInstance(Sample sample) {

        Bundle args = new Bundle();

        args.putSerializable(EXTRA_SAMPLE, sample);
        SEFragment01 fragment = new SEFragment01();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Log.d("SJY", "onCreateView");
        View view = inflater.inflate(R.layout.fragment_01, container, false);
        final Sample sample = (Sample) getArguments().getSerializable(EXTRA_SAMPLE);

        final ImageView squareBlue = (ImageView) view.findViewById(R.id.img_01);
        DrawableCompat.setTint(squareBlue.getDrawable(), sample.color);

        view.findViewById(R.id.btn_01).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addNextFragment(sample, squareBlue, false);
            }
        });

        view.findViewById(R.id.btn_02).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addNextFragment(sample, squareBlue, true);
            }
        });

        return view;
    }

    private void addNextFragment(Sample sample, ImageView img, boolean overlap) {
        SEFragment02 sharedElementFragment2 = SEFragment02.newInstance(sample);

        Slide slideTransition = new Slide(Gravity.RIGHT);
        slideTransition.setDuration(400);

        ChangeBounds changeBoundsTransition = new ChangeBounds();
        changeBoundsTransition.setDuration(500);

        sharedElementFragment2.setEnterTransition(slideTransition);
        sharedElementFragment2.setAllowEnterTransitionOverlap(overlap);
        sharedElementFragment2.setAllowReturnTransitionOverlap(overlap);
        sharedElementFragment2.setSharedElementEnterTransition(changeBoundsTransition);

        getFragmentManager().beginTransaction()
                .replace(R.id.layout_frag, sharedElementFragment2)
                .addToBackStack(null)
                .addSharedElement(img, "img_01")
                .commit();
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
        Log.d("SJY", "onStart");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d("SJY", "onStart");
    }
}
