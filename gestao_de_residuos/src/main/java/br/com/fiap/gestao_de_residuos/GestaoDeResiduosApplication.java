package br.com.fiap.gestao_de_residuos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GestaoDeResiduosApplication {

	@Autowired
	private AgendamentoService agendamentoService;

	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<AgendamentoExibicaoDTO> getAllSchedulesForAdmin() {
		return agendamentoService.findAll();
	}

	@GetMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public AgendamentoExibicaoDTO getScheduleById(@PathVariable("id") Integer id) {
		return agendamentoService.findById(id);
	}

	@GetMapping("/meus-agendamentos")
	@ResponseStatus(HttpStatus.OK)
	public List<AgendamentoExibicaoDTO> getUserSchedules() {
		return agendamentoService.findAllByEmail();
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public AgendamentoExibicaoDTO createSchedule(@RequestBody @Valid CadastroAgendamentoDTO schedule) {
		return agendamentoService.save(schedule);
	}

	@PutMapping
	@ResponseStatus(HttpStatus.OK)
	public AgendamentoExibicaoDTO updateSchedule(@RequestBody @Valid CadastroAgendamentoDTO schedule) {
		return agendamentoService.update(schedule);
	}

	@PutMapping("/cancelar/{id}")
	@ResponseStatus(HttpStatus.OK)
	public AgendamentoExibicaoDTO cancelSchedule(@PathVariable("id") Integer id) {
		return agendamentoService.cancelarAgendamento(id);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteSchedule(@PathVariable("id") Integer id) {
		agendamentoService.deleteAgendamento(id);
	}
}
