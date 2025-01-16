public class GameObject<T> {
    private String name;
    private T value;

    // Конструктор
    public GameObject(String name, T value) {
        this.name = name;
        this.value = value;
    }

    // Геттер для имени
    public String getName() {
        return name;
    }

    // Сеттер для имени
    public void setName(String name) {
        this.name = name;
    }

    // Геттер для значения
    public T getValue() {
        return value;
    }

    // Сеттер для значения
    public void setValue(T value) {
        this.value = value;
    }

    // Переопределение toString
    @Override
    public String toString() {
        return "GameObject{name='" + name + "', value=" + value + '}';
    }
}
