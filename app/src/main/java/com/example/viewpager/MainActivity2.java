package com.example.viewpager;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity2 extends AppCompatActivity  {

    Button button;
    EditText ednombre,ededad,edcorreo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        button=findViewById(R.id.btnreg);
        ednombre=findViewById(R.id.editnom);
        ededad=findViewById(R.id.editedad);
        edcorreo=findViewById(R.id.editcorreo);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference myRef = database.getReference("message");
                Usuario usuario = new Usuario(ednombre.getText().toString(),Integer.parseInt(ededad.getText().toString()),edcorreo.getText().toString());
                myRef.push().setValue(usuario);
            }
        });
    }
}