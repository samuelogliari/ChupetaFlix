/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package chupetaflix;

import com.formdev.flatlaf.themes.FlatMacDarkLaf;
import telas.TelaLogin;
import telas.TelaMenu;

/**
 *
 * @author samuel.ogliari
 */
public class Chupetinhaflix {

    public static void main(String[] args) {
        FlatMacDarkLaf.setup(); // import do flatlaf para estilo
        TelaLogin tl = new TelaLogin();
        tl.setVisible(true);
        
    }
}
