package br.com.crislei.forum_hub.controller;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

public class RepostaController {
    @RestController
    @RequestMapping("/respostas")
    @SecurityRequirement(name = "bearer-key")
    public class RespostaController {
        @Autowired
        private RespostaService service;



    }

