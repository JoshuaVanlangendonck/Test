package hellotvxlet;

import java.awt.Color;
import java.awt.event.ActionEvent;
import javax.tv.xlet.*;
import org.havi.ui.HScene;
import org.havi.ui.HSceneFactory;
import org.havi.ui.HStaticText;
import org.havi.ui.HTextButton;
import org.havi.ui.HVisible;
import org.havi.ui.event.HActionListener;

// HActionListener toevoegen
public class HelloTVXlet implements Xlet, HActionListener {

    HScene scene;
    public HelloTVXlet() {
        
    }

    public void initXlet(XletContext context){
      scene =   HSceneFactory.getInstance().getDefaultHScene();
      
      HStaticText label1 = new HStaticText("Welke knop is juist?", 200, 50, 300, 75);
      label1.setBackground(Color.BLUE);
      label1.setBackgroundMode(HVisible.BACKGROUND_FILL);
       
      // x, y, w, h
      HTextButton knop1 = new HTextButton("Knop1", 250,150,200,75);
      knop1.setBackground(Color.BLUE);
      knop1.setBackgroundMode(HVisible.BACKGROUND_FILL);
      
      HTextButton knop2 = new HTextButton("Knop2", 250,250,200,75);
      knop2.setBackground(Color.BLUE);
      knop2.setBackgroundMode(HVisible.BACKGROUND_FILL);
      
      HTextButton knop3 = new HTextButton("Knop3", 250,350,200,75);
      knop3.setBackground(Color.BLUE);
      knop3.setBackgroundMode(HVisible.BACKGROUND_FILL);
      
      HTextButton knop4 = new HTextButton("Knop4", 250,450,200,75);
      knop4.setBackground(Color.BLUE);
      knop4.setBackgroundMode(HVisible.BACKGROUND_FILL);
                  
      // up, down, left, right
      // jump from button to button with the arrows
      knop1.setFocusTraversal(null, knop2, null, null);
      knop2.setFocusTraversal(knop1, knop3, null, null);
      knop3.setFocusTraversal(knop2, knop4, null, null);
      knop4.setFocusTraversal(knop3, null, null, null);
      
      knop1.setActionCommand("knop1");
      knop2.setActionCommand("knop2");
      knop3.setActionCommand("knop3");
      knop4.setActionCommand("knop4");
      
      knop1.addHActionListener(this);
      knop2.addHActionListener(this);
      knop3.addHActionListener(this);
      knop4.addHActionListener(this);
      
      scene.add(knop1);
      scene.add(knop2);
      scene.add(knop3);
      scene.add(knop4);
      scene.add(label1);
      
      scene.validate(); 
      scene.setVisible(true);
      knop1.requestFocus(); // Start with focus on knop1
     
    }

    public void startXlet() {
    
    }

    public void pauseXlet() {
     
    }

    public void destroyXlet(boolean unconditional) {
     
    }
    
    public void actionPerformed(ActionEvent args0)
    {
        HStaticText msg = new HStaticText("msg", 50,50,100,100); // x,y,w,h
        msg.setBackground((Color.RED));
        msg.setBackgroundMode(HVisible.BACKGROUND_FILL);
        
        if(args0.getActionCommand().equals("knop1"))
        {
            msg.setTextContent("GOED!", HVisible.NORMAL_STATE);
            msg.setBackground(Color.GREEN);
        }
        else
        {
            msg.setTextContent("FOUT!", HVisible.NORMAL_STATE);
        }
        scene.add(msg);
        scene.popToFront(msg);
        scene.repaint();
    }
}
