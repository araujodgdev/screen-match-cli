package br.com.douglas.screenmatch;

import br.com.douglas.screenmatch.model.DadosSerie;
import br.com.douglas.screenmatch.service.ConsumoAPI;
import br.com.douglas.screenmatch.service.ConverteDados;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.json.JacksonJsonParser;

@SpringBootApplication
public class ScreenmatchApplication implements CommandLineRunner {

	public static void main(String[] args) {

		SpringApplication.run(ScreenmatchApplication.class, args);


	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Aplicação iniciado com sucesso!");
		String gilmoreGirls = new ConsumoAPI().obterDados("https://www.omdbapi.com/?t=gilmore+girls&apikey=37cbf002");
		ConverteDados conversor = new ConverteDados();

		DadosSerie minhaSerie = conversor.converteDados(gilmoreGirls, DadosSerie.class);

		System.out.println(minhaSerie);
	}
}
