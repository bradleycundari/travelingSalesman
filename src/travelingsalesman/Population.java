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

    public Population(ArrayList<City> cityMapPassed, int popSize)
    {        
        for (int i = 0; i < popSize; i++)
        {
            Route a = new Route();
            a.createRoute(cityMapPassed);
            currentPopulation.add(a);
        }      
    }
    
    public void setRoute(Route routePassed, int index)
    {
        currentPopulation.set(index, routePassed);
    }
    
    public void createPopulation(ArrayList<City> cityMapPassed, int size)
    {
        for (int i = 0; i < size; i++)
        {
            Route a = new Route();
            for (City ii: cityMapPassed)
            {
                a.addCity(ii);
            }
            currentPopulation.add(a);
        }    
        
    }
    
    
    public Route getRoute(int index)
    {
     return currentPopulation.get(index);   
    }
    
    public Route getFittest()
    {
        Route fittest = currentPopulation.get(0);
        
        for (Route i: currentPopulation)
        {
            if (fittest.getFitness() <= i.getFitness())
            {
            fittest = i;
            }    
        }
        return fittest;
    }    
    
    
   public void display()
    {
        for (Route i: currentPopulation)
        {
           i.display();
           System.out.println(i.getFitness());           
        }
    }
    
    
    public int getPopulationSize(Population this)
    {
        return currentPopulation.size();
    }
    
    
    
    
}
