package com.martin;

import javafx.application.Application;
import javafx.stage.Stage;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class Principal extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Connection conexion = null;
        try {
            String ciudad = "Paris";
            conexion = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/test", "sa", "");

            Map<String, Object> parametros = new HashMap<>();
            parametros.put("CIUDAD", ciudad);
            JasperPrint print = JasperFillManager.fillReport(getClass().getResourceAsStream("/com/martin/Informes/Clientes.jasper"), parametros, conexion);
            JasperExportManager.exportReportToPdfFile(print, "informes\\informePrueba.pdf");

        }catch(SQLException e){
            e.printStackTrace();
        }
     /*   System.out.println(conexion);
        VBox vBox = new VBox();
        Scene scene = new Scene(vBox);
        stage.setScene(scene);
        stage.show();*/
    }
}
