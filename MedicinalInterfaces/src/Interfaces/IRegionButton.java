/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Forms.MainFrame;
import java.awt.event.MouseAdapter;
import java.io.File;
import java.io.IOException;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author gabriel
 */
public interface IRegionButton {

    public abstract void installButton(MainFrame frame) throws IOException;

    public abstract void addContent(JPanel panel) throws IOException;

    public abstract void saveNewImage(File selectedFile);

    public abstract void addActionToButton(JLabel lblNewLabel, MouseAdapter mouserAdapter);
    
    public abstract void removeActionFromButton(JLabel lblNewLabel, MouseAdapter mouserAdapter);

    public abstract MouseAdapter getDefaultMouseAdapter();

    public abstract JLabel getLabel();

    public abstract JPanel getPanel();

}
