package de.purchasemgr.data.type;

import de.purchasemgr.i18n.Messages;

/**
 * This is a shop-object that represents a real shop.
 * 
 * @author croesch
 * @since Date: 2010/12/19 00:03:13
 */
public class Shop {

  private String name;

  private String postCode;

  private String location;

  /**
   * Constructs a new shop with the given parameters
   * 
   * @author croesch
   * @since Date: 23.01.2011 15:04:09
   * @param name the name of the shop
   * @param postCode the post-code of the shop
   * @param location the location of the shop
   */
  public Shop(String name, String postCode, String location) {
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
   * Sets the name of this shop to the given name
   * 
   * @author croesch
   * @since Date: 23.01.2011 15:03:51
   * @param n the new name
   */
  public void setName(String n) {
    this.name = n;
  }

  /**
   * @return the post code of this shop
   */
  public String getPostCode() {
    return this.postCode;
  }

  /**
   * Sets the post-code of this shop to the given code
   * 
   * @author croesch
   * @since Date: 23.01.2011 15:03:04
   * @param pc the new post-code
   */
  public void setPostCode(String pc) {
    this.postCode = pc;
  }

  /**
   * @return the location of this shop
   */
  public String getLocation() {
    return this.location;
  }

  /**
   * Sets the location of this shop to the given location
   * 
   * @author croesch
   * @since Date: 23.01.2011 15:03:30
   * @param l the new location
   */
  public void setLocation(String l) {
    this.location = l;
  }

  @Override
  public String toString() {
    return Messages.SHOP_STRING.text(this.name, this.postCode, this.location);
  }

}
