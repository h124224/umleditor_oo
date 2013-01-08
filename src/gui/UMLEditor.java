package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import mode.Mode;

import actions.*;
import button.*;

public class UMLEditor extends JFrame{
	//component
	private Canvas canvas;
	private SelectionButton selBtn;
	private ClassButton clsBtn;
	private UsecaseButton ucBtn;
	private AssociationLineButton alBtn;
	private CompositionLineButton clBtn;
	private GeneralizationLineButton glBtn;
	
	//controll
	private List<CustomButton> buttons = new ArrayList<CustomButton>();
	private DetectButtonStateListner dl = new DetectButtonStateListner();
	private ChangeObjectNameListener cl = new ChangeObjectNameListener();
	
	UMLEditor(){
		// set the property of frame
        setSize(800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
 
        setMenubar();
        setFunctionArea();
        setPaintingArea();
	}
	
	private void setMenubar(){
		// set the menubar
        JMenuBar bar = new JMenuBar();
        setJMenuBar(bar);
 
        // set a menu.
        JMenu menuFile = new JMenu("File");
        bar.add(menuFile);
        JMenu menuEdit = new JMenu("Edit");
        bar.add(menuEdit);
 
        // add sub menus.
        menuFile.add(new JMenuItem("Open File"));
        menuFile.addSeparator();
        menuFile.add(new JMenuItem("Close"));
        
        JMenuItem group = new JMenuItem("Group");
        group.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

			}      	
        });
        menuEdit.add(group);
        
        JMenuItem ungroup = new JMenuItem("Ungroup");
        ungroup.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {

			}      	
        });
        menuEdit.add(ungroup);
        
        menuEdit.addSeparator();
        JMenuItem changeObjName = new JMenuItem("Change Object Name");
        changeObjName.addActionListener(cl);
        menuEdit.add(changeObjName);
	}
	
	private void setFunctionArea(){
		//set function area
        JPanel panelFunction = new JPanel(new GridLayout(6,1));
        //set button
        selBtn = new SelectionButton(new ImageIcon("umleditor/select.png"));
        buttons.add(selBtn);
        alBtn  = new AssociationLineButton(new ImageIcon("umleditor/accline.png"));
        buttons.add(alBtn);
        clBtn  = new CompositionLineButton(new ImageIcon("umleditor/genline.png"));
        buttons.add(clBtn);
        glBtn  = new GeneralizationLineButton(new ImageIcon("umleditor/comline.png"));
        buttons.add(glBtn);
        clsBtn = new ClassButton(new ImageIcon("umleditor/addclass.png"));
        buttons.add(clsBtn);
        ucBtn  = new UsecaseButton(new ImageIcon("umleditor/addusecase.png"));
        buttons.add(ucBtn);

        for(CustomButton btn : buttons){
        	btn.addActionListener(dl);
        	panelFunction.add(btn);
        }
        
        add(panelFunction,BorderLayout.WEST);
	}
	
	private void setPaintingArea(){
		//set draw area
		canvas = new Canvas();
        canvas.setBackground(Color.WHITE);
        add(canvas,BorderLayout.CENTER);
        cl.useCanvas(canvas);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UMLEditor frame = new UMLEditor();
        frame.setVisible(true);
	}
	
	private class DetectButtonStateListner implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			for(CustomButton btn : buttons)
				btn.setSelected(false);
			
			CustomButton btn = (CustomButton) e.getSource();
			btn.setSelected(true);
		}
		
	}

}
