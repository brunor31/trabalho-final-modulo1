package reservei.service;

import reservei.exceptions.DBException;
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
}
