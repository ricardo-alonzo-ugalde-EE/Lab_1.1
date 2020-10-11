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
    LinearLayout main_container;

    @Override
    protected void onCreate(Bundle savedInstanceState) // constructor
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText editText = (EditText) findViewById(R.id.edittxtview);
        Button b = (Button) findViewById(R.id.button1);
        this.main_container = findViewById(R.id.mainContainer);

        b.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                LinearLayout layout = createNewLL();
                addElements(layout,editText.getText().toString());
                addTomMainView(layout);

            }
        });
    }

    protected LinearLayout createNewLL()
    {
        LinearLayout ll = new LinearLayout(this);
        ll.setOrientation(LinearLayout.HORIZONTAL);
        ll.setPadding(0,5,0,0);
        ll.setWeightSum(3);

        return ll;
    }

    protected  void addTomMainView(LinearLayout ll)
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
                addTomMainView(layout);
            }
        });

        ll.addView(editText);
        ll.addView(b);

    }



}