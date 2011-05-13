package de.purchasemgr.lib.arch;

/**
 * This interface represents a model and its interface to the whole world.
 * 
 * @author croesch
 * @since Date: May 13, 2011 9:34:34 AM
 * @see View
 */
public interface Model {

  /**
   * This method registers the given {@link View} to this model. From now on the view will be informed about changes of
   * the data, to update itself.
   * 
   * @author croesch
   * @since Date: May 13, 2011 9:38:13 AM
   * @param v the {@link View} to register
   * @return <code>true</code>, if the registration was successful
   * @see #unregister(View)
   * @see View#update()
   */
  boolean register(View v);

  /**
   * This method unregisters the given {@link View} from this model. From now on the view won't be informed about any
   * changes of the data.
   * 
   * @author croesch
   * @since Date: May 13, 2011 9:38:13 AM
   * @param v the {@link View} to unregister
   * @return <code>true</code>, if the removal was successful
   * @see #register(View)
   */
  boolean unregister(View v);

}
