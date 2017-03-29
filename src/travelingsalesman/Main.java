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
    display(cityList);

    Population pop1 = new Population();
    Population pop2 = new Population();
    pop1.createPopulation(cityList,20);
    pop1.createPopulation(cityList,20);
    pop1.setTotalDistances();
    pop2.setTotalDistances();
    pop1.display();
    System.out.println();
    pop2.display();
    }
    
    
    
    public static ArrayList<City> generateRandomCityMap(int size)
    {//begin generateRoute
    ArrayList<City> tempList = new ArrayList();
    Random rand = new Random();
    for (int i = 0; i < size; i++)
    {    
    tempList.add(new City(rand.nextInt(500),rand.nextInt(500)));
    } 
    return tempList;  
    } //end generateRoute       
    
    public static void display(ArrayList<City> listPassed)
    {
        for (City i: listPassed)
        {
            System.out.println(i.toString());
        }
    }
    
    
} // end main class
