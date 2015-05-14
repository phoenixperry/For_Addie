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
  Hey Addie! Here's the functionality you requested. I made it quit out and close the file 
  if you type ^. It writes a file called keyTracker.txt. 
   
  Just drag that file into the DrawMouseShape folder to draw your shape. 
  You can get really playful with it and add all the functionality you need from here
  btw - this method of data stuff is what I normally use for serial data w/Arudio
  so hopefully it'll be helpful later too. 
*/ 









  PrintWriter writer; 
  public void setup() 
  {
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
    PointerInfo inf = MouseInfo.getPointerInfo();
    Point p = inf.getLocation();
    println(p); 
    String  s = Integer.toString(p.x) + "," + Integer.toString(p.y); 
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
