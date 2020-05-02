/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Shell;

import Interfaces.ICore;
import Interfaces.IPlugin;
import Interfaces.IPluginController;
import Interfaces.IUiController;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import medicionalbrazil.regions.NortheastButton;

/**
 *
 * @author gabriel
 */
public class PluginController implements IPluginController {
    private ArrayList<IPlugin> allPlugins;
    
    public PluginController(){
        allPlugins = new ArrayList<>();
    }

    @Override
    public void initialize(ICore core) {
        IUiController uiController = core.getUiController();
        javax.swing.JButton newButton = new javax.swing.JButton();
        newButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
                int result = fileChooser.showOpenDialog(null);
                if (result == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = fileChooser.getSelectedFile();
                    System.out.println("Selected file: " + selectedFile.getAbsolutePath());
                    
                    try {
                        try {
                            loadSelectedPlugin(selectedFile, core);
                        } catch (ClassNotFoundException ex) {
                            Logger.getLogger(PluginController.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (InstantiationException ex) {
                            Logger.getLogger(PluginController.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (IllegalAccessException ex) {
                            Logger.getLogger(PluginController.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    } catch (MalformedURLException ex) {
                        Logger.getLogger(PluginController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        });
        ImageIcon image = new ImageIcon(getClass().getResource("/resources/puzzle-piece-plugin.png"));
        newButton.setIcon(image); 
        newButton.setFocusable(false);
        newButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        newButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        newButton.setVisible(false);
        //uiController.getToolBar().add(newButton);
    }

    @Override
    public ArrayList<IPlugin> getAllPlugins() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void loadSelectedPlugin(File selectedFile, ICore core) throws MalformedURLException, ClassNotFoundException, InstantiationException, IllegalAccessException{
        URL []urlVector = new URL[1];
        urlVector[0] = selectedFile.toURI().toURL();
     URLClassLoader ucl = new URLClassLoader(urlVector);
     
     IPlugin plugin = (IPlugin) Class.forName("plugin.EditorPlugin", true, ucl).newInstance();
     if(plugin != null){
         System.out.println("Found a plugin!");
         plugin.initialize(core);
         allPlugins.add(plugin);
         System.out.println("Plugin Loaded!");

     }
    }

}
