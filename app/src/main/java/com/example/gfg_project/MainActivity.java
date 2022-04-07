package com.example.gfg_project;

import androidx.appcompat.app.AppCompatActivity;
import androidx.dynamicanimation.animation.DynamicAnimation;
import androidx.dynamicanimation.animation.SpringAnimation;
import androidx.dynamicanimation.animation.SpringForce;

import android.os.Bundle;
import android.view.View;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Creating a view for the imageView
        final View view =findViewById(R.id.imageView);

        //Setting up a spring animation to animate the view
        final SpringAnimation animation = new SpringAnimation(view, DynamicAnimation.TRANSLATION_Y,0f);

        //Setting the damping ratio to create a high bouncing effect
        animation.getSpring().setDampingRatio(SpringForce.DAMPING_RATIO_HIGH_BOUNCY);

        //Setting the spring with a very low stiffness
        animation.getSpring().setStiffness(SpringForce.STIFFNESS_VERY_LOW);

        //Registering the AnimationEnd listener
        //This will indicate the End of the animation
        animation.addEndListener(new DynamicAnimation.OnAnimationEndListener() {
            @Override
            public void onAnimationEnd(DynamicAnimation animation1, boolean canceled, float value, float velocity) {
                view.setY(50f);                             //set the image to the beginning of the Y axis
                animation.animateToFinalPosition(500f);     //Again starting the animation
            }
        });

        //setting a OnClickListener to the view
        //Starts the animation when the image is clicked
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                animation.animateToFinalPosition(500f);      //starts the animation
            }
        });

    }
}