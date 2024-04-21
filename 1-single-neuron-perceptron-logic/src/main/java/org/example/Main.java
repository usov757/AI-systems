package org.example;

public class Main {
    public static void main(String[] args) {
        // Создание перцептрона для логической функции "И"
        Perceptron andPerceptron = new Perceptron(2);
        int[] andInputs = {0, 0, 0, 1, 1, 0, 1, 1};
        int[] andOutputs = {0, 0, 0, 1};
        //
        // Обучение на логической функции "И"
        for (int i = 0; i < andInputs.length; i += 2) {
            andPerceptron.train(new int[]{andInputs[i], andInputs[i + 1]}, andOutputs[i / 2]);
        }

        // Вывод весов и порога для перцептрона "И"
        System.out.println("Perceptron AND:");
        double[] andWeights = andPerceptron.getWeights();
        for (int i = 0; i < andWeights.length; i++) {
            System.out.printf("Weight %d: %.3f\n", i, andWeights[i]);
        }
        System.out.printf("Threshold: %.3f\n", andPerceptron.threshold);

        // Создание перцептрона для логической функции "ИЛИ"
        Perceptron orPerceptron = new Perceptron(2);
        int[] orInputs = {0, 0, 0, 1, 1, 0, 1, 1};
        int[] orOutputs = {0, 1, 1, 1};

        // Обучение на логической функции "ИЛИ"
        for (int i = 0; i < orInputs.length; i += 2) {
            orPerceptron.train(new int[]{orInputs[i], orInputs[i + 1]}, orOutputs[i / 2]);
        }

        // Вывод весов и порога для перцептрона "ИЛИ"
        System.out.println("Perceptron OR:");
        double[] orWeights = orPerceptron.getWeights();
        for (int i = 0; i < orWeights.length; i++) {
            System.out.printf("Weight %d: %.3f\n", i, orWeights[i]);
        }
        System.out.printf("Threshold: %.3f\n", orPerceptron.threshold);

        // Создание перцептрона для логической функции "НЕ"
        Perceptron notPerceptron = new Perceptron(1);
        int[] notInputs = {0, 1};
        int[] notOutputs = {1, 0};

        // Обучение на логической функции "НЕ"
        for (int i = 0; i < notInputs.length; i++) {
            notPerceptron.train(new int[]{notInputs[i]}, notOutputs[i]);
        }

        // Вывод весов и порога для перцептрона "НЕ"
        System.out.println("Perceptron NOT:");
        double[] notWeights = notPerceptron.getWeights();
        for (int i = 0; i < notWeights.length; i++) {
            System.out.printf("Weight %d: %.3f\n", i, notWeights[i]);
        }
        System.out.printf("Threshold: %.3f\n", notPerceptron.threshold);
    }
}