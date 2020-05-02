/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Shell;

import Interfaces.ICore;
import Interfaces.IProjectController;
import Interfaces.IUiController;
import java.awt.BorderLayout;
import java.awt.Image;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import medicionalbrazil.regions.NortheastButton;

/**
 *
 * @author gabriel
 */
public class ProjectController implements IProjectController{

    @Override
    public void initialize(ICore core) {
        IUiController uiController = core.getUiController();
        
        uiController.initializeComponents();       
        
    }
    
}
