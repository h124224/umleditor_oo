import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JToggleButton;

public class UMLEditor extends JFrame{
	//component
	private JToggleButton[] btnFunction;
	//private UMLCanvas canvas;
	
	UMLEditor(){
		// set the property of frame
        setSize(800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
 
        setMenubar();
        setFunctionArea();
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
        //changeObjName.setEnabled(false);
        changeObjName.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
	
			}      	
        });
        menuEdit.add(changeObjName);
	}
	
	private void setFunctionArea(){
		//set function area
        JPanel panelFunction = new JPanel(new GridLayout(6,1));
        //set button
        btnFunction = new JToggleButton[6];
        btnFunction[0] = new JToggleButton(new ImageIcon("umleditor/select.png"));
        btnFunction[1] = new JToggleButton(new ImageIcon("umleditor/accline.png"));
        btnFunction[2] = new JToggleButton(new ImageIcon("umleditor/genline.png"));
        btnFunction[3] = new JToggleButton(new ImageIcon("umleditor/comline.png"));
        btnFunction[4] = new JToggleButton(new ImageIcon("umleditor/addclass.png"));
        btnFunction[5] = new JToggleButton(new ImageIcon("umleditor/addusecase.png"));
        for(int i=0;i<6;i++){
        	//btnFunction[i].addActionListener(fl);
            panelFunction.add(btnFunction[i]);
        }
        add(panelFunction,BorderLayout.WEST);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UMLEditor frame = new UMLEditor();
        frame.setVisible(true);
	}

}
