import biblioteca.modelos.Livro;
import biblioteca.modelos.Publicacao;
import biblioteca.modelos.Revista;
import java.util.ArrayList;
import java.util.List;

public class Principal {
    public static void main(String[] args) throws Exception {
        /*
         * ============================
         * CRIAÇÃO DE OBJETO: LIVRO
         * ============================
         */
        Livro meuLivro = new Livro();
        meuLivro.setTitulo("Harry Potter e a Pedra Filosofal");
        meuLivro.setAutor("J. K. Rowlling");
        meuLivro.setEditora("Rocco");
        meuLivro.setGenero("Fantasia");
        // meuLivro.setTipo("Livro"); // Podemos setar, mas não é obrigatório
        meuLivro.setNumeroDePaginas(208);
        meuLivro.setNumeroDeCapitulos(17);
        meuLivro.setIsbn("9780545069670");
        meuLivro.setVolume(1);

        // Avaliando usando sobrecarga (overload):
        meuLivro.avalia(9); // chamará avalia(int nota)
        meuLivro.avalia(10.0); // chamará avalia(double nota)
        meuLivro.avalia(8.5); // idem avalia(double nota)

        double[] notasLivro = { 9.2, 8.8, 10 };
        meuLivro.avalia(notasLivro); // chamará avalia(double[])

        // Exibe a ficha literária (override) e a média de avaliações
        meuLivro.exibeFichaLiteraria();
        System.out.println("Avaliação: " + meuLivro.retornaMedia());

        /*
         * ==============================
         * CRIAÇÃO DE OBJETO: REVISTA
         * ==============================
         */
        Revista minhaRevista = new Revista();
        minhaRevista.setTitulo("Superinteressante");
        minhaRevista.setAutor("Alexandre Versignassi");
        minhaRevista.setEditora("Abril");
        // minhaRevista.setTipo("Revista");
        minhaRevista.setNumeroDePaginas(70);
        minhaRevista.setEdicao("473 - março/2025");
        minhaRevista.setAssunto("Cultura e Ciências");
        minhaRevista.setIssn("0104-178-9");
        minhaRevista.setNumeroDeArtigos(25);

        // Avaliando usando a sobrecarga (overload):
        minhaRevista.avalia(9.5); // avalia(double)
        minhaRevista.avalia(8); // avalia(int)
        minhaRevista.avalia(7.7); // avalia(double)

        minhaRevista.exibeFichaLiteraria();
        System.out.println("Avaliação: " + minhaRevista.retornaMedia());

        /*
         * =====================
         * POLIMORFISMO
         * =====================
         * Demonstrando que podemos usar uma lista de "Publicacao"
         * e colocar objetos "Livro" e "Revista" juntos.
         */
        System.out.println("\n=== DEMONSTRANDO POLIMORFISMO ===");

        List<Publicacao> listaPublicacoes = new ArrayList<>();
        listaPublicacoes.add(meuLivro);      // Um Livro, mas a referência é do tipo Publicacao
        listaPublicacoes.add(minhaRevista);  // Uma Revista, mas a referência é do tipo Publicacao

        // Percorremos a lista e chamamos "exibeFichaLiteraria()"
        // Observe que cada objeto "responde" de forma diferente
        for (Publicacao pub : listaPublicacoes) {
            // Nesse momento, acontece o polimorfismo de sobreposição (runtime).
            pub.exibeFichaLiteraria();

            // Exibe média de avaliações
            System.out.println("Média de Avaliações: " + pub.retornaMedia());
            System.out.println("-----------------------------------------");
        }
    }
}