/************************************************************************
 *
 * Copyright (C) 2010 - 2012
 *
 * [ApplicationLauncher.java]
 * AHCP Project (http://jacp.googlecode.com)
 * All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at 
 *
 *     http://www.apache.org/licenses/LICENSE-2.0 
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an "AS IS"
 * BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either 
 * express or implied. See the License for the specific language
 * governing permissions and limitations under the License.
 *
 *
 ************************************************************************/
package UD20_maven.UD20_Memory.main;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;

import java.awt.GridLayout;
import java.io.IOException;
import java.net.URL;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.jacpfx.rcp.util.LayoutUtil.GridPaneUtil;
import org.jacpfx.rcp.workbench.FXWorkbench;
import org.jacpfx.spring.launcher.AFXSpringJavaConfigLauncher;
import UD20_maven.UD20_Memory.config.BasicConfig;
import UD20_maven.UD20_Memory.workbench.JacpFXWorkbench;

/**
 * The application launcher containing the main method, the workbench definition, the configuration class and the packages to scan
 *
 * @author Andy Moncsek
 */
//Importadas las dependencias de JavaFX para el memory
public class ApplicationLauncher extends AFXSpringJavaConfigLauncher {

    /**
     * @param args
     */
    @Override
    public void start(Stage stage) throws IOException {
    	
    	//Lee el archivo .fxml que mostrará el maquetado de la pantalla que queremos ver y lo carga
    	URL url = new File("src/main/java/UD20_maven/UD20_Memory/main/main.fxml").toURI().toURL();
    	Parent root = FXMLLoader.load(url);
    	Scene scene = new Scene(root);
    	
    	//Una vez leido ponemos los parametros que queramos en la ventana que se va a mostrar
    	stage.setTitle("Memory");
    	stage.setWidth(800);
    	stage.setHeight(800);
    	
    	//Ponemos la escena, que es la llamada a AppController.java
    	stage.setScene(scene);
    	
    	//Mostrar la ventana
    	stage.show();
    	
    }
    
    public static void main(String[] args) {
    	
    	launch();
        //Application.launch(args)
    }

    @Override
    public void postInit(Stage stage) {
        Scene scene = stage.getScene();
        // add style sheet
        scene.getStylesheets().addAll(
                ApplicationLauncher.class.getResource("/styles/default.css")
                        .toExternalForm()
        );
    }

    @Override
    protected Class<?>[] getConfigClasses() {
        return new Class<?>[]{BasicConfig.class};
    }

	@Override
	protected Class<? extends FXWorkbench> getWorkbenchClass() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected String[] getBasePackages() {
		// TODO Auto-generated method stub
		return null;
	}
}
