package de.purchasemgr;

import de.purchasemgr.i18n.Messages;

/**
 * The actions that are used in the program.
 * 
 * @author croesch
 * @since Date: 2010/12/19 12:56:24
 */
public enum ActionPool {

  /** action to start the about dialog. */
  ABOUT (Messages.MB_HELP_ABOUT),
  /** action to show the general statistics. */
  STAT_GENERAL (Messages.MB_STAT_GENERAL),
  /** action to show the statistic of expenses per item. */
  STAT_EXPENSES_ITEM (Messages.MB_STAT_EXPENSES_ITEM),
  /** action to show the statistic of expenses per shop. */
  STAT_EXPENSES_SHOP (Messages.MB_STAT_EXPENSES_SHOP),
  /** action to show the statistic of expenses per week day. */
  STAT_EXPENSES_WDAY (Messages.MB_STAT_EXPENSES_WDAY),
  /** action to show the statistic of expenses per month. */
  STAT_EXPENSES_MONT (Messages.MB_STAT_EXPENSES_MONT),
  /** action to show the statistic of expenses per year. */
  STAT_EXPENSES_YEAR (Messages.MB_STAT_EXPENSES_YEAR),
  /** action to show the statistic of purchases per item. */
  STAT_PURCHASE_ITEM (Messages.MB_STAT_PURCHASE_ITEM),
  /** action to show the statistic of purchases per shop. */
  STAT_PURCHASE_SHOP (Messages.MB_STAT_PURCHASE_SHOP),
  /** action to show the statistic of purchases per week day. */
  STAT_PURCHASE_WDAY (Messages.MB_STAT_PURCHASE_WDAY),
  /** action to show the statistic of purchases per month. */
  STAT_PURCHASE_MONT (Messages.MB_STAT_PURCHASE_MONT),
  /** action to show the statistic of purchases per year. */
  STAT_PURCHASE_YEAR (Messages.MB_STAT_PURCHASE_YEAR),
  /** action to manage all shops. */
  EDIT_SHOPS (Messages.MB_EDIT_MANAGESHOPS),
  /** action to add a new shop. */
  NEW_SHOP (Messages.MB_EDIT_ADDSHOP),
  /** name for item to create a new purchase. */
  NEW_PURCHASE (Messages.PURCHASE_NEW),
  /** name for item to edit selected purchase. */
  EDIT_PURCHASE (Messages.PURCHASE_EDIT),
  /** name for item to delete selected purchase. */
  DEL_PURCHASE (Messages.PURCHASE_DEL),
  /** action to show some options to the user. */
  OPTIONS (Messages.MB_HELP_OPTIONS),
  /** action to show the information about licence. */
  VERSION_INFO (Messages.MB_HELP_VERSION),
  /** action to create a new file with new information. */
  FILE_NEW (Messages.MB_MENU_NEW),
  /** action to open saved data from a file. */
  FILE_OPEN (Messages.MB_MENU_OPEN),
  /** action to save the data to a file located on the file system. */
  FILE_SAVE (Messages.MB_MENU_SAVE),
  /** action to close the program. */
  EXIT (Messages.MB_MENU_EXIT),
  /** action to view and edit the items. */
  EDIT_ITEMS (Messages.MB_EDIT_ITEMS);

  /** the action for this instance. */
  private MainAction action;

  /** the message this instance contains. */
  private final String message;

  /**
   * Creates the instance of this enum with the given message.
   * 
   * @author croesch
   * @since Date: 30.01.2011 16:28:02
   * @param msg the messages object
   */
  private ActionPool(final Messages msg) {
    this.message = msg.text();
    this.action = new MainAction(this);
  }

  /**
   * Returns the text message of this action.
   * 
   * @author croesch
   * @since Date: 15.01.2011 14:16:19
   * @return the text of this action
   */
  public String text() {
    return this.message;
  }

  /**
   * @return the MainAction for that object
   */
  public MainAction getAction() {
    return this.action;
  }
}
