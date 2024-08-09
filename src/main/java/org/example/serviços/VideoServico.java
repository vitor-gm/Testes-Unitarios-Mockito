package org.example.serviços;


import org.example.implementações.OpcaoAceleracaoImpl;


import java.util.Scanner;

public class VideoServico {

    private final OpcaoAceleracaoImpl calculadorAceleracao;

    public VideoServico(OpcaoAceleracaoImpl calculadorAceleracao) {
        this.calculadorAceleracao = calculadorAceleracao;
    }

    public double calcularTempoEmMinutos(double video, int aceleracao ) {

        double fatorAceleracao = calculadorAceleracao.calcularFator(aceleracao);
        return video / fatorAceleracao;
    }

    public double calcularTempoEmHoras(double video, int aceleracao ) {

        double fatorAceleracao = calculadorAceleracao.calcularFator(aceleracao);
        return video / fatorAceleracao / 60;

    }
}
