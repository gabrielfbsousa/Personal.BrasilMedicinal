/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Shell;

import Interfaces.ICore;
import Interfaces.IPluginController;
import Interfaces.IProjectController;
import Interfaces.IUiController;
import java.io.IOException;

/**
 *
 * @author gabriel
 */
public class Core implements ICore{

   protected Core() throws IOException
    {
        uiController = new UiController();
        pluginController = new PluginController();
        pluginController.initialize(this);
        projectController = new ProjectController();
        projectController.initialize(this);
    }
    
    public static Core getInstance() throws IOException{
        if(instance == null) instance = new Core();
        //return new Core(); -- esse é do original
        return instance;
    }
    
    @Override
    public IUiController getUiController() {
        return uiController;
    }

    @Override
    public IProjectController getProjectController() {
        return projectController;
    }
    
    @Override
    public IPluginController getPluginController() {
        return pluginController;
    }
    
    private UiController uiController;
    private ProjectController projectController;
    private PluginController pluginController;
    private static Core instance = null;
    
}
