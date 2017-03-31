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
  private double fitness;
  private double totalDistance;
  
  public Route()
  {
  }
  
  
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

public int routeSize()
{
    return currentRoute.size();
}


public double getTotalDistance()
{
    calculateTotalDistance();
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

    public double getFitness()
    {
        calculateTotalDistance();
        if (fitness == 0) {
            fitness = 1/(double)getTotalDistance();
        }
        return fitness;
    }

    public City getCity(int index)
    {
    return currentRoute.get(index);
    }
    
    public void setCity(int index, City cityToSet)
    {
        currentRoute.set(index, cityToSet);
        fitness = 0;
        totalDistance = 0;
    }


    public void createRoute (ArrayList<City> cityMap)
    {
        long seed = 1564534;
        Random gen = new Random();
        cityMap.forEach((i) -> {
            this.currentRoute.add(i);
        });
        Collections.shuffle(currentRoute);
         
   }
    
   public boolean containsCity(City cityToCheck)
   {
       return this.currentRoute.contains(cityToCheck);
   }
    

   public void display()
   {
       currentRoute.forEach((i) -> {
           if(i == null)
           {
             System.out.print("|Empty|" + " ");
           }
           else System.out.print(i.toString() + " ");
      });
      System.out.println("");
   }
    
    
} // end class
