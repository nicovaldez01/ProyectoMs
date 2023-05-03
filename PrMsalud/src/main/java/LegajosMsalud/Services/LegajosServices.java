package LegajosMsalud.Services;

import LegajosMsalud.Model.Legajos;
import LegajosMsalud.Repository.ILegajosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
    public class LegajosServices {
    HashMap<String, Object> datos;
    private final ILegajosRepository iLegajosRepository;

    @Autowired
    public LegajosServices(ILegajosRepository iLegajosRepository){
        this.iLegajosRepository = iLegajosRepository;
    }

    public List<Legajos> getLegajos(){
        return this.iLegajosRepository.findAll();
    }


    public ResponseEntity<Object> newLegajos(Legajos legajos) {
        datos = new HashMap<>();
        Optional<Legajos> res = iLegajosRepository.findBydni(legajos.getDni());

        if (res.isPresent() && legajos.getId()==null){
            datos.put("error",true);
            datos.put("message","Ya existe un Legajo con ese ID.");
            return new ResponseEntity <>(
                    datos,
                    HttpStatus.CONFLICT
            );
        }else {
            datos.put("message","Legajos guardado con exito.");
            if(legajos.getId() != null){
                datos.put("message","Legajos actualizo con exito.");
            }
            datos.put("datos",legajos);
            iLegajosRepository.save(legajos);
            return new ResponseEntity <>(
                    datos,
                    HttpStatus.CREATED
            );
        }
    }

    public ResponseEntity<Object> deleteLegajos(Long id){
        datos = new HashMap<>();
        boolean existe = this.iLegajosRepository.existsById(id);
        if (!existe){
            datos.put("error",true);
            datos.put("message","No existe un Legajo con ese ID.");
            return new ResponseEntity <>(
                    datos,
                    HttpStatus.CONFLICT);
        }
        iLegajosRepository.deleteById(id);
        datos.put("ID",id);
        datos.put("message","Legajo eliminado.");
        return new ResponseEntity <>(
                datos,
                HttpStatus.ACCEPTED);
    }
}
