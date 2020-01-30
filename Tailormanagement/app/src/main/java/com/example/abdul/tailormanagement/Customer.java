package com.example.abdul.tailormanagement;

/**
 * Created by ABDUL on 10/25/2017.
 */

public class Customer {
    int ID;
    String Customername,phonenumber,address,Customergender,arrivaldate,finaldate,bust,waist,hips,blouselength,halflength,
            fulllength,handlength,roundhandlength,skirtlength,shoulder,length, neck,trouserlength,sewingtype,comment,totalpayment,
            deposit,balance;
    byte[] garmentphoto,style;

    public Customer() {
    }

    public Customer(String customername, String phonenumber, String address, String customergender, String arrivaldate, String finaldate, String bust, String waist, String hips, String blouselength, String halflength, String fulllength, String handlength, String roundhandlength, String skirtlength, String shoulder, String length, String neck, String trouserlength, String sewingtype, String comment, String totalpayment, String deposit, String balance, byte[] garmentphoto, byte[] style) {
        Customername = customername;
        this.phonenumber = phonenumber;
        this.address = address;
        Customergender = customergender;
        this.arrivaldate = arrivaldate;
        this.finaldate = finaldate;
        this.bust = bust;
        this.waist = waist;
        this.hips = hips;
        this.blouselength = blouselength;
        this.halflength = halflength;
        this.fulllength = fulllength;
        this.handlength = handlength;
        this.roundhandlength = roundhandlength;
        this.skirtlength = skirtlength;
        this.shoulder = shoulder;
        this.length = length;
        this.neck = neck;
        this.trouserlength = trouserlength;
        this.sewingtype = sewingtype;
        this.comment = comment;
        this.totalpayment = totalpayment;
        this.deposit = deposit;
        this.balance = balance;
        this.garmentphoto = garmentphoto;
        this.style = style;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getCustomername() {
        return Customername;
    }

    public void setCustomername(String customername) {
        Customername = customername;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCustomergender() {
        return Customergender;
    }

    public void setCustomergender(String customergender) {
        Customergender = customergender;
    }

    public String getArrivaldate() {
        return arrivaldate;
    }

    public void setArrivaldate(String arrivaldate) {
        this.arrivaldate = arrivaldate;
    }

    public String getFinaldate() {
        return finaldate;
    }

    public void setFinaldate(String finaldate) {
        this.finaldate = finaldate;
    }

    public String getBust() {
        return bust;
    }

    public void setBust(String bust) {
        this.bust = bust;
    }

    public String getWaist() {
        return waist;
    }

    public void setWaist(String waist) {
        this.waist = waist;
    }

    public String getHips() {
        return hips;
    }

    public void setHips(String hips) {
        this.hips = hips;
    }

    public String getBlouselength() {
        return blouselength;
    }

    public void setBlouselength(String blouselength) {
        this.blouselength = blouselength;
    }

    public String getHalflength() {
        return halflength;
    }

    public void setHalflength(String halflength) {
        this.halflength = halflength;
    }

    public String getFulllength() {
        return fulllength;
    }

    public void setFulllength(String fulllength) {
        this.fulllength = fulllength;
    }

    public String getHandlength() {
        return handlength;
    }

    public void setHandlength(String handlength) {
        this.handlength = handlength;
    }

    public String getRoundhandlength() {
        return roundhandlength;
    }

    public void setRoundhandlength(String roundhandlength) {
        this.roundhandlength = roundhandlength;
    }

    public String getSkirtlength() {
        return skirtlength;
    }

    public void setSkirtlength(String skirtlength) {
        this.skirtlength = skirtlength;
    }

    public String getShoulder() {
        return shoulder;
    }

    public void setShoulder(String shoulder) {
        this.shoulder = shoulder;
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }

    public String getNeck() {
        return neck;
    }

    public void setNeck(String neck) {
        this.neck = neck;
    }

    public String getTrouserlength() {
        return trouserlength;
    }

    public void setTrouserlength(String trouserlength) {
        this.trouserlength = trouserlength;
    }

    public String getSewingtype() {
        return sewingtype;
    }

    public void setSewingtype(String sewingtype) {
        this.sewingtype = sewingtype;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getTotalpayment() {
        return totalpayment;
    }

    public void setTotalpayment(String totalpayment) {
        this.totalpayment = totalpayment;
    }

    public String getDeposit() {
        return deposit;
    }

    public void setDeposit(String deposit) {
        this.deposit = deposit;
    }

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }

    public byte[] getGarmentphoto() {
        return garmentphoto;
    }

    public void setGarmentphoto(byte[] garmentphoto) {
        this.garmentphoto = garmentphoto;
    }

    public byte[] getStyle() {
        return style;
    }

    public void setStyle(byte[] style) {
        this.style = style;
    }
}
