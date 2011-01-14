package de.purchasemgr.i18n;

import java.util.Enumeration;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

/**
 * Connection to the messages file. Doesn't throw an exception if a key wasn't found.
 * 
 * @author $Author: croesch $
 * @version $Revision: 1.3 $ ($Date: 2010/12/19 14:41:45 $)
 */
class MessagesBundle extends ResourceBundle {

  private static ResourceBundle RESOURCE_BUNDLE;

  private MessagesBundle() {
    RESOURCE_BUNDLE = super.getBundle(Strings.MESSAGES_PROPERTIES_FILE.text());
  }

  /**
   * Get an instance of the Bundle.
   * 
   * @return bundle the resource bundle for the messages properties
   */
  static ResourceBundle getInstance() {
    if (RESOURCE_BUNDLE != null) {
      return RESOURCE_BUNDLE;
    }
    return new MessagesBundle();
  }

  /**
   * Get a message for the given key
   * 
   * @param key the key in the properties file
   * @return the message for the key or the key if the key wasn't found
   */
  static String getMessage(String key) {
    if (RESOURCE_BUNDLE == null) {
      new MessagesBundle();
    }
    try {
      return RESOURCE_BUNDLE.getString(key);
    } catch (MissingResourceException e) {
      return '!' + key + '!';
    }
  }

  /**
   * note that this function doesn't work yet
   */
  @Override
  public Enumeration<String> getKeys() {
    return null; // not yet supported
  }

  @Override
  protected Object handleGetObject(String key) {
    if (RESOURCE_BUNDLE == null) {
      new MessagesBundle();
    }
    try {
      return RESOURCE_BUNDLE.getString(key);
    } catch (MissingResourceException e) {
      return null;
    }
  }
}
