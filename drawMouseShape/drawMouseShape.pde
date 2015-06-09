import processing.core.*;

import java.awt.Point;
import java.io.*; 
import java.util.Scanner;
import java.util.ArrayList; 
import java.util.*;


  ArrayList<PVector> pointsAsVector = new ArrayList<PVector>(); 
  ArrayList<PVector> pointsScaledToScreen = new ArrayList<PVector>(); 
  PShape s; 
  ArrayList<Integer> points = new ArrayList<Integer>(); 
  String[] stuff; 
  int counter=0; 
 PVector sizeOfScreen; 
 
   public void setup(){
    sizeOfScreen = new PVector(displayWidth, displayHeight); 
    pointsScaledToScreen = new ArrayList(); 
    size(400,400, P2D); 

    stuff = loadStrings("keyTracker.txt");
    println("loaded"); 
    LoadShapeData(); 
    scaleToScreen();
    smooth();
    background(255);
  } 
  
  public void draw(){
    stroke(0);
    
    strokeWeight(0.5f);
    noFill();
    beginShape();
      for(int i =0; i < pointsScaledToScreen.size(); i++)
      {
        vertex(pointsScaledToScreen.get(i).x,pointsScaledToScreen.get(i).y);
      }
    endShape();
    
  } 
  public void scaleToScreen(){
    
       for(int i=0; i < pointsAsVector.size(); i++) 
       {  PVector p = pointsAsVector.get(i); 
          p.x = map(p.x, 0, displayWidth, 0, width); 
          p.y = map(p.y, 0, displayHeight, 0, height); 
     
          pointsScaledToScreen.add(p); 
        }
  } 
  public void LoadShapeData(){

    for(int i=0; i<stuff.length; i++) 
    {
    
      //split file at , 
      Scanner sc = new Scanner(stuff[i]).useDelimiter(",");
      //just an example of keeping track - since you know there are 2 (x,y) elements in athestring
        //you can grab each one as data as needed and write that through to whatever variable you are using 
      while(sc.hasNext()) {
        //get the next bit of data 
          //alternateLines and parse to points         
           points.add(Integer.parseInt(sc.next()));  
           //println(sc.next());
      }
    }
    //println(points.size()); 
    //DrawShapeData();
    for(int j=0; j < points.size(); j=j+2){
     if(j < points.size()-1)
      {
        PVector p = new PVector(points.get(j), points.get(j+1)); 
        pointsAsVector.add(p);
      }
    } 
    println(pointsAsVector.size()); 
  } 
