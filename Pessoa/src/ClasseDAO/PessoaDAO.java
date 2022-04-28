
package ClasseDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;



public class PessoaDAO {
    private Connection con = null;

    public PessoaDAO() throws Exception {      
    try {
            this.con = Conexao.getConnection( );
        } catch( Exception e ) {
            throw new Exception( "Erro: " +  ":\n" + e.getMessage( ) );
        }    
}
    //chamando classe Pessoa 
    public void salvar (Pessoa pessoa) throws Exception {
         PreparedStatement ps = null;
        Connection con = null;
         try {
            String SQL = "INSERT INTO pessoa (nome, endereco, uf, telefone, documento, email) " + "values (?, ?, ?, ?, ?)";
            con = this.con;
            ps = con.prepareStatement(SQL);
            // ps.setInt(1, pessoa.getNomeCliente());
            ps.setString(1, pessoa.getNomeCliente());
            ps.setString(2, pessoa.getEndereco());
            ps.setString(3, pessoa.getUf());
            ps.setString(4, pessoa.getTelefone());
            ps.setString(5, pessoa.getDocumento());
            ps.setString(6, pessoa.getEmail());
          //  ps.setDouble(8, pessoa.getDocumento());
            ps.executeUpdate();
        } catch (SQLException sqle) {
            throw new
                    Exception("Erro ao inserir dados "+ sqle);
        } finally {
            Conexao.closeConnection(con, ps);
        }
    }
     public void excluir(Pessoa pessoa) throws Exception {
        PreparedStatement ps = null;
        Connection con = null;
       
       try {
            con = this.con;
            //alterar de acordo com o bd
            ps = con.prepareStatement("delete from pessoa where ? = nome");
            ps.setString(1, pessoa.getNomeCliente());
            ps.executeUpdate( );
        } catch (SQLException sqle) {
            throw new Exception("Erro ao excluir dados:" + sqle);
        } finally {
            Conexao.closeConnection(con, ps);
        }
        
    }
     
     public void atualizar(Pessoa pessoa)  throws Exception {
        PreparedStatement ps = null;
        Connection con = null;
        if (pessoa == null)
            throw new Exception("O valor passado não pode ser nulo");
        
        try {
            String SQL = "UPDATE pessoa SET nome=? endereco=?, uf=?,  telefone=?, documento=?, email= ? where nome=?";
            con = this.con;
            ps = con.prepareStatement(SQL);
          //  ps.setInt(1, pessoa.getNomeCliente());
            ps.setString(1, pessoa.getNomeCliente());
            ps.setString(2, pessoa.getEndereco());
            ps.setString(3, pessoa.getUf());
            ps.setString(4, pessoa.getTelefone());
            ps.setString(5, pessoa.getDocumento());
            ps.setString(6, pessoa.getEmail());
             ps.executeUpdate();
        } catch (SQLException sqle) {
            throw new Exception("Erro ao atualizar dados: "+ sqle);
        } finally {
            Conexao.closeConnection(con, ps);
            
        }
    }
     
     public List todasPessoas( )  throws Exception{
        PreparedStatement ps = null;
        Connection con = null;
        ResultSet rs = null;
        try {
            con = this.con;
            ps = con.prepareStatement("select * from pessoa");
            rs = ps.executeQuery( );
            List<Pessoa> list = new ArrayList<Pessoa>();
            while( rs.next( ) ) {
                Integer id_cliente = rs.getInt(1);
                String nomeCliente = rs.getString(2);
               // String endereco = rs.getString(3);
                //CategoriaBean categoria = procurarCategoria(rs.getInt(4));
                //list.add(new ClienteBeans(codigo,nome,endereco,categoria) );
                //list.add(new PessoaBeans(codigo,nome,endereco) );
            }
            return list;
        } catch (SQLException sqle) {
            throw new Exception(sqle);
        } finally {
            Conexao.closeConnection(con, ps, rs);
        }
    }
     
     
     
    
}
