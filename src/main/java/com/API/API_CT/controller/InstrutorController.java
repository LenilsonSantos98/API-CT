package com.API.API_CT.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.API.API_CT.domain.model.Instrutor;

@RestController
@RequestMapping("/instrutores")
public class InstrutorController extends BaseController<Instrutor, Long>  {
    
}
