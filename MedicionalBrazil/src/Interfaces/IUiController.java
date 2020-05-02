/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import java.io.IOException;
import java.util.List;
import javax.swing.JToolBar;

/**
 *
 * @author gabriel
 */
public interface IUiController {
    public abstract void init() throws IOException;
    public abstract void initializeComponents();
     public abstract List<IRegionButton> getAllButtons();
     public abstract JToolBar getToolBar();
}
