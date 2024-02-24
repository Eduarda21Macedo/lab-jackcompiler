package br.ufma.ecp;

import java.io.FileWriter;
import java.io.IOException;

import br.ufma.ecp.token.Token;
import br.ufma.ecp.token.TokenType; 

import java.nio.file.Files;
import java.nio.file.Paths;

public class App 
{

    public static void main( String[] args )
    {
        StringBuilder outputBuilder = new StringBuilder();

        String fileName = "src/test/resources/ExpressionLessSquare/Main.jack"; // Caminho do arquivo a ser lido
        String input;
        try {
            input = Files.readString(Paths.get(fileName));
            Scanner scan = new Scanner (input.getBytes());
            for (Token tk = scan.nextToken(); tk.type != TokenType.EOF; tk = scan.nextToken()) {
                System.out.println(tk);
                String tokenString = tk.toString();
                outputBuilder.append(tokenString).append("\n");
            }

            String xmlString = outputBuilder.toString();

            try {
                FileWriter writer = new FileWriter("output.xml");
                writer.write(xmlString);
                writer.close();
                System.out.println("output.xml escrito com sucesso.");
            } catch (IOException e) {
                System.out.println("Erro ao escrever o arquivo.");
                e.printStackTrace();
            }
        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo: " + e.getMessage());
        }
}

}
