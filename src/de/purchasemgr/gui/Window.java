package de.purchasemgr.gui;

import java.awt.Toolkit;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JMenuBar;

import net.miginfocom.swing.MigLayout;

/**
 * TODO Comment here
 * 
 * @author croesch
 * @since Date: 2010/12/18 18:32:23
 */
public class Window extends JFrame {

  /** generated version UID */
  private static final long serialVersionUID = 5731315424494348485L;

  public Window(JComponent comp, int width, int height, JMenuBar menubar, String title) {
    Toolkit kit = Toolkit.getDefaultToolkit();
    int x = (kit.getScreenSize().width - width) / 2;
    int y = (kit.getScreenSize().height - height) / 2;

    this.setVisible(false);
    this.setResizable(false);
    this.setTitle(title);
    getContentPane().add(comp);
    getContentPane().setLayout(new MigLayout("", "[fill, grow]", "[fill, grow]"));
    this.setSize(width, height);
    this.setLocation(x, y);
    this.setJMenuBar(menubar);
  }
}
