package org.example;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class MessageService {
    boolean sendMessage(String ip, String message)               //
    {
        try {
            Socket socket = new Socket(ip, 80);
            OutputStream output = socket.getOutputStream();
            byte[] messageToSend = message.getBytes();
            try {
                //Try First Time
                output.write(messageToSend);
                return true;
            } catch (IOException firstTry){
                try {
                    //Try Second Time
                    output.write(messageToSend);
                    return true;
                } catch (IOException secondTry){
                    return false;
                }
            }
        } catch (IOException | SecurityException | IllegalArgumentException e){
            return false;
        }
    }                                                               //
}
