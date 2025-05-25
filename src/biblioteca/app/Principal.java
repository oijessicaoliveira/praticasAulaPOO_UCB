package biblioteca.app;

import biblioteca.modelos.*;
import biblioteca.interfaces.Digitalizavel;
import java.util.*;

public class Principal {
    public static void main(String[] args) throws Exception {
        Livro livro = new Livro("Harry Potter e a Pedra Filosofal", "J. K. Rowling", "Rocco", 208,
                "Fantasia", 1, "9780545069670", 17);
        livro.avalia(9);
        livro.avalia(8.5);

        Revista revista = new Revista("Superinteressante", "Alexandre Versignassi", "Abril", 70,
                "Ciência", "Março/2025", "0104-178-9", 25);
        revista.avalia(9);

        Ebook ebook = new Ebook("Clean Code", "Robert C. Martin", "Prentice Hall", 464,
                45, "EPUB");
        ebook.avalia(10);
        ebook.baixar();

        List<Publicacao> publicacoes = Arrays.asList(livro, revista, ebook);
        for (Publicacao pub : publicacoes) {
            pub.exibeFichaCompleta();
            System.out.println("Média de avaliações: " + pub.retornaMedia());
            if (pub instanceof Digitalizavel d) {
                d.geraVersaoDigital();
            }
            System.out.println("------------------------------");
        }
    }
}