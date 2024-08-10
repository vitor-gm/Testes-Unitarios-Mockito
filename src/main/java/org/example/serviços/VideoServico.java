package org.example.serviços;


import org.example.implementações.OpcaoAceleracaoImpl;


import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

public class VideoServico {

    private OpcaoAceleracaoImpl calculadorAceleracao = new OpcaoAceleracaoImpl();



    public VideoServico() {

    }
    public VideoServico(OpcaoAceleracaoImpl calculadorAceleracao) {
        this.calculadorAceleracao = calculadorAceleracao;
    }

    public double calcularTempoEmMinutos(double videoEmMinutos, int aceleracao ) {

        double fatorAceleracao = calculadorAceleracao.calcularFator(aceleracao);
        return videoEmMinutos / fatorAceleracao;
    }

    public double calcularTempoEmHoras(double videoEmHoras, int aceleracao ) {

        double fatorAceleracao = calculadorAceleracao.calcularFator(aceleracao);
        return videoEmHoras / fatorAceleracao / 60;

    }

    public double adiantarVideoEmQuizeSegundos(double videoEmMinutos, int aceleracao) {

        double fatorAceleracao = calculadorAceleracao.calcularFator(aceleracao);
        return videoEmMinutos / fatorAceleracao - (double) 1 / 4;
    }

    public void informacoesGerais(double videoEmMinutos, int aceleracao) {
        List<Double> tempos = new ArrayList<>();

        double tempoEmMinutos = calcularTempoEmMinutos(videoEmMinutos, aceleracao);
        double tempoEmHoras = calcularTempoEmHoras(videoEmMinutos, aceleracao);
        double tempoSemAbertura = adiantarVideoEmQuizeSegundos(videoEmMinutos, aceleracao);

        tempos.add(tempoEmMinutos);
        tempos.add(tempoEmHoras);
        tempos.add(tempoSemAbertura);

        DecimalFormat df = new DecimalFormat("#.##");
        tempos.forEach(e -> {
            System.out.println("Tempo: " + df.format(e));
        });


    }


}
