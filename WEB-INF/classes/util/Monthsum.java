package util;
import java.sql.*;

public class Monthsum{
    private String name;
    private Double y;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getY() {
        return y;
    }

    public void setY(Double y) {
        this.y = y;
    }

    public Monthsum(ResultSet result){
        try{
            this.name=result.getString("m1");
            this.y=result.getDouble("s");
        }
        catch(Exception e){

        }
    }
}
/*package util;
import java.sql.*;

public class Monthsum{
	private String name;
	private Double y;
	public Monthsum(ResultSet result){
		try{
			this.name=result.getString("m1");
			this.y=result.getDouble("s");
		}
		catch(Exception e){

		}
	}
	}*/
