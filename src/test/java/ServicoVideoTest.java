import org.example.implementações.OpcaoAceleracaoImpl;
import org.example.serviços.VideoServico;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ServicoVideoTest {

    @Mock
    private OpcaoAceleracaoImpl opcaoAceleracao;

    @InjectMocks
    private VideoServico tempoDeVideo;

    @Spy
    private VideoServico videoServico;

    @Captor
    private ArgumentCaptor<Double> doubleCaptor;

    @Test
    public void testeCalcularTempo() {

        when(opcaoAceleracao.calcularFator(4)).thenReturn(2.0);

        double resultado = tempoDeVideo.calcularTempoEmMinutos(10, 4);

        Assertions.assertEquals(5, resultado, 0.01);

        verify(opcaoAceleracao).calcularFator(4);
    }

    @Test
    public void OrdemCorretaDosMetodos() {
        videoServico.informacoesGerais(10, 4);

        InOrder inOrder = Mockito.inOrder(videoServico);
        inOrder.verify(videoServico).calcularTempoEmMinutos(10, 4);
        inOrder.verify(videoServico).calcularTempoEmHoras(10, 4);
        inOrder.verify(videoServico).adiantarVideoEmQuizeSegundos(10, 4);
    }

    @Test
    public void validarQuantidadeDeChamadas() {
        videoServico.informacoesGerais(10, 4);

        verify(videoServico, times(1)).calcularTempoEmMinutos(ArgumentMatchers.anyDouble(), ArgumentMatchers.anyInt());
        verify(videoServico, times(1)).calcularTempoEmHoras(ArgumentMatchers.anyDouble(), ArgumentMatchers.anyInt());
        verify(videoServico, times(1)).adiantarVideoEmQuizeSegundos(ArgumentMatchers.anyDouble(), ArgumentMatchers.anyInt());

    }

    @Test
    public void capturarArgumentos() {
        videoServico.informacoesGerais(10, 4);

        verify(videoServico).calcularTempoEmMinutos(doubleCaptor.capture(), ArgumentMatchers.anyInt());
        Double capturedArgument = doubleCaptor.getValue();
        Assertions.assertEquals(10.0, capturedArgument);
    }

}
