package lanou.a36k_ab.homepage;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.util.AttributeSet;
import android.view.View;

import lanou.a36k_ab.R;

/**
 * Created by dllo on 16/10/22.
 */
public class HomepageActivity extends AppCompatActivity {
    @Override
    public View onCreateView(String name, Context context, AttributeSet attrs) {
        return super.onCreateView(name, context, attrs);
        setContentView(R.layout.activity_homepage);
    }
}
