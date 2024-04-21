package org.example;

import java.util.Arrays;
import java.util.Random;

public class Perceptron {
    private double[][] weights;  // веса
    private double[] biases;      // смещения

    public Perceptron(int inputSize, int outputSize) {
        // Инициализация весов и смещений случайными значениями
        weights = new double[outputSize][inputSize];
        biases = new double[outputSize];
        Random random = new Random();
        for (int i = 0; i < outputSize; i++) {
            for (int j = 0; j < inputSize; j++) {
                weights[i][j] = random.nextDouble() - 0.5;
            }
            biases[i] = random.nextDouble() - 0.5;
        }
    }

    public int activate(double[] inputs) {
        // Вычисление активации нейронов
        double[] activations = new double[biases.length];
        for (int i = 0; i < biases.length; i++) {
            double activation = 0;
            for (int j = 0; j < inputs.length; j++) {
                activation += weights[i][j] * inputs[j];
            }
            activation += biases[i];
            activations[i] = activation;
        }

        // Выбор нейрона с наибольшей активацией (Argmax)
        int maxIndex = 0;
        double maxActivation = activations[0];
        for (int i = 1; i < activations.length; i++) {
            if (activations[i] > maxActivation) {
                maxActivation = activations[i];
                maxIndex = i;
            }
        }
        return maxIndex;
    }

    public void train(double[] inputs, int label, double learningRate, int iteration) {
        // Обучение перцептрона с помощью метода обратного распространения ошибки
        int guess = activate(inputs);
        double[] output = new double[biases.length];
        Arrays.fill(output, 0);
        output[label] = 1;

        // Вычисление ошибки
        double[] errors = new double[biases.length];
        for (int i = 0; i < errors.length; i++) {
            errors[i] = output[i] - (i == label ? 1 : 0);
        }

        // Коррекция весов и смещений
        for (int i = 0; i < biases.length; i++) {
            for (int j = 0; j < inputs.length; j++) {
                weights[i][j] += learningRate * errors[i] * inputs[j];
            }
            biases[i] += learningRate * errors[i];
        }

        // Вывод информации
        System.out.println("Iteration: " + iteration);
        System.out.println("Inputs: " + Arrays.toString(inputs));
        System.out.println("Label: " + label);
        System.out.println("Prediction: " + guess);
        // Печать новых значений весов и смещений
        System.out.println("Updated Weights: ");
        for (double[] weightRow : weights) {
            System.out.println(Arrays.toString(weightRow));
        }
        System.out.println("Updated Biases: " + Arrays.toString(biases));
        System.out.println("----------------------------------");
    }
}