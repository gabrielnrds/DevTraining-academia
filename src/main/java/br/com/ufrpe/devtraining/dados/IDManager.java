package br.com.ufrpe.devtraining.dados;

import java.io.*;

public class IDManager implements Serializable {
    private static final String CLIENT_FILENAME = "last_client_id.dat";
    private static final String PROFESSOR_FILENAME = "last_professor_id.dat";
    private static final String USUARIO_FILENAME = "last_usuario_id.dat";
    private int lastClientID;
    private int lastProfessorID;
    private int lastUsuarioID;

    public IDManager() {
        loadLastClientID();
        loadLastProfessorID();
        loadLastUsuarioID();
    }

    private void ensureFileExists(String filename) {
        File file = new File(filename);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                System.out.println("Erro ao criar o arquivo " + filename + ": " + e.getMessage());
            }
        }
    }

    public int getLastClientID() {
        return lastClientID;
    }

    public void setLastClientID(int lastClientID) {
        this.lastClientID = lastClientID;
    }

    public int getLastProfessorID() {
        return lastProfessorID;
    }

    public void setLastProfessorID(int lastProfessorID) {
        this.lastProfessorID = lastProfessorID;
        saveLastProfessorID(); // Salva o último ID do professor após atualizá-lo
    }

    public int getLastUsuarioID() {
        return lastUsuarioID;
    }

    public void setLastUsuarioID(int lastUsuarioID) {
        this.lastUsuarioID = lastUsuarioID;
        saveLastUsuarioID(); // Salva o último ID do usuário após atualizá-lo
    }

    public void saveLastClientID() {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(CLIENT_FILENAME))) {
            out.writeObject(lastClientID);
            System.out.println("Último ID do cliente salvo com sucesso.");
        } catch (IOException e) {
            System.out.println("Erro ao salvar último ID do cliente: " + e.getMessage());
        }
    }

    public void loadLastClientID() {
        ensureFileExists(CLIENT_FILENAME);
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(CLIENT_FILENAME))) {
            lastClientID = (int) in.readObject();
            System.out.println("Último ID do cliente carregado com sucesso.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Erro ao carregar último ID do cliente: " + e.getMessage());
        }
    }

    public void saveLastProfessorID() {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(PROFESSOR_FILENAME))) {
            out.writeObject(lastProfessorID);
            System.out.println("Último ID do professor salvo com sucesso.");
        } catch (IOException e) {
            System.out.println("Erro ao salvar último ID do professor: " + e.getMessage());
        }
    }

    public void loadLastProfessorID() {
        ensureFileExists(PROFESSOR_FILENAME);
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(PROFESSOR_FILENAME))) {
            lastProfessorID = (int) in.readObject();
            System.out.println("Último ID do professor carregado com sucesso.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Erro ao carregar último ID do professor: " + e.getMessage());
        }
    }

    public void saveLastUsuarioID() {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(USUARIO_FILENAME))) {
            out.writeObject(lastUsuarioID);
            System.out.println("Último ID do Usuário salvo com sucesso.");
        } catch (IOException e) {
            System.out.println("Erro ao salvar último ID do Usuário: " + e.getMessage());
        }
    }

    public void loadLastUsuarioID() {
        ensureFileExists(USUARIO_FILENAME);
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(USUARIO_FILENAME))) {
            lastUsuarioID = (int) in.readObject();
            System.out.println("Último ID do Usuário carregado com sucesso.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Erro ao carregar último ID do Usuário: " + e.getMessage());
        }
    }
}
