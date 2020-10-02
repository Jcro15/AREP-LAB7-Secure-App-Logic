package edu.escuelaing.arep;


import com.google.gson.Gson;

import static spark.Spark.*;

public class SparkWebApp {

   /**
    *  Función encargada de inicializar la aplicación, contiene la implementación de los endpoints usando el micro
     *  framework Spark, implementa una conexión por canal seguro
     * @param args args
     */
    public static void main(String[] args) {
        port(getPort());
        secure("keystores/ecikeystore.p12","123456","keystores/myTrustStore","567890");
        Gson gson=new Gson();
        get("/service",(request, response) -> "Respuesta del servicio de prueba");



    }

    /**
     *
     * @return Retorna el puerto indicado por el entorno, en caso de no encontrarlo retorna el puerto 5000 por defecto
     */
    static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 5000;
    }
}
