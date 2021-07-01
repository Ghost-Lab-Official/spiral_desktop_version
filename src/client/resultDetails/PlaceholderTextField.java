package client.resultDetails;

import java.awt.*;
import javax.swing.*;

public class PlaceholderTextField extends JTextField {

  public static void main(final String[] args) {
    final PlaceholderTextField tf = new PlaceholderTextField("");
    tf.setColumns(20);
    tf.setPlaceholder("Add a comment!");
    final Font f = tf.getFont();
    tf.setFont(new Font(f.getName(), f.getStyle(), 15));
    JOptionPane.showMessageDialog(null, tf);
  }

  private String placeholder;

  public PlaceholderTextField() {}

  public PlaceholderTextField(final String pText) {
    super(pText);
  }

  public String getPlaceholder() {
    return placeholder;
  }

  @Override
  protected void paintComponent(final Graphics pG) {
    super.paintComponent(pG);

    if (
      placeholder == null || placeholder.length() == 0 || getText().length() > 0
    ) {
      return;
    }

    final Graphics2D g = (Graphics2D) pG;
    g.setColor(getDisabledTextColor());
    g.drawString(
      placeholder,
      getInsets().left,
      pG.getFontMetrics().getMaxAscent() + getInsets().top
    );
  }

  public void setPlaceholder(final String s) {
    placeholder = s;
  }
}
