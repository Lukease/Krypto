package pl.lukease.crypto.exception;

public class CryptoNotFoundException extends RuntimeException{
 public CryptoNotFoundException() {
     super("Kryptowaluta nie zosatła znaleziona");
 }
}
