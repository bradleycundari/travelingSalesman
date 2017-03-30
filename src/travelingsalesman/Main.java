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
    cityList = generateRandomCityMap(6);
    //display(cityList);

    Population pop1 = new Population(cityList,20);
    Population pop2 = new Population(cityList,20);
    Genetics gene = new Genetics();
        
    //pop1.display();
    Route test = gene.crossover(pop1.getRoute(0), pop1.getRoute(1),cityList);
    //System.out.println("Parent 1:");
    //pop1.getRoute(0).display();
    //System.out.println("");
    //System.out.println("Parent 2:");
    //pop2.getRoute(1).display();
    //System.out.println("Child:");
    //test.display();
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
