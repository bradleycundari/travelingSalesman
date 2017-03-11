/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package travelingsalesman;

import javax.swing.JFrame;

/**
 *
 * @author Brad
 */
public class GUI 
{
    JFrame mainWindow = new JFrame();     
    
    public static void main(String args[])
    {  
    }
    
    public void show()
    {
        mainWindow.setSize(500,500);
        mainWindow.setLayout(null);
        mainWindow.setTitle("Traveling Salesman");
        mainWindow.setVisible(true);
    }
   
    public JFrame getMainWindow()
    {
        return mainWindow;
    }
            
            
            
            
            
 }