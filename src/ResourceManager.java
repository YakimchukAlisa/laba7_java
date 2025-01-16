import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

abstract class ResourceManager<ResourceType> {
    private final Map<String, ResourceType> resources = new HashMap<>();

    public Optional<ResourceType> load(String key, String filePath) {
        if (resources.containsKey(key)) {
            return Optional.of(resources.get(key));
        }

        ResourceType resource = createResource();
        if (!loadResource(resource, filePath)) {
            return Optional.empty(); // Не удалось загрузить ресурс
        }
        resources.put(key, resource);
        return Optional.of(resource);
    }

    public Optional<ResourceType> get(String key) {
        return Optional.ofNullable(resources.get(key));
    }

    public void unload(String key) {
        resources.remove(key);
    }

    public void unloadAll() {
        resources.clear();
    }

    protected abstract boolean loadResource(ResourceType resource, String filePath);

    protected abstract ResourceType createResource();
}