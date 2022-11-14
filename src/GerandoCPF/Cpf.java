/*
Wesley Elbert Assis
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
