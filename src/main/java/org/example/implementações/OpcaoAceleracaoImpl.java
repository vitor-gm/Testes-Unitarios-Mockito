package org.example.implementações;


public class OpcaoAceleracaoImpl {


    public double calcularFator(int aceleracao) {


        switch (aceleracao) {
            case 1:
                return 1;
            case 2:
                return 1.25;
            case 3:
                return 1.5;
            case 4:
                return 1.75;
            case 5:
                return 2.0;


        }
        return 0;
    }
}
