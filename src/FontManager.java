import org.jsfml.graphics.Font;
import java.nio.file.Paths;
import java.io.File;

class FontManager extends ResourceManager<Font> {
    @Override
    protected boolean loadResource(Font resource, String filePath) {
        try {
            // Логируем путь для диагностики
            System.out.println("Attempting to load font from: " + filePath);

            // Проверка, существует ли файл
            File file = new File(filePath);
            if (!file.exists()) {
                System.out.println("File not found: " + filePath);
                return false;  // Возвращаем false, если файл не найден
            }

            // Загружаем шрифт
            resource.loadFromFile(Paths.get(filePath));  // Пытаемся загрузить шрифт
            return true;  // Возвращаем true, если шрифт загружен успешно
        } catch (Exception e) {
            // Логируем ошибку
            System.out.println("Error loading font: " + e.getMessage());
            e.printStackTrace();  // Выводим стек ошибки для более детальной диагностики
            return false;  // Возвращаем false, если произошла ошибка
        }
    }

    @Override
    protected Font createResource() {
        return new Font();  // Создаем новый объект Font из JSFML
    }
}
