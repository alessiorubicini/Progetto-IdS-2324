package it.unicam.cs.opencity.controller;


import it.unicam.cs.opencity.entity.Content;
import it.unicam.cs.opencity.entity.Favorite;
import it.unicam.cs.opencity.entity.FavoriteId;
import it.unicam.cs.opencity.service.ContentService;
import it.unicam.cs.opencity.util.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/content")
public class ContentController {

    private final ContentService contentService;
    private final JwtTokenProvider jwtTokenProvider;

    @Autowired
    public ContentController(ContentService contentService, JwtTokenProvider jwtTokenProvider) {
        this.contentService = contentService;
        this.jwtTokenProvider = jwtTokenProvider;
    }

    @PostMapping("/upload")
    public ResponseEntity<Content> uploadContent(@RequestBody Content content) {
        if(contentService.uploadContent(content))
            return new ResponseEntity<>(content, HttpStatus.CREATED);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Content> getContentDetails(@PathVariable Integer id){
        Content content = contentService.getContentDetails(id).orElse(null);
        if(content != null)
            return new ResponseEntity<>(content, HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/{userId}/contents")
    public ResponseEntity<List<Content>> getContentsOfUser(@PathVariable Integer userId) {
        List<Content> contents = contentService.getContentsOfUser(userId);
        if(contents != null)
            return new ResponseEntity<>(contents, HttpStatus.CREATED);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteContent(@PathVariable Integer id){
        if(contentService.removeContent(id))
            return new ResponseEntity<>(HttpStatus.CREATED);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateContent(@RequestBody Content content){
        if(contentService.updateContent(content))
            return new ResponseEntity<>(content, HttpStatus.CREATED);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/{id}/favorite")
    public ResponseEntity<Object> addFavorite(@RequestHeader MultiValueMap<String, String> headers, @PathVariable Integer id){
        String token = headers.get("authorization").get(0).substring(7);
        Integer idUser = Integer.parseInt(jwtTokenProvider.extractId(token));

        FavoriteId favoriteId = new FavoriteId();
        favoriteId.setUserId(idUser);
        favoriteId.setContent(id);

        Favorite favorite = new Favorite();
        favorite.setId(favoriteId);
        if(contentService.addFavorite(favorite))
            return new ResponseEntity<>(favorite, HttpStatus.CREATED);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
