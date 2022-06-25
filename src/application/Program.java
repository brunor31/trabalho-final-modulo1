package application;

import entities.*;

import java.text.ParseException;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Program {

    public static void main(String[] args) throws ParseException {

        Scanner sc = new Scanner(System.in);
        AtomicInteger n = new AtomicInteger();
        AdministrarReserva administrarReserva = new AdministrarReserva();
        Quarto quarto1 = new Quarto(101, 1, "Quarto Individual", true, 200.00, n.incrementAndGet());
        Quarto quarto2 = new Quarto(201, 2, "Suite", true, 300.00, n.incrementAndGet());
        Quarto quarto3 = new Quarto(301, 1, "Quarto Individual", true, 220.00, n.incrementAndGet());
        Quarto quarto4 = new Quarto(401, 2, "Suite", true, 350.00, n.incrementAndGet());
        Quarto quarto5 = new Quarto(501, 1, "Quarto Individual", true, 230.00, n.incrementAndGet());
        Quarto quarto6 = new Quarto(202, 2, "Suite", true, 400.00, n.incrementAndGet());
        Quarto quarto7 = new Quarto(105, 1, "Quarto Individual", true, 199.00, n.incrementAndGet());
        Quarto quarto8 = new Quarto(303, 2, "Suite", true, 360.00, n.incrementAndGet());
        Quarto quarto9 = new Quarto(404, 1, "Quarto Individual", true, 150.00, n.incrementAndGet());
        Quarto quarto10 = new Quarto(180, 1, "Quarto Individual", true, 200.00, n.incrementAndGet());
        Quarto quarto11 = new Quarto(119, 2, "Quarto Casal", true, 300.00, n.incrementAndGet());
        Quarto quarto12 = new Quarto(120, 2, "Quarto Casal Luxo", true, 450.00, n.incrementAndGet());
        ArrayList<Quarto> quartosHotel1 = new ArrayList<>();
        ArrayList<Quarto> quartosHotel2 = new ArrayList<>();
        ArrayList<Quarto> quartosHotel3 = new ArrayList<>();
        ArrayList<Quarto> quartosHotel4 = new ArrayList<>();
        Collections.addAll(quartosHotel1, quarto1, quarto2, quarto3);
        Collections.addAll(quartosHotel2, quarto4, quarto5, quarto6);
        Collections.addAll(quartosHotel3, quarto7, quarto8, quarto9);
        Collections.addAll(quartosHotel4, quarto10, quarto11, quarto12);
        Hotel hotel1 = new Hotel("Ibis", "Rio Grande do Sul", "Porto Alegre", "5135498100", 4, quartosHotel1, n.incrementAndGet());
        Hotel hotel2 = new Hotel("Light Aurora Resort", "Santa Catarina", "Florianópolis", "493541000", 5, quartosHotel2, n.incrementAndGet());
        Hotel hotel3 = new Hotel("Quality Suites", "São Paulo", "São Paulo", "1140112549", 3, quartosHotel3, n.incrementAndGet());
        Hotel hotel4 = new Hotel("Primme Hotel", "Rio de Janeiro", "Rio de Janeiro", "2136481111", 5, quartosHotel4, n.incrementAndGet());
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
                    System.out.println("Em qual região você deseja realizar uma reserva");
                    System.out.println("1: Região Sul");
                    System.out.println("2: Região Sudeste");
                    int selecionarRegiao = sc.nextInt();
                    sc.nextLine();
                    switch (selecionarRegiao) {
                        case 1 -> {
                            System.out.println("Em qual cidade você deseja realizar uma reserva: ");
                            System.out.println("1: Porto Alegre");
                            System.out.println("2: Florianópolis");
                        }
                        case 2 -> {
                            System.out.println("Em qual cidade você deseja realizar uma reserva: ");
                            System.out.println("3: São Paulo");
                            System.out.println("4: Rio de Janeiro");
                        }
                    }
                    int selecionarCidade = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Hotel Disponível: ");
                    final String [] result = {"Porto Alegre", "Florianópolis", "São Paulo", "Rio de Janeiro"};
                    switch (selecionarCidade){
                        case 1 -> {
                            List<Hotel> hotelDisponivelCidade = hoteis.stream().filter(hotel -> hotel.getCidade() == result[selecionarCidade - 1]).toList();
                            hotelDisponivelCidade.stream().forEach(System.out::println);
                            System.out.println();
                            System.out.print("Você deseja realizar a reserva? (s/n): ");
                            char reservar = sc.next().charAt(0);
                            if (reservar == 's') {
                                System.out.println();
                                System.out.println("Quartos Disponíveis: ");
                                System.out.println();
                                quartosHotel1.stream().forEach(System.out::println);
                            }
                            else {
                                break;
                            }
                            System.out.println();
                            System.out.print("Deseja continuar com a reserva: (s/n): ");
                            char continuar = sc.next().charAt(0);
                            if (continuar == 's'){
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
                                cliente.setId(n.incrementAndGet());
                                System.out.print("Digite o número do quarto que você deseja alugar: ");
                                int escolhaDoQuarto = sc.nextInt();
                                Optional<Quarto> meuQuarto = quartosHotel1.stream().
                                        filter(hotel -> hotel.getNumero().equals(escolhaDoQuarto)).
                                        findFirst();
                                meuQuarto.get();
                                Quarto novoQuarto = new Quarto();
                                System.out.println(meuQuarto);
                                System.out.print("Digite a data de entrada (dd/MM/yyyy): ");
                                String dataEntrada = sc.next();
                                System.out.print("Digite a data de saída (dd/MM/yyyy): ");
                                String dataSaida = sc.next();
                            }
                        }
                    }
                }
            }
        }

    }
}

/*
*/
