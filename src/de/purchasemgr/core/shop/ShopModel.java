package de.purchasemgr.core.shop;

import java.util.ArrayList;
import java.util.List;

import de.purchasemgr.data.type.Shop;

/**
 * Contains the data of the shops of the program
 * 
 * @author croesch
 * @since Date: 15.01.2011 16:10:00
 */
class ShopModel {

  /** the list that contains the stored shops */
  private final List<Shop> shops = new ArrayList<Shop>();

  /**
   * adds the given shop to the list
   * 
   * @param s the {@link Shop} to add
   */
  void addShop(final Shop s) {
    this.shops.add(s);
  }

  /**
   * @return a list of all stored shops
   */
  List<Shop> getShops() {
    return this.shops;
  }

  /**
   * Removes the shop at the given position
   * 
   * @author croesch
   * @since Date: 06.02.2011 20:02:33
   * @see List#remove(int)
   * @param i the index of the shop to remove
   * @throws ArrayIndexOutOfBoundsException if the position is invalid
   */
  void remove(final int i) throws ArrayIndexOutOfBoundsException {
    this.shops.remove(i);
  }

  /**
   * Returns the shop at the given position
   * 
   * @author croesch
   * @since Date: 06.02.2011 20:03:12
   * @see List#get(int)
   * @param i the index of the shop to fetch
   * @return the {@link Shop} at the given position
   * @throws ArrayIndexOutOfBoundsException if the position is invalid
   */
  Shop get(final int i) throws ArrayIndexOutOfBoundsException {
    if (i >= 0) {
      return this.shops.get(i);
    }
    throw new ArrayIndexOutOfBoundsException(i);
  }

  /**
   * Returns the number of stored {@link Shop}s
   * 
   * @author croesch
   * @since Date: 06.02.2011 20:03:54
   * @see List#size()
   * @return the size of the list of shops
   */
  int getShopCount() {
    return this.shops.size();
  }

  /**
   * Sets the given {@link Shop} at the given position
   * 
   * @author croesch
   * @since Date: 06.02.2011 20:06:18
   * @see List#set(int, Object)
   * @param index the index where to store the shop
   * @param shop the new shop for the given position
   * @throws ArrayIndexOutOfBoundsException if the given position is invalid
   */
  void set(final int index, final Shop shop)
                                            throws ArrayIndexOutOfBoundsException {
    this.shops.set(index, shop);
  }
}
