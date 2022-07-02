package reservei.service;

import reservei.exceptions.DBException;
import reservei.model.Hotel;
import reservei.repository.HotelRepository;

import java.util.Scanner;

public class HotelService {

    private HotelRepository hotelRepository;

    public HotelService() {
        hotelRepository = new HotelRepository();
    }

    public void adicionarHotel() {
        try {
            Scanner sc = new Scanner(System.in);
            System.out.println("Nome: ");
            String nome = sc.nextLine();
            System.out.println("Cidade: ");
            String cidade = sc.nextLine();
            System.out.println("Telefone: (exp: DDD+Número)");
            String telefone = sc.nextLine();
            sc.nextLine();
            while (telefone.length() > 14){
                throw new DBException("Você digitou um telefone inválido, digite novamente: ");
            }
            System.out.println("Classificação: (1 a 5)");
            Integer classificacao = sc.nextInt();
            sc.nextLine();
            if ((classificacao < 1) || (classificacao > 5)) {
                throw new DBException("Você digitou uma classificação inválida, digite novamente um valor entre 1 e 5: ");
            }
            Hotel hotel = new Hotel(nome, cidade, telefone, classificacao);
            hotelRepository.adicionar(hotel);
            System.out.println("Hotel adicionado com sucesso!");
        } catch (DBException e) {
            System.out.println(e.getMessage());
        }
    }
}
