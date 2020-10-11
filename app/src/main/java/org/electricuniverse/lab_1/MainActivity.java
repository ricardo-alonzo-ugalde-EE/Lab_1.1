package org.electricuniverse.lab_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;

import static android.widget.HorizontalScrollView.*;

public class MainActivity extends AppCompatActivity
{


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /**
         * Code to create: LinearLayout
         * */
        LinearLayout ll =  new LinearLayout(this);
        ll.setOrientation(LinearLayout.HORIZONTAL);
        ll.setPadding(0,5,0,0);
        ll.setWeightSum(3);

        /**
         * Code to create: editText view object
         * */
        EditText editText = (EditText) findViewById(R.id.editxtview);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.WRAP_CONTENT,2f);
        editText.setLayoutParams(params);

        /**
         * Code to create: button view object
         * */
        Button b = (Button) findViewById(R.id.button1);
        LinearLayout.LayoutParams params2 = new LinearLayout.LayoutParams(0,ViewGroup.LayoutParams.WRAP_CONTENT,1f);
        b.setLayoutParams(params2);

        /**
         * Code to create: get the text content of editText
         * */
        editText.getText();

        /**
         * Code to create: ViewGroup
         * */
        //ll.addView(editText);
        //ll.addView(b);

        b.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {

                // if edit text !=: Create a new linear layout dinamicy, else, create horizontal layout
                Button newbtn = new Button(MainActivity.this);
                EditText editText = (EditText) findViewById(R.id.editxtview);
                editText.getText();
                String value = editText.getText().toString().trim();



                if(value != "h")
                {
                    LinearLayout ll =  (LinearLayout) findViewById(R.id.mainContainer);
                    ll.setOrientation(LinearLayout.VERTICAL);
                    ll.addView(newbtn);
                    LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.WRAP_CONTENT,2f);
                    editText.setLayoutParams(params);
                    newbtn.setText(value);
                    //ll.addView(editText);
                }
                else
                {
                    LinearLayout ll =  (LinearLayout) findViewById(R.id.mainContainer);
                    ll.setOrientation(LinearLayout.HORIZONTAL);
                    ll.addView(newbtn);
                    LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.WRAP_CONTENT,2f);
                    editText.setLayoutParams(params);
                    newbtn.setText(value);
                }



            }
        });

        /**
         * Code to create: viewGroup object (II) into the root ViewGroup
         * */
        LinearLayout main_container = findViewById(R.id.mainContainer);
        main_container.addView(ll);

        /**
         * Code to create: Horizontal Scroll view group
         * */
        HorizontalScrollView horizontalScrollView = new HorizontalScrollView(this);
        LinearLayout.LayoutParams scrollViewParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        horizontalScrollView.setLayoutParams(scrollViewParams);

        /**
         * Code to create: Linear layout viewgroup
         * */
        final LinearLayout ll1 = new LinearLayout(this);
        ll1.setOrientation(LinearLayout.HORIZONTAL);
        ll1.setPadding(0,5,0,0);

        /**
         * Code to create: new button to linear layout element
         * */
        Button bb = new Button(this);
        Integer count = ll1.getChildCount()+1;
        bb.setText(count.toString());
        ll1.addView(bb);

        /**
         * Code to create: Insert linear Layout into the horizontal scroll
         * and the horizontal scroll into the main container.
         * */
        LinearLayout main_container1 = (LinearLayout) findViewById(R.id.mainContainer);
        //HorizontalScrollView.addView(ll1);
        main_container.addView(horizontalScrollView);





    }


    /**public void addButton()
    {

        Button newbtn = new Button(this);
        LinearLayout layout = (LinearLayout) findViewById(R.id.rootlayout);
        String name = "Tim";
        System.out.println(name);
        newbtn.setText("editText");
        layout.addView(newbtn);

    }*/
}