package br.com.ufrpe.devtraining;

import br.com.ufrpe.devtraining.negocio.entidades.*;

public class app {
    public static void main(String[] args){

        Professor professor = new Professor("Roberto", "8199777-6666", "roberto.bc@email.com", "7141564", "Rua da aurora, centro", "25", "tarde", 1212.23, new Usuario("roberto", "1234"));

        Cliente cliente = new Cliente("Jessiane", "325222352", "email", "4234235", "endereço", "23", professor, true, new Usuario("jessiane", "1234"));

        FichaTreino ficha = new FichaTreino(professor, cliente, "inferior");

        ficha.adicionarExercicio(new Exercicio("Leg Press", 3, 12));
        ficha.adicionarExercicio(new Exercicio("Agachamento", 3, 12));
        ficha.adicionarExercicio(new Exercicio("Panturrilha", 4, 14));
        ficha.adicionarExercicio(new Exercicio("Extensora", 3, 12));

        FichaTreino ficha2 = new FichaTreino(professor, cliente, "superior");

        System.out.println(ficha2.getIdTreino());
        System.out.println(professor.getId());
        System.out.println(cliente.getId());

    }
}
