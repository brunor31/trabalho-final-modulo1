package reservei.enums;

import java.util.Arrays;

public enum TipoQuarto {

    QUARTO_SOLTEIRO(1),
    QUARTO_CASAL(2);

    private Integer type;

    TipoQuarto(Integer tipo) {
        this.type = tipo;
    }
    public Integer getType(){
        return type;
    }

    public static TipoQuarto ofType(Integer tipo){
        return Arrays.stream(TipoQuarto.values())
                .filter(tp -> tp.getType().equals(tipo))
                .findFirst()
                .get();
    }

}
