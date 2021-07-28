package lib.anim.transition.demo5;

import android.os.Bundle;
import android.transition.ChangeBounds;
import android.transition.Slide;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.core.graphics.drawable.DrawableCompat;
import androidx.fragment.app.Fragment;

import lib.anim.transition.R;

/**
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
        View view = inflater.inflate(R.layout.fragment_01, container, false);
//        final Sample sample = (Sample) getArguments().getSerializable(EXTRA_SAMPLE);
//
//        final ImageView squareBlue = (ImageView) view.findViewById(R.id.img_01);
//        DrawableCompat.setTint(squareBlue.getDrawable(), sample.color);
//
//        view.findViewById(R.id.btn_01).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                addNextFragment(sample, squareBlue, false);
//            }
//        });
//
//        view.findViewById(R.id.btn_02).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                addNextFragment(sample, squareBlue, true);
//            }
//        });

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

        getParentFragmentManager().beginTransaction()
                .replace(R.id.fragment_layout, sharedElementFragment2)
                .addToBackStack(null)
                .addSharedElement(img, "img_01")
                .commit();
    }

}
