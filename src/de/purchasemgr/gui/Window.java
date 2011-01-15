package de.purchasemgr.gui;

import java.awt.FlowLayout;
import java.awt.Toolkit;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JMenuBar;

/**
 * TODO Comment here
 * 
 * @author croesch
 * @since Date: 2010/12/18 18:32:23
 */
public class Window extends JFrame {

  /** generated version UID */
  private static final long serialVersionUID = 5731315424494348485L;

  Window(JComponent comp, int width, int height, JMenuBar menubar, String title) {
    Toolkit kit = Toolkit.getDefaultToolkit();
    int x = (kit.getScreenSize().width - width) / 2;
    int y = (kit.getScreenSize().height - height) / 2;

    this.setVisible(false);
    this.setResizable(false);
    this.setLayout(new FlowLayout());
    this.setTitle(title);
    this.add(comp);
    this.setSize(width, height);
    this.setLocation(x, y);
    this.setJMenuBar(menubar);
  }
}
