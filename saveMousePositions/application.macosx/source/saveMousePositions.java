import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import processing.core.*; 
import java.util.*; 
import java.awt.MouseInfo; 
import java.awt.Point; 
import java.awt.PointerInfo; 
import java.io.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class saveMousePositions extends PApplet {

/* 
  Hey Addie! Here's the functionality you requested.
  Note this little trick will not work unless you are running the actual application. 
  Build vs. pressing the arrow in processing. 
  I made it quit out and write the file  if you type ^. 
  It writes a file called keyTracker.txt. 
  As it stands now, if you close the window w/out closing the file and flushing data
  you'll get no data. Always do that - or add that funcitonaluty to an on close event:) 
  
  Just drag that file into the DrawMouseShape folder to draw your shape. 
  You can get really playful with it and add all the functionality you need from here
  btw - this method of data stuff is what I normally use for serial data w/Arudio
  so hopefully it'll be helpful later too. 
    
  */ 









  PrintWriter writer; 
  PFont f; 
  public void setup() 
  {
    f = loadFont("Serif-16.vlw");
   textFont(f, 16);  
    size(300, 150); 
    try {
    writer = new PrintWriter("keyTracker.txt", "UTF-8");
  } catch (FileNotFoundException e) {
    // TODO Auto-generated catch block
    e.printStackTrace();
  } catch (UnsupportedEncodingException e) {
    // TODO Auto-generated catch block
    e.printStackTrace();
  }
    
  } 
int currentTweet;
  public void draw()
  {
    background (0); 
    PointerInfo inf = MouseInfo.getPointerInfo();
    Point p = inf.getLocation();
    //  println(p); 
    String  s = Integer.toString(p.x) + "," + Integer.toString(p.y); 
    String t = "The mouse is at: " + s;
    fill(255,255,255); 
    text(t, 10, 40); 
    text("Press ^ to quit and save the data to a file", 10, 60); 
    fill(255,255,0); 
    text("Make sure this is an application build", 10, 80); 
    fill(0,255,0); 
    text("When you are done, drag the keyTracker.txt \nfile into the drawMouseShape sketch", 10, 100); 
    writer.println(s);
  }
  public void keyPressed()
  {
    if(key == '^'){
      writer.flush();
      writer.close();
      exit();
    } 
  }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "saveMousePositions" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
