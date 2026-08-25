/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.projetopratico2;

import com.formdev.flatlaf.themes.FlatMacDarkLaf;
import telas.TelaMenu;

/**
 *
 * @author samuel.ogliari
 */
public class Chupetinhaflix {

    public static void main(String[] args) {
        FlatMacDarkLaf.setup(); // import do flatlaf para estilo
        TelaMenu tm = new TelaMenu();
        tm.setVisible(true);
    }
}
