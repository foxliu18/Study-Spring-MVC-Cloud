package com.summer.Demo1;

public class Proxy {

    private HouseOwner houseOwner;

    public Proxy() {
    }

    public Proxy(HouseOwner houseOwner) {
        this.houseOwner = houseOwner;
    }

    public void rent(){
        seeHouse();
        houseOwner.rent();
        fare();
        contract();
    }

    public void seeHouse(){
        System.out.println("中介带看房");
    }

    public void fare(){
        System.out.println("中介收中介费");
    }

    public void contract(){
        System.out.println("中介签合同");
    }

}
