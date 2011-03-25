package de.purchasemgr.core.shop;

import java.awt.event.ActionEvent;
import java.util.List;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.github.croesch.components.CButton;

import net.miginfocom.layout.AC;
import net.miginfocom.layout.CC;
import net.miginfocom.layout.LC;
import net.miginfocom.swing.MigLayout;
import de.purchasemgr.data.type.Shop;
import de.purchasemgr.gui.Window;
import de.purchasemgr.i18n.Messages;
import de.purchasemgr.i18n.Strings;

/**
 * The view for the shops, provides windows to manage shops and different components to visualise the current amount of
 * shops
 * 
 * @author croesch
 * @since Date: 16.01.2011 12:47:38
 */
class ShopView {

  /** the controller of this view */
  private final ShopController controller;

  /** the text field for editing a shop that contains the name of the shop */
  private final JTextField shopName = new JTextField();

  /** the text field for editing a shop that contains the post code of the shop */
  private final JTextField shopPostCode = new JTextField();

  /** the text field for editing a shop that contains the location of the shop */
  private final JTextField shopLocation = new JTextField();

  /** the text field for creating a new shop that contains the name of the shop */
  private final JTextField newShopNameField = new JTextField();

  /** the text field for creating a new shop that contains the post code of the shop */
  private final JTextField newShopPostCodeField = new JTextField();

  /** the text field for creating a new shop that contains the location of the shop */
  private final JTextField newShopLocationField = new JTextField();

  /** the label to display the number of the shop to create */
  private final JLabel newShopNumber = new JLabel();

  /** the label to display the number of the shop that is being edited */
  private final JLabel editShopNumber = new JLabel();

  /** the frame that is displayed to edit shops */
  private final Window editShopFrame;

  /** the frame that is displayed to create a new shop */
  private final Window newShopFrame;

  /** the box to select a shop from all stored shops */
  private final JComboBox shopBox = new JComboBox();

  /** the action to edit the following shop */
  private ShopAction editNext;

  /** the action to edit the previous shop */
  private ShopAction editPrevious;

  /**
   * Constructs the view for the shops.
   * 
   * @author croesch
   * @since Date: 08.02.2011 17:04:30
   * @param cont the controller of this view
   */
  ShopView(final ShopController cont) {
    this.controller = cont;
    this.editShopFrame = createEditShopFrame();
    this.newShopFrame = createNewShopFrame();
  }

  /**
   * Constructs the frame to create a new shop
   * 
   * @author croesch
   * @since Date: 08.02.2011 17:06:18
   * @return the created frame
   */
  private Window createNewShopFrame() {
    // some constants for better readability
    final long g = 100L;

    final int rows = 6;
    final int numberRow = 0;
    final int nameRow = 2;
    final int postCodeRow = 3;
    final int locationRow = 4;
    final int spaceRow = 5;
    final int buttonRow = 6;

    final int columns = 3;
    final int labelCol = 0;
    final int fieldCol = 2;

    final int width = 400;
    final int height = 300;

    //creation of the frame

    JPanel pan = new JPanel();
    JPanel buttonPanel = new JPanel();
    pan.setLayout(new MigLayout(new LC(), new AC().grow(g, fieldCol).fill(fieldCol), new AC().count(rows)
      .grow(g, spaceRow)));
    buttonPanel.setLayout(new MigLayout());

    final JLabel newShopLabel = new JLabel(Messages.SHOP_NEW_INDEX.text());
    final JLabel newShopNameLbl = new JLabel(Messages.SHOP_NAME.text());
    final JLabel newShopPostCodeLbl = new JLabel(Messages.SHOP_POSTCODE.text());
    final JLabel newShopLocationLbl = new JLabel(Messages.SHOP_LOCATION.text());

    CButton createShopBtn = new CButton(new ShopAction(ShopAction.NEW_SAVE));
    CButton stopCreatingShopBtn = new CButton(new ShopAction(ShopAction.NEW_CANCEL));

    buttonPanel.add(createShopBtn, new CC().cell(0, 0).sizeGroup(Strings.EMPTY_STRING.text()));
    buttonPanel.add(stopCreatingShopBtn, new CC().cell(1, 0).sizeGroup(Strings.EMPTY_STRING.text()));

    pan.add(newShopLabel, new CC().cell(labelCol, numberRow));
    pan.add(this.newShopNumber, new CC().cell(fieldCol, numberRow));
    pan.add(newShopNameLbl, new CC().cell(labelCol, nameRow));
    pan.add(this.newShopNameField, new CC().cell(fieldCol, nameRow));
    pan.add(newShopPostCodeLbl, new CC().cell(labelCol, postCodeRow));
    pan.add(this.newShopPostCodeField, new CC().cell(fieldCol, postCodeRow));
    pan.add(newShopLocationLbl, new CC().cell(labelCol, locationRow));
    pan.add(this.newShopLocationField, new CC().cell(fieldCol, locationRow));
    pan.add(buttonPanel, new CC().cell(labelCol, buttonRow, columns, 1).alignX(Strings.RIGHT.text()));

    Window.Builder b = new Window.Builder(width, height);
    b = b.title(Messages.SHOP_NEW.text()).component(pan);
    return b.build();
  }

  /**
   * Returns the frame for creating shops.
   * 
   * @author croesch
   * @since Date: 08.02.2011 17:17:41
   * @return the frame
   */
  Window getNewShopFrame() {
    return this.newShopFrame;
  }

  /**
   * Returns the frame for editing shops.
   * 
   * @author croesch
   * @since Date: 08.02.2011 17:18:06
   * @return the frame
   */
  Window getEditShopFrame() {
    return this.editShopFrame;
  }

  /**
   * Constructs the frame to edit a shop
   * 
   * @author croesch
   * @since Date: 08.02.2011 17:06:18
   * @return the created frame
   */
  private Window createEditShopFrame() {
    // some constants for better readability
    final long g = 100L;

    final int rows = 7;
    final int numberRow = 0;
    final int nameRow = 2;
    final int postCodeRow = 3;
    final int locationRow = 4;
    final int navRow = 5;
    final int spaceRow = 6;
    final int buttonRow = 7;

    final int columns = 3;
    final int labelCol = 0;
    final int fieldCol = 2;

    final int width = 400;
    final int height = 300;

    //creation of the frame

    JPanel pan = new JPanel();
    JPanel navPanel = new JPanel();
    JPanel buttonPanel = new JPanel();
    pan.setLayout(new MigLayout(new LC(), new AC().grow(g, fieldCol).fill(fieldCol), new AC().count(rows)
      .grow(g, spaceRow)));
    navPanel.setLayout(new MigLayout());
    buttonPanel.setLayout(new MigLayout());

    this.editNext = new ShopAction(ShopAction.EDIT_NEXT);
    this.editPrevious = new ShopAction(ShopAction.EDIT_PREVIOUS);

    final JLabel shopIndexDescLbl = new JLabel(Messages.SHOP_EDIT_INDEX.text());
    final JLabel shopNameLbl = new JLabel(Messages.SHOP_NAME.text());
    final JLabel shopPostCodeLbl = new JLabel(Messages.SHOP_POSTCODE.text());
    final JLabel shopLocationLbl = new JLabel(Messages.SHOP_LOCATION.text());

    CButton prevShopBtn = new CButton(this.editPrevious);
    CButton nextShopBtn = new CButton(this.editNext);

    CButton applyShopBtn = new CButton(new ShopAction(ShopAction.EDIT_SAVE));
    CButton cancelShopBtn = new CButton(new ShopAction(ShopAction.EDIT_CANCEL));

    navPanel.add(prevShopBtn, new CC().cell(0, 0).sizeGroup(Strings.EMPTY_STRING.text()));
    navPanel.add(nextShopBtn, new CC().cell(1, 0).sizeGroup(Strings.EMPTY_STRING.text()));

    buttonPanel.add(applyShopBtn, new CC().cell(0, 0));
    buttonPanel.add(cancelShopBtn, new CC().cell(1, 0));

    pan.add(shopIndexDescLbl, new CC().cell(labelCol, numberRow));
    pan.add(this.editShopNumber, new CC().cell(fieldCol, numberRow));
    pan.add(shopNameLbl, new CC().cell(labelCol, nameRow));
    pan.add(this.shopName, new CC().cell(fieldCol, nameRow));
    pan.add(shopPostCodeLbl, new CC().cell(labelCol, postCodeRow));
    pan.add(this.shopPostCode, new CC().cell(fieldCol, postCodeRow));
    pan.add(shopLocationLbl, new CC().cell(labelCol, locationRow));
    pan.add(this.shopLocation, new CC().cell(fieldCol, locationRow));
    pan.add(navPanel, new CC().cell(labelCol, navRow, columns, 1));
    pan.add(buttonPanel, new CC().cell(labelCol, buttonRow, columns, 1).alignX(Strings.RIGHT.text()));

    Window.Builder b = new Window.Builder(width, height);
    b = b.title(Messages.SHOP_EDIT.text()).component(pan);
    return b.build();
  }

  /**
   * Shows the frame to edit the Shop at the given position.
   * 
   * @author croesch
   * @since Date: 08.02.2011 17:25:08
   * @param index the position of the Shop > 0, to visualise
   */
  void editShop(final int index) {
    this.editShopNumber.setText(Messages.SHOP_EDIT_INDEX_VALUE.text(String.valueOf(index), String
      .valueOf(this.controller.getShopCount())));

    this.editNext.setEnabled(index < this.controller.getShopCount());
    this.editPrevious.setEnabled(index > 1);

    Shop shop = this.controller.getShopAt(index - 1);

    this.shopName.setText(shop.getName());
    this.shopPostCode.setText(shop.getPostCode());
    this.shopLocation.setText(shop.getLocation());

    this.editShopFrame.repaint();
    this.editShopFrame.setVisible(true);
  }

  /**
   * Shows the frame to create a new {@link Shop}
   * 
   * @author croesch
   * @since Date: 08.02.2011 17:31:09
   */
  void newShop() {
    this.newShopNumber
      .setText(Messages.SHOP_NEW_INDEX_VALUE.text(String.valueOf((this.controller.getShopCount() + 1))));

    this.newShopNameField.setText(Strings.EMPTY_STRING.text());
    this.newShopPostCodeField.setText(Strings.EMPTY_STRING.text());
    this.newShopLocationField.setText(Strings.EMPTY_STRING.text());

    this.newShopFrame.repaint();
    this.newShopFrame.setVisible(true);
  }

  /**
   * Performs to add the shop defined in the newShopFrame to the model and hides the frame for creating a new shop
   * 
   * @author croesch
   * @since Date: 08.02.2011 17:31:42
   */
  void addShop() {
    String name = this.newShopNameField.getText();
    String postCode = this.newShopPostCodeField.getText();
    String location = this.newShopLocationField.getText();
    this.controller.createShop(name, postCode, location);
    this.newShopFrame.setVisible(false);
  }

  /**
   * Stores the data of the current edited shop.
   * 
   * @author croesch
   * @since Date: 08.02.2011 17:32:26
   */
  void saveShop() {
    String name = this.shopName.getText();
    String postCode = this.shopPostCode.getText();
    String location = this.shopLocation.getText();
    this.controller.save(name, postCode, location);
  }

  /**
   * Performs to change the index of the edited shop.
   * 
   * @author croesch
   * @since Date: 08.02.2011 17:33:10
   * @param decrement {@code true}, if the index should be decremented, {@code false}, if the index should be
   *        incremented
   */
  void changeEditingShop(final boolean decrement) {
    saveShop();

    if (decrement) {
      this.controller.decrementEditingShop();
    } else {
      this.controller.incrementEditingShop();
    }
  }

  /**
   * Sets the given data to the box to visualise the given list of shops
   * 
   * @author croesch
   * @since Date: 08.02.2011 17:38:41
   * @param data the data (list of shops) to visualise
   */
  void updateBox(final List<Shop> data) {
    this.shopBox.removeAllItems();
    this.shopBox.setModel(new DefaultComboBoxModel(data.toArray()));
  }

  /**
   * Returns the box that visualises a list of the given shops.
   * 
   * @author croesch
   * @since Date: 08.02.2011 17:39:38
   * @param shops the list of shops
   * @return the Component that visualises the data
   */
  JComboBox getBox(final List<Shop> shops) {
    updateBox(shops);
    return this.shopBox;
  }

  /**
   * Returns the selected index of the box that visualises the shops.
   * 
   * @author croesch
   * @since Date: 08.02.2011 17:40:21
   * @return the selected index
   */
  int getSelectedIndex() {
    return this.shopBox.getSelectedIndex();
  }

  /**
   * Action that is used in this view, provides different actions
   * 
   * @author croesch
   * @since Date: 08.02.2011 17:34:41
   */
  private class ShopAction extends AbstractAction {

    /** generated version UID */
    private static final long serialVersionUID = 1L;

    /** the constant for the action to cancel the creation of a new shop */
    static final int NEW_CANCEL = 1;

    /** the constant for the action to submit the creation of a new shop */
    static final int NEW_SAVE = 2;

    /** the constant for the action to edit the next shop */
    static final int EDIT_NEXT = 3;

    /** the constant for the action to edit the previous shop */
    static final int EDIT_PREVIOUS = 4;

    /** the constant for the action to cancel the editing the shop */
    static final int EDIT_CANCEL = 5;

    /** the constant for the action to submit the changes of editing a shop */
    static final int EDIT_SAVE = 6;

    /** the id of this action */
    private final int id;

    /**
     * Constructs a new action with the behaviour defined by the ID
     * 
     * @author croesch
     * @since Date: 08.02.2011 17:37:14
     * @param identificationNumber the id of the action
     */
    ShopAction(final int identificationNumber) {
      this.id = identificationNumber;
      String name;
      switch (identificationNumber) {
        case NEW_CANCEL:
          name = Messages.SHOP_NEW_CANCEL.text();
          break;
        case NEW_SAVE:
          name = Messages.SHOP_NEW_SAVE.text();
          break;
        case EDIT_NEXT:
          name = Messages.SHOP_EDIT_NEXT.text();
          break;
        case EDIT_PREVIOUS:
          name = Messages.SHOP_EDIT_PREV.text();
          break;
        case EDIT_CANCEL:
          name = Messages.SHOP_EDIT_CANC.text();
          break;
        case EDIT_SAVE:
          name = Messages.SHOP_EDIT_SAVE.text();
          break;
        default:
          throw new IllegalArgumentException(Messages.EXC_ILLARG.text(String.valueOf(identificationNumber)));
      }
      putValue(Action.NAME, name);
    }

    @Override
    public void actionPerformed(final ActionEvent e) {
      if (this.id == NEW_CANCEL) {
        ShopView.this.getNewShopFrame().setVisible(false);
      } else if (this.id == NEW_SAVE) {
        ShopView.this.addShop();
      } else if (this.id == EDIT_NEXT) {
        ShopView.this.changeEditingShop(false);
      } else if (this.id == EDIT_PREVIOUS) {
        ShopView.this.changeEditingShop(true);
      } else if (this.id == EDIT_CANCEL) {
        ShopView.this.getEditShopFrame().setVisible(false);
      } else if (this.id == EDIT_SAVE) {
        ShopView.this.saveShop();
        ShopView.this.getEditShopFrame().setVisible(false);
      } else {
        throw new IllegalArgumentException(Messages.EXC_ILLARG.text(String.valueOf(this.id)));
      }
    }
  }
}
