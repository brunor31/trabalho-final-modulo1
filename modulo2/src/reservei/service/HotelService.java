package reservei.service;

import reservei.exceptions.DBException;
import reservei.model.Hotel;
import reservei.repository.HotelRepository;

public class HotelService {

    private HotelRepository hotelRepository;

    public HotelService() {
        hotelRepository = new HotelRepository();
    }

    public void adicionarHotel(Hotel hotel) {
        try {
            if (hotel.getTelefone().length() > 14) {
                throw new DBException("Você inseriu um telefone inválido, digite novamente:");
            }
            if ((hotel.getClassificacao() < 1) || ((hotel.getClassificacao() > 5))) {
                throw new Exception("Você digitou um valor inválido");
            }
            hotelRepository.adicionar(hotel);
            System.out.println("Hotel adicionado com sucesso!");
        } catch (DBException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void listarHoteis() {
        try {
            hotelRepository.listar().forEach(System.out::println);
        } catch (DBException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void editarHotel(Integer indice, Hotel hotel) {
        try {
            boolean deuCerto = hotelRepository.editar(indice, hotel);
            System.out.println("Edição concluída? " + deuCerto + "| com id=" + indice);
        } catch (DBException e) {
            System.out.println(e.getMessage());
        }
    }

    public void removerHotel(Integer id) {
        try {
            boolean deuCerto = hotelRepository.remover(id);
            System.out.println("Hotel excluído com sucesso? " + deuCerto + "| com id=" + id);
        } catch (DBException e) {
            System.out.println(e.getMessage());
        }
    }

    public void listarQuartosHotel(Hotel hotel){
        hotel.getQuartos().forEach(System.out::println);
    }
}
