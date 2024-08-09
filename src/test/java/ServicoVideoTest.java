import org.example.implementações.OpcaoAceleracaoImpl;

import org.example.serviços.VideoServico;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ServicoVideoTest {

    @Mock
    private OpcaoAceleracaoImpl opcaoAceleracao;

    @InjectMocks
    private VideoServico tempoDeVideo;

    @Test
    public void testeCalcularTempo() {

        Mockito.when(opcaoAceleracao.calcularFator(4)).thenReturn(2.0);

        double resultado = tempoDeVideo.calcularTempoEmMinutos(10, 4);

        Assertions.assertEquals(5, resultado, 0.01);

    }

}
