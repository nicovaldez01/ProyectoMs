package LegajosMsalud.Controller;

import LegajosMsalud.Model.Legajos;
import LegajosMsalud.Services.LegajosServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping(path = "api/v1/Legajos")

public class LegajosController {
    private final LegajosServices legajosServices;

    @Autowired
    public LegajosController(LegajosServices legajosServices){
        this.legajosServices =legajosServices;
}

    @GetMapping
    public List<Legajos> getLegajos(){
        return this.legajosServices.getLegajos();
    }


    @PostMapping
    public ResponseEntity<Object> registrarLegajo(@RequestBody Legajos legajos){
        return this.legajosServices.newLegajos(legajos);
    }

    @PutMapping
    public ResponseEntity<Object> actualizarLegajo (@RequestBody Legajos legajos){
        return this.legajosServices.newLegajos(legajos);
    }

    @DeleteMapping(path="{productId}")
    public ResponseEntity<Object> eliminarLegajo (@PathVariable("productId") Long id){
        return this.legajosServices.deleteLegajos(id);
    }

}
