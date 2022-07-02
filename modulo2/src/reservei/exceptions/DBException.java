package reservei.exceptions;

import java.sql.SQLException;

public class DBException extends SQLException {

    public DBException (String msg){
        super(msg);
    }

}
