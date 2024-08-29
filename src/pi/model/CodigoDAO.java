/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pi.model;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import java.sql.ResultSet;

public class CodigoDAO {

    public static boolean cadastrar(Codigo c) {
        try {
            Conexao conexao = new Conexao();
            conexao.conectar();

            String sql = "INSERT INTO servicos(nomeCliente, cpf, dataNascimento, metodoPagamento, modeloCarro, anoCarro, nomeCarro, placa, valor, servico, realizado) VALUES(?,?,?,?,?,?,?,?,?,?,?);";
            PreparedStatement query = conexao.getConexao().prepareStatement(sql);
            query.setString(1, c.getNomeCliente());
            query.setString(2, c.getCPF());
            query.setString(3, c.getDataNascimento());
            query.setString(4, c.getMetodoPagamento());
            query.setString(5, c.getModeloCarro());
            query.setString(6, c.getAnoCarro());
            query.setString(7, c.getNomeCarro());
            query.setString(8, c.getPlaca());
            query.setDouble(9, c.getValor());
            query.setString(10, c.getServico());
            query.setBoolean(11, c.isRealizado());

            int linhasAfetadas = query.executeUpdate();

            conexao.desconectar();

            if (linhasAfetadas > 0) {
                JOptionPane.showMessageDialog(null, "Registro cadastrado com sucesso!");
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "Falha ao cadastrar registro no banco de dados!");
                return false;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar registro no banco de dados: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    public static List<Codigo> ListarTodos() {
        List<Codigo> lista = new ArrayList<Codigo>();

        try {
            Conexao conexao = new Conexao();
            conexao.conectar();

            String sql = "SELECT * FROM servicos";
            PreparedStatement consulta = conexao.getConexao().prepareStatement(sql);

            ResultSet resposta = consulta.executeQuery();

            while (resposta.next()) {
                Codigo c = new Codigo();
                c.setId(resposta.getInt("id"));
                c.setNomeCliente(resposta.getString("nomeCliente"));
                c.setCPF(resposta.getString("cpf"));
                c.setDataNascimento(resposta.getString("dataNascimento"));
                c.setMetodoPagamento(resposta.getString("metodoPagamento"));
                c.setModeloCarro(resposta.getString("modeloCarro"));
                c.setAnoCarro(resposta.getString("anoCarro"));
                c.setNomeCarro(resposta.getString("nomeCarro"));
                c.setPlaca(resposta.getString("placa"));
                c.setValor(resposta.getDouble("valor"));
                c.setServico(resposta.getString("servico"));
                c.setRealizado(resposta.getBoolean("realizado"));

                lista.add(c);
            }

            conexao.desconectar();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao listar registros no banco de dados!");
            e.printStackTrace(); // Exibe informações detalhadas sobre o erro no console
        }

        return lista;
    }

    public static boolean excluir(int id) {
        List<Codigo> lista = new ArrayList<Codigo>();

        try {
            Conexao conexao = new Conexao();
            conexao.conectar();

            String sql = "DELETE FROM servicos WHERE id=?;";
            PreparedStatement consulta = conexao.getConexao().prepareStatement(sql);

            consulta.setInt(1, id);

            consulta.execute();

            conexao.desconectar();
            return true;

        } catch (SQLException s) {
            JOptionPane.showMessageDialog(null, "Erro ao deletar registro no banco de dados!");
        }
        return false;
    }

    public static boolean atualizar(Codigo c) {
    try {
        Conexao conexao = new Conexao();
        conexao.conectar();

        String sql = "UPDATE servicos SET nomeCliente=?, cpf=?, dataNascimento=?, metodoPagamento=?, modeloCarro=?, anoCarro=?, nomeCarro=?, placa=?, valor=?, servico=?, realizado=? WHERE id=?;";
        PreparedStatement consulta = conexao.getConexao().prepareStatement(sql);

        consulta.setString(1, c.getNomeCliente());
        consulta.setString(2, c.getCPF());
        consulta.setString(3, c.getDataNascimento());
        consulta.setString(4, c.getMetodoPagamento());
        consulta.setString(5, c.getModeloCarro());
        consulta.setString(6, c.getAnoCarro());
        consulta.setString(7, c.getNomeCarro());
        consulta.setString(8, c.getPlaca());
        consulta.setDouble(9, c.getValor());
        consulta.setString(10, c.getServico());
        consulta.setBoolean(11, c.isRealizado());
        consulta.setInt(12, c.getId());

        int linhasAfetadas = consulta.executeUpdate(); // Use executeUpdate para atualizações

        conexao.desconectar();
        
        if (linhasAfetadas > 0) {
            // Não é ideal exibir a mensagem aqui, melhor controlar isso na interface
            // JOptionPane.showMessageDialog(null, "Registro atualizado com sucesso!");
            return true;
        } else {
            // JOptionPane.showMessageDialog(null, "Falha ao atualizar registro no banco de dados!");
            return false;
        }
    } catch (SQLException e) {
        e.printStackTrace();
        // Trate a exceção adequadamente, como lançar uma exceção personalizada ou logar o erro
        return false;
    }
}
   
    
   public static Codigo BuscarPorId(int id) {
    Codigo c = null; // Inicialize com null para tratar caso nenhum registro seja encontrado
    try {
        Conexao conexao = new Conexao();
        conexao.conectar();

        String sql = "SELECT * FROM servicos WHERE id=?;";
        PreparedStatement consulta = conexao.getConexao().prepareStatement(sql);
        consulta.setInt(1, id);

        ResultSet resposta = consulta.executeQuery();

        if (resposta.next()) {
            c = new Codigo(); // Inicialize o objeto Codigo aqui
            c.setId(resposta.getInt("id"));
            c.setNomeCliente(resposta.getString("nomeCliente"));
            c.setCPF(resposta.getString("cpf"));
            c.setDataNascimento(resposta.getString("dataNascimento"));
            c.setMetodoPagamento(resposta.getString("metodoPagamento"));
            c.setModeloCarro(resposta.getString("modeloCarro"));
            c.setAnoCarro(resposta.getString("anoCarro"));
            c.setNomeCarro(resposta.getString("nomeCarro"));
            c.setPlaca(resposta.getString("placa"));
            c.setValor(resposta.getDouble("valor"));
            c.setServico(resposta.getString("servico"));
            c.setRealizado(resposta.getBoolean("realizado"));
        }

        conexao.desconectar();

    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Erro ao buscar registro " + id + " do banco de dados!");
        e.printStackTrace(); // Exibe informações detalhadas sobre o erro no console
    }

    return c;
}
   
   public static List<Codigo> buscarPorServico(String nome) {
    List<Codigo> resultados = new ArrayList<>();
    
    try {
        // Conectar ao banco de dados
        Conexao conexao = new Conexao();
        conexao.conectar();
        
        // Instrução SQL para buscar registros pelo nome do serviço
        String SQL = "SELECT * FROM servicos WHERE servico LIKE ?";
        PreparedStatement consulta = conexao.getConexao().prepareStatement(SQL);
        
        // Configurar o parâmetro do nome para fazer a busca
        consulta.setString(1, "%" + nome + "%"); // Usamos % para corresponder a qualquer texto antes ou depois do nome
        
        // Executar a consulta
        ResultSet resposta = consulta.executeQuery();
        
        // Processar os resultados da consulta
        while (resposta.next()) {
            Codigo c = new Codigo();
            c.setId(resposta.getInt("id"));
            c.setNomeCliente(resposta.getString("nomeCliente"));
            c.setCPF(resposta.getString("cpf"));
            c.setDataNascimento(resposta.getString("dataNascimento"));
            c.setMetodoPagamento(resposta.getString("metodoPagamento"));
            c.setModeloCarro(resposta.getString("modeloCarro"));
            c.setAnoCarro(resposta.getString("anoCarro"));
            c.setNomeCarro(resposta.getString("nomeCarro"));
            c.setPlaca(resposta.getString("placa"));
            c.setValor(resposta.getDouble("valor"));
            c.setServico(resposta.getString("servico"));
            c.setRealizado(resposta.getBoolean("realizado"));
            
            resultados.add(c);
        }
        
        // Desconectar do banco de dados
        conexao.desconectar();
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Erro ao buscar registros do banco de dados!");
        e.printStackTrace(); // Exibe informações detalhadas sobre o erro no console
    }
    
    return resultados;
}
}