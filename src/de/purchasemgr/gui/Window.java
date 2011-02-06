package de.purchasemgr.gui;

import java.awt.Toolkit;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JMenuBar;

import net.miginfocom.layout.AC;
import net.miginfocom.layout.LC;
import net.miginfocom.swing.MigLayout;
import de.purchasemgr.i18n.Strings;

/**
 * This class represents a frame, with special behaviour. It is able to centre
 * itself.
 * 
 * @author croesch
 * @since Date: 2010/12/18 18:32:23
 */
public final class Window extends JFrame {

  /** generated version UID */
  private static final long serialVersionUID = 5731315424494348485L;

  /**
   * This is a builder that is able to construct a {@link Window}
   * 
   * @author croesch
   * @since Date: 06.02.2011 15:28:58
   */
  public static class Builder {

    /** constant for the centred position */
    public static final int POSITION_CENTER = -1;

    //required fields

    /** the width of the window to construct */
    private final int width;

    /** the height of the window to construct */
    private final int height;

    //optional fields

    /** the title of the window to construct */
    private String title = Strings.EMPTY_STRING.text();

    /** the component to place to the content pane of the window to construct */
    private JComponent component = null;

    /** the menu bar of the window to construct */
    private JMenuBar menuBar = null;

    /** if the constructed window should be visible after creation */
    private boolean visible = false;

    /** if the constructed window should be resizable after creation */
    private boolean resizable = false;

    /** the position on the x-axis */
    private int xPosition = POSITION_CENTER;

    /** the position on the y-axis */
    private int yPosition = POSITION_CENTER;

    /**
     * Constructs a builder to build a {@link Window} with the given
     * measurements
     * 
     * @author croesch
     * @since Date: 06.02.2011 15:30:43
     * @param w the width of the {@link Window} to construct >0
     * @param h the height of the {@link Window} to construct >0
     * @throws IllegalArgumentException if w or h is <=0
     */
    public Builder(final int w, final int h) throws IllegalArgumentException {
      if (w <= 0 || h <= 0) {
        throw new IllegalArgumentException();
      }
      this.width = w;
      this.height = h;
    }

    /**
     * Sets the title for the frame to construct
     * 
     * @author croesch
     * @since Date: 06.02.2011 15:45:46
     * @param t the title !=null
     * @return the instance of this {@link Builder}
     * @throws IllegalArgumentException if t == null
     */
    public final Builder title(final String t) throws IllegalArgumentException {
      if (t == null) {
        throw new IllegalArgumentException();
      }
      this.title = t;
      return this;
    }

    /**
     * Sets the component to add to the content pane of the frame to construct
     * 
     * @author croesch
     * @since Date: 06.02.2011 15:45:46
     * @param c the component to add to the pane, if c == null, nothing will be
     *        added
     * @return the instance of this {@link Builder}
     */
    public final Builder component(final JComponent c) {
      this.component = c;
      return this;
    }

    /**
     * Sets the menu bar to add to the frame to construct
     * 
     * @author croesch
     * @since Date: 06.02.2011 15:45:46
     * @param mb the menu bar to add to the frame, if c == null, nothing will be
     *        added
     * @return the instance of this {@link Builder}
     */
    public final Builder menuBar(final JMenuBar mb) {
      this.menuBar = mb;
      return this;
    }

    /**
     * Whether the frame should be visible after creation.
     * 
     * @author croesch
     * @since Date: 06.02.2011 15:54:29
     * @param v {@code true}, if the frame should be visible after creation
     * @return the instance of this {@link Builder}
     */
    public final Builder visible(final boolean v) {
      this.visible = v;
      return this;
    }

    /**
     * Whether the frame should be resizable after creation.
     * 
     * @author croesch
     * @since Date: 06.02.2011 15:54:29
     * @param r {@code true}, if the frame should be resizable after creation
     * @return the instance of this {@link Builder}
     */
    public final Builder resizable(final boolean r) {
      this.resizable = r;
      return this;
    }

    /**
     * Sets the position of the frame to construct on the x-axis
     * 
     * @author croesch
     * @since Date: 06.02.2011 15:54:29
     * @param position the position on the x-axis
     * @return the instance of this {@link Builder}
     */
    public final Builder xPosition(final int position) {
      this.xPosition = position;
      return this;
    }

    /**
     * Sets the position of the frame to construct on the y-axis
     * 
     * @author croesch
     * @since Date: 06.02.2011 15:54:29
     * @param position the position on the y-axis
     * @return the instance of this {@link Builder}
     */
    public final Builder yPosition(final int position) {
      this.yPosition = position;
      return this;
    }

    /**
     * Builds the {@link Window} with the parameters stored in this
     * {@link Builder}
     * 
     * @author croesch
     * @since Date: 06.02.2011 15:49:47
     * @return the created {@link Window}
     */
    @SuppressWarnings("synthetic-access")
    public final Window build() {
      return new Window(this);
    }
  }

  /**
   * Constructs a new Window, with the parameters given in the {@link Builder}.
   * 
   * @author croesch
   * @since Date: 06.02.2011 15:50:47
   * @param builder the instance of the {@link Builder}
   */
  @SuppressWarnings("synthetic-access")
  private Window(final Builder builder) {

    getContentPane().setLayout(
                               new MigLayout(new LC(),
                                             new AC().fill().grow(),
                                             new AC().fill().grow()));
    getContentPane().add(builder.component);

    this.setJMenuBar(builder.menuBar);

    this.setSize(builder.width, builder.height);
    int x = builder.xPosition;
    int y = builder.yPosition;

    Toolkit kit = Toolkit.getDefaultToolkit();
    if (x == Builder.POSITION_CENTER) {
      x = (kit.getScreenSize().width - builder.width) / 2;
    }
    if (y == Builder.POSITION_CENTER) {
      y = (kit.getScreenSize().height - builder.height) / 2;
    }
    this.setLocation(x, y);

    this.setResizable(builder.resizable);
    this.setTitle(builder.title);
    this.setVisible(builder.visible);
  }
}
