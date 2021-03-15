package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;



public class Main {

    public static void gerarTxt(){
        try {
            BufferedWriter out = new BufferedWriter(new FileWriter("numeros.txt"));
            int numero[], x;
            x = 100000;
            numero = new int[x];
            String num[] = new String[x];
            for(int y = 0; y < x; y++) {
                numero[y] = (int) (Math.random() * x);
                num[y] = String.valueOf(numero[y]);
                out.write(num[y]);
                out.write(",");
            }
            out.close();
        }
        catch(IOException e){

        }
        System.exit(0);
    }

    public static void coletarDadosTxt() throws IOException{
        int x;    int y = 10;
        int dadosConvertidos[] = new int[y];
        String dados[] = new String[y];
        InputStream input = new FileInputStream("numeros.txt");
        InputStreamReader inReader = new InputStreamReader(input);
        BufferedReader buffer = new BufferedReader(inReader);
        String texto = buffer.readLine();
        System.out.println("Números fora de ordem:");
        while (texto != null){
            dados = texto.split(",");

            for(x = 0; x < y; x++){System.out.print(dados[x] + ", ");}

            System.out.println("\n");
            texto = buffer.readLine();
        }



        for(x = 0; x<y; x++){dadosConvertidos[x] = Integer.parseInt(dados[x]);}

        System.out.println("números ordenados: ");
        //insertionSort(dadosConvertidos);
        //bubbleSort(dadosConvertidos);
        System.out.println("\n");

        return;
    }

    public static void insertionSort(int[] vetor){
        int j, i;
        int aux;
        for(j = 0; j < vetor.length; j++){
            aux = vetor[j];
            for (i = j - 1; (i >= 0) && (vetor[i] > aux); i--)
            {
                vetor[i + 1] = vetor[i];
            }
            vetor[i + 1] = aux;
        }

        for(i = 0; i < vetor.length; i++){
           System.out.print(vetor[i] + ", ");
        }

    }

    public static void bubbleSort(int[] vetor){
        for(int i = 0; i < vetor.length - 1; i++) {
            for(int j = 0; j < vetor.length - 1 - i; j++) {
                if(vetor[j] > vetor[j + 1]) {
                    int aux = vetor[j];
                    vetor[j] = vetor[j + 1];
                    vetor[j + 1] = aux;
                }
            }
        }
    }


    public static void main(String[] args) throws IOException {
        //gerarTxt();
        long tempoInicial = System.currentTimeMillis();

        coletarDadosTxt();

        long tempoFinal = System.currentTimeMillis() - tempoInicial;
        System.out.println("Duração do programa: " + tempoFinal);
    }
}
