package com.company;

import java.io.*;


public class Main {

    public static void gerarTxt(){
        try {
            BufferedWriter out = new BufferedWriter(new FileWriter("numerosHeapSort.txt"));
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
        int x;    int y = 20000;
        int dadosConvertidos[] = new int[y];
        String dados[] = new String[y];
        InputStream input = new FileInputStream("numerosHeapSort.txt");
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
        //mergeSort(dadosConvertidos,0, dadosConvertidos.length - 1);
        heapSort(dadosConvertidos);
        System.out.println("\n");
        for(int i = 0; i < dadosConvertidos.length; i++){
            System.out.print(dadosConvertidos[i] + ", ");
        }
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
        for(int i = 0; i < vetor.length; i++){
            System.out.print(vetor[i] + ", ");
        }
    }

    public static int mergeSort(int[] vetor, int inicio, int fim) {
        int meio;
        if (inicio < fim) {
            meio = (inicio + fim) / 2;
            mergeSort(vetor, inicio, meio);
            mergeSort(vetor, meio + 1, fim);
            intercala(vetor, inicio, meio, fim);
        }
        return vetor[fim];
    }

    public static void intercala(int vetor[], int inicio, int meio, int fim) {
        int tamEsq = meio - inicio + 1;
        int tamDir = fim - meio;
        int esq[] = new int[tamEsq];
        int dir[] = new int[tamDir];
        int idxEsq = 0;
        int idxDir = 0;
        for (int i = 0; i < tamEsq; i++) {
            esq[i] = vetor[inicio + i];
        }
        for (int j = 0; j < tamDir; j++) {
            dir[j] = vetor[meio + 1 + j];
        }
        for (int k = inicio; k <= fim; k++) {
            if (idxEsq < tamEsq) {
                if (idxDir < tamDir) {
                    if (esq[idxEsq] < dir[idxDir]) {
                        vetor[k] = esq[idxEsq++];
                    } else {
                        vetor[k] = dir[idxDir++];
                    }
                } else {
                    vetor[k] = esq[idxEsq++];
                }
            }else{
                vetor[k] = dir[idxDir++];
            }
        }
    }

    public static int[] heapSort(int arr[]) {
        int n = arr.length;
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }
        for (int i = n - 1; i >= 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            heapify(arr, i, 0);
        }
        return arr;
    }

    static void heapify(int arr[], int n, int i) {
        int largest = i;
        int l = 2 * i + 1;
        int r = 2 * i + 2;

        if (l < n && arr[l] > arr[largest])
            largest = l;

        if (r < n && arr[r] > arr[largest])
            largest = r;

        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            heapify(arr, n, largest);
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
