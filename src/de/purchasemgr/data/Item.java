package de.purchasemgr.data;

import de.purchasemgr.i18n.Messages;

/**
 * This is the representation for an item, the clone from the reality.
 * 
 * @author $Author: croesch $
 * @version ($Date: 2010/12/19 00:03:13 $)
 */
class Item {

  /** Version number. */
  public static final String VER = "$Revision: 1.2 $"; //$NON-NLS-1$

  private final String number;

  private final String name;

  Item(String itemNr, String itemName) {
    this.number = itemNr;
    this.name = itemName;
  }

  @Override
  public String toString() {
    return Messages.ITEM_STRING.text(this.number, this.name);
  }
}
