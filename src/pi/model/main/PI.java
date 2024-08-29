
package pi.model.main;

import java.sql.SQLException;
import pi.model.Codigo;
import pi.model.CodigoDAO;
import pi.model.Conexao;
import pi.view.TelaAdicionar;
import pi.view.TelaPrincipal;


public class PI {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
     
 TelaPrincipal tp = new TelaPrincipal();
 tp.setVisible(true);
 tp.setLocationRelativeTo(null);
    }
    
}
