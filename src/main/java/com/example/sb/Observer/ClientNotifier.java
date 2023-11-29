package com.example.sb.Observer;

public class ClientNotifier implements ClientListener{
    @Override
    public void NotifyAddClient() {
        System.out.println("Client Added with success !");
    }
}
