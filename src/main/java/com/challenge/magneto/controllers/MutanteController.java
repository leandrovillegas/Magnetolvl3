package com.challenge.magneto.controllers;

import java.io.IOException;
import java.io.Reader;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;


import com.challenge.magneto.dao.MutanteDao;
import com.challenge.magneto.models.Mutante;



@SpringBootApplication
@RestController
@RequestMapping
public class MutanteController {
	
	@Autowired
	private MutanteDao mutanteDao;
	
	
	
	

	@PostMapping(value = "/prueba")
	    public List<Mutante>  bds()  {
		
			return mutanteDao.estadisticas();
			
	
		
	 }
	
	
	
	 @PostMapping(value = "/mutant",
			 consumes = {MediaType.APPLICATION_JSON_VALUE})
	    public HttpStatus  Verificacions(@RequestBody Mutante mensaje) throws Exception {
		 Mutante mutan= new Mutante();
		 mutan.setDna(mensaje.getDna());
		System.out.println(mutan.getDna().toString());
		if(isMutant(mutan))
		{
			
			return HttpStatus.OK;
			
		}
		else
		{
			return HttpStatus.FORBIDDEN;
		}
		
		
	 }

	 
	 public static  boolean isMutant(Mutante dna) {
			
			
			
		 if(verificacionH(dna) + verificacionV(dna) >= 2)
			 {
			 System.out.println("ES MUTANTE");
			 return true;
			 }
		 System.out.println("NO ES MUTANTE");
		 return false;
		
	}
	
	
	
	public static int verificacionH (Mutante dna) {
		
		//String[] mutante =  {"ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"};
		
		int contador=1;
		int contadoradn=0;
	   
	
		for (int i = 0; i < dna.getDna().length; i++) {// COLUMNA
			contador=1;
			for ( int j = 0; j < dna.getDna().length; j++) { //FILA
			

				if(dna.getDna().length > j+1 && contador!= 4) {
		
					//System.out.println(dna[i].substring(j,j+1));
					//System.out.println(dna[i].substring(j+1,j+2));
					if( dna.getDna()[i].substring(j,j+1).equals(dna.getDna()[i].substring(j+1,j+2))) {
			
						contador++;
						//System.out.println(contador);
					}
					else{
						//System.out.println("No \n");
						contador=1;
					}	
				}
				else {
					if(contador==4) {
						System.out.println("GEN MUTANTE EN H \n");
						contadoradn++;
						contador=1;
						}
					}
			}	
		}
		
		return contadoradn;
		}



			 
			 
	
	
	

	public  static int verificacionV(Mutante dna) {
	
		//String[] mutante =  {"ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"};
		int contador=1;
		int contadoradn=0;
		
		
		for (int i = 0; i < dna.getDna().length; i++) { // COLUMNA
			contador=1;
			for ( int j = 0; j < dna.getDna().length; j++) { //FILA
				
			
			if(dna.getDna().length > j+1 && contador!= 4) {
			
				//System.out.println(dna[j].substring(i,i+1));
				//System.out.println(dna[j+1].substring(i,i+1));
			if( dna.getDna()[j].substring(i,i+1).equals(dna.getDna()[j+1].substring(i,i+1))) {
				
					contador++;
					//System.out.println(contador);
				}
				else{
					//System.out.println("No \n");
					contador=1;
					}	
				}
				else {
					if(contador==4) {
						System.out.println("GEN MUTANTE EN V \n");
						contadoradn++;
						contador=1;
						}
					}
			}	
		}
		
		return contadoradn;
		}
	
}


/*



@GetMapping("/pepe")
public ModelAndView prueba()
{
  ModelAndView mv = new ModelAndView();
  mv.setViewName("index");
  mv.getModel().put("data", "Hola mundo");
  return mv;
}

@RequestMapping(value = "prueba")
public HttpStatus pruebas()
{
 return HttpStatus.FORBIDDEN;
}



 @PostMapping(value = "/mutant")
    public String Verificacion(@RequestBody Reader  mensaje) {
	 //JSONPObject que = new JSONPObject(mensaje,mensaje);
	 
	    StringBuilder sb = new StringBuilder();
	    int cp;
	    try {
			while ((cp = mensaje.read()) != -1) {
			  sb.append((char) cp);
			  System.out.println(sb.toString());
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    JSONObject data_obj  = new JSONObject (mensaje);
	    String dna=  data_obj.getJSONObject("dna").toString();
	    sb.toString();

        return dna;
	  }
 
 @PostMapping(value = "/prueba",
		 consumes = {MediaType.APPLICATION_JSON_VALUE})
    public String Verificaciont(@RequestBody Map<String, Object> mensaje) throws Exception {
	// JSONPObject que = new JSONPObject("dna", mensaje);
	 // String[] pep= new String[mensaje.length()];
	  //  String inline = "";
      //  Scanner scanner = new Scanner(mensaje);

        //Write all the JSON data into a string using a scanner
      /*  while (scanner.hasNext()) {
            inline += scanner.nextLine();
        }*/

        //Close the scanner
        //scanner.close();
	    //JSONParser parse = new JSONParser(mensaje);
        //JSONObject data_obj  = (JSONObject) mensaje.parse();
			//JSONObject obj = (JSONObject) mensaje.getJSONObject("dna");
	  /*  for (String[] value : mensaje.values()) {
	        System.out.println("Valor " + value + "/n");
	        System.out.println(mensaje.values().size());
	    }*
	    System.out.println(mensaje.get("dna"));
	   
	 int i=0;
	 String[] dna= new String[6];
	  for (Entry<String, Object> entry: mensaje.entrySet())
        {
            
            dna[i] = entry.getValue().toString();
        }
	  for (i = 0; i < mensaje.size(); i++) {
		  System.out.println(dna[i]);
        }
			
        
	    return mensaje.get("dna").toString();
	  //pep[0] = mensaje.getJSONObject("dna").toString();
	    //System.out.println(mensaje);
	  //return mensaje.getString("dna").toString();
	  }

	  
*/