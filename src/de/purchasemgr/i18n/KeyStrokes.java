package de.purchasemgr.i18n;

import javax.swing.KeyStroke;

/**
 * This class provides access to the keystrokes properties file.
 * 
 * @author $Author: croesch $
 * @version $Revision: 1.1 $ ($Date: 2010/12/19 12:56:24 $)
 */
@SuppressWarnings("nls")
public enum KeyStrokes {

  /** keystroke for exiting the program */
  PROGRAM_EXIT,

  /** keystroke for making a new file */
  FILE_NEW,
  /** keystroke for saving current file */
  FILE_SAVE,
  /** keystroke for opening a file */
  FILE_OPEN,

  /** keystroke for making a new shop */
  NEW_SHOP,

  /** keystroke for editing the items */
  EDIT_ITEMS,
  /** keystroke for editing the shops */
  EDIT_SHOPS,

  /** keystroke for displaying general statistics */
  STAT_GENERAL,

  /** keystroke for displaying statistics of expenses per item */
  STAT_EXPENSES_ITEM,
  /** keystroke for displaying statistics of expenses per shop */
  STAT_EXPENSES_SHOP,
  /** keystroke for displaying statistics of expenses per week day */
  STAT_EXPENSES_WDAY,
  /** keystroke for displaying statistics of expenses per month */
  STAT_EXPENSES_MONT,
  /** keystroke for displaying statistics of expenses per year */
  STAT_EXPENSES_YEAR,

  /** keystroke for displaying statistics of purchases per item */
  STAT_PURCHASE_ITEM,
  /** keystroke for displaying statistics of purchases per shop */
  STAT_PURCHASE_SHOP,
  /** keystroke for displaying statistics of purchases per week day */
  STAT_PURCHASE_WDAY,
  /** keystroke for displaying statistics of purchases per month */
  STAT_PURCHASE_MONT,
  /** keystroke for displaying statistics of purchases per year */
  STAT_PURCHASE_YEAR,

  /** keystroke for opening the options */
  HELP_OPTIONS,
  /** keystroke for displaying version information */
  HELP_VERSION,
  /** keystroke for displaying information about program */
  HELP_ABOUT;

  private final KeyStroke stroke;

  private KeyStrokes() {
    final String key = "pmanager." + name().toLowerCase().replace('_', '.');
    this.stroke = KeyStroke.getKeyStroke(KeyStrokesBundle.getStroke(key));
  }

  @Override
  public String toString() {
    return this.stroke.toString();
  }

  /**
   * key stroke of that object
   * 
   * @return the key stroke for that object
   */
  public KeyStroke stroke() {
    return this.stroke;
  }
}
