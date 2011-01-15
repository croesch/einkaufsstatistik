package de.purchasemgr.util;

import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.JMenuItem;

/**
 * This menu item is able to set its mnemonic key automatically.
 * 
 * @author croesch
 * @since Date: 2010/12/19 12:56:24
 */
public class CMenuItem extends JMenuItem {

  /** serial version UID */
  private static final long serialVersionUID = 3614702957338710920L;

  /**
   * Simply calls {@link JMenuItem#JMenuItem()}
   * 
   * @see JMenuItem#JMenuItem()
   */
  public CMenuItem() {
    super();
  }

  /**
   * Simply calls {@link JMenuItem#JMenuItem(Icon)}
   * 
   * @see JMenuItem#JMenuItem(Icon)
   * @param icon the parameter Icon that is given to superclass constructor
   */
  public CMenuItem(Icon icon) {
    super(icon);
  }

  /**
   * Simply calls {@link JMenuItem#JMenuItem(String)}
   * 
   * @see JMenuItem#JMenuItem(String)
   * @param text the parameter String that is given to superclass constructor
   */
  public CMenuItem(String text) {
    super(text);
  }

  /**
   * Simply calls {@link JMenuItem#JMenuItem(Action)}
   * 
   * @see JMenuItem#JMenuItem(Action)
   * @param a the parameter Action that is given to superclass constructor
   */
  public CMenuItem(Action a) {
    super(a);
  }

  /**
   * Simply calls {@link JMenuItem#JMenuItem(String, Icon)}
   * 
   * @see JMenuItem#JMenuItem(String, Icon)
   * @param text the parameter String that is given to superclass constructor
   * @param icon the parameter Icon that is given to superclass constructor
   */
  public CMenuItem(String text, Icon icon) {
    super(text, icon);
  }

  /**
   * Simply calls {@link JMenuItem#JMenuItem(String, int)}
   * 
   * @see JMenuItem#JMenuItem(String, int)
   * @param text the parameter String that is given to superclass constructor
   * @param mnemonic the parameter int that is given to superclass constructor
   */
  public CMenuItem(String text, int mnemonic) {
    super(text, mnemonic);
  }

  @Override
  public void setText(String text) {
    super.setText(MnemonicUtil.filterMnemonic(text, this));
  }
}
