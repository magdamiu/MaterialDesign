package magdamiu.com.materialdesign;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.SwipeDismissBehavior;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.graphics.Palette;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private CardView mFabAndSnackbarCardView, mCollapseToolbarCardView;
    private TextView mFirstTextView, mSecondTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mFabAndSnackbarCardView = (CardView) findViewById(R.id.cv_fabAndSnackbar);
        mCollapseToolbarCardView = (CardView) findViewById(R.id.cv_collapseToolbar);

        mFirstTextView = (TextView) findViewById(R.id.tv_first);
        mSecondTextView = (TextView) findViewById(R.id.tv_second);

        computeTheBackgroundColor();

        mFabAndSnackbarCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, FabAndSnackbarActivity.class);
                startActivity(intent);
            }
        });

        mCollapseToolbarCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, CollapsingToolbarAndAppbarActivity.class);
                startActivity(intent);
            }
        });
    }

    private void computeTheBackgroundColor() {

        getImageColorData(R.drawable.card1, mFirstTextView);
        getImageColorData(R.drawable.card2, mSecondTextView);
    }

    private void getImageColorData(int imageId, final TextView textView) {

        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), imageId);
        Palette.Builder builder = Palette.from(bitmap);

        builder.generate(new Palette.PaletteAsyncListener() {
            @Override
            public void onGenerated(Palette palette) {
                /*
                Other options:
                palette.getDarkMutedColor(0);
                palette.getDarkVibrantColor(0);
                palette.getDominantColor(0);
                palette.getLightMutedColor(0);
                palette.getLightVibrantColor(0);
                palette.getMutedColor(0);
                palette.getVibrantColor(0);
                */
                textView.setBackgroundColor(palette.getVibrantColor(0));
            }
        });
    }
}
