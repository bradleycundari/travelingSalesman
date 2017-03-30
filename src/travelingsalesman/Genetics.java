/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package travelingsalesman;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 *
 * @author Brad
 */
public class Genetics 
{ // begin class
    
    
    
    
    
    // Applies crossover to a set of parents and creates offspring
    public Route crossover(Route parent1, Route parent2, ArrayList<City> cityMap) 
    {   

        Route child = new Route();
        child.createRoute(cityMap);
        
        //Make a blank route
        for (int z = 0; z < child.routeSize(); z++)
        {
            child.setCity(z, null);
        }
        
        
        int startPos = (int) (Math.random() * parent1.routeSize());
        int endPos = (int) (Math.random() * parent1.routeSize());
        
        while (startPos >= endPos)
        {
         startPos = (int) (Math.random() * parent1.routeSize());
         endPos = (int) (Math.random() * parent1.routeSize());    
        }
        
        System.out.println(startPos);
        System.out.println(endPos);

        //Populate Child with sub route of parent1
        for (int i = startPos; i < endPos; i++)
        {
            child.setCity(i, parent1.getCity(i));
        }
        

        // populate Child with remaining subroute of parent 2
        for (int childIndex = 0; childIndex < child.routeSize(); childIndex++)
        {
            if (child.getCity(childIndex) == null && !child.containsCity(parent2.getCity(childIndex)))
            {
             child.setCity(childIndex, parent2.getCity(childIndex));
            }    
        }

        //populates the child with any missing cities
        for (City i: cityMap)
        {
            for (int index = 0; index < child.routeSize(); index++)
            {
                if(child.getCity(index) == null && !child.getCurrentRoute().contains(i))
                {
                   child.setCity(index, i);
                }
            }
        }
       
        
        return child;
    }    
    
    
    
    
    
    
    
    
    public Route mutate(Route toMutate)
    {
      //generates a new mutated route based off of input route
      Random rand = new Random();
      int rand1 = rand.nextInt(toMutate.routeSize()-1);
      int rand2 = rand.nextInt(toMutate.routeSize()-1);
      while (rand1 == rand2)
      {    
          rand1 = rand.nextInt(toMutate.routeSize()-1);
      }  
      Collections.swap(toMutate.getCurrentRoute(), rand1, rand2);  
      return toMutate;
    }    
    
} // end class
