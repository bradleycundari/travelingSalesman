package travelingsalesman;


import java.util.ArrayList;
import java.util.Collections;
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
  private ArrayList<City> currentRoute = new ArrayList<City>();  
  private int numCities;
  private double fitness;
  private double totalDistance;
    
 public void addCity(City cityPassed)
 {
   currentRoute.add(cityPassed);
 }
    
 public void calculateTotalDistance(Route this)
 {  
   double currentTotalDistance = 0;  
   for (int i = 0; i < currentRoute.size() - 1; i++)
   {
      //Gets the current element of currentRoute and compares it with the next element. Skips the final comparison.
      currentTotalDistance = currentTotalDistance + currentRoute.get(i).distanceBetweenCities(currentRoute.get(i+1));
   } 
   //this is the final comparison of the last city with the first city
   City firstCity = currentRoute.get(0);
   City lastCity = currentRoute.get(currentRoute.size()-1);  
   currentTotalDistance = currentTotalDistance + Math.abs(firstCity.distanceBetweenCities(lastCity));
   setTotalDistance(currentTotalDistance);
 }   

public void setFitness(double fitnessPassed)
{
    this.fitness = fitnessPassed;
}

public void setTotalDistance(double totalDistancePassed)
{
    this.totalDistance = totalDistancePassed;
}

public double getTotalDistance()
{
    return totalDistance;
}

public ArrayList<City> getCurrentRoute()
{
    return currentRoute;
}        

public void setCurrentRoute(ArrayList<City> cityListPassed)
{
    this.currentRoute = cityListPassed;
}

public void createRoute (ArrayList<City> cityMap)
    {
        long seed = 1564534;
        cityMap.forEach((i) -> {
            this.currentRoute.add(i);
        });
        Collections.shuffle(this.currentRoute, new Random(seed));
         
   }

    

} // end class
