package de.purchasemgr.data.type;

import de.purchasemgr.i18n.Messages;
import de.purchasemgr.i18n.Strings;

/**
 * This is the representation for an item, the clone from the reality.
 * 
 * @author croesch
 * @since Date: 2010/12/19 00:03:13
 */
public final class Item {

  /** the unique id of this item */
  private final int uniqueId;

  /** the id of the item in the shop */
  private final String number;

  /** the name of the item */
  private final String name;

  /**
   * This is a builder that is able to construct a {@link Item}
   * 
   * @author croesch
   * @since Date: 06.02.2011 15:28:58
   */
  public static class Builder {

    /** the unique id for the new item */
    private static int uniqueId = 0;

    //required fields

    /** the description or name of this item */
    private final String name;

    //optional fields

    /** the number of the item in the shop */
    private String number = Strings.EMPTY_STRING.text();

    /**
     * Constructs a builder to build a {@link Item} with the given name
     * 
     * @author croesch
     * @since Date: 06.02.2011 15:30:43
     * @param n the description for this item
     * @throws IllegalArgumentException if n is {@code null} or empty
     */
    public Builder(final String n) throws IllegalArgumentException {
      if (n == null || n.trim().length() == 0) {
        throw new IllegalArgumentException();
      }
      this.name = n;
    }

    /**
     * Sets the number of the item to construct
     * 
     * @author croesch
     * @since Date: 06.02.2011 15:45:46
     * @param n the number !=null
     * @return the instance of this {@link Builder}
     * @throws IllegalArgumentException if n == null
     */
    public final Builder number(final String n) throws IllegalArgumentException {
      if (n == null) {
        throw new IllegalArgumentException();
      }
      this.number = n;
      return this;
    }

    /**
     * Builds the {@link Item} with the parameters stored in this {@link Builder}, each call returns a new Item
     * 
     * @author croesch
     * @since Date: 06.02.2011 15:49:47
     * @return the created {@link Item}
     */
    @SuppressWarnings("synthetic-access")
    public final Item build() {
      ++uniqueId;
      return new Item(this);
    }
  }

  /**
   * Constructs a new item with the given values.
   * 
   * @author croesch
   * @since Date: 08.02.2011 17:42:11
   * @param builder is used to fetch the parameters
   */
  @SuppressWarnings("synthetic-access")
  private Item(final Builder builder) {
    this.name = builder.name;
    this.number = builder.number;
    this.uniqueId = Builder.uniqueId;
  }

  @Override
  public String toString() {
    return Messages.ITEM_STRING.text(this.number, this.name);
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    // should ever return true, but better save than sorry
    if (this.name != null && this.number != null) {
      result = prime * result + this.name.hashCode();
      result = prime * result + this.number.hashCode();
    }
    result = prime * result + this.uniqueId;
    return result;
  }

  @Override
  public boolean equals(final Object obj) {
    //since this object should be immutable and we have a unique id, each item should be unequal to another item
    if (this == obj) {
      return true;
    }
    return false;
  }
}
