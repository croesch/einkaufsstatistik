package de.purchasemgr.lib.arch;

/**
 * This interface represents a view and its interface to the whole world.
 * 
 * @author croesch
 * @since Date: May 13, 2011 9:34:34 AM
 * @see Model
 */
public interface View {

  /**
   * This method informs the view to update herself and fetch the data. Call this method if data has changed and you
   * want the view to be updated.
   * 
   * @author croesch
   * @since Date: May 13, 2011 9:46:36 AM
   */
  void update();

}
