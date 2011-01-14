package de.purchasemgr.data;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import de.purchasemgr.i18n.Messages;

/**
 * This is the representation for a purchase, the clone from the reality.
 * 
 * @author $Author: croesch $
 * @version $Revision: 1.2 $ ($Date: 2010/12/19 00:03:13 $)
 */
class Purchase {

  /** Version number. */
  public static final String VER = "$Revision: 1.2 $"; //$NON-NLS-1$

  private final Date date;

  private final Shop shop;

  List<Item> items = new ArrayList<Item>();

  Purchase(Date date, Shop shop) {
    this.date = date;
    this.shop = shop;
  }

  void addItem(Item item) {
    this.items.add(item);
  }

  Shop getShop() {
    return this.shop;
  }

  Date getDate() {
    return this.date;
  }

  @Override
  public String toString() {
    DateFormat sdf = SimpleDateFormat.getDateInstance(DateFormat.MEDIUM);
    return Messages.PURCHASE_STRING.text(sdf.format(this.date), this.shop.toString());
  }

}
