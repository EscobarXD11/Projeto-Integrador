/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pi.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/**
 *
 * @author wesle
 */
public class Conexao {

    public Connection getConexao() {
        return conexao;
    }

    public void setConexao(Connection conexao) {
        this.conexao = conexao;
    }
    
    private Connection conexao;
        
public void conectar() throws SQLException{  
    
    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        conexao = DriverManager.getConnection("jdbc:mysql://localhost/pi","root","2003");
        System.err.println("CONECTADO COM SUCESSO!");
    } catch (ClassNotFoundException e) {
        System.out.println("Falha ao conectar classe de conexão!");
    } catch (SQLException s) {
        System.err.println("Falha ao conectar com o banco de dados. Erro de SQL!");
    }
}
   
public void desconectar(){
    
    try {
        if(conexao != null && !conexao.isClosed()) {
            conexao.close();
            System.err.println("DESCONECTADO COM SUCESSO!");    
            
        }
    } catch (SQLException ex) {
        System.out.println("Erro ao desconectar.");
    }
        
    
    
}

}
