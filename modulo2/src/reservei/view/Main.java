package reservei.view;

import reservei.service.HotelService;

import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        HotelService hotelService = new HotelService();
        hotelService.adicionarHotel();

    }
}
