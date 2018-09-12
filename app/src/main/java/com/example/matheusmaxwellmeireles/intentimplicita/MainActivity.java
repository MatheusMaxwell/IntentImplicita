package com.example.matheusmaxwellmeireles.intentimplicita;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends Activity {


    GridView gridView;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gridView = findViewById(R.id.grid);

        gridView.setAdapter(new ImageAdapter(getApplicationContext()));

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                        Uri gmmIntentUri = Uri.parse("geo:37.7749,-122.4194");
                        intent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                        intent.setPackage("com.google.android.apps.maps");
                        if (intent.resolveActivity(getPackageManager()) != null) {
                            startActivity(intent);
                        }
                        else{
                            Toast.makeText(getApplicationContext(),"Erro", Toast.LENGTH_SHORT);
                        }
                        break;
                    case 1:
                        intent = new Intent();
                        intent.setAction(Intent.ACTION_SEND);
                        intent.putExtra(Intent.EXTRA_TEXT, "Olá");
                        intent.setType("text/plain");
                        startActivity(intent);
                        break;
                    case 2:
                        String phone = "+34666777888";
                        intent = new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", phone, null));
                        startActivity(intent);


                        break;
                    case 3:
                        String url = "http://www.ucb.br/";
                        intent = new Intent(Intent.ACTION_VIEW);
                        intent.setData(Uri.parse(url));
                        startActivity(intent);
                        break;
                    default:
                        break;
                }
            }
        });


    }
}
