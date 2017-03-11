package travelingsalesman;


import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Brad
 */
public class Tour 
{
  ArrayList<City> currentTour;  
  private int numCities;
  private double fitness;
  private double totalDistance;
    
 public void addCity(City cityPassed)
 {
   currentTour.add(cityPassed);
 }
    
 public void calculateTotalDistance(Tour this)
 {  
   double totalDistance = 0;  
   for (int i = 0; i < currentTour.size(); i++)
   {
      //Gets the current element of currentTour and compares it with the next element. Skips the final comparison.
      totalDistance = totalDistance + currentTour.get(i).distanceBetweenCities(currentTour.get(i+1));
   } 
   //this is the final comparison of the last city with the first city
   totalDistance = totalDistance + currentTour.get(currentTour.size()).distanceBetweenCities(currentTour.get(1));
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



}
