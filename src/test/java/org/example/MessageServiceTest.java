package org.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class MessageServiceTest {
    private List<String> ipList = new ArrayList<>();          //
    private List<String> notValidIpList = new ArrayList<>();  //

    @Mock                                                     //
    private MessageService messageService;                    //

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);                      //
        List<String> ips = new ArrayList<>();
        List<String> notValidIP = new ArrayList<>();
        ips.add("192.168.1.1");
        notValidIP.add("092.830.020");
        this.ipList = ips;
        this.notValidIpList = notValidIP;                       //
    }

    @AfterEach
    void tearDown() {
        this.ipList = null;                                    //
        this.notValidIpList = null;                            //
    }

    @Test
    void sendMessageNotValidIP() {
        when(messageService.sendMessage(this.notValidIpList.get(0), "Hello There !")).thenReturn(false);                         //
        assertEquals(messageService.sendMessage(this.notValidIpList.get(0), "Hello There !"), false, "Receiver IP is Not Valid"); //
    }

    @Test
    void sendMessageSuccessfully(){
        when(messageService.sendMessage(this.ipList.get(0), "Hello There !")).thenReturn(true);                                 //
        assertEquals(messageService.sendMessage(this.ipList.get(0), "Hello There !"), true, "Message Sent Successfully !");     //
    }
}