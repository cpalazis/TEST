package org.example;

public class Network {
    MessageService msgService = new MessageService();
    boolean sendMessage(String ip, String message){
        return msgService.sendMessage(ip, message);
    }
}
