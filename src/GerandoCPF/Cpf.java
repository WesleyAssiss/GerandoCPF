/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GerandoCPF;

public class Cpf {

    public static void main(String[] args) throws InterruptedException {

        Trabalhador trabs[] = {new Trabalhador()};

        for (Trabalhador trab : trabs) {
            trab.start();
        }

        for (Trabalhador trab : trabs) {
            trab.join();
        }

    }
}
