package reservei.view;

import reservei.enums.TipoReserva;
import reservei.model.*;
import reservei.service.ClienteService;
import reservei.service.HotelService;
import reservei.service.QuartoService;
import reservei.service.ReservaService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ParseException {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        HotelService hotelService = new HotelService();
        QuartoService quartoService = new QuartoService();
        ClienteService clienteService = new ClienteService();
        ReservaService reservaService = new ReservaService();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        int opcao = 0;
        while (opcao != 4) {
            System.out.println("1: Menu Hotel");
            System.out.println("2: Menu Cliente");
            System.out.println("3: Menu Reserva");
            System.out.println("4: Sair");
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
                            int id = sc.nextInt();
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

                            clienteService.editarCliente(id, clienteEditado);
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
                            System.out.println("1: Porto Alegre");
                            System.out.println("2: Florianópolis");
                            System.out.println("3: São Paulo");
                            System.out.println("4: Rio de Janeiro");
                            System.out.println();
                            System.out.println("Digite o nome da cidade que dejesa efetuar a reserva:");
                            String cidade = sc.nextLine();
                            hotelService.listarHotelPorCidade(cidade);
                            System.out.println("Escolha o hotel que deseja realizar a reserva pelo Id:");
                            Integer hotel = sc.nextInt();
                            sc.nextLine();
                            quartoService.listarQuartoPorHotel(hotel);
                            System.out.println("Escolha o quarto que deseja realizar a reserva:");
                            Integer quarto = sc.nextInt();
                            sc.nextLine();
                            System.out.println("Você já possui cadastro no site? (s/n)");
                            char resposta = sc.next().charAt(0);
                            if (resposta == 'n') {
                                Cliente cliente = new Cliente();
                                sc.nextLine();
                                System.out.println("Digite o nome:");
                                cliente.setNome(sc.nextLine());

                                System.out.println("Digite o CPF:");
                                String cpf = sc.next();
                                cliente.setCpf(cpf);

                                sc.nextLine();
                                System.out.println("Digite o telefone: (DDD+Número)");
                                cliente.setTelefone(sc.nextLine());

                                System.out.println("Digite o email:");
                                cliente.setEmail(sc.nextLine());

                                System.out.println("Digite a senha:");
                                cliente.setSenha(sc.nextLine());

                                clienteService.adicionarCliente(cliente);

                                Hotel hotelReserva = hotelService.hotelEscolhido(hotel);
                                Quarto quartoReserva = quartoService.quartoEscolhido(quarto);
                                Cliente clienteReserva = clienteService.clienteEscolhido(cpf);

                                System.out.println("Digite a data de entrada (dd/MM/yyyy)");
                                String dataEntrada = sc.next();
                                System.out.println("Digite a data de saída: (dd/MM/yyyy)");
                                String dataSaida = sc.next();

                                System.out.println("Você possui desconto para assinantes premium? (s/n)");
                                char clientePremium = sc.next().charAt(0);

                                if (clientePremium == 's'){
                                    ReservaPremium reservaPremium = new ReservaPremium();
                                    reservaPremium.setHotel(hotelReserva);
                                    reservaPremium.setQuarto(quartoReserva);
                                    reservaPremium.setCliente(clienteReserva);
                                    reservaPremium.setDataEntrada(LocalDate.parse(dataEntrada, formatter));
                                    reservaPremium.setDataSaida(LocalDate.parse(dataSaida, formatter));
                                    reservaPremium.setTipo(TipoReserva.RESERVA_PREMIUM);
                                    reservaService.adicionarReserva(reservaPremium);
                                    System.out.println(reservaPremium);

                                } else if (resposta == 'n') {
                                    Reserva reserva = new Reserva();
                                    reserva.setHotel(hotelReserva);
                                    reserva.setQuarto(quartoReserva);
                                    reserva.setCliente(clienteReserva);
                                    reserva.setDataEntrada(LocalDate.parse(dataEntrada, formatter));
                                    reserva.setDataSaida(LocalDate.parse(dataSaida, formatter));
                                    reserva.setTipo(TipoReserva.RESERVA_COMUM);
                                    reservaService.adicionarReserva(reserva);
                                }
                            }else if (resposta == 's'){
                                System.out.println("Digite seu CPF:");
                                String cpf=sc.next();
                                System.out.println("Digite sua senha:");
                                String senha = sc.next();
                                clienteService.validarCliente(senha,cpf);
                                Hotel hotelReserva=hotelService.hotelEscolhido(hotel);
                                Quarto quartoReserva=quartoService.quartoEscolhido(quarto);
                                Cliente clienteReserva=clienteService.clienteEscolhido(cpf);
                                System.out.println("Digite a data de entrada (dd/MM/yyyy)");
                                String dataEntrada=sc.next();
                                System.out.println("Digite a data de saída: (dd/MM/yyyy)");
                                String dataSaida=sc.next();
                                System.out.println("Você possui desconto para assinantes premium? (s/n)");
                                char clientePremium = sc.next().charAt(0);

                                if (clientePremium == 's'){
                                    ReservaPremium reservaPremium = new ReservaPremium();
                                    reservaPremium.setHotel(hotelReserva);
                                    reservaPremium.setQuarto(quartoReserva);
                                    reservaPremium.setCliente(clienteReserva);
                                    reservaPremium.setDataEntrada(LocalDate.parse(dataEntrada, formatter));
                                    reservaPremium.setDataSaida(LocalDate.parse(dataSaida, formatter));
                                    reservaPremium.setTipo(TipoReserva.RESERVA_PREMIUM);
                                    reservaService.adicionarReserva(reservaPremium);

                                } else if (resposta == 'n') {
                                    Reserva reserva = new Reserva();
                                    reserva.setHotel(hotelReserva);
                                    reserva.setQuarto(quartoReserva);
                                    reserva.setCliente(clienteReserva);
                                    reserva.setDataEntrada(LocalDate.parse(dataEntrada, formatter));
                                    reserva.setDataSaida(LocalDate.parse(dataSaida, formatter));
                                    reserva.setTipo(TipoReserva.RESERVA_COMUM);
                                    reservaService.adicionarReserva(reserva);
                                }
                            }
                        }
                        case 2 -> {

                            System.out.println("Digite seu CPF:");
                            String cpf = sc.next();
                            reservaService.imprimirReserva(cpf);

                        }
                        case 3 -> {

                            System.out.println("Digite seu CPF:");
                            String cpf = sc.next();
                            reservaService.imprimirReserva(cpf);
                            System.out.println("Digite o Id da Reserva que você deseja editar:");
                            Integer id = sc.nextInt();

                            Reserva reserva = new Reserva();

                            System.out.println("Digite a data de entrada (dd/MM/yyyy)");
                            String dataEntrada=sc.next();

                            System.out.println("Digite a data de saída: (dd/MM/yyyy)");
                            String dataSaida=sc.next();

                            reserva.setDataEntrada(LocalDate.parse(dataEntrada, formatter));
                            reserva.setDataSaida(LocalDate.parse(dataSaida, formatter));

                            reservaService.editarReserva(id, reserva);

                        }
                        case 4 -> {

                            System.out.println("Digite seu CPF:");
                            String cpf = sc.next();
                            reservaService.imprimirReserva(cpf);
                            System.out.println("Digite o Id da Reserva que você deseja excluir:");
                            Integer id = sc.nextInt();
                            reservaService.excluirReserva(id);

                        }
                    }

                }
            }
        }
    }
}
