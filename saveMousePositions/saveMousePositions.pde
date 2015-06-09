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

import processing.core.*;

import java.util.*;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.PointerInfo;
import java.io.*;

  PrintWriter writer; 
  PFont f; 
  boolean pressed = false;
  public void setup() 
  {
    f = loadFont("Serif-16.vlw");
   textFont(f, 16);  
    size(300, 150); 
    try {
    writer = createWriter("keyTracker.txt");
  } catch (Exception e ) {
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
   
    fill(0,255,255); 
    rect(10,100, 200,200); 
    fill(0,0,0);
    text("press to quit", 30, 130); 
    writer.println(s);
    println(s); 
    
    if(mouseX > 10 && mouseX < 200 && mouseY >100 && mouseY < 200) {
      fill(255,255,0); 
      rect(10,100, 200,200); 
      fill(0,0,0);
      text("press to quit", 30, 130); 
      pressed = true; 
    }
 
  }
  public void mousePressed(){
   if(pressed){
      writer.flush();
      writer.close();
      exit();
   } 
  }
 
