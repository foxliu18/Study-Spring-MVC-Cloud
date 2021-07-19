package com.summer.Demo1;

public class Client {
    public static void main(String[] args) {
        HouseOwner houseOwner = new HouseOwner();
        Proxy proxy = new Proxy(houseOwner);

        proxy.rent();

    }
}
