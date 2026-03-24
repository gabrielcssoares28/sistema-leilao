/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Adm
 */

import java.sql.PreparedStatement;
import java.sql.Connection;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.util.ArrayList;


public class ProdutosDAO {
    
    Connection conn;
    PreparedStatement prep;
    ResultSet resultset;
    ArrayList<ProdutosDTO> listagem = new ArrayList<>();
    
    public void cadastrarProduto (ProdutosDTO produto){
        String sql = "INSERT INTO produtos (nome, valor, status) VALUES (?, ?, ?)";

    try {
        Connection conn = new conectaDAO().connectDB();
        PreparedStatement pstm = conn.prepareStatement(sql);

        pstm.setString(1, produto.getNome());
        pstm.setInt(2, produto.getValor());
        pstm.setString(3, produto.getStatus());

        pstm.execute();
        pstm.close();

    } catch (Exception e) {
        javax.swing.JOptionPane.showMessageDialog(null, "Erro ao cadastrar produto: " + e.getMessage());
    }
        
        //conn = new conectaDAO().connectDB();
        
        
    }
    
    public ArrayList<ProdutosDTO> listarProdutos(){
        ArrayList<ProdutosDTO> lista = new ArrayList<>();

    try {
        java.sql.Connection conn = new conectaDAO().connectDB();
        java.sql.Statement stmt = conn.createStatement();
        java.sql.ResultSet rs = stmt.executeQuery("SELECT * FROM produtos");

        while(rs.next()){
            ProdutosDTO produto = new ProdutosDTO();

            produto.setId(rs.getInt("id"));
            produto.setNome(rs.getString("nome"));
            produto.setValor(rs.getInt("valor"));
            produto.setStatus(rs.getString("status"));

            lista.add(produto);
        }

    } catch (Exception e) {
        javax.swing.JOptionPane.showMessageDialog(null, "Erro ao listar produtos!");
    }

    return lista;
    }
    
    
    
        
}

