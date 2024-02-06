package br.com.ufrpe.devtraining;

import br.com.ufrpe.devtraining.negocio.entidades.Cliente;
import br.com.ufrpe.devtraining.negocio.entidades.Exercicio;
import br.com.ufrpe.devtraining.negocio.entidades.FichaTreino;
import br.com.ufrpe.devtraining.negocio.entidades.Professor;

public class app {
    public static void main(String[] args){
        Professor professor = new Professor(1, "Roberto", "8199777-6666", "roberto.bc@email.com", "7141564", "Rua da aurora, centro", 25, "tarde", 1212.23);

        Cliente cliente = new Cliente(2, "Jessiane", "325222352", "email", "4234235", "endereço", 23, professor, true);

        FichaTreino ficha = new FichaTreino(1, professor, cliente, "inferior");

        ficha.adicionarExercicio(new Exercicio("Leg Press", 3, 12));
        ficha.adicionarExercicio(new Exercicio("Agachamento", 3, 12));
        ficha.adicionarExercicio(new Exercicio("Panturrilha", 4, 14));
        ficha.adicionarExercicio(new Exercicio("Extensora", 3, 12));

        System.out.println(ficha.toString());
    }
}
