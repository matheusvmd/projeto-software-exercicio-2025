package br.edu.insper.exercicio.viagens;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ViagemService {

    @Autowired
    private ViagemRepository viagemRepository;

    public List<Viagem> getViagens() {
        return viagemRepository.findAll();
    }

    public Viagem createViagem(Viagem viagem) {
        return viagemRepository.save(viagem);
    }

    public void deleteViagem(Integer id) {
        viagemRepository.deleteById(id);
    }

    public Viagem getViagem(Integer id) {
        return viagemRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Viagem não encontrada"));
    }
}
