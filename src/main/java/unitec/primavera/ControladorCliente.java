/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unitec.primavera;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author ramce
 */
@RestController
@RequestMapping("/api")
public class ControladorCliente {
    @Autowired RepositorioCliente cliente;
    
      
    //Buscamos todos
    @GetMapping(path="/cliente")
    public List<Cliente> todos(){
    return cliente.findAll();
    }
    
    //Buscamos por id
    @GetMapping(path="/cliente/{id}")
    public Cliente buscarPorId(@PathVariable String id){
        return cliente.findById(id).get();
    }
    
    //Vamos a guardar para ello siempre se ocupa el POST
    @PostMapping(path="/cliente",consumes="application/json")
    public Estatus guardar(@RequestBody String json)throws Exception{
        //Recibimos a json con los brazos abiertos
        ObjectMapper maper=new ObjectMapper();
        Cliente cliente=maper.readValue(json, Cliente.class);
        System.out.println(cliente);
        Estatus estatus=new Estatus();
        estatus.setSuccess(true);
        estatus.setMensaje("Cliente guardado con exito");
        return estatus;
    }
}
