package biblioteca.app;

import biblioteca.db.DatabaseManager;
import biblioteca.db.PublicacaoDAO;
import biblioteca.modelos.*;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonParseException;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.util.List;

import static spark.Spark.*;

public class ApiServidor {

    private static PublicacaoDAO publicacaoDAO = new PublicacaoDAO();
    private static Gson gson = new GsonBuilder().serializeNulls().create();

    public static void main(String[] args) {
        DatabaseManager.initializeDatabase();

        port(4567);

        options("/*", (request, response) -> {
            String accessControlRequestHeaders = request.headers("Access-Control-Request-Headers");
            if (accessControlRequestHeaders != null) {
                response.header("Access-Control-Allow-Headers", accessControlRequestHeaders);
            }
            String accessControlRequestMethod = request.headers("Access-Control-Request-Method");
            if (accessControlRequestMethod != null) {
                response.header("Access-Control-Allow-Methods", accessControlRequestMethod);
            }
            return "OK";
        });

        before((request, response) -> {
            response.header("Access-Control-Allow-Origin", "*");
            response.header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS");
            response.header("Access-Control-Allow-Headers", "Content-Type, Authorization, X-Requested-With, Content-Length, Accept, Origin");
            response.type("application/json");
        });

        get("/api/publicacoes", (request, response) -> {
            try {
                List<Publicacao> publicacoes = publicacaoDAO.buscarTodos();
                String jsonResponse = gson.toJson(publicacoes); // Converte para JSON
                System.out.println("DEBUG API GET /api/publicacoes - JSON Enviado: " + jsonResponse); // Linha de Debug
                return jsonResponse; // Retorna o JSON
            } catch (Exception e) {
                response.status(500);
                e.printStackTrace();
                return gson.toJson(new ErrorResponse("Erro interno ao buscar publicações: " + e.getMessage()));
            }
        });

        post("/api/publicacoes", (request, response) -> {
            try {
                JsonElement jsonElement = gson.fromJson(request.body(), JsonElement.class);
                if (jsonElement == null || !jsonElement.isJsonObject()) {
                    response.status(400);
                    return gson.toJson(new ErrorResponse("Corpo da requisição inválido ou não é um objeto JSON."));
                }
                JsonObject jsonObject = jsonElement.getAsJsonObject();

                if (!jsonObject.has("tipo") || !jsonObject.get("tipo").isJsonPrimitive()) {
                    response.status(400);
                    return gson.toJson(new ErrorResponse("Campo 'tipo' ausente ou inválido no JSON."));
                }
                String tipoPublicacao = jsonObject.get("tipo").getAsString();

                Publicacao publicacaoRecebida;

                switch (tipoPublicacao.toLowerCase()) {
                    case "livro":
                        publicacaoRecebida = gson.fromJson(request.body(), Livro.class);
                        break;
                    case "revista":
                        publicacaoRecebida = gson.fromJson(request.body(), Revista.class);
                        break;
                    case "ebook":
                        publicacaoRecebida = gson.fromJson(request.body(), Ebook.class);
                        break;
                    default:
                        response.status(400);
                        return gson.toJson(new ErrorResponse("Tipo de publicação desconhecido: " + tipoPublicacao));
                }

                Publicacao publicacaoSalva = publicacaoDAO.salvar(publicacaoRecebida);
                response.status(201);
                return gson.toJson(publicacaoSalva);

            } catch (JsonParseException e) {
                response.status(400);
                return gson.toJson(new ErrorResponse("JSON mal formatado: " + e.getMessage()));
            } catch (IllegalArgumentException e) {
                response.status(400);
                return gson.toJson(new ErrorResponse("Dados inválidos na publicação: " + e.getMessage()));
            } catch (Exception e) {
                response.status(500);
                e.printStackTrace();
                return gson.toJson(new ErrorResponse("Erro interno ao salvar publicação: " + e.getMessage()));
            }
        });

        System.out.println("Servidor API da Biblioteca Digital iniciado em http://localhost:4567");
        System.out.println("Use Ctrl+C para parar o servidor.");
    }

    static class ErrorResponse {
        String message;
        public ErrorResponse(String message) {
            this.message = message;
        }
    }
}