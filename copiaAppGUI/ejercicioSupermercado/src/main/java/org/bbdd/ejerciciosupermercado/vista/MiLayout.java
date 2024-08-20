package org.bbdd.ejerciciosupermercado.vista;

import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.LayoutManager;

public class MiLayout implements LayoutManager {

    private int x;
    private int y = 20;
    
    @Override
    public void layoutContainer(Container micontenedor) {
        int d = micontenedor.getWidth();
        
        x = d/2;
        
        int contador = 0;
        int n = micontenedor.getComponentCount();
        
        for(int i=0; i<n; i++){
            contador++;
            Component c = micontenedor.getComponent(i);
            c.setBounds(x-100, y, 100, 20);
            x+=100;
            if(contador % 2 == 0){
                x=d/2;
                y+=40;
            }
        }
        
    }
    
    @Override
    public void addLayoutComponent(String name, Component comp) {
        
    }

    @Override
    public void removeLayoutComponent(Component comp) {
        
    }

    @Override
    public Dimension preferredLayoutSize(Container parent) {
        return null;
    }

    @Override
    public Dimension minimumLayoutSize(Container parent) {
       return null; 
    }

}