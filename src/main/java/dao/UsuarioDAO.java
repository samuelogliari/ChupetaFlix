/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entidades.Usuario;
import java.sql.SQLException;

/**
 *
 * @author samuel.ogliari
 */
public interface UsuarioDAO {

    Usuario autenticar(String login, String senha) throws SQLException;

    void salvar(String nome, String login, String senha) throws SQLException;
}
