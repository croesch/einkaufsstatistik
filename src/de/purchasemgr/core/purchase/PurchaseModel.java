package de.purchasemgr.core.purchase;

import java.util.ArrayList;
import java.util.List;

import de.purchasemgr.data.type.Purchase;
import de.purchasemgr.i18n.Messages;
import de.purchasemgr.logging.LogManager;

/**
 * Contains the data of the purchases of the program
 * 
 * @author croesch
 * @since Date: 15.01.2011 16:10:00
 */
class PurchaseModel {

  private final List<Purchase> purchases = new ArrayList<Purchase>();

  /**
   * adds the given purchase
   * 
   * @param p the purchase to add
   */
  void addPurchase(Purchase p) {
    this.purchases.add(p);
  }

  /**
   * @return a list of all stored purchases
   */
  List<Purchase> getPurchases() {
    return this.purchases;
  }

  void remove(int i) {
    if (i >= 0) {
      this.purchases.remove(i);
    } else {
      LogManager.log(Messages.LOG_NOPURCHASETOEDIT.text(), true);
    }
  }

  Purchase get(int i) {
    if (i >= 0) {
      return this.purchases.get(i);
    }
    LogManager.log(Messages.LOG_NOPURCHASETOEDIT.text(), true);
    return null;
  }
}
