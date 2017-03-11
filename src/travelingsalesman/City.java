/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package travelingsalesman;

/**
 *
 * @author Brad
 */
public class City 
{ // begin class
private int x;
private int y;


public City(int xPassed, int yPassed)
{
 this.x = xPassed;
 this.y = yPassed;
}    

public void setX(int xPassed)
{
    x = xPassed;
}        
     
public int getX()
{        
    return x;
}


public void setY(int yPassed)
{
    y = yPassed;
}  

public int getY()
{        
    return y;
}

public double distanceBetweenCities (City this, City cityPassed2)
{        
   int xDistance = Math.abs(this.getX() - cityPassed2.getX());
   int yDistance = Math.abs(this.getY() - cityPassed2.getY());
   return Math.sqrt(Math.pow(xDistance,2)+Math.pow(yDistance,2));
}    
    
    
    
    
    
    
} // end class



