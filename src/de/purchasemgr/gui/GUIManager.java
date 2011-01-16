package de.purchasemgr.gui;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import de.crhcomponents.components.CButton;
import de.crhcomponents.components.CMenu;
import de.crhcomponents.components.CMenuItem;
import de.purchasemgr.ActionPool;
import de.purchasemgr.Main;
import de.purchasemgr.MainAction;
import de.purchasemgr.data.DataModel;
import de.purchasemgr.data.type.Shop;
import de.purchasemgr.i18n.KeyStrokes;
import de.purchasemgr.i18n.Messages;
import de.purchasemgr.i18n.Strings;
import de.purchasemgr.logging.LogManager;

/**
 * The manager for everything that has to do with GUI TODO change this and remove this central class
 * 
 * @author croesch
 * @since $Revision: 1.11 $ Date: 2010/12/19 12:56:24
 */
public class GUIManager {

  private final DataModel model;

  private static final int HSPACE = 20;

  private static final int VSPACE = 13;

  private final JComponent contentPanel = new JPanel();

  private final int width = 400, height = 400;

  private JScrollPane listScroller;

  private JButton newPurch, deletePurch, editPurch;

  private final JPanel buttons = new JPanel();

  private final JPanel newShopPanel = new JPanel(new GridLayout(5, 2, HSPACE, VSPACE));

  //		private DataModel dataModel = new DataModel(this);
  static JLabel shopIndexLabel = new JLabel();

  private final JLabel shopIndexDescLbl = new JLabel(Messages.SHOP_EDIT_INDEX.text());

  private JButton nextShopBtn, prevShopBtn, applyShopBtn, cancelShopBtn;

  private final JPanel shopPanel = new JPanel(new GridLayout(6, 2, HSPACE, VSPACE));

  private final JLabel newShopLabel = new JLabel(Messages.SHOP_NEW_INDEX.text()), newShopNumber = new JLabel();

  private JButton createShopBtn, stopCreatingShopBtn;

  private final JLabel newShopNameLbl = new JLabel(Messages.SHOP_NAME.text());

  private final JLabel newShopPostCodeLbl = new JLabel(Messages.SHOP_POSTCODE.text());

  private final JLabel newShopLocationLbl = new JLabel(Messages.SHOP_LOCATION.text());

  private final JTextField newShopNameField = new JTextField(), newShopPostCodeField = new JTextField();

  private final JTextField newShopLocationField = new JTextField();

  private final JLabel shopNameLbl = new JLabel(Messages.SHOP_NAME.text());

  private final JLabel shopPostCodeLbl = new JLabel(Messages.SHOP_POSTCODE.text());

  private final JLabel shopLocationLbl = new JLabel(Messages.SHOP_LOCATION.text());

  private final JTextField shopName = new JTextField(), shopPostCode = new JTextField(),
          shopLocation = new JTextField();

  public int nr;

  int max;

  static Window ABOUT_FRAME;

  /** frame to edit the shops */
  public Window editShop;

  /** frame to add a new shop */
  public Window newShop;

  Window mainWindow;

  /**
   * @return the text of the shop-name field in the new shop frame
   */
  public String getNewShopName() {
    return this.newShopNameField.getText();
  }

  /**
   * @return the text of the shop-postcode field in the new shop frame
   */
  public String getNewShopPostCode() {
    return this.newShopPostCodeField.getText();
  }

  /**
   * @return the text of the shop-location field in the new shop frame
   */
  public String getNewShopLocation() {
    return this.newShopLocationField.getText();
  }

  /**
   * @return the text of the shop-name field
   */
  public String getShopName() {
    return this.shopName.getText();
  }

  /**
   * @return the text of the shop-postcode field
   */
  public String getShopPostCode() {
    return this.shopPostCode.getText();
  }

  /**
   * @return the text of the shop-location field
   */
  public String getShopLocation() {
    return this.shopLocation.getText();
  }

  /**
   * show the about frame
   */
  public static void about() {
    final String descrAbout = Messages.PROGRAM_ABOUT_TEXT.text(Main.VERSION);
    final String titleAbout = Messages.PROGRAM_ABOUT_TITLE.text(Main.NAME);
    JLabel lab = new JLabel(descrAbout);
    if (ABOUT_FRAME == null) {
      ABOUT_FRAME = new Window(lab, 200, 100, null, titleAbout);
    }
    ABOUT_FRAME.setVisible(true);
  }

  /**
   * handles different ways of editing shops
   * 
   * @param mode the way to edit: <br>
   *        0: all shops will be edited <br>
   *        1: a new shop will be created
   */
  public void editShops(int mode) {
    this.max = this.model.getShops().toArray().length;
    switch (mode) {
      case 0:
        this.nr = this.max;
        if (this.nr > 0) {
          editShopsRefresh(--this.nr);
          this.editShop.setVisible(true);
        } else {
          LogManager.log(Messages.LOG_NOSHOPSTOEDIT.text());
        }
        break;
      case 1:
        newShop();
        break;
      default:
        throw new IllegalArgumentException(Messages.EXC_ILLARG.text(String.valueOf(mode)));
    }
  }

  private void newShop() {
    //#################### ==> new shop <== ####################
    this.newShopNumber.setText(Messages.SHOP_NEW_INDEX_VALUE.text(String.valueOf((this.max + 1))));

    this.newShopNameField.setText(Strings.EMPTY_STRING.text());
    this.newShopPostCodeField.setText(Strings.EMPTY_STRING.text());
    this.newShopLocationField.setText(Strings.EMPTY_STRING.text());

    this.newShop.repaint();
    this.newShop.setVisible(true);

  }

  /**
   * updates the components of the edit shops frame
   * 
   * @param ind the index of the shop to edit
   */
  public void editShopsRefresh(int ind) {
    //#################### ==> edit shop <== ####################
    shopIndexLabel.setText(Messages.SHOP_EDIT_INDEX_VALUE.text(String.valueOf((ind + 1)), String.valueOf(this.max)));
    if (ind >= this.max - 1) {
      ActionPool.EDIT_SHOPS_NXT.getAction().setEnabled(false);
    } else {
      ActionPool.EDIT_SHOPS_NXT.getAction().setEnabled(true);
    }
    if (ind <= 0) {
      ActionPool.EDIT_SHOPS_PRE.getAction().setEnabled(false);
    } else {
      ActionPool.EDIT_SHOPS_PRE.getAction().setEnabled(true);
    }
    Shop index = this.model.getShops().get(ind);

    this.shopName.setText(index.getName());
    this.shopPostCode.setText(index.getPostCode());
    this.shopLocation.setText(index.getLocation());

    this.editShop.repaint();
    this.editShop.setVisible(true);

  }

  private JMenuBar createMainMenuBar() {

    JMenuBar mb = new JMenuBar();
    JMenu menu, edit, stat, help, statPurchase, statExpenses;
    JMenuItem newFile, save, open, exit, items, shops, general;
    JMenuItem purchaseShop, purchaseWDay, purchaseMonth, purchaseYear, purchaseItems, expensesShop;
    JMenuItem expensesWDay, expensesMonth, expensesYear, expensesItems, options, about, version;
    @SuppressWarnings("hiding")
    JMenuItem newShop;

    menu = new CMenu(Messages.MB_MENU.text());
    edit = new CMenu(Messages.MB_EDIT.text());
    stat = new CMenu(Messages.MB_STAT.text());
    help = new CMenu(Messages.MB_HELP.text());
    statPurchase = new CMenu(Messages.MB_STAT_PURCHASE.text());
    statExpenses = new CMenu(Messages.MB_STAT_EXPENSES.text());

    // Menu - Items
    newFile = new CMenuItem(ActionPool.FILE_NEW.getAction());
    save = new CMenuItem(ActionPool.FILE_SAVE.getAction());
    open = new CMenuItem(ActionPool.FILE_OPEN.getAction());
    exit = new CMenuItem(ActionPool.EXIT.getAction());

    // Menu - Items - Keys
    newFile.setAccelerator(KeyStrokes.FILE_NEW.stroke());
    save.setAccelerator(KeyStrokes.FILE_SAVE.stroke());
    open.setAccelerator(KeyStrokes.FILE_OPEN.stroke());
    exit.setAccelerator(KeyStrokes.PROGRAM_EXIT.stroke());

    // Menu - add Items
    menu.add(newFile);
    menu.add(open);
    menu.addSeparator();
    menu.add(save);
    menu.addSeparator();
    menu.add(exit);

    //edit - Items
    items = new CMenuItem(ActionPool.EDIT_ITEMS.getAction());
    shops = new CMenuItem(ActionPool.EDIT_SHOPS.getAction());
    newShop = new CMenuItem(ActionPool.NEW_SHOP.getAction());

    //edit - items - keys
    items.setAccelerator(KeyStrokes.EDIT_ITEMS.stroke());
    newShop.setAccelerator(KeyStrokes.NEW_SHOP.stroke());
    shops.setAccelerator(KeyStrokes.EDIT_SHOPS.stroke());

    //edit - add items
    edit.add(items);
    edit.add(newShop);
    edit.add(shops);

    //statistic - expenses - items
    expensesItems = new CMenuItem(ActionPool.STAT_EXPENSES_ITEM.getAction());
    expensesShop = new CMenuItem(ActionPool.STAT_EXPENSES_SHOP.getAction());
    expensesWDay = new CMenuItem(ActionPool.STAT_EXPENSES_WDAY.getAction());
    expensesMonth = new CMenuItem(ActionPool.STAT_EXPENSES_MONT.getAction());
    expensesYear = new CMenuItem(ActionPool.STAT_EXPENSES_YEAR.getAction());

    //statistic - expenses - keys
    expensesItems.setAccelerator(KeyStrokes.STAT_EXPENSES_ITEM.stroke());
    expensesShop.setAccelerator(KeyStrokes.STAT_EXPENSES_SHOP.stroke());
    expensesWDay.setAccelerator(KeyStrokes.STAT_EXPENSES_WDAY.stroke());
    expensesMonth.setAccelerator(KeyStrokes.STAT_EXPENSES_MONT.stroke());
    expensesYear.setAccelerator(KeyStrokes.STAT_EXPENSES_YEAR.stroke());

    //statistic - expenses - add items
    statExpenses.add(expensesShop);
    statExpenses.add(expensesWDay);
    statExpenses.add(expensesMonth);
    statExpenses.add(expensesYear);
    statExpenses.add(expensesItems);

    //statistic - purchases - items
    purchaseItems = new CMenuItem(ActionPool.STAT_PURCHASE_ITEM.getAction());
    purchaseShop = new CMenuItem(ActionPool.STAT_PURCHASE_SHOP.getAction());
    purchaseWDay = new CMenuItem(ActionPool.STAT_PURCHASE_WDAY.getAction());
    purchaseMonth = new CMenuItem(ActionPool.STAT_PURCHASE_MONT.getAction());
    purchaseYear = new CMenuItem(ActionPool.STAT_PURCHASE_YEAR.getAction());

    //statistic - purchases - keys
    purchaseItems.setAccelerator(KeyStrokes.STAT_PURCHASE_ITEM.stroke());
    purchaseShop.setAccelerator(KeyStrokes.STAT_PURCHASE_SHOP.stroke());
    purchaseWDay.setAccelerator(KeyStrokes.STAT_PURCHASE_WDAY.stroke());
    purchaseMonth.setAccelerator(KeyStrokes.STAT_PURCHASE_MONT.stroke());
    purchaseYear.setAccelerator(KeyStrokes.STAT_PURCHASE_YEAR.stroke());

    //statistic - purchases - add items
    statPurchase.add(purchaseShop);
    statPurchase.add(purchaseWDay);
    statPurchase.add(purchaseMonth);
    statPurchase.add(purchaseYear);
    statPurchase.add(purchaseItems);

    //statistic - items
    general = new CMenuItem(ActionPool.STAT_GENERAL.getAction());

    //statistic - keys
    general.setAccelerator(KeyStrokes.STAT_GENERAL.stroke());

    //statistic - add items
    stat.add(general);
    stat.addSeparator();
    stat.add(statPurchase);
    stat.add(statExpenses);

    //help - items
    options = new CMenuItem(ActionPool.OPTIONS.getAction());
    version = new CMenuItem(ActionPool.VERSION_INFO.getAction());
    about = new CMenuItem(ActionPool.ABOUT.getAction());

    //help - keys
    options.setAccelerator(KeyStrokes.HELP_OPTIONS.stroke());
    version.setAccelerator(KeyStrokes.HELP_VERSION.stroke());
    about.setAccelerator(KeyStrokes.HELP_ABOUT.stroke());

    //help - add items
    help.add(options);
    help.addSeparator();
    help.add(version);
    help.addSeparator();
    help.add(about);

    mb.add(menu);
    mb.add(edit);
    mb.add(stat);
    mb.add(help);

    return mb;
  }

  private void initialize() {

    //#################### ==> edit shop <== ####################
    this.cancelShopBtn = new CButton(ActionPool.EDIT_SHOPS_CAN.getAction());
    this.prevShopBtn = new CButton(ActionPool.EDIT_SHOPS_PRE.getAction());
    this.nextShopBtn = new CButton(ActionPool.EDIT_SHOPS_NXT.getAction());
    this.applyShopBtn = new CButton(ActionPool.EDIT_SHOPS_SAV.getAction());

    this.shopPanel.add(this.shopIndexDescLbl);
    this.shopPanel.add(shopIndexLabel);
    this.shopPanel.add(this.shopNameLbl);
    this.shopPanel.add(this.shopName);
    this.shopPanel.add(this.shopPostCodeLbl);
    this.shopPanel.add(this.shopPostCode);
    this.shopPanel.add(this.shopLocationLbl);
    this.shopPanel.add(this.shopLocation);
    this.shopPanel.add(this.prevShopBtn);
    this.shopPanel.add(this.nextShopBtn);
    this.shopPanel.add(this.applyShopBtn);
    this.shopPanel.add(this.cancelShopBtn);

    this.editShop = new Window(this.shopPanel, 400, 300, null, Messages.SHOP_EDIT.text());

    //#################### ==> create shop <== ####################
    this.createShopBtn = new CButton(ActionPool.NEW_SHOP_OK.getAction());
    this.stopCreatingShopBtn = new CButton(ActionPool.NEW_SHOP_CANCEL.getAction());

    this.newShopPanel.add(this.newShopLabel);
    this.newShopPanel.add(this.newShopNumber);
    this.newShopPanel.add(this.newShopNameLbl);
    this.newShopPanel.add(this.newShopNameField);
    this.newShopPanel.add(this.newShopPostCodeLbl);
    this.newShopPanel.add(this.newShopPostCodeField);
    this.newShopPanel.add(this.newShopLocationLbl);
    this.newShopPanel.add(this.newShopLocationField);
    this.newShopPanel.add(this.createShopBtn);
    this.newShopPanel.add(this.stopCreatingShopBtn);

    this.newShop = new Window(this.newShopPanel, 400, 300, null, Messages.SHOP_NEW.text());

    //Buttons
    this.newPurch = new CButton(ActionPool.NEW_PURCHASE.getAction());
    this.editPurch = new CButton(ActionPool.EDIT_PURCHASE.getAction());
    this.deletePurch = new CButton(ActionPool.DEL_PURCHASE.getAction());

    this.buttons.setLayout(new GridLayout(3, 1, 0, 10));

    this.buttons.add(this.newPurch);
    this.buttons.add(this.editPurch);
    this.buttons.add(this.deletePurch);

    this.contentPanel.add(this.listScroller);
    this.contentPanel.add(this.buttons);
  }

  public GUIManager(DataModel model) {
    MainAction.init(this);
    model.setGUI(this);
    this.model = model;
    initialize();
    this.mainWindow = new Window(this.contentPanel, this.width, this.height, createMainMenuBar(), Main.NAME);
    this.mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

  }

  public DataModel getModel() {
    return this.model;
  }

  public void setVisible(boolean vis) {
    if (this.mainWindow != null) {
      this.mainWindow.setVisible(vis);
    }
  }
}
