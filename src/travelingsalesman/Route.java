package travelingsalesman;


import java.util.ArrayList;
import java.util.Random;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Brad
 */
public class Route 
{
  ArrayList<City> currentRoute;  
  private int numCities;
  private double fitness;
  private double totalDistance;
    
 public void addCity(City cityPassed)
 {
   currentRoute.add(cityPassed);
 }
    
 public void calculateTotalDistance(Route this)
 {  
   double totalDistance = 0;  
   for (int i = 0; i < currentRoute.size(); i++)
   {
      //Gets the current element of currentRoute and compares it with the next element. Skips the final comparison.
      totalDistance = totalDistance + currentRoute.get(i).distanceBetweenCities(currentRoute.get(i+1));
   } 
   //this is the final comparison of the last city with the first city
   totalDistance = totalDistance + currentRoute.get(currentRoute.size()).distanceBetweenCities(currentRoute.get(1));
   setTotalDistance(totalDistance);
 }   

public void setFitness(double fitnessPassed)
{
    this.fitness = fitnessPassed;
}

public void setTotalDistance(double totalDistancePassed)
{
    this.totalDistance = totalDistancePassed;
}

public ArrayList<City> getCurrentRoute()
{
    return currentRoute;
}        

public void generateRandomRoute()
{
    Random rand = new Random();
    for (int i = 0; i < 5; i++)
    {    
    currentRoute.add(new City(rand.nextInt(500),rand.nextInt(500)));
    } 
}        
    



} // end class
