/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;

import com.codename1.components.FloatingActionButton;
import com.codename1.components.ImageViewer;
import com.codename1.components.ToastBar;
import com.codename1.notifications.LocalNotification;
import com.codename1.ui.Container;
import com.codename1.ui.Display;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.URLImage;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.util.Callback;
import java.io.IOException;

/**
 *
 * @author mosla
 */
public class Layout {

    Form f;
    Container toolbar;
    Container content;
    Container main;
   
    public Layout() {
        f = new Form();

        f.getToolbar().setHidden(true, true);
        toolbar = new Container(new BorderLayout());
      
        
        //toolbar.add(BorderLayout.EAST, overflowMenu);

        content = new Container(new BoxLayout(BoxLayout.Y_AXIS));
        //content.setScrollableY(true);

        main = new Container(new BoxLayout(BoxLayout.Y_AXIS));
        //main.setScrollableY(false);
        main.add(toolbar);
        main.add(content);
        //f.setScrollableX(false);
        //f.setScrollableY(false);
        f.add(main);

    }

    public Form getF() {
        return f;
    }

    public void setF(Form f) {
        this.f = f;
    }
}
