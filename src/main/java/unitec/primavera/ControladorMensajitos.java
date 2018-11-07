/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unitec.primavera;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author ramce
 */
@RestController
@RequestMapping("/api")
@CrossOrigin(origins = {"https://angular-ghiryr.stackblitz.io"})
public class ControladorMensajitos {
    @Autowired RepositorioMensajes mensa;
    
    
    //Mi primer "Hola mundo" desde REST API con spring
    @GetMapping(path="/hola")
    public String hola(){
        return "Hola mundo malo";
    }
    
    
    //Buscamos todos
    @GetMapping(path="/mensaje")
    public List<Mensajito> todos(){
    return mensa.findAll();
    }
    
    //Buscamos por id
    @GetMapping(path="/mensaje/{id}")
    public Mensajito buscarPorId(@PathVariable String id){
        return mensa.findById(id).get();
    }
    
    //Vamos a guardar para ello siempre se ocupa el POST
    @PostMapping(path="/crearmensaje",consumes="application/json")
    public Estatus guardar(@RequestBody String json)throws Exception{
        //Recibimos a json con los brazos abiertos
        ObjectMapper maper=new ObjectMapper();
        Mensajito mensajito=maper.readValue(json, Mensajito.class);
        System.out.println(mensajito);
        mensa.save(mensajito);
        Estatus estatus=new Estatus();
        estatus.setSuccess(true);
        estatus.setMensaje("Mensajito guardado con exito");
        return estatus;
    }
    
           //Vamos a guardar para ello siempre se ocupa el POST
    @PutMapping(path="/actualizarMensaje",consumes="application/json")
    public Estatus actualizar(@RequestBody String json)throws Exception{
        //Recibimos a json con los brazos abiertos
       ObjectMapper maper=new ObjectMapper();
        Mensajito mensajito=maper.readValue(json, Mensajito.class);
        System.out.println(mensajito);
        mensa.save(mensajito);
        Estatus estatus=new Estatus();
        estatus.setSuccess(true);
        estatus.setMensaje("Mensajito actualizado con exito");
        return estatus;
    }
    
    
    @DeleteMapping(path="/eliminarmensaje/{id}")
    public Estatus borrarPorId(@PathVariable String id){
    mensa.deleteById(id);
    return new Estatus(true, "Borrado");
}
    
}
