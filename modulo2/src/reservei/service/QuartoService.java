package reservei.service;

import reservei.exceptions.DBException;
import reservei.model.Hotel;
import reservei.model.Quarto;
import reservei.repository.HotelRepository;
import reservei.repository.QuartoRepository;

public class QuartoService {

    private QuartoRepository quartoRepository;

    public QuartoService() {
        quartoRepository = new QuartoRepository();
    }

    public void listarQuartos() {
        try {
            quartoRepository.listar().forEach(System.out::println);
        } catch (DBException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    public void listarQuartoPorHotel(Integer id) {
        try {
            quartoRepository.listarQuartosPorHotel(id).forEach(System.out::println);
        } catch (DBException e) {
            System.out.println(e.getMessage());
        }
    }
    public Quarto quartoEscolhido(Integer id){
        try {
            Quarto quarto = quartoRepository.listarQuartosPorId(id).stream().findFirst().get();
            return quarto;
        }catch (DBException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
