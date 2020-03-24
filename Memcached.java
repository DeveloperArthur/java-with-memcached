package br.com.bourbon.beback.infra.memcached;

import net.spy.memcached.MemcachedClient;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.Scanner;

public class Memcached {
    public static void main(String[] args) {
        System.out.println("Digite seu nome: ");
        String nome = new Scanner(System.in).nextLine();

        try {
            MemcachedClient memcached = new MemcachedClient(new InetSocketAddress("127.0.0.1", 11211));
            System.out.println("Conectado com servidor");
            System.out.println("guardando nome no cache: " + memcached.set("meuNome", 900, nome).isDone());
            System.out.println("pegando nome no cache: " + memcached.get("meuNome"));
        } catch (IOException e) {
            System.out.println("Erro: " + e.getStackTrace());
        }
    }
}
