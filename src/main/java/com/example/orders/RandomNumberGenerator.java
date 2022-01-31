package com.example.orders;

import java.util.Random;

public class RandomNumberGenerator {
    // singleton design pattern
    private static  RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
    private RandomNumberGenerator(){}
    public static RandomNumberGenerator GetInstance(){
        return randomNumberGenerator;
    }
    public int getRandomInteger(int maxRange){
        Random random = new Random();
        int integer = random.nextInt( maxRange);
        return integer;
    }
}
