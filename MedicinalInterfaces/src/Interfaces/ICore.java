/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

/**
 *
 * @author gabriel
 */
public interface ICore {
    public abstract IUiController getUiController();
    public abstract IProjectController getProjectController();
    public abstract IPluginController getPluginController();
}