package agenda;

import static java.lang.System.out;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class Conexao {

	private String url;
	private Connection con;
	public Connection conn;
	
	Conexao(){
		
		url="jdbc:mysql://localhost:3306/database?user=root&password=";

		
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url);
			out.println("<h3>Conexão feita com sucesso!<h3>");
			
		}catch(Exception e) {
			
			e.printStackTrace();
                        out.println("<h3>Conexão não feita<h3>");
		}
                
                
		
	}
        

	public int executaSQL(String sql) {
		
		try {
			
			Statement stm = con.createStatement();
			int res = stm.executeUpdate(sql);
			con.close();
			return res;
			
		}catch(Exception e) {
			
			e.printStackTrace();
			return 0;
		}
		
		
	}
        
        
        public ResultSet executaBusca(String sql){
         
            try{
                
                Statement stm = con.createStatement();
		ResultSet rs = stm.executeQuery(sql);
		con.close();
		return rs;
            
            }catch(Exception e) {
			
		e.printStackTrace();
		return null;
	   }
            
            
            
        }
        
         public ResultSet executaBusca_org(String sql){
         
            try{
                
                Statement stm = con.createStatement();
		ResultSet rs = stm.executeQuery(sql);
		return rs;
            
            }catch(Exception e) {
			
		e.printStackTrace();
		return null;
	   } 
            
        }
         
         
         
            public ResultSet executaBusca2(String sql){
         
            try{
                
                Statement stm = con.createStatement();
		ResultSet rs = stm.executeQuery(sql);
		return rs;
            
            }catch(Exception e) {
			
		e.printStackTrace();
		return null;
	   }
            
            
            
        }
         
         
            public ResultSet executaBusca_org2(String sql){
         
            try{
                
                Statement stm = con.createStatement();
		ResultSet rs = stm.executeQuery(sql);
		return rs;
            
            }catch(Exception e) {
			
		e.printStackTrace();
		return null;
	   } 
            
        }
	
            
            public void conectar () throws SQLException{
            
                conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/database", "root", "");
            
            }
            
            public void desconectar () throws SQLException{
            
            conn.close();
            }
            
            
            
    public ArrayList <Formato> getListaInteira() throws Exception{
    
    ArrayList <Formato> lista = new ArrayList<>();
    
    String SQL = "SELECT * FROM agenda";
    this.conectar();
    
    com.mysql.jdbc.Statement stm =  (com.mysql.jdbc.Statement) conn.createStatement();
    ResultSet rs =  stm.executeQuery(SQL);
    
    while(rs.next()){
    
        
        Formato cadastro = new Formato();
        cadastro.setId(rs.getInt("id"));
        cadastro.setNome(rs.getString("nome"));
        cadastro.setSobrenome(rs.getString("sobrenome"));
        cadastro.setEmail(rs.getString("email"));
        cadastro.setEndereco(rs.getString("endereco"));
        cadastro.setTelefone(rs.getString("telefone"));

        lista.add(cadastro);
  
    }
    
    this.desconectar();
    return lista;
 
    }  
            
            
	
}

