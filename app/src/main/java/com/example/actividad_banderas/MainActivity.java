package com.example.actividad_banderas;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ConstraintLayout constraintLayout = findViewById(R.id.main);

        LinearLayout alemania = new LinearLayout(this);
        alemania.setId(View.generateViewId());
        alemania.setOrientation(LinearLayout.VERTICAL);
        ConstraintLayout.LayoutParams alemaniaParams = new ConstraintLayout.LayoutParams(
                ConstraintLayout.LayoutParams.MATCH_CONSTRAINT,
                ConstraintLayout.LayoutParams.MATCH_CONSTRAINT
        );
        alemaniaParams.setMargins(16, 16, 16, 16);
        constraintLayout.addView(alemania, alemaniaParams);

        View viewBlack = new View(this);
        viewBlack.setBackgroundColor(0xFF000000);
        LinearLayout.LayoutParams viewParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                0
        );
        viewParams.weight = 1;
        alemania.addView(viewBlack, viewParams);

        View viewRed = new View(this);
        viewRed.setBackgroundColor(0xFFFF0000);
        alemania.addView(viewRed, viewParams);

        View viewYellow = new View(this);
        viewYellow.setBackgroundColor(0xFFFFD700);
        alemania.addView(viewYellow, viewParams);

        LinearLayout colombia = new LinearLayout(this);
        colombia.setId(View.generateViewId());
        colombia.setOrientation(LinearLayout.VERTICAL);
        ConstraintLayout.LayoutParams colombiaParams = new ConstraintLayout.LayoutParams(
                ConstraintLayout.LayoutParams.MATCH_CONSTRAINT,
                ConstraintLayout.LayoutParams.MATCH_CONSTRAINT
        );
        colombiaParams.setMargins(16, 16, 16, 16);
        constraintLayout.addView(colombia, colombiaParams);

        View viewYellowColombia = new View(this);
        viewYellowColombia.setBackgroundColor(0xFFFFD700);
        LinearLayout.LayoutParams viewYellowParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                0
        );
        viewYellowParams.weight = 2;
        colombia.addView(viewYellowColombia, viewYellowParams);

        View viewBlue = new View(this);
        viewBlue.setBackgroundColor(0xFF0000FF);
        colombia.addView(viewBlue, viewParams);

        View viewRedColombia = new View(this);
        viewRedColombia.setBackgroundColor(0xFFFF0000);
        colombia.addView(viewRedColombia, viewParams);

        ConstraintSet constraintSet = new ConstraintSet();
        constraintSet.clone(constraintLayout);

        constraintSet.connect(alemania.getId(), ConstraintSet.TOP, ConstraintSet.PARENT_ID, ConstraintSet.TOP);
        constraintSet.connect(alemania.getId(), ConstraintSet.BOTTOM, colombia.getId(), ConstraintSet.TOP);
        constraintSet.connect(alemania.getId(), ConstraintSet.START, ConstraintSet.PARENT_ID, ConstraintSet.START);
        constraintSet.connect(alemania.getId(), ConstraintSet.END, ConstraintSet.PARENT_ID, ConstraintSet.END);

        constraintSet.connect(colombia.getId(), ConstraintSet.TOP, alemania.getId(), ConstraintSet.BOTTOM);
        constraintSet.connect(colombia.getId(), ConstraintSet.BOTTOM, ConstraintSet.PARENT_ID, ConstraintSet.BOTTOM);
        constraintSet.connect(colombia.getId(), ConstraintSet.START, ConstraintSet.PARENT_ID, ConstraintSet.START);
        constraintSet.connect(colombia.getId(), ConstraintSet.END, ConstraintSet.PARENT_ID, ConstraintSet.END);

        constraintSet.applyTo(constraintLayout);
    }
}
