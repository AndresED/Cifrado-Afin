/**
 *
 * @author Andres Esquivel
 */
package Modelos;

import javax.swing.JOptionPane;

public class Inverso {
    public double CalcularInverso(long n,long z)
    {
        long mcd[] =new long[3];
        int x=0,y = 0;
        Euclides obj = new Euclides();
        if(n>z)
        {
            mcd=obj.euclidesExtendido(n,z);
        }
        if(n<z)
        {
            mcd=obj.euclidesExtendido(z,n);
        }
        
        System.out.println("MCD: "+mcd[0]);
        if(mcd[0]>1)
        {
            System.out.println("EL INVERSO NO EXISTE");
            JOptionPane.showMessageDialog(null, "A no tiene inverso por lo que no se puede realizar ninguna operacion");
            y=0;
        }
        else
        {
            y=(int) mcd[2];
            if(y<0)
            {
                y=(int) (y+z);
            }
        }
        //System.out.println("Hola y:" +y);
        return y;
    }
}
