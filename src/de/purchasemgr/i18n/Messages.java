package de.purchasemgr.i18n;

import com.github.croesch.util.FilePropertiesBundle;

/**
 * This class provides access to the messages properties file.
 * 
 * @author croesch
 * @since Date: 2010/12/19 12:56:24
 */
@SuppressWarnings("nls")
public enum Messages {

  /** the text of the label in about frame */
  PROGRAM_ABOUT_TEXT,

  /** the title of the about frame */
  PROGRAM_ABOUT_TITLE,

  /** the name of the program */
  PROGRAM_NAME,

  /** the string that represents a shop */
  SHOP_STRING,

  /** the title for a new shop dialog */
  SHOP_NEW,

  /** the description for the button to save a new shop */
  SHOP_NEW_SAVE,

  /** the description for the button to cancel adding a new shop */
  SHOP_NEW_CANCEL,

  /** the description for the word index in a new shop dialog */
  SHOP_NEW_INDEX,

  /** the current index for the new shop */
  SHOP_NEW_INDEX_VALUE,

  /** the word name in shop - new */
  SHOP_NAME,

  /** the word postcode in shop - new */
  SHOP_POSTCODE,

  /** the word location in shop - new */
  SHOP_LOCATION,

  /** the title of frame when editing a shop */
  SHOP_EDIT,

  /** the word index in editing a shop */
  SHOP_EDIT_INDEX,

  /** the string to display the current index */
  SHOP_EDIT_INDEX_VALUE,

  /** the string for the next button when editing the shops */
  SHOP_EDIT_NEXT,

  /** the string for the button to edit the previous shop */
  SHOP_EDIT_PREV,

  /** the string for the button to save edited shops */
  SHOP_EDIT_SAVE,

  /** the string for the button to cancel editing shops */
  SHOP_EDIT_CANC,

  /** the string for the representation of a purchase */
  PURCHASE_STRING,

  /** the title of the frame and the button for a new purchase */
  PURCHASE_NEW,

  /** the title of button to save the new purchase */
  PURCHASE_NEW_SAVE,

  /** the title of button to cancel adding a new purchase */
  PURCHASE_NEW_CANC,

  /** the word date for the new purchase dialog */
  PURCHASE_NEW_DATE,

  /** the word shop for the new purchase dialog */
  PURCHASE_NEW_SHOP,

  /** the button to edit a selected purchase */
  PURCHASE_EDIT,

  /** the button to delete a selected purchase */
  PURCHASE_DEL,

  /** the string that contains the representation of an item */
  ITEM_STRING,

  /** description of the menu menu */
  MB_MENU,

  /** description of the item new in menu menu */
  MB_MENU_NEW,

  /** description of the item open in menu menu */
  MB_MENU_OPEN,

  /** description of the item save in menu menu */
  MB_MENU_SAVE,

  /** description of the item exit in menu menu */
  MB_MENU_EXIT,

  /** description of the menu edit */
  MB_EDIT,

  /** description of the item edit items in edit menu */
  MB_EDIT_ITEMS,

  /** description of the item add shop in edit menu */
  MB_EDIT_ADDSHOP,

  /** description of the item manage all shops in edit menu */
  MB_EDIT_MANAGESHOPS,

  /** description of the menu statistic */
  MB_STAT,

  /** the description of the item general in menu statistic */
  MB_STAT_GENERAL,

  /** description of the menu purchase in statistic */
  MB_STAT_PURCHASE,

  /** the description of the item item in menu statistic per purchase */
  MB_STAT_PURCHASE_ITEM,

  /** the description of the item shop in menu statistic per purchase */
  MB_STAT_PURCHASE_SHOP,

  /** the description of the item week day in menu statistic per purchase */
  MB_STAT_PURCHASE_WDAY,

  /** the description of the item month in menu statistic per purchase */
  MB_STAT_PURCHASE_MONT,

  /** the description of the item year in menu statistic per purchase */
  MB_STAT_PURCHASE_YEAR,

  /** description of the menu expenses in statistic */
  MB_STAT_EXPENSES,

  /** the description of the item item in menu statistic per expense */
  MB_STAT_EXPENSES_ITEM,

  /** the description of the item shop in menu statistic per expense */
  MB_STAT_EXPENSES_SHOP,

  /** the description of the item week day in menu statistic per expense */
  MB_STAT_EXPENSES_WDAY,

  /** the description of the item month in menu statistic per expense */
  MB_STAT_EXPENSES_MONT,

  /** the description of the item year in menu statistic per expense */
  MB_STAT_EXPENSES_YEAR,

  /** description of the menu help */
  MB_HELP,

  /** the description of the item about in menu help */
  MB_HELP_ABOUT,

  /** the description of the item options in menu help */
  MB_HELP_OPTIONS,

  /** the description of the item version in menu help */
  MB_HELP_VERSION,

  /** the message that is displayed when no shops are there but someone wants to edit them */
  LOG_NOSHOPSTOEDIT,

  /** the message is displayed when no purchase is selected but should be edited */
  LOG_NOPURCHASETOEDIT,

  /** the message is displayed when no purchase is selected but should be deleted */
  LOG_NOPURCHASETODELETE,

  /** the message is displayed when no shop is available but a purchase should be created */
  LOG_NOSHOPFORPURCHASE,

  /** the message is displayed when the action is not supported */
  LOG_ACTION_ERROR,

  /** the prefix for an error message */
  LOG_ERROR,

  /** the prefix for an info message */
  LOG_INFO,

  /** the string for an illegal argument exception */
  EXC_ILLARG;

  /** the actual message of this instance */
  private final String string;

  /**
   * Constructs a new message. The properties file is expected to be in the {@code lang}-directory.<br>
   * The name of the properties file is {@code messages + CODE + .properties}<br> {@code CODE} is built from the
   * {@link java.util.Locale}, it can be empty or one of these: <li>{@code _LC} where LC is the language code</li> <li>
   * {@code _LC_CT} where CT is the country code</li> <li>{@code _LC_CT_VR} where VT is the variant code</li><br>
   * <br>
   * The key for the property to lookup is {@code pmanager. + NAME}. {@code NAME} is the {@link Enum#name()} of this
   * enum is, but it is converted to lower case and '_' are replaced by '.'.
   * 
   * @author croesch
   * @since Date: 08.02.2011 18:59:14
   * @see java.util.ResourceBundle#getBundle(String, java.util.Locale, ClassLoader)
   * @see Enum#name()
   * @see String#toLowerCase()
   */
  private Messages() {
    final String key = "pmanager." + name().toLowerCase().replace('_', '.');
    this.string = FilePropertiesBundle.getText("lang/messages", key);
  }

  @Override
  public String toString() {
    return text();
  }

  /**
   * String representation of this object
   * 
   * @return the String that represents the object
   */
  public String text() {
    return this.string;
  }

  /**
   * String representation of this object, but {x} will be replaced by argument number x starting to count from 0.
   * 
   * @param s the replacements
   * @return the String that represents the object with replaced placeholders
   */
  public String text(final String ... s) {
    String text = this.string;
    for (int i = 0; i < s.length; ++i) {
      text = text.replaceAll("([^{]?)\\{" + i + "\\}", "$1" + s[i]);
      text = text.replaceAll("\\{\\{" + i + "\\}", "\\{" + i + "\\}");
    }
    return text;
  }
}
