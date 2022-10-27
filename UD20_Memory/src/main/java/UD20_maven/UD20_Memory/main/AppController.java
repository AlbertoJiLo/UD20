package UD20_maven.UD20_Memory.main;

import javafx.scene.image.*;
import javafx.scene.layout.GridPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.Node;
import javafx.animation.Timeline;
import javafx.util.Duration;
import javafx.scene.text.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.concurrent.TimeUnit;

import javax.swing.JOptionPane;

import javafx.fxml.*;

//Controlador del juego
public class AppController {

	//Grid para poner las cartas
	@FXML
	public GridPane matrix;
	
	//Array que nos servira para saber donde estan las cartas
	private String imagenes[] = new String[16];
	
	//Estas son variables para controlar las cartas giradas y la situacion del juego
	private boolean firstCartFlip = false;
	private boolean secondCartFlip = false;
	private int rememberFirstPosition = 0;
	private int rememberSecondPosition = 0;
	private int parejasEncontradas = 0;
	
	//Esto nos permitira ir editando el texto que se muestra en la ventana
	@FXML
	public Text fallosText;
	private int fallos = 0;
	
	//Se inicializa
	@FXML
	public void initialize() throws FileNotFoundException {
		
		//Ponemos el texto en la ventana por defecto
		fallosText.setText("Fallos: 0");
		
		//Hacemos un contador para saber que hay una pareja de cada
		int countav = 0;
		int countbr = 0;
		int countce = 0;
		int countel = 0;
		int countma = 0;
		int countmo = 0;
		int countmu = 0;
		int counttib = 0;
		
		//La i controlará que esten todas las cartas rellenas
		int i = 0;
		
		//Metemos de manera aleatoria y sin repetir las cartas
		do {
		
			int num = (int)Math.floor(Math.random() * (8));
			
			if (num == 0 && countav != 2) {
				
				//El string funciona para llamar a las imagenes de las cartas
				imagenes[i] = "av";
				countav++;
				
			} else if (num == 1 && countbr != 2) {
				
				imagenes[i] = "br";
				countbr++;
				
			} else if (num == 2 && countce != 2) {
				
				imagenes[i] = "ce";
				countce++;
				
			} else if (num == 3 && countel != 2) {
				
				imagenes[i] = "el";
				countel++;
				
			} else if (num == 4 && countma != 2) {
				
				imagenes[i] = "ma";
				countma++;
				
			} else if (num == 5 && countmo != 2) {
				
				imagenes[i] = "mo";
				countmo++;
				
			} else if (num == 6 && countmu != 2) {
				
				imagenes[i] = "mu";
				countmu++;
				
			} else if (num == 7 && counttib != 2) {
				
				imagenes[i] = "tib";
				counttib++;
				
			}
			
			i = countav + countbr + countce + countel + countma + countmo + countmu + counttib;
			
		} while (i != 16);
		
		//Creamos el grid, aparte de definir el tamaño del grid en el main.fxml, también lo añadimos aqui para que se visualice como queremos
		for (int row = 0; row < 4; row++) {
			
			for (int col = 0; col < 4; col++) {
				
				//Ponemos la imagen de la parte posterior de la carta
				FileInputStream	inputcart = new FileInputStream("src/main/resources/images/cart.png");
				Image imagecart = new Image(inputcart);
				ImageView cartView = new ImageView(imagecart);
				
				//Ponemos la medida que le hemos dado
				cartView.setFitWidth(160);
				cartView.setFitHeight(160);
				
				//Ponemos como "ID" la posicion en la que se encuentra si fuera un array de un solo vector
				cartView.setUserData((row*4)+col);
				
				//Creamos un evento para cada carta que llamara a las funciones que administraran el juego
				cartView.setOnMouseClicked(event -> {
					try {
						cardListener(event);
					} catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				});
				
				//Por último, añadimos la carta a la matriz en la posición correspondiente para que se vea
				matrix.add(cartView, row, col);
				
			}
			
		}
		
	}
	
	//Este es el metodo que hace girar la carta
	private void cardListener(MouseEvent event) throws FileNotFoundException {
		
		//Agarra el recurso que ha sido clicado
		Node sourceComponent = (Node)event.getSource();
		
		//Pillo el ID
		int position = (Integer)sourceComponent.getUserData();
		
		//Muesto la imagen que és
		FileInputStream inputcontent = new FileInputStream("src/main/resources/images/"+ imagenes[position] +".png");
		
		Image imagecontent = new Image(inputcontent);
		((ImageView)sourceComponent).setImage(imagecontent);
		
		//Compruebo como va el juego
		checkCartMatching(position);
		
	}
	
	//Este es el mismo metodo que el anterior pero ya sabiendo el objeto
	private void cardListener(int position) throws FileNotFoundException {
		
		//Muesto la imagen que és
		FileInputStream inputcontent = new FileInputStream("src/main/resources/images/"+ imagenes[position] +".png");
		
		Image imagecontent = new Image(inputcontent);
		((ImageView)matrix.getChildren().get(position)).setImage(imagecontent);
		
		//Compruebo como va el juego
		checkCartMatching(position);
		
	}

	private void checkCartMatching(int position) throws FileNotFoundException {
		
		//Si no hay carta girada, la gira y guarda su posicion
		if (!firstCartFlip) {
			
			firstCartFlip = true;
			rememberFirstPosition = position;
		
		//Si no hay segunda carta girada todavia entramos aqui girandola
		} else if (!secondCartFlip && (position != rememberFirstPosition)) {
			
			secondCartFlip = true;
			
			//Comprobamos si no son iguales
			if (!imagenes[position].equals(imagenes[rememberFirstPosition])) {
					
				//Simplemente sumamos en el contador que a fallado, guadando la posicion de la segunda carta para despues girarla
				rememberSecondPosition = position;
				fallos++;
				fallosText.setText("Fallos: " + fallos);

			//Si no coincide con la primera carta girada y tiene el mismo valor significará que a acertado
			} else if (position != rememberFirstPosition && imagenes[position].equals(imagenes[rememberFirstPosition])) {
					
				//Quitamos el listener de esas cartas
				((ImageView)matrix.getChildren().get(rememberFirstPosition)).setOnMouseClicked(null);
				((ImageView)matrix.getChildren().get(position)).setOnMouseClicked(null);
				
				//Ponemos que no hay ninguna carta girada para volver a comenzar y sumamos 1 a las parejas encontradas
				firstCartFlip = false;
				secondCartFlip = false;
				parejasEncontradas++;
				
				//Una vez ya estan todas, sale el pop-up diciendonos que hemos completado el juego con x fallos
				if (parejasEncontradas == 8) {
					
					JOptionPane.showMessageDialog(null, "¡Felicidades, has acabado el juego con " + fallos + " fallos!");
					
				}
				
			}
			
		//En caso de que las dos cartas esten giradas, es decir que la pareja seleccionada no coincide, pasamos a este condicional
		} else if (firstCartFlip && secondCartFlip) {
			
			//Creamos dos FileInputStream con la imagen posterior de la carta para el par de cartas que estan giradas de forma erronea
			//Se hace dos veces porque, al parecer, al llamarlo otra vez despues de haber sido llamado, se a consumido la imagen
			FileInputStream	inputcart = new FileInputStream("src/main/resources/images/cart.png");
			((ImageView)matrix.getChildren().get(rememberFirstPosition)).setImage(new Image(inputcart));
			FileInputStream	inputcart2 = new FileInputStream("src/main/resources/images/cart.png");
			((ImageView)matrix.getChildren().get(rememberSecondPosition)).setImage(new Image(inputcart2));
			
			//Ponemos ambos en false para volver a hacer el condicional
			firstCartFlip = false;
			secondCartFlip = false;

			cardListener(position);

			
		}
		
	}
	
}
