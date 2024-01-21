package it.unicam.cs.opencity.controller;


import it.unicam.cs.opencity.entity.Content;
import it.unicam.cs.opencity.service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ContentController {

    private final ContentService contentService;

    @Autowired
    public ContentController(ContentService contentService) {
        this.contentService = contentService;
    }

    @GetMapping("/city/{cityId}/points/{pointId}/contents")
    public ResponseEntity<List<Content>> getContentsOfPoint(@PathVariable Integer cityId, @PathVariable Integer pointId){
        return ResponseEntity.ok(contentService.getContentsOfPoint(pointId, cityId));
    }

    @GetMapping("/city/{cityId}/points/{pointId}/contents/{contentId}")
    public ResponseEntity<Content> getContentDetails(@PathVariable Integer cityId, @PathVariable Integer pointId, @PathVariable Integer contentId) {
        return ResponseEntity.ok(contentService.getContentDetails(contentId, pointId, cityId));
    }

    @PostMapping("/city/{cityId}/points/{pointId}/contents")
    public ResponseEntity<Content> addContent(@RequestBody Content content, @PathVariable Integer cityId, @PathVariable Integer pointId) {
        if(contentService.addContent(content, pointId, cityId))
            return new ResponseEntity<>(content, HttpStatus.CREATED);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/city/{cityId}/points/{pointId}/contents/{contentId}")
    public ResponseEntity<Object> deleteContent(@PathVariable Integer cityId, @PathVariable Integer pointId, @PathVariable Integer contentId){
        if(contentService.deleteContent(contentId, pointId, cityId))
            return new ResponseEntity<>(HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // TODO: modificare rotta in "/city/{id}/points/{pointId}/contents/{contentId}/favorite"
    @PostMapping("/{id}/favorite")
    public ResponseEntity<Object> addFavorite(@RequestHeader MultiValueMap<String, String> headers, @PathVariable Integer id){
    //        String token = headers.get("authorization").get(0).substring(7);
    //        Integer idUser = Integer.parseInt(jwtTokenProvider.extractId(token));
    //
    //        FavoriteId favoriteId = new FavoriteId();
    //        favoriteId.setUserId(idUser);
    //        favoriteId.setContent(id);
    //
    //        Favorite favorite = new Favorite();
    //        favorite.setId(favoriteId);
    //        if(contentService.addFavorite(favorite))
    //            return new ResponseEntity<>(favorite, HttpStatus.CREATED);
    //        else
    //            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return ResponseEntity.ok("cicipiciapaciapa");
    }
}