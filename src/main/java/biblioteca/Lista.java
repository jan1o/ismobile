package biblioteca;

import java.util.ArrayList;
import java.util.Iterator;

public class Lista extends ArrayList{
	/**
     * Creates a new instance of Lista
     */
    public Lista() {
    }
    
     public String MontarXML(){
        String lista = "<l>";
        Iterator it = this.iterator();
        while (it.hasNext()){
            InterfaceObjeto o = (InterfaceObjeto) it.next();
            lista = lista + o.toXML();
        }
      
        return lista+"</l>";
     }
}
