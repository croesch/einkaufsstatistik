package de.purchasemgr.data.type;

import de.purchasemgr.i18n.Messages;

/**
 * This is a shop-object that represents a real shop.
 * 
 * @author croesch
 * @since Date: 2010/12/19 00:03:13
 */
public class Shop {

  /** the name of the shop */
  private String name;

  /** the post code of the shop */
  private String postCode;

  /** the location of the shop */
  private String location;

  /**
   * Constructs a new shop with the given parameters
   * 
   * @author croesch
   * @since Date: 23.01.2011 15:04:09
   * @param n the name of the shop
   * @param pc the post-code of the shop
   * @param loc the location of the shop
   */
  public Shop(final String n, final String pc, final String loc) {
    setName(n);
    setPostCode(pc);
    setLocation(loc);
  }

  /**
   * Returns a new instance of a shop with the values of the given shop.
   * 
   * @author croesch
   * @since Date: 08.02.2011 18:32:22
   * @param s the {@link Shop} to copy
   */
  public Shop(final Shop s) {
    this(s.getName(), s.getPostCode(), s.getLocation());
  }

  /**
   * @return the name of this shop
   */
  public final String getName() {
    return this.name;
  }

  /**
   * Sets the name of this shop to the given name
   * 
   * @author croesch
   * @since Date: 23.01.2011 15:03:51
   * @param n the new name
   * @throws IllegalArgumentException if the value is {@code null} or empty
   */
  public final void setName(final String n) throws IllegalArgumentException {
    if (n == null || n.trim().length() == 0) {
      throw new IllegalArgumentException(n);
    }
    this.name = n;
  }

  /**
   * @return the post code of this shop
   */
  public final String getPostCode() {
    return this.postCode;
  }

  /**
   * Sets the post-code of this shop to the given code
   * 
   * @author croesch
   * @since Date: 23.01.2011 15:03:04
   * @param pc the new post-code
   * @throws IllegalArgumentException if the value is {@code null} or empty
   */
  public final void setPostCode(final String pc) throws IllegalArgumentException {
    if (pc == null || pc.trim().length() == 0) {
      throw new IllegalArgumentException(pc);
    }
    this.postCode = pc;
  }

  /**
   * @return the location of this shop
   */
  public final String getLocation() {
    return this.location;
  }

  /**
   * Sets the location of this shop to the given location
   * 
   * @author croesch
   * @since Date: 23.01.2011 15:03:30
   * @param l the new location
   * @throws IllegalArgumentException if the value is {@code null} or empty
   */
  public final void setLocation(final String l) throws IllegalArgumentException {
    if (l == null || l.trim().length() == 0) {
      throw new IllegalArgumentException(l);
    }
    this.location = l;
  }

  @Override
  public final String toString() {
    return Messages.SHOP_STRING.text(this.name, this.postCode, this.location);
  }

}
