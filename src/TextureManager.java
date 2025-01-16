import org.jsfml.graphics.Texture;
import java.io.File;
import java.nio.file.Paths;

class TextureManager extends ResourceManager<Texture> {
    @Override
    protected boolean loadResource(Texture resource, String filePath) {
        try {
            // Пытаемся загрузить текстуру
            resource.loadFromFile(new File(filePath).toPath());
            return true;  // Возвращаем true, если текстура загружена успешно
        } catch (Exception e) {
            // Если произошла ошибка при загрузке текстуры
            System.out.println("Error loading texture: " + e.getMessage());
            return false;  // Возвращаем false, если произошла ошибка
        }
    }

    @Override
    protected Texture createResource() {
        return new Texture();  // Создаем новый объект Texture из JSFML
    }
}
