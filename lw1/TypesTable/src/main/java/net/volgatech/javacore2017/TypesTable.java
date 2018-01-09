package net.volgatech.javacore2017;

public class TypesTable {
    public static void main(String[] args) {
        System.out.printf("%-10s%20s%23s%7s%n", "Type", "Min", "Max", "Size");
        System.out.printf("%-10s%20d%23d%7d%n", "Long", Long.MIN_VALUE, Long.MAX_VALUE, Long.SIZE/8);
        System.out.printf("%-10s%20d%23d%7d%n", "Integer", Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.SIZE/8);
        System.out.printf("%-10s%20d%23d%7d%n", "Short", Short.MIN_VALUE, Short.MAX_VALUE, Short.SIZE/8);
        System.out.printf("%-10s%20d%23d%7d%n", "Byte", Byte.MIN_VALUE, Byte.MAX_VALUE, Byte.SIZE/8);
        System.out.printf("%-10s%20e%23e%7d%n", "Double", Double.MIN_VALUE, Double.MAX_VALUE, Double.SIZE/8);
        System.out.printf("%-10s%20e%23e%7d%n", "Float", Float.MIN_VALUE, Float.MAX_VALUE, Float.SIZE/8);
        System.out.printf("%-10s%20d%23d%7d%n", "Character", (int)Character.MIN_VALUE, (int)Character.MAX_VALUE, Character.SIZE/8);
    }
}