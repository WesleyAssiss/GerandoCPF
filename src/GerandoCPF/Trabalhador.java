/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GerandoCPF;


import java.util.ArrayList;
import java.util.Date;

public class Trabalhador extends Thread {

    private Date start;

    public Trabalhador()
    {
        reset();
    }

    public void reset()
    {
        start = new Date(); // now
    }

    public long getTime()
    {
        Date now = new Date();
        long millis = now.getTime() - start.getTime();

        return millis;
    }


    public String toString( boolean mili )
    {
        long millis = getTime();

        long hours = millis / 1000 / 60 / 60;
        millis -= hours * 1000 * 60 * 60;

        long minutes = millis / 1000 / 60;
        millis -= minutes * 1000 * 60;

        long seconds = millis / 1000;
        millis -= seconds * 1000;

        StringBuffer time = new StringBuffer();
        if( hours > 0 )
            time.append( hours + "H:" );
        if( hours > 0 && minutes < 10 )
            time.append( "0" );
        time.append(minutes + "min:" );
        if( seconds < 10 )
            time.append( "0" );
        time.append( seconds );

        if( mili ) {
            time.append( "seg." );
            if( millis < 100 )
                time.append( "0" );
            if( millis < 10 )
                time.append( "0" );
            time.append(millis + "ms");
        }

        return time.toString();
    }

    @Override
    public String toString()
    {
        return toString( true );
    }


    @Override
    public void run() {


        Trabalhador timer = new Trabalhador();

        ArrayList<Integer> CPF = new ArrayList();

        //iniciando os 9 primeiros números do cpf com 0
        int n1 = 0;
        int n2 = 0;
        int n3 = 0;
        int n4 = 0;
        int n5 = 0;
        int n6 = 0;
        int n7 = 0;
        int n8 = 0;
        int n9 = 0;

        while (true) {
            n9 += 1;
        //Instanciando os números
            CPF.add(n1);
            CPF.add(n2);
            CPF.add(n3);
            CPF.add(n4);
            CPF.add(n5);
            CPF.add(n6);
            CPF.add(n7);
            CPF.add(n8);
            CPF.add(n9);

            Verificadores(CPF);
            imprime(CPF);
            System.out.println();
            CPF.clear();
        //Quando n9 = 0, o valor irá da direita para esquerda.
            if (n9 == 9) {
                n8 += 1;
                n9 = 0;
            }
            if (n8 == 10) {
                n7 += 1;
                n8 = 0;
            }
            if (n7 == 10) {
                n6 += 1;
                n7 = 0;
            }
            if (n6 == 10) {
                n5 += 1;
                n6 = 0;
            }
            if (n5 == 10) {
                n4 += 1;
                n5 = 0;
            }
            if (n4 == 10) {
                n3 += 1;
                n4 = 0;
            }
            if (n3 == 10) {
                n2 += 1;
                n3 = 0;
            }
            if (n2 == 10) {
                n1 += 1;
                n2 = 0;
            }
            if (n1 == 10) {
                break;
            }
            // Número de Habitantes no Brail. Segundo dados do Instituto Brasileiro
            // de Geografia e Estatística (IBGE), no momento da publicação desta matéria (2022),
            // a projeção da população do Brasil é de ->  214.388.866
                    if(n1 == 2 && n2 == 1 && n3 == 4
                    && n4 == 3 && n5 == 8 && n6 == 8
                    && n7 == 8 && n8 == 6 && n9 == 6){
                break;
            }

        }
        System.out.println("Tempo de execução: " + timer);

    }
            //Calculando os dois ultimos digitos do CPF para validação.
    public  ArrayList<Integer> Verificadores(ArrayList<Integer> CPF) {

        int vetor[] = new int[11];
        int operando = 10, somaVerificador = 0, resto, digitoVerificador = 0;

        for (int i = 0; i < CPF.size(); i++) {
            somaVerificador = CPF.get(i) * operando + somaVerificador;
            operando--;
        }

        resto = somaVerificador % 11;

        if (resto < 2) {
            CPF.add(0);
        } else {
            if (resto >= 2) {
                digitoVerificador = 11 - resto;
                CPF.add(digitoVerificador);
            }
        }

        int operando2 = 11, somaVerificador2 = 0, resto2, digitoVerificador2 = 0;

        for (int k = 0; k < CPF.size(); k++) {
            somaVerificador2 = CPF.get(k) * operando2 + somaVerificador2;
            operando2--;
        }

        resto2 = somaVerificador2 % 11;

        if (resto2 < 2) {
            CPF.add(0);
        } else {
            if (resto2 >= 2) {
                digitoVerificador2 = 11 - resto2;
                CPF.add(digitoVerificador2);
            }
        }

        return CPF;
    }

    public  void imprime(ArrayList<Integer> CPF) {
        for (int i = 0; i < 11; i++) {
            System.out.print(CPF.get(i));
        }

    }
}
