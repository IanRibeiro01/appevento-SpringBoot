package com.appevento.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.appevento.models.Evento;
import com.appevento.repository.EventoRepository;

@Controller
public class EventoController {

	@Autowired
	private EventoRepository er;
	
	//Listagem de eventos
	@RequestMapping(value="/index", method=RequestMethod.GET)
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView("index");
		Iterable<Evento> eventos = er.findAll();
		mv.addObject("eventos", eventos);
		return mv;
	}
	
	
	//Cadastro de evento
	@RequestMapping(value="/cadastrarEvento", method=RequestMethod.GET)
	public String cadastrar() {
		return "evento/formEvento";
	}
	
	@RequestMapping(value="/cadastrarEvento", method=RequestMethod.POST)
	public String cadastar(Evento evento) {
		er.save(evento);
		return "redirect:/index";
	}
	
	
	//Detalhes de um eveton
	@RequestMapping("/{codigo}")
	public ModelAndView detalhesEvento(@PathVariable("codigo") long codigo) {
		Evento evento = er.findByCodigo(codigo);
		ModelAndView mv = new ModelAndView("evento/detalhesEvento");
		mv.addObject("evento", evento);
		return mv;
	}
	
	
}
