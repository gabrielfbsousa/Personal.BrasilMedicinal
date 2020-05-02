/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package plugin;

import Interfaces.ICore;
import Interfaces.IPlugin;
import Interfaces.IRegionButton;
import Interfaces.IUiController;
import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;

/**
 *
 * @author gabriel
 */
public class EditorPlugin implements IPlugin{
    private boolean counterClicked;
    private MouseAdapter editorMouseAdapter;
    
    public EditorPlugin(){
        counterClicked = false;
    }
    
    
    @Override
    public void initialize(ICore icore) {
        IUiController uiController = icore.getUiController();
        javax.swing.JButton newButton = new javax.swing.JButton();
        newButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if(counterClicked == false){
                    //Se não tiver ativado o modo edição, ativar ele - Ligar Modo edição
                    newButton.setBorder(BorderFactory.createLoweredBevelBorder());
                    changeRegionButtonsBehaviour(uiController.getAllButtons());
                    System.out.println("Changed to edit");
                    //lblNewLabel.setIcon(clicking);
                    counterClicked = true;
                } else {
                    //.Se estiver ativado o modo edição, desativar ele - Voltar ao modo Play
                    for(int i = 0; i < uiController.getAllButtons().size(); i++){
                        IRegionButton button = uiController.getAllButtons().get(i);
                        button.removeActionFromButton(button.getLabel(), editorMouseAdapter);
                        uiController.getAllButtons().get(i).addActionToButton(button.getLabel(), button.getDefaultMouseAdapter());
                    }
                    System.out.println("Changed back to Play mode");
                    counterClicked = false;
                    newButton.setBorder(BorderFactory.createCompoundBorder());
                }
                
            }
        });
        
        ImageIcon image = new ImageIcon(getClass().getResource("/resources/pencil.png"));
        newButton.setIcon(image); 
        newButton.setFocusable(false);
        newButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        newButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        uiController.getToolBar().add(newButton);
    }
    
    
    public void changeRegionButtonsBehaviour(List<IRegionButton> allButtons){
        
        
        for(int i = 0; i < allButtons.size(); i++){
            IRegionButton selectedButton = allButtons.get(i);
            editorMouseAdapter = new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {

                addContentToPanel(selectedButton);
                super.mousePressed(e);
            }
        };
            //allButtons.get(i).addActionToButton(allButtons.get(i).getLabel(), mouseAction);
            selectedButton.removeActionFromButton(allButtons.get(i).getLabel(), allButtons.get(i).getDefaultMouseAdapter());
            selectedButton.addActionToButton(allButtons.get(i).getLabel(), editorMouseAdapter);
            //Pra cada botao, o clique nele deve mostrar, no panel 2, uma imagem de "importe uma imagem", que ao ser clicado, vai abrir um JFileChooser
        }
    }
    
    public void addContentToPanel(IRegionButton button){
        
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
                    button.saveNewImage(selectedFile);//TODO salvar esse file. Fazer esse método
                    
                   
                }
            }
        });
        //Criando a imagem do Ícone
        ImageIcon image = new ImageIcon(getClass().getResource("/resources/import.png"));
        newButton.setIcon(image); 
        newButton.setFocusable(false);
        newButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        newButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        
        button.getPanel().removeAll();
        button.getPanel().setLayout(new BorderLayout());
        button.getPanel().add(newButton);
        button.getPanel().validate();
        button.getPanel().repaint();

    }
    
}
