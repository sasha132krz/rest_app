package org.example.rest;

import org.example.db.model.Category;
import org.example.db.model.Owner;
import org.example.service.CategoryService;
import org.example.service.OwnerService;
import org.example.service.PieceOfArtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/public/rest/pieces_of_art")
public class PieceOfArtRestService {

    @Autowired
    private OwnerService ownerService;

    @Autowired
    private PieceOfArtService pieceOfArtService;

    @Autowired
    private CategoryService categoryService;

    @RequestMapping(value = "/category", method = RequestMethod.GET)
    public ResponseEntity<Object> showCategory() {
        try {
            return ResponseEntity.ok(categoryService.listAll());
        } catch (Exception e){
            return new ResponseEntity<>("BAD_REQUEST", HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<Object> showPieceOfArt() {
        try {
            return ResponseEntity.ok(pieceOfArtService.listAll());
        } catch (Exception e){
            return new ResponseEntity<>("BAD_REQUEST", HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "/owner", method = RequestMethod.GET)
    public ResponseEntity<Object> showOwner() {
        try {
            return ResponseEntity.ok(ownerService.listAll());
        } catch (Exception e){
            return new ResponseEntity<>("BAD_REQUEST", HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "/category/{category_id}", method = RequestMethod.GET)
    public ResponseEntity<Object> findByCategoryId(@PathVariable("category_id") Integer category_id) {
        try {
            return ResponseEntity.ok(categoryService.findByCategoryId(category_id));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @RequestMapping(value = "/owner/{owner_id}", method = RequestMethod.GET)
    public ResponseEntity<Object> findByOwnerId(@PathVariable("owner_id") Integer owner_id) {
        try {
            return ResponseEntity.ok(ownerService.findByOwnerId(owner_id));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @RequestMapping(value = "/category/{name}", method = RequestMethod.POST)
    public ResponseEntity<Object> addCategory(@PathVariable("name") String name) {
        try {
            categoryService.add(name);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
        catch (Exception e) {
            return new ResponseEntity<>("BAD_REQUEST", HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "/owner/{name}", method = RequestMethod.POST)
    public ResponseEntity<Object> addOwner(@PathVariable("name") String name) {
        try {
            ownerService.add(name);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
        catch (Exception e) {
            return new ResponseEntity<>("BAD_REQUEST", HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "/{name}/{category_id}/{owner_id}/{year}/{price}", method = RequestMethod.POST)
    public ResponseEntity<Object> addPieceOfArt(@PathVariable("name") String name, @PathVariable("category_id") Integer category_id, @PathVariable("owner_id") Integer owner_id, @PathVariable("year") Integer year, @PathVariable("price") Integer price) {
        try {
            Category category = categoryService.findByCategoryId(category_id);
            Owner owner = ownerService.findByOwnerId(owner_id);
            pieceOfArtService.add(name, category, owner, year, price);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
        catch (Exception e) {
            return new ResponseEntity<>("BAD_REQUEST", HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deletePieceOfArt(@PathVariable("id") Integer id) {
        try {
            pieceOfArtService.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        catch (Exception e) {
            return new ResponseEntity<>("NOT FOUND", HttpStatus.NOT_FOUND);
        }
    }
}
