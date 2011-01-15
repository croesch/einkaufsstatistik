package de.purchasemgr.i18n;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.MissingResourceException;
import java.util.PropertyResourceBundle;

/**
 * Connection to the keystrokes file.
 * 
 * @author croesch
 * @since Date: 2010/12/19 12:56:24
 */
class KeyStrokesBundle extends PropertyResourceBundle {

  private static final String BUNDLE_NAME = String.valueOf(Strings.KEYSTROKES_PROPERTIES_FILE);

  private static KeyStrokesBundle RESOURCE_BUNDLE;

  private KeyStrokesBundle() throws FileNotFoundException, IOException {
    super(new FileInputStream(new File(BUNDLE_NAME)));
    RESOURCE_BUNDLE = this;
  }

  /**
   * Get an instance of the Bundle.
   * 
   * @return bundle, if the file is found or null if there was an IOException
   */
  static KeyStrokesBundle getInstance() {
    if (RESOURCE_BUNDLE != null) {
      return RESOURCE_BUNDLE;
    }
    try {
      return new KeyStrokesBundle();
    } catch (FileNotFoundException e) {
      e.printStackTrace();
      return null;
    } catch (IOException e) {
      e.printStackTrace();
      return null;
    }
  }

  /**
   * Get a stroke for the given key
   * 
   * @param key the key in the properties file
   * @return the stroke for the key or null if the file wasn't found
   */
  static String getStroke(String key) {
    if (RESOURCE_BUNDLE == null) {
      try {
        new KeyStrokesBundle();
      } catch (FileNotFoundException e) {
        e.printStackTrace();
        return null;
      } catch (IOException e) {
        e.printStackTrace();
        return null;
      }
    }
    try {
      return RESOURCE_BUNDLE.getString(key);
    } catch (MissingResourceException e) {
      return '!' + key + '!';
    }
  }
}
