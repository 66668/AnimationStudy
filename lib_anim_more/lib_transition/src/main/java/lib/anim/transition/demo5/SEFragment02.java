package lib.anim.transition.demo5;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.core.graphics.drawable.DrawableCompat;

import lib.anim.transition.R;

public class SEFragment02 extends Fragment {
    private static final String EXTRA_SAMPLE = "sample";

    public static SEFragment02 newInstance(Sample sample) {
        Bundle args = new Bundle();
        args.putSerializable(EXTRA_SAMPLE, sample);
        SEFragment02 fragment = new SEFragment02();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_02, container, false);
        Sample sample = (Sample) getArguments().getSerializable(EXTRA_SAMPLE);

        ImageView squareBlue = (ImageView) view.findViewById(R.id.img02);
        DrawableCompat.setTint(squareBlue.getDrawable(), sample.color);

        return view;
    }

}
