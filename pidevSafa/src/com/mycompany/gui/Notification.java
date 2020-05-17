/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.gui;

import com.codename1.notifications.LocalNotification;
import com.codename1.ui.Display;

/**
 *
 * @author Admin
 */
public class Notification {
    
    
    
    
    public void notification()
    {
        LocalNotification n = new LocalNotification();
        n.setId("demo-notification");
        n.setAlertBody("It's time to take a break and look at me");
        n.setAlertTitle("Break Time!");
        n.setAlertSound("/notification_sound_bells.mp3"); //file name must begin with notification_sound
        

        Display.getInstance().scheduleLocalNotification(
                n,
                System.currentTimeMillis() + 10 * 10, // fire date/time
                LocalNotification.REPEAT_MINUTE  // Whether to repeat and what frequency
        );
   
    }
    
}
