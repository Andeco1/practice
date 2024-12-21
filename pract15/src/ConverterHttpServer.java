import java.io.*;
import java.net.*;
import java.util.*;

public class ConverterHttpServer {
    private static final int PORT = 8080;

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Converter HTTP Server запущен на порту " + PORT);
            while (true) {
                try (Socket clientSocket = serverSocket.accept()) {
                    handleClient(clientSocket);
                }
            }
        } catch (IOException e) {
            System.err.println("Ошибка запуска сервера: " + e.getMessage());
        }
    }

    private static void handleClient(Socket clientSocket) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        PrintWriter out = new PrintWriter(clientSocket.getOutputStream());
        String line = in.readLine();
        if (line == null) return;

        String[] requestParts = line.split(" ");
        if (requestParts.length < 2) {
            sendHttpResponse(out, 400, "Invalid Request");
            return;
        }

        String method = requestParts[0];
        String path = requestParts[1];

        if (method.equals("GET") && path.equals("/")) {
            sendHomePage(out);
        } else if (method.equals("GET") && path.startsWith("/convert")) {
            handleConversionRequest(path, out);
        } else {
            sendHttpResponse(out, 404, "Not Found");
        }

        out.flush();
    }

    private static void sendHomePage(PrintWriter out) {
        out.println("HTTP/1.1 " + 200 + " OK");
        out.println("Content-Type: text/html");
        out.println("Content-Length: " + 10000);
        out.println();
        out.println("<html lang=\"ru\"><head><meta charset=\"UTF-8\"><meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\"></head><body>");
        out.println("<h1>Конвертер единиц измерения</h1>");
        out.println("<form method='GET' action='/convert'>");
        out.println("Значение: <input type='text' name='value' required><br>");
        out.println("Из: <select name='from'>");
        out.println("<option value='meters'>Метры</option>");
        out.println("<option value='kilometers'>Километры</option>");
        out.println("<option value='centimeters'>Сантиметры</option>");
        out.println("<option value='millimeters'>Миллиметры</option>");
        out.println("<option value='grams'>Граммы</option>");
        out.println("<option value='kilograms'>Килограммы</option>");
        out.println("<option value='tonnes'>Тонны</option>");
        out.println("<option value='celsius'>Цельсий</option>");
        out.println("<option value='fahrenheit'>Фаренгейт</option>");
        out.println("</select><br>");
        out.println("В: <select name='to'>");
        out.println("<option value='meters'>Метры</option>");
        out.println("<option value='kilometers'>Километры</option>");
        out.println("<option value='centimeters'>Сантиметры</option>");
        out.println("<option value='millimeters'>Миллиметры</option>");
        out.println("<option value='grams'>Граммы</option>");
        out.println("<option value='kilograms'>Килограммы</option>");
        out.println("<option value='tonnes'>Тонны</option>");
        out.println("<option value='celsius'>Цельсий</option>");
        out.println("<option value='fahrenheit'>Фаренгейт</option>");
        out.println("</select><br>");
        out.println("<button type='submit'>Перевести</button>");
        out.println("</form>");
        out.println("</body></html>");
    }

    private static void handleConversionRequest(String path, PrintWriter out) {
        Map<String, String> queryParams = getQueryParams(path);

        if (!queryParams.containsKey("value") || !queryParams.containsKey("from") || !queryParams.containsKey("to")) {
            sendHttpResponse(out, 400, "Отсутствуют query-параметры");
            return;
        }

        try {
            double value = Double.parseDouble(queryParams.get("value"));
            String fromUnit = queryParams.get("from").toLowerCase();
            String toUnit = queryParams.get("to").toLowerCase();
            double result = convertUnits(value, fromUnit, toUnit);

            String response = String.format("%s %s = %s %s", value, fromUnit, result, toUnit);
            sendHttpResponse(out, 200, response);
        } catch (NumberFormatException e) {
            sendHttpResponse(out, 400, "Недопустимое значение параметра");
        }
    }

    private static Map<String, String> getQueryParams(String path) {
        Map<String, String> queryParams = new HashMap<>();
        String[] parts = path.split("\\?");
        if (parts.length > 1) {
            String[] params = parts[1].split("&");
            for (String param : params) {
                String[] keyValue = param.split("=");
                if (keyValue.length == 2) {
                    queryParams.put(keyValue[0], keyValue[1]);
                }
            }
        }
        return queryParams;
    }

    private static double convertUnits(double value, String from, String to) {
        if (from.equals("meters") && to.equals("kilometers")) {
            return value / 1000f;
        } else if (from.equals("kilometers") && to.equals("meters")) {
            return value * 1000;
        } else if (from.equals("centimeters") && to.equals("meters")) {
            return value / 100f;
        } else if (from.equals("meters") && to.equals("centimeters")) {
            return value * 100;
        } else if (from.equals("centimeters") && to.equals("kilometers")) {
            return value / 100000f;
        } else if (from.equals("kilometers") && to.equals("centimeters")) {
            return value * 100000;
        } else if (from.equals("millimeters") && to.equals("meters")) {
            return value / 1000f;
        } else if (from.equals("meters") && to.equals("millimeters")) {
            return value * 1000;
        } else if (from.equals("grams") && to.equals("kilograms")) {
            return value / 1000f;
        } else if (from.equals("kilograms") && to.equals("grams")) {
            return value * 1000;
        } else if (from.equals("grams") && to.equals("tonnes")) {
            return value / 1000000f;
        } else if (from.equals("tonnes") && to.equals("grams")) {
            return value * 1000000;
        } else if (from.equals("kilograms") && to.equals("tonnes")) {
            return value / 1000f;
        } else if (from.equals("tonnes") && to.equals("kilograms")) {
            return value * 1000;
        }else if (from.equals("celsius") && to.equals("fahrenheit")) {
            return value * 9 / 5f + 32;
        } else if (from.equals("fahrenheit") && to.equals("celsius")) {
            return (value - 32) * 5 / 9f;
        }

        throw new IllegalArgumentException("Невозможно перевести значение из " + from + " в " + to);
    }

    private static void sendHttpResponse(PrintWriter out, int statusCode, String body) {
        out.println("HTTP/1.1 " + statusCode + " OK");
        out.println("Content-Type: text/html");
        out.println("Content-Length: " + body.length());
        out.println();
        out.println(body);
    }
}
