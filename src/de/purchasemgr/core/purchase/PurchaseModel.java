package de.purchasemgr.core.purchase;

import java.util.ArrayList;
import java.util.List;

import de.purchasemgr.data.type.Purchase;

/**
 * Contains the data of the purchases of the program
 * 
 * @author croesch
 * @since Date: 15.01.2011 16:10:00
 */
class PurchaseModel {

  /** the list of the purchases */
  private final List<Purchase> purchases = new ArrayList<Purchase>();

  /**
   * adds the given purchase
   * 
   * @param p the purchase to add
   */
  void addPurchase(final Purchase p) {
    this.purchases.add(p);
  }

  /**
   * @return a list of all stored purchases
   */
  List<Purchase> getPurchases() {
    return this.purchases;
  }

  /**
   * Removes the purchase at the given position.
   * 
   * @author croesch
   * @since Date: 06.02.2011 16:33:20
   * @see List#remove(int)
   * @param i the index to remove
   * @throws IndexOutOfBoundsException if the given position is invalid
   */
  void remove(final int i) throws IndexOutOfBoundsException {
    this.purchases.remove(i);
  }

  /**
   * Returns the purchase at the given position
   * 
   * @author croesch
   * @since Date: 06.02.2011 16:34:50
   * @see List#get(int)
   * @param i the index to get
   * @return the {@link Purchase} at the given position
   * @throws IndexOutOfBoundsException if the given position is invalid
   */
  Purchase get(final int i) throws IndexOutOfBoundsException {
    if (i >= 0) {
      return this.purchases.get(i);
    }
    return null;
  }
}
