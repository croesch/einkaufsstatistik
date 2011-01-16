package de.purchasemgr.data.type;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import de.purchasemgr.i18n.Messages;

/**
 * This is the representation for a purchase, the clone from the reality.
 * 
 * @author croesch
 * @since Date: 2010/12/19 00:03:13
 */
public class Purchase {

  private final Date date;

  private final Shop shop;

  List<Item> items = new ArrayList<Item>();

  public Purchase(Date date, Shop shop) {
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
    DateFormat sdf = DateFormat.getDateInstance(DateFormat.MEDIUM);
    return Messages.PURCHASE_STRING.text(sdf.format(this.date), this.shop.toString());
  }

}