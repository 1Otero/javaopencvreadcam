package com.mycompany.opencvtest;
import org.opencv.core.*; 
import org.opencv.imgproc.Imgproc;
import org.opencv.objdetect.Objdetect;
// Importar paquetes OpenCV
import org.opencv.core.Mat.*;
import static org.opencv.highgui.HighGui.*;
import org.opencv.videoio.*; 
/**
 *
 * @author truji
 */
public class Opencvtest {
    static {
        System.load("C:/tools/opencv/build/java/x64/opencv_java460.dll");
    }
    public static void main(String[] args) {
        //System.setProperty("java.library.path", "C:/tools/opencv/build/java/x64");
        //System.setProperty("java.library.path", "C:/tools/opencv/build/java/x64/opencv_java460.dll");
        
         // Abrir la cámara default
        VideoCapture camera = new VideoCapture(0);  
    
    // Comprobar si se abrió correctamente
    if(!camera.isOpened()){
      System.out.println("Error al abrir la cámara");
      return;
    }
   
    // Crear objeto Mat para capturar los fotogramas
    Mat frame = new Mat();
   
    // Crear objeto VideoWriter para escribir el video
    VideoWriter video = new VideoWriter("mi_video.avi", VideoWriter.fourcc('M','J','P','G'), 
                                        30, new Size(640,480), true);
   
    // Capturar y escribir los fotogramas en un ciclo 
    while(true){
     
      // Leer siguiente fotograma de la cámara
      camera.read(frame);
       
      // Escribir fotograma al video  
      video.write(frame); 
       
      // Mostrar preview del video 
      imshow("Video", frame);
   
      // Salir al presionar la tecla 'q'
      if(waitKey(1) == 'q') break;
    }
   
    // Liberar recursos  
    camera.release();
    video.release(); 
    }
}
