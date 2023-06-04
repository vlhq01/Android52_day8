package com.vndevpro.android52_day7;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class add extends AppCompatActivity {
    private EditText ettitle,etprice,etdes;
    private Button btnOk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_product);
        map();

        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                Bundle bundle = new Bundle();
                bundle.putInt("price", Integer.parseInt(etprice.getText().toString()));
                bundle.putString("title",ettitle.getText().toString());
                bundle.putString("des",etdes.getText().toString());
                intent.putExtras(bundle);
                setResult(200,intent);
                finish();
            }

        });

    }
    private void map(){
        ettitle = findViewById(R.id.edttitle);
        etdes = findViewById(R.id.edtdes);
        etprice = findViewById(R.id.edtprice);
        btnOk = findViewById(R.id.btnadd);

    }
}
