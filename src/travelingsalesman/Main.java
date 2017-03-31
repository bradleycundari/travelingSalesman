/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package travelingsalesman;

import java.io.IOException;
import java.io.PrintWriter;
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
    System.out.println("The map contains 25 cities.");
    //display(cityList);
    ArrayList<Double> data = new ArrayList();

    Genetics gene = new Genetics();
    Population pop1 = new Population(cityList,50);
    System.out.println("The distance of the fittest route of population #1: " + pop1.getFittest().getTotalDistance());
    data.add(pop1.getFittest().getTotalDistance()); 
    for (int z = 0; z < 50; z++)
    {
        pop1 = gene.evolve(pop1, cityList, pop1.getPopulationSize());
        System.out.println("The distance of the fittest route of population #" + z + ": " + pop1.getFittest().getTotalDistance());
        data.add(pop1.getFittest().getTotalDistance()); 
    }
    System.out.println("The distance of the fittest route of population #20: " + pop1.getFittest().getTotalDistance());
    data.add(pop1.getFittest().getTotalDistance()); 
    
    for (double j: data)
    {
        System.out.println(j);
    }
    
    
    /*
    try
    {
    PrintWriter writer = new PrintWriter("results.txt", "UTF-8");
    for (Double q: data)
    {
    writer.println(q);   
    }
    writer.println("");
    }
    catch (IOException e)
    {    
        System.out.println(e.getMessage());
    }
    */
    
    
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
