package Modelos;
import java.util.ArrayList;

/**
 *
 * @author Andres Esquivel
 */
public class Afin {
    private int a;
    private int b;
    private String cadena;
    private String alfabeto[] = new String[26];
    private String CadenaEncriptada;
    private String CadenaDesencriptada;
    public Afin(int a,int b,String cadena)
    {
        this.a=a;
        this.b=b;
        this.cadena=cadena;
        this.alfabeto[0]="a";
        this.alfabeto[1]="b";
        this.alfabeto[2]="c";
        this.alfabeto[3]="d";
        this.alfabeto[4]="e";
        this.alfabeto[5]="f";
        this.alfabeto[6]="g";
        this.alfabeto[7]="h";
        this.alfabeto[8]="i";
        this.alfabeto[9]="j";
        this.alfabeto[10]="k";
        this.alfabeto[11]="l";
        this.alfabeto[12]="m";
        this.alfabeto[13]="n";
        this.alfabeto[14]="o";
        this.alfabeto[15]="p";
        this.alfabeto[16]="q";
        this.alfabeto[17]="r";
        this.alfabeto[18]="s";
        this.alfabeto[19]="t";
        this.alfabeto[20]="u";
        this.alfabeto[21]="v";
        this.alfabeto[22]="w";
        this.alfabeto[23]="x";
        this.alfabeto[24]="y";
        this.alfabeto[25]="z";
    }
    public String LimpiarEspacios(String cadenas)
    {
        String aux="";
        //limpiando espacios en blanco
        for (int i = 0; i < cadenas.length(); i++) 
        {
            if(cadenas.charAt(i)!=' ')//Mientras sea diferente de un espacio vamos concatenando caracter a caracter en una nueva cadena
            {
                aux=aux+cadenas.charAt(i);
            }
        }
        return aux;
    }
    public ArrayList<Integer> CadenaNumeros(String aux)
    {
        ArrayList<Integer> cadena_en_numeros= new ArrayList<>();
        for (int j = 0; j < aux.length(); j++) {
            
            for (int k = 0; k < alfabeto.length; k++) 
            {
                if(alfabeto[k].charAt(0)==aux.charAt(j))//Comparando cada caracter de la cadena auxiliar con cada elemento del alfabeto y si corresponde a la letra estoy guardando su posicio
                {
                    cadena_en_numeros.add(k);
                }
            }
        }
        return cadena_en_numeros;
    }
    public String NumerosCadena(ArrayList<Integer> Lista)
    {
        String aux="";
        for (int i = 0; i < Lista.size(); i++) {
            if(Lista.get(i)==0)
            {
                aux=aux+"a";
            }
            if(Lista.get(i)==1)
            {
                aux=aux+"b";
            }
            if(Lista.get(i)==2)
            {
                aux=aux+"c";
            }
            if(Lista.get(i)==3)
            {
                aux=aux+"d";
            }
            if(Lista.get(i)==4)
            {
                aux=aux+"e";
            }
            if(Lista.get(i)==5)
            {
                aux=aux+"f";
            }
            if(Lista.get(i)==6)
            {
                aux=aux+"g";
            }
            if(Lista.get(i)==7)
            {
                aux=aux+"h";
            }
            if(Lista.get(i)==8)
            {
                aux=aux+"i";
            }
            if(Lista.get(i)==9)
            {
                aux=aux+"j";
            }
            if(Lista.get(i)==10)
            {
                aux=aux+"k";
            }
            if(Lista.get(i)==11)
            {
                aux=aux+"l";
            }
            if(Lista.get(i)==12)
            {
                aux=aux+"m";
            }
            if(Lista.get(i)==13)
            {
                aux=aux+"n";
            }
            if(Lista.get(i)==14)
            {
                aux=aux+"o";
            }
            if(Lista.get(i)==15)
            {
                aux=aux+"p";
            }
            if(Lista.get(i)==16)
            {
                aux=aux+"q";
            }
            if(Lista.get(i)==17)
            {
                aux=aux+"r";
            }
            if(Lista.get(i)==18)
            {
                aux=aux+"s";
            }
            if(Lista.get(i)==19)
            {
                aux=aux+"t";
            }
            if(Lista.get(i)==20)
            {
                aux=aux+"u";
            }
            if(Lista.get(i)==21)
            {
                aux=aux+"v";
            }
            if(Lista.get(i)==22)
            {
                aux=aux+"w";
            }
            if(Lista.get(i)==23)
            {
                aux=aux+"x";
            }
            if(Lista.get(i)==24)
            {
                aux=aux+"y";
            }
            if(Lista.get(i)==25)
            {
                aux=aux+"z";
            }
        }
        return aux;
    }
    public void Encriptar()
    {
        ArrayList<Integer> cadena_en_numeros=new ArrayList<>();
        ArrayList<Integer> numeros_encriptados=new ArrayList<>();
        String aux;
        //LIMPIANDO ESPACIOS EN BLANCO
        aux=LimpiarEspacios(cadena);
        //Convirtiendo cadena auxiliar en numeros para luego proceder a su encripacion
        cadena_en_numeros=CadenaNumeros(aux);
        int C;
        //Encriptando => C=aP+b(mod26)
        for (int m = 0; m<cadena_en_numeros.size(); m++) 
        {
            C=(a*cadena_en_numeros.get(m)+b)%26;
            numeros_encriptados.add(C);
        }
        //Convirtiendo numeros encriptados a una cadena que representara la cadena encriptada
        CadenaEncriptada=NumerosCadena(numeros_encriptados);
    }
    public void Desencriptar()
    {
        ArrayList<Integer> cadena_en_numeros=new ArrayList<>();
        ArrayList<Integer> numeros_desencriptados=new ArrayList<>();
        //Limpiar Espacios
        String aux=LimpiarEspacios(cadena);
        //Pasar la cadena a numeros
        cadena_en_numeros=CadenaNumeros(aux);
        //Desencriptando P=(inversa(a)*(c-b)))%26
        Inverso inverso= new Inverso();
        long inv;
        int aux_num;
        inv = (long) inverso.CalcularInverso(a,26);
        for (int i = 0; i < cadena_en_numeros.size(); i++) {
            aux_num=(int) (inv*(cadena_en_numeros.get(i)-b))%26;
            if(aux_num<0)
            {
                aux_num=aux_num+26;
            }
            numeros_desencriptados.add(aux_num);
        }
        /*for (int j = 0; j < numeros_desencriptados.size(); j++) {
            System.out.println(numeros_desencriptados.get(j));
        }*/
        //Convirtiendo de numeros a letras
        CadenaDesencriptada=NumerosCadena(numeros_desencriptados);
    }
    public String GetCadenaEncriptada()
    {
        return CadenaEncriptada;
    }
    public String GetCadenaDesencriptada()
    {
        return CadenaDesencriptada;
    }
}

