package com.company;
import java.util.Scanner;
import java.util.Random;

public class ManyDimArr {

// функции для работы с массивами

    public static int[][] ManualGener ( int n, int m){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Начни вводить значения массива");
        int[][] arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j =0; j<m; j++){
                arr[i][j] = scanner.nextInt();
            }
        }
        return arr;
    }

    public static int[][] RandomGener ( int n, int m, int a, int b){
        Random random = new Random();
        int[][] arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j =0; j<m; j++){
                arr[i][j] = random.nextInt(a, b);
            }
        }
        return arr;
    }

    public static void PrintArrayBig (int[][] arr, int n, int m){
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; j++) {
                System.out.print(arr[i][j] + " ");

            }
            System.out.println();
        }
    }

    public static void PrintArraySmallBool (boolean[] arr, int n){
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void PrintArraySmallInt (int[] arr, int n){
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void PrintArraySmallDouble (double[] arr, int n){
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main (String[]args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Размерность массива");
        int n = scanner.nextInt();
//        int m = scanner.nextInt();
//        System.out.println("Минимальное и максимальное значение генерации");
//        int a = scanner.nextInt();
//        int b = scanner.nextInt();
//        int[][] arr = RandomGener(n, m, a, b);
//        //int[][] arr = ManualGener(n, m); //для тестирования
//        PrintArrayBig(arr, n, m);
//        System.out.println("");

        //Task1_4(arr, n, m);
        //Task5(arr, n, m);
        //Task6(arr, n, m);
        //Task7(arr, n, m);
        //Task8(arr, n, m);
        //Task9(arr, n, m);
        //Task10(arr, n, m);
        //Task11(arr, n, m);
        Task12 (n);
    }

    // функции заданий

    public static void Task1_4 (int[][] arr, int n, int m){
        //Найти минимальный элемент массива
        //Найти максимальный элемент массива
        //Найти индекс минимального элемента массива
        //Найти индекс максимального элемента массива
        int min = arr[0][0];
        int max = arr[0][0];
        int mini = 0, minj = 0, maxi = 0, maxj = 0;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] <= arr[mini][minj]) {
                    mini = i;
                    minj = j;
                }
                if (arr[i][j] >= arr[maxi][maxj]) {
                    maxi = i;
                    maxj = j;
                }
            }
        }
        System.out.println("max= " + arr[maxi][maxj]);
        System.out.println("min= " + arr[mini][minj]);
        System.out.println("max index= " + maxi + " " + maxj);
        System.out.println("min index= " + mini + " " + minj);
    }

    public static void Task5 (int[][] arr, int n, int m){
        //Найти количество элементов массива, которые больше всех своих соседей одновременно
        System.out.println("Соседями считаем все числа вокруг, в том числе и по диагонали");
        boolean check;
        int count = 0;
        for (int i = 0; i<n; i++){
            for (int j = 0; j<m; j++){
                check = true;
                for (int f = i-1; f<=i+1; f++){
                    for (int k = j-1; k<=j+1; k++){
                        if (f>=0 && f<n && k>=0 && k<m && !(f==i && k==j)){
                            if (arr[f][k]>=arr[i][j]){
                                check = false;
                                break;
                            }
                        }
                    }
                }
                if (check){
                    count++;
                    System.out.println(count + " число = "+ arr[i][j]);
                    System.out.println("Индекс: " + i + " " + j);
                }
            }
        }
        if (count!=0){
            System.out.println("Всего чисел в массиве: "+ count);
        }else{
            System.out.println("Таких чисел нет");
        }
    }

    public static void Task6 (int[][] arr, int n, int m){
        //Отразите массив относительно его главной диагонали
        for (int i = 0; i < n; i++){
            for (int j=i+1; j<m; j++){
                int temp = arr[i][j];
                arr[i][j]=arr[j][i];
                arr[j][i]=temp;
            }
        }
        System.out.println("Отраженный массив:");
        PrintArrayBig(arr, n, m);
    }

    public static void Task7 (int[][] arr, int n, int m){
        //Дана вещественная матрица размерности n * m. По матрице получить логический вектор, присвоив его k-ому элементу значение True,
        // если выполнено указанное условие и значение False иначе:
        // - все элементы k столбца нулевые;
        // - элементы k строки матрицы упорядочены по убыванию;
        // - k строка массива симметрична.

        boolean[] zeroarr = new boolean[m];
        int proof;
        for(int i = 0; i<m; i++){
            proof = 0;
            for (int j=0; j<n; j++){
                proof+=arr[j][i];
            }
            if (proof==0){
                zeroarr[i] = true;
            }else{
                zeroarr[i] = false;
            }
        }
        System.out.println("Нулевой: ");
        PrintArraySmallBool(zeroarr, m);

        boolean[] sortarr = new boolean[n];
        boolean check;
        for(int i = 0; i<n; i++){
            check = true;
            for (int j=1; j<m; j++){
                if (arr[i][j]>arr[i][j-1]){
                    check = false;
                    break;
                }
            }
            if (check){
                sortarr[i] = true;
            }else{
                sortarr[i] = false;
            }
        }
        System.out.println("Упорядоченный: ");
        PrintArraySmallBool(sortarr, n);

        boolean[] simmarr = new boolean[n];
        boolean simm;
        for(int i = 0; i<n; i++){
            simm = true;
            for (int j=0; j<m/2; j++){
                if (arr[i][j]!=arr[i][m-j-1]){
                    simm = false;
                    break;
                }
            }
            if (simm){
                simmarr[i] = true;
            }else{
                simmarr[i] = false;
            }
        }
        System.out.println("Симметричный: ");
        PrintArraySmallBool(simmarr, n);
    }

    public static void Task8 (int[][] arr, int n, int m){
        //Дан двухмерный массив A[1..m,1..n]. Написать программу построения одномерного массива B[1..m],
        // элементы которого соответственно равны
        // а) суммам элементов строк, б) произведениям элементов строк, в) наименьшим средних арифметических элементов строк.

        int[] summarr = new int[n];
        int[] comparr = new int[n];
        double[] midarr = new double[n];
        int summ;
        int comp;
        for(int i = 0; i<n; i++){
            summ = 0;
            comp = 1;
            for (int j=0; j<m; j++){
                summ+=arr[i][j];
                comp *= arr[i][j];
            }
            summarr [i] = summ;
            comparr [i] = comp;
            midarr [i] = 1.0*summarr[i]/m;
        }
        System.out.println("Сумма строк: ");
        PrintArraySmallInt(summarr, n);
        System.out.println("Произведение строк: ");
        PrintArraySmallInt(comparr, n);
        System.out.println("Среднее арифметическое строк: ");
        PrintArraySmallDouble(midarr, n);


    }

    public static void Task9 (int[][] arr, int n, int m){
        //В массиве А[1..N,1..N] определить номера строки и столбца какой-нибудь седловой точки.
        // Некоторый элемент массива называется седловой точкой, если он является одновременно наименьшим в своей строке и наибольшим в своем столбце.

        boolean result=true;
        boolean check;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                check = true;
                for(int k=0; k<n; k++){
                    if (arr[k][j]>=arr[i][j] && k!=i){
                        check = false;
                        break;
                    }
                }
                for(int t=0; t<m; t++){
                if (arr[i][t]<=arr[i][j] && t!=j){
                    check = false;
                    break;
                    }
                }
                if(check){
                    result = false;
                    System.out.println("Элемент " + arr[i][j] + " с индексами " + i + " " + j);
                }
            }
        }
        if (result){
            System.out.println("Нет таких чисел");
        }
    }

    public static void Task10 (int[][] arr, int n, int m){
        //Массив А[1..5,1..7] содержит вещественные числа. Требуется ввести целое число K и вычислить сумму элементов А[I,J],
        // для которых I+J=К. Прежде, однако следует убедиться, что значение К позволяет найти решение,
        // в противном случае нужно напечатать сообщение об ошибке.
        Scanner scanner = new Scanner(System.in);
        System.out.println("Какое число проверяем?");
        int k = scanner.nextInt();
        int summ = 0;
        if ((n-1)+(m-1)<k){
            System.out.println("Решение не может быть найдено");
            return;
        }
        for(int i=0; i<n; i++) {
            for (int j = 0; j < m; j++) {
                if (i+j==k){
                    summ += arr[i][j];
                    System.out.println("Элемент " + arr[i][j] + " с индексами " + i + " " + j);
                }
            }
        }
        System.out.println("Сумма = " + summ);
    }

    public static void Task11 (int[][] arr, int n, int m){
        //Дана матрица NxM. Переставляя ее строки и столбцы, переместить наибольший элемент в верхний левый угол.
        //Определить можно ли таким же образом поместить минимальный элемент в нижний правый угол.
        int max = arr[0][0];
        int maxi = 0, maxj = 0;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] >= arr[maxi][maxj]) {
                    maxi = i;
                    maxj = j;
                }
            }
        }
        System.out.println("Элемент " + arr[maxi][maxj] + " с индексами " + maxi + " " + maxj);
        for (int i=maxi; i>0; i--){
            for (int j = 0; j<m; j++){
                int temp = arr[i-1][j];
                arr[i-1][j]=arr[i][j];
                arr[i][j]=temp;
            }
            PrintArrayBig(arr, n, m);
            System.out.println("");
        }
        for (int j=maxj; j>0; j--){
            for (int i = 0; i<n; i++){
                int temp = arr[i][j-1];
                arr[i][j-1]=arr[i][j];
                arr[i][j]=temp;
            }
            PrintArrayBig(arr, n, m);
            System.out.println("");
        }

    }

    public static void Task12 (int n){
        //Заполнить двухмерный массив Т[1..n,1..n] последовательными целыми числами от 1, расположенными по спирали,
        // начиная с левого верхнего угла и продвигаясь по часовой стрелке
        //Для этой задачи закомментируй строчки 66-71Math.ceil(n/2)

        int[][] arr = new int[n][n];
        int m = n;
        int num = 0;
        for (int dash=0; dash<(int)Math.ceil(1.0*n/2); dash++) {
            for (int r = 0 + dash; r < n-dash; r++) {
                arr[dash][r]=num;
                num++;
            }
            for (int d = dash + 1; d < n-dash; d++) {
                arr[d][n-dash-1]=num;
                num++;
            }
            for (int l = n-dash - 2; l >= dash; l--) {
                arr[n-dash-1][l]=num;
                num++;
            }
            for (int u = n-dash - 2; u >= dash+1; u--) {
                arr[u][dash]=num;
                num++;
            }
        }
        PrintArrayBig(arr, n, m);
    }
}

