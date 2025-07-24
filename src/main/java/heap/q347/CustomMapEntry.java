package heap.q347;

import java.util.Map;
import java.util.Objects;

public class CustomMapEntry<K , V extends Comparable<V>> implements Map.Entry<K, V>, Comparable<CustomMapEntry<K, V>> {
    private K key;
    private V value;

    public CustomMapEntry(K key, V value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public K getKey() {
        return key;
    }

    @Override
    public V getValue() {
        return value;
    }

    @Override
    public V setValue(V value) {
        this.value = value;
        return value;
    }

    @Override
    public int compareTo(CustomMapEntry<K, V> other) {
        return this.value.compareTo(other.value);  // 基于 key 进行排序
    }

    // 实现 equals 方法
    @Override
    public boolean equals(Object o) {
        if (this == o) return true; // 如果两个对象相同引用，则相等
        if (o == null || getClass() != o.getClass()) return false; // 类型不匹配
        CustomMapEntry<?, ?> that = (CustomMapEntry<?, ?>) o;
        return Objects.equals(key, that.key) && Objects.equals(value, that.value); // 比较 key 和 value
    }

    // 实现 hashCode 方法
    @Override
    public int hashCode() {
        return Objects.hash(key, value); // 根据 key 和 value 生成 hashCode
    }
}

