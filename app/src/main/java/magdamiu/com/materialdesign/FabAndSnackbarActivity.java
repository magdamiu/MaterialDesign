package magdamiu.com.materialdesign;

import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.design.widget.SwipeDismissBehavior;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Toast;

public class FabAndSnackbarActivity extends AppCompatActivity {

    private CoordinatorLayout mMainCoordinatorLayout;
    private CardView mCardView3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fab_and_snackbar);

        mMainCoordinatorLayout = (CoordinatorLayout) findViewById(R.id.cl_main);
    }

    public void showSnackbar(View view) {
        Snackbar.make(mMainCoordinatorLayout, getResources().getString(R.string.message_snackbar1), Snackbar.LENGTH_SHORT).
                setAction(getResources().getString(R.string.close), new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //custom action
                    }
                }).show();
    }
}
