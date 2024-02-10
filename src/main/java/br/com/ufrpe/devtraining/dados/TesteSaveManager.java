package br.com.ufrpe.devtraining.dados;

public class TesteSaveManager {
    public static void main(String[] args) {
        // Criando instâncias dos repositórios individuais
        RepositorioClientes repositorioClientes = new RepositorioClientes(100);
        RepositorioExercicios repositorioExercicios = new RepositorioExercicios(100);
        RepositorioUsuarios repositorioUsuarios = new RepositorioUsuarios(100);
        RepositorioTreinos repositorioTreinos = new RepositorioTreinos(100);
        RepositorioProfessores repositorioProfessores = new RepositorioProfessores(100);

        // Adicionando alguns dados aos repositórios (opcional)
        // (Você pode pular esta parte se já tiver dados nos repositórios)

        // Criando instância de RepositorioGeral e associando os repositórios individuais
        RepositorioGeral repositorioGeral = new RepositorioGeral();
        repositorioGeral.setRepositorioClientes(repositorioClientes);
        repositorioGeral.setRepositorioExercicios(repositorioExercicios);
        repositorioGeral.setRepositorioUsuarios(repositorioUsuarios);
        repositorioGeral.setRepositorioTreinos(repositorioTreinos);
        repositorioGeral.setRepositorioProfessores(repositorioProfessores);

        // Criando instância do SaveManager
        SaveManager saveManager = new SaveManager(repositorioGeral);

        // Salvando os dados
        saveManager.salvar();

        // Carregando os dados
        saveManager.carregar();

        // Verificando se os dados foram carregados corretamente
        System.out.println("Repositório de clientes carregado com sucesso: " + repositorioGeral.getRepositorioClientes());
        System.out.println("Repositório de exercícios carregado com sucesso: " + repositorioGeral.getRepositorioExercicios());
        System.out.println("Repositório de usuários carregado com sucesso: " + repositorioGeral.getUsuarioRepositorio());
        System.out.println("Repositório de treinos carregado com sucesso: " + repositorioGeral.getRepositorioTreinos());
        System.out.println("Repositório de professores carregado com sucesso: " + repositorioGeral.getRepositorioProfessores());
    }
}
