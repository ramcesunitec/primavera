package unitec.primavera;

import java.time.LocalDate;
import static jdk.nashorn.internal.runtime.Debug.id;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PrimaveraApplication implements CommandLineRunner{

    @Autowired RepositorioPagos repoPagos;
    @Autowired RepositorioMensajes repoMensa;
    
    
	public static void main(String[] args) {
		SpringApplication.run(PrimaveraApplication.class, args);
                
	}

    @Override
    public void run(String... args) throws Exception {
        
        //System.out.println("hola mundo");
        //repoPagos.servicioPagar();
        
        //Guarda mensaje
        //repoMensa.save(new Mensajito("Java 3","Profesor: Juan Carlos Campos",LocalDate.now()));
        
        //Buscamos todos los mensajes
            //Ponemos metodo ToString en Mesajito
        //for(Mensajito mensa: repoMensa.findAll()){
          //  System.out.println(mensa);                    
        //}
        
        //Buscar por Id
        //System.out.println(repoMensa.findById("5bb8cd49d2f4f812706be501").get());
        
        
        //Buscar por Titulo
        //System.out.println(repoMensa.findByTitulo("malo"));
        
        //Actualizamos
        //repoMensa.save(new Mensajito("5bb8cd49d2f4f812706be501", "Redes", "Ezequiel", LocalDate.now()));
        //System.out.println(repoMensa.findByTitulo("Redes"));
        
        //Buscar por Borrar
        //repoMensa.deleteById("5bb8cd49d2f4f812706be501");
             
        
        
    }
}
