package net.volgatech.javacore2017;

import java.io.*;
import java.util.regex.*;

public class GetNetAddress {
    public static String toBinary(String value) {
        String binaryString = Integer.toBinaryString(Integer.parseInt(value));
        String minBinaryString = "00000000";
        return (binaryString.length() >= minBinaryString.length()) ? binaryString
            : new String(minBinaryString.toCharArray(), 0, minBinaryString.length() - binaryString.length()) + binaryString;
    }

    public static boolean isValid(String[] arg, boolean isMask) {
        if(arg.length != 4) {
            return false;
        }
        boolean foundZero = false;
        for (int i = 0; i < arg.length; ++i) {
            String binaryString = toBinary(arg[i]);
            if(!binaryString.matches("[0-1]{1,8}")) {
                return false;
            }
            if (isMask){
                int zeroPos = binaryString.indexOf('0');
                int onePos = binaryString.indexOf('1');
                if(!foundZero) {
                    if(zeroPos != -1) {
                        foundZero = true;
                        if(onePos > zeroPos) {
                            return false;
                        }
                    }
                }
                else {
                    if(onePos != -1) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static String getNetAddress(String[] ipAddress, String[] subnetMask) {
        String netAddress = "";
        if (!isValid(ipAddress, false)) {
              throw new Error("Invalid IP address");
        }
        if (!isValid(subnetMask, true)) {
            throw new Error("Invalid subnet mask");
        }
        for (int i = 0; i < ipAddress.length; ++i) {
            netAddress += (((i == 0) ? "" : ".") + Integer.toString(Integer.parseInt(ipAddress[i]) & Integer.parseInt(subnetMask[i])));
        }
        return netAddress;
    }

    public static void main(String[] args) {
        try {
            if (args.length != 2) {
                throw new Error("Invalid argument count");
            }
            System.out.println(getNetAddress(args[0].split("\\."), args[1].split("\\.")));
        }
        catch (Throwable err) {
            System.out.println(err);
            System.out.println("Use: GetNetAddress <IP address> <subnet mask>");
            System.out.println("Example: GetNetAddress 192.168.0.0 255.255.254.0");
        }
    }
}