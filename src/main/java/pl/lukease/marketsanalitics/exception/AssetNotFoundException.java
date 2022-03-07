package pl.lukease.marketsanalitics.exception;

public class AssetNotFoundException extends RuntimeException{
 public AssetNotFoundException() {
     super("Kryptowaluta nie zosatła znaleziona");
 }
}
