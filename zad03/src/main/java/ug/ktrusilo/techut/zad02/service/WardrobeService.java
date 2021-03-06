package ug.ktrusilo.techut.zad02.service;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import ug.ktrusilo.techut.zad02.domain.Wardrobe;

public class WardrobeService {

	private final String URL = "jdbc:hsqldb:hsql://localhost/workdb";
    private final Connection connection;
    private final Statement statement;
    private final String CREATE_TABLE_SQL = "CREATE TABLE Wardrobe (id bigint GENERATED BY DEFAULT AS IDENTITY, name VARCHAR(25), weight DOUBLE, productionDate DATE, isWood BOOLEAN)";
    private boolean tableExists = false;
    
    private PreparedStatement addWardrobeStmt;
    private PreparedStatement getAllWardrobesStmt;
    private PreparedStatement getWardrobeByIdStmt;
    private PreparedStatement deleteAllWardrobesStmt;
    private PreparedStatement deleteWardrobeByIdStmt;
    private PreparedStatement getWardrobesHeavierThanStmt;

    public WardrobeService() throws SQLException {
        connection = DriverManager.getConnection(URL);
        statement = connection.createStatement();

        ResultSet rs = connection.getMetaData().getTables(null, null, null, null);

        while (rs.next()) {
            if ("Wardrobe".equalsIgnoreCase(rs.getString("table_name"))) {
                tableExists = true;
                break;
            }
        }

        if (!tableExists) {
            statement.executeUpdate(CREATE_TABLE_SQL);
        }
        
        addWardrobeStmt = connection.prepareStatement("INSERT INTO Wardrobe (name, weight, productionDate, isWood) VALUES (?,?,?,?)");
        getAllWardrobesStmt = connection.prepareStatement("SELECT * FROM Wardrobe");
        getWardrobeByIdStmt = connection.prepareStatement("SELECT * FROM Wardrobe WHERE ID=?");
        deleteAllWardrobesStmt = connection.prepareStatement("DELETE FROM Wardrobe");
        deleteWardrobeByIdStmt = connection.prepareStatement("DELETE FROM Wardrobe WHERE ID=?");
        getWardrobesHeavierThanStmt = connection.prepareStatement("SELECT * FROM Wardrobe WHERE WEIGHT > ?");
    }
    
    public void addWardrobe(Wardrobe wardrobe) {
    	try {
    		addWardrobeStmt.setString(1, wardrobe.getName());
    		addWardrobeStmt.setDouble(2, wardrobe.getWeight());
    		addWardrobeStmt.setDate(3, wardrobe.getProductionDate());
    		addWardrobeStmt.setBoolean(4, wardrobe.isWood());
    		
    		addWardrobeStmt.executeUpdate();
    	}
    	catch (SQLException e) {
    		e.printStackTrace();
    	}
    }
    
    public List<Wardrobe> getAllWardrobes() {
    	List<Wardrobe> wardrobes = new ArrayList<Wardrobe>();
    	try {
    		ResultSet rs = getAllWardrobesStmt.executeQuery();
    		
    		while (rs.next() ) {
    			Wardrobe newWardrobe = new Wardrobe(rs.getString("name"),
    					rs.getDouble("weight"), rs.getDate("productionDate"), rs.getBoolean("isWood"));
    			wardrobes.add(newWardrobe);
    		}
    	}
    	catch (SQLException e) {
    		e.printStackTrace();
    	}
    	
    	return wardrobes;
    }
    
    public Wardrobe getWardrobeById(int id) {
		Wardrobe newWardrobe = new Wardrobe();
    	try {
    		getWardrobeByIdStmt.setInt(1, id);
    		ResultSet rs = getWardrobeByIdStmt.executeQuery();
    		
    		while (rs.next()) {
    			newWardrobe = new Wardrobe(rs.getString("name"),
    					rs.getDouble("weight"), rs.getDate("productionDate"), rs.getBoolean("isWood"));
    		}
    	}
    	catch (SQLException e) {
    		e.printStackTrace();
    	}
    	
    	return newWardrobe;
    }
    
    public void deleteAllWardrobes() {
    	try {
    		deleteAllWardrobesStmt.executeUpdate();
    	}
    	catch (SQLException e) {
    		e.printStackTrace();
    	}
    }
    
    public void deleteWardrobeById(int id) {
    	try {
    		deleteWardrobeByIdStmt.setInt(1, id);
    		deleteWardrobeByIdStmt.executeUpdate();
    	}
    	catch (SQLException e) {
    		e.printStackTrace();
    	}
}
   

	public boolean addWardrobes(List<Wardrobe> wardrobes) {
		try {
            connection.setAutoCommit(false);

            for (Wardrobe wardrobe : wardrobes) {
            	addWardrobeStmt.setString(1, wardrobe.getName());
        		addWardrobeStmt.setDouble(2, wardrobe.getWeight());
        		addWardrobeStmt.setDate(3, wardrobe.getProductionDate());
        		addWardrobeStmt.setBoolean(4, wardrobe.isWood());

        		addWardrobeStmt.executeUpdate();
            }

            connection.commit();

            return true;
        } catch (SQLException e) {
            System.out.println("Rollback");
            try {
                connection.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }

        return false;
    }
    
    
	public List<Wardrobe> getWardrobesHeavierThan(double weight) {
		List<Wardrobe> wardrobes = new ArrayList<Wardrobe>();
    	try {
    		getWardrobesHeavierThanStmt.setDouble(1, weight);
    		ResultSet rs = getWardrobesHeavierThanStmt.executeQuery();
    		
    		while (rs.next() ) {
    			Wardrobe newWardrobe = new Wardrobe(rs.getString("name"),
    					rs.getDouble("weight"), rs.getDate("productionDate"), rs.getBoolean("isWood"));
    			wardrobes.add(newWardrobe);
    		}
    	}
    	catch (SQLException e) {
    		e.printStackTrace();
    	}
    	
    	return wardrobes;
	}
}
    
