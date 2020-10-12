package org.electricuniverse.lab_1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.menu.ListMenuItemView;

import android.os.Bundle;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;

import static android.widget.HorizontalScrollView.*;

public class MainActivity extends AppCompatActivity
{
    LinearLayout main_container; //linear layout object called main_container

    @Override
    protected void onCreate(Bundle savedInstanceState) // constructor
    {
        super.onCreate(savedInstanceState); // comes with the onCreate function
        setContentView(R.layout.activity_main); // comes with  the on Create function


        final EditText editText = (EditText) findViewById(R.id.edittxtview); // final is like constant but editText is a class object of EditText
        Button b = (Button) findViewById(R.id.button1); // button class oject named button
        main_container = findViewById(R.id.mainContainer); // tying the main container linear layout object to main conContainer design

        b.setOnClickListener(new View.OnClickListener() // sets the listener for the button we created ealier
        {
            String value = editText.getText().toString();
            @Override
            public void onClick(View v)
            {


                if (value != "h")
                {
                    LinearLayout layout = createNewLL(); // function to create a new Linear Layout with parameters from createNewLL() function defined below
                    addElements(layout, editText.getText().toString()); // function to add elements during the on onClick call
                    addToMainView(layout);

                }
                else
                {
                    LinearLayout layout = createNewHorizontalLL(); // function to create a new Linear Layout with parameters from createNewLL() function defined below
                    addHorizontalElements(layout, editText.getText().toString()); // function to add elements during the on onClick call
                    addToMainView(layout);

                }

            }
        });
    }

    /**
     * Adds the linear layout everytime the onclick function is called.
     * */
    protected LinearLayout createNewLL()
    {
        LinearLayout ll = new LinearLayout(this);
        ll.setOrientation(LinearLayout.HORIZONTAL);
        ll.setPadding(0,5,0,0);
        ll.setWeightSum(3);

        return ll;
    }

    protected LinearLayout createNewHorizontalLL()
    {
        LinearLayout Hll = new LinearLayout(this);
        HorizontalScrollView horizontalScrollView= new HorizontalScrollView(this);
        LinearLayout.LayoutParams scrollViewParams = new
        LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
        ViewGroup.LayoutParams.WRAP_CONTENT);
        horizontalScrollView.setLayoutParams(scrollViewParams);

        return Hll;
    }

    protected  void addToMainView(LinearLayout ll)
    {
        this.main_container.addView(ll);
    }

    protected void addElements(LinearLayout ll, String buttonText)
    {
        final EditText editText = new EditText(this);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(0,ViewGroup.LayoutParams.WRAP_CONTENT,2f);
        editText.setLayoutParams(params);

        Button b = new Button(this);
        LinearLayout.LayoutParams params2=new LinearLayout.LayoutParams(0,ViewGroup.LayoutParams.WRAP_CONTENT,1f);
        b.setLayoutParams(params2);
        b.setText(buttonText);
        b.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                LinearLayout layout= createNewLL();
                addElements(layout, editText.getText().toString());
                addToMainView(layout);
            }
        });

        protected void addHorizontalElements(LinearLayout ll, String buttonText)
        {
            final EditText editText = new EditText(this);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(0,ViewGroup.LayoutParams.WRAP_CONTENT,2f);
            editText.setLayoutParams(params);

            Button b = new Button(this);
            
            LinearLayout.LayoutParams params2=new LinearLayout.LayoutParams(0,ViewGroup.LayoutParams.WRAP_CONTENT,1f);
            b.setLayoutParams(params2);
            b.setText(buttonText);
            b.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View v)
                {
                    LinearLayout layout= createNewLL();
                    addElements(layout, editText.getText().toString());
                    addToMainView(layout);
                }
            });


        ll.addView(editText);
        ll.addView(b);

    }



}