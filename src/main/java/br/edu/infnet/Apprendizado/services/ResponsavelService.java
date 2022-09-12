package br.edu.infnet.Apprendizado.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import br.edu.infnet.Apprendizado.entities.Responsavel;
import br.edu.infnet.Apprendizado.test.AppImprimir;

@Service
public class ResponsavelService {
	private static Map<Long, Responsavel> respMap = new HashMap<>();
	private static Long id = 1L;
	
	public void incluir(Responsavel responsavel) {
		responsavel.setId(id++);
		respMap.put(responsavel.getId(), responsavel);
		AppImprimir.relatorio(responsavel.getNome(), responsavel);
	}
	
	public List<Responsavel> obterLista(){
		return respMap.values().stream().toList();
	}
	
	public void excluir(Long id) {
		respMap.remove(id);
	}
}
