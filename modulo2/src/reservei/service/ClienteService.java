package reservei.service;

import reservei.exceptions.DBException;
import reservei.model.Cliente;
import reservei.model.Hotel;
import reservei.repository.ClienteRepository;

public class ClienteService {

    private ClienteRepository clienteRepository;

    public ClienteService(){
        clienteRepository = new ClienteRepository();
    }

    public void adicionarCliente(Cliente cliente) {
        try {
            if (cliente.getTelefone().length() > 14) {
                throw new DBException("Você inseriu um telefone inválido, digite novamente:");
            }
            if (cliente.getCpf().length() != 11) {
                throw new DBException("Você inseriu um CPF inválido, digite novamente:");
            }
            clienteRepository.adicionar(cliente);
            System.out.println("Cliente adicionado com sucesso!");
        } catch (DBException e) {
            System.out.println(e.getMessage());
        }
    }

    public void listarClientes() {
        try {
            clienteRepository.listar().forEach(System.out::println);
        } catch (DBException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void editarCliente(Integer indice, Cliente cliente) {
        try {
            boolean deuCerto = clienteRepository.editar(indice, cliente);
            System.out.println("Edição concluída? " + deuCerto + "| com id=" + indice);
        } catch (DBException e) {
            System.out.println(e.getMessage());
        }
    }

    public void removerCliente(Integer id) {
        try {
            boolean deuCerto = clienteRepository.remover(id);
            System.out.println("Cliente excluído com sucesso? " + deuCerto + "| com id=" + id);
        } catch (DBException e) {
            System.out.println(e.getMessage());
        }
    }

    public boolean validarCliente(String senha, String cpf){
        try{
            if (clienteRepository.validarCliente(senha, cpf)){
                System.out.println("Login efetuado com sucesso");
            }else{
                System.out.println("Usuário não encontrado");
            }

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return false;
    }
    public Cliente clienteEscolhido(String cpf){
        try {
            Cliente cliente = clienteRepository.listarClientePorCPF(cpf).stream().findFirst().get();
            return cliente;
        }catch (DBException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
