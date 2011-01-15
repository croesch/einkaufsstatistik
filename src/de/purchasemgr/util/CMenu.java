package de.purchasemgr.util;

import javax.swing.Action;
import javax.swing.JMenu;

/**
 * This menu is able to set its mnemonic key automatically.
 * 
 * @author croesch
 * @since Date: 2010/12/19 12:56:24 $)
 */
public class CMenu extends JMenu {

  /** version UID */
  private static final long serialVersionUID = -8285015108385978148L;

  /**
   * Simply calls {@link JMenu#JMenu()}
   */
  public CMenu() {
    super();
  }

  /**
   * Simply calls {@link JMenu#JMenu(Action)}
   * 
   * @param a parameter Action that is given to {@link JMenu#JMenu(Action)}
   */
  public CMenu(Action a) {
    super(a);
  }

  /**
   * Simply calls {@link JMenu#JMenu(String, boolean)}
   * 
   * @param s parameter String that is given to {@link JMenu#JMenu(String, boolean)}
   * @param b parameter boolean that is given to {@link JMenu#JMenu(String, boolean)}
   */
  public CMenu(String s, boolean b) {
    super(s, b);
  }

  /**
   * Simply calls {@link JMenu#JMenu(String)}
   * 
   * @param s parameter that is given to {@link JMenu#JMenu(String)}
   */
  public CMenu(String s) {
    super(s);
  }

  @Override
  public void setText(String text) {
    super.setText(MnemonicUtil.filterMnemonic(text, this));
  }
}
