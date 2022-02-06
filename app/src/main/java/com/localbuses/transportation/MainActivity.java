package com.localbuses.transportation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.budiyev.android.codescanner.CodeScanner;
import com.budiyev.android.codescanner.CodeScannerView;
import com.budiyev.android.codescanner.DecodeCallback;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.zxing.Result;

import java.util.ArrayList;
import java.util.List;



public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    //FIREBASE

    DatabaseReference databaseReference;

    List<TransactionsList> transactions_myLists;
    RecyclerView transactions_rv;
    TransactionsAdapter transactions_adapter;

    Button walletStatus;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CardView sendButton = (CardView) findViewById(R.id.sendButton);
        CardView receiveButton = (CardView) findViewById(R.id.receiveButton);
        CardView topupButton = (CardView) findViewById(R.id.topupButton);


        TextView recentTransactions = (TextView) findViewById(R.id.recentTransactions);

        ImageView logoutButton = (ImageView) findViewById(R.id.logoutButton);


        databaseReference = FirebaseDatabase.getInstance("https://qrcode-payment-local-default-rtdb.asia-southeast1.firebasedatabase.app/").getReference();

        Toast.makeText(this, databaseReference.toString(), Toast.LENGTH_SHORT).show();
        databaseReference.child("users").child("test").setValue("asdqwe").addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                Toast.makeText(MainActivity.this, "Updated successfully", Toast.LENGTH_SHORT).show();

            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });



        walletStatus = (Button) findViewById(R.id.walletStatus);


        sendButton.setOnClickListener(this);
        receiveButton.setOnClickListener(this);
        topupButton.setOnClickListener(this);
        recentTransactions.setOnClickListener(this);
        walletStatus.setOnClickListener(this);
        logoutButton.setOnClickListener(this);

        transactions_rv = (RecyclerView) findViewById(R.id.transactions_rec);
        transactions_rv.setHasFixedSize(true);
        transactions_rv.setLayoutManager(new LinearLayoutManager(MainActivity.this, LinearLayoutManager.VERTICAL, false));
        transactions_myLists = new ArrayList<>();

        transactions_myLists.add(new TransactionsList(null, null));
        transactions_myLists.add(new TransactionsList(null, null));
        transactions_myLists.add(new TransactionsList(null, null));
        transactions_myLists.add(new TransactionsList(null, null));
        transactions_myLists.add(new TransactionsList(null, null));
        transactions_myLists.add(new TransactionsList(null, null));


        transactions_adapter = new TransactionsAdapter(transactions_myLists, MainActivity.this);
        transactions_rv.setAdapter(transactions_adapter);
        transactions_adapter.notifyDataSetChanged();


    }

    public void loadWallet(){


    }


    @Override
    public void onClick(View view) {
        Intent intent;

        switch(view.getId()) {
            case R.id.sendButton:

                intent = new Intent(this, Send.class);
                startActivity(intent);
                break;
            case R.id.receiveButton:
                intent = new Intent(this, QRCode.class);
                startActivity(intent);
            case R.id.topupButton:


                break;

            case R.id.recentTransactions:
                intent = new Intent(this, Recent_Transactions.class);
                startActivity(intent);

                break;

            case R.id.walletStatus:
                if(walletStatus.getText().toString().matches("Active")){
                    walletStatus.setText("Inactive");
                }else{
                    walletStatus.setText("Active");
                }

                break;
            case R.id.logoutButton:
                intent = new Intent(this, Login.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);

                break;
        }
    }


}