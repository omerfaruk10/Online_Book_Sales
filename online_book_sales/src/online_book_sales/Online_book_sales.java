package online_book_sales;
import com.formdev.flatlaf.FlatLightLaf;

/**
 * @author Omer Faruk
 */
public class Online_book_sales {
    public static void main(String[] args) {
        FlatLightLaf.setup();
        
        Introduction_screen introduction_screen = new Introduction_screen();
        introduction_screen.setVisible(true);
    } 
}
