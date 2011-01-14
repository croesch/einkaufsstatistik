package de.purchasemgr;

import de.purchasemgr.i18n.Messages;

/**
 * The actions that are used in the program
 * 
 * @author $Author: croesch $
 * @version ($Date: 2010/12/19 12:56:24 $)
 */
public enum ActionPool {

  /** action to start the about dialog */
  ABOUT (Messages.MB_HELP_ABOUT),
  /** action to show the general statistics */
  STAT_GENERAL (Messages.MB_STAT_GENERAL),
  /** action to show the statistic of expenses per item */
  STAT_EXPENSES_ITEM (Messages.MB_STAT_EXPENSES_ITEM),
  /** action to show the statistic of expenses per shop */
  STAT_EXPENSES_SHOP (Messages.MB_STAT_EXPENSES_SHOP),
  /** action to show the statistic of expenses per week day */
  STAT_EXPENSES_WDAY (Messages.MB_STAT_EXPENSES_WDAY),
  /** action to show the statistic of expenses per month */
  STAT_EXPENSES_MONT (Messages.MB_STAT_EXPENSES_MONT),
  /** action to show the statistic of expenses per year */
  STAT_EXPENSES_YEAR (Messages.MB_STAT_EXPENSES_YEAR),
  /** action to show the statistic of purchases per item */
  STAT_PURCHASE_ITEM (Messages.MB_STAT_PURCHASE_ITEM),
  /** action to show the statistic of purchases per shop */
  STAT_PURCHASE_SHOP (Messages.MB_STAT_PURCHASE_SHOP),
  /** action to show the statistic of purchases per week day */
  STAT_PURCHASE_WDAY (Messages.MB_STAT_PURCHASE_WDAY),
  /** action to show the statistic of purchases per month */
  STAT_PURCHASE_MONT (Messages.MB_STAT_PURCHASE_MONT),
  /** action to show the statistic of purchases per year */
  STAT_PURCHASE_YEAR (Messages.MB_STAT_PURCHASE_YEAR),
  /** action to manage all shops */
  EDIT_SHOPS (Messages.MB_EDIT_MANAGESHOPS),
  /** action to add a new shop */
  NEW_SHOP (Messages.MB_EDIT_ADDSHOP),
  /** action to save the new added shop */
  NEW_SHOP_OK (Messages.SHOP_NEW_SAVE),
  /** action to cancel the new added shop */
  NEW_SHOP_CANCEL (Messages.SHOP_NEW_CANCEL),
  /** action to choose previous shop to edit */
  EDIT_SHOPS_PRE (Messages.SHOP_EDIT_PREV),
  /** action to choose next shop to edit */
  EDIT_SHOPS_NXT (Messages.SHOP_EDIT_NEXT),
  /** action to save edited shops */
  EDIT_SHOPS_SAV (Messages.SHOP_EDIT_SAVE),
  /** action to cancel editing shops */
  EDIT_SHOPS_CAN (Messages.SHOP_EDIT_CANC),
  /** action to add the new purchase */
  NEW_PURCHASE_SAVE (Messages.PURCHASE_NEW_SAVE),
  /** action to cancel adding a new purchase */
  NEW_PURCHASE_CAN (Messages.PURCHASE_NEW_CANC),
  /** name for item to create a new purchase */
  NEW_PURCHASE (Messages.PURCHASE_NEW),
  /** name for item to edit selected purchase */
  EDIT_PURCHASE (Messages.PURCHASE_EDIT),
  /** name for item to delete selected purchase */
  DEL_PURCHASE (Messages.PURCHASE_DEL),
  /** action to show some options to the user */
  OPTIONS (Messages.MB_HELP_OPTIONS),
  /** action to show the information about licence */
  VERSION_INFO (Messages.MB_HELP_VERSION),
  /** action to create a new file with new information */
  FILE_NEW (Messages.MB_MENU_NEW),
  /** action to open saved data from a file */
  FILE_OPEN (Messages.MB_MENU_OPEN),
  /** action to save the data to a file located on the file system */
  FILE_SAVE (Messages.MB_MENU_SAVE),
  /** action to close the program */
  EXIT (Messages.MB_MENU_EXIT),
  /** action to view and edit the items */
  EDIT_ITEMS (Messages.MB_EDIT_ITEMS);

  /** Version number. */
  public static final String VER = "$Revision: 1.5 $"; //$NON-NLS-1$

  private MainAction action;

  private ActionPool(Messages msg) {
    this.action = new MainAction(msg.text());
  }

  /**
   * @return the MainAction for that object
   */
  public MainAction getAction() {
    return this.action;
  }

}
