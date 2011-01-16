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

  private final List<Shop> shops = new ArrayList<Shop>();

  /**
   * adds the given shop to the list
   * 
   * @param p the {@link Shop} to add
   */
  void addShop(Shop s) {
    this.shops.add(s);
  }

  /**
   * @return a list of all stored shops
   */
  List<Shop> getShops() {
    return this.shops;
  }

  void remove(int i) {
    this.shops.remove(i);
  }

  Shop get(int i) {
    if (i >= 0) {
      return this.shops.get(i);
    }
    return null;
  }

  int getShopCount() {
    return this.shops.size();
  }

  void set(int index, Shop shop) {
    this.shops.set(index, shop);
  }
}