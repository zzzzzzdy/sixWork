package activitytest.exmaple.com.chongyouapp;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class TabFragment extends Fragment {
    View baseView;
    ImageView mImage;
    TextView mText;
    int resID;
    String textString;

    public void setData(int resId, String text) {
        this.resID = resId;
        this.textString = text;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        baseView = inflater.inflate(R.layout.fragment_simple_layout, container, false);

        mImage = baseView.findViewById(R.id.iv_image);
        mText = baseView.findViewById(R.id.tv_text);

        mImage.setImageResource(resID);
        mText.setText(textString);
        return baseView;
    }
}