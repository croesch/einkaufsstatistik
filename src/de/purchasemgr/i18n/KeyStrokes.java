package de.purchasemgr.i18n;

import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.KeyStroke;

import com.github.croesch.util.FilePropertiesBundle;


/**
 * This class provides access to the keystrokes properties file.
 * 
 * @author croesch
 * @since Date: 2010/12/19 12:56:24
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

  /** the keystroke of this instance */
  private final KeyStroke stroke;

  /**
   * Constructs a new keystroke. The properties file is expected to be in the {@code config}-directory.<br>
   * The name of the properties file is {@code keystroke + CODE + .properties}<br> {@code CODE} is built from the
   * {@link Locale}, it can be empty or one of these: <li>{@code _LC} where LC is the language code</li> <li>{@code
   * _LC_CT} where CT is the country code</li> <li>{@code _LC_CT_VR} where VT is the variant code</li><br>
   * <br>
   * The key for the property to lookup is {@code pmanager. + NAME}. {@code NAME} is the {@link Enum#name()} of this
   * enum is, but it is converted to lower case and '_' are replaced by '.'.
   * 
   * @author croesch
   * @since Date: 08.02.2011 18:59:14
   * @see ResourceBundle#getBundle(String, java.util.Locale, ClassLoader)
   * @see Enum#name()
   * @see String#toLowerCase()
   */
  private KeyStrokes() {
    final String key = "pmanager." + name().toLowerCase().replace('_', '.');
    final String str = FilePropertiesBundle.getMessageFromSingleBundle("config/keystrokes", key);
    if (str == null) {
      this.stroke = KeyStroke.getKeyStroke("");
    } else {
      this.stroke = KeyStroke.getKeyStroke(str);
    }
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
