package de.purchasemgr.data;

import de.purchasemgr.i18n.Messages;

/**
 * This is a shop-object that represents a real shop.
 * 
 * @author croesch
 * @since Date: 2010/12/19 00:03:13
 */
public class Shop {

  private final String name, postCode, location;

  Shop(String name, String postCode, String location) {
    this.name = name;
    this.postCode = postCode;
    this.location = location;
  }

  /**
   * @return the name of this shop
   */
  public String getName() {
    return this.name;
  }

  /**
   * @return the post code of this shop
   */
  public String getPostCode() {
    return this.postCode;
  }

  /**
   * @return the location of this shop
   */
  public String getLocation() {
    return this.location;
  }

  @Override
  public String toString() {
    return Messages.SHOP_STRING.text(this.name, this.postCode, this.location);
  }

}
