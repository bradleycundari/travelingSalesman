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
        // Some code was utilized from: 
        // http://www.theprojectspot.com/tutorial-post/applying-a-genetic-algorithm-to-the-travelling-salesman-problem/5
        
        
        Route child = new Route();
        child.createRoute(cityMap);
        
        int startPos = (int) (Math.random() * parent1.routeSize());
        int endPos = (int) (Math.random() * parent1.routeSize());

        //crossover for sub route from parent1
        for (int i = 0; i < parent1.routeSize(); i++)
        {
            if (startPos < endPos && i > startPos && i < endPos)
            {
               child.setCity(i, parent1.getCity(i));
            }    
            else if (startPos > endPos)
            {
                if (!(i < startPos && i > endPos)) {
                    child.setCity(i, parent1.getCity(i));
                }
            }
        }
        
        for (int i = 0; i < parent2.routeSize(); i++) {
            // If child doesn't have the city add it
            if (!child.containsCity(parent2.getCity(i))) {
                // Loop to find a spare position in the child's tour
                for (int ii = 0; ii < child.routeSize(); ii++) {
                    // Spare position found, add city
                    if (child.getCity(ii) == null) {
                        child.setCity(ii, parent2.getCity(i));
                        break;
                    }
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
