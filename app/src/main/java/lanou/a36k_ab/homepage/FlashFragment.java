package lanou.a36k_ab.homepage;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import lanou.a36k_ab.R;

/**
 * Created by dllo on 16/10/24.
 */
public class FlashFragment extends android.support.v4.app.Fragment {
//    ExpandTextView textView;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_homepage_flash,container,false);
    }

//    @Override
//    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
//        super.onViewCreated(view, savedInstanceState);
//        textView= (ExpandTextView)view.findViewById(R.id.cusTextView);
//        textView.updateText(getResources().getString(R.string.test_expandtext));
//
//    }
//
//    @Override
//    public void onResume() {
//        super.onResume();
//    }
}
