package com.example.luisacfl.tareatabs;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.luisacfl.tareatabs.beans.ItemProduct;

/**
 * Created by luisacfl on 16/10/17.
 */

public class ActivityDetail extends AppCompatActivity {
    protected EditText title, store, location;
    protected ImageView image;
    protected Button save;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        title = (EditText) findViewById(R.id.activity_detail_title);
        store = (EditText) findViewById(R.id.activity_detail_store);
        image = (ImageView) findViewById(R.id.activity_detail_image);
        save = (Button) findViewById(R.id.activity_detail_save);

        final ItemProduct itemProduct = getIntent().getParcelableExtra("ITEM");
        title.setText(itemProduct.getTitle());
        store.setText(itemProduct.getStore().getName());
        location.setText(itemProduct.getStore().getCity().getName());


        switch (itemProduct.getImage()){
            case 0:
                image.setImageResource(R.drawable.mac);
                break;
            case 1:
                image.setImageResource(R.drawable.alienware);
                break;
        }

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                itemProduct.setImage(image.getId());
                itemProduct.setTitle(title.getText().toString());
                itemProduct.getStore().setName(store.getText().toString());
                itemProduct.getStore().getCity().setName(location.getText().toString());
            }
        });
    }
}
