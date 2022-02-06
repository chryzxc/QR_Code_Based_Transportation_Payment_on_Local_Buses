package com.localbuses.transportation;

public class TransactionsList {

    private String id,customer_id;


    public TransactionsList(String id,
                            String customer_id) {

        this.id = id;
        this.customer_id = customer_id;



    }


    public String getId() {
        return id;

    }

    public String getCustomer_id() {
        return customer_id;

    }





}