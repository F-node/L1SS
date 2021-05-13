/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package lss;

import java.awt.*;
import java.util.Vector;
import javax.swing.*; 
/**
 *
 * @author user
 */
public class WideComboBox extends JComboBox{ 
 
    public WideComboBox() { 
    } 
 
    public WideComboBox(final Object items[]){ 
        super(items); 
    } 
 
    public WideComboBox(Vector items) { 
        super(items); 
    } 
 
    public WideComboBox(ComboBoxModel aModel) { 
        super(aModel); 
    } 
 
    private boolean layingOut = false; 
 
    @Override
    public void doLayout(){ 
        try{ 
            layingOut = true; 
            super.doLayout(); 
        }finally{ 
            layingOut = false; 
        } 
    } 
 
    @Override
    public Dimension getSize(){ 
        Dimension dim = super.getSize(); 
        if(!layingOut) {
            dim.width = Math.max(dim.width, getPreferredSize().width); 
        } 
        return dim; 
    } 
}