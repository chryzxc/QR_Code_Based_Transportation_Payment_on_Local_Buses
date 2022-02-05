package com.localbuses.transportation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    List<TransactionsList> transactions_myLists;
    RecyclerView transactions_rv;
    TransactionsAdapter transactions_adapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CardView sendButton = (CardView) findViewById(R.id.sendButton);
        CardView receiveButton = (CardView) findViewById(R.id.receiveButton);
        CardView topupButton = (CardView) findViewById(R.id.topupButton);

        TextView recentTransactions = (TextView) findViewById(R.id.recentTransactions);


        sendButton.setOnClickListener(this);
        receiveButton.setOnClickListener(this);
        topupButton.setOnClickListener(this);
        recentTransactions.setOnClickListener(this);

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

    @Override
    public void onClick(View view) {
        Intent intent;

        switch(view.getId()) {
            case R.id.sendButton:
                intent = new Intent(this, Send.class);
                startActivity(intent);
                break;
            case R.id.receiveButton:
                intent = new Intent(this, Receive.class);
                startActivity(intent);
            case R.id.topupButton:


                break;

            case R.id.recentTransactions:
                intent = new Intent(this, Recent_Transactions.class);
                startActivity(intent);

                break;
        }
    }
}