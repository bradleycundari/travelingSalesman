/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package travelingsalesman;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author Brad
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
    //GUI mainGUI = new GUI();
    //mainGUI.show();
    
    
    //This will be the city mapping randomly generated
    ArrayList<City> cityList = new ArrayList();
    cityList = generateRandomCityMap(25);
    //display(cityList);

    Genetics gene = new Genetics();
    Population pop1 = new Population(cityList,20);
    System.out.println("The fittest of initial: " + pop1.getFittest().getTotalDistance());
    System.out.println("");
    for (int i = 0; i < 20; i++)
    {
        pop1 = gene.evolve(pop1, cityList, pop1.getPopulationSize());
        System.out.println("The fittest of " + i + " :" + pop1.getFittest().getTotalDistance());
    }
    System.out.println("The ending fittest: " + pop1.getFittest().getTotalDistance());
    
   
    }
    
    
    
    public static ArrayList<City> generateRandomCityMap(int size)
    {//begin generateRoute
    ArrayList<City> tempList = new ArrayList();
    Random rand = new Random();
    rand.setSeed(1000);
    for (int i = 0; i < size; i++)
    {    
    tempList.add(new City(rand.nextInt(500),rand.nextInt(500)));
    } 
    return tempList;  
    } //end generateRoute       
    
    public static void display(ArrayList<City> listPassed)
    {
        listPassed.forEach((i) -> {
            System.out.println(i.toString());
        });
    }
    
    
} // end main class
