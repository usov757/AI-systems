package org.example;

public class Perceptron {
    private double[] weights;
    double threshold;

    public Perceptron(int inputSize) {
        weights = new double[inputSize];
        for (int i = 0; i < weights.length; i++) {
            // инициализация весов
            weights[i] = Math.random() - 0.5;
        }
        // инициализация порога
        threshold = Math.random() - 0.5;
    }

    public int activate(int[] inputs) {
        double sum = 0;
        for (int i = 0; i < weights.length; i++) {
            sum += inputs[i] * weights[i];
        }
        if (sum > threshold) {
            return 1; // активация
        } else {
            return 0; // неактивация
        }
    }

    public void train(int[] inputs, int desired) {
        int guess = activate(inputs);
        double error = desired - guess;
        for (int i = 0; i < weights.length; i++) {
            weights[i] += error * inputs[i]; // коррекция весов
        }
        threshold -= error; // коррекция порога
    }

    public double[] getWeights() {
        return weights;
    }
}