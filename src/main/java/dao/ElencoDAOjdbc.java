/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import banco.Conexao;
import entidades.Elenco;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author samuel.ogliari
 */
public class ElencoDAOjdbc implements ElencoDAO {

    private static final String SQL_SALVAR
            = "INSERT INTO elenco "
            + "(nome, nacionalidade, dt_nascimento) "
            + "VALUES (?, ?, ?)";

    private static final String SQL_RECUPERAR_TODOS
            = "SELECT id, nome, nacionalidade, dt_nascimento "
            + "FROM elenco";

    private static final String SQL_RECUPERAR_UM
            = "SELECT id, nome, nacionalidade, dt_nascimento "
            + "FROM elenco WHERE id = ?";

    private static final String SQL_PESQUISAR_POR_NOME
            = "SELECT id, nome, nacionalidade, dt_nascimento "
            + "FROM elenco WHERE nome ILIKE ?";

    private static final String SQL_EDITAR
            = "UPDATE elenco SET nome = ?, nacionalidade = ?, "
            + "dt_nascimento = ? WHERE id = ?";

    private static final String SQL_EXCLUIR
            = "DELETE FROM elenco WHERE id = ?";

    @Override
    
    public void salvar(Elenco elenco) throws SQLException {
        try (Connection conexao = Conexao.conectar(); PreparedStatement comando
                = conexao.prepareStatement(SQL_SALVAR)) {

            comando.setString(1, elenco.getNome());
            comando.setString(2, elenco.getNacionalidade());

            if (elenco.getDtNascimento() == null) {
                comando.setNull(3, java.sql.Types.DATE);
            } else {
                comando.setDate(3, Date.valueOf(elenco.getDtNascimento()));
            }

            comando.executeUpdate();
        }
    }

    @Override
    
    public ArrayList<Elenco> recuperarTodos() throws SQLException {
        try (Connection conexao = Conexao.conectar(); PreparedStatement comando
                = conexao.prepareStatement(SQL_RECUPERAR_TODOS); ResultSet resultado = comando.executeQuery()) {

            ArrayList<Elenco> integrantes = new ArrayList<>();

            while (resultado.next()) {
                integrantes.add(mapearElenco(resultado));
            }

            return integrantes;
        }
    }

    @Override
    
    public Elenco recuperarUm(int codigo) throws SQLException {
        try (Connection conexao = Conexao.conectar(); PreparedStatement comando
                = conexao.prepareStatement(SQL_RECUPERAR_UM)) {

            comando.setInt(1, codigo);

            try (ResultSet resultado = comando.executeQuery()) {
                if (resultado.next()) {
                    return mapearElenco(resultado);
                }
            }
        }

        return null;
    }

    @Override
    
    public ArrayList<Elenco> pesquisarPorNome(String nome)
            throws SQLException {

        try (Connection conexao = Conexao.conectar(); PreparedStatement comando
                = conexao.prepareStatement(SQL_PESQUISAR_POR_NOME)) {

            comando.setString(1, "%" + nome + "%");

            try (ResultSet resultado = comando.executeQuery()) {
                ArrayList<Elenco> integrantes = new ArrayList<>();

                while (resultado.next()) {
                    integrantes.add(mapearElenco(resultado));
                }

                return integrantes;
            }
        }
    }

    @Override
    
    public void editar(Elenco elenco) throws SQLException {
        try (Connection conexao = Conexao.conectar(); PreparedStatement comando
                = conexao.prepareStatement(SQL_EDITAR)) {

            comando.setString(1, elenco.getNome());
            comando.setString(2, elenco.getNacionalidade());

            if (elenco.getDtNascimento() == null) {
                comando.setNull(3, java.sql.Types.DATE);
            } else {
                comando.setDate(3, Date.valueOf(elenco.getDtNascimento()));
            }

            comando.setInt(4, elenco.getCodigo());
            comando.executeUpdate();
        }
    }

    @Override
    
    public void excluir(int codigo) throws SQLException {
        try (Connection conexao = Conexao.conectar(); PreparedStatement comando
                = conexao.prepareStatement(SQL_EXCLUIR)) {

            comando.setInt(1, codigo);
            comando.executeUpdate();
        }
    }

    private Elenco mapearElenco(ResultSet resultado) throws SQLException {
        Date dataNascimento = resultado.getDate("dt_nascimento");

        Elenco elenco = new Elenco(
                resultado.getString("nome"),
                resultado.getString("nacionalidade"),
                dataNascimento != null
                        ? dataNascimento.toLocalDate()
                        : null
        );

        elenco.setCodigo(resultado.getInt("id"));

        return elenco;
    }
}
