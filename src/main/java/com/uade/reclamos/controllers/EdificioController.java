package com.uade.reclamos.controllers;

import controlador.Controlador;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/edificios")
public class EdificioController {

    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    public HttpEntity<BSREPostingSearchResult> listarEdificios() {
        String pagingLimit = SEARCH_NAME_MAP.equals(searchName) ? SEARCH_NAME_MAP_POSTINGS_LIMIT : siteService.hasMoreDevelopmentsAndPostingLimit() ? POSTING_LIMIT_RELA : POSTING_LIMIT_DEFAULT;
        return new ResponseEntity<>(postingService.getListado(sortByName, searchName, searchParameters, pagingOffset, pagingLimit,null, null), HttpStatus.OK);
    }

}
