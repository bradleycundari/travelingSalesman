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
public class Population 
{
    private ArrayList<Route> currentPopulation = new ArrayList();

    
    
    public void createPopulation(ArrayList<City> cityMapPassed, int size)
    {
        for (int i = 0; i < size; i++)
        {
            Route a = new Route();
            a.createRoute(cityMapPassed);
            currentPopulation.add(a);
        }    
        
    }
    
    public void setTotalDistances()
    {
        for (Route i: currentPopulation)
        {
            i.calculateTotalDistance();
        }
    }
    
    
    
    
   public void display()
    {
        for (Route i: currentPopulation)
        {
           System.out.print(i.getTotalDistance());
        }
    }
    
    
    public int getPopulationSize(Population this)
    {
        return currentPopulation.size();
    }
    
    
    
    
}
