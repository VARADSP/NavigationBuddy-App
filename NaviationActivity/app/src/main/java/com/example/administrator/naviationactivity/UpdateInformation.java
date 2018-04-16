package com.example.administrator.naviationactivity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.FragmentManager;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;
import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;
import com.basgeekball.awesomevalidation.utility.RegexTemplate;

public class UpdateInformation extends AppCompatActivity {
    ImageView imageView;
    RatingBar rb;
    TextView value;
    EditText fname,cnumber,ampaid,feed;
    Button submit;
    AwesomeValidation awesomeValidation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_information);
        Button Clickhere = (Button) findViewById(R.id.oswald);
        Clickhere.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view6) {
                Intent i8 = new Intent(UpdateInformation.this, signaturepad.class);
                startActivity(i8);
            }
        });


        Button Clickme = (Button) findViewById(R.id.noddy);
        Clickme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view7) {
                Intent i6 = new Intent(UpdateInformation.this, camera.class);
                startActivity(i6);
            }
        });


        awesomeValidation = new AwesomeValidation(ValidationStyle.BASIC);
        updateUI();
        rb = (RatingBar) findViewById(R.id.ratingBar);
        value = (TextView) findViewById(R.id.value);

        rb.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                value.setText("Value is " + rating);
            }
        });


    }
    private void updateUI() {
        fname = (EditText) findViewById(R.id.fname);
        cnumber = (EditText) findViewById(R.id.cnumber);
        ampaid = (EditText) findViewById(R.id.ampaid);
        feed = (EditText) findViewById(R.id.feed);
        submit =(Button) findViewById(R.id.submit);
        awesomeValidation.addValidation(UpdateInformation.this,R.id.fname, "[a-zA-Z\\s]+", R.string.fnamer);
        awesomeValidation.addValidation(UpdateInformation.this,R.id.cnumber, RegexTemplate.TELEPHONE,R.string.cnumberr);
        awesomeValidation.addValidation(UpdateInformation.this,R.id.ampaid, RegexTemplate.TELEPHONE,R.string.ampaidr);
        awesomeValidation.addValidation(UpdateInformation.this,R.id.feed,"[a-zA-Z\\s]+", R.string.feedr );

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(awesomeValidation.validate()){
                    Toast.makeText(UpdateInformation.this, "Data received successfully" , Toast.LENGTH_SHORT);
                }
                else
                {
                    Toast.makeText(UpdateInformation.this, "Error" , Toast.LENGTH_SHORT);
                }
            }
        });

    }
}
