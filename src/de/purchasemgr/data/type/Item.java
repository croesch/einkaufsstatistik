package de.purchasemgr.data.type;

import de.purchasemgr.i18n.Messages;

/**
 * This is the representation for an item, the clone from the reality.
 * 
 * @author croesch
 * @since Date: 2010/12/19 00:03:13
 */
public class Item {

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
