package reservei.view;

import reservei.model.Hotel;
import reservei.service.HotelService;

import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        HotelService hotelService = new HotelService();
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
            }
        }

    }
}
