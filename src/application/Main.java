package application;

import entities.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {

    public static void main(String[] args) throws ParseException {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        AtomicInteger id = new AtomicInteger();
        ManipularReserva manipularReserva = new ManipularReserva();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Quarto quarto1 = new Quarto(101, "Solteiro", true, 200.00, id.incrementAndGet());
        Quarto quarto2 = new Quarto(201, "Casal", true, 300.00, id.incrementAndGet());
        Quarto quarto3 = new Quarto(102, "Solteiro", true, 220.00, id.incrementAndGet());
        Quarto quarto4 = new Quarto(202, "Casal", true, 350.00, id.incrementAndGet());
        Quarto quarto5 = new Quarto(103, "Solteiro", true, 230.00, id.incrementAndGet());
        Quarto quarto6 = new Quarto(203, "Casal", true, 400.00, id.incrementAndGet());
        Quarto quarto7 = new Quarto(104, "Solteiro", true, 199.00, id.incrementAndGet());
        Quarto quarto8 = new Quarto(204, "Casal", true, 360.00, id.incrementAndGet());
        Quarto quarto9 = new Quarto(105, "Solteiro", true, 150.00, id.incrementAndGet());
        Quarto quarto10 = new Quarto(205, "Casal", true, 500.00, id.incrementAndGet());
        Quarto quarto11 = new Quarto(106, "Solteiro", true, 300.00, id.incrementAndGet());
        Quarto quarto12 = new Quarto(206, "Casal", true, 450.00, id.incrementAndGet());
        ArrayList<Quarto> quartosHotel1 = new ArrayList<>();
        ArrayList<Quarto> quartosHotel2 = new ArrayList<>();
        ArrayList<Quarto> quartosHotel3 = new ArrayList<>();
        ArrayList<Quarto> quartosHotel4 = new ArrayList<>();
        Collections.addAll(quartosHotel1, quarto1, quarto2, quarto3);
        Collections.addAll(quartosHotel2, quarto4, quarto5, quarto6);
        Collections.addAll(quartosHotel3, quarto7, quarto8, quarto9);
        Collections.addAll(quartosHotel4, quarto10, quarto11, quarto12);
        Hotel hotel1 = new Hotel("Ibis", "Porto Alegre", "5135498100", 4, quartosHotel1, id.decrementAndGet());
        Hotel hotel2 = new Hotel("Light Aurora Resort", "Florianópolis", "493541000", 5, quartosHotel2, id.incrementAndGet());
        Hotel hotel3 = new Hotel("Quality Suites", "São Paulo", "1140112549", 3, quartosHotel3, id.incrementAndGet());
        Hotel hotel4 = new Hotel("Primme Hotel", "Rio de Janeiro", "2136481111", 5, quartosHotel4, id.incrementAndGet());
        ArrayList<Hotel> hoteis = new ArrayList<>();
        Collections.addAll(hoteis, hotel1, hotel2, hotel3, hotel4);
        ArrayList<Quarto> quartos = new ArrayList<>();
        Collections.addAll(quartos, quarto1, quarto2, quarto3, quarto4, quarto5, quarto6, quarto7, quarto8, quarto9, quarto10, quarto11, quarto12);
        int opcao = 0;
        while (opcao != 5) {
            System.out.println("Digite 1 para criar reserva");
            System.out.println("Digite 2 para listar reserva");
            System.out.println("Digite 3 para modificar reserva");
            System.out.println("Digite 4 para cancelar reserva");
            System.out.println("Digite 5 para sair");
            opcao = sc.nextInt();
            sc.nextLine();
            switch (opcao) {
                case 1 -> {
                    System.out.println("Em qual cidade você deseja realizar uma reserva: ");
                    System.out.println("1: Porto Alegre");
                    System.out.println("2: Florianópolis");
                    System.out.println("3: São Paulo");
                    System.out.println("4: Rio de Janeiro");
                    System.out.println();
                    System.out.print("Escolha a cidade: ");
                    int escolhaCidade = sc.nextInt();
                    sc.nextLine();
                    final String[] result = {"Porto Alegre", "Florianópolis", "São Paulo", "Rio de Janeiro"};
                    List<Hotel> hotelDisponivelCidade = hoteis.stream().filter(hotel -> hotel.getCidade() == result[escolhaCidade - 1]).toList();
                    System.out.println();
                    System.out.println("Hotel Disponível");
                    hotelDisponivelCidade.stream().forEach(System.out::println);
                    System.out.println();
                    System.out.print("Você deseja realizar a reserva? (s/n): ");
                    char reservar = sc.next().charAt(0);
                    if (reservar == 's') {
                        System.out.println();
                        System.out.println("Quartos Disponíveis: ");
                        System.out.println();
                        List<Quarto> quartoHotel = hotelDisponivelCidade.get(0).getQuartos();
                        quartoHotel.stream().forEach(System.out::println);
                    }
                    System.out.println();
                    System.out.print("Deseja continuar com a reserva: (s/n): ");
                    char continuar = sc.next().charAt(0);
                    Hotel hotelEscolhido = new Hotel();
                    if (continuar == 's') {
                        List<Hotel> listaHoteis = hoteis.stream().
                                filter(hotel -> hotel.getCidade() == result[escolhaCidade - 1]).toList();
                        listaHoteis.forEach(hotel -> {
                            hotelEscolhido.setNome(hotel.getNome());
                            hotelEscolhido.setCidade(hotel.getCidade());
                            hotelEscolhido.setTelefone(hotel.getTelefone());
                            hotelEscolhido.setClassificacao(hotel.getClassificacao());
                            hotelEscolhido.setQuartos(hotel.getQuartos());
                            hotelEscolhido.setIdHotel(hotel.getIdHotel());
                        });
                        Cliente cliente = new Cliente();
                        sc.nextLine();
                        System.out.print("Digite o nome: ");
                        cliente.setNome(sc.nextLine());
                        System.out.print("Digite o cpf: ");
                        cliente.setCpf(sc.nextLine());
                        System.out.print("Digite o telefone para contato: ");
                        cliente.setTelefone(sc.nextLine());
                        System.out.print("Digite o email: ");
                        cliente.setEmail(sc.nextLine());
                        cliente.setId(id.incrementAndGet());
                        System.out.print("Digite o número do quarto que você deseja alugar: ");
                        int escolhaDoQuarto = sc.nextInt();
                        List<Quarto> meuQuarto = quartos.stream().
                                filter(hotel -> hotel.getNumero().equals(escolhaDoQuarto)).toList();
                        Quarto novoQuarto = new Quarto();
                        meuQuarto.forEach(quarto -> {
                            novoQuarto.setIdQuarto(quarto.getIdQuarto());
                            novoQuarto.setNumero(quarto.getNumero());
                            novoQuarto.setTipo(quarto.getTipo());
                            novoQuarto.setDisponibilidade(quarto.isDisponibilidade());
                            novoQuarto.setPrecoDiaria(quarto.getPrecoDiaria());
                        });
                        System.out.print("Digite a data de entrada (dd/MM/yyyy): ");
                        Date dataEntrada = sdf.parse(sc.next());
                        System.out.print("Digite a data de saída (dd/MM/yyyy): ");
                        Date dataSaida = sdf.parse(sc.next());
                        Reserva reserva = new Reserva(hotelEscolhido, novoQuarto, cliente, dataEntrada, dataSaida, id.incrementAndGet());
                        System.out.println();
                        System.out.println("Reserva concluida com sucesso!");
                        reserva.imprimirReserva();
                        System.out.println();
                        manipularReserva.processarReserva(reserva);
                    }
                }
                case 2 -> {
                    System.out.print("Digite seu CPF: ");
                    String cpf = sc.next();
                    manipularReserva.imprimirReserva(cpf);
                }
                case 3 -> {
                    System.out.print("Digite seu CPF: ");
                    String cpf = sc.next();

                }
                case 4 -> {
                    System.out.print("Digite seu CPF: ");
                    String cpf = sc.next();
                    manipularReserva.cancelarReserva(cpf);
                    System.out.println("Reserva cancelada com sucesso!");
                }
            }
        }
    }
}