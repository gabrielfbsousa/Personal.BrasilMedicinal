/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JToolBar;

/**
 *
 * @author gabriel
 */
public interface IMainFrame {
     public abstract JLabel getjLabel1();

    public abstract void setjLabel1(JLabel jLabel1);

    public abstract JLabel getjLabel2();

    public abstract void setjLabel2(JLabel jLabel2);

    public abstract JLabel getjLabel3();

    public abstract void setjLabel3(JLabel jLabel3);

    public abstract JLabel getjLabel4();

    public abstract void setjLabel4(JLabel jLabel4);
    
    public abstract JLabel getjLabel5();

    public abstract void setjLabel5(JLabel jLabel5);

    public abstract JPanel getjPanel1();

    public abstract void setjPanel1(JPanel jPanel1);

    public abstract JPanel getjPanel2();

    public abstract void setjPanel2(JPanel jPanel2);

    public abstract JToolBar getjToolBar1();

    public abstract void setjToolBar1(JToolBar jToolBar1);
    
    public abstract void setVisible(boolean b);
}
