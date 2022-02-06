package com.localbuses.transportation;

public class MyWallet {

    private String walletId;
    private int walletBalance;
    private Boolean isWalletActive;

    public MyWallet(String walletId, int walletBalance, Boolean isWalletActive) {

        this.walletId = walletId;
        this.walletBalance = walletBalance;
        this.isWalletActive = isWalletActive;

    }

    public String getWalletId(){
        return walletId;
    }

    public Boolean getWalletActive() {
        return isWalletActive;
    }

    public int getWalletBalance() {
        return walletBalance;
    }

    public void setWalletBalance(int newWalletBalance){
        walletBalance = newWalletBalance;
    }

    public void setWalletStatus(Boolean newWalletStatus){
        isWalletActive = newWalletStatus;
    }




}
