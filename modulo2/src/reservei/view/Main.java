package reservei.view;

import reservei.model.Cliente;
import reservei.model.Hotel;
import reservei.model.Quarto;
import reservei.model.Reserva;
import reservei.service.ClienteService;
import reservei.service.HotelService;
import reservei.service.QuartoService;
import reservei.service.ReservaService;

import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        HotelService hotelService = new HotelService();
        QuartoService quartoService = new QuartoService();
        ClienteService clienteService = new ClienteService();
        ReservaService reservaService = new ReservaService();
        int opcao = 0;
        while (opcao != 4) {
            System.out.println("1: Menu Hotel");
            System.out.println("2: Menu Cliente");
            System.out.println("3: Menu Reserva");
            opcao = sc.nextInt();
            switch (opcao) {
                case 1 -> {
                    int escolha = 0;
                    System.out.println("1: Cadastrar Hotel");
                    System.out.println("2: Lista Hoteis");
                    System.out.println("3: Editar Hotel");
                    System.out.println("4: Excluir Hotel");
                    escolha = sc.nextInt();
                    switch (escolha) {
                        case 1 -> {
                            sc.nextLine();
                            Hotel hotel = new Hotel();
                            System.out.println("Digite o nome:");
                            hotel.setNome(sc.nextLine());

                            System.out.println("Digite a cidade:");
                            hotel.setCidade(sc.nextLine());

                            System.out.println("Digite o telefone: (DDD+Número)");
                            hotel.setTelefone(sc.nextLine());

                            System.out.println("Digite a classificação, de 1 a 5:");
                            hotel.setClassificacao(sc.nextInt());

                            hotelService.adicionarHotel(hotel);
                            break;
                        }
                        case 2 -> {
                            hotelService.listarHoteis();
                            break;
                        }
                        case 3 -> {
                            System.out.println("Qual hotel você deseja editar:");
                            hotelService.listarHoteis();
                            System.out.println("Id Hotel: ");
                            int indice = sc.nextInt();
                            sc.nextLine();

                            Hotel hotelEditado = new Hotel();

                            System.out.println("Digite o nome:");
                            hotelEditado.setNome(sc.nextLine());

                            System.out.println("Digite a cidade:");
                            hotelEditado.setCidade(sc.nextLine());

                            System.out.println("Digite o telefone: (DDD+Número)");
                            hotelEditado.setTelefone(sc.nextLine());

                            System.out.println("Digite a classificação, de 1 a 5:");
                            hotelEditado.setClassificacao(sc.nextInt());

                            hotelService.editarHotel(indice, hotelEditado);
                            break;
                        }
                        case 4 -> {
                            System.out.println("Qual hotel você deseja excluir?");
                            hotelService.listarHoteis();
                            System.out.println("Id Hotel: ");
                            int id = sc.nextInt();
                            hotelService.removerHotel(id);
                        }
                    }
                }
                case 2 -> {
                    int escolha = 0;
                    System.out.println("1: Cadastrar Cliente");
                    System.out.println("2: Listar Clientes");
                    System.out.println("3: Editar Cliente");
                    System.out.println("4: Excluir Cliente");
                    escolha = sc.nextInt();
                    switch (escolha) {
                        case 1 -> {
                            sc.nextLine();
                            Cliente cliente = new Cliente();
                            System.out.println("Digite o nome:");
                            cliente.setNome(sc.nextLine());

                            System.out.println("Digite o CPF:");
                            cliente.setCpf(sc.nextLine());

                            System.out.println("Digite o telefone: (DDD+Número)");
                            cliente.setTelefone(sc.nextLine());

                            System.out.println("Digite o email:");
                            cliente.setEmail(sc.nextLine());

                            System.out.println("Digite a senha:");
                            cliente.setSenha(sc.nextLine());

                            clienteService.adicionarCliente(cliente);
                            break;
                        }
                        case 2 -> {
                            clienteService.listarClientes();
                            break;
                        }
                        case 3 -> {
                            System.out.println("Qual cliente você deseja editar:");
                            clienteService.listarClientes();
                            System.out.println("Id Cliente: ");
                            int indice = sc.nextInt();
                            sc.nextLine();

                            Cliente clienteEditado = new Cliente();

                            System.out.println("Digite o nome:");
                            clienteEditado.setNome(sc.nextLine());

                            System.out.println("Digite o CPF:");
                            clienteEditado.setCpf(sc.nextLine());

                            System.out.println("Digite o telefone: (DDD+Número)");
                            clienteEditado.setTelefone(sc.nextLine());

                            System.out.println("Digite o email:");
                            clienteEditado.setEmail(sc.nextLine());

                            System.out.println("Digite a senha:");
                            clienteEditado.setSenha(sc.nextLine());

                            clienteService.editarCliente(indice, clienteEditado);
                            break;
                        }
                        case 4 -> {
                            System.out.println("Qual cliente você deseja excluir?");
                            clienteService.listarClientes();
                            System.out.println("Id Cliente: ");
                            int id = sc.nextInt();
                            clienteService.removerCliente(id);
                        }

                    }
                }
                case 3 -> {
                    int escolha = 0;
                    System.out.println("1: Cadastrar Reserva");
                    System.out.println("2: Listar Reservas");
                    System.out.println("3: Editar Reserva");
                    System.out.println("4: Excluir Reserva");
                    escolha = sc.nextInt();
                    switch (escolha) {
                        case 1 -> {
                            sc.nextLine();
                            hotelService.listarHoteis();
                            System.out.println("Escolha o hotel que deseja realizar a reserva:");
                            Integer hotel = sc.nextInt();
                            sc.nextLine();
                            quartoService.listarQuartoPorHotel(hotel);
                        }
                    }

                }
            }
        }
    }
}